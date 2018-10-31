package com.gpdi.kaiwe.rusa.common.scheduled;


import com.gpdi.kaiwe.rusa.modules.feign.FeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author: liangjinyin
 * @Date: 2018-10-04
 * @Description:
 */
@Slf4j
//@Component
public class ScheduledService {

    @Autowired
    private FeignClient feignClient;

    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled(){
        Object date = feignClient.getDate();
        System.out.println(date);
        log.info("=====>>>>>使用cron  {}",System.currentTimeMillis());
    }
    @Scheduled(fixedRate = 5000)
    public void scheduled1() {
        log.info("=====>>>>>使用fixedRate{}", System.currentTimeMillis());
    }
    @Scheduled(fixedDelay = 5000)
    public void scheduled2() {
        log.info("=====>>>>>fixedDelay{}",System.currentTimeMillis());
    }
}
