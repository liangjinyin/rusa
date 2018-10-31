package com.gpdi.kaiwe.rusa.modules.build.repository;

import com.gpdi.kaiwe.rusa.common.module.repository.BaseRepository;
import com.gpdi.kaiwe.rusa.modules.build.entity.BaseBuild;
import com.gpdi.kaiwe.rusa.modules.build.entity.BuildListVO;
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
public interface BuildRepository extends BaseRepository<BaseBuild,Integer>{

    @Query(value = "select new com.gpdi.kaiwe.rusa.modules.build.entity.BuildListVO(a.buildId," +
            " a.buildName,a.address) " +
            " from BaseBuild a where a.address LIKE CONCAT('%',:name,'%') OR " +
            " a.gridName LIKE CONCAT('%',:name,'%') OR a.buildName LIKE CONCAT('%',:name,'%')" +
            " AND a.gridId = :gradeId ")
    List<BuildListVO> findBuildList(@Param("name") String name, @Param("gradeId") Integer gradeId);

    BaseBuild findByBuildId(Integer id);

    @Query(value = "SELECT com_name comName,address,leader,capital,com_state comState," +
            " create_time createTime,com_type comType,group_type groupType,profit,phone " +
            " FROM ra_info_company WHERE id = :id",nativeQuery = true)
    Map<String,Object> findCompanyById(@Param("id") Integer id);

    @Query(value = "SELECT id,com_name comName,address,group_type groupType" +
            " FROM ra_info_company WHERE build_id = :id AND(com_name LIKE CONCAT('%',:name,'%') OR :name IS NULL )",nativeQuery = true)
    List<Map<String,Object>> findCompanyList(@Param("id") Integer buildId,@Param("name") String name);

    @Query(value = "SELECT build_id buildId,build_name buildName,addr_full_name address FROM ra_info_build" +
            " WHERE build_id in (SELECT yid FROM ra_relation WHERE xid = :id AND type=1)",nativeQuery = true)
    List<Map<String,Object>> findBuildListByHotelId(@Param("id")Integer hotelId);

    @Query(value = "SELECT equipment_id equipmentId,equipment_code equipmentCode,build_id buildId,name," +
            " equipment_type equipmentType,address,addr_id addrId,port_num portNum,free_num freeNum," +
            " speed FROM ra_info_equipment WHERE build_id=:id ", nativeQuery = true)
    Map<String,Object> findResourceByBuildId(@Param("id") Integer id);
}
