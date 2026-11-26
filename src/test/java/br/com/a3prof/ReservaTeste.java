package br.com.a3prof;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReservaTeste {

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
}
