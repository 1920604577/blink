package com.hln.blink.service.impl;

import com.hln.blink.mapper.AdminMapper;
import com.hln.blink.pojo.vo.ResponseVo;
import com.hln.blink.service.SystemService;
import com.hln.blink.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.hln.blink.util.JwtUtil.analysis;

@Service
public class SystemServiceImpl implements SystemService {

    @Value("${filePath}")
    private String path;
    @Value("${projecturl}")
    private String projecturl;
    @Autowired
    private AdminMapper userAdminMapper;

    /**
     * @author hln 2024-4-30
     *  判断是否是登陆状态
     * @param token
     * @return
     */
    @Override
    public ResponseVo auth(String token) {
        try {
            Map<String, Object> map = analysis(token);
//            String id = (String) analysis.get("id");
//            Long userId = Long.valueOf(id);
//            User user = userMapper.findById(userId);
            ThreadLocalUtil.mapThreadLocalOfJWT.get().put("userinfo",map);
//            System.out.println(ThreadLocalUtil.mapThreadLocalOfJWT);
            return new ResponseVo(null,map,"0x200");
        } catch (Exception e) {
            //e.printStackTrace();
            ThreadLocalUtil.mapThreadLocal.get().put("error","身份验证过期");
            ThreadLocalUtil.mapThreadLocal.get().put("code", "0x600");
            return new ResponseVo("身份登入验证过期",null,"0x203");
        }
    }

    /**
     * @author Oh...Yeah!!! 2023-11-13
     *    图片上传
     * @param token
     * @return String.class
     */
    @Override
    public ResponseVo isAdmin(String token,Integer leave){
        //身份鉴权
        ResponseVo auth = this.auth(token);
        if (auth.getData() == null) {
            return null;
        }

        String strUserId = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userinfo").get("id");
        Long userId = Long.valueOf(strUserId);

        if(userId == null || userId == 0L){
            return new ResponseVo("token解析失败",null,"0x501");
        }

//        UserAdmin userAdmin = userAdminMapper.queryByUserId(userId);
//
//        if (userAdmin == null || userAdmin.getRole() < leave){
//            ThreadLocalUtil.mapThreadLocal.get().put("error","权限不足");
//            ThreadLocalUtil.mapThreadLocal.get().put("code", "0x600");
//            return new ResponseVo("权限不足",null,"0x404");
//        }

        return null;
    }

}
