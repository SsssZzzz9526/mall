package com.gaffey.mall.modules.ums.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gaffey.mall.common.dto.PagingCondition;
import com.gaffey.mall.common.exception.MallException;
import com.gaffey.mall.modules.ums.dto.LoginAdminRequest;
import com.gaffey.mall.modules.ums.dto.RegisterAdminRequest;
import com.gaffey.mall.modules.ums.dto.UpdateAdminPasswordRequest;
import com.gaffey.mall.modules.ums.mapper.UmsAdminMapper;
import com.gaffey.mall.modules.ums.model.UmsAdmin;
import com.gaffey.mall.modules.ums.model.UmsResource;
import com.gaffey.mall.modules.ums.model.UmsRole;
import com.gaffey.mall.modules.ums.service.UmsAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author gaffey
 * @since 2020-09-17
 */
@Slf4j
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UmsAdmin register(RegisterAdminRequest registerAdminRequest) {
        // 参数转换
        UmsAdmin umsAdmin = registerAdminRequest.convert();
        // 查询是否存在同名用户
        QueryWrapper<UmsAdmin> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(UmsAdmin::getUsername, umsAdmin.getUsername());
        Optional.ofNullable(getOne(wrapper)).ifPresent(admin -> {
            throw new MallException();
        });
        // 密码加密
        umsAdmin.setPassword(passwordEncoder.encode(umsAdmin.getPassword()));
        // 入库
        this.getBaseMapper().insert(umsAdmin);
        return umsAdmin;
    }

    @Override
    public String login(LoginAdminRequest loginAdminRequest) {
        return null;
    }

    @Override
    public String refreshToken(String oldToken) {
        return null;
    }

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        return null;
    }

    @Override
    public Page<UmsAdmin> listAdminsByKeyword(String keyword, PagingCondition pageCondition) {
        return null;
    }

    @Override
    public boolean update(Long adminId, UmsAdmin admin) {
        return false;
    }

    @Override
    public boolean delete(Long adminId) {
        return false;
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        return 0;
    }

    @Override
    public List<UmsRole> listRolesByAdminId(Long adminId) {
        return null;
    }

    @Override
    public List<UmsResource> listResourcesByAdminId(Long adminId) {
        return null;
    }

    @Override
    public boolean updatePassword(UpdateAdminPasswordRequest updatePasswordParam) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return null;
    }
}
