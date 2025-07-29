package com.wgAeroporto.model.factory;

import java.util.Date;

public class PassageiroComumFactory extends PasageiroFactory { // Agora herda a superclasse
    @Override
    public Passageiro criarPassageiro(int id, String nome, String sobrenome, Date dataNascimento, String genero, String email, String celular, String cpf) {
        return new PassageiroComum(id, nome, sobrenome, dataNascimento, genero, email, celular, cpf);
    }
}
