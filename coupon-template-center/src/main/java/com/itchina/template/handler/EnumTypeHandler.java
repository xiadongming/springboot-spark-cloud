package com.itchina.template.handler;

import com.itchina.common.constant.CodeBaseEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Optional;

/**
 * @Date: 2021/4/11 10:09
 * @Desc:
 */
@MappedTypes({CodeBaseEnum.class})
public  class   EnumTypeHandler<E extends Enum<?> & CodeBaseEnum> implements TypeHandler<E> {
    private Class<E> type;

    public EnumTypeHandler(Class<E> type) {
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
            ps.setInt(i, parameter.code());
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

    private E enumOf(int code) {
        final Optional<E> codedEnumOpt = CodeBaseEnum.codeOf(type, code);
        if (codedEnumOpt.isPresent()) {
            return codedEnumOpt.get();
        } else {
            throw new IllegalArgumentException("Cannot convert " + code + " to " + type.getSimpleName() + " by code value.");
        }
    }
}
