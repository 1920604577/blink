package com.hln.blink.aop.impl;

import com.hln.blink.aop.UserControllerAop;
import com.hln.blink.pojo.bo.DeleteUserByIdBo;
import com.hln.blink.pojo.bo.UserQueryBo;
import com.hln.blink.pojo.bo.UserUpdateBo;
import com.hln.blink.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserControllerAopImpl implements UserControllerAop {

    @Autowired
    private SystemService systemService;

    /**
     * @param joinPoint
     * @return
     * @author hln 2023-10-31
     * 查找user鉴权
     */
    @Override
    @Before("execution(* com.hln.blink.controller.UserController.queryUserById(..))")
    public String queryUserById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserQueryBo arg = (UserQueryBo) args[0];
        String token = arg.getToken();
        systemService.auth(token);

        return null;
    }

    /**
     * @param joinPoint
     * @return
     * @author hln 2023-10-31
     * 修改user鉴权
     */
    @Override
    @Before("execution(* com.hln.blink.controller.UserController.updateUserById(..))")
    public String updateUserById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        UserUpdateBo arg = (UserUpdateBo) args[0];
        String token = arg.getToken();
        systemService.auth(token);

        return null;
    }

    /**
     * @param joinPoint
     * @return
     * @author hln 2023-10-31
     * 删除user鉴权
     */
    @Override
    @Before("execution(* com.hln.blink.controller.UserController.deleteUserById(..))")
    public String deleteUserById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        DeleteUserByIdBo arg = (DeleteUserByIdBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);

        return null;
    }

    /**
     * @param joinPoint
     * @author hln 2023-11-03
     * 查询所有信息
     */
    @Override
    @Before("execution(* com.hln.blink.controller.UserController.findAll(..))")
    public String findAll(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String token = (String) args[0];
        systemService.isAdmin(token,2);

        return null;
    }
}
