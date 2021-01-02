package com.sefricam.sefricam3;

import java.io.Serializable;
import java.util.ArrayList;

public class MetodosCaptura implements Serializable {
    private int NumeroMallas;
    private int LongitudRed;

    private boolean Coto;
    private ArrayList<Integer> ControlAgentes;
    private int ReclamosCamachuelo;
    private int CimbelesCamachuelo;
    private int CapturasCamachuelo;

    private int ReclamosJilguero;
    private int CimbelesJilguero;
    private int CapturasJilguero;

    private int ReclamosLugano;
    private int CimbelesLugano;
    private int CapturasLugano;

    private int ReclamosPardilloComun;
    private int CimbelesPardilloComun;
    private int CapturasPardilloComun;

    private int ReclamosPicogordo;
    private int CimbelesPicogordo;
    private int CapturasPicogordo;

    private int ReclamosPinzonComun;
    private int CimbelesPinzonComun;
    private int CapturasPinzonComun;

    private int ReclamosPinzonReal;
    private int CimbelesPinzonReal;
    private int CapturasPinzonReal;

    private int ReclamosPiquituerto;
    private int CimbelesPiquituerto;
    private int CapturasPiquituerto;

    private int ReclamosVerdecillo;
    private int CimbelesVerdecillo;
    private int CapturasVerdecillo;

    private int ReclamosVerdonComun;
    private int CimbelesVerdonComun;
    private int CapturasVerdonComun;

    private int ReclamosVerdonSerrano;
    private int CimbelesVerdonSerrano;
    private int CapturasVerdonSerrano;

    private String Observaciones;

    public MetodosCaptura(int numeroMallas, int longitudRed, boolean coto, ArrayList<Integer> controlAgentes, int reclamosCamachuelo, int cimbelesCamachuelo, int capturasCamachuelo, int reclamosJilguero, int cimbelesJilguero, int capturasJilguero, int reclamosLugano, int cimbelesLugano, int capturasLugano, int reclamosPardilloComun, int cimbelesPardilloComun, int capturasPardilloComun, int reclamosPicogordo, int cimbelesPicogordo, int capturasPicogordo, int reclamosPinzonComun, int cimbelesPinzonComun, int capturasPinzonComun, int reclamosPinzonReal, int cimbelesPinzonReal, int capturasPinzonReal, int reclamosPiquituerto, int cimbelesPiquituerto, int capturasPiquituerto, int reclamosVerdecillo, int cimbelesVerdecillo, int capturasVerdecillo, int reclamosVerdonComun, int cimbelesVerdonComun, int capturasVerdonComun, int reclamosVerdonSerrano, int cimbelesVerdonSerrano, int capturasVerdonSerrano, String observaciones) {
        NumeroMallas = numeroMallas;
        LongitudRed = longitudRed;
        Coto = coto;
        ControlAgentes = controlAgentes;
        ReclamosCamachuelo = reclamosCamachuelo;
        CimbelesCamachuelo = cimbelesCamachuelo;
        CapturasCamachuelo = capturasCamachuelo;
        ReclamosJilguero = reclamosJilguero;
        CimbelesJilguero = cimbelesJilguero;
        CapturasJilguero = capturasJilguero;
        ReclamosLugano = reclamosLugano;
        CimbelesLugano = cimbelesLugano;
        CapturasLugano = capturasLugano;
        ReclamosPardilloComun = reclamosPardilloComun;
        CimbelesPardilloComun = cimbelesPardilloComun;
        CapturasPardilloComun = capturasPardilloComun;
        ReclamosPicogordo = reclamosPicogordo;
        CimbelesPicogordo = cimbelesPicogordo;
        CapturasPicogordo = capturasPicogordo;
        ReclamosPinzonComun = reclamosPinzonComun;
        CimbelesPinzonComun = cimbelesPinzonComun;
        CapturasPinzonComun = capturasPinzonComun;
        ReclamosPinzonReal = reclamosPinzonReal;
        CimbelesPinzonReal = cimbelesPinzonReal;
        CapturasPinzonReal = capturasPinzonReal;
        ReclamosPiquituerto = reclamosPiquituerto;
        CimbelesPiquituerto = cimbelesPiquituerto;
        CapturasPiquituerto = capturasPiquituerto;
        ReclamosVerdecillo = reclamosVerdecillo;
        CimbelesVerdecillo = cimbelesVerdecillo;
        CapturasVerdecillo = capturasVerdecillo;
        ReclamosVerdonComun = reclamosVerdonComun;
        CimbelesVerdonComun = cimbelesVerdonComun;
        CapturasVerdonComun = capturasVerdonComun;
        ReclamosVerdonSerrano = reclamosVerdonSerrano;
        CimbelesVerdonSerrano = cimbelesVerdonSerrano;
        CapturasVerdonSerrano = capturasVerdonSerrano;
        Observaciones = observaciones;
    }

