package com.sefricam.sefricam3;

import java.io.Serializable;
import java.util.ArrayList;

public class MetodosCaptura implements Serializable {
    private final int NumeroMallas;
    private final int LongitudRed;

    private final boolean Coto;
    private final ArrayList<Boolean> ControlAgentes;

    private final int ReclamosCamachuelo;
    private final int CimbelesCamachuelo;
    private final int CapturasCamachueloM;
    private final int CapturasCamachueloH;

    private final int ReclamosJilguero;
    private final int CimbelesJilguero;
    private final int CapturasJilgueroM;
    private final int CapturasJilgueroH;

    private final int ReclamosLugano;
    private final int CimbelesLugano;
    private final int CapturasLuganoM;
    private final int CapturasLuganoH;

    private final int ReclamosPardComun;
    private final int CimbelesPardComun;
    private final int CapturasPardComunM;
    private final int CapturasPardComunH;

    private final int ReclamosPicogordo;
    private final int CimbelesPicogordo;
    private final int CapturasPicogordoM;
    private final int CapturasPicogordoH;

    private final int ReclamosPinzonComun;
    private final int CimbelesPinzonComun;
    private final int CapturasPinzonComunM;
    private final int CapturasPinzonComunH;

    private final int ReclamosPinzonReal;
    private final int CimbelesPinzonReal;
    private final int CapturasPinzonRealM;
    private final int CapturasPinzonRealH;

    private final int ReclamosPiquituerto;
    private final int CimbelesPiquituerto;
    private final int CapturasPiquituertoM;
    private final int CapturasPiquituertoH;

    private final int ReclamosVerdecillo;
    private final int CimbelesVerdecillo;
    private final int CapturasVerdecilloM;
    private final int CapturasVerdecilloH;

    private final int ReclamosVerdComun;
    private final int CimbelesVerdComun;
    private final int CapturasVerdComunM;
    private final int CapturasVerdComunH;

    private final int ReclamosVerdSerrano;
    private final int CimbelesVerdSerrano;
    private final int CapturasVerdSerranoM;
    private final int CapturasVerdSerranoH;

    private final String Observaciones;

    /**
     * This is a Object Class in order to make data more readable at debug. Contains all the data related
     * to the MetodosCaptura that we store in the Parse DB
     */
    public MetodosCaptura(int numeroMallas, int longitudRed, boolean coto, ArrayList<Boolean> controlAgentes, int reclamosCamachuelo, int cimbelesCamachuelo, int capturasCamachueloM, int capturasCamachueloH, int reclamosJilguero, int cimbelesJilguero, int capturasJilgueroM, int capturasJilgueroH, int reclamosLugano, int cimbelesLugano, int capturasLuganoM, int capturasLuganoH, int reclamosPardComun, int cimbelesPardComun, int capturasPardComunM, int capturasPardComunH, int reclamosPicogordo, int cimbelesPicogordo, int capturasPicogordoM, int capturasPicogordoH, int reclamosPinzonComun, int cimbelesPinzonComun, int capturasPinzonComunM, int capturasPinzonComunH, int reclamosPinzonReal, int cimbelesPinzonReal, int capturasPinzonRealM, int capturasPinzonRealH, int reclamosPiquituerto, int cimbelesPiquituerto, int capturasPiquituertoM, int capturasPiquituertoH, int reclamosVerdecillo, int cimbelesVerdecillo, int capturasVerdecilloM, int capturasVerdecilloH, int reclamosVerdComun, int cimbelesVerdComun, int capturasVerdComunM, int capturasVerdComunH, int reclamosVerdSerrano, int cimbelesVerdSerrano, int capturasVerdSerranoM, int capturasVerdSerranoH, String observaciones) {
        NumeroMallas = numeroMallas;
        LongitudRed = longitudRed;
        Coto = coto;
        ControlAgentes = controlAgentes;
        ReclamosCamachuelo = reclamosCamachuelo;
        CimbelesCamachuelo = cimbelesCamachuelo;
        CapturasCamachueloM = capturasCamachueloM;
        CapturasCamachueloH = capturasCamachueloH;
        ReclamosJilguero = reclamosJilguero;
        CimbelesJilguero = cimbelesJilguero;
        CapturasJilgueroM = capturasJilgueroM;
        CapturasJilgueroH = capturasJilgueroH;
        ReclamosLugano = reclamosLugano;
        CimbelesLugano = cimbelesLugano;
        CapturasLuganoM = capturasLuganoM;
        CapturasLuganoH = capturasLuganoH;
        ReclamosPardComun = reclamosPardComun;
        CimbelesPardComun = cimbelesPardComun;
        CapturasPardComunM = capturasPardComunM;
        CapturasPardComunH = capturasPardComunH;
        ReclamosPicogordo = reclamosPicogordo;
        CimbelesPicogordo = cimbelesPicogordo;
        CapturasPicogordoM = capturasPicogordoM;
        CapturasPicogordoH = capturasPicogordoH;
        ReclamosPinzonComun = reclamosPinzonComun;
        CimbelesPinzonComun = cimbelesPinzonComun;
        CapturasPinzonComunM = capturasPinzonComunM;
        CapturasPinzonComunH = capturasPinzonComunH;
        ReclamosPinzonReal = reclamosPinzonReal;
        CimbelesPinzonReal = cimbelesPinzonReal;
        CapturasPinzonRealM = capturasPinzonRealM;
        CapturasPinzonRealH = capturasPinzonRealH;
        ReclamosPiquituerto = reclamosPiquituerto;
        CimbelesPiquituerto = cimbelesPiquituerto;
        CapturasPiquituertoM = capturasPiquituertoM;
        CapturasPiquituertoH = capturasPiquituertoH;
        ReclamosVerdecillo = reclamosVerdecillo;
        CimbelesVerdecillo = cimbelesVerdecillo;
        CapturasVerdecilloM = capturasVerdecilloM;
        CapturasVerdecilloH = capturasVerdecilloH;
        ReclamosVerdComun = reclamosVerdComun;
        CimbelesVerdComun = cimbelesVerdComun;
        CapturasVerdComunM = capturasVerdComunM;
        CapturasVerdComunH = capturasVerdComunH;
        ReclamosVerdSerrano = reclamosVerdSerrano;
        CimbelesVerdSerrano = cimbelesVerdSerrano;
        CapturasVerdSerranoM = capturasVerdSerranoM;
        CapturasVerdSerranoH = capturasVerdSerranoH;
        Observaciones = observaciones;
    }

