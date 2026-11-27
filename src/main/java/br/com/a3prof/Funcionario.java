package br.com.a3prof;

public class Funcionario {
    private final int id;
    private final String nome;
    private double salario;

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
    public void setSalario(double salario) {
        if (salario <= 0) {
            throw new IllegalArgumentException("Salario deve ser positivo.");
        }
        this.salario = salario;
    }
    public double getSalario() {
        return salario;
    }

    public void aplicarReajuste(double percentual) {
        salario += salario * percentual / 100;
    }
}