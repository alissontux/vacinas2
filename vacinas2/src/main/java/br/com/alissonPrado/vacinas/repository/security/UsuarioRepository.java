package br.com.alissonPrado.vacinas.repository.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alissonPrado.vacinas.modelo.security.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByEmail(String email);

}
