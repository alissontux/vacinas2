package br.com.alissonPrado.vacinas.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@RestControllerAdvice
public class ErroDeValidacaoHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroFormularioDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		List<ErroFormularioDto> dto = new ArrayList<>();
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

		fieldErrors.forEach(e -> {
			// Busca a mansagem de erro no idioma do cliente
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());

			ErroFormularioDto erro = new ErroFormularioDto(e.getField(), mensagem);
			dto.add(erro);
		});

		return dto;

	}

	@ExceptionHandler(InvalidFormatException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErroFormularioDto handleInvalidFormatException(InvalidFormatException ex) {
		
        String nomeCampo = "campo";

        if (ex.getPath() != null && !ex.getPath().isEmpty()) {
            JsonMappingException.Reference path = ex.getPath().get(ex.getPath().size() - 1);
            if (path != null) {
                nomeCampo = path.getFieldName();
            }
        }
        
        String mensagem = "O campo fornecido " + nomeCampo + " valor '" + 
        		ex.getValue().toString() + "' não é do tipo requerido " + ex.getTargetType();

		return new ErroFormularioDto(nomeCampo, mensagem);
	}

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ResponseBody
//	public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
//
//		return "Campo: " + ex.getBindingResult().getFieldError().getField() + " - Descrição erro: "
//				+ ex.getBindingResult().getFieldError().getDefaultMessage();
//	}

}
