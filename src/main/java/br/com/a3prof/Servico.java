package br.com.a3prof;

public class Servico {

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isBlank())
            throw new IllegalArgumentException("Descricao invalida");

        this.descricao = descricao;
    }
}