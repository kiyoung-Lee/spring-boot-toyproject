package org.gradle;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import static org.junit.Assert.*;


public class PersonTest {
	
	@Autowired 
	private Environment environment;
		
    @Test
    public void canConstructAPersonWithAName() {
        Person person = new Person("Larry");
        assertEquals("Larry", person.getName());
        
        String system = System.getenv("os");
        System.out.println(system);
        
        String home = System.getProperty("user.home");
        System.out.println(home);
        
        String[] arr = environment.getActiveProfiles();
        System.out.println(arr);
        
    }
}
