package com.gaffey.mall.config;

import cn.hutool.core.collection.CollUtil;
import com.gaffey.mall.modules.ums.model.UmsResource;
import com.gaffey.mall.modules.ums.service.UmsAdminService;
import com.gaffey.mall.modules.ums.service.UmsResourceService;
import com.gaffey.mall.security.component.DynamicSecurityService;
import com.gaffey.mall.security.config.BaseSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mall安全配置
 *
 * @author gaffey
 * @created 2020-09-17 23:57:00
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MallSecurityConfig extends BaseSecurityConfig {
    @Autowired
    private UmsAdminService adminService;

    @Autowired
    private UmsResourceService resourceService;

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return adminService::loadUserByUsername;
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return () -> {
            List<UmsResource> resourceList = resourceService.list();
            List<String> collect = resourceList.stream().map(item -> String.format("%s:%s", item.getId(), item.getName())).collect(Collectors.toList());
            HashSet<String> set = CollUtil.newHashSet(collect);
            System.out.println(collect.size() + ":" + set.size());
            return resourceList.stream().collect(Collectors.toMap(
                    UmsResource::getUrl,
                    resource -> new SecurityConfig(String.format("%s:%s", resource.getId(), resource.getName()))
            ));
        };
    }
}
