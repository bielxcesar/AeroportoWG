package com.wgAeroporto.model.factory;
import java.util.Date;

public interface Passageiro {
     int id();
     String nome();
     String sobrenome();
     Date dataNascimento();
     String genero();
     String email();
     String celular();
     String cpf();
}
