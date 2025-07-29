package com.wgAeroporto.model.factory;

import java.util.Date;

public class PassageiroComum implements Passageiro { // Agora implementa a interface
    private int id;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private String genero;
    private String email;
    private String celular;
    private String cpf;

    public PassageiroComum(int id, String nome, String sobrenome, Date dataNascimento, String genero, String email, String celular, String cpf) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.email = email;
        this.celular = celular;
        this.cpf = cpf;
    }

    @Override public int id() { return id; }
    @Override public String nome() { return nome; }
    @Override public String sobrenome() { return sobrenome; }
    @Override public Date dataNascimento() { return dataNascimento; }
    @Override public String genero() { return genero; }
    @Override public String email() { return email; }
    @Override public String celular() { return celular; }
    @Override public String cpf() { return cpf; }
}
