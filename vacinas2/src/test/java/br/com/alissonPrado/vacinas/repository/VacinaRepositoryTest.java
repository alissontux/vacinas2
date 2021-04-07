package br.com.alissonPrado.vacinas.repository;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alissonPrado.vacinas.modelo.Vacina;

@RunWith(SpringRunner.class)
@DataJpaTest
//Para não substituir o Banco de dados utilizado na aplicação pelo H2
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//Cria um novo profile de testes (Utiliza a configuração de aplication-test.properties)
@ActiveProfiles("test")
class VacinaRepositoryTest {

	@Autowired
	VacinaRepository vacinaRepository;
	
	@Autowired
	TestEntityManager em;

	@Test
	void deveTrazerNomeCoronavacVacinaId1() {
		
		//necessário incluir dados no banco para realizar o teste (o banco está vazio por padrão)
		Vacina vacinaBanco = new Vacina();
		vacinaBanco.setNome("CoronaVac");
		em.persist(vacinaBanco);

		Optional<Vacina> vacina = vacinaRepository.findById(1L);

		Assert.assertNotNull(vacina);

		Assert.assertEquals("CoronaVac", vacina.get().getNome());

	}

}
