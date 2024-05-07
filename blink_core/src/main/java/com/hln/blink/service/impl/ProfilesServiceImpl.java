package com.hln.blink.service.impl;

import com.hln.blink.mapper.ProfilesMapper;
import com.hln.blink.pojo.Profiles;
import com.hln.blink.pojo.bo.DeleteProfilesByIdBo;
import com.hln.blink.pojo.bo.ProfilesAddBo;
import com.hln.blink.pojo.bo.ProfilesQueryBo;
import com.hln.blink.pojo.bo.ProfilesUpdateBo;
import com.hln.blink.pojo.vo.AdminVo;
import com.hln.blink.pojo.vo.ResponseVo;
import com.hln.blink.service.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilesServiceImpl implements ProfilesService {

    @Autowired
    private ProfilesMapper profilesMapper;

    /**
     * @param profilesAddBo
     * @return
     * @author hln 2024-5-7
     * 添加Profiles
     */
    @Override
    public ResponseVo addProfiles(ProfilesAddBo profilesAddBo) {

        Long aLong = profilesMapper.addProfiles(profilesAddBo);

        if (aLong.longValue() == 0L) {
            return new ResponseVo<>("添加失败",null,"0x455");
        }

        return new ResponseVo<>("添加成功",null,"0x200");
    }

    /**
     * @param profilesQueryBo
     * @return
     * @author hln 2024-5-7
     * 根据userId查询Profiles
     */
    @Override
    public ResponseVo queryUserById(ProfilesQueryBo profilesQueryBo) {
        Profiles profiles = profilesMapper.queryUserById(profilesQueryBo);

        if (profiles == null) {
            return new ResponseVo<>("查询失败",null,"0x455");
        }

        return new ResponseVo<>("查询成功",profiles,"0x200");
    }

    /**
     * @param profilesUpdateBo
     * @return
     * @author hln 2024-5-7
     * 根据userId修改用户Profiles
     */
    @Override
    public ResponseVo updateProfilesById(ProfilesUpdateBo profilesUpdateBo) {
        Long aLong = profilesMapper.updateProfilesById(profilesUpdateBo);

        if (aLong.longValue() == 0L) {
            return new ResponseVo<>("修改失败",null,"0x455");
        }

        return new ResponseVo<>("修改成功",null,"0x200");
    }

    /**
     * @param deleteProfilesByIdBo
     * @return
     * @author hln 2024-5-7
     * 根据userId删除用户Profiles(逻辑删除)
     */
    @Override
    public ResponseVo deleteProfilesById(DeleteProfilesByIdBo deleteProfilesByIdBo) {
        Long aLong = profilesMapper.deleteProfilesById(deleteProfilesByIdBo);

        if (aLong.longValue() == 0L) {
            return new ResponseVo<>("删除失败",null,"0x455");
        }

        return new ResponseVo<>("删除成功",null,"0x200");
    }

    /**
     * @return
     * @author hln 2024-5-7
     * 查询所有Profiles
     */
    @Override
    public ResponseVo findAll() {
        List<Profiles> list = profilesMapper.findAll();
        return new ResponseVo<>("查询成功",list,"0x200");
    }
}
