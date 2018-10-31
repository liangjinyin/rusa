package com.gpdi.kaiwe.rusa.modules.build.entity;

import lombok.Data;

/**
 * @author: liangjinyin
 * @Date: 2018-10-30
 * @Description:
 */
@Data
public class Company {
    private Integer id;
    private Integer companyId;
    private Integer buildId;
    /** 企业名称*/
    private String comName;
    /** 企业地址*/
    private String address;
    /** 法人代表*/
    private String leader;
    /** 注册资本*/
    private String capital;
    /** 企业状态*/
    private String comState;
    /** 成立时间*/
    private String createTime;
    /** 商事类型*/
    private String comType;
    /** 集团类型*/
    private String groupType;
    /** 收入情况*/
    private String profit;
    /** 联系电话*/
    private String phone;
}
