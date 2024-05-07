package com.hln.blink.service.impl;

import com.hln.blink.mapper.AdminMapper;
import com.hln.blink.pojo.Admin;
import com.hln.blink.pojo.bo.AdminAddBo;
import com.hln.blink.pojo.bo.AdminQueryBo;
import com.hln.blink.pojo.bo.AdminUpdateBo;
import com.hln.blink.pojo.bo.DeleteAdminByIdBo;
import com.hln.blink.pojo.vo.AdminVo;
import com.hln.blink.pojo.vo.ResponseVo;
import com.hln.blink.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * @author hln 2024-4-30
     *  添加admin
     * @param adminAddBo
     * @return
     */
    @Override
    public ResponseVo addAdmin(AdminAddBo adminAddBo) {

        Long aLong = adminMapper.addAdmin(adminAddBo);

        if (aLong.longValue() == 0L) {
            return new ResponseVo<>("添加失败",null,"0x455");
        }

        return new ResponseVo<>("添加成功",null,"0x200");
    }

    /**
     * @author hln 2024-4-30
     *  根据id查询用户
     * @param adminQueryBo
     * @return
     */
    @Override
    public ResponseVo queryUserById(AdminQueryBo adminQueryBo) {

        AdminVo adminVo = adminMapper.queryUserById(adminQueryBo);

        if (adminVo == null) {
            return new ResponseVo<>("查询失败",null,"0x455");
        }

        return new ResponseVo<>("查询成功",adminVo,"0x200");
    }

    /**
     * @author hln 2024-4-30
     *  根据id修改用户
     * @param adminUpdateBo
     * @return
     */
    @Override
    public ResponseVo updateAdminById(AdminUpdateBo adminUpdateBo) {
        Long aLong = adminMapper.updateAdminById(adminUpdateBo);

        if (aLong.longValue() == 0L) {
            return new ResponseVo<>("修改失败",null,"0x455");
        }

        return new ResponseVo<>("修改成功",null,"0x200");
    }

    /**
     * @author hln 2024-4-30
     *  根据id删除用户(逻辑删除)
     * @param deleteAdminByIdBo
     * @return
     */
    @Override
    public ResponseVo deleteAdminById(DeleteAdminByIdBo deleteAdminByIdBo) {

        Long aLong = adminMapper.deleteUserById(deleteAdminByIdBo);

        if (aLong.longValue() == 0L) {
            return new ResponseVo<>("删除失败",null,"0x455");
        }

        return new ResponseVo<>("删除成功",null,"0x200");
    }

    /**
     * @author hln 2024-5-6
     * 查询所有
     * @return
     */
    @Override
    public ResponseVo findAll() {
        List<AdminVo> list = adminMapper.findAll();
        return new ResponseVo<>("查询成功",list,"0x200");
    }
}
