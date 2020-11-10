package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springBulletinBoard.dao.PostDAO;
import springBulletinBoard.dao.StudentDAO;
import springBulletinBoard.service.LoginService;
import springBulletinBoard.service.PostListService;
import springBulletinBoard.service.StudentRegisterService;

@Configuration
@EnableTransactionManagement
public class StudentConfig {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/springbulletinboard?characterEncoding=utf8");
		ds.setUsername("root");
		ds.setPassword("1111");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}

	@Bean
	public StudentDAO studentDAO() {
		return new StudentDAO(dataSource());
	}

	@Bean
	public PostDAO postDAO() {
		return new PostDAO(dataSource());
	}

	@Bean
	public StudentRegisterService studentRegSvc() {
		return new StudentRegisterService(studentDAO());
	}

	@Bean
	public LoginService loginSvc() {
		return new LoginService(studentDAO());
	}

	@Bean
	public PostListService postListSvc() {
		return new PostListService(postDAO());
	}
//	@Bean
//	public ChangePasswordService changePwdSvc() {
//		ChangePasswordService pwdSvc = new ChangePasswordService();
//		pwdSvc.setMemberDao(memberDao());
//		return pwdSvc;
//	}
}
