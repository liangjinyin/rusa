package com.gpdi.kaiwe.rusa.modules.build.service;

import com.gpdi.kaiwe.rusa.common.enums.ResultCode;
import com.gpdi.kaiwe.rusa.common.module.service.BaseService;
import com.gpdi.kaiwe.rusa.common.utils.MapUtils;
import com.gpdi.kaiwe.rusa.modules.build.entity.BaseBuild;
import com.gpdi.kaiwe.rusa.modules.build.entity.Floor;
import com.gpdi.kaiwe.rusa.modules.build.repository.BuildRepository;
import com.gpdi.kaiwe.rusa.modules.build.repository.FloorRepository;
import com.gpdi.kaiwe.rusa.modules.room.entity.RoomListVO;
import com.gpdi.kaiwe.rusa.modules.room.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: liangjinyin
 * @Date: 2018-10-25
 * @Description:
 */
@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class BuildService extends BaseService<BaseBuild> {

    @Autowired
    private BuildRepository buildRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private FloorRepository floorRepository;

    public Object findBuildList(String name, Integer gradeId) {
        try {
            //TODO 加上区域搜索条件
            return buildRepository.findBuildList(name, gradeId);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}", getClass().getSimpleName(), e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }

    public Object findBuildById(Integer id) {
        Map<String, Object> data = new HashMap(16);
        try {
            BaseBuild build = buildRepository.findByBuildId(id);
            List<Floor> floorList = floorRepository.findByBuildId(id);

            floorList.stream().forEach(e -> e.setRoomList(roomRepository.findByFloorId(e.getFloorId())));
            data.put("build", build);
            data.put("floorList", floorList);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}", getClass().getSimpleName(), e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }

    public Object findCompanyById(Integer id) {
        try {
            return buildRepository.findCompanyById(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}",getClass().getSimpleName(),e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }

    public Object findCompanyList(Integer buildId, String name) {
        try {
            return buildRepository.findCompanyList(buildId, name);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}",getClass().getSimpleName(),e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }

    public Object findResourceById(Integer id) {
        try {
            return buildRepository.findResourceByBuildId(id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{} 类出现了异常，异常信息为：{}",getClass().getSimpleName(),e.getMessage());
            return ResultCode.OPERATION_FAILED;
        }
    }

}
