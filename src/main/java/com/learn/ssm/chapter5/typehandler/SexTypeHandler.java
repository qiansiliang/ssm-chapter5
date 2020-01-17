package com.learn.ssm.chapter5.typehandler;


import com.learn.ssm.chapter5.enumeration.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SexTypeHandler extends BaseTypeHandler<SexEnum> {
	@Override
	public void setNonNullParameter(PreparedStatement ps, int index, SexEnum sex, JdbcType jdbcType) throws SQLException {
		ps.setInt(index, sex.getId());
	}

	@Override
	public SexEnum getNullableResult(ResultSet rs, String s) throws SQLException {
		int sexId = rs.getInt(s);
		return SexEnum.getSexById(sexId);
	}

	@Override
	public SexEnum getNullableResult(ResultSet rs, int index) throws SQLException {
		int sexId = rs.getInt(index);
		return SexEnum.getSexById(sexId);
	}

	@Override
	public SexEnum getNullableResult(CallableStatement cs, int index) throws SQLException {
		int sexId = cs.getInt(index);
		return SexEnum.getSexById(sexId);
	}
}
