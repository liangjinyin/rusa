package com.gpdi.kaiwe.rusa.modules.room.entity;

import lombok.Data;

/**
 * @author: liangjinyin
 * @Date: 2018-10-26
 * @Description:
 */
@Data
public class ResourceVO {
    /** 设备编号*/
    private Integer equipmentId;
    /** 设备编码*/
    private String equipmentCode;
    private Integer buildId;
    /** 设备名称*/
    private String name;
    /** 设备类型编码*/
    private String equipmentType;
    /** 设备安装地址*/
    private String address;
    private Integer addrId;
    /** 端口数*/
    private Integer portNum;
    /** 空闲端口数*/
    private Integer freeNum;
    /** 可达速率*/
    private String speed;
}
