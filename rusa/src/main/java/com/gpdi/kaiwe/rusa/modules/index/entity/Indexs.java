package com.gpdi.kaiwe.rusa.modules.index.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: liangjinyin
 * @Date: 2018-10-25
 * @Description: 指标实体
 */
@Data
@Entity
@Table(name = "topl_user_daily_grid")
public class Indexs implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /** 指标id*/
    @Column(name = "codeclassdetailsid")
    private String cid;
    /** 时间*/
    @Column(name = "edw_date")
    private String date;
    /** 指标名称*/
    @Column(name = "ind_name")
    private String name;
    /** 指标值*/
    @Column(name = "ind_value")
    private String value;
    /** 机构区域名*/
    @Column(name = "gradeid")
    private Integer gradeId;
    /** 指标所属类名*/
    @Column(name = "mid_class_name")
    private String className;
}
