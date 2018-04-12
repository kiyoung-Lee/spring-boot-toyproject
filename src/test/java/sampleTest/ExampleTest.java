package sampleTest;

import com.sample.boot.Application;
import com.sample.boot.User.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ExampleTest {

    @Autowired
    UserService userService;

    @Test
    public void di_Test() {
        assertNotNull(userService);
    }
}
