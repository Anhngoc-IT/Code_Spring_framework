package VTI.service;

import java.util.List;

import VTI.entity.Department;
import VTI.entity.Parameters;

public interface IDepartmentService {

	public List<Department> getAllDepartment(Parameters parameters);

	public Department getDepartmentById(short id);
	
	public Department getDepartmentByName(String name);

	public void CreateDepartment(Department department);

	public void UpdateDepartment(short id, String newName);

	public void DeleteDepartment(short id);
	
	public boolean isDepartmentExistsByName(String name);
	
	public boolean isDepartmentExistsById(short id);

	
}
