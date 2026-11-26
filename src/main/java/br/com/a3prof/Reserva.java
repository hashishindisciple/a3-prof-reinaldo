package br.com.a3prof;

import java.time.LocalDate;

public class Reserva {

    private int id;
    private LocalDate entrada;
    private LocalDate saida;

    public void setDatas(LocalDate entrada, LocalDate saida) {
        if (entrada == null || saida == null || saida.isBefore(entrada)) {
            throw new IllegalArgumentException("Data de saída não pode ser anterior à data de entrada.");
        }
        this.entrada = entrada;
        this.saida = saida;
    }

    public int getId() {
        return id;
    }
    public Reserva() {
        this.id = 1;
    }
    public LocalDate getEntrada() {
        return entrada;
    }

    public LocalDate getSaida() {
        return saida;
    }
}
