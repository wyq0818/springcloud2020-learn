package com.wyq.cloud.gatewayhand.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 断言模型
 * @Author:wuyongqiang
 * @Date:2021-02-05 09:58:9:58
 */
@Getter
@Setter
@ApiModel(description = "断言实体对象")
public class GatewayPredicateDefinition {
    //断言对应的Name
    @ApiModelProperty(value = "名称")
    private String name;
    //配置的断言规则
    @ApiModelProperty(value = "规则")
    private Map<String, String> args = new LinkedHashMap<>();
    //此处省略Get和Set方法
}
