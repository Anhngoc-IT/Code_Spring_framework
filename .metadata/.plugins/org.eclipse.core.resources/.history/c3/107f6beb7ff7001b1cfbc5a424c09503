package VTI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VTI.entity.User;
import VTI.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository repository;
	
	// dùng để login
	@Override
	public User findByUserName(String username) {
		
		return repository.findByUserName(username);
	}

}
