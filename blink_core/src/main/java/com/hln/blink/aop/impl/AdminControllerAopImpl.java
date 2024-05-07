package com.hln.blink.aop.impl;

import com.hln.blink.aop.AdminControllerAop;
import com.hln.blink.aop.UserControllerAop;
import com.hln.blink.pojo.bo.*;
import com.hln.blink.service.SystemService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AdminControllerAopImpl implements AdminControllerAop {

    @Autowired
    private SystemService systemService;

    /**
     * @param joinPoint
     * @return
     * @author hln 2024-5-7
     * 添加admin
     */
    @Override
    @Before("execution(* com.hln.blink.controller.AdminController.addAdmin(..))")
    public String addAdmin(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        AdminAddBo arg = (AdminAddBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);

        return null;
    }

    /**
     * @param joinPoint
     * @return
     * @author hln 2024-5-7
     * 查找user鉴权
     */
    @Override
    @Before("execution(* com.hln.blink.controller.AdminController.queryAdminById(..))")
    public String queryAdminById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        AdminQueryBo arg = (AdminQueryBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);

        return null;
    }

    /**
     * @param joinPoint
     * @return
     * @author hln 2024-5-7
     * 修改user鉴权
     */
    @Override
    @Before("execution(* com.hln.blink.controller.AdminController.updateAdminById(..))")
    public String updateAdminById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        AdminUpdateBo arg = (AdminUpdateBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);

        return null;
    }

    /**
     * @param joinPoint
     * @return
     * @author hln 2024-5-7
     * 删除user鉴权
     */
    @Override
    @Before("execution(* com.hln.blink.controller.AdminController.deleteAdminById(..))")
    public String deleteAdminById(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        DeleteAdminByIdBo arg = (DeleteAdminByIdBo) args[0];
        String token = arg.getToken();
        systemService.isAdmin(token,2);

        return null;
    }

    /**
     * @param joinPoint
     * @author hln 2024-5-7
     * 查询所有信息
     */
    @Override
    @Before("execution(* com.hln.blink.controller.AdminController.findAll(..))")
    public String findAll(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String token = (String) args[0];
        systemService.isAdmin(token,2);

        return null;
    }
}
