package com.gpdi.kaiwe.rusa.modules.room.controller;

import com.gpdi.kaiwe.rusa.common.module.controller.BaseController;
import com.gpdi.kaiwe.rusa.modules.room.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liangjinyin
 * @Date: 2018-10-25
 * @Description:
 */
@RestController
@RequestMapping("/room")
public class RoomController extends BaseController{

    @Autowired
    private RoomService roomService;

    @GetMapping("/findOne")
    public String findRoomById(Integer id){
        data = roomService.findRoomById(id);
        return result();
    }

    @GetMapping("/findResource")
    public String findResourceById(Integer id){
        data = roomService.findResourceById(id);
        return result();
    }

    @GetMapping("findList")
    public String findRoomList(String name,String access){
        data = roomService.findRoomList(name,access);
        return result();
    }
}
