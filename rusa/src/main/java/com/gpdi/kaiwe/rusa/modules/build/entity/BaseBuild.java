package com.gpdi.kaiwe.rusa.modules.build.entity;

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
@Table(name = "ra_info_build")
public class BaseBuild implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column(name = "build_id")
    private Integer buildId;
    @Column(name = "build_name")
    private String buildName;
    @Column(name = "addr_full_name")
    private String address;
    @Column(name = "grid_id")
    private String gridId;
    /** 网格名称*/
    @Column(name = "grid_name")
    private String gridName;
    @Column(name = "floor_num")
    private String floorNum;
    @Column(name = "room_num")
    private String roomNum;
    @Column(name = "man_stream")
    private String manStream;
    @Column(name = "company_num")
    private String companyNum;
    /** 网络覆盖情况*/
    @Column(name = "net_type")
    private String netType;
    /** 移动用户数*/
    @Column(name = "ctcc_user_cnt")
    private Integer ctUserNum;
    /** 联通用户数*/
    @Column(name = "unicom_user_cnt")
    private Integer unUserNum;
    /** 电信用户数*/
    @Column(name = "chinatel_user_cnt")
    private Integer chUserNum;
    /** 无业务房间数*/
    @Column(name = "no_business_room_cnt")
    private Integer noBusiness;
    /** 移动渗透率*/
    @Column(name = "ctcc_user_rate")
    private Integer ctUserRate;
    /** 友商渗透率*/
    @Column(name = "compete_user_rate")
    private Integer otherUserRate;
    /** 172移动开通能力*/
    @Column(name = "ctcc_open_ability")
    private String  ctAbility;
    /** 友商开通能力*/
    @Column(name = "compete_open_ability")
    private String  otherAbility;

}
