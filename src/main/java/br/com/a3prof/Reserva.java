package br.com.a3prof;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {

    private final int id;
    private Hospede hospede;
    private Quarto quarto;
    private LocalDate entrada;
    private LocalDate saida;
    private double valorDiaria;

    public Reserva() {
        this(1);
    }

    public Reserva(int id) {
        if (id <= 0) throw new IllegalArgumentException("Id invalido");
        this.id = id;
    }

    public Hospede getHospede() { return hospede; }
    public void setHospede(Hospede hospede) {
        if (hospede == null) throw new IllegalArgumentException("Hospede obrigatorio");
        this.hospede = hospede;
    }

    public Quarto getQuarto() { return quarto; }
    public void setQuarto(Quarto quarto) {
        if (quarto == null) throw new IllegalArgumentException("Quarto obrigatorio");
        this.quarto = quarto;
    }

    public void setDatas(LocalDate entrada, LocalDate saida) {
        if (entrada == null || saida == null || !saida.isAfter(entrada)) {
            throw new IllegalArgumentException("Saida deve ser posterior a entrada.");
        }
        this.entrada = entrada;
        this.saida = saida;
    }

    public long getQuantidadeDiarias() {
        return ChronoUnit.DAYS.between(entrada, saida);
    }

    public void setValorDiaria(double valorDiaria) {
        if (valorDiaria <= 0) {
            throw new IllegalArgumentException(
                    "O valor da diária deve ser positivo."
            );
        }
        this.valorDiaria = valorDiaria;
    }
    public double getValorTotal() {
        return getQuantidadeDiarias() * valorDiaria;
    }
    public int getId() {
        return id;
    }
    public LocalDate getEntrada() {
        return entrada;
    }

    public LocalDate getSaida() {
        return saida;
    }
}
