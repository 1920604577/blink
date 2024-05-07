package com.hln.blink.mapper;

import com.hln.blink.pojo.User;
import com.hln.blink.pojo.bo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper{

    /**
     * @author hln 2024-4-30
     *  用户注册
     * @param user
     * @return
     */
    Long insertUser(UserRegBo user);

    /**
     * @author hln 2024-4-30
     *  用户登录
     * @param loginBo
     * @return
     */
    User login(LoginBo loginBo);

    /**
     * @author hln 2024-4-30
     *  根据id查询用户
     * @param userQueryBo
     * @return
     */
    User queryUserById(UserQueryBo userQueryBo);

    /**
     * @author hln 2024-4-30
     *  根据id修改用户
     * @param userUpdateBo
     * @return
     */
    Long updateUserById(UserUpdateBo userUpdateBo);

    /**
     * @author hln 2024-4-30
     *  根据id删除用户(逻辑删除)
     * @param deleteUserByIdBo
     * @return
     */
    Long deleteUserById(DeleteUserByIdBo deleteUserByIdBo);

    /**
     * @author hln 2024-5-5
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * @author hln 2024-5-7
     * 根据username找user
     * @param username
     * @return
     */
    User queryUserByName(String username);
}
