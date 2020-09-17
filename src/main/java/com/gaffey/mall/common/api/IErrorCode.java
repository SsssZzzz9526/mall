package com.gaffey.mall.common.api;

/**
 * 错误码
 *
 * @author gaffey
 * @created 2020-09-17 23:51:00
 */
public interface IErrorCode {

    /**
     * <p>
     * 返回错误码
     * </p>
     * @return int
     * @author gaffey
     * @since 2020/9/17 23:52
     */
    int getCode();

    /**
     * <p>
     * 返回错误信息
     * </p>
     * @param
     * @return java.lang.String
     * @author gaffey
     * @since 2020/9/17 23:52
     */
    String getMessage();
}
