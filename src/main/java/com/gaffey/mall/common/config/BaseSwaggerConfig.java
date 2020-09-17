package com.gaffey.mall.common.config;

import cn.hutool.core.collection.CollUtil;
import com.gaffey.mall.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

/**
 * Swagger基础配置
 *
 * @author gaffey
 * @created 2020-09-17 21:23:00
 */
public abstract class BaseSwaggerConfig {

    @Bean
    public Docket createRestApi() {
        SwaggerProperties swaggerProperties = buildSwaggerProperties();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo(swaggerProperties))
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getApiBasePackage())).paths(PathSelectors.any())
                .build();
        if (swaggerProperties.isEnableSecurity()) {
            docket.securitySchemes(buildSecuritySchemes())
                    .securityContexts(buildSecurityContexts());
        }
        return docket;
    }

    /**
     * <p> 
     * 子类构建自定义swagger配置
     * </p>
     * @param 
     * @return com.gaffey.mall.common.domain.SwaggerProperties
     * @author gaffey
     * @since 2020/9/17 21:28
     */
    protected abstract SwaggerProperties buildSwaggerProperties();

    /**
     * <p> 
     * 构建api信息
     * </p>
     * @param swaggerProperties
     * @return springfox.documentation.service.ApiInfo
     * @author gaffey
     * @since 2020/9/17 21:28
     */
    private ApiInfo buildApiInfo(SwaggerProperties swaggerProperties) {
        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .contact(new Contact(swaggerProperties.getContactName(), swaggerProperties.getContactUrl(), swaggerProperties.getContactEmail()))
                .version(swaggerProperties.getVersion())
                .build();
    }

    /**
     * <p> 
     * 构建安全方案
     * </p>
     * @param 
     * @return java.util.List<? extends springfox.documentation.service.SecurityScheme>
     * @author gaffey
     * @since 2020/9/17 21:36
     */
    private List<? extends SecurityScheme> buildSecuritySchemes() {
        return CollUtil.newArrayList(new ApiKey("Authorization", "Authorization", "header"));
    }

    /**
     * <p>
     * 构建安全上下文
     * </p>
     * @param
     * @return java.util.List<springfox.documentation.spi.service.contexts.SecurityContext>
     * @author gaffey
     * @since 2020/9/17 21:36
     */
    private List<SecurityContext> buildSecurityContexts() {
        return CollUtil.newArrayList(getContextByPath());
    }

    /**
     * <p> 
     * 根据路径表达式获取安全上下文
     * </p>
     * @return springfox.documentation.spi.service.contexts.SecurityContext
     * @author gaffey
     * @since 2020/9/17 21:44
     */
    private SecurityContext getContextByPath() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/*/.*"))
                .build();
    }

    /**
     * <p> 
     * 默认授权方式
     * </p>
     * @param 
     * @return java.util.List<springfox.documentation.service.SecurityReference>
     * @author gaffey
     * @since 2020/9/17 21:44
     */
    private List<SecurityReference> defaultAuth() {
        return CollUtil.newArrayList(new SecurityReference("Authorization",
                new AuthorizationScope[]{
                        new AuthorizationScope("global", "accessEverything")
                })
        );
    }
}
