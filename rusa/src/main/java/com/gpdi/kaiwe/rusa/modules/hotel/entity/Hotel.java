package com.gpdi.kaiwe.rusa.modules.hotel.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: liangjinyin
 * @Date: 2018-10-26
 * @Description:
 */
@Data
@Entity
@Table(name = "ra_info_hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "hotel_id")
    private Integer hotelId;
    @Column(name = "hotel_name")
    private String hotelName;
    private String address;
    /** 网格名称*/
    @Column(name = "grid_name")
    private String gridName;
    /** 法人代表*/
    private String leader;
    /** 注册资本*/
    private String capital;
    /** 酒店星级*/
    @Column(name = "hotel_grade")
    private String hotelGrade;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "room_num")
    private String  roomNum;
    @Column(name = "company_num")
    private String companyNum;
    /** 过夜人流*/
    @Column(name = "flower_num")
    private String flowerNum;
    /** 酒店住满率*/
    @Column(name = "live_perc")
    private String livePerc;
    /** 酒店回访率*/
    @Column(name = "visit_perc")
    private String visitPerc;
    /** 竞争力指数*/
    @Column(name = "compete_num")
    private String competeNum;
    /** 集团类型*/
    @Column(name = "group_type")
    private String groupType;
    /** 网络覆盖情况*/
    @Column(name = "net_type")
    private String netType;
    /** 收入情况*/
    private String income;
    @Transient
    private String createTime;
}
