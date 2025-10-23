package com.sefricam.sefricam3;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Getter;

@Getter
public class MetodosCaptura implements Serializable {
    private final int NumeroParticipantes;
    private final int NumeroMallas;
    private final double LongitudRed;

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
    public MetodosCaptura(int numeroParticipantes, int numeroMallas, double longitudRed, boolean coto, ArrayList<Boolean> controlAgentes, int reclamosCamachuelo, int cimbelesCamachuelo, int capturasCamachueloM, int capturasCamachueloH, int reclamosJilguero, int cimbelesJilguero, int capturasJilgueroM, int capturasJilgueroH, int reclamosLugano, int cimbelesLugano, int capturasLuganoM, int capturasLuganoH, int reclamosPardComun, int cimbelesPardComun, int capturasPardComunM, int capturasPardComunH, int reclamosPicogordo, int cimbelesPicogordo, int capturasPicogordoM, int capturasPicogordoH, int reclamosPinzonComun, int cimbelesPinzonComun, int capturasPinzonComunM, int capturasPinzonComunH, int reclamosPinzonReal, int cimbelesPinzonReal, int capturasPinzonRealM, int capturasPinzonRealH, int reclamosPiquituerto, int cimbelesPiquituerto, int capturasPiquituertoM, int capturasPiquituertoH, int reclamosVerdecillo, int cimbelesVerdecillo, int capturasVerdecilloM, int capturasVerdecilloH, int reclamosVerdComun, int cimbelesVerdComun, int capturasVerdComunM, int capturasVerdComunH, int reclamosVerdSerrano, int cimbelesVerdSerrano, int capturasVerdSerranoM, int capturasVerdSerranoH, String observaciones) {
        NumeroParticipantes = numeroParticipantes;
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

}
