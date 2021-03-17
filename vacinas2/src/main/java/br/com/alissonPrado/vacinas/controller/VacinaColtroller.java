package br.com.alissonPrado.vacinas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.alissonPrado.vacinas.controller.dto.VacinaDto;
import br.com.alissonPrado.vacinas.modelo.Vacina;
import br.com.alissonPrado.vacinas.repository.VacinaRepository;

@RestController
@RequestMapping("/vacinas")
public class VacinaColtroller {

	@Autowired
	private VacinaRepository vacinaRepository;

	@GetMapping
	public Page<VacinaDto> listaVacinas(@RequestParam(required = false) String nome,
			@PageableDefault(sort = "nome", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {

		if (nome == null) {
			Page<Vacina> vacinas = vacinaRepository.findAll(paginacao);
			return VacinaDto.converteListaVacinaDto(vacinas);
		} else {
			Page<Vacina> vacinas = vacinaRepository.findByNome(nome, paginacao);
			return VacinaDto.converteListaVacinaDto(vacinas);
		}

	}

//	método sem paginação
//	@GetMapping
//	public List<VacinaDto> listaVacinas() {
//		
//		List<Vacina> vacinas = vacinaRepository.findAll();
//		return VacinaDto.converteListaVacinaDto(vacinas);
//		
//	}

}
