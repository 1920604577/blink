package com.hln.blink.controller;

import com.alibaba.fastjson2.JSONArray;
import com.hln.blink.pojo.bo.*;
import com.hln.blink.service.DatingInvitationsService;
import com.hln.blink.service.DatingInvitationsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Api(value = "发起板块接口",tags = {"发起板块接口"})
@RestController
@RequestMapping("/datingInvitations")
public class DatingInvitationsController {

    @Autowired
    private DatingInvitationsService datingInvitationsService;

    /**
     * @author hln 2024-4-30
     *  添加DatingInvitations
     * @param datingInvitationsAddBo
     * @return
     */
    @PostMapping("/addDatingInvitations")
    @ApiOperation("添加DatingInvitations")
    public String addDatingInvitations(@RequestBody DatingInvitationsAddBo datingInvitationsAddBo){
        return JSONArray.toJSONString(datingInvitationsService.addDatingInvitations(datingInvitationsAddBo));
    }

    /**
     * @author hln 2024-4-30
     *  根据id查询用户
     * @param datingInvitationsQueryBo
     * @return
     */
    @PostMapping("/queryDatingInvitationsById")
    @ApiOperation("根据id查询DatingInvitations")
    public String queryDatingInvitationsById(@RequestBody DatingInvitationsQueryBo datingInvitationsQueryBo){
        return JSONArray.toJSONString(datingInvitationsService.queryDatingInvitationsById(datingInvitationsQueryBo));
    }

    /**
     * @author hln 2024-4-30
     *  根据id修改用户
     * @param datingInvitationsUpdateBo
     * @return
     */
    @PostMapping("/updateDatingInvitationsById")
    @ApiOperation("根据id修改用户")
    public String updateDatingInvitationsById(@RequestBody DatingInvitationsUpdateBo datingInvitationsUpdateBo){
        return JSONArray.toJSONString(datingInvitationsService.updateDatingInvitationsById(datingInvitationsUpdateBo));
    }

    /**
     * @author hln 2024-4-30
     *  根据id删除用户(逻辑删除)
     * @param deleteDatingInvitationsByIdBo
     * @return
     */
    @PostMapping("/deleteDatingInvitationsById")
    @ApiOperation("根据id删除用户(逻辑删除)")
    public String deleteDatingInvitationsById(@RequestBody DeleteDatingInvitationsByIdBo deleteDatingInvitationsByIdBo){
        return JSONArray.toJSONString(datingInvitationsService.deleteDatingInvitationsById(deleteDatingInvitationsByIdBo));
    }

    /**
     * @author hln 2024-5-6
     *  查询所有
     * @param token
     * @return
     */
    @PostMapping("/findAll")
    @ApiOperation("查询所有")
    public String findAll(@RequestParam String token){
        return JSONArray.toJSONString(datingInvitationsService.findAll());
    }

    /**
     * @author hln 2024-5-12
     *  yes
     * @return
     */
    @PostMapping("/handleYes")
    @ApiOperation("yes")
    public String handleYes(@RequestBody HandleYesBo handleYesBo){
        return JSONArray.toJSONString(datingInvitationsService.handleYes(handleYesBo));
    }

    /**
     * @author hln 2024-5-12
     *  yes
     * @return
     */
    @PostMapping("/handleNo")
    @ApiOperation("no")
    public String handleNo(@RequestBody HandleNoBo handleNoBo){
        return JSONArray.toJSONString(datingInvitationsService.handleNo(handleNoBo));
    }

    /**
     * @author hln 2024-5-6
     *  查询该用户所有 Status != 0
     * @return
     */
    @PostMapping("/queryAllByUserId")
    @ApiOperation("查询所有")
    public String queryAllByUserId(@RequestBody QueryAllByUserIdBo queryAllByUserIdBo){
        return JSONArray.toJSONString(datingInvitationsService.queryAllByUserId(queryAllByUserIdBo));
    }

}
