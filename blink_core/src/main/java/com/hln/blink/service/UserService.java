package com.hln.blink.service;

import com.hln.blink.pojo.bo.*;
import com.hln.blink.pojo.vo.ResponseVo;

public interface UserService {

    /**
     * @author hln 2024-4-30
     *  用户注册
     * @param userRegBo
     * @return
     */
    ResponseVo userReg(UserRegBo userRegBo);

    /**
     * @author hln 2024-4-30
     *  用户登录
     * @param loginBo
     * @return
     */
    ResponseVo login(LoginBo loginBo);

    /**
     * @author hln 2024-4-30
     *  根据id查询用户
     * @param userQueryBo
     * @return
     */
    ResponseVo queryUserById(UserQueryBo userQueryBo);

    /**
     * @author hln 2024-4-30
     *  根据id修改用户
     * @param userUpdateBo
     * @return
     */
    ResponseVo updateUserById(UserUpdateBo userUpdateBo);

    /**
     * @author hln 2024-4-30
     *  根据id删除用户(逻辑删除)
     * @param deleteUserByIdBo
     * @return
     */
    ResponseVo deleteUserById(DeleteUserByIdBo deleteUserByIdBo);

    /**
     * @author hln 2024-4-30
     * 查询所有
     * @return
     */
    ResponseVo findAll();
}
