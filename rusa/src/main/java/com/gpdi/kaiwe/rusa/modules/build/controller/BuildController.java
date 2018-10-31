package com.gpdi.kaiwe.rusa.modules.build.controller;

import com.gpdi.kaiwe.rusa.common.module.controller.BaseController;
import com.gpdi.kaiwe.rusa.modules.build.service.BuildService;
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
@RequestMapping("/build")
public class BuildController extends BaseController{

    @Autowired
    private BuildService buildService;

    @GetMapping("/findList")
    public String findList(String name,Integer gradeId){
        data = buildService.findBuildList(name, gradeId);
        return result();
    }

    @GetMapping("/findOne")
    public String findOne(Integer id){
        data = buildService.findBuildById(id);
        return result();
    }

    @GetMapping("/findCompany")
    public String findCompanyById(Integer id){
        data = buildService.findCompanyById(id);
        return result();
    }

    @GetMapping("/findCompanyList")
    public String findCompanyList(Integer buildId,String name){
        data = buildService.findCompanyList(buildId,name);
        return result();
    }

    @GetMapping("/findResource")
    public String findResourceById(Integer id){
        data = buildService.findResourceById(id);
        return result();
    }
}
