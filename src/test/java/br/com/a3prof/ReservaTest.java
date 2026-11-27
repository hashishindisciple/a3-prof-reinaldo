package br.com.a3prof;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaTest {

    @Test
    void testReserva() {
        Reserva reserva = new Reserva();

        assertEquals(1, reserva.getId());
    }
    @Test
    void defineDatasDaReserva() {
        Reserva reserva = new Reserva();
        LocalDate entrada = LocalDate.of(2026, 12, 10);
        LocalDate saida = LocalDate.of(2026, 12, 15);

        reserva.setDatas(entrada, saida);

        assertEquals(entrada, reserva.getEntrada());
        assertEquals(saida, reserva.getSaida());
    }
    @Test
    void rejeitaSaidaAntesDaEntrada() {
        Reserva reserva = new Reserva();

        assertThrows(IllegalArgumentException.class, () ->
                reserva.setDatas(
                        LocalDate.of(2026, 12, 15),
                        LocalDate.of(2026, 12, 10)
                )
        );
    }
    @Test
    void reservaNovaNaoTemDatas() {
        Reserva reserva = new Reserva();

        assertNull(reserva.getEntrada());
        assertNull(reserva.getSaida());
    }
    @Test
    void idDaReservaNaoMuda() {
        Reserva reserva = new Reserva();

        assertEquals(1, reserva.getId());
    }
    @Test
    void rejeitaEntradaNula() {
        Reserva reserva = new Reserva();

        assertThrows(IllegalArgumentException.class, () ->
                reserva.setDatas(null, LocalDate.of(2026, 12, 15))
        );
    }
    @Test
    void rejeitaSaidaNula() {
        Reserva reserva = new Reserva();

        assertThrows(IllegalArgumentException.class, () ->
                reserva.setDatas(LocalDate.of(2026, 12, 10), null)
        );
    }
    @Test
    void calculaQuantidadeDeDiarias() {
        Reserva reserva = new Reserva();
        reserva.setDatas(
                LocalDate.of(2026, 12, 10),
                LocalDate.of(2026, 12, 15)
        );

        assertEquals(5, reserva.getQuantidadeDiarias());
    }
    @Test
    void calculaValorTotal() {
        Reserva reserva = new Reserva();
        reserva.setDatas(
                LocalDate.of(2026, 12, 10),
                LocalDate.of(2026, 12, 15)
        );
        reserva.setValorDiaria(100.0);

        assertEquals(500.0, reserva.getValorTotal());
    }
    @Test
    void rejeitaValorDeDiariaNaoPositivo() {
        Reserva reserva = new Reserva();

        assertThrows(IllegalArgumentException.class,
                () -> reserva.setValorDiaria(0));
    }

    @Test
    void criaReservaComIdDiferente() {
        assertEquals(25, new Reserva(25).getId());
    }

    @Test
    void rejeitaIdDeReservaInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Reserva(0));
    }

    @Test
    void associaHospedeEQuarto() {
        Hospede hospede = new Hospede();
        Quarto quarto = new Quarto();
        Reserva reserva = new Reserva(2);

        reserva.setHospede(hospede);
        reserva.setQuarto(quarto);

        assertSame(hospede, reserva.getHospede());
        assertSame(quarto, reserva.getQuarto());
    }

    @Test
    void rejeitaAssociacoesNulas() {
        Reserva reserva = new Reserva(2);

        assertThrows(IllegalArgumentException.class, () -> reserva.setHospede(null));
        assertThrows(IllegalArgumentException.class, () -> reserva.setQuarto(null));
    }

    @Test
    void rejeitaDatasIguais() {
        Reserva reserva = new Reserva();
        LocalDate data = LocalDate.of(2026, 12, 10);

        assertThrows(IllegalArgumentException.class, () -> reserva.setDatas(data, data));
    }

    @Test
    void substituiHospedeAssociado() {
        Reserva reserva = new Reserva(3);
        Hospede primeiro = new Hospede();
        Hospede segundo = new Hospede();
        reserva.setHospede(primeiro);
        reserva.setHospede(segundo);
        assertSame(segundo, reserva.getHospede());
    }

    @Test
    void substituiQuartoAssociado() {
        Reserva reserva = new Reserva(3);
        Quarto primeiro = new Quarto();
        Quarto segundo = new Quarto();
        reserva.setQuarto(primeiro);
        reserva.setQuarto(segundo);
        assertSame(segundo, reserva.getQuarto());
    }

    @Test
    void atualizaPeriodoDaReserva() {
        Reserva reserva = new Reserva();
        LocalDate novaEntrada = LocalDate.of(2026, 12, 20);
        LocalDate novaSaida = LocalDate.of(2026, 12, 22);
        reserva.setDatas(LocalDate.of(2026, 12, 10), LocalDate.of(2026, 12, 12));
        reserva.setDatas(novaEntrada, novaSaida);
        assertEquals(novaEntrada, reserva.getEntrada());
        assertEquals(novaSaida, reserva.getSaida());
    }

    @Test
    void calculaDiariaDeUmaNoite() {
        Reserva reserva = new Reserva();
        reserva.setDatas(LocalDate.of(2026, 12, 10), LocalDate.of(2026, 12, 11));
        assertEquals(1, reserva.getQuantidadeDiarias());
    }

    @Test
    void calculaTotalParaUmaNoite() {
        Reserva reserva = new Reserva();
        reserva.setDatas(LocalDate.of(2026, 12, 10), LocalDate.of(2026, 12, 11));
        reserva.setValorDiaria(150);
        assertEquals(150, reserva.getValorTotal());
    }

}
