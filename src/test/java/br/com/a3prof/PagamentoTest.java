package br.com.a3prof;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PagamentoTest {

    @Test
    void deveAceitarValorPositivo() {
        Pagamento pagamento = new Pagamento();
        assertTrue(pagamento.validarValor(100.0));
    }

    @Test
    void deveRejeitarValorZero() {
        Pagamento pagamento = new Pagamento();
        assertFalse(pagamento.validarValor(0.0));
    }

    @Test
    void deveRejeitarValorNegativo() {
        Pagamento pagamento = new Pagamento();
        assertFalse(pagamento.validarValor(-50.0));
    }
}