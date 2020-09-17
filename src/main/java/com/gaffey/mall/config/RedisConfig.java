package com.gaffey.mall.config;

import com.gaffey.mall.common.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Redis配置类
 *
 * @author gaffey
 * @created 2020-09-17 21:18:00
 */
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {
}
