package com.gpdi.kaiwe.rusa.modules.room.service;

import com.gpdi.kaiwe.rusa.common.enums.ResultCode;
import com.gpdi.kaiwe.rusa.common.module.service.BaseService;
import com.gpdi.kaiwe.rusa.common.utils.MyBeanUtils;
import com.gpdi.kaiwe.rusa.modules.room.entity.Compete;
import com.gpdi.kaiwe.rusa.modules.room.entity.RoomDetailVO;
import com.gpdi.kaiwe.rusa.modules.room.repository.CompeteRepository;
import com.gpdi.kaiwe.rusa.modules.room.repository.CustomerRepository;
import com.gpdi.kaiwe.rusa.modules.room.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author: liangjinyin
 * @Date: 2018-10-25
 * @Description:
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class CompeteService extends BaseService{

    @Autowired
    private CompeteRepository competeRepository;


    public Object deleteCompete(Integer id) {
        try {
            if(competeRepository.existsById(id)){
                competeRepository.deleteById(id);
            }
            return ResultCode.OPERATION_SUCCESSED;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}",getClass().getSimpleName(),e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }

    public Object createOrUpdateCompete(Compete compete) {
        try {
            if (compete.getId()!=null) {
                //修改
                Compete temp = competeRepository.findById(compete.getId()).get();
                MyBeanUtils.copyProperties(compete,temp);
                return competeRepository.save(temp);
            }else{
                //添加
                return competeRepository.save(compete);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}",getClass().getSimpleName(),e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }

    public Object findCompeteByRoomId(Integer id) {
        try {
            return competeRepository.findByRoomId(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}",getClass().getSimpleName(),e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }
}
