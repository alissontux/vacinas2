package br.com.alissonPrado.vacinas.config.validacao;

public class ErroFormularioDto {

	String campo;
	String erro;

	public ErroFormularioDto(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

}
