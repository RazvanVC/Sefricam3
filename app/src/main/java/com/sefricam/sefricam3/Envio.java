package com.sefricam.sefricam3;

import java.io.Serializable;
import java.util.Date;

/**
 * This is a Object Class in order to make data more readable at debug. Contains all the data related
 * to the full Datos_Entorno class that we store in the Parse DB
 */
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
        this.versionNumber = "version325";
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

    public String getVersionNumber() {
        return versionNumber;
    }

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    public boolean isModificacion() {
        return modificacion;
    }

    public void setModificacion(boolean modificacion) {
        this.modificacion = modificacion;
    }

    public DatosEntorno getDatosEntorno() {
        return datosEntorno;
    }

    public void setDatosEntorno(DatosEntorno datosEntorno) {
        this.datosEntorno = datosEntorno;
    }

    public DatosAvistamiento getDatosAvistamiento() {
        return datosAvistamiento;
    }

    public void setDatosAvistamiento(DatosAvistamiento datosAvistamiento) {
        this.datosAvistamiento = datosAvistamiento;
    }

    public MetodosCaptura getMetodosCaptura() {
        return metodosCaptura;
    }

    public void setMetodosCaptura(MetodosCaptura metodosCaptura) {
        this.metodosCaptura = metodosCaptura;
    }

    public boolean isEntornoCompletado() {
        return EntornoCompletado;
    }

    public void setEntornoCompletado(boolean entornoCompletado) {
        EntornoCompletado = entornoCompletado;
    }

    public boolean isMCapturaCompletado() {
        return MCapturaCompletado;
    }

    public void setMCapturaCompletado(boolean MCapturaCompletado) {
        this.MCapturaCompletado = MCapturaCompletado;
    }

    public boolean isAvistamientoCompletado() {
        return AvistamientoCompletado;
    }

    public void setAvistamientoCompletado(boolean avistamientoCompletado) {
        AvistamientoCompletado = avistamientoCompletado;
    }

    public boolean isEnvioCompletado() {
        return EnvioCompletado;
    }

    public void setEnvioCompletado(boolean envioCompletado) {
        EnvioCompletado = envioCompletado;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDNI() {
        return DNI;
    }

    public String getEmail() {
        return email;
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
