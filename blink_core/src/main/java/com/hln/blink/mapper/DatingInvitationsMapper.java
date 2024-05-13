package com.hln.blink.mapper;

import com.hln.blink.pojo.DatingInvitations;
import com.hln.blink.pojo.bo.*;
import com.hln.blink.pojo.vo.DatingInvitationsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DatingInvitationsMapper {

    Long addDatingInvitations(DatingInvitationsAddBo datingInvitationsAddBo);

    DatingInvitations queryDatingInvitationsById(DatingInvitationsQueryBo datingInvitationsQueryBo);

    Long updateDatingInvitationsById(DatingInvitationsUpdateBo datingInvitationsUpdateBo);

    Long deleteDatingInvitationsById(DeleteDatingInvitationsByIdBo deleteDatingInvitationsByIdBo);

    List<DatingInvitationsVo> findAll();

    Long handleYes(HandleYesBo handleYesBo);

    Long handleNo(HandleNoBo handleNoBo);

    List<DatingInvitationsVo> queryAllByUserId(QueryAllByUserIdBo queryAllByUserIdBo);
}
