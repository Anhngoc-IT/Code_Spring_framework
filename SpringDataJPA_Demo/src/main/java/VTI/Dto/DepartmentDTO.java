package VTI.Dto;

// dựa trên entity , để lấy ra dánh sách 
import VTI.entity.Department;

public class DepartmentDTO {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DepartmentDTO() {
	}

	public Department toEntity() {
		return new Department(name);
	}

}
