package com.gpdi.kaiwe.rusa.modules.room.repository;

import com.gpdi.kaiwe.rusa.modules.room.entity.Compete;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: liangjinyin
 * @Date: 2018-10-26
 * @Description:
 */
@Repository
public interface CompeteRepository extends CrudRepository<Compete,Integer>{

    Compete findByRoomId(Integer id);


}
