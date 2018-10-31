package com.gpdi.kaiwe.rusa.modules.event.repository;

import com.gpdi.kaiwe.rusa.modules.event.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: liangjinyin
 * @Date: 2018-10-26
 * @Description:
 */
@Repository
public interface EventRepository extends CrudRepository<Event,Integer>{

    List<Event> findByRoomIdAndTypeOrderByAnswerTimeDesc(Integer id,String type);
}
