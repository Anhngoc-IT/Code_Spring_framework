package VTI.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import VTI.entity.Group;
import VTI.entity.Parameters;
import VTI.dto.GroupDTO;


public interface IGroupService {
	
	public List<GroupDTO> getAllGroups(Parameters parameters);

	public Group getGroupByID(short id);

	public Group getGroupByName(String name);

	public void createGroup(Group Group);

	public void updateGroup(Group Group);

	public void deleteGroup(short id);

	public boolean isGroupExistsByID(short id);

	public boolean isGroupExistsByName(String name);
	
	public void deleteMultiGroups(List<Short> ids);
}