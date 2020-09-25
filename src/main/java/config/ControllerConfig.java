package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.LoginController;
import controller.RegisterController;
import springBulletinBoard.service.StudentRegisterService;

@Configuration
public class ControllerConfig {
	@Autowired
	StudentRegisterService studentRegSvc;

	@Bean
	public LoginController loginController() {
		LoginController loginController = new LoginController();
		return loginController;
	}

	@Bean
	public RegisterController registerController() {
		RegisterController registerController = new RegisterController();
		registerController.setStudentRegisterService(studentRegSvc);
		return registerController;
	}

}
