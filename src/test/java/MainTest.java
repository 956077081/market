import com.pht.MainApplication;
import com.pht.cust.dto.CustomerParam;
import com.pht.cust.dto.CustomerQueryParam;
import com.pht.cust.entity.User;
import com.pht.cust.service.CustomerService;
import com.pht.cust.service.UserService;
import com.pht.security.bo.AdminUserDetails;
import com.pht.security.util.JwtTokenUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {MainApplication.class})
public class MainTest {
    @Autowired
    UserService userService;
@Autowired
    CustomerService customerService;
@Autowired
    JwtTokenUtil jwtTokenUtil;

    /**
     * 生成 登录token
     */
    @Test
    public void testCustomerCrt(){
        User user = new User();
        user.setUserName("admin");
        user.setPassWord("123456");
        UserDetails userDetails = new AdminUserDetails(user);
        String s = jwtTokenUtil.generateToken(userDetails);
        System.out.println(s);

    }


}
