package VTI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import VTI.entity.User;
import VTI.service.IUserService;

@RestController
@RequestMapping(value = "api/vti/user")
@CrossOrigin(origins = "http://127.0.0.1:5500")

public class UserController {

	@Autowired
	private IUserService service;
	
	@GetMapping
	public ResponseEntity<?> getAllGroup(@RequestParam String username){
		
		User entities = service.findByUserName(username);
		
		return new ResponseEntity<User>(entities, HttpStatus.OK);

	}
}
