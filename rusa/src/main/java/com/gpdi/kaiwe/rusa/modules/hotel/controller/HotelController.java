package com.gpdi.kaiwe.rusa.modules.hotel.controller;

import com.gpdi.kaiwe.rusa.common.module.controller.BaseController;
import com.gpdi.kaiwe.rusa.modules.hotel.entity.Hotel;
import com.gpdi.kaiwe.rusa.modules.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liangjinyin
 * @Date: 2018-10-27
 * @Description:
 */
@RestController
@RequestMapping("/hotel")
public class HotelController extends BaseController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/findOne")
    public String findHotelById(Integer id){
        data = hotelService.findHotelById(id);
        return result();
    }

    @GetMapping("/findList")
    public String findHotelList(String name,Integer gradeId){
        //TODO 加上区域条件
        data = hotelService.findHotelList(name);
        return result();
    }

    @GetMapping("/findBuildList")
    public String findBuildList(Integer hotelId){
        data = hotelService.findBuildList(hotelId);
        return result();
    }
}
