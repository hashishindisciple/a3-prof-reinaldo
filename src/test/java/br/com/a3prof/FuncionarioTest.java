package br.com.a3prof;

import org.junit.jupiter.api.Test;

public class FuncionarioTest {
    @Test
    void criaFuncionarioComId() {
        Funcionario funcionario = new Funcionario(7);
        assertEquals(7, funcionario.getId());
    }
}
