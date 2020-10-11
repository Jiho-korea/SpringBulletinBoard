package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springBulletinBoard.exception.StudentNotFoundException;
import springBulletinBoard.service.LoginService;
import springBulletinBoard.vo.LoginRequest;
import springBulletinBoard.vo.Student;

@Controller
@RequestMapping("/login/login")
public class LoginController {
	LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@GetMapping
	public String loginForm(LoginRequest loginRequest, @CookieValue(value = "memory", required = false) Cookie cookie) {
		// 쿠키를 이용한 아이디 기억하기
		if (cookie != null) {
			loginRequest.setSid(cookie.getValue());
			loginRequest.setMemory(true);
		}
		return "login/loginFormPage";
	}

	@PostMapping
	public String login(@Valid LoginRequest loginRequest, Errors errors, HttpSession session,
			HttpServletResponse response) {
		if (errors.hasErrors()) {
			return "login/loginFormPage";
		}

		try {
			Student student = loginService.login(loginRequest);
			session.setAttribute("login", student);

			Cookie memoryCookie = new Cookie("memory", loginRequest.getSid());
			memoryCookie.setPath("/");
			if (loginRequest.isMemory()) {
				memoryCookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				memoryCookie.setMaxAge(0);
			}
			response.addCookie(memoryCookie);

			return "main/mainPage";
		} catch (StudentNotFoundException e) {
			errors.reject("notfound");
			return "login/loginFormPage";
		}
	}
}
