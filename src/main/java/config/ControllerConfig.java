package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.LoginController;

@Configuration
public class ControllerConfig {

	@Bean
	public LoginController loginController() {
		LoginController loginController = new LoginController();
		return loginController;
	}

}
