package servicetest;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sample.boot.Application;
import com.sample.boot.User.Data.UserDTO;
import com.sample.boot.User.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTest {

	@Autowired
	UserService service;
	
	@Test
	public void login_Test() throws Exception {
		UserDTO loginUser = new UserDTO();
		loginUser.setExternalId("temp_id");
		
		UserDTO result = service.login(loginUser);
		assertNotNull(result);
		assertNotNull(result.getExternalId());
		assertNotNull(result.getUserName());
		assertTrue(result.getUserIdx() > 0);
	}
	
	@Test (expected = NullPointerException.class)
	public void login_Null_Test() throws Exception {
		service.login(null);
	}
	
	@Test (expected = NullPointerException.class)
	public void login_ExternalId_Null_Test() throws Exception {
		UserDTO EmptyUser = new UserDTO();
		service.login(EmptyUser);
	}
	
	@Test
	@Transactional
	public void join_Test() throws Exception {
		UserDTO newUser = new UserDTO();
		newUser.setUserName(UUID.randomUUID().toString());
		newUser.setExternalId(UUID.randomUUID().toString());
		
		UserDTO result = service.Join(newUser);
		assertNotNull(result);
		assertNotNull(result.getExternalId());
		assertNotNull(result.getUserName());
		assertTrue(result.getUserIdx() > 0);
	}
	
	@Test (expected = NullPointerException.class)
	public void join_Null_Test() throws Exception {
		service.Join(null);
	}
	
	@Test (expected = NullPointerException.class)
	public void join_ExternalId_Null_Test() throws Exception {
		UserDTO newUser = new UserDTO();
		newUser.setUserName(UUID.randomUUID().toString());
		
		service.Join(newUser);
	}
	
	@Test (expected = NullPointerException.class)
	public void join_UserName_Null_Test() throws Exception {
		UserDTO newUser = new UserDTO();
		newUser.setExternalId(UUID.randomUUID().toString());
		
		service.Join(newUser);
	}
	
	@Test
	public void join_ExsistUser_Test() throws Exception {
		UserDTO loginUser = new UserDTO();
		loginUser.setExternalId("temp_id");
		
		UserDTO result = service.login(loginUser);
		assertNotNull(result);
		assertNotNull(result.getExternalId());
		assertNotNull(result.getUserName());
		assertTrue(result.getUserIdx() > 0);
	}
}
