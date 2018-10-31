package com.gpdi.kaiwe.rusa.common.module.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author: liangjinyin
 * @Date: 2018-09-21
 * @Description: Dao基类
 */
@NoRepositoryBean
public interface BaseRepository<T,ID> extends JpaRepository<T,ID>,JpaSpecificationExecutor<T> {

}
