package br.org.soujava.exemplo_kafka.model;

public class Cliente {
    private String nome;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Cliente() {
    }
}
