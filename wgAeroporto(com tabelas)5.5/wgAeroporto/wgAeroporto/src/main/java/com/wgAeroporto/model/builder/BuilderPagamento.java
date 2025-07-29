package com.wgAeroporto.model.builder;

import com.wgAeroporto.model.factory.Passageiro;
import java.util.Date;

public class BuilderPagamento {
    private int id;
    private String numCartao;
    private Date validade;
    private int codSeguranca;
    private String nome;
    private int parcela;

    public  int getId() {
        return id;
    }
    public String getNumCartao() {
        return numCartao;
    }
    public Date getValidade() {
        return validade;
    }
    public int getCodSeguranca() {
        return codSeguranca;
    }
    public String getNome() {
        return nome;
    }
    public int getParcela() {
        return parcela;
    }

    public BuilderPagamento id(int id) {
        this.id = id;
        return this;
    }

    public BuilderPagamento numCartao(String numCartao) {
        this.numCartao = numCartao;
        return this;
    }

    public BuilderPagamento validade(Date validade) {
        this.validade = validade;
        return this;
    }

    public BuilderPagamento codSeguranca(int codSeguranca) {
        this.codSeguranca = codSeguranca;
        return this;
    }

    public BuilderPagamento nome(String nome) {
        this.nome = nome;
        return this;
    }

    public BuilderPagamento parcela(int parcela) {
        this.parcela = parcela;
        return this;
    }

}
