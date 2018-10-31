package com.gpdi.kaiwe.rusa.modules.region.service;

import com.gpdi.kaiwe.rusa.common.enums.ResultCode;
import com.gpdi.kaiwe.rusa.common.module.service.BaseService;
import com.gpdi.kaiwe.rusa.modules.region.entity.Region;
import com.gpdi.kaiwe.rusa.modules.region.repository.RegionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
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
public class RegionService extends BaseService<Region> {

    @Autowired
    private RegionRepository regionRepository;

    public Object findRegionListByPId(Integer id) {
        try {
            List<Region> regionList = regionRepository.findByParentId(id);
            return regionList.stream().map(e->{
                Map<String, Object> map = new HashMap<>(8);
                map.put("id", e.getId());
                map.put("name", e.getName());
                return map;
            }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}",getClass().getSimpleName(),e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }
}
