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
    void deveRetornarNumeroInicial() {
        assertEquals(0, new Quarto().getNumero());
    }

    @Test
    void deveRetornarNumeroAlterado() {
        Quarto q = new Quarto();
        q.setNumero(101);
        q.setNumero(102);
        assertEquals(102, q.getNumero());
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
    void deveRetornarCategoriaInicial() {
        assertNull(new Quarto().getCategoria());
    }

    @Test
    void deveRetornarCategoriaAlterada() {
        Quarto q = new Quarto();
        q.setCategoria("Simples");
        q.setCategoria("Luxo");
        assertEquals("Luxo", q.getCategoria());
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

    @Test
    void deveRetornarPrecoInicial() {
        assertEquals(0, new Quarto().getPreco());
    }

    @Test
    void deveRetornarPrecoAlterado() {
        Quarto q = new Quarto();
        q.setPreco(150);
        q.setPreco(200);
        assertEquals(200, q.getPreco());
    }

    @Test
    void deveRegistrarDisponivel() {
        Quarto q = new Quarto();
        q.setSituacao("Disponivel");
        assertEquals("Disponivel", q.getSituacao());
    }

    @Test
    void deveRegistrarOcupado() {
        Quarto q = new Quarto();
        q.setSituacao("Ocupado");
        assertEquals("Ocupado", q.getSituacao());
    }

    @Test
    void deveRegistrarManutencao() {
        Quarto q = new Quarto();
        q.setSituacao("Manutencao");
        assertEquals("Manutencao", q.getSituacao());
    }

    @Test
    void deveRejeitarSituacaoInvalida() {
        Quarto q = new Quarto();
        assertThrows(IllegalArgumentException.class,
            () -> q.setSituacao("Invalida"));
    }
}