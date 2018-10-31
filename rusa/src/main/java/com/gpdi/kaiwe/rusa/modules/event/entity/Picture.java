package com.gpdi.kaiwe.rusa.modules.event.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: liangjinyin
 * @Date: 2018-10-26
 * @Description:
 */
@Table(name = "ra_picture")
@Data
@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /** 序号*/
    private Integer id;
    /** xid  1 拜访；2 故障； 3投诉的id*/
    private Integer xid;
    /** 图片*/
    private byte[] picture;
}
