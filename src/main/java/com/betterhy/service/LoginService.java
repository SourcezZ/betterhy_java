package com.betterhy.service;

import com.betterhy.common.db.DataAccessManager;
import com.betterhy.common.db.dao.generate.OaUserMapper;
import com.betterhy.common.db.dto.OaUser;
import com.betterhy.common.db.dto.OaUserExample;
import com.betterhy.common.result.Result;
import com.betterhy.common.result.ResultFactory;
import com.betterhy.common.utils.BeanUtils;
import com.google.common.collect.Maps;
import com.mysql.jdbc.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 登陆服务
 *
 * @author Source
 * @date 2020-09-08 11:05
 **/
@Transactional(rollbackFor = Exception.class)
@Service
public class LoginService {

    /**
     * 登陆
     * @param reqMap 请求map
     * @return result
     */
    public Result login(Map<String, Object> reqMap){
        Map<String, Object> result = Maps.newHashMapWithExpectedSize(2);
        OaUser user = BeanUtils.map2Bean(reqMap, OaUser.class);

        String code = (String) reqMap.get("code");
        if (StringUtils.isNullOrEmpty(code) && StringUtils.isNullOrEmpty(user.getUsername())){
            return ResultFactory.buildFailResult("code或username不能为空");
        }

        if (!StringUtils.isNullOrEmpty(user.getUsername())){
            // 首次登陆，走输入用户名的流程
            user = updateUserName(user);
            if (user.getStatus() == 0){
                return ResultFactory.buildFailResult("抱歉，该小程序只对公司内部员工开放");
            }
        }else {
            String openId = "";
            if (StringUtils.isNullOrEmpty(openId)){
                return ResultFactory.buildFailResult("获取openId失败");
            }
            OaUserExample example = new OaUserExample();
            example.createCriteria().andOpenIdEqualTo(openId).andStatusEqualTo(1);
            List<OaUser> list = DataAccessManager.getMapper(OaUserMapper.class).selectByExample(example);

            //首次登陆 插入数据库
            if (list.isEmpty()){
                String password = "123";
                // 得到 hash 后的密码
                String encodedPassword = new SimpleHash("md5", password).toString();
                user.setPassword(encodedPassword);
                user.setOpenId(openId);
                user.setRoleId("applyUser");
                user.setRankId(2);
                DataAccessManager.getMapper(OaUserMapper.class).insertSelective(user);

                result.put("status", "F");
                result.put("user", user);
                return ResultFactory.buildSuccessResult(result);
            }

            user = list.get(0);
            if (StringUtils.isNullOrEmpty(user.getUsername())){
                result.put("status", "F");
                result.put("user", user);
                return ResultFactory.buildSuccessResult(result);
            }
        }

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(String.valueOf(user.getUserId()), "123");
        try {
            subject.login(usernamePasswordToken);
            result.put("user", user);
            result.put("sessionId", subject.getSession().getId());
            subject.getSession().setTimeout(432000000L);
            return ResultFactory.buildSuccessResult(result);
        } catch (IncorrectCredentialsException e) {
            return ResultFactory.buildFailResult("密码错误");
        } catch (UnknownAccountException e) {
            return ResultFactory.buildFailResult("账号不存在");
        }
    }

    /**
     * 注册
     * @param user user对象
     * @return result
     */
    public Result register(OaUser user){
        String password = user.getPassword();
        // 得到 hash 后的密码
        String encodedPassword = new SimpleHash("md5", password).toString();
        user.setPassword(encodedPassword);
        user.setRoleId("applyUser");
        user.setRankId(2);
        int i = DataAccessManager.getMapper(OaUserMapper.class).insertSelective(user);
        if (i == 1){
            return ResultFactory.buildSuccessResult(user);
        }else {
            return ResultFactory.buildFailResult("create fail");
        }
    }

    private OaUser updateUserName(OaUser user){
        DataAccessManager.getMapper(OaUserMapper.class).updateByPrimaryKeySelective(user);
        user = DataAccessManager.getMapper(OaUserMapper.class).selectByPrimaryKey(user.getUserId());
        return user;
    }
}
