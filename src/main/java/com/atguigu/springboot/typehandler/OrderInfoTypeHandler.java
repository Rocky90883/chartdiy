package com.atguigu.springboot.typehandler;

import com.atguigu.springboot.enums.OrderInfoEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author LinD
 * @Classname OrderInfoTypeHandler
 * @Description TODO
 * @date 2019/7/2 18:26
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(OrderInfoEnum.class)
public class OrderInfoTypeHandler extends BaseTypeHandler<OrderInfoEnum> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, OrderInfoEnum orderInfoEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,orderInfoEnum.getType());
    }

    @Override
    public OrderInfoEnum getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return OrderInfoEnum.getOrderInfoEnum(resultSet.getString(columnName));
    }

    @Override
    public OrderInfoEnum getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        return OrderInfoEnum.getOrderInfoEnum(resultSet.getString(columnIndex));
    }

    @Override
    public OrderInfoEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return OrderInfoEnum.getOrderInfoEnum(callableStatement.getString(i));
    }

}
