package servicetest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.boot.Application;
import com.sample.boot.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTest {

	@Autowired
	UserService service;
	
	@Test
	public void login_Test() throws Exception {
		
	}
	
	@Test
	public void login_Null_Test() throws Exception {
		
	}
	
	@Test
	public void login_ExternalId_Null_Test() throws Exception {
		
	}
	
	@Test
	public void join_Test() throws Exception {
		
	}
	
	@Test
	public void join_Null_Test() throws Exception {
		
	}
	
	@Test
	public void join_ExsistUser_Test() throws Exception {
		
	}
}
