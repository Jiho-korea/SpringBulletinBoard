package springBulletinBoard.service;

import springBulletinBoard.dao.StudentDAO;
import springBulletinBoard.exception.DuplicateStudentException;
import springBulletinBoard.exception.StudentRegisterException;
import springBulletinBoard.vo.RegisterRequest;
import springBulletinBoard.vo.Student;

public class StudentRegisterService {
	private StudentDAO studentDAO;

	public StudentRegisterService(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public int regist(RegisterRequest req) {
		Student student = studentDAO.selectBySid(req.getSid());

		if (student != null) {
			throw new DuplicateStudentException("dup sid : " + req.getSid());
		}

		Student newStudent = new Student(req.getSid(), req.getName(), req.getPassword(), req.getGrade(),
				req.getSubject());

		int result = studentDAO.insertStudent(newStudent);
		if (result == 1) {
			return newStudent.getSid();
		} else {
			throw new StudentRegisterException("regist fail : " + newStudent.getSid());
		}
	}

}
