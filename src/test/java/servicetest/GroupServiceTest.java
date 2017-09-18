package servicetest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.boot.Application;
import com.sample.boot.dto.GroupDTO;
import com.sample.boot.service.GroupService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class GroupServiceTest {

	@Autowired
	GroupService service;
	
	@Test
	public void getGroupList_Test() throws Exception {
		List<GroupDTO> result = service.getGroupList(2);
		assertNotNull(result);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void getGroupList_userIdx_Invalid_Test() throws Exception {
		service.getGroupList(0);
	}
}
