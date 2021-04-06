package br.com.alissonPrado.vacinas.repository.security;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alissonPrado.vacinas.modelo.security.Usuario;

@RunWith(SpringRunner.class)
@DataJpaTest
class UsuarioRepositoryTest {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Test
	void deveBuscarUsuarioPorEmailInformado() {
		Optional<Usuario> usuario = usuarioRepository.findByEmail("aplicador@email.com");
		
		Assert.assertNotNull(usuario);
		
		Assert.assertEquals("Aplicador", usuario.get().getNome());		
		
	}

}
