package com.gpdi.kaiwe.rusa.modules.room.service;

import com.gpdi.kaiwe.rusa.common.enums.ResultCode;
import com.gpdi.kaiwe.rusa.common.module.service.BaseService;
import com.gpdi.kaiwe.rusa.common.utils.MapUtils;
import com.gpdi.kaiwe.rusa.modules.room.entity.ResourceVO;
import com.gpdi.kaiwe.rusa.modules.room.entity.RoomDetailVO;
import com.gpdi.kaiwe.rusa.modules.room.repository.CustomerRepository;
import com.gpdi.kaiwe.rusa.modules.room.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liangjinyin
 * @Date: 2018-10-25
 * @Description:
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class RoomService extends BaseService{

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public Object findRoomById(Integer id) {
        Map<String, Object> data = new HashMap<>();
        try {
            //TODO 添加其他实体
            RoomDetailVO room = roomRepository.findByRoomId(id);
            //设置房间客户信息
            room.setCustomerVO(customerRepository.findByCustId(room.getCustId()));
            //设置房间产品信息
            room.setProductVO(roomRepository.findProductByRoomId(id));
            data.put("room", room);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}",getClass().getSimpleName(),e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }

    public Object findResourceById(Integer id) {
        try {
            Map<String, Object> resource = roomRepository.findResourceById(id);
            return MapUtils.mapToObject(resource, ResourceVO.class);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}",getClass().getSimpleName(),e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }

    public Object findRoomList(String name, String access) {
        try {
            return roomRepository.findRoomList(name,access);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}",getClass().getSimpleName(),e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }
}
