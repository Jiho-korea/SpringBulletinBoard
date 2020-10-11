package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.LoginController;
import controller.LogoutController;
import controller.RegisterController;
import springBulletinBoard.service.LoginService;
import springBulletinBoard.service.StudentRegisterService;

@Configuration
public class ControllerConfig {
	@Autowired
	StudentRegisterService studentRegSvc;

	@Autowired
	LoginService loginSvc;

	@Bean
	public LoginController loginController() {
		LoginController loginController = new LoginController();
		loginController.setLoginService(loginSvc);
		return loginController;
	}

	@Bean
	public RegisterController registerController() {
		RegisterController registerController = new RegisterController();
		registerController.setStudentRegisterService(studentRegSvc);
		return registerController;
	}

	@Bean
	public LogoutController logoutController() {
		LogoutController logoutController = new LogoutController();
		return logoutController;
	}

}
