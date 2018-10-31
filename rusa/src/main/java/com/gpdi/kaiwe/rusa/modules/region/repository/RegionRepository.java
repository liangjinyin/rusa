package com.gpdi.kaiwe.rusa.modules.region.repository;

import com.gpdi.kaiwe.rusa.common.module.repository.BaseRepository;
import com.gpdi.kaiwe.rusa.modules.region.entity.Region;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: liangjinyin
 * @Date: 2018-10-25
 * @Description:
 */
@Repository
public interface RegionRepository extends BaseRepository<Region,Integer> {

    List<Region> findByParentId(Integer id);

}
