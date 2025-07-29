package com.wgAeroporto.model.factory;
import java.util.Date;

public class VooComum implements Voo {
    private int id;
    private String saida;
    private String destino;
    private String horaIda;
    private String horaVolta;
    private Date diaIda;
    private Date diaVolta;

    public VooComum(int id, String saida, String destino, String horaIda, String horaVolta, Date diaIda, Date diaVolta) {
        this.id = id;
        this.saida = saida;
        this.destino = destino;
        this.horaIda = horaIda;
        this.horaVolta = horaVolta;
        this.diaIda = diaIda;
        this.diaVolta = diaVolta;
    }

    @Override
    public int id() { return id; }
    @Override
    public String saida() { return saida; }
    @Override
    public String destino() { return destino; }
    @Override
    public String horaIda() { return horaIda; }
    @Override
    public String horaVolta() { return horaVolta; }
    @Override
    public Date diaIda() { return diaIda; }
    @Override
    public Date diaVolta() { return diaVolta; }
}
