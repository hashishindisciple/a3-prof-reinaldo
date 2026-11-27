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
    @Test
    void guardaSalario() {
        Funcionario funcionario = new Funcionario(7, "Ana");
        funcionario.setSalario(3000.0);

        assertEquals(3000.0, funcionario.getSalario());
    }
    @Test
    void rejeitaSalarioNaoPositivo() {
        Funcionario funcionario = new Funcionario(7, "Ana");

        assertThrows(IllegalArgumentException.class,
                () -> funcionario.setSalario(0));
        assertThrows(IllegalArgumentException.class,
                () -> funcionario.setSalario(-100));
    }
    @Test
    void aplicaReajusteSalarial() {
        Funcionario funcionario = new Funcionario(7, "Ana");
        funcionario.setSalario(3000);
        funcionario.aplicarReajuste(10);

        assertEquals(3300, funcionario.getSalario());
    }

    @Test
    void aplicaReajusteDeVinteECincoPorCento() {
        Funcionario funcionario = new Funcionario(8, "Bia");
        funcionario.setSalario(1000);
        funcionario.aplicarReajuste(25);
        assertEquals(1250, funcionario.getSalario());
    }

    @Test
    void reajusteDeZeroMantemSalario() {
        Funcionario funcionario = new Funcionario(9, "Caio");
        funcionario.setSalario(2000);
        funcionario.aplicarReajuste(0);
        assertEquals(2000, funcionario.getSalario());
    }
}
