package com.gpdi.kaiwe.rusa.modules.region.controller;

import com.gpdi.kaiwe.rusa.common.module.controller.BaseController;
import com.gpdi.kaiwe.rusa.modules.region.service.RegionService;
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
@RequestMapping("/region")
public class RegionController extends BaseController {


    @Autowired
    private RegionService regionService;

    @GetMapping("findCList")
    public String findRegionListByPId(Integer id){
        data = regionService.findRegionListByPId(id);
        return result();
    }

}
