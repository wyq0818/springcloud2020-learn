package com.wyq.cloud.gatewayhand.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 过滤器模型
 * @Author:wuyongqiang
 * @Date:2021-02-05 09:57:9:57
 */
@Getter
@Setter
@ApiModel(description = "过滤器实体对象")
public class GatewayFilterDefinition {
    @ApiModelProperty(value = "名称")
    //Filter Name
    private String name;
    //对应的路由规则
    @ApiModelProperty(value = "规则")
    private Map<String, String> args = new LinkedHashMap<>();
    //此处省略Get和Set方法
}
