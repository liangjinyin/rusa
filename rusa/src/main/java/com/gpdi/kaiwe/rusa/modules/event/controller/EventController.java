package com.gpdi.kaiwe.rusa.modules.event.controller;

import com.gpdi.kaiwe.rusa.common.module.controller.BaseController;
import com.gpdi.kaiwe.rusa.modules.event.entity.Event;
import com.gpdi.kaiwe.rusa.modules.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liangjinyin
 * @Date: 2018-10-26
 * @Description:
 */
@RestController
@RequestMapping("/event")
public class EventController extends BaseController{

    @Autowired
    private EventService eventService;

    @GetMapping("/findList")
    public String findEventListByType(String type,Integer id){
        data = eventService.findEventListByType(type, id);
        return result();
    }

    @PostMapping("/createOrUpdate")
    public String createOrUpdateEvent(Event event) {
        data = eventService.createOrUpdateEvent(event);
        return result();
    }

    @GetMapping("/findOne")
    public String findEventById(Integer id){
        data = eventService.findEventById(id);
        return result();
    }
}
