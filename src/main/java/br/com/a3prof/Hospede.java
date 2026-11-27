package br.com.a3prof;

public class Hospede {

    private String nome;
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarNome(nome);
        this.nome = nome;
    }

    private void validarNome(String nome) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("Nome invalido");
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || !cpf.matches("[0-9]{11}"))
            throw new IllegalArgumentException("CPF invalido");

        this.cpf = cpf;
    }
}