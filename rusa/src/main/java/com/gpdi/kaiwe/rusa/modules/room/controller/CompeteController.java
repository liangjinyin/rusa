package com.gpdi.kaiwe.rusa.modules.room.controller;

import com.gpdi.kaiwe.rusa.common.module.controller.BaseController;
import com.gpdi.kaiwe.rusa.modules.room.entity.Compete;
import com.gpdi.kaiwe.rusa.modules.room.service.CompeteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: liangjinyin
 * @Date: 2018-10-25
 * @Description:
 */
@RestController
@RequestMapping("/compete")
public class CompeteController extends BaseController {

    @Autowired
    private CompeteService competeService;

    @PostMapping("/createOrUpdate")
    public String createOrUpdateCompete(Compete compete) {
        data = competeService.createOrUpdateCompete(compete);
        return result();
    }

    @DeleteMapping("/delete")
    public String deleteCompete(Integer id) {
        data = competeService.deleteCompete(id);
        return result();
    }

    @GetMapping("/findOne")
    public String findCompeteByRoomId(Integer id){
        data = competeService.findCompeteByRoomId(id);
        return result();
    }

}