    public int getNumeroMallas() {
        return NumeroMallas;
    }

    public void setNumeroMallas(int numeroMallas) {
        NumeroMallas = numeroMallas;
    }

    public int getLongitudRed() {
        return LongitudRed;
    }

    public void setLongitudRed(int longitudRed) {
        LongitudRed = longitudRed;
    }

    public int getReclamosCamachuelo() {
        return ReclamosCamachuelo;
    }

    public void setReclamosCamachuelo(int reclamosCamachuelo) {
        ReclamosCamachuelo = reclamosCamachuelo;
    }

    public int getCimbelesCamachuelo() {
        return CimbelesCamachuelo;
    }

    public void setCimbelesCamachuelo(int cimbelesCamachuelo) {
        CimbelesCamachuelo = cimbelesCamachuelo;
    }

    public int getCapturasCamachuelo() {
        return CapturasCamachuelo;
    }

    public void setCapturasCamachuelo(int capturasCamachuelo) {
        CapturasCamachuelo = capturasCamachuelo;
    }

    public int getReclamosJilguero() {
        return ReclamosJilguero;
    }

    public void setReclamosJilguero(int reclamosJilguero) {
        ReclamosJilguero = reclamosJilguero;
    }

    public int getCimbelesJilguero() {
        return CimbelesJilguero;
    }

    public void setCimbelesJilguero(int cimbelesJilguero) {
        CimbelesJilguero = cimbelesJilguero;
    }

    public int getCapturasJilguero() {
        return CapturasJilguero;
    }

    public void setCapturasJilguero(int capturasJilguero) {
        CapturasJilguero = capturasJilguero;
    }

    public int getReclamosLugano() {
        return ReclamosLugano;
    }

    public void setReclamosLugano(int reclamosLugano) {
        ReclamosLugano = reclamosLugano;
    }

    public int getCimbelesLugano() {
        return CimbelesLugano;
    }

    public void setCimbelesLugano(int cimbelesLugano) {
        CimbelesLugano = cimbelesLugano;
    }

    public int getCapturasLugano() {
        return CapturasLugano;
    }

    public void setCapturasLugano(int capturasLugano) {
        CapturasLugano = capturasLugano;
    }

    public int getReclamosPardilloComun() {
        return ReclamosPardilloComun;
    }

    public void setReclamosPardilloComun(int reclamosPardilloComun) {
        ReclamosPardilloComun = reclamosPardilloComun;
    }

    public int getCimbelesPardilloComun() {
        return CimbelesPardilloComun;
    }

    public void setCimbelesPardilloComun(int cimbelesPardilloComun) {
        CimbelesPardilloComun = cimbelesPardilloComun;
    }

    public int getCapturasPardilloComun() {
        return CapturasPardilloComun;
    }

    public void setCapturasPardilloComun(int capturasPardilloComun) {
        CapturasPardilloComun = capturasPardilloComun;
    }

    public int getReclamosPicogordo() {
        return ReclamosPicogordo;
    }

    public void setReclamosPicogordo(int reclamosPicogordo) {
        ReclamosPicogordo = reclamosPicogordo;
    }

    public int getCimbelesPicogordo() {
        return CimbelesPicogordo;
    }

    public void setCimbelesPicogordo(int cimbelesPicogordo) {
        CimbelesPicogordo = cimbelesPicogordo;
    }

    public int getCapturasPicogordo() {
        return CapturasPicogordo;
    }

    public void setCapturasPicogordo(int capturasPicogordo) {
        CapturasPicogordo = capturasPicogordo;
    }

    public int getReclamosPinzonComun() {
        return ReclamosPinzonComun;
    }

