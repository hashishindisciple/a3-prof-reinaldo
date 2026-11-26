package br.com.a3prof;

import java.time.LocalDate;

public class Reserva {

    private int id;
    private LocalDate entrada;
    private LocalDate saida;

    public int getId() {
        return id;
    }
    public Reserva() {
        this.id = 1;
    }
}
