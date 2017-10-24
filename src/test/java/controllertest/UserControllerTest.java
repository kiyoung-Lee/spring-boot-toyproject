package controllertest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.boot.Application;
import com.sample.boot.controller.UserController;
import com.sample.boot.dto.UserDTO;
import com.sample.boot.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
@WebAppConfiguration
@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@MockBean	
	private UserService userService;	
	
	@Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();    
    
    
	@Test
	public void login_ExstistUser_Test() throws Exception {
		UserDTO loginUser = new UserDTO();		
		loginUser.setExternalId("temp_id");
		
		when(userService.login(loginUser)).thenReturn(new UserDTO());
				
		mockMvc.perform(post("/user/login")
    			.contentType(MediaType.APPLICATION_JSON_UTF8)
    			.content(mapper.writeValueAsString(loginUser))
    			.accept(MediaType.APPLICATION_JSON_UTF8))
    			.andDo(print())
    			.andExpect(status().isOk());
				
	}	
	
	@Test 
	public void login_externalId_Null_Test() throws Exception {
		UserDTO loginUser = new UserDTO();
		mockMvc.perform(post("/user/login")
    			.contentType(MediaType.APPLICATION_JSON_UTF8)
    			.content(mapper.writeValueAsString(loginUser))
    			.accept(MediaType.APPLICATION_JSON_UTF8))
    			.andDo(print());    			
	}
	
	@Test
	public void join_Test() throws Exception {
		
	}
	
	@Test
	public void join_userName_Null_Test() throws Exception {
		
	}
	
	@Test
	public void join_externalId_Null_Test() throws Exception {
		
	}
}
