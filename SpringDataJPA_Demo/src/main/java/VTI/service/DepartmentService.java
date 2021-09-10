package VTI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import VTI.entity.Department;
import VTI.entity.Parameters;
import VTI.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	
	private IDepartmentRepository repository;
	
	

	@Override
	public List<Department> getAllDepartment(Parameters parameters) {
		// Sắp xếp và phân trang
		
		Pageable pageable = null;
		if(parameters.page >=0 && parameters.pageSize >0 
				&& parameters.field != null && !parameters.field.isEmpty() ) {
			
			if(parameters.typeSort != null && !parameters.typeSort.isEmpty() && parameters.typeSort.equals("DESC")) {
				
				// b1 : khai báo pageable
				pageable = 	 PageRequest.of(parameters.page, parameters.pageSize ,Sort.by(parameters.field).descending());
				
			}else {
				
				pageable = 	 PageRequest.of(parameters.page, parameters.pageSize ,Sort.by(parameters.field).ascending());
				
			}
			return repository.findAll(pageable).toList();
		}else if(parameters.page >=0 && parameters.pageSize >0 ) {
			pageable = PageRequest.of(parameters.page, parameters.pageSize);
			return repository.findAll(pageable).toList();
		}else {
			
			return repository.findAll();
		}		
		
	}

	@Override
	public Department getDepartmentById(short id) {
		
		return repository.getById(id);
	}
	
	@Override
	public Department getDepartmentByName(String name) {
		
		return repository.findByName(name);
	}

	@Override
	public void CreateDepartment(Department department) {
		
		repository.save(department);
		
	}

	@Override
	public void UpdateDepartment(short id, String newName) {
		
		Department dept = new Department();
		
		dept.setId(id);
		dept.setName(newName);
		
		repository.save(dept);
		
	}

	@Override
	public void DeleteDepartment(short id) {
		
		repository.deleteById(id);
	}

	@Override
	public boolean isDepartmentExistsByName(String name) {
		
		return repository.existsByName(name);
	}

	@Override
	public boolean isDepartmentExistsById(short id) {
		
		return repository.existsById(id);
	}

	
}
