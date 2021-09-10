package VTI.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Department {
	
	
	private short id;
	
	
	@Size(min = 6 , max = 50, message = "name cần có ít nhất từ 6-> 50 kí tự !")
	private String name;

	@Min(value = 0, message = "Totalmember  > 0")
	private short totalMember;
	
	@Email(regexp = "(\\ w+ |\\ \\ d+)@\\ \\ w.+", message = "Bạn sai định dạng email!")
	private String email;
	
	public Department() {
		
	}
	
	

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Department(String name2) {
		this.name = name2;
	}

	public short getId() {
		return id;
	}


	public void setId(short id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	public short getTotalMember() {
		return totalMember;
	}

	
	public void setTotalMember(short totalMember) {
		this.totalMember = totalMember;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", totalMember=" + totalMember + "]";
	}

}
