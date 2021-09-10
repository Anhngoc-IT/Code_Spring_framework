package VTI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import VTI.dto.GroupDTO;

import VTI.entity.Parameters;


@RestController
@RequestMapping(value = "api/vti/group")
@CrossOrigin(origins = "http://127.0.0.1:5500")

public class GroupController {
 
	

	
	@GetMapping()
	public ResponseEntity<?> getAllGrpups(Parameters par){
//		List<GroupDTO> entities = service.getAllGroups(par);
		return new ResponseEntity<String>("All file", HttpStatus.OK);
	}
	
	
}
