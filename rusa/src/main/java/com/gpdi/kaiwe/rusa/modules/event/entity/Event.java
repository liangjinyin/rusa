package com.gpdi.kaiwe.rusa.modules.event.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author: liangjinyin
 * @Date: 2018-10-26
 * @Description:
 */
@Table(name = "ra_zh_record")
@Data
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column(name = "room_id")
    private Integer roomId;
    /** 事件名称*/
    private String name;
    /** 拜访人/故障处理人/投诉处理人*/
    private String header;
    /** 故障处理时间/投诉处理时间*/
    @Column(name = "answer_time")
    private Date answerTime;
    /** 故障处理结果/投诉处理结果*/
    @Column(name = "answer_result")
    private String answerResult;
    /** 记录详细/故障描述/投诉内容*/
    private String details;
    /** 归属记录 1 拜访；2 故障； 3投诉*/
    private String type;
    @Transient
    private List<Picture> pictureList;
}
