package com.gpdi.kaiwe.rusa.modules.room.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: liangjinyin
 * @Date: 2018-10-25
 * @Description:
 */
@Data
@Entity
@Table(name ="ra_info_customer")
public class CustomerVO implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cust_id")
    private Integer custId;
    @Column(name = "cust_name")
    private String custName;
    @Column(name = "cust_type")
    private String custType;
    /** 联系人*/
    private String contacts;
    private String phone;
    /** 业务等级*/
    @Column(name = "busi_grade")
    private String busiGrade;
    /** 预警情况*/
    private String warn;
    /** 开通时长*/
    @Column(name = "open_time")
    private String openTime;
    /** 宽带情况*/
    private String broadband;
    /** 流量情况*/
    private String flow;
}
