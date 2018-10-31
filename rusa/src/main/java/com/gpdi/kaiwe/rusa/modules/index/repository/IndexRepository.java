package com.gpdi.kaiwe.rusa.modules.index.repository;

import com.gpdi.kaiwe.rusa.common.module.repository.BaseRepository;
import com.gpdi.kaiwe.rusa.modules.index.entity.Indexs;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: liangjinyin
 * @Date: 2018-10-25
 * @Description:
 */
@Repository
public interface IndexRepository extends BaseRepository<Indexs, Integer> {

    /**
     *  查询指定的指标
     * @param ids
     * @param gradeId
     * @param date
     * @return
     */
    List<Indexs> findByCidInAndGradeIdAndDate(List<String> ids,Integer gradeId,String date);
}
