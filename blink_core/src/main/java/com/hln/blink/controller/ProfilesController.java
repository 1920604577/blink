package com.hln.blink.controller;

import com.alibaba.fastjson2.JSONArray;
import com.hln.blink.pojo.bo.ProfilesAddBo;
import com.hln.blink.pojo.bo.ProfilesQueryBo;
import com.hln.blink.pojo.bo.ProfilesUpdateBo;
import com.hln.blink.pojo.bo.DeleteProfilesByIdBo;
import com.hln.blink.service.ProfilesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Api(value = "个人信息描述板块接口",tags = {"个人信息描述板块接口"})
@RestController
@RequestMapping("/profiles")
public class ProfilesController {

    @Autowired
    private ProfilesService profilesService;

    /**
     * @author hln 2024-5-7
     *  添加Profiles
     * @param profilesAddBo
     * @return
     */
    @PostMapping("/add")
    @ApiOperation("添加个人信息")
    public String addProfiles(@RequestBody ProfilesAddBo profilesAddBo){
        return JSONArray.toJSONString(profilesService.addProfiles(profilesAddBo));
    }

    /**
     * @author hln 2024-5-7
     *  根据userId查询Profiles
     * @param profilesQueryBo
     * @return
     */
    @PostMapping("/queryProfilesById")
    @ApiOperation("根据userId查询Profiles")
    public String queryProfilesById(@RequestBody ProfilesQueryBo profilesQueryBo){
        return JSONArray.toJSONString(profilesService.queryUserById(profilesQueryBo));
    }

    /**
     * @author hln 2024-5-7
     *  根据userId修改用户信息
     * @param ProfilesUpdateBo
     * @return
     */
    @PostMapping("/updateProfilesById")
    @ApiOperation("根据userId修改用户信息")
    public String updateProfilesById(@RequestBody ProfilesUpdateBo ProfilesUpdateBo){
        return JSONArray.toJSONString(profilesService.updateProfilesById(ProfilesUpdateBo));
    }

    /**
     * @author hln 2024-5-7
     *  根据userId删除用户信息(逻辑删除)
     * @param deleteProfilesByIdBo
     * @return
     */
    @PostMapping("/deleteProfilesById")
    @ApiOperation("根据userId删除用户信息(逻辑删除)")
    public String deleteProfilesById(@RequestBody DeleteProfilesByIdBo deleteProfilesByIdBo){
        return JSONArray.toJSONString(profilesService.deleteProfilesById(deleteProfilesByIdBo));
    }

    /**
     * @author hln 2024-5-7
     *  查询所有
     * @param token
     * @return
     */
    @PostMapping("/findAll")
    @ApiOperation("查询所有")
    public String findAll(@RequestParam String token){
        return JSONArray.toJSONString(profilesService.findAll());
    }


}
