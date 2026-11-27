package br.com.a3prof;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuartoTest {

    @Test
    void deveRegistrarNumero() {
        Quarto q = new Quarto();
        q.setNumero(101);
        assertEquals(101, q.getNumero());
    }

    @Test
    void deveRejeitarNumeroZero() {
        Quarto q = new Quarto();
        assertThrows(IllegalArgumentException.class,
            () -> q.setNumero(0));
    }

    @Test
    void deveRejeitarNumeroNegativo() {
        Quarto q = new Quarto();
        assertThrows(IllegalArgumentException.class,
            () -> q.setNumero(-1));
    }
}