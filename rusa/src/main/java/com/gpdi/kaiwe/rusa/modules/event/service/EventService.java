package com.gpdi.kaiwe.rusa.modules.event.service;

import com.gpdi.kaiwe.rusa.common.enums.ResultCode;
import com.gpdi.kaiwe.rusa.common.module.service.BaseService;
import com.gpdi.kaiwe.rusa.common.utils.MyBeanUtils;
import com.gpdi.kaiwe.rusa.modules.event.entity.Event;
import com.gpdi.kaiwe.rusa.modules.event.repository.EventRepository;
import com.gpdi.kaiwe.rusa.modules.event.repository.PictureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: liangjinyin
 * @Date: 2018-10-26
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class EventService extends BaseService<Event> {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private PictureRepository pictureRepository;

    /**
     * 获取事件列表
     *
     * @param type 事件类型
     * @param id   房间id
     * @return
     */
    public Object findEventListByType(String type, Integer id) {
        try {
            list = eventRepository.findByRoomIdAndTypeOrderByAnswerTimeDesc(id, type);
            return list.stream().map(e -> {
                Map<String, Object> map = new HashMap<>();
                map.put("id", e.getId());
                map.put("answerTime", e.getAnswerTime());
                map.put("name", e.getName());
                return map;
            }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}", getClass().getSimpleName(), e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }

    /**
     * 更新或创建事件
     *
     * @param event
     * @return
     */
    public Object createOrUpdateEvent(Event event) {
        try {
            if (event.getId() != null) {
                //修改  先删除所有图片再添加
                entity = eventRepository.findById(event.getId()).get();
                if (entity.getPictureList() != null) {
                    pictureRepository.deleteAll(entity.getPictureList());
                }
                MyBeanUtils.copyProperties(event, entity);
                eventRepository.save(entity);
                if (entity.getPictureList() != null) {
                    pictureRepository.saveAll(entity.getPictureList());
                }
            } else {
                //添加
                entity = eventRepository.save(event);
                if (entity.getPictureList() != null) {
                    entity.getPictureList().stream().forEach(e -> e.setXid(entity.getId()));
                    pictureRepository.saveAll(entity.getPictureList());
                }
            }
            return ResultCode.OPERATION_SUCCESSED;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}", getClass().getSimpleName(), e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }

    /**
     * 获取指定事件
     *
     * @param id id
     * @return
     */
    public Object findEventById(Integer id) {
        try {
            entity = eventRepository.findById(id).get();
            entity.setPictureList(pictureRepository.findByXidOrderById(id));
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}", getClass().getSimpleName(), e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }
}
