package com.hln.blink.aop;

import org.aspectj.lang.JoinPoint;

public interface AdminControllerAop {

    /**
     * @author hln 2024-5-7
     *  添加admin
     * @param joinPoint
     * @return
     */
    public String addAdmin(JoinPoint joinPoint);

    /**
     * @author hln 2024-5-7
     *      查找user鉴权
     * @param joinPoint
     * @return
     */
    public String queryAdminById(JoinPoint joinPoint);

    /**
     * @author hln 2024-5-7
     *      修改user鉴权
     * @param joinPoint
     * @return
     */
    public String updateAdminById(JoinPoint joinPoint);

    /**
     * @author hln 2024-5-7
     *      删除user鉴权
     * @param joinPoint
     * @return
     */
    public String deleteAdminById(JoinPoint joinPoint);

    /**
     * @author hln 2024-5-7
     *      查询所有信息
     * @param joinPoint
     */
    String findAll(JoinPoint joinPoint);

}
