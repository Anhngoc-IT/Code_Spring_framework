package VTI.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import VTI.entity.User;

public class UserDTO {
	@Email(regexp = "(\\w+|\\d+)@\\w.+", message = "Sai định dạng email!")
	private String email;

	@Size(min = 6, max = 50, message = "Độ dài phải lớn hơn 6 & nhỏ hơn 50!")
	private String userName;

	@Size(min = 6, max = 800, message = "Độ dài phải lớn hơn 6 & nhỏ hơn 800!")
	private String password;

	private String fisrtName;

	private String lastName;

	private String phone;

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public UserDTO(@Email(regexp = "(\\w+|\\d+)@\\w.+", message = "Sai định dạng email!") String email,
			@Size(min = 6, max = 50, message = "Độ dài phải lớn hơn 6 & nhỏ hơn 50!") String userName,
			@Size(min = 6, max = 800, message = "Độ dài phải lớn hơn 6 & nhỏ hơn 800!") String password,
			String fisrtName, String lastName, String phone) {
		super();
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.phone = phone;
	}
	
	public User toEntity() {
		return new User((short) 0, email, userName, password, fisrtName, lastName, phone);
	}
	
	

}
