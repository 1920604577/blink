package com.hln.blink.service;

import com.hln.blink.pojo.bo.*;
import com.hln.blink.pojo.vo.ResponseVo;

public interface DatingInvitationsService {
    /**
     * @author hln 2024-4-30
     *  添加admin
     * @param datingInvitationsAddBo
     * @return
     */
    ResponseVo addDatingInvitations(DatingInvitationsAddBo datingInvitationsAddBo);

    /**
     * @author hln 2024-4-30
     *  根据id查询用户
     * @param datingInvitationsQueryBo
     * @return
     */
    ResponseVo queryDatingInvitationsById(DatingInvitationsQueryBo datingInvitationsQueryBo);

    /**
     * @author hln 2024-4-30
     *  根据id修改用户
     * @param datingInvitationsUpdateBo
     * @return
     */
    ResponseVo updateDatingInvitationsById(DatingInvitationsUpdateBo datingInvitationsUpdateBo);

    /**
     * @author hln 2024-4-30
     *  根据id删除用户(逻辑删除)
     * @param deleteDatingInvitationsByIdBo
     * @return
     */
    ResponseVo deleteDatingInvitationsById(DeleteDatingInvitationsByIdBo deleteDatingInvitationsByIdBo);

    /**
     * @author hln 2024-5-6
     *  查询所有
     * @return
     */
    ResponseVo findAll();

    ResponseVo handleYes(HandleYesBo handleYesBo);
    ResponseVo handleNo(HandleNoBo handleNoBo);

    ResponseVo queryAllByUserId(QueryAllByUserIdBo queryAllByUserIdBo);
}
