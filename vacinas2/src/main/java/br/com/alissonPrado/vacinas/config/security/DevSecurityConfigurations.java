package br.com.alissonPrado.vacinas.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@Profile("dev")
public class DevSecurityConfigurations extends WebSecurityConfigurerAdapter {
	
	// Configurações de autorização via token
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/**").permitAll()
		.and().csrf().disable();
	}

	// Configurações de autenticação via login e senha (sessão)
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers(HttpMethod.GET, "/").permitAll()
//		.antMatchers(HttpMethod.GET, "/vacinas").permitAll()		
//		.antMatchers(HttpMethod.GET, "/cidadao/*").permitAll()
//		.antMatchers(HttpMethod.GET, "/aplicacao").permitAll()
//		.antMatchers(HttpMethod.GET, "/aplicacao/*").permitAll()
//		.anyRequest().authenticated().and().formLogin();
//	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// Swagger
//		web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**",
//				"/swagger-resources/**");

	}

//	public static void main(String[] args) {
//	System.out.println(new BCryptPasswordEncoder().encode("123456"));
//}

}
