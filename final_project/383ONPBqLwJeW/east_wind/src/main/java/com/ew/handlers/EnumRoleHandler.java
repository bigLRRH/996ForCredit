package com.ew.handlers;

import com.ew.enums.Role;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnumRoleHandler implements TypeHandler<Role> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Role parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i,parameter.getRoleCode());
    }

    @Override
    public Role getResult(ResultSet rs, String columnName) throws SQLException {
        return Role.getRole(rs.getInt(columnName));
    }

    @Override
    public Role getResult(ResultSet rs, int columnIndex) throws SQLException {
        return Role.getRole(rs.getInt(columnIndex));
    }

    @Override
    public Role getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return Role.getRole(cs.getInt(columnIndex));
    }
}
