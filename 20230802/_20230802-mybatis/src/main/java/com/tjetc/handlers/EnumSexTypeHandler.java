package com.tjetc.handlers;

import com.tjetc.enums.EnumSex;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//处理自定义EnumSex枚举类型
public class EnumSexTypeHandler implements TypeHandler<EnumSex> {
//    jdbc设置参数 javatype转换成jdbctype -----> EnumSex 转成 int

    /**
     * 设置参数（一般会在insertupdate触发）
     *
     * @param ps        jdbc操作ps对象
     * @param i         表示要设置第儿个参数
     * @param parameter 参数值
     * @param jdbcType  jdbc类型
     * @throws SQLException
     */
    @Override
    public void setParameter(PreparedStatement ps, int i, EnumSex parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter.getCode());
    }

    /**
     * jdbc type转换java type (int ---> EnumSex)（一般用于查询
     *
     * @param rs         结果集
     * @param columnName 结果集sex列名
     * @return
     * @throws SQLException
     */
    @Override
    public EnumSex getResult(ResultSet rs, String columnName) throws SQLException {
        Integer sexCode = (Integer) rs.getObject(columnName);
        return EnumSex.getByCode(sexCode);
    }

    @Override
    public EnumSex getResult(ResultSet rs, int columnIndex) throws SQLException {
        Integer sexCode = (Integer) rs.getObject(columnIndex);
        return EnumSex.getByCode(sexCode);
    }

    @Override
    public EnumSex getResult(CallableStatement cs, int columnIndex) throws SQLException {
        Integer sexCode = (Integer) cs.getObject(columnIndex);
        return EnumSex.getByCode(sexCode);
    }
}
