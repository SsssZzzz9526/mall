package com.gaffey.mall.modules.ums.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 管理员登陆DTO
 * @author gaffey
 * @created 2020-09-17 22:14:00
 */
@Data
public class LoginAdminRequest {

    @NotEmpty
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @NotEmpty
    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
