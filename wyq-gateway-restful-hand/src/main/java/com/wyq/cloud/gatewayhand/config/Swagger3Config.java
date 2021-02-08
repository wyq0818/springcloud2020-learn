package com.wyq.cloud.gatewayhand.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.ApiSelector;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @Author:wuyongqiang
 * @Date:2021-02-07 10:21:10:21
 */
@Configuration
public class Swagger3Config {

    @Value(value = "${spring.application.name}")
    private String componentName;
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.basePackage("com.wyq.cloud.gatewayhand.controller"))
                .paths(PathSelectors.any())
                .build();
//                .globalRequestParameters(getGlobalRequestParameters())
//                .globalResponses(HttpMethod.GET, getGlobalResponseMessage())
//                .globalResponses(HttpMethod.POST, getGlobalResponseMessage())
//                .globalResponses(HttpMethod.DELETE, getGlobalResponseMessage())
//                .globalResponses(HttpMethod.PUT, getGlobalResponseMessage())
                //添加登录认证
//                .securitySchemes(securitySchemes())
//                .securityContexts(securityContexts());
    }

    /**
     * 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
     */
    private ApiInfo apiInfo() {
        // 获取工程名称
        String projectName = System.getProperty("user.dir");
        return new ApiInfoBuilder()
                .title(projectName.substring(projectName.lastIndexOf("\\") + 1))
                .contact(new Contact("wuyongqiang", "", "473664742@qq.com"))
                .version("1.0")
                .description(componentName+":  API文档")
                .build();
    }

    /**
     * 生成通用响应信息
     */
    private List<Response> getGlobalResponseMessage() {
        List<Response> responseList = new ArrayList<>();
        responseList.add(new ResponseBuilder().code("404").description("找不到资源").build());
        return responseList;
    }

    /**
     * 设置授权信息
     */
    private List<SecurityScheme> securitySchemes() {
        ApiKey apiKey = new ApiKey("tfToken", "token", "header");
        return Collections.singletonList(apiKey);
    }

    /**
     * 授权信息全局应用
     */
    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(Collections.singletonList(new SecurityReference("tfToken", new AuthorizationScope[]{new AuthorizationScope("global", "accessEverything")})))
                        .build()
        );
    }
}
