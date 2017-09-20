package controllertest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sample.boot.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class GroupControllerTest {

	@Test
	public void getGroupList_Test() throws Exception {
		
	}
	
	@Test
	public void getGroupList_userIdx_Invalid_Test() throws Exception {
		
	}
}
