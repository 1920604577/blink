package com.hln.blink.service.impl;

import com.hln.blink.mapper.DatingEventsMapper;
import com.hln.blink.mapper.DatingInvitationsMapper;
import com.hln.blink.pojo.DatingEvents;
import com.hln.blink.pojo.bo.*;
import com.hln.blink.pojo.vo.DatingEventsVo;
import com.hln.blink.pojo.vo.DatingInvitationsVo;
import com.hln.blink.pojo.vo.ResponseVo;
import com.hln.blink.service.DatingEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatingEventsServiceImpl implements DatingEventsService {

    @Autowired
    private DatingEventsMapper datingEventsMapper;

    @Autowired
    private DatingInvitationsMapper datingInvitationsMapper;

    /**
     * @param DatingEventsAddBo
     * @return
     * @author hln 2024-5-12
     */
    @Override
    public ResponseVo addDatingEvents(DatingEventsAddBo DatingEventsAddBo) {

        Long aLong = datingEventsMapper.addDatingEvents(DatingEventsAddBo);

        if (aLong.longValue() == 0L) {
            return new ResponseVo<>("添加失败",null,"0x455");
        }

        return new ResponseVo<>("添加成功",null,"0x200");
    }

    /**
     * @param DatingEventsQueryBo
     * @return
     * @author hln 2024-5-12
     * 根据id查询用户
     */
    @Override
    public ResponseVo queryDatingEventsById(DatingEventsQueryBo DatingEventsQueryBo) {
        DatingEvents DatingEvents = datingEventsMapper.queryDatingEventsById(DatingEventsQueryBo);

        if (DatingEvents == null) {
            return new ResponseVo<>("查询失败",null,"0x455");
        }

        return new ResponseVo<>("查询成功",DatingEvents,"0x200");
    }

    /**
     * @param DatingEventsUpdateBo
     * @return
     * @author hln 2024-5-12
     * 根据id修改用户
     */
    @Override
    public ResponseVo updateDatingEventsById(DatingEventsUpdateBo DatingEventsUpdateBo) {

        Long aLong = datingEventsMapper.updateDatingEventsById(DatingEventsUpdateBo);

        if (aLong.longValue() == 0L) {
            return new ResponseVo<>("修改失败",null,"0x455");
        }

        return new ResponseVo<>("修改成功",null,"0x200");
    }

    /**
     * @param deleteDatingEventsByIdBo
     * @return
     * @author hln 2024-5-12
     * 根据id删除用户(逻辑删除)
     */
    @Override
    public ResponseVo deleteDatingEventsById(DeleteDatingEventsByIdBo deleteDatingEventsByIdBo) {
        Long aLong = datingEventsMapper.deleteDatingEventsById(deleteDatingEventsByIdBo);

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
        List<DatingEvents> list = datingEventsMapper.findAll();
        return new ResponseVo<>("查询成功",list,"0x200");
    }

    /**
     * @param queryAllDataByUserIdBo
     * @return
     */
    @Override
    public ResponseVo queryAllByUserId(QueryAllDataByUserIdBo queryAllDataByUserIdBo) {
        List<DatingEventsVo> list = datingEventsMapper.queryAllByUserId(queryAllDataByUserIdBo);
        return new ResponseVo<>("查询成功",list,"0x200");
    }

}
