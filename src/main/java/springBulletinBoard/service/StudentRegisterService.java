package springBulletinBoard.service;

import springBulletinBoard.dao.StudentDAO;
import springBulletinBoard.exception.DuplicateStudentException;
import springBulletinBoard.vo.RegisterRequest;
import springBulletinBoard.vo.Student;

public class StudentRegisterService {
	private StudentDAO studentDAO;

	public StudentRegisterService(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public Boolean regist(RegisterRequest req) {
		Student student = studentDAO.selectBySid(req.getSid());

		if (student != null) {
			throw new DuplicateStudentException("dup sid " + req.getSid());
		}

		Student newStudent = new Student(req.getSid(), req.getName(), req.getPassword(), req.getGrade(),
				req.getSubject());

		studentDAO.insertStudent(newStudent);
		return newMember.getId();
		if (checkRegistration == 1) {
			throw new DuplicateStudentException("dup sid " + student.getSid());
		}

		int updateCount = 0;
		updateCount = studentDAO.insertStudent(student);
		if (updateCount == 1) {
			return true;
		} else {
			throw new RuntimeException();
		}
	}

}
