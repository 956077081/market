import com.pht.MainApplication;
import com.pht.cust.dto.CustomerParam;
import com.pht.cust.dto.CustomerQueryParam;
import com.pht.cust.entity.User;
import com.pht.cust.service.CustomerService;
import com.pht.cust.service.UserService;
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
@Autowired
    CustomerService customerService;
    @Test
    public void testUser(){
        User user =  userService.getUserByUserName("pht");
        System.out.println(user);
    }
    @Test
    public void testCustomerCrt(){
        CustomerParam customerParam= new CustomerParam();
        customerParam.setCustType("00");
        customerParam.setCustName("张三");
        customerParam.setIdNum("610321199603122772");
        customerService.save(customerParam);
    }

    @Test
    public void queryList(){
        CustomerQueryParam customerQueryParam = new CustomerQueryParam();
        customerQueryParam.setIdType("00");
        customerQueryParam.setIdNum("610321199603122772");
        customerQueryParam.setCustName("新");


        customerQueryParam.setProfession("");
        customerService.queryList(customerQueryParam,1,1);
    }

}
