package VTI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import VTI.Dto.DepartmentDTO;
import VTI.entity.Department;
import VTI.entity.Parameters;
import VTI.service.IDepartmentService;

// trả ra đường dẫn API , 
//nếu @Controller thì trả về dường dẫn của trang web
@RestController

// đạt tên đường link
@RequestMapping(value = "/api/v1/departments")
// cho phép localhost dc tiếp nhận API này.
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DepartmentController {

	@Autowired
	private IDepartmentService IDepartmentService;

	@GetMapping
	public ResponseEntity<?> getAllDepartments(Parameters parameters){
		
		System.out.println(parameters);
		// get data
		
		List<Department> entities = IDepartmentService.getAllDepartment(parameters);
		
		// ResponseEntity : thư viện của java, trả ra list department
		// httpStatus.Ok : trả cho dl ng dùng 200
		return new ResponseEntity<List<Department>>(entities, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getDepartmentById(@PathVariable (name = "id") short id){
		
		
		return new ResponseEntity<Department>(IDepartmentService.getDepartmentById(id), HttpStatus.OK);
		
	}
	@PostMapping()
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentDTO dto) {
		IDepartmentService.CreateDepartment(dto.toEntity());
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id, @RequestBody DepartmentDTO dto, String name) {
		Department department = dto.toEntity();
		department.setId(id);
		//department.setName(name);
		IDepartmentService.UpdateDepartment(id,department.getName());
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") short id) {
		IDepartmentService.DeleteDepartment(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
