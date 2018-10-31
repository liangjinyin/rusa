package com.gpdi.kaiwe.rusa.modules.index.service;

import com.gpdi.kaiwe.rusa.common.enums.ResultCode;
import com.gpdi.kaiwe.rusa.common.module.service.BaseService;
import com.gpdi.kaiwe.rusa.modules.index.entity.Indexs;
import com.gpdi.kaiwe.rusa.modules.index.repository.IndexRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: liangjinyin
 * @Date: 2018-10-25
 * @Description:
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class IndexService extends BaseService<Indexs> {

    @Autowired
    private IndexRepository indexRepository;

    /**
     *  获取指定的指标
     * @param ids 指标id
     * @return
     */
    public Object findValue(String ids,Integer gradeId,String date) {
        try {
            List<Indexs> indexsList = indexRepository.findByCidInAndGradeIdAndDate(Arrays.asList(ids.split(",")),gradeId,date);
            //根据大类分组
            return indexsList.stream().collect(Collectors.groupingBy(Indexs::getClassName));
           // return indexsList;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}",getClass().getSimpleName(),e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }
}
