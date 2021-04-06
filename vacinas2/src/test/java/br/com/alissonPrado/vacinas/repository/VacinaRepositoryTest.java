package br.com.alissonPrado.vacinas.repository;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alissonPrado.vacinas.modelo.Vacina;

@RunWith(SpringRunner.class)
@DataJpaTest
class VacinaRepositoryTest {

	@Autowired
	VacinaRepository vacinaRepository;

	@Test
	void deveTrazerNomeCoronavacVacinaId1() {

		Optional<Vacina> vacina = vacinaRepository.findById(1L);

		Assert.assertNotNull(vacina);

		Assert.assertEquals("CoronaVac", vacina.get().getNome());

	}

}
