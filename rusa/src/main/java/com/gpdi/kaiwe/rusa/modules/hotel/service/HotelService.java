package com.gpdi.kaiwe.rusa.modules.hotel.service;

import com.gpdi.kaiwe.rusa.common.enums.ResultCode;
import com.gpdi.kaiwe.rusa.common.module.service.BaseService;
import com.gpdi.kaiwe.rusa.modules.build.repository.BuildRepository;
import com.gpdi.kaiwe.rusa.modules.hotel.entity.Hotel;
import com.gpdi.kaiwe.rusa.modules.hotel.repository.HotelRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: liangjinyin
 * @Date: 2018-10-27
 * @Description:
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class HotelService extends BaseService<Hotel> {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private BuildRepository buildRepository;

    public Object findHotelById(Integer id) {
        try {
            entity = hotelRepository.findByHotelId(id);
            entity.setCreateTime(DateFormatUtils.format(entity.getCreateDate(),"yyyy-MM-dd"));
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}",getClass().getSimpleName(),e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }

    public Object findHotelList(String name) {
        try {
            return hotelRepository.findHotelList(name);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}",getClass().getSimpleName(),e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }

    public Object findBuildList(Integer hotelId) {
        try {
            return buildRepository.findBuildListByHotelId(hotelId);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}",getClass().getSimpleName(),e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }
}
