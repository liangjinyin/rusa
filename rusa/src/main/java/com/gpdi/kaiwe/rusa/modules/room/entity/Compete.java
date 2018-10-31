package com.gpdi.kaiwe.rusa.modules.room.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: liangjinyin
 * @Date: 2018-10-25
 * @Description:
 */
@Data
@Entity
@Table(name ="ra_info_compete")
public class Compete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "room_id")
    private Integer roomId;
    private String remarks;
    /** 竞争对手*/
    private String competer;
    /** 到期时间*/
    private Date endDate;
    /** 到期提示*/
    private String tips;
    private Integer price;
    /** 速率*/
    private String speed;
    /** 接入方式*/
    @Column(name = "accese_type")
    private String acceseType;
    private String contacts;
    private String phone;
    /** 营销人*/
    @Column(name = "saler_name")
    private String salerName;
    /** 营销人账号*/
    @Column(name = "saler_code")
    private String salerCode;
}
