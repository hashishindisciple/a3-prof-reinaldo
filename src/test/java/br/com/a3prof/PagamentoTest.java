package br.com.a3prof;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PagamentoTest {

    @Test
    void deveAceitarValorPositivo() {
        assertTrue(new Pagamento().validarValor(100));
    }

    @Test
    void deveRejeitarValorZero() {
        assertFalse(new Pagamento().validarValor(0));
    }

    @Test
    void deveRejeitarValorNegativo() {
        assertFalse(new Pagamento().validarValor(-50));
    }

    @Test
    void deveRegistrarValorPositivo() {
        Pagamento p = new Pagamento();
        p.setValor(150);
        assertEquals(150, p.getValor());
    }

    @Test
    void deveImpedirRegistroDeValorZero() {
        assertThrows(IllegalArgumentException.class,
            () -> new Pagamento().setValor(0));
    }

    @Test
    void deveImpedirRegistroDeValorNegativo() {
        assertThrows(IllegalArgumentException.class,
            () -> new Pagamento().setValor(-100));
    }

    @Test
    void deveRetornarValorInicial() {
        assertEquals(0, new Pagamento().getValor());
    }

    @Test
    void deveRetornarValorAlterado() {
        Pagamento p = new Pagamento();
        p.setValor(100);
        p.setValor(200);
        assertEquals(200, p.getValor());
    }

    @Test
    void deveRegistrarDataAtual() {
        Pagamento p = new Pagamento();
        LocalDate data = LocalDate.now();
        p.setData(data);
        assertEquals(data, p.getData());
    }

    @Test
    void deveRegistrarDataAnterior() {
        Pagamento p = new Pagamento();
        LocalDate data = LocalDate.now().minusDays(1);
        p.setData(data);
        assertEquals(data, p.getData());
    }

    @Test
    void deveRejeitarDataNula() {
        assertThrows(IllegalArgumentException.class,
            () -> new Pagamento().setData(null));
    }

    @Test
    void deveRetornarDataInicial() {
        assertNull(new Pagamento().getData());
    }

    @Test
    void deveRegistrarPix() {
        Pagamento p = new Pagamento();
        p.setFormaPagamento("PIX");
        assertEquals("PIX", p.getFormaPagamento());
    }

    @Test
    void deveRegistrarCartao() {
        Pagamento p = new Pagamento();
        p.setFormaPagamento("Cartao");
        assertEquals("Cartao", p.getFormaPagamento());
    }

    @Test
    void deveRegistrarDinheiro() {
        Pagamento p = new Pagamento();
        p.setFormaPagamento("Dinheiro");
        assertEquals("Dinheiro", p.getFormaPagamento());
    }

    @Test
    void deveRejeitarFormaInvalida() {
        assertThrows(IllegalArgumentException.class,
            () -> new Pagamento().setFormaPagamento("Invalido"));
    }

    @Test
    void deveRegistrarSituacaoPago() {
        Pagamento p = new Pagamento();
        p.setSituacao("Pago");
        assertEquals("Pago", p.getSituacao());
    }

    @Test
    void deveRegistrarSituacaoPendente() {
        Pagamento p = new Pagamento();
        p.setSituacao("Pendente");
        assertEquals("Pendente", p.getSituacao());
    }

    @Test
    void deveRegistrarSituacaoCancelado() {
        Pagamento p = new Pagamento();
        p.setSituacao("Cancelado");
        assertEquals("Cancelado", p.getSituacao());
    }

    @Test
    void deveRejeitarSituacaoInvalida() {
        assertThrows(IllegalArgumentException.class,
            () -> new Pagamento().setSituacao("Invalido"));
    }
}