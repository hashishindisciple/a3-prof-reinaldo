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

    @Test
    void deveRegistrarCategoria() {
        Quarto q = new Quarto();
        q.setCategoria("Simples");
        assertEquals("Simples", q.getCategoria());
    }

    @Test
    void deveRejeitarCategoriaVazia() {
        Quarto q = new Quarto();
        assertThrows(IllegalArgumentException.class,
            () -> q.setCategoria(""));
    }

    @Test
    void deveRejeitarCategoriaNula() {
        Quarto q = new Quarto();
        assertThrows(IllegalArgumentException.class,
            () -> q.setCategoria(null));
    }

    @Test
    void deveRegistrarPreco() {
        Quarto q = new Quarto();
        q.setPreco(150);
        assertEquals(150, q.getPreco());
    }

    @Test
    void deveRejeitarPrecoZero() {
        Quarto q = new Quarto();
        assertThrows(IllegalArgumentException.class,
            () -> q.setPreco(0));
    }

    @Test
    void deveRejeitarPrecoNegativo() {
        Quarto q = new Quarto();
        assertThrows(IllegalArgumentException.class,
            () -> q.setPreco(-50));
    }
}