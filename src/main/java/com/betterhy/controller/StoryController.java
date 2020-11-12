package com.betterhy.controller;

import com.betterhy.common.db.DataAccessManager;
import com.betterhy.common.db.dao.generate.MyappCommentDao;
import com.betterhy.common.db.dao.generate.MyappStoryDao;
import com.betterhy.common.db.dto.MyappComment;
import com.betterhy.common.db.dto.MyappCommentExample;
import com.betterhy.common.db.dto.MyappStory;
import com.betterhy.common.db.dto.MyappStoryExample;
import com.betterhy.common.result.Result;
import com.betterhy.common.result.ResultFactory;
import com.betterhy.common.utils.SqlUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 话题控制类
 *
 * @author Source
 * @date 2020-08-12 17:22
 **/
@RestController
public class StoryController {

    /**
     * 请假申请
     * @param reqMap 请求map
     * @return Result
     */
    @PostMapping("/api/storyQry")
    public Result storyQry(@RequestBody Map<String, Object> reqMap) {
        MyappStoryExample example = new MyappStoryExample();
        example.setOrderByClause("ADD_TIME DESC");
        SqlUtils.startPage(1, 10);
        List<MyappStory> storyList = DataAccessManager.getMapper(MyappStoryDao.class).selectByExample(example);
        Map<String, Object> map = new HashMap<String, Object>((int) ((1/0.75) + 1)){{put("list", storyList);}};
        return ResultFactory.buildSuccessResult(map);
    }

    @PostMapping("/api/commentQry")
    public Result commentQry(@RequestBody Map<String, Object> reqMap) {
        List<MyappComment> commentList = DataAccessManager.getMapper(MyappCommentDao.class).selectByExample(new MyappCommentExample());
        Map<String, Object> map = new HashMap<String, Object>((int) ((1/0.75) + 1)){{put("list", commentList);}};
        return ResultFactory.buildSuccessResult(map);
    }

    @PostMapping("/api/addStory")
    public Result addStory(@RequestBody MyappStory story) {
        DataAccessManager.getMapper(MyappStoryDao.class).insertSelective(story);
        return ResultFactory.buildSuccessResult();
    }

    @PostMapping("/api/addComment")
    public Result addStory(@RequestBody MyappComment comment) {
        DataAccessManager.getMapper(MyappCommentDao.class).insertSelective(comment);
        return ResultFactory.buildSuccessResult();
    }

}
