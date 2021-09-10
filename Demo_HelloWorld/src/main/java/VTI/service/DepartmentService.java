package VTI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VTI.entity.Department;
import VTI.entity.Parameters;
import VTI.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	// dựa trên interface DepartmentRepository, 
	// nó sẽ tìm đến đối tượng nào implements interface IDepartmentRepository
	// @Au... là thư viện spring framework
	@Autowired  // nó sẽ khởi tạo một đối tượng mới của thằng bên dưới để sử dụng các phương thưc
	IDepartmentRepository IDepartmentRepository ;
	
	@Override
	public List<Department> getAllDepartment(Parameters parameters) {
		
		return IDepartmentRepository.getAllDepartment(parameters);
	}

	@Override
	public Department getDepartmentById(short id) {
		// TODO Auto-generated method stub
		return IDepartmentRepository.getDepartmentById(id);
	}

	@Override
	public void CreateDepartment(Department department) {
		
		IDepartmentRepository.CreateDepartment(department);
		
	}

	@Override
	public void UpdateDepartment(short id, String name) {
		
		IDepartmentRepository.UpdateDepartment(id, name);
		
	}

	@Override
	public void DeleteDepartment(short id) {
		
		IDepartmentRepository.DeleteDepartment(id);
		
	}

}
