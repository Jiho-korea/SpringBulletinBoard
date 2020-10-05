package springBulletinBoard.vo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class RegisterRequest {
	@NotBlank
	private String name;
	@NotBlank
	@Size(min = 8)
	private String sid;
	@NotBlank
	private String password;
	@NotBlank
	private String confirmPassword;
	@NotBlank
	private String grade;
	@NotBlank
	private String subject;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public boolean isPasswordEqualToConfirmPassword() {
		return password.equals(confirmPassword);
	}
}
