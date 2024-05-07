package com.hln.blink.controller;

import com.alibaba.fastjson2.JSONArray;
import com.hln.blink.pojo.bo.*;
import com.hln.blink.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Api(value = "管理员板块接口",tags = {"管理员板块接口"})
@RestController
@RequestMapping("/admin")
public class AdminController{

    @Autowired
    private AdminService adminService;

    /**
     * @author hln 2024-4-30
     *  添加admin
     * @param adminAddBo
     * @return
     */
    @PostMapping("/addAdmin")
    @ApiOperation("添加admin")
    public String addAdmin(@RequestBody AdminAddBo adminAddBo){
        return JSONArray.toJSONString(adminService.addAdmin(adminAddBo));
    }

    /**
     * @author hln 2024-4-30
     *  根据id查询用户
     * @param adminQueryBo
     * @return
     */
    @PostMapping("/queryAdminById")
    @ApiOperation("根据id查询admin")
    public String queryAdminById(@RequestBody AdminQueryBo adminQueryBo){
        return JSONArray.toJSONString(adminService.queryUserById(adminQueryBo));
    }

    /**
     * @author hln 2024-4-30
     *  根据id修改用户
     * @param adminUpdateBo
     * @return
     */
    @PostMapping("/updateAdminById")
    @ApiOperation("根据id修改用户")
    public String updateAdminById(@RequestBody AdminUpdateBo adminUpdateBo){
        return JSONArray.toJSONString(adminService.updateAdminById(adminUpdateBo));
    }

    /**
     * @author hln 2024-4-30
     *  根据id删除用户(逻辑删除)
     * @param deleteAdminByIdBo
     * @return
     */
    @PostMapping("/deleteAdminById")
    @ApiOperation("根据id删除用户(逻辑删除)")
    public String deleteAdminById(@RequestBody DeleteAdminByIdBo deleteAdminByIdBo){
        return JSONArray.toJSONString(adminService.deleteAdminById(deleteAdminByIdBo));
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
        return JSONArray.toJSONString(adminService.findAll());
    }

}
