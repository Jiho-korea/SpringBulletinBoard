package controller;

import org.springframework.stereotype.Controller;
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

//	@PostMapping("/register/step2")
//	public String registerStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree,
//			@RequestParam(value = "_agree", required = true) String _agree, RegisterRequest registerRequest) {
//		// RequestParam or 커맨드 객체 에는 _agree 만 두고 agree는 reqeust 객체에서 꺼내쓰는 용도?
//		if (agree) {
//			return "register/registerStep2";
//		}
//		if (_agree.equals("on")) {
//			return "redirect:/login/login";
//		}
//
//		return "register/registerStep2";
//	}

//	@PostMapping("/register/step2")
//	public String registerStep2(Checkbox checkbox, @RequestParam(value = "_agree", required = true) String _agree,
//			RegisterRequest registerRequest) {
////	 커맨드 객체 에   agree,_agree 둘다 두고  agree는 객체가  reqeust 영역에 있을 때 꺼내쓰는 용도로 _agree 가 있는 건가? defaultvalue랑 기능은 똑같은데?
//		if (checkbox.getAgree() == null) {
//			return "register/registerStep2";
//		}
//		if (_agree.equals("on")) {
//			return "redirect:/login/login";
//		}
//
//		return "register/registerStep2";
//	}

	@PostMapping("/register/step3")
	public String registerStep3(RegisterRequest regReq) {
		try {
			studentRegisterService.regist(regReq);
			return "register/registerStep3";
		} catch (DuplicateStudentException ex) {
			return "register/registerStep2";
		}
	}

}
