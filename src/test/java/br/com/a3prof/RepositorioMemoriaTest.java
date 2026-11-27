package br.com.a3prof;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositorioMemoriaTest {
    @Test
    void cadastraRegistro() {
        assertTrue(new RepositorioMemoria<String, String>().cadastrar("1", "Ana"));
    }

    @Test
    void naoCadastraChaveDuplicada() {
        RepositorioMemoria<String, String> repo = new RepositorioMemoria<>();
        repo.cadastrar("1", "Ana");
        assertFalse(repo.cadastrar("1", "Bia"));
    }

    @Test
    void cadastroRejeitaNulos() {
        RepositorioMemoria<String, String> repo = new RepositorioMemoria<>();
        assertThrows(NullPointerException.class, () -> repo.cadastrar(null, "Ana"));
        assertThrows(NullPointerException.class, () -> repo.cadastrar("1", null));
    }

    @Test
    void buscaRegistroExistente() {
        RepositorioMemoria<String, String> repo = new RepositorioMemoria<>();
        repo.cadastrar("1", "Ana");
        assertEquals("Ana", repo.buscar("1"));
    }

    @Test
    void buscaRegistroAusente() {
        assertNull(new RepositorioMemoria<String, String>().buscar("1"));
    }

    @Test
    void buscaRejeitaChaveNula() {
        assertThrows(NullPointerException.class,
                () -> new RepositorioMemoria<String, String>().buscar(null));
    }

    @Test
    void listaRepositorioVazio() {
        assertTrue(new RepositorioMemoria<String, String>().listar().isEmpty());
    }

    @Test
    void listaTodosNaOrdemDeCadastro() {
        RepositorioMemoria<String, String> repo = new RepositorioMemoria<>();
        repo.cadastrar("1", "Ana");
        repo.cadastrar("2", "Bia");
        assertEquals(java.util.List.of("Ana", "Bia"), repo.listar());
    }

    @Test
    void listaImutavel() {
        RepositorioMemoria<String, String> repo = new RepositorioMemoria<>();
        repo.cadastrar("1", "Ana");
        assertThrows(UnsupportedOperationException.class, () -> repo.listar().clear());
    }

    @Test
    void atualizaRegistroExistente() {
        RepositorioMemoria<String, String> repo = new RepositorioMemoria<>();
        repo.cadastrar("1", "Ana");
        assertTrue(repo.atualizar("1", "Bia"));
        assertEquals("Bia", repo.buscar("1"));
    }

    @Test
    void naoAtualizaRegistroAusente() {
        assertFalse(new RepositorioMemoria<String, String>().atualizar("1", "Bia"));
    }

    @Test
    void atualizacaoRejeitaNulos() {
        RepositorioMemoria<String, String> repo = new RepositorioMemoria<>();
        repo.cadastrar("1", "Ana");
        assertThrows(NullPointerException.class, () -> repo.atualizar(null, "Bia"));
        assertThrows(NullPointerException.class, () -> repo.atualizar("1", null));
    }

    @Test
    void excluiRegistroExistente() {
        RepositorioMemoria<String, String> repo = new RepositorioMemoria<>();
        repo.cadastrar("1", "Ana");
        assertTrue(repo.excluir("1"));
    }

    @Test
    void excluirAusenteRetornaFalso() {
        assertFalse(new RepositorioMemoria<String, String>().excluir("1"));
    }

    @Test
    void exclusaoRejeitaChaveNula() {
        assertThrows(NullPointerException.class,
                () -> new RepositorioMemoria<String, String>().excluir(null));
    }
}
