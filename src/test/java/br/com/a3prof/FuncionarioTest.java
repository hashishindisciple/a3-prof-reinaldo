package br.com.a3prof;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FuncionarioTest {
    @Test
    void criaFuncionarioComId() {
        Funcionario funcionario = new Funcionario(7);
        assertEquals(7, funcionario.getId());
    }

    @Test
    void guardaNome() {
        Funcionario funcionario = new Funcionario(7, "Ana");
        assertEquals("Ana", funcionario.getNome());
    }
}
