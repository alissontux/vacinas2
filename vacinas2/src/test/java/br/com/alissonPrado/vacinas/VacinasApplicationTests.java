package br.com.alissonPrado.vacinas;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
public class VacinasApplicationTests {

	@Test
	public void contextLoads() {
		
		Assert.assertTrue(true);
		
	}

}
