package com.hln.blink.mapper;

import com.hln.blink.pojo.bo.AdminAddBo;
import com.hln.blink.pojo.bo.AdminQueryBo;
import com.hln.blink.pojo.bo.AdminUpdateBo;
import com.hln.blink.pojo.bo.DeleteAdminByIdBo;
import com.hln.blink.pojo.vo.AdminVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    /**
     * @author hln 2024-4-30
     *  添加admin
     * @param adminAddBo
     * @return
     */
    Long addAdmin(AdminAddBo adminAddBo);

    /**
     * @param adminQueryBo
     * @return
     * @author hln 2024-4-30
     * 根据id查询用户
     */
    AdminVo queryUserById(AdminQueryBo adminQueryBo);

    /**
     * @author hln 2024-4-30
     *  根据id修改用户
     * @param adminUpdateBo
     * @return
     */
    Long updateAdminById(AdminUpdateBo adminUpdateBo);

    /**
     * @author hln 2024-4-30
     *  根据id删除用户(逻辑删除)
     * @param deleteAdminByIdBo
     * @return
     */
    Long deleteUserById(DeleteAdminByIdBo deleteAdminByIdBo);

    /**
     * @author hln 2024-5-6
     * 查询所有
     * @return
     */
    List<AdminVo> findAll();

    /**
     * @author hln 2024-5-7
     * 根据id查role
     * @param id
     * @return
     */
    Integer queryRoleById(Long id);
}
