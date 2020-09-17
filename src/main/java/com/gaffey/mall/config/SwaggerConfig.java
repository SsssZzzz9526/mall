package com.gaffey.mall.config;

import com.gaffey.mall.common.config.BaseSwaggerConfig;
import com.gaffey.mall.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerAPI文档配置
 *
 * @author gaffey
 * @created 2020-09-17 21:45:00
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    protected SwaggerProperties buildSwaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.gaffey.mall.modules")
                .title("mall项目")
                .description("mall项目接口文档")
                .contactName("gaffey")
                .version("0.0.1")
                .enableSecurity(true)
                .build();
    }
}
