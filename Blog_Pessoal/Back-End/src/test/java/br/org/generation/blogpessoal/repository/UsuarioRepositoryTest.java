package br.org.generation.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.org.generation.blogpessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
    
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start(){

		usuarioRepository.save(new Usuario(0L, "Gabriel da Silva", "gabriel@gmail.com.br", "13465278"));
		
		usuarioRepository.save(new Usuario(0L, "Mariana da Silva", "mariana@gmail.com.br", "13465278"));
		
		usuarioRepository.save(new Usuario(0L, "Guilherme da Silva", "guilherme@gmail.com.br", "13465278"));

        usuarioRepository.save(new Usuario(0L, "Jhonatan Medeiros", "jhonmed@gmail.com.br", "13465278"));

	}

	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {

		Optional<Usuario> usuario = usuarioRepository.findByUsuario("gabriel@gmail.com.br");
		assertTrue(usuario.get().getUsuario().equals("gabriel@gmail.com.br"));
	}

	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {

		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Gabriel da Silva"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Mariana da Silva"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Guilherme da Silva"));
		
	}

}