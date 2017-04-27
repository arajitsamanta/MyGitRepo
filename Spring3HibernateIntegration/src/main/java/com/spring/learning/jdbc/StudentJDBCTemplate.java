/**
 * 
 */
package com.spring.learning.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author as47775
 *
 */
public class StudentJDBCTemplate implements StudentDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.spring.learning.jdbc.StudentDAO#setDataSource(javax.sql.DataSource)
	 */
	// @Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		System.out.println("Setting DataSource:" + dataSource);
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spring.learning.jdbc.StudentDAO#create(java.lang.String,
	 * java.lang.Integer)
	 */
	@Override
	public void create(String name, Integer age) {
		// TODO Auto-generated method stub
		String SQL = "insert into Student (name, age) values (?, ?)";

		jdbcTemplateObject.update(SQL, name, age);
		System.out.println("Created Record Name = " + name + " Age = " + age);
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spring.learning.jdbc.StudentDAO#getStudent(java.lang.Integer)
	 */
	@Override
	public StudentBean getStudent(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "select * from Student where id = ?";
		StudentBean student = jdbcTemplateObject.queryForObject(SQL,
				new Object[] { id }, new StudentMapper());
		return student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spring.learning.jdbc.StudentDAO#listStudents()
	 */
	@Override
	public List<StudentBean> listStudents() {
		// TODO Auto-generated method stub
		String SQL = "select * from Student";
		List<StudentBean> students = jdbcTemplateObject.query(SQL,
				new StudentMapper());
		return students;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spring.learning.jdbc.StudentDAO#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {
		String SQL = "delete from Student where id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id);
		return;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spring.learning.jdbc.StudentDAO#update(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public void update(Integer id, Integer age) {
		// TODO Auto-generated method stub
		String SQL = "update Student set age = ? where id = ?";
		jdbcTemplateObject.update(SQL, age, id);
		System.out.println("Updated Record with ID = " + id);
		return;

	}

	public void createStudentMarks(String name, Integer age, Integer marks,
			Integer year) {

		try {
			String SQL1 = "insert into Student (name, age) values (?, ?)";
			jdbcTemplateObject.update(SQL1, name, age);

			// Get the latest student id to be used in Marks table
			String SQL2 = "select max(id) from Student";
			int sid = jdbcTemplateObject.queryForInt(SQL2);

			String SQL3 = "insert into Marks(sid, marks, year) "
					+ "values (?, ?, ?)";
			jdbcTemplateObject.update(SQL3, sid, marks, year);

			System.out.println("Created Name = " + name + ", Age = " + age);
			// to simulate the exception.
			//throw new RuntimeException("simulate Error condition");
		} catch (DataAccessException e) {
			System.out.println("Error in creating record, rolling back");
			throw e;
		}
	}

	public List<StudentMarks> listStudentMarks() {
		String SQL = "select * from Student, Marks where Student.id=Marks.sid";

		List<StudentMarks> studentMarks = jdbcTemplateObject.query(SQL,
				new StudentMarksMapper());
		return studentMarks;
	}

}