    public void setReclamosPinzonComun(int reclamosPinzonComun) {
        ReclamosPinzonComun = reclamosPinzonComun;
    }

    public int getCimbelesPinzonComun() {
        return CimbelesPinzonComun;
    }

    public void setCimbelesPinzonComun(int cimbelesPinzonComun) {
        CimbelesPinzonComun = cimbelesPinzonComun;
    }

    public int getCapturasPinzonComun() {
        return CapturasPinzonComun;
    }

    public void setCapturasPinzonComun(int capturasPinzonComun) {
        CapturasPinzonComun = capturasPinzonComun;
    }

    public int getReclamosPinzonReal() {
        return ReclamosPinzonReal;
    }

    public void setReclamosPinzonReal(int reclamosPinzonReal) {
        ReclamosPinzonReal = reclamosPinzonReal;
    }

    public int getCimbelesPinzonReal() {
        return CimbelesPinzonReal;
    }

    public void setCimbelesPinzonReal(int cimbelesPinzonReal) {
        CimbelesPinzonReal = cimbelesPinzonReal;
    }

    public int getCapturasPinzonReal() {
        return CapturasPinzonReal;
    }

    public void setCapturasPinzonReal(int capturasPinzonReal) {
        CapturasPinzonReal = capturasPinzonReal;
    }

    public int getReclamosPiquituerto() {
        return ReclamosPiquituerto;
    }

    public void setReclamosPiquituerto(int reclamosPiquituerto) {
        ReclamosPiquituerto = reclamosPiquituerto;
    }

    public int getCimbelesPiquituerto() {
        return CimbelesPiquituerto;
    }

    public void setCimbelesPiquituerto(int cimbelesPiquituerto) {
        CimbelesPiquituerto = cimbelesPiquituerto;
    }

    public int getCapturasPiquituerto() {
        return CapturasPiquituerto;
    }

    public void setCapturasPiquituerto(int capturasPiquituerto) {
        CapturasPiquituerto = capturasPiquituerto;
    }

    public int getReclamosVerdecillo() {
        return ReclamosVerdecillo;
    }

    public void setReclamosVerdecillo(int reclamosVerdecillo) {
        ReclamosVerdecillo = reclamosVerdecillo;
    }

    public int getCimbelesVerdecillo() {
        return CimbelesVerdecillo;
    }

    public void setCimbelesVerdecillo(int cimbelesVerdecillo) {
        CimbelesVerdecillo = cimbelesVerdecillo;
    }

    public int getCapturasVerdecillo() {
        return CapturasVerdecillo;
    }

    public void setCapturasVerdecillo(int capturasVerdecillo) {
        CapturasVerdecillo = capturasVerdecillo;
    }

    public int getReclamosVerdonComun() {
        return ReclamosVerdonComun;
    }

    public void setReclamosVerdonComun(int reclamosVerdonComun) {
        ReclamosVerdonComun = reclamosVerdonComun;
    }

    public int getCimbelesVerdonComun() {
        return CimbelesVerdonComun;
    }

    public void setCimbelesVerdonComun(int cimbelesVerdonComun) {
        CimbelesVerdonComun = cimbelesVerdonComun;
    }

    public int getCapturasVerdonComun() {
        return CapturasVerdonComun;
    }

    public void setCapturasVerdonComun(int capturasVerdonComun) {
        CapturasVerdonComun = capturasVerdonComun;
    }

    public int getReclamosVerdonSerrano() {
        return ReclamosVerdonSerrano;
    }

    public void setReclamosVerdonSerrano(int reclamosVerdonSerrano) {
        ReclamosVerdonSerrano = reclamosVerdonSerrano;
    }

    public int getCimbelesVerdonSerrano() {
        return CimbelesVerdonSerrano;
    }

    public void setCimbelesVerdonSerrano(int cimbelesVerdonSerrano) {
        CimbelesVerdonSerrano = cimbelesVerdonSerrano;
    }

    public int getCapturasVerdonSerrano() {
        return CapturasVerdonSerrano;
    }

    public void setCapturasVerdonSerrano(int capturasVerdonSerrano) {
        CapturasVerdonSerrano = capturasVerdonSerrano;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }

    public boolean isCoto() {
        return Coto;
    }

    public ArrayList<Integer> getControlAgentes() {
        return ControlAgentes;
    }
}
