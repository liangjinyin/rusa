package com.gpdi.kaiwe.rusa.modules.index.controller;

import com.gpdi.kaiwe.rusa.common.module.controller.BaseController;
import com.gpdi.kaiwe.rusa.modules.index.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liangjinyin
 * @Date: 2018-10-25
 * @Description:
 */
@RestController
@RequestMapping("/index")
public class IndexController extends BaseController{

    @Autowired
    private IndexService indexService;

    @GetMapping("/findValue")
    public String findValue(String ids,Integer gradeId,String date){
        data = indexService.findValue(ids,gradeId,date);
        return result();
    }
}
