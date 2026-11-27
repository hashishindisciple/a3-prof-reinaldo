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

}
