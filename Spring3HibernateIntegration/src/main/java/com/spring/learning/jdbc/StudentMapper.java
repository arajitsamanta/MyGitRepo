/**
 * 
 */
package com.spring.learning.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author as47775
 *
 */
public class StudentMapper implements RowMapper<StudentBean> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
	 * int)
	 */
	@Override
	public StudentBean mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		StudentBean student = new StudentBean();
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setAge(rs.getInt("age"));
		return student;
	}

}
