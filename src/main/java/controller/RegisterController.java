package controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springBulletinBoard.exception.DuplicateStudentException;
import springBulletinBoard.service.StudentRegisterService;
import springBulletinBoard.vo.RegisterRequest;

@Controller
public class RegisterController {
	StudentRegisterService studentRegisterService;

	public void setStudentRegisterService(StudentRegisterService studentRegisterService) {
		this.studentRegisterService = studentRegisterService;
	}

	@RequestMapping("/register/step1")
	public String registerStep1() {
		return "register/registerStep1";
	}

	@GetMapping("/register/step2")
	public String registerStep2Get() {
		return "redirect:/register/step1";
	}

	@GetMapping("/register/step3")
	public String registerStep3Get() {
		return "redirect:/register/step1";
	}

	@PostMapping("/register/step2")
	public String registerStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree,
			RegisterRequest registerRequest) {
		if (!agree) {
			return "register/registerStep1";
		}

		return "register/registerStep2";
	}

	@PostMapping("/register/step3")
	public String registerStep3(@Valid RegisterRequest regReq, Errors errors) {
		if (errors.hasErrors()) {
			return "register/registerStep2";
		}

		try {
			studentRegisterService.regist(regReq);
			return "register/registerStep3";
		} catch (DuplicateStudentException ex) {
			errors.rejectValue("sid", "duplicate");
			return "register/registerStep2";
		}
	}

}
