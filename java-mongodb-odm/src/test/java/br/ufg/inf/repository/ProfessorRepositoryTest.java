package br.ufg.inf.repository;

import br.ufg.inf.model.Professor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
public class ProfessorRepositoryTest {

    @Autowired
    private ProfessorRepository repo;

    // @BeforeEach
    // void setUp() {
    //     repo.deleteAll();
    // }

    @Test
    @DisplayName("POST / Criar: Salvar professor e gerar ID")
    void testCriar() {
        Professor prof = new Professor("Marcelo Akira", "1990-01-01", "Mestre", 10354.79);
        Professor salvo = repo.save(prof);

        assertNotNull(salvo.getId());
        assertEquals("Marcelo Akira", salvo.getNomeCompleto());
    }

    @Test
    @DisplayName("GET / Listar: Buscar todos os professores")
    void testBuscarTodos() {
    int totalInicial = repo.findAll().size();

    repo.save(new Professor("Maria Teste", "1990-01-01", "Mestre", 10354.79));
    repo.save(new Professor("João Silva", "1985-05-15", "Doutor", 12500.00));

    List<Professor> lista = repo.findAll();

    assertEquals(totalInicial + 2, lista.size());
    }

    @Test
    @DisplayName("GET / Buscar por ID: Encontrar professor existente")
    void testBuscarPorId() {
        Professor salvo = repo.save(new Professor("Vinicius Teste", "2004-05-24", "Doutor", 10354.79));

        Optional<Professor> resultado = repo.findById(salvo.getId());

        assertTrue(resultado.isPresent());
        assertEquals(salvo.getId(), resultado.get().getId());
        assertEquals("Vinicius Teste", resultado.get().getNomeCompleto());
    }

    @Test
    @DisplayName("PUT / Atualizar: Alterar atributos de um professor persistido")
    void testAtualizar() {
        Professor salvo = repo.save(new Professor("Maria Teste", "1990-01-01", "Mestre", 10354.79));

        salvo.setNivelPos("Doutor");
        salvo.setSalario(12800.50);
        Professor atualizado = repo.save(salvo);

        Optional<Professor> busca = repo.findById(salvo.getId());
        assertTrue(busca.isPresent());
        assertEquals("Doutor", busca.get().getNivelPos());
        assertEquals(12800.50, busca.get().getSalario());
    }

    @Test
    @DisplayName("DELETE / Excluir: Remover professor por ID")
    void testExcluir() {
        Professor salvo = repo.save(new Professor("Maria Teste", "1990-01-01", "Mestre", 10354.79));
        String id = salvo.getId();

        repo.deleteById(id);

        Optional<Professor> busca = repo.findById(id);
        assertFalse(busca.isPresent());
    }
}