package br.com.a3prof;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservaTeste {

    @Test
    void testReserva() {
        Reserva reserva = new Reserva();

        assertEquals(1, reserva.getId());
    }
}
