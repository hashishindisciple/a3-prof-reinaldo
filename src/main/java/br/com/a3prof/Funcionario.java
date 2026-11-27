package br.com.a3prof;

public class Funcionario {
    private final int id;
    private final String nome;

    public Funcionario(int id, String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome obrigatório.");
        }
        this.id = id;
        this.nome = nome.trim();
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
}