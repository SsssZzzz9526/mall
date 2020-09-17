package com.gaffey.mall.modules.ums.dto;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.gaffey.mall.common.enums.AdminStatusEnum;
import com.gaffey.mall.modules.ums.model.UmsAdmin;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * 管理员注册请求DTO
 * @author gaffey
 * @created 2020-09-17 22:08:00
 */
@Data
public class RegisterAdminRequest {
    @NotEmpty
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @NotEmpty
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "头像")
    private String icon;

    @Email
    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "备注")
    private String note;

    /**
     * <p>
     * 将当前对象转化为UmsAdmin
     * </p>
     * @param
     * @return com.gaffey.mall.modules.ums.model.UmsAdmin
     * @author gaffey
     * @since 2020/9/17 23:24
     */
    public UmsAdmin convert() {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtil.copyProperties(this, umsAdmin, CopyOptions.create().setIgnoreNullValue(true));
        umsAdmin.setStatus(AdminStatusEnum.ENABLE);
        umsAdmin.setCreateTime(new Date());
        return umsAdmin;
    }
}
