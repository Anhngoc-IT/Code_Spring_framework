package VTI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import VTI.entity.User;

public interface IUserRepository extends JpaRepository<User, Short> {

	public User findByUserName(String username);
}
