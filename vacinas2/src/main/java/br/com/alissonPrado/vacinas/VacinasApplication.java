package br.com.alissonPrado.vacinas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching //para aplicações de produção deve-se usar um provedor de cache (EHCache, Redis, Infinispan, Caffeine)
public class VacinasApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacinasApplication.class, args);
	}
}
