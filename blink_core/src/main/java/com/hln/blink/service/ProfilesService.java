package com.hln.blink.service;

import com.hln.blink.pojo.bo.ProfilesAddBo;
import com.hln.blink.pojo.bo.ProfilesQueryBo;
import com.hln.blink.pojo.bo.ProfilesUpdateBo;
import com.hln.blink.pojo.bo.DeleteProfilesByIdBo;
import com.hln.blink.pojo.vo.ResponseVo;

public interface ProfilesService {

    /**
     * @author hln 2024-4-30
     *  添加Profiles
     * @param profilesAddBo
     * @return
     */
    ResponseVo addProfiles(ProfilesAddBo profilesAddBo);

    /**
     * @author hln 2024-4-30
     *  根据userId查询Profiles
     * @param profilesQueryBo
     * @return
     */
    ResponseVo queryUserById(ProfilesQueryBo profilesQueryBo);

    /**
     * @author hln 2024-4-30
     *  根据userId修改用户Profiles
     * @param profilesUpdateBo
     * @return
     */
    ResponseVo updateProfilesById(ProfilesUpdateBo profilesUpdateBo);

    /**
     * @author hln 2024-4-30
     *  根据userId删除用户Profiles(逻辑删除)
     * @param deleteProfilesByIdBo
     * @return
     */
    ResponseVo deleteProfilesById(DeleteProfilesByIdBo deleteProfilesByIdBo);

    /**
     * @author hln 2024-5-6
     *  查询所有Profiles
     * @return
     */
    ResponseVo findAll();

}
