package com.gpdi.kaiwe.rusa.modules.build.entity;

import lombok.Data;

/**
 * @author: liangjinyin
 * @Date: 2018-10-25
 * @Description:
 */
@Data
public class BuildListVO {
    private Integer buildId;
    private String buildName;
    private String address;

    public BuildListVO(Integer buildId, String buildName, String address) {
        this.buildId = buildId;
        this.buildName = buildName;
        this.address = address;
    }
}
