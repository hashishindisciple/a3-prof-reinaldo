package br.com.a3prof;

import org.junit.jupiter.api.Test;

public class ReservaTeste {

    @Test
    void testReserva() {
        Reserva reserva = new Reserva();

        assertEquals(1, reserva.getId());
    }
}
