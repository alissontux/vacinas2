package br.com.alissonPrado.vacinas.repository;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alissonPrado.vacinas.modelo.Cidadao;

@RunWith(SpringRunner.class)
@DataJpaTest
class CidadaoRepositoryTest {
	
	@Autowired
	CidadaoRepository cidadaoRepository;

	@Test
	void deveRetornarCidadoPorCPFInformado() {
		Optional<Cidadao> cidadao = cidadaoRepository.findByCpf("000.000.000-00");
		
		Assert.assertNotNull(cidadao);
		
		Assert.assertEquals("Teste3", cidadao.get().getNome());
		
		Assert.assertNotEquals("teste3@gmail.co", cidadao.get().getEmail());		
		
	}
	
	@Test
	void deveRetornarCidadoPorEmailInformado() {
		Optional<Cidadao> cidadao = cidadaoRepository.findByEmail("teste3@gmail.com");
		
		Assert.assertNotNull(cidadao);
		
		Assert.assertEquals("Teste3", cidadao.get().getNome());	
		
	}
	
	@Test
	void naoDeveRetornarCidadoPorEmailInformadoIncorreto() {
		Optional<Cidadao> cidadao = cidadaoRepository.findByEmail("teste@gmail.com");
		
		Assert.assertTrue(cidadao.isEmpty());
		
	}

}
