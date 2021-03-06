package com.gaffey.mall.common.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * <p>
 * 枚举类型公共接口
 * </p>
 *
 * @author gaffey
 * @since 2020-09-17
 */
public interface BaseCodeEnum {
    /**
     * <p>
     * 获取枚举类型code字段值
     * </p>
     * @return int
     * @author gaffey
     * @since 2020/9/17 22:59
     */
    int getCode();

    /**
     * <p>
     * 根据给定code在给定枚举class中寻找对应实例
     * </p>
     * @param enumClass  @param code
     * @return java.util.Optional<E>
     * @author gaffey
     * @since 2020/9/17 23:02
     */
    static <E extends Enum<?> & BaseCodeEnum>Optional<E> codeOf(Class<E> enumClass, int code) {
        return Arrays.stream(enumClass.getEnumConstants()).filter(e -> e.getCode() == code).findAny();
    }
}
