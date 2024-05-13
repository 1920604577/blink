package com.hln.blink.service;

import com.hln.blink.pojo.bo.*;
import com.hln.blink.pojo.vo.ResponseVo;

public interface DatingEventsService {

    ResponseVo addDatingEvents(DatingEventsAddBo datingEventsAddBo);

    ResponseVo queryDatingEventsById(DatingEventsQueryBo datingEventsQueryBo);

    ResponseVo updateDatingEventsById(DatingEventsUpdateBo datingEventsUpdateBo);

    ResponseVo deleteDatingEventsById(DeleteDatingEventsByIdBo deleteDatingEventsByIdBo);

    ResponseVo findAll();

    ResponseVo queryAllByUserId(QueryAllDataByUserIdBo queryAllDataByUserIdBo);
}
