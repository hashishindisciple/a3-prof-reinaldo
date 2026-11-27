package br.com.a3prof;

public class Quarto {

    private int numero;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        validarNumero(numero);
        this.numero = numero;
    }

    private void validarNumero(int numero) {
        if (numero <= 0)
            throw new IllegalArgumentException("Numero invalido");
    }
}