package com.betterhy.controller;

import com.betterhy.common.result.Result;
import com.betterhy.common.result.ResultFactory;
import com.betterhy.common.utils.Live2dUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 话题控制类
 *
 * @author Source
 * @date 2020-08-12 17:22
 **/
@RestController
public class Live2dController {

    @GetMapping("/api/utilView_getLive2d")
    public Result getLive2D(@RequestParam Map<String, Object> reqMap) {
        return ResultFactory.buildSuccessResult(Live2dUtils.getLive2D(reqMap));
    }

    @GetMapping("/api/utilView_getRandJson")
    public Result getRandJson(@RequestParam Map<String, Object> reqMap) {
        return ResultFactory.buildSuccessResult(Live2dUtils.getRandJson(reqMap));
    }

}
