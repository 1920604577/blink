package com.hln.blink.mapper;

import com.hln.blink.pojo.Profiles;
import com.hln.blink.pojo.bo.ProfilesAddBo;
import com.hln.blink.pojo.bo.ProfilesQueryBo;
import com.hln.blink.pojo.bo.ProfilesUpdateBo;
import com.hln.blink.pojo.bo.DeleteProfilesByIdBo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfilesMapper {

    /**
     * @author hln 2024-5-7
     *  添加Profiles
     * @param ProfilesAddBo
     * @return
     */
    Long addProfiles(ProfilesAddBo ProfilesAddBo);

    /**
     * @param ProfilesQueryBo
     * @return
     * @author hln 2024-5-7
     * 根据id查询用户
     */
    Profiles queryUserById(ProfilesQueryBo ProfilesQueryBo);

    /**
     * @author hln 2024-5-7
     *  根据id修改用户
     * @param ProfilesUpdateBo
     * @return
     */
    Long updateProfilesById(ProfilesUpdateBo ProfilesUpdateBo);

    /**
     * @author hln 2024-5-7
     *  根据id删除用户(逻辑删除)
     * @param deleteProfilesByIdBo
     * @return
     */
    Long deleteProfilesById(DeleteProfilesByIdBo deleteProfilesByIdBo);

    /**
     * @author hln 2024-5-7
     * 查询所有
     * @return
     */
    List<Profiles> findAll();

}
