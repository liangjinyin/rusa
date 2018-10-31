package com.gpdi.kaiwe.rusa.modules.room.entity;

import lombok.Data;

/**
 * @author: liangjinyin
 * @Date: 2018-10-25
 * @Description:
 */
@Data
public class RoomListVO {

    private String roomName;
    private Integer roomId;
    private Integer custId;
    /** 移动业务标识*/
    private String isYD;
    /** 联通业务标识*/
    private String isLT;
    /** 电信业务标识*/
    private String isDX;
    /** 无业务*/
    private String noBusi;
    /** 宽带标识*/
    private String kdMark;
    /** 专线互联标识*/
    private String zxhlMark;
    /** ITV标识*/
    private String itvMark;
    /** 移动标识*/
    private String mobileMark;
    /** 固话标识*/
    private String ghMark;

}
