package br.com.a3prof;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FuncionarioTest {
    @Test
    void criaFuncionarioComId() {
        Funcionario funcionario = new Funcionario(7, "Ana");
        assertEquals(7, funcionario.getId());
    }

    @Test
    void guardaNome() {
        Funcionario funcionario = new Funcionario(7, "Ana");
        assertEquals("Ana", funcionario.getNome());
    }
    @Test
    void rejeitaNomeVazio() {
        assertThrows(IllegalArgumentException.class,
                () -> new Funcionario(7, ""));
    }
}
