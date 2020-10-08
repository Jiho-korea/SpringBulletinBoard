package springBulletinBoard.vo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class LoginRequest {

	@NotBlank
	@Size(min = 8)
	private String sid;

	@NotBlank
	private String password;

	private boolean memory;

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

	public boolean isMemory() {
		return memory;
	}

	public void setMemory(boolean memory) {
		this.memory = memory;
	}

}
