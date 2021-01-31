import com.pht.MainApplication;
import com.pht.cust.model.User;
import com.pht.cust.service.UserService;
import com.sun.javaws.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MainApplication.class})
public class MainTest {
    @Autowired
    UserService userService;

    @Test
    public void testUser(){
        User user =  userService.getUserByUserName("pht");
        System.out.println(user);
    }
}
