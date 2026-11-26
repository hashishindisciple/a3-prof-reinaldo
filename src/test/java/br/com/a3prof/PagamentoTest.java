package br.com.a3prof;

import java.time.LocalDate;
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

    @Test
    void deveRegistrarValorPositivo() {
        Pagamento pagamento = new Pagamento();
        pagamento.setValor(150.0);
        assertEquals(150.0, pagamento.getValor());
    }

    @Test
    void deveImpedirRegistroDeValorZero() {
        Pagamento pagamento = new Pagamento();
        assertThrows(IllegalArgumentException.class,
            () -> pagamento.setValor(0.0));
    }

    @Test
    void deveImpedirRegistroDeValorNegativo() {
        Pagamento pagamento = new Pagamento();
        assertThrows(IllegalArgumentException.class,
            () -> pagamento.setValor(-100.0));
    }

    @Test
    void deveRegistrarDataAtual() {
        Pagamento pagamento = new Pagamento();
        LocalDate data = LocalDate.now();
        pagamento.setData(data);
        assertEquals(data, pagamento.getData());
    }

    @Test
    void deveRegistrarDataAnterior() {
        Pagamento pagamento = new Pagamento();
        LocalDate data = LocalDate.now().minusDays(1);
        pagamento.setData(data);
        assertEquals(data, pagamento.getData());
    }

    @Test
    void deveRejeitarDataNula() {
        Pagamento pagamento = new Pagamento();
        assertThrows(IllegalArgumentException.class,
            () -> pagamento.setData(null));
    }
}