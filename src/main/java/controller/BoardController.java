package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springBulletinBoard.service.StudentRegisterService;

@Controller
public class BoardController {
	StudentRegisterService studentRegisterService;

	public void setStudentRegisterService(StudentRegisterService studentRegisterService) {
		this.studentRegisterService = studentRegisterService;
	}

	@RequestMapping("/board/list")
	public String boardList() {
		return "board/boardPage";
	}
}
