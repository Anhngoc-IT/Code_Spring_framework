package VTI.repository;

import java.util.List;

import VTI.entity.Department;
import VTI.entity.Parameters;

public interface IDepartmentRepository {

	public List<Department> getAllDepartment(Parameters parameters);
	
	public Department getDepartmentById(short id);
	
	public void CreateDepartment(Department department);
	
	public void UpdateDepartment(short id, String name);
	
	public void DeleteDepartment(short id);
	
}
