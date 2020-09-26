package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import springBulletinBoard.exception.StudentNotFoundException;
import springBulletinBoard.service.LoginService;
import springBulletinBoard.vo.LoginRequest;
import springBulletinBoard.vo.Student;

@Controller
public class LoginController {
	LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@GetMapping("/login/login")
	public String loginForm(LoginRequest loginRequest) {
		return "login/loginFormPage";
	}

	@PostMapping("/login/login")
	public String login(LoginRequest loginRequest) {
		try {
			Student student = loginService.login(loginRequest);
			return "main/mainPage";
		} catch (StudentNotFoundException e) {
			return "login/loginFormPage";
		}
	}
}
