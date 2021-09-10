package VTI.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.config.SortedResourcesFactoryBean;
import org.springframework.stereotype.Service;

import VTI.dto.GroupDTO;
import VTI.entity.Group;
import VTI.entity.Parameters;
import VTI.entity.User;
import VTI.repository.IGroupRepository;

@Service
public class GroupService implements IGroupService{

	@Autowired
	private IGroupRepository repository;
	
	@Override
	public List<GroupDTO> getAllGroups(Parameters parameters) {
		List<GroupDTO> lsDtos = new ArrayList<>();
		
		List<Group> listGroup = null;
		Pageable pageable = null;
		Specification<Group> where = null;
		Sort sort = null;	
		if(parameters.getField() != null && !parameters.getField().isEmpty()) {
			
			if(parameters.getTypeSort() != null && parameters.getTypeSort().equals("DESC")) {
				
				sort = Sort.by(parameters.getField()).descending();
			}else {
				sort = Sort.by(parameters.getField()).ascending();
			}
		}
		
		if(parameters.getSearch() != null && !parameters.getSearch().isEmpty()) {
			where = searchByName(parameters.getSearch());
		}
		if(parameters.getMaxId() >0 ) {
			
			if(where ==null) {
				where = lessThanEqualMaxId((short) parameters.getMaxId());
			}else {
				where = where.and(lessThanEqualMaxId((short) parameters.getMaxId()));
			}
		}
		if(parameters.getMinId() >0 ) {
			
			if(where ==null) {
				where = greaterThanEqualMinId((short) parameters.getMinId());
			}else {
				where = where.and(greaterThanEqualMinId((short) parameters.getMinId()));
			}
		}		
		
		
		if(parameters.getPage() >=0 && parameters.getPageSize() > 0) {
			// trường hợp người dùng có phân trang
			if(sort !=null) {
				// kết hợp cả phân trang + sắp xếp
				pageable = PageRequest.of(parameters.getPage(), parameters.getPageSize(),sort);
			}else {
				pageable = PageRequest.of(parameters.getPage(), parameters.getPageSize());
			}
			if(where !=null) listGroup = repository.findAll(where,pageable).toList();
			else  listGroup = repository.findAll(pageable).toList();
		}else {
			// trường hợp người dùng không  phân trang (không truyền lên page + pageSize)
			if(sort !=null &&  where !=null) {
				listGroup = repository.findAll(where,sort);
			}else if(sort !=null && where ==null) {
				listGroup = repository.findAll(sort);
			}else if(sort ==null && where !=null) {
				listGroup = repository.findAll(where);
			}else {
				listGroup = repository.findAll();
			}
			
		}								
		// đổ dữ liệu từ listGroup->lsDtos
		if(listGroup.size() > 0) {
			User user = null;
			for (Group group : listGroup) {
				if(group.getUser()!=null) {
					user = new User(
							group.getUser().getId(),
							group.getUser().getEmail(),
							group.getUser().getUserName(),
							group.getUser().getPassword(),
							group.getUser().getFisrtName(),
							group.getUser().getLastName(),						
							group.getUser().getPhone()
							);
				}								
				GroupDTO groupDTO = new GroupDTO(
						group.getGroupId(),
						group.getGroupName(),
						group.getMember(),
						user,
						group.getCreateDate()
						);				
				lsDtos.add(groupDTO);
			}
			
		}				
		return lsDtos;
	}

	public Specification<Group> searchByName(String name){
		return new Specification<Group>() {
			@Override
			public Predicate toPredicate(Root<Group> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				
				return criteriaBuilder.like(root.get("name"), "%"+name+"%");
			}
			
		};		
	}
	public Specification<Group> greaterThanEqualMinId(short minId){
		return new Specification<Group>() {
			@Override
			public Predicate toPredicate(Root<Group> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				
				return criteriaBuilder.ge(root.get("id"), minId);
			}
			
		};		
	}
	public Specification<Group> lessThanEqualMaxId(short maxId){
		return new Specification<Group>() {
			@Override
			public Predicate toPredicate(Root<Group> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				
				return criteriaBuilder.le(root.get("id"), maxId);
			}
			
		};		
	}
	
	@Override
	public Group getGroupByID(short id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public Group getGroupByName(String name) {
		// TODO Auto-generated method stub
		return repository.findByGroupName(name);
	}

	@Override
	public void createGroup(Group Group) {
		// TODO Auto-generated method stub
		repository.save(Group);
	}

	@Override
	public void updateGroup(Group Group) {
		// TODO Auto-generated method stub
		repository.save(Group);
	}

	@Override
	public void deleteGroup(short id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public boolean isGroupExistsByID(short id) {
		// TODO Auto-generated method stub
		return repository.existsById(id);
	}

	@Override
	public boolean isGroupExistsByName(String name) {
		// TODO Auto-generated method stub
		return repository.existsByGroupName(name);
	}

	@Override
	public void deleteMultiGroups(List<Short> ids) {
		// TODO Auto-generated method stub
		repository.deleteByIds(ids);
	}

}