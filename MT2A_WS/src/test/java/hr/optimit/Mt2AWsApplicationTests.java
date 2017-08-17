package hr.optimit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Mt2AWsApplication.class)
@WebAppConfiguration
public class Mt2AWsApplicationTests {

	@Test
	public void contextLoads() {
		
		StandardPasswordEncoder spe = new StandardPasswordEncoder();
		System.out.println(spe.encode("test"));
	}

}
