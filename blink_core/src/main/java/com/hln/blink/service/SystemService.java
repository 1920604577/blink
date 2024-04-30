package com.hln.blink.service;

import com.hln.blink.pojo.vo.ResponseVo;

public interface SystemService {

    /**
     * @author hln 2024-4-30
     *  判断是否是登陆状态
     * @param token
     * @return
     */
    public ResponseVo isAuth(String token);

    /**
     * @author hln 2024-4-30
     *  判断是否是管理员（用户权限等级）
     * @param token
     * @param leave
     * @return
     */
    public ResponseVo isAdmin(String token, Integer leave);

}
