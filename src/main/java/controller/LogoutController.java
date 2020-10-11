package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springBulletinBoard.vo.LoginRequest;

@Controller
public class LogoutController {
	@RequestMapping("/logout")
	public String boardList(LoginRequest loginRequest, HttpSession session) {
		session.removeAttribute("login");
		return "login/loginFormPage";
	}
}
