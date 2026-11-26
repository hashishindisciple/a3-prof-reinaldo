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
}