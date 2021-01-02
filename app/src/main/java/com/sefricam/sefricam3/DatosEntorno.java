package com.sefricam.sefricam3;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class DatosEntorno implements Serializable {

    private final double tInicio;
    private final double tFin;
    private final int zonificacion;
    private final int viento;
    private final String direccionViento;
    private final int nubes;
    private final int lluvia;
    private final ArrayList<Boolean> plantas;
    private final String EP37;
    private final String EP38;

    public DatosEntorno(double tInicio, double tFin, int zonificacion, int viento, String direccionViento, int nubes, int lluvia, ArrayList<Boolean> plantas, String EP37,  String EP38) {
        this.tInicio = tInicio;
        this.tFin = tFin;
        this.zonificacion = zonificacion;
        this.viento = viento;
        this.direccionViento = direccionViento;
        this.nubes = nubes;
        this.lluvia = lluvia;
        this.plantas = plantas;
        this.EP37 = EP37;
        this.EP38 = EP38;
    }

    public double gettInicio() {
        return tInicio;
    }

    public double gettFin() {
        return tFin;
    }

    public int getZonificacion() {
        return zonificacion;
    }

    public int getViento() {
        return viento;
    }

    public String getDireccionViento() {
        return direccionViento;
    }

    public int getNubes() {
        return nubes;
    }

    public int getLluvia() {
        return lluvia;
    }

    public ArrayList<Boolean> getPlantas() {
        return plantas;
    }

    public String getEP37() {
        return EP37;
    }

    public String getEP38() {
        return EP38;
    }
}
