package com.sefricam.sefricam3;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * This is a Object Class in order to make data more readable at debug. Contains all the data related
 * to the birds that we store in the Parse DB
 */
@Getter
@Setter
public class DatosAves implements Serializable {

    private final int numGrupo;
    private final Date fechaCaptura;
    private final double latitud;
    private final double longitud;
    private String horaCaptura;
    private int especie;
    private int nEjemplares;
    private int nAnilla;
    private String anillaPreexistente;
    private double peso;
    private double longitudTarso;
    private double longitudPico;
    private double longitudTerceraPrimaria;
    private double longitudCola;
    private int localizacion;
    private int sexo;
    private int edad;
    private int condicionFisica;
    private int grasa;
    private int musculoPectoral;
    private int muda;
    private int placaIncubatriz;
    private boolean modificacion;
    private String objectID;
    private String observaciones;

    public DatosAves(int numGrupo, Date fechaCaptura, double latitud, double longitud) {
        this.numGrupo = numGrupo;
        this.fechaCaptura = fechaCaptura;
        this.latitud = latitud;
        this.longitud = longitud;
        this.modificacion = false;
    }

}
