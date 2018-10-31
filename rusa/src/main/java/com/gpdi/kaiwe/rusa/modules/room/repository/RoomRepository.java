package com.gpdi.kaiwe.rusa.modules.room.repository;

import com.gpdi.kaiwe.rusa.common.module.repository.BaseRepository;
import com.gpdi.kaiwe.rusa.modules.room.entity.ProductVO;
import com.gpdi.kaiwe.rusa.modules.room.entity.ResourceVO;
import com.gpdi.kaiwe.rusa.modules.room.entity.RoomDetailVO;
import com.gpdi.kaiwe.rusa.modules.room.entity.RoomListVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: liangjinyin
 * @Date: 2018-10-25
 * @Description:
 */
@Repository
public interface RoomRepository extends BaseRepository<RoomDetailVO, Integer> {


    RoomDetailVO findByRoomId(Integer id);

    @Query(value = "SELECT a.room_id roomId,a.room_name roomName," +
            " b.cust_name custName,a.is_ctcc isYD,a.is_unicom isLT,a.is_chinatel isDX,a.no_business noBusi," +
            " a.kd_mark kdMark,a.zxhl_mark zxhlMark,a.gh_mark ghMark,a.itv_mark itvMark ,a.mobile_mark mobileMark " +
            " FROM ra_info_room a LEFT JOIN ra_info_customer b ON a.cust_id = b.cust_id" +
            " WHERE a.floor_id=:id", nativeQuery = true)
    List<Map<String,Object>> findByFloorId(@Param("id") Integer id);

    @Query(value = "SELECT equipment_id equipmentId,equipment_code equipmentCode,build_id buildId,name," +
            " equipment_type equipmentType,address,addr_id addrId,port_num portNum,free_num freeNum," +
            " speed FROM ra_info_equipment WHERE equipment_id=:id ", nativeQuery = true)
    Map<String,Object> findResourceById(@Param("id") Integer id);

    @Query(value = "SELECT access_num accessNum,product_name productName,product_type productType," +
            " meal_type mealType,meal_value mealValue,meal_name mealName,tips,rate,is_zhuka isZhuka" +
            " from ra_info_product WHERE room_id=:id", nativeQuery = true)
    List<Map<String,Object>> findProductByRoomId(@Param("id") Integer id);

    @Query(value = "SELECT a.room_id roomId,b.cust_name custName, a.product_name productName" +
            " FROM ra_info_product a LEFT JOIN ra_info_customer b ON a.cust_id = b.cust_id" +
            " WHERE a.access_num = :access OR b.cust_name like concat('%',:name,'%')", nativeQuery = true)
    List<Map<String,Object>> findRoomList(@Param("name") String name,@Param("access")String access);
}
