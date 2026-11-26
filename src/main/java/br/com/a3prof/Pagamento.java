package br.com.a3prof;

public class Pagamento {

    private double valor;

    public boolean validarValor(double valor) {
        return valor > 0;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (!validarValor(valor)) {
            throw new IllegalArgumentException("Valor invalido");
        }

        this.valor = valor;
    }
}