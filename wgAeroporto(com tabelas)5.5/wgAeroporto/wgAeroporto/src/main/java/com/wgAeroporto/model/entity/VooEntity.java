package com.wgAeroporto.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "voo")
public class VooEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @JsonProperty("saida")
        private String saida;

        @JsonProperty("destino")
        private String destino;

        @JsonProperty("horaIda") // Corrigido
        private String horaIda;

        @JsonProperty("horaVolta")
        private String horaVolta;

        @JsonProperty("diaIda")
        private Date diaIda;

        @JsonProperty("diaVolta")
        private Date diaVolta;


        // Getters e Setters corrigidos
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getSaida() {
            return saida;
        }

        public void setSaida(String saida) {
            this.saida = saida;
        }

        public String getHoraIda() {
            return horaIda;
        }

        public void setHoraIda(String horaIda) {
            this.horaIda = horaIda;
        }

        public String getHoraVolta() {
            return horaVolta;
        }

        public void setHoraVolta(String horaVolta) {
            this.horaVolta = horaVolta;
        }

        public Date getDiaIda() {
            return diaIda;
        } // Corrigido

        public void setDiaIda(Date diaIda) {
            this.diaIda = diaIda;
        } // Corrigido

        public Date getDiaVolta() {
            return diaVolta;
        } // Corrigido

        public void setDiaVolta(Date diaVolta) {
            this.diaVolta = diaVolta;
        } // Corrigido
}
