package br.com.a3prof;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServicoTest {

    @Test
    void deveRegistrarDescricao() {
        Servico s = new Servico();
        s.setDescricao("Lavanderia");
        assertEquals("Lavanderia", s.getDescricao());
    }

    @Test
    void deveRejeitarDescricaoVazia() {
        Servico s = new Servico();
        assertThrows(IllegalArgumentException.class,
            () -> s.setDescricao(""));
    }

    @Test
    void deveRejeitarDescricaoNula() {
        Servico s = new Servico();
        assertThrows(IllegalArgumentException.class,
            () -> s.setDescricao(null));
    }

    @Test
    void deveRetornarDescricaoInicial() {
        assertNull(new Servico().getDescricao());
    }

    @Test
    void deveRetornarDescricaoAlterada() {
        Servico s = new Servico();
        s.setDescricao("Lavanderia");
        s.setDescricao("Limpeza");
        assertEquals("Limpeza", s.getDescricao());
    }

    @Test
    void deveRegistrarPreco() {
        Servico s = new Servico();
        s.setPreco(50);
        assertEquals(50, s.getPreco());
    }

    @Test
    void deveRejeitarPrecoZero() {
        Servico s = new Servico();
        assertThrows(IllegalArgumentException.class,
            () -> s.setPreco(0));
    }

    @Test
    void deveRejeitarPrecoNegativo() {
        Servico s = new Servico();
        assertThrows(IllegalArgumentException.class,
            () -> s.setPreco(-10));
    }

    @Test
    void deveRetornarPrecoInicial() {
        assertEquals(0, new Servico().getPreco());
    }

    @Test
    void deveRetornarPrecoAlterado() {
        Servico s = new Servico();
        s.setPreco(50);
        s.setPreco(80);
        assertEquals(80, s.getPreco());
    }
}