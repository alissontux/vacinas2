package br.com.alissonPrado.vacinas.controller.security;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alissonPrado.vacinas.controller.form.security.LoginForm;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form) {

		System.out.println("Email: " + form.getEmail());
		System.out.println("Senha: " + form.getSenha());

		return ResponseEntity.ok().build();
	}

}
