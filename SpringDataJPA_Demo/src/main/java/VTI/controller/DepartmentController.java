package VTI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import VTI.Dto.DepartmentDTO;
import VTI.entity.Department;
import VTI.entity.Parameters;
import VTI.service.IDepartmentService;


@RestController
@RequestMapping(value = "api/v2/departments")

public class DepartmentController {

	@Autowired
	private IDepartmentService service;
	
	// ResponseEntity là thư viên của java
	// trả ra list department
	
	@GetMapping
	public ResponseEntity<?> getAllDepartments(Parameters parameters){
		
		List<Department> entities = service.getAllDepartment(parameters);
		
		return new ResponseEntity<List<Department>>(entities, HttpStatus.OK);

	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getDepartmentById(@PathVariable (name = "id") short id){
		
		
		return new ResponseEntity<Department>(service.getDepartmentById(id), HttpStatus.OK);
		
	}
	
	@PostMapping()
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentDTO dto){
		
		service.CreateDepartment(dto.toEntity());
		
		return new ResponseEntity<String>("Create Successfully !", HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/{id}")
	
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id, @RequestBody DepartmentDTO dto, String name){
		Department dep = dto.toEntity();
		dep.setId(id);
		service.UpdateDepartment(id, dep.getName());
		
		return new ResponseEntity<String>("Update Successfully !", HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{id}")
	
	public ResponseEntity<?> deleteDepartment (@PathVariable(name = "id") short id){
		
		service.DeleteDepartment(id);
		
		return new ResponseEntity<String>("Delete Successfully !", HttpStatus.OK);	
	}
	
//	@GetMapping(value = "/{name}")
//	
//	public ResponseEntity<?> getDepartmentByName(@RequestParam("name") String name){
//		
//		Department departmentByName = service.getDepartmentByName(name);
//		
//		return new ResponseEntity<Department>(departmentByName, HttpStatus.OK);
//		
//	}

	
}
