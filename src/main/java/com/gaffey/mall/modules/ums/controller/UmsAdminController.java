package com.gaffey.mall.modules.ums.controller;


import com.gaffey.mall.common.api.CommonResult;
import com.gaffey.mall.modules.ums.dto.RegisterAdminRequest;
import com.gaffey.mall.modules.ums.model.UmsAdmin;
import com.gaffey.mall.modules.ums.service.UmsAdminService;
import com.gaffey.mall.modules.ums.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author gaffey
 * @since 2020-09-17
 */
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RestController
@RequestMapping("/admin")
public class UmsAdminController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenPrefix}")
    private String tokenPrefix;

    private final UmsAdminService adminService;

    private final UmsRoleService roleService;

    public UmsAdminController(UmsAdminService adminService, UmsRoleService roleService) {
        this.adminService = adminService;
        this.roleService = roleService;
    }

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UmsAdmin> register(@Validated @RequestBody RegisterAdminRequest registerAdminRequest) {
        UmsAdmin umsAdmin = adminService.register(registerAdminRequest);
        if (umsAdmin == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }
}

