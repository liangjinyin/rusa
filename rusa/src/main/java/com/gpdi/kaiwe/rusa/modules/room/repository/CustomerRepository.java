package com.gpdi.kaiwe.rusa.modules.room.repository;

import com.gpdi.kaiwe.rusa.common.module.repository.BaseRepository;
import com.gpdi.kaiwe.rusa.modules.room.entity.CustomerVO;
import org.springframework.stereotype.Repository;


/**
 * @author: liangjinyin
 * @Date: 2018-10-25
 * @Description:
 */
@Repository
public interface CustomerRepository extends BaseRepository<CustomerVO,Integer> {

    CustomerVO findByCustId(Integer id);
}
