package com.wangdao.snc.asyn.eventhandler;


import com.wangdao.snc.asyn.EventModel;
import com.wangdao.snc.asyn.EventType;

import java.util.ArrayList;

public interface EventHandler {

    void handlerEvent(EventModel eventModel);

    void registerCareEvent(EventType eventType);

    ArrayList<EventType> getCareEvent();
}
