package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
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
	public String login(@Valid LoginRequest loginRequest, Errors errors, HttpSession session) {
		if (errors.hasErrors()) {
			return "login/loginFormPage";
		}

		try {
			Student student = loginService.login(loginRequest);
			if (loginRequest.isMemory() == true) {
				session.setAttribute("memory", student.getSid());
			} else {
				session.removeAttribute("memory");
			}
			session.setAttribute("login", student);
			return "main/mainPage";
		} catch (StudentNotFoundException e) {
			errors.reject("notfound");
			return "login/loginFormPage";
		}
	}
}
