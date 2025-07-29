package com.wgAeroporto.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "passageiro")
public class PassageiroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("sobrenome")
    private String sobrenome;

    @JsonProperty("dataNascimento") // Corrigido
    private Date dataNascimento;

    @JsonProperty("genero")
    private String genero;

    @JsonProperty("email")
    private String email;

    @JsonProperty("celular")
    private String celular;

    @JsonProperty("cpf")
    private String cpf;

    // Getters e Setters corrigidos
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }

    public Date getDataNascimento() { return dataNascimento; } // Corrigido
    public void setDataNascimento(Date dataNascimento) { this.dataNascimento = dataNascimento; } // Corrigido

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }  // Adicionado

    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
}
