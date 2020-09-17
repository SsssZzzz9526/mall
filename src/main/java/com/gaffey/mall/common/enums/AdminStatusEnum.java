package com.gaffey.mall.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * 管理员状态
 * </p>
 *
 * @author gaffey
 * @since 2020-09-17
 */
@Getter
@AllArgsConstructor
public enum AdminStatusEnum implements BaseCodeEnum {
    /**
     * 可用
     */
    ENABLE(1, "可用"),

    /**
     * 不可用
     */
    DISABLED(0, "不可用")
    ;

    private final int code;

    private final String description;
}
