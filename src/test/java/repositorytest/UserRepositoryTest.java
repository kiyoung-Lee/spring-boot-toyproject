package repositorytest;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.boot.Application;
import com.sample.boot.dto.UserDTO;
import com.sample.boot.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserRepositoryTest {

	@Autowired
	UserRepository repository;
	
	@Test
	public void getUserInfo_Test(){
		String facebookId = "temp_id";
		UserDTO result = repository.getUserInfo(facebookId);
		
		assertNotNull(result);
		assertEquals(result.getExternalId(), "temp_id");
	}
	
	@Test
	public void getUserInfo_Null_Test(){
		UserDTO result = repository.getUserInfo(null);
		assertNull(result);
	}
	
	@Test
	public void getUserInfo_Invalid_Id_Test(){
		String invalidId = "InvalidID";
		UserDTO result = repository.getUserInfo(invalidId);		
		assertNull(result);
	}
	
	@Test
	public void insertNewUser_Test(){
		UserDTO user = new UserDTO();
		user.setUserName("testUser");
		user.setExternalId("externalId" + UUID.randomUUID().toString());
		
		repository.inserNewUser(user);
	}
	
	@Test (expected = NullPointerException.class)
	public void insertNewUser_Null_Test(){
		repository.inserNewUser(null);
	}
	
	@Test (expected = NullPointerException.class)
	public void insertNewUser_UserName_Null_Test(){
		UserDTO user = new UserDTO();		
		repository.inserNewUser(user);
	}
	
	@Test (expected = NullPointerException.class)
	public void insertNewUser_ExternalId_Null_Test(){
		UserDTO user = new UserDTO();
		user.setUserName("testName");
		repository.inserNewUser(user);
	}
}
