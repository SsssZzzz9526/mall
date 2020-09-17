package com.gaffey.mall.common.typehandler;

import com.gaffey.mall.common.enums.BaseCodeEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;

/**
 * Mybatis自定义枚举类型处理器
 *
 * @author gaffey
 * @created 2020-09-17 23:06:00
 */
@MappedTypes(BaseCodeEnum.class)
public class BaseCodedEnumTypeHandler<E extends Enum<?> & BaseCodeEnum> implements TypeHandler<E> {
    private final Class<E> type;

    public BaseCodedEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        if (parameter == null) {
            ps.setNull(i, Types.TINYINT);
        } else {
            ps.setInt(i, parameter.getCode());
        }
    }

    @Override
    public E getResult(ResultSet rs, String columnName) throws SQLException {
        int columnValue = rs.getInt(columnName);
        return rs.wasNull() ? null : enumOf(columnValue);
    }

    @Override
    public E getResult(ResultSet rs, int columnIndex) throws SQLException {
        int columnValue = rs.getInt(columnIndex);
        return rs.wasNull() ? null : enumOf(columnValue);
    }

    @Override
    public E getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int columnValue = cs.getInt(columnIndex);
        return cs.wasNull() ? null : enumOf(columnValue);
    }

    /**
     * 根据code获取对应枚举实例
     * @param code code
     * @return 枚举实例，没找到则抛出IllegalArgumentException异常
     */
    private E enumOf(int code) {
        return BaseCodeEnum.codeOf(type, code)
                .orElseThrow(() -> new IllegalArgumentException("Cannot convert " + code + " to " + type.getSimpleName() + " by code value."));
    }
}
