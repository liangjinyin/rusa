package com.gpdi.kaiwe.rusa.modules.hotel.repository;

import com.gpdi.kaiwe.rusa.common.module.repository.BaseRepository;
import com.gpdi.kaiwe.rusa.modules.hotel.entity.Hotel;
import com.gpdi.kaiwe.rusa.modules.hotel.entity.HotelListOV;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: liangjinyin
 * @Date: 2018-10-27
 * @Description:
 */
@Repository
public interface HotelRepository extends BaseRepository<Hotel,Integer> {

    Hotel findByHotelId(Integer id);

    @Query(value = "select new com.gpdi.kaiwe.rusa.modules.hotel.entity.HotelListOV(a.hotelId,a.hotelName,a.gridName) " +
            "from Hotel as a where a.gridName like concat('%',:name,'%') or " +
            "  a.hotelName like concat('%',:name,'%')")
    List<HotelListOV> findHotelList(@Param("name") String name);
}
