package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("/login/login")
	public String loginForm() {
		return "login/loginFormPage";
	}

	@PostMapping("/login/login")
	public String login() {
		return "login/login";
	}
}
