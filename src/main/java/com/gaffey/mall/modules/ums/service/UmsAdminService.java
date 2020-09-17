package com.gaffey.mall.modules.ums.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gaffey.mall.common.dto.PagingCondition;
import com.gaffey.mall.common.exception.MallException;
import com.gaffey.mall.modules.ums.dto.LoginAdminRequest;
import com.gaffey.mall.modules.ums.dto.RegisterAdminRequest;
import com.gaffey.mall.modules.ums.dto.UpdateAdminPasswordRequest;
import com.gaffey.mall.modules.ums.model.UmsAdmin;
import com.gaffey.mall.modules.ums.model.UmsResource;
import com.gaffey.mall.modules.ums.model.UmsRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author gaffey
 * @since 2020-09-17
 */
public interface UmsAdminService extends IService<UmsAdmin> {
    /**
     * <p>
     * 管理员注册
     * </p>
     * @param registerAdminRequest 注册信息
     * @return com.gaffey.mall.modules.ums.model.UmsAdmin
     * @author gaffey
     * @since 2020/9/17 22:13
     */
    UmsAdmin register(RegisterAdminRequest registerAdminRequest);

    /**
     * <p>
     * 管理员登陆
     * </p>
     * @param loginAdminRequest 登录信息
     * @return java.lang.String 生成JWT的token
     * @author gaffey
     * @since 2020/9/17 22:14
     */
    String login(LoginAdminRequest loginAdminRequest);

    /**
     * <p>
     * 刷新token
     * </p>
     * @param oldToken 原始token
     * @return java.lang.String
     * @author gaffey
     * @since 2020/9/17 22:15
     */
    String refreshToken(String oldToken);

    /**
     * <p>
     * 根据用户名查询管理员
     * </p>
     * @param username 用户名
     * @return com.gaffey.mall.modules.ums.model.UmsAdmin
     * @author gaffey
     * @since 2020/9/17 22:06
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * <p>
     * 根据关键字分页查询管理员
     * </p>
     * @param keyword 关键字 [用户名 | 昵称]
     * @param pageCondition 分页条件 [页数 & 每页显示条目数]
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.gaffey.mall.modules.ums.model.UmsAdmin>
     * @author gaffey
     * @since 2020/9/17 22:47
     */
    Page<UmsAdmin> listAdminsByKeyword(String keyword, PagingCondition pageCondition);

    /**
     * <p>
     * 更新管理员信息
     * </p>
     * @param adminId 管理员ID
     * @param admin 更新信息
     * @return boolean
     * @author gaffey
     * @since 2020/9/17 22:18
     */
    boolean update(Long adminId, UmsAdmin admin);

    /**
     * <p>
     * 删除指定用户
     * </p>
     * @param adminId 管理员ID
     * @return boolean
     * @author gaffey
     * @since 2020/9/17 22:18
     */
    boolean delete(Long adminId);

    /**
     * <p>
     * 修改用户角色关系
     * </p>
     * @param adminId 管理员ID
     * @param roleIds 角色ID
     * @return int 影响行数
     * @author gaffey
     * @since 2020/9/17 22:19
     */
    @Transactional(rollbackFor = MallException.class)
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * <p>
     * 获取指定管理员对应角色
     * </p>
     * @param adminId 管理员ID
     * @return java.util.List<com.gaffey.mall.modules.ums.model.UmsRole>
     * @author gaffey
     * @since 2020/9/17 22:23
     */
    List<UmsRole> listRolesByAdminId(Long adminId);

    /**
     * <p>
     * 获取指定管理员的可访问资源
     * </p>
     * @param adminId 管理员ID
     * @return java.util.List<com.gaffey.mall.modules.ums.model.UmsResource>
     * @author gaffey
     * @since 2020/9/17 22:23
     */
    List<UmsResource> listResourcesByAdminId(Long adminId);

    /**
     * <p>
     * 修改密码
     * </p>
     * @param updatePasswordParam 修改密码
     * @return boolean
     * @author gaffey
     * @since 2020/9/17 22:34
     */
    boolean updatePassword(UpdateAdminPasswordRequest updatePasswordParam);

    /**
     * <p>
     * 根据用户名获取管理员信息
     * </p>
     * @param username
     * @return UserDetails
     * @author gaffey
     * @since 2020/9/17 22:35
     */
    UserDetails loadUserByUsername(String username);
}
