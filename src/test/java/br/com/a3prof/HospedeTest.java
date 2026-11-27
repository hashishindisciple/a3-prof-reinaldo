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
}