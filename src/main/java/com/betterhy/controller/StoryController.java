package com.betterhy.controller;

import com.betterhy.db.DataAccessManager;
import com.betterhy.db.dao.extend.MyappStoryMapperExtend;
import com.betterhy.db.dao.generate.MyappCommentMapper;
import com.betterhy.db.dao.generate.MyappStoryMapper;
import com.betterhy.db.dto.MyappComment;
import com.betterhy.db.dto.MyappCommentExample;
import com.betterhy.db.dto.MyappStory;
import com.betterhy.db.dto.MyappStoryExample;
import com.betterhy.result.Result;
import com.betterhy.result.ResultFactory;
import com.google.common.collect.Maps;
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
        List<MyappStory> storyList = DataAccessManager.getMapper(MyappStoryMapper.class).selectByExample(example);
        Map<String, Object> map = new HashMap<String, Object>((int) ((1/0.75) + 1)){{put("list", storyList);}};
        return ResultFactory.buildSuccessResult(map);
    }

    @PostMapping("/api/commentQry")
    public Result commentQry(@RequestBody Map<String, Object> reqMap) {
        List<MyappComment> commentList = DataAccessManager.getMapper(MyappCommentMapper.class).selectByExample(new MyappCommentExample());
        Map<String, Object> map = new HashMap<String, Object>((int) ((1/0.75) + 1)){{put("list", commentList);}};
        return ResultFactory.buildSuccessResult(map);
    }

    @PostMapping("/api/addStory")
    public Result addStory(@RequestBody MyappStory story) {
        DataAccessManager.getMapper(MyappStoryMapper.class).insertSelective(story);
        return ResultFactory.buildSuccessResult();
    }

    @PostMapping("/api/addComment")
    public Result addStory(@RequestBody MyappComment comment) {
        DataAccessManager.getMapper(MyappCommentMapper.class).insertSelective(comment);
        return ResultFactory.buildSuccessResult();
    }

}
