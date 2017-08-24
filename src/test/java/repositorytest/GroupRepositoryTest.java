package repositorytest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.boot.Application;
import com.sample.boot.repository.GroupRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class GroupRepositoryTest {

	@Autowired
	GroupRepository repository;
	
	@Test
	public void selectTest(){
		int result = repository.selectTest();
		System.out.println(result);
	}
}
