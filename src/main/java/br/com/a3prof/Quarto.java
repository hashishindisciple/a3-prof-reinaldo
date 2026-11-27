package br.com.a3prof;

public class Quarto {

    private int numero;
    private String categoria;

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        validarCategoria(categoria);
        this.categoria = categoria;
    }

    private void validarCategoria(String categoria) {
        if (categoria == null || categoria.isBlank())
            throw new IllegalArgumentException("Categoria invalida");
    }
}