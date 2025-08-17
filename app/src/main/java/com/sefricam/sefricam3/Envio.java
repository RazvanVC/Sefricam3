package com.sefricam.sefricam3;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * This is a Object Class in order to make data more readable at debug. Contains all the data related
 * to the full Datos_Entorno class that we store in the Parse DB
 */
@Getter
@Setter
public class Envio implements Serializable {

    private DatosEntorno datosEntorno;
    private DatosAvistamiento datosAvistamiento;
    private MetodosCaptura metodosCaptura;
    private boolean EntornoCompletado, MCapturaCompletado, AvistamientoCompletado, EnvioCompletado, modificacion;
    private double latitud, longitud;
    private Date fecha;
    private final String DNI, email;
    private String objectID;
    private final String versionNumber;


    public Envio(String DNI, String email) {
        this.versionNumber = "version400";
        this.datosEntorno = null;
        this.datosAvistamiento = null;
        this.metodosCaptura = null;
        this.EntornoCompletado = false;
        this.MCapturaCompletado = false;
        this.AvistamientoCompletado = false;
        this.EnvioCompletado = false;
        modificacion=false;
        this.latitud = 0;
        this.longitud = 0;
        this.fecha = null;
        this.DNI = DNI;
        this.email = email;
        this.objectID = "";
    }
    public void printData(String name){
        System.out.println("****************************************************");
        System.out.println("Star of Received Data from " + name);
        System.out.println("____________________________________________________");
        System.out.println("EMAIL                  => " + this.getEmail());
        System.out.println("DNI                    => " + this.getDNI());
        System.out.println("FECHA                  => " + this.getFecha());
        System.out.println("____________________________________________________");
        System.out.println("ESTADO ENTORNO         => " + this.isEntornoCompletado());
        System.out.println("DATOS ENTORNO          => " + this.getDatosEntorno());
        System.out.println("ESTADO METODOS CAPTURA => " + this.isMCapturaCompletado());
        System.out.println("METODOS CAPTURA        => " + this.getMetodosCaptura());
        System.out.println("ESTADO AVISTAMIENTO    => " + this.isAvistamientoCompletado());
        System.out.println("DATOS AVISTAMIENTO     => " + this.getDatosAvistamiento());
        System.out.println("____________________________________________________");
        System.out.println("End of Received Data from " + name);
        System.out.println("****************************************************");
    }
}
