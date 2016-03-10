package chapter1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.training.controller.MyFirstController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test.xml" })
public class MyFirstControllerTest {

	@Autowired
	MyFirstController controller;
	
	@Test
	public void test() {
		assertEquals("jock",controller.getName().getName());
	}

}
