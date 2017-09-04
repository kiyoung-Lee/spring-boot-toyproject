package repositorytest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sample.boot.Application;
import com.sample.boot.dto.GroupDTO;
import com.sample.boot.repository.GroupRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class GroupRepositoryTest {

	@Autowired
	GroupRepository repository;
	
	@Test
	@Transactional
	public void assign_User_Group_Relate_Test() throws Exception {
		repository.assign_User_Group_Relate(1, 1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void assign_User_Group_Relate_Invalid_UserIdx_Test() throws Exception {
		repository.assign_User_Group_Relate(0, 1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void assign_User_Group_Relate_Invalid_GroupIdx_Test() throws Exception {
		repository.assign_User_Group_Relate(1, 0);
	}
	
	@Test
	public void getGroupList_Test() throws Exception {
		List<GroupDTO> groupList = repository.getGroupList("1,2");
		assertNotNull(groupList);
		assertEquals(groupList.size(), 2);
	}
	
	@Test
	public void getGroupList_Null_Test() throws Exception {
		List<GroupDTO> groupList = repository.getGroupList(null);
	}
}
