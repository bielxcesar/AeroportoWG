package com.wgAeroporto.model.factory;

import java.util.Date;

public abstract class PasageiroFactory {
    public abstract Passageiro criarPassageiro(int id, String nome, String sobrenome, Date dataNascimento, String genero, String email, String celular, String cpf);
}
