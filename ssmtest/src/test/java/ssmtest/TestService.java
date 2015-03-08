package ssmtest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {
	@Test
	public void testSpring(){
		ApplicationContext context = new ClassPathXmlApplicationContext();
	}
}
