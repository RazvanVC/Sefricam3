package com.sefricam.sefricam3;

import java.io.Serializable;
import java.util.Date;

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
    private int localizacion;
    private int sexo;
    private int edad;
    private int condicionFisica;
    private int grasa;
    private int musculoPectoral;
    private int muda;
    private int placaIncubatriz;

    public DatosAves(int numGrupo, Date fechaCaptura, double latitud, double longitud, String horaCaptura, int especie, int nEjemplares, int nAnilla, String anillaPreexistente, double peso, double longitudTarso, double longitudPico, double longitudTerceraPrimaria, int localizacion, int sexo, int edad, int condicionFisica, int grasa, int musculoPectoral, int muda, int placaIncubatriz) {
        this.numGrupo = numGrupo;
        this.fechaCaptura = fechaCaptura;
        this.latitud = latitud;
        this.longitud = longitud;
        this.horaCaptura = horaCaptura;
        this.especie = especie;
        this.nEjemplares = nEjemplares;
        this.nAnilla = nAnilla;
        this.anillaPreexistente = anillaPreexistente;
        this.peso = peso;
        this.longitudTarso = longitudTarso;
        this.longitudPico = longitudPico;
        this.longitudTerceraPrimaria = longitudTerceraPrimaria;
        this.localizacion = localizacion;
        this.sexo = sexo;
        this.edad = edad;
        this.condicionFisica = condicionFisica;
        this.grasa = grasa;
        this.musculoPectoral = musculoPectoral;
        this.muda = muda;
        this.placaIncubatriz = placaIncubatriz;
    }

    public int getNumGrupo() {
        return numGrupo;
    }

    public Date getFechaCaptura() {
        return fechaCaptura;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public String getHoraCaptura() {
        return horaCaptura;
    }

    public void setHoraCaptura(String horaCaptura) {
        this.horaCaptura = horaCaptura;
    }

    public int getEspecie() {
        return especie;
    }

    public void setEspecie(int especie) {
        this.especie = especie;
    }

    public int getnEjemplares() {
        return nEjemplares;
    }

    public void setnEjemplares(int nEjemplares) {
        this.nEjemplares = nEjemplares;
    }

    public int getnAnilla() {
        return nAnilla;
    }

    public void setnAnilla(int nAnilla) {
        this.nAnilla = nAnilla;
    }

    public String getAnillaPreexistente() {
        return anillaPreexistente;
    }

    public void setAnillaPreexistente(String anillaPreexistente) {
        this.anillaPreexistente = anillaPreexistente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getLongitudTarso() {
        return longitudTarso;
    }

    public void setLongitudTarso(double longitudTarso) {
        this.longitudTarso = longitudTarso;
    }

    public double getLongitudPico() {
        return longitudPico;
    }

    public void setLongitudPico(double longitudPico) {
        this.longitudPico = longitudPico;
    }

    public double getLongitudTerceraPrimaria() {
        return longitudTerceraPrimaria;
    }

    public void setLongitudTerceraPrimaria(double longitudTerceraPrimaria) {
        this.longitudTerceraPrimaria = longitudTerceraPrimaria;
    }

    public int getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(int localizacion) {
        this.localizacion = localizacion;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCondicionFisica() {
        return condicionFisica;
    }

    public void setCondicionFisica(int condicionFisica) {
        this.condicionFisica = condicionFisica;
    }

    public int getGrasa() {
        return grasa;
    }

    public void setGrasa(int grasa) {
        this.grasa = grasa;
    }

    public int getMusculoPectoral() {
        return musculoPectoral;
    }

    public void setMusculoPectoral(int musculoPectoral) {
        this.musculoPectoral = musculoPectoral;
    }

    public int getMuda() {
        return muda;
    }

    public void setMuda(int muda) {
        this.muda = muda;
    }

    public int getPlacaIncubatriz() {
        return placaIncubatriz;
    }

    public void setPlacaIncubatriz(int placaIncubatriz) {
        this.placaIncubatriz = placaIncubatriz;
    }
}
