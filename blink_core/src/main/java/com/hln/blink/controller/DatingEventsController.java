package com.hln.blink.controller;

import com.alibaba.fastjson2.JSONArray;
import com.hln.blink.pojo.bo.*;
import com.hln.blink.service.DatingEventsService;
import com.hln.blink.service.DatingEventsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Api(value = "相亲活动内容板块接口",tags = {"相亲活动内容板块接口"})
@RestController
@RequestMapping("/datingEvents")
public class DatingEventsController {

    @Autowired
    private DatingEventsService datingEventsService;

    /**
     * @author hln 2024-5-12
     *  添加DatingEvents
     * @param datingEventsAddBo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("添加活动信息")
    public String addDatingEvents(@RequestBody DatingEventsAddBo datingEventsAddBo){
        return JSONArray.toJSONString(datingEventsService.addDatingEvents(datingEventsAddBo));
    }

    /**
     * @author hln 2024-5-12
     *  根据userId查询DatingEvents
     * @param datingEventsQueryBo
     * @return
     */
    @PostMapping("/queryDatingEventsById")
    @ApiOperation("根据userId查询DatingEvents")
    public String queryDatingEventsById(@RequestBody DatingEventsQueryBo datingEventsQueryBo){
        return JSONArray.toJSONString(datingEventsService.queryDatingEventsById(datingEventsQueryBo));
    }

    /**
     * @author hln 2024-5-12
     *  根据userId修改用户信息
     * @param datingEventsUpdateBo
     * @return
     */
    @PostMapping("/updateDatingEventsById")
    @ApiOperation("根据userId修改用户信息")
    public String updateDatingEventsById(@RequestBody DatingEventsUpdateBo datingEventsUpdateBo){
        return JSONArray.toJSONString(datingEventsService.updateDatingEventsById(datingEventsUpdateBo));
    }

    /**
     * @author hln 2024-5-12
     *  根据userId删除用户信息(逻辑删除)
     * @param deleteDatingEventsByIdBo
     * @return
     */
    @PostMapping("/deleteDatingEventsById")
    @ApiOperation("根据userId删除用户信息(逻辑删除)")
    public String deleteDatingEventsById(@RequestBody DeleteDatingEventsByIdBo deleteDatingEventsByIdBo){
        return JSONArray.toJSONString(datingEventsService.deleteDatingEventsById(deleteDatingEventsByIdBo));
    }

    /**
     * @author hln 2024-5-12
     *  查询所有
     * @param token
     * @return
     */
    @PostMapping("/findAll")
    @ApiOperation("查询所有")
    public String findAll(@RequestParam String token){
        return JSONArray.toJSONString(datingEventsService.findAll());
    }

    /**
     * @author hln 2024-5-12
     *  查询所有
     * @param queryAllDataByUserIdBo
     * @return
     */
    @PostMapping("/queryAllByUserId")
    @ApiOperation("查询所有")
    public String queryAllByUserId(@RequestBody QueryAllDataByUserIdBo queryAllDataByUserIdBo){
        return JSONArray.toJSONString(datingEventsService.queryAllByUserId(queryAllDataByUserIdBo));
    }

}
