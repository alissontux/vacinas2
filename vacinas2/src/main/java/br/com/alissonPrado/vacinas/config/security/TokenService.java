package br.com.alissonPrado.vacinas.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.alissonPrado.vacinas.modelo.security.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${vacinas.jwt.expiration}")
	private String expiration;

	@Value("${vacinas.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authentication) {

		Date hoje = new Date();

		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

		Usuario logado = (Usuario) authentication.getPrincipal();

		return Jwts.builder().setIssuer("Cadastro aplicação vacinas Covid-19").setSubject(logado.getId().toString())
				.setIssuedAt(hoje).setExpiration(dataExpiracao).signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public boolean isTokenValido(String token) {

		try {
			Jwts.parser().setSigningKey(this.secret).parse(token);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Long getIdUsuario(String token) {

		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}

}
