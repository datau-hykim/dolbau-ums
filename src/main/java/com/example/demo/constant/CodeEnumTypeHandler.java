package com.example.demo.constant;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@Slf4j
@RequiredArgsConstructor
public abstract class CodeEnumTypeHandler<E extends CodeEnum> implements TypeHandler<CodeEnum> {
    private final Class<E> type;

    @Override
    public void setParameter(PreparedStatement ps, int i, CodeEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getKey());
    }

    @Override
    public CodeEnum getResult(ResultSet rs, String columnName) throws SQLException {
        String key = rs.getString(columnName);

        return Arrays.stream(type.getEnumConstants()).toList()
                .stream()
                .filter(type -> type.getKey().equals(key))
                .findAny()
                .orElse(null);
    }

    @Override
    public CodeEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        String key = rs.getString(columnIndex);

        return Arrays.stream(type.getEnumConstants()).toList()
                .stream()
                .filter(type -> type.getKey().equals(key))
                .findAny()
                .orElse(null);
    }

    @Override
    public CodeEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String key = cs.getString(columnIndex);

        return Arrays.stream(type.getEnumConstants()).toList()
                .stream()
                .filter(type -> type.getKey().equals(key))
                .findAny()
                .orElse(null);
    }
}
