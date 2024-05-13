package com.hln.blink.service.impl;

import com.hln.blink.mapper.DatingInvitationsMapper;
import com.hln.blink.pojo.DatingInvitations;
import com.hln.blink.pojo.bo.*;
import com.hln.blink.pojo.vo.DatingInvitationsVo;
import com.hln.blink.pojo.vo.ResponseVo;
import com.hln.blink.service.DatingInvitationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatingInvitationsServiceImpl implements DatingInvitationsService {

    @Autowired
    private DatingInvitationsMapper datingInvitationsMapper;


    /**
     * @param datingInvitationsAddBo
     * @return
     * @author hln 2024-5-12
     */
    @Override
    public ResponseVo addDatingInvitations(DatingInvitationsAddBo datingInvitationsAddBo) {
        Long aLong = datingInvitationsMapper.addDatingInvitations(datingInvitationsAddBo);

        if (aLong.longValue() == 0L) {
            return new ResponseVo<>("添加失败",null,"0x455");
        }

        return new ResponseVo<>("添加成功",null,"0x200");
    }

    /**
     * @param datingInvitationsQueryBo
     * @return
     * @author hln 2024-5-12
     * 根据id查询用户
     */
    @Override
    public ResponseVo queryDatingInvitationsById(DatingInvitationsQueryBo datingInvitationsQueryBo) {
        DatingInvitations datingInvitations = datingInvitationsMapper.queryDatingInvitationsById(datingInvitationsQueryBo);

        if (datingInvitations == null) {
            return new ResponseVo<>("查询失败",null,"0x455");
        }

        return new ResponseVo<>("查询成功",datingInvitations,"0x200");
    }

    /**
     * @param datingInvitationsUpdateBo
     * @return
     * @author hln 2024-5-12
     * 根据id修改用户
     */
    @Override
    public ResponseVo updateDatingInvitationsById(DatingInvitationsUpdateBo datingInvitationsUpdateBo) {

        Long aLong = datingInvitationsMapper.updateDatingInvitationsById(datingInvitationsUpdateBo);

        if (aLong.longValue() == 0L) {
            return new ResponseVo<>("修改失败",null,"0x455");
        }

        return new ResponseVo<>("修改成功",null,"0x200");
    }

    /**
     * @param deleteDatingInvitationsByIdBo
     * @return
     * @author hln 2024-5-12
     * 根据id删除用户(逻辑删除)
     */
    @Override
    public ResponseVo deleteDatingInvitationsById(DeleteDatingInvitationsByIdBo deleteDatingInvitationsByIdBo) {
        Long aLong = datingInvitationsMapper.deleteDatingInvitationsById(deleteDatingInvitationsByIdBo);

        if (aLong.longValue() == 0L) {
            return new ResponseVo<>("删除失败",null,"0x455");
        }

        return new ResponseVo<>("删除成功",null,"0x200");
    }

    /**
     * @return
     * @author hln 2024-5-6
     * 查询所有
     */
    @Override
    public ResponseVo findAll() {
        List<DatingInvitationsVo> list = datingInvitationsMapper.findAll();
        return new ResponseVo<>("查询成功",list,"0x200");
    }

    /**
     * @param handleYesBo
     * @return
     */
    @Override
    public ResponseVo handleYes(HandleYesBo handleYesBo) {
        Long aLong = datingInvitationsMapper.handleYes(handleYesBo);

        if (aLong.longValue() == 0L) {
            return new ResponseVo<>("操作失败",null,"0x455");
        }

        return new ResponseVo<>("操作成功",null,"0x200");
    }

    /**
     * @param handleNoBo
     * @return
     */
    @Override
    public ResponseVo handleNo(HandleNoBo handleNoBo) {
        Long aLong = datingInvitationsMapper.handleNo(handleNoBo);

        if (aLong.longValue() == 0L) {
            return new ResponseVo<>("操作失败",null,"0x455");
        }

        return new ResponseVo<>("操作成功",null,"0x200");
    }

    /**
     * @return
     */
    @Override
    public ResponseVo queryAllByUserId(QueryAllByUserIdBo queryAllByUserIdBo) {
        List<DatingInvitationsVo> list = datingInvitationsMapper.queryAllByUserId(queryAllByUserIdBo);
        return new ResponseVo<>("查询成功",list,"0x200");
    }
}
