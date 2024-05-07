package com.hln.blink.aop;

import org.aspectj.lang.JoinPoint;

public interface UserControllerAop {

    /**
     * @author hln 2024-5-7
     *      查找user鉴权
     * @param joinPoint
     * @return
     */
    public String queryUserById(JoinPoint joinPoint);

    /**
     * @author hln 2024-5-7
     *      修改user鉴权
     * @param joinPoint
     * @return
     */
    public String updateUserById(JoinPoint joinPoint);

    /**
     * @author hln 2024-5-7
     *      删除user鉴权
     * @param joinPoint
     * @return
     */
    public String deleteUserById(JoinPoint joinPoint);

    /**
     * @author hln 2024-5-7
     *      查询所有信息
     * @param joinPoint
     */
    String findAll(JoinPoint joinPoint);

}
