package com.gpdi.kaiwe.rusa.modules.event.repository;

import com.gpdi.kaiwe.rusa.modules.event.entity.Event;
import com.gpdi.kaiwe.rusa.modules.event.entity.Picture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: liangjinyin
 * @Date: 2018-10-26
 * @Description:
 */
@Repository
public interface PictureRepository extends CrudRepository<Picture,Integer>{

    List<Picture> findByXidOrderById(Integer id);
}
