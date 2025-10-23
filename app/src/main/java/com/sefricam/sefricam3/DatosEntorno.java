package com.sefricam.sefricam3;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Getter;

/**
 * This is a Object Class in order to make data more readable at debug. Contains all the data related
 * to the DatosEntorno that we store in the Parse DB
 */
@Getter
public class DatosEntorno implements Serializable {

    private final double tInicio;
    private final double tFin;
    private final int zonificacion;
    private final int viento;
    private final String direccionViento;
    private final int nubes;
    private final int lluvia;
    private final ArrayList<Integer> plantas;
    private final String EP37;
    private final String EP38;

    public DatosEntorno(double tInicio, double tFin, int zonificacion, int viento, String direccionViento, int nubes, int lluvia, ArrayList<Integer> plantas, String EP37, String EP38) {
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

}
