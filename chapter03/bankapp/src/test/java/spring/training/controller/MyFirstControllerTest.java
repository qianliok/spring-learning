
package spring.training.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations = { "/test.xml" } )
public class MyFirstControllerTest {

	@Autowired
	BankController controller;

	@Test
	public void test() {
		// do nothing

	}

}
