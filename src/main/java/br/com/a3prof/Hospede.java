package br.com.a3prof;

public class Hospede {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("Nome invalido");

        this.nome = nome;
    }
}