package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

	@GetMapping("/register/register")
	public String loginForm() {
		return "register/registerPage";
	}

	@PostMapping("/register/register")
	public String login() {
		return "register/registerPage";
	}
}
