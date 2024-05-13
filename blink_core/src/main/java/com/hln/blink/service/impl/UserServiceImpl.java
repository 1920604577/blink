package com.hln.blink.service.impl;

import com.hln.blink.mapper.AdminMapper;
import com.hln.blink.mapper.ProfilesMapper;
import com.hln.blink.mapper.UserMapper;
import com.hln.blink.pojo.User;
import com.hln.blink.pojo.bo.*;
import com.hln.blink.pojo.vo.AdminVo;
import com.hln.blink.pojo.vo.LoginVo;
import com.hln.blink.pojo.vo.ResponseVo;
import com.hln.blink.service.UserService;
import com.hln.blink.util.JwtUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private ProfilesMapper profilesMapper;

    /**
     * @author hln 2024-4-30
     *  用户注册
     * @param userRegBo
     * @return
     */
    @Override
    public ResponseVo userReg(UserRegBo userRegBo) {

        Long uLong = userMapper.insertUser(userRegBo);
        AdminAddBo adminAddBo = new AdminAddBo();
        User user = userMapper.queryUserByName(userRegBo.getUsername());
        adminAddBo.setRole(0);
        adminAddBo.setUserId(user.getId());
        Long aLong = adminMapper.addAdmin(adminAddBo);

        if (uLong.longValue() == 0L || aLong.longValue() == 0L) {
            return new ResponseVo<>("注册失败",null,"0x455");
        }

        return new ResponseVo<>("注册成功",null,"0x200");
    }

    /**
     * @author hln 2024-4-30
     *  用户登录
     * @param loginBo
     * @return
     */
    @Override
    public ResponseVo login(LoginBo loginBo) {

        User user = userMapper.login(loginBo);
        String jwt = JwtUtil.createJWT(user);
        Integer role = adminMapper.queryRoleById(user.getId());
        LoginVo loginVo = new LoginVo();
        loginVo.setUser(user);
        loginVo.setToken(jwt);
        loginVo.setRole(role);

        if (user == null) {
            return new ResponseVo<>("登录失败",null,"0x455");
        }

        return new ResponseVo<>("登录成功",loginVo,"0x200");
    }

    /**
     * @author hln 2024-4-30
     *  根据id查询用户
     * @param userQueryBo
     * @return
     */
    @Override
    public ResponseVo queryUserById(UserQueryBo userQueryBo) {

        User user = userMapper.queryUserById(userQueryBo);

        if (user == null) {
            return new ResponseVo<>("查询失败",null,"0x455");
        }

        return new ResponseVo<>("查询成功",user,"0x200");
    }

    /**
     * @author hln 2024-4-30
     *  根据id修改用户
     * @param userUpdateBo
     * @return
     */
    @Override
    public ResponseVo updateUserById(UserUpdateBo userUpdateBo) {

        Long aLong = userMapper.updateUserById(userUpdateBo);

        if (aLong.longValue() == 0L) {
            return new ResponseVo<>("修改失败",null,"0x455");
        }

        return new ResponseVo<>("修改成功",null,"0x200");
    }

    /**
     * @author hln 2024-4-30
     *  根据id删除用户(逻辑删除)
     * @param deleteUserByIdBo
     * @return
     */
    @Override
    public ResponseVo deleteUserById(DeleteUserByIdBo deleteUserByIdBo) {

        Long aLong = userMapper.deleteUserById(deleteUserByIdBo);
        DeleteProfilesByIdBo deleteProfilesByIdBo = new DeleteProfilesByIdBo();
        deleteProfilesByIdBo.setUserId(deleteUserByIdBo.getId());
        Long pLong = profilesMapper.deleteProfilesById(deleteProfilesByIdBo);

        if (aLong.longValue() == 0L && pLong.longValue() == 0L) {
            return new ResponseVo<>("删除失败",null,"0x455");
        }

        return new ResponseVo<>("删除成功",null,"0x200");
    }

    /**
     * @author hln 2024-5-5
     * 查询所有
     */
    @Override
    public ResponseVo findAll() {
        List<User> list = userMapper.findAll();
        return new ResponseVo<>("查询成功",list,"0x200");
    }
}
