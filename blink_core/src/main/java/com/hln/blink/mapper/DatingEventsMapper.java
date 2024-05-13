package com.hln.blink.mapper;

import com.hln.blink.pojo.DatingEvents;
import com.hln.blink.pojo.bo.*;
import com.hln.blink.pojo.vo.DatingEventsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DatingEventsMapper {

    Long addDatingEvents(DatingEventsAddBo DatingEventsAddBo);

    DatingEvents queryDatingEventsById(DatingEventsQueryBo DatingEventsQueryBo);

    Long updateDatingEventsById(DatingEventsUpdateBo DatingEventsUpdateBo);

    Long deleteDatingEventsById(DeleteDatingEventsByIdBo deleteDatingEventsByIdBo);

    List<DatingEvents> findAll();

    List<DatingEventsVo> queryAllByUserId(QueryAllDataByUserIdBo queryAllDataByUserIdBo);
}
