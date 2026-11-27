package br.com.a3prof;

public class Hospede {

    private String nome;
    private String cpf;
    private String telefone;
    private String email;

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
        validarCpf(cpf);
        this.cpf = cpf;
    }

    private void validarCpf(String cpf) {
        if (cpf == null || !cpf.matches("[0-9]{11}"))
            throw new IllegalArgumentException("CPF invalido");
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        validarTelefone(telefone);
        this.telefone = telefone;
    }

    private void validarTelefone(String telefone) {
        if (telefone == null || !telefone.matches("[0-9]{10,11}"))
            throw new IllegalArgumentException("Telefone invalido");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validarEmail(email);
        this.email = email;
    }

    private void validarEmail(String email) {
        if (email == null || !email.matches("[^\\s@]+@[^\\s@]+\\.[^\\s@]+"))
            throw new IllegalArgumentException("Email invalido");
    }
}