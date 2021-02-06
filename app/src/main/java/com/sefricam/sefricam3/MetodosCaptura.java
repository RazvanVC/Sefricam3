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

    private final int ReclamosPardilloComun;
    private final int CimbelesPardilloComun;
    private final int CapturasPardilloComunM;
    private final int CapturasPardilloComunH;

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

    private final int ReclamosVerderonComun;
    private final int CimbelesVerderonComun;
    private final int CapturasVerderonComunM;
    private final int CapturasVerderonComunH;

    private final int ReclamosVerderonSerrano;
    private final int CimbelesVerderonSerrano;
    private final int CapturasVerderonSerranoM;
    private final int CapturasVerderonSerranoH;

    private final String Observaciones;

    public MetodosCaptura(int numeroMallas, int longitudRed, boolean coto, ArrayList<Boolean> controlAgentes, int reclamosCamachuelo, int cimbelesCamachuelo, int capturasCamachueloM, int capturasCamachueloH, int reclamosJilguero, int cimbelesJilguero, int capturasJilgueroM, int capturasJilgueroH, int reclamosLugano, int cimbelesLugano, int capturasLuganoM, int capturasLuganoH, int reclamosPardilloComun, int cimbelesPardilloComun, int capturasPardilloComunM, int capturasPardilloComunH, int reclamosPicogordo, int cimbelesPicogordo, int capturasPicogordoM, int capturasPicogordoH, int reclamosPinzonComun, int cimbelesPinzonComun, int capturasPinzonComunM, int capturasPinzonComunH, int reclamosPinzonReal, int cimbelesPinzonReal, int capturasPinzonRealM, int capturasPinzonRealH, int reclamosPiquituerto, int cimbelesPiquituerto, int capturasPiquituertoM, int capturasPiquituertoH, int reclamosVerdecillo, int cimbelesVerdecillo, int capturasVerdecilloM, int capturasVerdecilloH, int reclamosVerderonComun, int cimbelesVerderonComun, int capturasVerderonComunM, int capturasVerderonComunH, int reclamosVerderonSerrano, int cimbelesVerderonSerrano, int capturasVerderonSerranoM, int capturasVerderonSerranoH, String observaciones) {
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
        ReclamosVerderonComun = reclamosVerderonComun;
        CimbelesVerderonComun = cimbelesVerderonComun;
        CapturasVerderonComunM = capturasVerderonComunM;
        CapturasVerderonComunH = capturasVerderonComunH;
        ReclamosVerderonSerrano = reclamosVerderonSerrano;
        CimbelesVerderonSerrano = cimbelesVerderonSerrano;
        CapturasVerderonSerranoM = capturasVerderonSerranoM;
        CapturasVerderonSerranoH = capturasVerderonSerranoH;
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

    public int getReclamosVerderonComun() {
        return ReclamosVerderonComun;
    }

    public int getCimbelesVerderonComun() {
        return CimbelesVerderonComun;
    }

    public int getCapturasVerderonComunM() {
        return CapturasVerderonComunM;
    }

    public int getCapturasVerderonComunH() {
        return CapturasVerderonComunH;
    }

    public int getReclamosVerderonSerrano() {
        return ReclamosVerderonSerrano;
    }

    public int getCimbelesVerderonSerrano() {
        return CimbelesVerderonSerrano;
    }

    public int getCapturasVerderonSerranoM() {
        return CapturasVerderonSerranoM;
    }

    public int getCapturasVerderonSerranoH() {
        return CapturasVerderonSerranoH;
    }

    public String getObservaciones() {
        return Observaciones;
    }
}
