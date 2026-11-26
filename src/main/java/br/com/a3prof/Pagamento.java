package br.com.a3prof;

import java.time.LocalDate;

public class Pagamento {

    private double valor;
    private LocalDate data;
    private String formaPagamento;

    public boolean validarValor(double valor) {
        return valor > 0;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        validarRegistro(valor);
        this.valor = valor;
    }

    private void validarRegistro(double valor) {
        if (!validarValor(valor)) {
            throw new IllegalArgumentException("Valor invalido");
        }
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("Data invalida");
        }

        this.data = data;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        if (!"PIX".equals(formaPagamento) &&
            !"Cartao".equals(formaPagamento) &&
            !"Dinheiro".equals(formaPagamento)) {
            throw new IllegalArgumentException("Forma de pagamento invalida");
        }

        this.formaPagamento = formaPagamento;
    }
}