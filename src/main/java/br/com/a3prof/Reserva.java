package br.com.a3prof;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {

    private final int id;
    private LocalDate entrada;
    private LocalDate saida;
    private double valorDiaria;

    public void setDatas(LocalDate entrada, LocalDate saida) {
        if (entrada == null || saida == null || saida.isBefore(entrada)) {
            throw new IllegalArgumentException("Data de saída não pode ser anterior à data de entrada.");
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
