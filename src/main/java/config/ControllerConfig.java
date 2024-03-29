package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.BoardController;
import controller.LoginController;
import controller.LogoutController;
import controller.RegisterController;
import springBulletinBoard.service.LoginService;
import springBulletinBoard.service.PostListService;
import springBulletinBoard.service.StudentRegisterService;

@Configuration
public class ControllerConfig {
	@Autowired
	StudentRegisterService studentRegSvc;

	@Autowired
	LoginService loginSvc;

	@Autowired
	PostListService postListService;

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

	@Bean
	public BoardController boardController() {
		BoardController boardController = new BoardController();
		boardController.setPostListService(postListService);
		return boardController;
	}

}
