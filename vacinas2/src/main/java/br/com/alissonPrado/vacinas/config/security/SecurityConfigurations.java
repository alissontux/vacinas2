package br.com.alissonPrado.vacinas.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	AutenticacaoService autenticacaoService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	//Configurações de autorização via token
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").permitAll()
		.antMatchers(HttpMethod.GET, "/vacinas").permitAll()		
		.antMatchers(HttpMethod.GET, "/cidadao/*").permitAll()
		.antMatchers(HttpMethod.GET, "/aplicacao").permitAll()
		.antMatchers(HttpMethod.GET, "/aplicacao/*").permitAll()
		.antMatchers(HttpMethod.POST, "/auth").permitAll()
		.anyRequest().authenticated()
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	//Configurações de autenticação via login e senha (sessão)
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
		// TODO Auto-generated method stub
		super.configure(web);
	}
	
//	public static void main(String[] args) {
//	System.out.println(new BCryptPasswordEncoder().encode("123456"));
//}

}
