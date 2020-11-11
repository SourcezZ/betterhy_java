package com.betterhy.controller;

import com.betterhy.db.dto.OaUser;
import com.betterhy.result.Result;
import com.betterhy.result.ResultFactory;
import com.betterhy.utils.OaUtils;
import com.betterhy.utils.UserUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单控制
 *
 * @author Source
 * @date 2020-07-07 12:16
 **/
@RestController
public class MenuController {

    @PostMapping("/api/menuQry")
    public Result menu() {
        OaUser user = UserUtils.getUser();
        List<String> menus = OaUtils.getMenusByRoleId(user.getRoleId());
        return ResultFactory.buildSuccessResult(menus);
    }


}
