package com.wgAeroporto.model.builder;
import com.wgAeroporto.model.factory.Passageiro;
import com.wgAeroporto.model.factory.PassageiroComum;

import java.util.Date;


public class BuilderPassageiro {
    private int id;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private String genero;
    private String email;
    private String celular;
    private String cpf;

    public  int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public String getEmail() {
        return email;
    }

    public String getCelular() {
        return celular;
    }

    public  String getCpf() {
        return cpf;
    }

    public BuilderPassageiro id(int id) {
        this.id = id;
        return this;
    }

    public BuilderPassageiro nome(String nome) {
        this.nome = nome;
        return this;
    }

    public BuilderPassageiro sobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public BuilderPassageiro dataNacimento(Date dataNacimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public BuilderPassageiro genero(String genero) {
        this.genero = genero;
        return this;
    }

    public BuilderPassageiro email(String email) {
        this.email = email;
        return this;
    }

    public BuilderPassageiro celular(String celular) {
        this.celular = celular;
        return this;
    }

    public BuilderPassageiro cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public PassageiroComum build() {
        return new PassageiroComum(id, nome, sobrenome, dataNascimento, genero, email, celular, cpf);
    }
}
