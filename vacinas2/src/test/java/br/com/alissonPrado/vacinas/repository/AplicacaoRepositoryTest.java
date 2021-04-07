package br.com.alissonPrado.vacinas.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alissonPrado.vacinas.modelo.Aplicacao;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
class AplicacaoRepositoryTest {
	
	@Autowired
	AplicacaoRepository aplicacaoRepository;

	@Test
	void naoDeveRetornarListaDeAplicacoesPorCPFInformado() {
		List<Aplicacao> listAplicacao = aplicacaoRepository.findByCidadao_Cpf("000.000.000-00");
		
		Assert.assertTrue(listAplicacao.isEmpty());
	}

	@Test
	void deveRetornarZero() {
		int count = aplicacaoRepository.findOcorrencia(1L, "000.000.000-00", 1);
		
		Assert.assertEquals(0, count);
	}

}
