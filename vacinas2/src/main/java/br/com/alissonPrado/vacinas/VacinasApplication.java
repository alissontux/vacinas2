package br.com.alissonPrado.vacinas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport //para habilitar passagem de objeto Pageable na requisição
@EnableCaching //para aplicações de produção deve-se usar um provedor de cache (EHCache, Redis, Infinispan, Caffeine)
@EnableSwagger2 //para gerar documentação da API
public class VacinasApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacinasApplication.class, args);
	}
}
