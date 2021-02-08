package com.wyq.cloud.gatewayhand.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 路由模型
 * @Author:wuyongqiang
 * @Date:2021-02-05 09:57:9:57
 */
@Getter
@Setter
@ApiModel(description = "路由实体对象")
public class GatewayRouteDefinition {
    //路由的Id
    @ApiModelProperty(value = "路由id")
    private String id;
    //路由断言集合配置
    @ApiModelProperty(value = "断言集合")
    private List<GatewayPredicateDefinition> predicates = new ArrayList<>();
    //路由过滤器集合配置
    @ApiModelProperty(value = "过滤器集合")
    private List<GatewayFilterDefinition> filters = new ArrayList<>();
    //路由规则转发的目标uri
    @ApiModelProperty(value = "目标服务uri")
    private String uri;
    //路由执行的顺序
    @ApiModelProperty(value = "路由执行顺序")
    private int order = 0;
    //此处省略get和set方法


}
