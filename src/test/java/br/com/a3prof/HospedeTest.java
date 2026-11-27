package br.com.a3prof;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HospedeTest {

    @Test
    void deveRegistrarNome() {
        Hospede h = new Hospede();
        h.setNome("Joao Silva");
        assertEquals("Joao Silva", h.getNome());
    }

    @Test
    void deveRejeitarNomeVazio() {
        Hospede h = new Hospede();
        assertThrows(IllegalArgumentException.class,
            () -> h.setNome(""));
    }

    @Test
    void deveRejeitarNomeNulo() {
        Hospede h = new Hospede();
        assertThrows(IllegalArgumentException.class,
            () -> h.setNome(null));
    }

    @Test
    void deveRetornarNomeInicialNulo() {
        Hospede h = new Hospede();
        assertNull(h.getNome());
    }

    @Test
    void deveAlterarNome() {
        Hospede h = new Hospede();
        h.setNome("Joao");
        h.setNome("Pedro");
        assertEquals("Pedro", h.getNome());
    }

    @Test
    void deveRegistrarCpf() {
        Hospede h = new Hospede();
        h.setCpf("12345678909");
        assertEquals("12345678909", h.getCpf());
    }

    @Test
    void deveRejeitarCpfInvalido() {
        Hospede h = new Hospede();
        assertThrows(IllegalArgumentException.class,
            () -> h.setCpf("123"));
    }

    @Test
    void deveRejeitarCpfNulo() {
        Hospede h = new Hospede();
        assertThrows(IllegalArgumentException.class,
            () -> h.setCpf(null));
    }

    @Test
    void deveRetornarCpfInicialNulo() {
        Hospede h = new Hospede();
        assertNull(h.getCpf());
    }

    @Test
    void deveAlterarCpf() {
        Hospede h = new Hospede();
        h.setCpf("12345678909");
        h.setCpf("98765432100");
        assertEquals("98765432100", h.getCpf());
    }

    @Test
    void deveRegistrarTelefone() {
        Hospede h = new Hospede();
        h.setTelefone("31999999999");
        assertEquals("31999999999", h.getTelefone());
    }

    @Test
    void deveRejeitarTelefoneInvalido() {
        Hospede h = new Hospede();
        assertThrows(IllegalArgumentException.class,
            () -> h.setTelefone("123"));
    }

    @Test
    void deveRejeitarTelefoneNulo() {
        Hospede h = new Hospede();
        assertThrows(IllegalArgumentException.class,
            () -> h.setTelefone(null));
    }

    @Test
    void deveRetornarTelefoneInicialNulo() {
        Hospede h = new Hospede();
        assertNull(h.getTelefone());
    }

    @Test
    void deveAlterarTelefone() {
        Hospede h = new Hospede();
        h.setTelefone("31999999999");
        h.setTelefone("3133334444");
        assertEquals("3133334444", h.getTelefone());
    }

    @Test
    void deveRegistrarEmail() {
        Hospede h = new Hospede();
        h.setEmail("joao@exemplo.com");
        assertEquals("joao@exemplo.com", h.getEmail());
    }

    @Test
    void deveRejeitarEmailInvalido() {
        Hospede h = new Hospede();
        assertThrows(IllegalArgumentException.class,
            () -> h.setEmail("joao123"));
    }

    @Test
    void deveRejeitarEmailNulo() {
        Hospede h = new Hospede();
        assertThrows(IllegalArgumentException.class,
            () -> h.setEmail(null));
    }

    @Test
    void deveRetornarEmailInicialNulo() {
        Hospede h = new Hospede();
        assertNull(h.getEmail());
    }

    @Test
    void deveAlterarEmail() {
        Hospede h = new Hospede();
        h.setEmail("joao@exemplo.com");
        h.setEmail("pedro@exemplo.com");
        assertEquals("pedro@exemplo.com", h.getEmail());
    }
}