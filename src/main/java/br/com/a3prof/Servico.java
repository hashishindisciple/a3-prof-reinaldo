package br.com.a3prof;

public class Servico {

    private String descricao;
    private double preco;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        validarDescricao(descricao);
        this.descricao = descricao;
    }

    private void validarDescricao(String descricao) {
        if (descricao == null || descricao.isBlank())
            throw new IllegalArgumentException("Descricao invalida");
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
    }
}