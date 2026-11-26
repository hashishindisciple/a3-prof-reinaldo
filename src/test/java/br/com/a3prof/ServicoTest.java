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
    void deveRegistrarPreco() {
        Servico s = new Servico();
        s.setPreco(50.0);
        assertEquals(50.0, s.getPreco());
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
}