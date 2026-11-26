package br.com.a3prof;

import java.time.LocalDate;

public class Pagamento {

    private double valor;
    private LocalDate data;
    private String formaPagamento;
    private String situacao;

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
        if (!validarValor(valor))
            throw new IllegalArgumentException("Valor invalido");
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (data == null)
            throw new IllegalArgumentException("Data invalida");
        this.data = data;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        validarFormaPagamento(formaPagamento);
        this.formaPagamento = formaPagamento;
    }

    private void validarFormaPagamento(String forma) {
        if (!"PIX".equals(forma) && !"Cartao".equals(forma) && !"Dinheiro".equals(forma))
            throw new IllegalArgumentException("Forma invalida");
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        if (!"Pago".equals(situacao) && !"Pendente".equals(situacao) && !"Cancelado".equals(situacao))
            throw new IllegalArgumentException("Situacao invalida");
        this.situacao = situacao;
    }
}