    public int getNumeroMallas() {
        return NumeroMallas;
    }

    public int getLongitudRed() {
        return LongitudRed;
    }

    public boolean isCoto() {
        return Coto;
    }

    public ArrayList<Boolean> getControlAgentes() {
        return ControlAgentes;
    }

    public int getReclamosCamachuelo() {
        return ReclamosCamachuelo;
    }

    public int getCimbelesCamachuelo() {
        return CimbelesCamachuelo;
    }

    public int getCapturasCamachueloM() {
        return CapturasCamachueloM;
    }

    public int getCapturasCamachueloH() {
        return CapturasCamachueloH;
    }

    public int getReclamosJilguero() {
        return ReclamosJilguero;
    }

    public int getCimbelesJilguero() {
        return CimbelesJilguero;
    }

    public int getCapturasJilgueroM() {
        return CapturasJilgueroM;
    }

    public int getCapturasJilgueroH() {
        return CapturasJilgueroH;
    }

    public int getReclamosLugano() {
        return ReclamosLugano;
    }

    public int getCimbelesLugano() {
        return CimbelesLugano;
    }

    public int getCapturasLuganoM() {
        return CapturasLuganoM;
    }

    public int getCapturasLuganoH() {
        return CapturasLuganoH;
    }

    public int getReclamosPardComun() {
        return ReclamosPardComun;
    }

    public int getCimbelesPardComun() {
        return CimbelesPardComun;
    }

    public int getCapturasPardComunM() {
        return CapturasPardComunM;
    }

    public int getCapturasPardComunH() {
        return CapturasPardComunH;
    }

    public int getReclamosPicogordo() {
        return ReclamosPicogordo;
    }

    public int getCimbelesPicogordo() {
        return CimbelesPicogordo;
    }

    public int getCapturasPicogordoM() {
        return CapturasPicogordoM;
    }

    public int getCapturasPicogordoH() {
        return CapturasPicogordoH;
    }

    public int getReclamosPinzonComun() {
        return ReclamosPinzonComun;
    }

    public int getCimbelesPinzonComun() {
        return CimbelesPinzonComun;
    }

    public int getCapturasPinzonComunM() {
        return CapturasPinzonComunM;
    }

    public int getCapturasPinzonComunH() {
        return CapturasPinzonComunH;
    }

    public int getReclamosPinzonReal() {
        return ReclamosPinzonReal;
    }

    public int getCimbelesPinzonReal() {
        return CimbelesPinzonReal;
    }

    public int getCapturasPinzonRealM() {
        return CapturasPinzonRealM;
    }

    public int getCapturasPinzonRealH() {
        return CapturasPinzonRealH;
    }

    public int getReclamosPiquituerto() {
        return ReclamosPiquituerto;
    }

    public int getCimbelesPiquituerto() {
        return CimbelesPiquituerto;
    }

    public int getCapturasPiquituertoM() {
        return CapturasPiquituertoM;
    }

    public int getCapturasPiquituertoH() {
        return CapturasPiquituertoH;
    }

    public int getReclamosVerdecillo() {
        return ReclamosVerdecillo;
    }

    public int getCimbelesVerdecillo() {
        return CimbelesVerdecillo;
    }

    public int getCapturasVerdecilloM() {
        return CapturasVerdecilloM;
    }

    public int getCapturasVerdecilloH() {
        return CapturasVerdecilloH;
    }

    public int getReclamosVerdComun() {
        return ReclamosVerdComun;
    }

    public int getCimbelesVerdComun() {
        return CimbelesVerdComun;
    }

    public int getCapturasVerdComunM() {
        return CapturasVerdComunM;
    }

    public int getCapturasVerdComunH() {
        return CapturasVerdComunH;
    }

    public int getReclamosVerdSerrano() {
        return ReclamosVerdSerrano;
    }

    public int getCimbelesVerdSerrano() {
        return CimbelesVerdSerrano;
    }

    public int getCapturasVerdSerranoM() {
        return CapturasVerdSerranoM;
    }

    public int getCapturasVerdSerranoH() {
        return CapturasVerdSerranoH;
    }

    public String getObservaciones() {
        return Observaciones;
    }
}
