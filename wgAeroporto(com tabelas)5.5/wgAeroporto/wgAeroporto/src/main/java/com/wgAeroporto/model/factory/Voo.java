package com.wgAeroporto.model.factory;
import java.util.Date;

public interface Voo {
     int id();
     String saida();
     String destino();
     String horaIda();
     String horaVolta();
     Date diaIda();
     Date diaVolta();
}
