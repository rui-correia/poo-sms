package model;

import java.util.List;

public class Pessoa {

    private String nome;
    private Integer cpf;
    private Integer telefone;
    private List<String> listaSms;

    public Pessoa(String nome, Integer cpf, Integer telefone, List<String> listaSms) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.listaSms = listaSms;
    }

    @Override
    public String toString() {
        return  "Nome: " + nome + " | CPF: " + cpf;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setListaSms(List<String> listaSms) {
        this.listaSms = listaSms;
    }

    public List<String> getListaSms() {
        return listaSms;
    }

    public Integer getCpf() {
        return cpf;
    }
}
