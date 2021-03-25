package br.com.alissonPrado.vacinas.controller.form.security;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginForm {

	@NotNull
	@NotBlank(message = "O e-mail não pode ser vazio.")
	@Email
	String email;

	@NotNull
	@NotBlank(message = "A senha não pode ser vazia.")
	String senha;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
