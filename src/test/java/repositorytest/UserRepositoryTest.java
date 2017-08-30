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
		int result = repository.getUserInfo(facebookId);
		
		assertEquals(result, 1);
	}
	
	@Test
	public void getUserInfo_Null_Test(){
		int result = repository.getUserInfo(null);
		assertEquals(result, 0);
	}
	
	@Test
	public void getUserInfo_Invalid_Id_Test(){
		String invalidId = "InvalidID";
		int result = repository.getUserInfo(invalidId);
		assertEquals(result, 0);
	}
	
	@Test
	public void insertNewUser_Test(){
		UserDTO user = new UserDTO();
		user.setUserName("testUser");
		user.setExternalId("externalId" + UUID.randomUUID().toString());
		
		repository.inserNewUser(user);
	}
}
