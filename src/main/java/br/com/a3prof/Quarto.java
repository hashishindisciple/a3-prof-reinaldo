package br.com.a3prof;

public class Quarto {

    private int numero;
    private String categoria;
    private double preco;
    private String situacao;

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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        validarPreco(preco);
        this.preco = preco;
    }

    private void validarPreco(double preco) {
        if (preco <= 0)
            throw new IllegalArgumentException("Preco invalido");
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        if (!"Disponivel".equals(situacao) &&
            !"Ocupado".equals(situacao) &&
            !"Manutencao".equals(situacao))
            throw new IllegalArgumentException("Situacao invalida");

        this.situacao = situacao;
    }
}