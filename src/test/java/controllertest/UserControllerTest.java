package controllertest;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.boot.Application;
import com.sample.boot.controller.UserController;
import com.sample.boot.dto.UserDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class UserControllerTest {
	
	@Autowired
    private UserController userController;
	
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();
    
    @Before
    public void setUp() {    	
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
        		.build();
    }
    
	@Test
	public void login_ExstistUser_Test() throws Exception {
		UserDTO loginUser = new UserDTO();		
		loginUser.setExternalId("temp_id");
		
		mockMvc.perform(post("/user/login")
    			.contentType(MediaType.APPLICATION_JSON_UTF8)
    			.content(mapper.writeValueAsString(loginUser))
    			.accept(MediaType.APPLICATION_JSON_UTF8))
    			.andDo(print())
    			.andExpect(status().isOk())
    			.andExpect(jsonPath("$.success").value(true)) 
    	    	.andExpect(jsonPath("$.message").value("로그인 성공"));
	}
	
	@Test
	public void login_userName_Null_Test() throws Exception {
		
	}
	
	@Test
	public void login_externalId_Null_Test() throws Exception {
		
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
