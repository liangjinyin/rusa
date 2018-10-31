package com.gpdi.kaiwe.rusa.modules.build.entity;

import com.gpdi.kaiwe.rusa.modules.room.entity.RoomListVO;
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
@Table(name = "ra_info_floor")
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "floor_id")
    private Integer floorId;
    @Column(name = "build_id")
    private Integer buildId;
    @Column(name = "floor_name")
    private String floorName;
    @Transient
    private List<Map<String,Object>> roomList;
}
