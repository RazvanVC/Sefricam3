package com.sefricam.sefricam3;

import java.io.Serializable;
import java.util.ArrayList;

public class MetodosCaptura implements Serializable {
    private int NumeroMallas;
    private int LongitudRed;

    private boolean Coto;
    private ArrayList<Boolean> ControlAgentes;

    private int ReclamosCamachuelo;
    private int CimbelesCamachuelo;
    private int CapturasCamachueloM;
    private int CapturasCamachueloH;

    private int ReclamosJilguero;
    private int CimbelesJilguero;
    private int CapturasJilgueroM;
    private int CapturasJilgueroH;

    private int ReclamosLugano;
    private int CimbelesLugano;
    private int CapturasLuganoM;
    private int CapturasLuganoH;

    private int ReclamosPardilloComun;
    private int CimbelesPardilloComun;
    private int CapturasPardilloComunM;
    private int CapturasPardilloComunH;

    private int ReclamosPicogordo;
    private int CimbelesPicogordo;
    private int CapturasPicogordoM;
    private int CapturasPicogordoH;

    private int ReclamosPinzonComun;
    private int CimbelesPinzonComun;
    private int CapturasPinzonComunM;
    private int CapturasPinzonComunH;

    private int ReclamosPinzonReal;
    private int CimbelesPinzonReal;
    private int CapturasPinzonRealM;
    private int CapturasPinzonRealH;

    private int ReclamosPiquituerto;
    private int CimbelesPiquituerto;
    private int CapturasPiquituertoM;
    private int CapturasPiquituertoH;

    private int ReclamosVerdecillo;
    private int CimbelesVerdecillo;
    private int CapturasVerdecilloM;
    private int CapturasVerdecilloH;

    private int ReclamosVerdonComun;
    private int CimbelesVerdonComun;
    private int CapturasVerdonComunM;
    private int CapturasVerdonComunH;

    private int ReclamosVerdonSerrano;
    private int CimbelesVerdonSerrano;
    private int CapturasVerdonSerranoM;
    private int CapturasVerdonSerranoH;

    private String Observaciones;

    public MetodosCaptura(int numeroMallas, int longitudRed, boolean coto, ArrayList<Boolean> controlAgentes, int reclamosCamachuelo, int cimbelesCamachuelo, int capturasCamachueloM, int capturasCamachueloH, int reclamosJilguero, int cimbelesJilguero, int capturasJilgueroM, int capturasJilgueroH, int reclamosLugano, int cimbelesLugano, int capturasLuganoM, int capturasLuganoH, int reclamosPardilloComun, int cimbelesPardilloComun, int capturasPardilloComunM, int capturasPardilloComunH, int reclamosPicogordo, int cimbelesPicogordo, int capturasPicogordoM, int capturasPicogordoH, int reclamosPinzonComun, int cimbelesPinzonComun, int capturasPinzonComunM, int capturasPinzonComunH, int reclamosPinzonReal, int cimbelesPinzonReal, int capturasPinzonRealM, int capturasPinzonRealH, int reclamosPiquituerto, int cimbelesPiquituerto, int capturasPiquituertoM, int capturasPiquituertoH, int reclamosVerdecillo, int cimbelesVerdecillo, int capturasVerdecilloM, int capturasVerdecilloH, int reclamosVerdonComun, int cimbelesVerdonComun, int capturasVerdonComunM, int capturasVerdonComunH, int reclamosVerdonSerrano, int cimbelesVerdonSerrano, int capturasVerdonSerranoM, int capturasVerdonSerranoH, String observaciones) {
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
        ReclamosPardilloComun = reclamosPardilloComun;
        CimbelesPardilloComun = cimbelesPardilloComun;
        CapturasPardilloComunM = capturasPardilloComunM;
        CapturasPardilloComunH = capturasPardilloComunH;
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
        ReclamosVerdonComun = reclamosVerdonComun;
        CimbelesVerdonComun = cimbelesVerdonComun;
        CapturasVerdonComunM = capturasVerdonComunM;
        CapturasVerdonComunH = capturasVerdonComunH;
        ReclamosVerdonSerrano = reclamosVerdonSerrano;
        CimbelesVerdonSerrano = cimbelesVerdonSerrano;
        CapturasVerdonSerranoM = capturasVerdonSerranoM;
        CapturasVerdonSerranoH = capturasVerdonSerranoH;
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

    public int getReclamosPardilloComun() {
        return ReclamosPardilloComun;
    }

    public int getCimbelesPardilloComun() {
        return CimbelesPardilloComun;
    }

    public int getCapturasPardilloComunM() {
        return CapturasPardilloComunM;
    }

    public int getCapturasPardilloComunH() {
        return CapturasPardilloComunH;
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

    public int getReclamosVerdonComun() {
        return ReclamosVerdonComun;
    }

    public int getCimbelesVerdonComun() {
        return CimbelesVerdonComun;
    }

    public int getCapturasVerdonComunM() {
        return CapturasVerdonComunM;
    }

    public int getCapturasVerdonComunH() {
        return CapturasVerdonComunH;
    }

    public int getReclamosVerdonSerrano() {
        return ReclamosVerdonSerrano;
    }

    public int getCimbelesVerdonSerrano() {
        return CimbelesVerdonSerrano;
    }

    public int getCapturasVerdonSerranoM() {
        return CapturasVerdonSerranoM;
    }

    public int getCapturasVerdonSerranoH() {
        return CapturasVerdonSerranoH;
    }

    public String getObservaciones() {
        return Observaciones;
    }
}
