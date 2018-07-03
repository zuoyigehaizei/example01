package com.example.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleApplicationTests {

	@Test
	public void contextLoads() {

		BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
		String encode = encoder.encode("root");
		System.out.println(encode);
	}

}
