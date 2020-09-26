package springBulletinBoard.service;

import springBulletinBoard.dao.StudentDAO;
import springBulletinBoard.exception.StudentNotFoundException;
import springBulletinBoard.vo.LoginRequest;
import springBulletinBoard.vo.Student;

public class LoginService {
	private StudentDAO studentDAO;

	public LoginService(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public Student login(LoginRequest loginRequest) {
		Student loginStudent = studentDAO.selectBySidPassword(loginRequest);
		if (loginStudent == null) {
			throw new StudentNotFoundException("not found " + loginRequest.getSid());
		}

		return loginStudent;
	}

}
