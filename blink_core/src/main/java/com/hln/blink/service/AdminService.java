package com.hln.blink.service;

import com.hln.blink.pojo.bo.AdminAddBo;
import com.hln.blink.pojo.bo.AdminQueryBo;
import com.hln.blink.pojo.bo.AdminUpdateBo;
import com.hln.blink.pojo.bo.DeleteAdminByIdBo;
import com.hln.blink.pojo.vo.ResponseVo;

public interface AdminService{

    /**
     * @author hln 2024-4-30
     *  添加admin
     * @param adminAddBo
     * @return
     */
    ResponseVo addAdmin(AdminAddBo adminAddBo);

    /**
     * @author hln 2024-4-30
     *  根据id查询用户
     * @param adminQueryBo
     * @return
     */
    ResponseVo queryUserById(AdminQueryBo adminQueryBo);

    /**
     * @author hln 2024-4-30
     *  根据id修改用户
     * @param adminUpdateBo
     * @return
     */
    ResponseVo updateAdminById(AdminUpdateBo adminUpdateBo);

    /**
     * @author hln 2024-4-30
     *  根据id删除用户(逻辑删除)
     * @param deleteAdminByIdBo
     * @return
     */
    ResponseVo deleteAdminById(DeleteAdminByIdBo deleteAdminByIdBo);

    /**
     * @author hln 2024-5-6
     *  查询所有
     * @return
     */
    ResponseVo findAll();
}
