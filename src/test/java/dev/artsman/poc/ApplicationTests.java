package dev.artsman.poc;

import dev.artsman.poc.hexagonal.arch.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ApplicationTests {
	@Autowired
	ApplicationContext context;

	@Test
	void contextLoads() {
		var application = context.getBean(Application.class);
		Assertions.assertNotNull(application);
	}
}
