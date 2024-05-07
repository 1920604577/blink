package com.hln.blink.service;

import com.hln.blink.pojo.vo.ResponseVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

public interface SystemService {

    /**
     * @author hln 2024-4-30
     *  判断是否是登陆状态
     * @param token
     * @return
     */
    public ResponseVo auth(String token);

    /**
     * @author hln 2024-4-30
     *  判断是否是管理员（用户权限等级）
     * @param token
     * @param leave
     * @return
     */
    public ResponseVo isAdmin(String token, Integer leave);

}
