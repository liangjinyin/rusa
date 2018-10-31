package com.gpdi.kaiwe.rusa.modules.hotel.entity;

import lombok.Data;

/**
 * @author: liangjinyin
 * @Date: 2018-10-27
 * @Description:
 */
@Data
public class HotelListOV {

    private Integer id;
    private String hotelName;
    private String gridName;

    public HotelListOV(Integer id, String hotelName, String gridName) {
        this.id = id;
        this.hotelName = hotelName;
        this.gridName = gridName;
    }
}
