package springBulletinBoard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import springBulletinBoard.vo.Student;

// DB STUDENT 테이블에 접근하는 DAO
public class StudentDAO {
	private JdbcTemplate jdbcTemplate;

	public StudentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Student selectBySid(int sid) {
		List<Student> results = jdbcTemplate.query("SELECT * FROM student WHERE SID = ?", new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student(rs.getInt("SID"), rs.getString("NAME"), rs.getString("PASSWORD"),
						rs.getInt("GRADE"), rs.getString("SUBJECT"));
				return student;
			}
		}, sid);

		return results.isEmpty() ? null : results.get(0);

	}

	public int insertStudent(Student student) {
		int result = jdbcTemplate.update(
				"INSERT INTO student(SID,NAME,PASSWORD,GRADE,SUBJECT,MANAGER) VAlUES(?, ?, ?, ?, ?, 0)",
				student.getSid(), student.getName(), student.getPassword(), student.getGrade(), student.getSubject());

		return result;
		// INSERT INTO student(SID,NAME,PASSWORD,GRADE,SUBJECT,MANAGER) VAlUES(#{sid},
		// #{name}, #{password}, #{grade}, #{subject}, 0)
		//
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		int success = 0;
//		try {
//			success = sqlSession.insert("org.mybatis.persistence.StudentMapper.insertStudent", pStudent);
//			sqlSession.commit();
//			return success;
//		} catch (Exception e) {
//			e.printStackTrace();
//			sqlSession.rollback();
//			return success;
//		} finally {
//			sqlSession.close();
//		}
	}

//	public Student selectBySidPassword(Student pStudent) {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		Student student = null;
//		try {
//			student = sqlSession.selectOne("org.mybatis.persistence.StudentMapper.selectBySidPassword", pStudent);
//			return student;
//		} catch (Exception e) {
//			e.printStackTrace();
//			sqlSession.rollback();
//			return student;
//		} finally {
//			sqlSession.close();
//		}
//	}

//
//	public static Student getWriter(int sid) {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		Student student = new Student();
//		student.setSid(sid);
//		try {
//			student = sqlSession.selectOne("org.mybatis.persistence.StudentMapper.selectBySid", student);
//
//			return student;
//		} catch (Exception e) {
//			e.printStackTrace();
//			sqlSession.rollback();
//			return student;
//		} finally {
//			sqlSession.close();
//		}
//	}
}
