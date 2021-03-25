package br.com.alissonPrado.vacinas.controller.security;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alissonPrado.vacinas.config.security.TokenService;
import br.com.alissonPrado.vacinas.controller.form.security.LoginForm;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	AuthenticationManager authManager;

	@Autowired
	TokenService tokenService;

	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form) {

		UsernamePasswordAuthenticationToken dadosLogin = form.converter();

		try {

			Authentication authentication = authManager.authenticate(dadosLogin);

			String token = tokenService.gerarToken(authentication);

			System.out.println("Token gerado: " + token);

			return ResponseEntity.ok().build();

		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

}
