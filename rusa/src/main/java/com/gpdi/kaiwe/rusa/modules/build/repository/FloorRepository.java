package com.gpdi.kaiwe.rusa.modules.build.repository;

import com.gpdi.kaiwe.rusa.common.module.repository.BaseRepository;
import com.gpdi.kaiwe.rusa.modules.build.entity.Floor;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author: liangjinyin
 * @Date: 2018-10-25
 * @Description:
 */
@Repository
public interface FloorRepository extends BaseRepository<Floor,Integer>{

    List<Floor> findByBuildId(Integer id);
}
