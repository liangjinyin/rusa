package com.gpdi.kaiwe.rusa.modules.room.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

/**
 * @author: liangjinyin
 * @Date: 2018-10-25
 * @Description:
 */
@Data
@Entity
@Table(name ="ra_info_room")
public class RoomDetailVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "room_id")
    private Integer roomId;
    @Column(name = "room_name")
    private String roomName;
    /** 房间全名称*/
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "cust_id")
    private Integer custId;
    /** 网络结构*/
    @Column(name = "net_type")
    private String netType;
    /** 接入方式*/
    @Column(name = "access_type")
    private String accTpye;
    /** 是否已登记*/
    @Column(name = "registe_flag")
    private String regiFlag;
    /** 资源设备ID*/
    @Column(name = "equipment_id")
    private Integer equipmentId;
    /** 拜访次数*/
    @Column(name = "bf_num")
    private Integer bfNum;
    /** 故障次数*/
    @Column(name = "gz_num")
    private Integer gzNum;
    /** 投诉次数*/
    @Column(name = "ts_num")
    private Integer tsNum;
    @Transient
    private CustomerVO customerVO;
    @Transient
    private List<Map<String,Object>> productVO;

}
