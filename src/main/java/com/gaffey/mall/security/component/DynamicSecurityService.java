package com.gaffey.mall.security.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * 动态权限相关业务
 *
 * @author gaffey
 * @created 2020-09-17 23:31:00
 */
public interface DynamicSecurityService {
    /**
     * <p>
     * 加载资源ANT通配符和资源对应MAP
     * </p>
     * @param
     * @return java.util.Map<java.lang.String,org.springframework.security.access.ConfigAttribute>
     * @author gaffey
     * @since 2020/9/17 23:31
     */
    Map<String, ConfigAttribute> loadDataSource();
}
