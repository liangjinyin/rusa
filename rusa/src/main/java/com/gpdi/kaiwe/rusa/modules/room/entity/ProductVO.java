package com.gpdi.kaiwe.rusa.modules.room.entity;

import lombok.Data;

/**
 * @author: liangjinyin
 * @Date: 2018-10-26
 * @Description:
 */
@Data
public class ProductVO {
    /**
     * 接入号
     */
    private String accessNum;
    /** 产品名称*/
    private String productName;
    /** 产品结构*/
    private String productType;
    /** 套餐结构*/
    private String mealType;
    /** 套餐价值*/
    private String mealValue;
    /** 套餐名称*/
    private String mealName;
    /** 优惠提醒*/
    private String tips;
    /** 宽带速率*/
    private String rate;
    /** 主副卡标识*/
    private String isZhuka;
}
