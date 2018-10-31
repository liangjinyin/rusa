package com.gpdi.kaiwe.rusa.modules.feign;

import feign.Headers;
import feign.RequestLine;

/**
 * @author: liangjinyin
 * @Date: 2018-10-04
 * @Description:  模块
 */
@Headers("Content-Type:application/json")
public interface FeignClient {
    @RequestLine("GET /customer/data")
    Object getDate();
}
