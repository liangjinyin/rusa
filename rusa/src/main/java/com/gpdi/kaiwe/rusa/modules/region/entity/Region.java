package com.gpdi.kaiwe.rusa.modules.region.entity;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @author: liangjinyin
 * @Date: 2018-10-25
 * @Description:
 */
@Data
@Entity
@Table(name ="ra_info_region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "parent_id")
    private Integer parentId;
    private String name;
    private String grade;
    private String code;
    @Column(name = "classcode")
    private String classCode;
    /** 名称简拼*/
    @Column(name = "jp_code")
    private String jpCode;
}
