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
}