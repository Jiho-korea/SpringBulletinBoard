package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import springBulletinBoard.vo.RegisterRequest;

@Controller
public class RegisterController {
	MemberRegisterService memberRegisterService;

	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
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
	public String registerStep3(RegisterRequest regReq) {
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		} catch (DuplicateMemberException ex) {
			return "register/step2";
		}
	}

}
