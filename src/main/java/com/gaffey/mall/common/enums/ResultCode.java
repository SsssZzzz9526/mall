package com.gaffey.mall.common.enums;

import com.gaffey.mall.common.api.IErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 结果枚举
 *
 * @author gaffey
 * @created 2020-09-17 23:48:00
 */
@Getter
@AllArgsConstructor
public enum ResultCode implements IErrorCode {
    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),

    /**
     * 操作失败
     */
    FAILED(500, "操作失败"),

    /**
     * 参数检验失败
     */
    VALIDATE_FAILED(404, "参数检验失败"),

    /**
     * 暂未登录或token已经过期
     */
    UNAUTHORIZED(401, "暂未登录或token已经过期"),

    /**
     * 没有相关权限
     */
    FORBIDDEN(403, "没有相关权限");

    private final int code;

    private final String message;
}
