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
}