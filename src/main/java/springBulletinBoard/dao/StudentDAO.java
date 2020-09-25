package springBulletinBoard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import springBulletinBoard.vo.Student;

// DB STUDENT 테이블에 접근하는 DAO
public class StudentDAO {
	private JdbcTemplate jdbcTemplate;

	public StudentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Student selectBySid(int sid) {
		Student student = jdbcTemplate.queryForObject("SELECT * FROM student WHERE SID = ?", new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student(rs.getInt("SID"), rs.getString("NAME"), rs.getString("PASSWORD"),
						rs.getInt("GRADE"), rs.getString("SUBJECT"));
				return student;
			}
		}, sid);

		return student;

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

	public int insertStudent(Student pStudent) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO student(SID,NAME,PASSWORD,GRADE,SUBJECT,MANAGER) VAlUES(?, ?, ?, #{grade}, #{subject}, 0)");
				// 인덱스 파라미터 값 설정
				pstmt.setInt(1, pStudent.getSid());
				pstmt.setString(2, pStudent.getName());
				pstmt.setString(3, pStudent.getPassword());
				pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}
		});

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
