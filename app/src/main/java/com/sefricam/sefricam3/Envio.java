package com.sefricam.sefricam3;

import java.io.Serializable;
import java.util.Date;

public class Envio implements Serializable {

    private DatosEntorno datosEntorno;
    private DatosAvistamiento datosAvistamiento;
    private MetodosCaptura metodosCaptura;
    private boolean EntornoCompletado, MCapturaCompletado, AvistamientoCompletado, EnvioCompletado;
    private double latitud, longitud;
    private Date fecha;
    private final String DNI, email;

    public Envio(String DNI, String email) {
        this.datosEntorno = null;
        this.datosAvistamiento = null;
        this.metodosCaptura = null;
        this.EntornoCompletado = false;
        this.MCapturaCompletado = false;
        this.AvistamientoCompletado = false;
        this.EnvioCompletado = false;
        this.latitud = Double.parseDouble(null);
        this.longitud = Double.parseDouble(null);
        this.fecha = null;
        this.DNI = DNI;
        this.email = email;
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
}
