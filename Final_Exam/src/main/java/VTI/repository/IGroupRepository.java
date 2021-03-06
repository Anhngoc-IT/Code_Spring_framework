package VTI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import VTI.entity.Group;

public interface IGroupRepository extends JpaRepository<Group, Short>,JpaSpecificationExecutor<Group>{
	public Group findByGroupName(String name);
	public boolean existsByGroupName(String name);
	
	
	@Modifying
	@Transactional
	@Query("Delete From Group where id In(:ids)")
	public void deleteByIds(@Param("ids") List<Short> ids);
}