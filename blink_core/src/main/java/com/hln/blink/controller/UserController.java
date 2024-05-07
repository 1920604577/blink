package com.hln.blink.controller;

import com.alibaba.fastjson2.JSONArray;
import com.hln.blink.pojo.bo.*;
import com.hln.blink.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@CrossOrigin
@Api(value = "用户板块接口",tags = {"用户板块接口"})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @author hln 2024-4-30
     *  用户注册
     * @param userRegBo
     * @return
     */
    @PostMapping("/userReg")
    @ApiOperation("用户注册")
    public String userReg(@RequestBody UserRegBo userRegBo){
        return JSONArray.toJSONString(userService.userReg(userRegBo));
    }

    /**
     * @author hln 2024-4-30
     *  用户登录
     * @param loginBo
     * @return
     */
    @PostMapping(value = "/login")
    @ApiOperation("用户登录")
    public String login(@RequestBody LoginBo loginBo){
        return JSONArray.toJSONString(userService.login(loginBo));
    }

    /**
     * @author hln 2024-4-30
     *  根据id查询用户
     * @param userQueryBo
     * @return
     */
    @PostMapping("/queryUserById")
    @ApiOperation("根据id查询用户")
    public String queryUserById(@RequestBody UserQueryBo userQueryBo){
        return JSONArray.toJSONString(userService.queryUserById(userQueryBo));
    }

    /**
     * @author hln 2024-4-30
     *  根据id修改用户
     * @param userUpdateBo
     * @return
     */
    @PostMapping("/updateUserById")
    @ApiOperation("根据id修改用户")
    public String updateUserById(@RequestBody UserUpdateBo userUpdateBo){
        return JSONArray.toJSONString(userService.updateUserById(userUpdateBo));
    }

    /**
     * @author hln 2024-4-30
     *  根据id删除用户(逻辑删除)
     * @param deleteUserByIdBo
     * @return
     */
    @PostMapping("/deleteUserById")
    @ApiOperation("根据id删除用户(逻辑删除)")
    public String deleteUserById(@RequestBody DeleteUserByIdBo deleteUserByIdBo){
        return JSONArray.toJSONString(userService.deleteUserById(deleteUserByIdBo));
    }

    @PostMapping("/findAll")
    @ApiOperation("查询所有")
    public String findAll(@RequestParam String token){
        return JSONArray.toJSONString(userService.findAll());
    }

}
