package com.wgAeroporto.model.builder;

import com.wgAeroporto.model.factory.VooComum;

import java.util.Date;

public class BuilderVoo {
    private int id;
    private String saida;
    private String destino;
    private String horaIda;
    private String horaVolta;
    private Date diaIda;
    private Date diaVolta;

    // Métodos para configurar os atributos do voo
    public BuilderVoo id(int id) {
        this.id = id;
        return this;
    }

    public BuilderVoo saida(String saida) {
        this.saida = saida;
        return this;
    }

    public BuilderVoo destino(String destino) {
        this.destino = destino;
        return this;
    }

    public BuilderVoo horaIda(String horaIda) {
        this.horaIda = horaIda;
        return this;
    }

    public BuilderVoo horaVolta(String horaVolta) {
        this.horaVolta = horaVolta;
        return this;
    }

    public BuilderVoo diaIda(Date diaIda) {
        this.diaIda = diaIda;
        return this;
    }

    public BuilderVoo diaVolta(Date diaVolta) {
        this.diaVolta = diaVolta;
        return this;
    }

    // Método final que constrói um objeto Voo
    public VooComum build() {
        return new VooComum(id, saida, destino, horaIda, horaVolta, diaIda, diaVolta);
    }
}
