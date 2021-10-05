package com.sefricam.sefricam3;

import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.Serializable;

/**
 * This is a Object Class in order to make data more readable at debug. Contains all the data related
 * to the biometry of the birds that we store in the Parse DB
 */
public class Limites implements Serializable {
    private double minLat, maxLat, minLon, maxLon;
    private int minTemp, maxTemp, minNAnilla, maxNAnilla;

    private int maxRecCamachuelo, maxCimCamachuelo;
    private double minAlaCamachuelo, maxAlaCamachuelo, minPicoCamachuelo, maxPicoCamachuelo, minTarsoCamachuelo, maxTarsoCamachuelo, minPesoCamachuelo, maxPesoCamachuelo;

    private int maxRecJilguero, maxCimJilguero;
    private double minAlaJilguero, maxAlaJilguero, minPicoJilguero, maxPicoJilguero, minTarsoJilguero, maxTarsoJilguero, minPesoJilguero, maxPesoJilguero;

    private int maxRecLugano, maxCimLugano;
    private double minAlaLugano, maxAlaLugano, minPicoLugano, maxPicoLugano, minTarsoLugano, maxTarsoLugano, minPesoLugano, maxPesoLugano;

    private int maxRecPardComun, maxCimPardComun;
    private double  minAlaPardComun, maxAlaPardComun, minPicoPardComun, maxPicoPardComun, minTarsoPardComun, maxTarsoPardComun, minPesoPardComun, maxPesoPardComun;

    private int maxRecPicogordo, maxCimPicogordo;
    private double minAlaPicogordo, maxAlaPicogordo, minPicoPicogordo, maxPicoPicogordo, minTarsoPicogordo, maxTarsoPicogordo, minPesoPicogordo, maxPesoPicogordo;

    private int maxRecPinzComun, maxCimPinzComun;
    private double minAlaPinzComun, maxAlaPinzComun, minPicoPinzComun, maxPicoPinzComun, minTarsoPinzComun, maxTarsoPinzComun, minPesoPinzComun, maxPesoPinzComun;

    private int maxRecPinzReal, maxCimPinzReal;
    private double minAlaPinzReal, maxAlaPinzReal, minPicoPinzReal, maxPicoPinzReal, minTarsoPinzReal, maxTarsoPinzReal, minPesoPinzReal, maxPesoPinzReal;

    private int maxRecPiquituerto, maxCimPiquituerto;
    private double minAlaPiquituerto, maxAlaPiquituerto, minPicoPiquituerto, maxPicoPiquituerto, minTarsoPiquituerto, maxTarsoPiquituerto, minPesoPiquituerto, maxPesoPiquituerto;

    private int maxRecVerdecillo, maxCimVerdecillo;
    private double minAlaVerdecillo, maxAlaVerdecillo, minPicoVerdecillo, maxPicoVerdecillo, minTarsoVerdecillo, maxTarsoVerdecillo, minPesoVerdecillo, maxPesoVerdecillo;

    private int maxRecVerdComun, maxCimVerdComun;
    private double minAlaVerdComun, maxAlaVerdComun, minPicoVerdComun, maxPicoVerdComun, minTarsoVerdComun, maxTarsoVerdComun, minPesoVerdComun, maxPesoVerdComun;

    private int maxRecVerdSerrano, maxCimVerdSerrano;
    private double minAlaVerdSerrano, maxAlaVerdSerrano, minPicoVerdSerrano, maxPicoVerdSerrano, minTarsoVerdSerrano, maxTarsoVerdSerrano, minPesoVerdSerrano, maxPesoVerdSerrano;
    private int numeroGrupo;

    private boolean anillableCamachuelo, anillableVerdComun, anillableVerdSerrano, anillableJilguero, anillablePardComun, anillableVerdecillo, anillableLugano, anillablePinzComun, anillablePinzReal, anillablePiquituerto, anillablePicogordo;

    public Limites(int numGrupo) {
        this.numeroGrupo = numGrupo;
        readObject(numGrupo);
        readObject();
    }

    private void readObject() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Limites");

        // The query will search for a ParseObject, given its objectId.
        // When the query finishes running, it will invoke the GetCallback
        // with either the object, or the exception thrown
        query.getInBackground("AWmV7DLevo", (result, e) -> {
            if (e == null) {
                //Datos Generales
                minLat = result.getDouble("MinLat");
                maxLat = result.getDouble("MaxLat");
                minLon = result.getDouble("MinLon");
                maxLon = result.getDouble("MaxLon");
                minTemp = result.getInt("MinTemp");
                maxTemp = result.getInt("MaxTemp");

                //Datos Aves
                maxRecCamachuelo = result.getInt("MaxRecCamachuelo");
                maxCimCamachuelo = result.getInt("MaxCimCamachuelo");

                maxRecJilguero = result.getInt("MaxRecJilguero");
                maxCimJilguero = result.getInt("MaxCimJilguero");

                maxRecLugano = result.getInt("MaxRecLugano");
                maxCimLugano = result.getInt("MaxCimLugano");

                maxRecPardComun = result.getInt("MaxRecPardComun");
                maxCimPardComun = result.getInt("MaxCimPardComun");

                maxCimPicogordo = result.getInt("MaxCimPicogordo");
                maxRecPicogordo = result.getInt("MaxRecPicogordo");

                maxCimPinzComun = result.getInt("MaxCimPinzComun");
                maxRecPinzComun = result.getInt("MaxRecPinzComun");

                maxRecPinzReal = result.getInt("MaxRecPinzReal");
                maxCimPinzReal = result.getInt("MaxCimPinzReal");

                maxRecPiquituerto = result.getInt("MaxRecPiquituerto");
                maxCimPiquituerto = result.getInt("MaxCimPiquituerto");

                maxRecVerdecillo = result.getInt("MaxRecVerdecillo");
                maxCimVerdecillo = result.getInt("MaxCimVerdecillo");

                maxRecVerdComun = result.getInt("MaxRecVerdComun");
                maxCimVerdComun = result.getInt("MaxCimVerdComun");

                maxRecVerdSerrano = result.getInt("MaxRecVerdSerrano");
                maxCimVerdSerrano = result.getInt("MaxCimVerdSerrano");

                //Parámetros aves
                minAlaCamachuelo = result.getDouble("MinAlaCamachuelo");
                maxAlaCamachuelo = result.getDouble("MaxAlaCamachuelo");
                minPicoCamachuelo = result.getDouble("MinPicoCamachuelo");
                maxPicoCamachuelo = result.getDouble("MaxPicoCamachuelo");
                minTarsoCamachuelo = result.getDouble("MinTarsoCamachuelo");
                maxTarsoCamachuelo = result.getDouble("MaxTarsoCamachuelo");
                minPesoCamachuelo = result.getDouble("MinPesoCamachuelo");
                maxPesoCamachuelo = result.getDouble("MaxPesoCamachuelo");

                minAlaJilguero = result.getDouble("MinAlaJilguero");
                maxAlaJilguero = result.getDouble("MaxAlaJilguero");
                minPicoJilguero = result.getDouble("MinPicoJilguero");
                maxPicoJilguero = result.getDouble("MaxPicoJilguero");
                minTarsoJilguero = result.getDouble("MinTarsoJilguero");
                maxTarsoJilguero = result.getDouble("MaxTarsoJilguero");
                minPesoJilguero = result.getDouble("MinPesoJilguero");
                maxPesoJilguero = result.getDouble("MaxPesoJilguero");

                minAlaLugano = result.getDouble("MinAlaLugano");
                maxAlaLugano = result.getDouble("MaxAlaLugano");
                minPicoLugano = result.getDouble("MinPicoLugano");
                maxPicoLugano = result.getDouble("MaxPicoLugano");
                minTarsoLugano = result.getDouble("MinTarsoLugano");
                maxTarsoLugano = result.getDouble("MaxTarsoLugano");
                minPesoLugano = result.getDouble("MinPesoLugano");
                maxPesoLugano = result.getDouble("MaxPesoLugano");

                minAlaPardComun = result.getDouble("MinAlaPardComun");
                maxAlaPardComun = result.getDouble("MaxAlaPardComun");
                minPicoPardComun = result.getDouble("MinPicoPardComun");
                maxPicoPardComun = result.getDouble("MaxPicoPardComun");
                minTarsoPardComun = result.getDouble("MinTarsoPardComun");
                maxTarsoPardComun = result.getDouble("MaxTarsoPardComun");
                minPesoPardComun = result.getDouble("MinPesoPardComun");
                maxPesoPardComun = result.getDouble("MaxPesoPardComun");

                minAlaPicogordo = result.getDouble("MinAlaPicogordo");
                maxAlaPicogordo = result.getDouble("MaxAlaPicogordo");
                minPicoPicogordo = result.getDouble("MinPicoPicogordo");
                maxPicoPicogordo = result.getDouble("MaxPicoPicogordo");
                minTarsoPicogordo = result.getDouble("MinTarsoPicogordo");
                maxTarsoPicogordo = result.getDouble("MaxTarsoPicogordo");
                minPesoPicogordo = result.getDouble("MinPesoPicogordo");
                maxPesoPicogordo = result.getDouble("MaxPesoPicogordo");

                minAlaPinzComun = result.getDouble("MinAlaPinzComun");
                maxAlaPinzComun = result.getDouble("MaxAlaPinzComun");
                minPicoPinzComun = result.getDouble("MinPicoPinzComun");
                maxPicoPinzComun = result.getDouble("MaxPicoPinzComun");
                minTarsoPinzComun = result.getDouble("MinTarsoPinzComun");
                maxTarsoPinzComun = result.getDouble("MaxTarsoPinzComun");
                minPesoPinzComun = result.getDouble("MinPesoPinzComun");
                maxPesoPinzComun = result.getDouble("MaxPesoPinzComun");

                minAlaPinzReal = result.getDouble("MinAlaPinzReal");
                maxAlaPinzReal = result.getDouble("MaxAlaPinzReal");
                minPicoPinzReal = result.getDouble("MinPicoPinzReal");
                maxPicoPinzReal = result.getDouble("MaxPicoPinzReal");
                minTarsoPinzReal = result.getDouble("MinTarsoPinzReal");
                maxTarsoPinzReal = result.getDouble("MaxTarsoPinzReal");
                minPesoPinzReal = result.getDouble("MinPesoPinzReal");
                maxPesoPinzReal = result.getDouble("MaxPesoPinzReal");

                minAlaPiquituerto = result.getDouble("MinAlaPiquituerto");
                maxAlaPiquituerto = result.getDouble("MaxAlaPiquituerto");
                minPicoPiquituerto = result.getDouble("MinPicoPiquituerto");
                maxPicoPiquituerto = result.getDouble("MaxPicoPiquituerto");
                minTarsoPiquituerto = result.getDouble("MinTarsoPiquituerto");
                maxTarsoPiquituerto = result.getDouble("MaxTarsoPiquituerto");
                minPesoPiquituerto = result.getDouble("MinPesoPiquituerto");
                maxPesoPiquituerto = result.getDouble("MaxPesoPiquituerto");

                minAlaVerdecillo = result.getDouble("MinAlaVerdecillo");
                maxAlaVerdecillo = result.getDouble("MaxAlaVerdecillo");
                minPicoVerdecillo = result.getDouble("MinPicoVerdecillo");
                maxPicoVerdecillo = result.getDouble("MaxPicoVerdecillo");
                minTarsoVerdecillo = result.getDouble("MinTarsoVerdecillo");
                maxTarsoVerdecillo = result.getDouble("MaxTarsoVerdecillo");
                minPesoVerdecillo = result.getDouble("MinPesoVerdecillo");
                maxPesoVerdecillo = result.getDouble("MaxPesoVerdecillo");

                minAlaVerdComun = result.getDouble("MinAlaVerdComun");
                maxAlaVerdComun = result.getDouble("MaxAlaVerdComun");
                minPicoVerdComun = result.getDouble("MinPicoVerdComun");
                maxPicoVerdComun = result.getDouble("MaxPicoVerdComun");
                minTarsoVerdComun = result.getDouble("MinTarsoVerdComun");
                maxTarsoVerdComun = result.getDouble("MaxTarsoVerdComun");
                minPesoVerdComun = result.getDouble("MinPesoVerdComun");
                maxPesoVerdComun = result.getDouble("MaxPesoVerdComun");

                minAlaVerdSerrano = result.getDouble("MinAlaVerdSerrano");
                maxAlaVerdSerrano = result.getDouble("MaxAlaVerdSerrano");
                minPicoVerdSerrano = result.getDouble("MinPicoVerdSerrano");
                maxPicoVerdSerrano = result.getDouble("MaxPicoVerdSerrano");
                minTarsoVerdSerrano = result.getDouble("MinTarsoVerdSerrano");
                maxTarsoVerdSerrano = result.getDouble("MaxTarsoVerdSerrano");
                minPesoVerdSerrano = result.getDouble("MinPesoVerdSerrano");
                maxPesoVerdSerrano = result.getDouble("MaxPesoVerdSerrano");

                anillableJilguero = result.getBoolean("AnillableJilguero");
                anillableCamachuelo = result.getBoolean("AnillableCamachuelo");
                anillableLugano = result.getBoolean("AnillableLugano");
                anillablePardComun = result.getBoolean("AnillablePardComun");
                anillablePicogordo = result.getBoolean("AnillablePicogordo");
                anillablePinzComun = result.getBoolean("AnillablePinzComun");
                anillablePinzReal = result.getBoolean("AnillablePinzReal");
                anillablePiquituerto = result.getBoolean("AnillablePiquituerto");
                anillableVerdecillo = result.getBoolean("AnillableVerdecillo");
                anillableVerdComun = result.getBoolean("AnillableVerdComun");
                anillableVerdSerrano = result.getBoolean("AnillableVerdSerrano");

            } else {
                System.out.println("ERROR: No es posible leer los datos");
            }
        });
    }

    public boolean isAnillableCamachuelo() {
        return anillableCamachuelo;
    }

    public boolean isAnillableVerdComun() {
        return anillableVerdComun;
    }

    public boolean isAnillableVerdSerrano() {
        return anillableVerdSerrano;
    }

    public boolean isAnillableJilguero() {
        return anillableJilguero;
    }

    public boolean isAnillablePardComun() {
        return anillablePardComun;
    }

    public boolean isAnillableVerdecillo() {
        return anillableVerdecillo;
    }

    public boolean isAnillableLugano() {
        return anillableLugano;
    }

    public boolean isAnillablePinzComun() {
        return anillablePinzComun;
    }

    public boolean isAnillablePinzReal() {
        return anillablePinzReal;
    }

    public boolean isAnillablePiquituerto() {
        return anillablePiquituerto;
    }

    public boolean isAnillablePicogordo() {
        return anillablePicogordo;
    }

    public double getMinLat() {
        return minLat;
    }

    public double getMaxLat() {
        return maxLat;
    }

    public double getMinLon() {
        return minLon;
    }

    public double getMaxLon() {
        return maxLon;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinNAnilla() {
        return minNAnilla;
    }

    public int getMaxNAnilla() {
        return maxNAnilla;
    }

    public int getMaxRecCamachuelo() {
        return maxRecCamachuelo;
    }

    public int getMaxCimCamachuelo() {
        return maxCimCamachuelo;
    }

    public double getMinAlaCamachuelo() {
        return minAlaCamachuelo;
    }

    public double getMaxAlaCamachuelo() {
        return maxAlaCamachuelo;
    }

    public double getMinPicoCamachuelo() {
        return minPicoCamachuelo;
    }

    public double getMaxPicoCamachuelo() {
        return maxPicoCamachuelo;
    }

    public double getMinTarsoCamachuelo() {
        return minTarsoCamachuelo;
    }

    public double getMaxTarsoCamachuelo() {
        return maxTarsoCamachuelo;
    }

    public double getMinPesoCamachuelo() {
        return minPesoCamachuelo;
    }

    public double getMaxPesoCamachuelo() {
        return maxPesoCamachuelo;
    }

    public int getMaxRecJilguero() {
        return maxRecJilguero;
    }

    public int getMaxCimJilguero() {
        return maxCimJilguero;
    }

    public double getMinAlaJilguero() {
        return minAlaJilguero;
    }

    public double getMaxAlaJilguero() {
        return maxAlaJilguero;
    }

    public double getMinPicoJilguero() {
        return minPicoJilguero;
    }

    public double getMaxPicoJilguero() {
        return maxPicoJilguero;
    }

    public double getMinTarsoJilguero() {
        return minTarsoJilguero;
    }

    public double getMaxTarsoJilguero() {
        return maxTarsoJilguero;
    }

    public double getMinPesoJilguero() {
        return minPesoJilguero;
    }

    public double getMaxPesoJilguero() {
        return maxPesoJilguero;
    }

    public int getMaxRecLugano() {
        return maxRecLugano;
    }

    public int getMaxCimLugano() {
        return maxCimLugano;
    }

    public double getMinAlaLugano() {
        return minAlaLugano;
    }

    public double getMaxAlaLugano() {
        return maxAlaLugano;
    }

    public double getMinPicoLugano() {
        return minPicoLugano;
    }

    public double getMaxPicoLugano() {
        return maxPicoLugano;
    }

    public double getMinTarsoLugano() {
        return minTarsoLugano;
    }

    public double getMaxTarsoLugano() {
        return maxTarsoLugano;
    }

    public double getMinPesoLugano() {
        return minPesoLugano;
    }

    public double getMaxPesoLugano() {
        return maxPesoLugano;
    }

    public int getMaxRecPardComun() {
        return maxRecPardComun;
    }

    public int getMaxCimPardComun() {
        return maxCimPardComun;
    }

    public double getMinAlaPardComun() {
        return minAlaPardComun;
    }

    public double getMaxAlaPardComun() {
        return maxAlaPardComun;
    }

    public double getMinPicoPardComun() {
        return minPicoPardComun;
    }

    public double getMaxPicoPardComun() {
        return maxPicoPardComun;
    }

    public double getMinTarsoPardComun() {
        return minTarsoPardComun;
    }

    public double getMaxTarsoPardComun() {
        return maxTarsoPardComun;
    }

    public double getMinPesoPardComun() {
        return minPesoPardComun;
    }

    public double getMaxPesoPardComun() {
        return maxPesoPardComun;
    }

    public int getMaxRecPicogordo() {
        return maxRecPicogordo;
    }

    public int getMaxCimPicogordo() {
        return maxCimPicogordo;
    }

    public double getMinAlaPicogordo() {
        return minAlaPicogordo;
    }

    public double getMaxAlaPicogordo() {
        return maxAlaPicogordo;
    }

    public double getMinPicoPicogordo() {
        return minPicoPicogordo;
    }

    public double getMaxPicoPicogordo() {
        return maxPicoPicogordo;
    }

    public double getMinTarsoPicogordo() {
        return minTarsoPicogordo;
    }

    public double getMaxTarsoPicogordo() {
        return maxTarsoPicogordo;
    }

    public double getMinPesoPicogordo() {
        return minPesoPicogordo;
    }

    public double getMaxPesoPicogordo() {
        return maxPesoPicogordo;
    }

    public int getMaxRecPinzComun() {
        return maxRecPinzComun;
    }

    public int getMaxCimPinzComun() {
        return maxCimPinzComun;
    }

    public double getMinAlaPinzComun() {
        return minAlaPinzComun;
    }

    public double getMaxAlaPinzComun() {
        return maxAlaPinzComun;
    }

    public double getMinPicoPinzComun() {
        return minPicoPinzComun;
    }

    public double getMaxPicoPinzComun() {
        return maxPicoPinzComun;
    }

    public double getMinTarsoPinzComun() {
        return minTarsoPinzComun;
    }

    public double getMaxTarsoPinzComun() {
        return maxTarsoPinzComun;
    }

    public double getMinPesoPinzComun() {
        return minPesoPinzComun;
    }

    public double getMaxPesoPinzComun() {
        return maxPesoPinzComun;
    }

    public int getMaxRecPinzReal() {
        return maxRecPinzReal;
    }

    public int getMaxCimPinzReal() {
        return maxCimPinzReal;
    }

    public double getMinAlaPinzReal() {
        return minAlaPinzReal;
    }

    public double getMaxAlaPinzReal() {
        return maxAlaPinzReal;
    }

    public double getMinPicoPinzReal() {
        return minPicoPinzReal;
    }

    public double getMaxPicoPinzReal() {
        return maxPicoPinzReal;
    }

    public double getMinTarsoPinzReal() {
        return minTarsoPinzReal;
    }

    public double getMaxTarsoPinzReal() {
        return maxTarsoPinzReal;
    }

    public double getMinPesoPinzReal() {
        return minPesoPinzReal;
    }

    public double getMaxPesoPinzReal() {
        return maxPesoPinzReal;
    }

    public int getMaxRecPiquituerto() {
        return maxRecPiquituerto;
    }

    public int getMaxCimPiquituerto() {
        return maxCimPiquituerto;
    }

    public double getMinAlaPiquituerto() {
        return minAlaPiquituerto;
    }

    public double getMaxAlaPiquituerto() {
        return maxAlaPiquituerto;
    }

    public double getMinPicoPiquituerto() {
        return minPicoPiquituerto;
    }

    public double getMaxPicoPiquituerto() {
        return maxPicoPiquituerto;
    }

    public double getMinTarsoPiquituerto() {
        return minTarsoPiquituerto;
    }

    public double getMaxTarsoPiquituerto() {
        return maxTarsoPiquituerto;
    }

    public double getMinPesoPiquituerto() {
        return minPesoPiquituerto;
    }

    public double getMaxPesoPiquituerto() {
        return maxPesoPiquituerto;
    }

    public int getMaxRecVerdecillo() {
        return maxRecVerdecillo;
    }

    public int getMaxCimVerdecillo() {
        return maxCimVerdecillo;
    }

    public double getMinAlaVerdecillo() {
        return minAlaVerdecillo;
    }

    public double getMaxAlaVerdecillo() {
        return maxAlaVerdecillo;
    }

    public double getMinPicoVerdecillo() {
        return minPicoVerdecillo;
    }

    public double getMaxPicoVerdecillo() {
        return maxPicoVerdecillo;
    }

    public double getMinTarsoVerdecillo() {
        return minTarsoVerdecillo;
    }

    public double getMaxTarsoVerdecillo() {
        return maxTarsoVerdecillo;
    }

    public double getMinPesoVerdecillo() {
        return minPesoVerdecillo;
    }

    public double getMaxPesoVerdecillo() {
        return maxPesoVerdecillo;
    }

    public int getMaxRecVerdComun() {
        return maxRecVerdComun;
    }

    public int getMaxCimVerdComun() {
        return maxCimVerdComun;
    }

    public double getMinAlaVerdComun() {
        return minAlaVerdComun;
    }

    public double getMaxAlaVerdComun() {
        return maxAlaVerdComun;
    }

    public double getMinPicoVerdComun() {
        return minPicoVerdComun;
    }

    public double getMaxPicoVerdComun() {
        return maxPicoVerdComun;
    }

    public double getMinTarsoVerdComun() {
        return minTarsoVerdComun;
    }

    public double getMaxTarsoVerdComun() {
        return maxTarsoVerdComun;
    }

    public double getMinPesoVerdComun() {
        return minPesoVerdComun;
    }

    public double getMaxPesoVerdComun() {
        return maxPesoVerdComun;
    }

    public int getMaxRecVerdSerrano() {
        return maxRecVerdSerrano;
    }

    public int getMaxCimVerdSerrano() {
        return maxCimVerdSerrano;
    }

    public double getMinAlaVerdSerrano() {
        return minAlaVerdSerrano;
    }

    public double getMaxAlaVerdSerrano() {
        return maxAlaVerdSerrano;
    }

    public double getMinPicoVerdSerrano() {
        return minPicoVerdSerrano;
    }

    public double getMaxPicoVerdSerrano() {
        return maxPicoVerdSerrano;
    }

    public double getMinTarsoVerdSerrano() {
        return minTarsoVerdSerrano;
    }

    public double getMaxTarsoVerdSerrano() {
        return maxTarsoVerdSerrano;
    }

    public double getMinPesoVerdSerrano() {
        return minPesoVerdSerrano;
    }

    public double getMaxPesoVerdSerrano() {
        return maxPesoVerdSerrano;
    }

    public int getNumeroGrupo() {
        return numeroGrupo;
    }

    public void imprimirDatosRecYCim(){
        System.out.println("Datos Recibidos de Reclamos");
        System.out.println("___________________________________");
        System.out.println("Reclamos Camachuelo    =>" + getMaxRecCamachuelo());
        System.out.println("Reclamos Jilguero      =>" + getMaxRecJilguero());
        System.out.println("Reclamos Lugano        =>" + getMaxRecLugano());
        System.out.println("Reclamos Pard Comun    =>" + getMaxRecPardComun());
        System.out.println("Reclamos Picogordo     =>" + getMaxRecPicogordo());
        System.out.println("Reclamos Pinz Comun    =>" + getMaxRecPinzComun());
        System.out.println("Reclamos Pinz Real     =>" + getMaxRecPinzReal());
        System.out.println("Reclamos Piquituerto   =>" + getMaxRecPiquituerto());
        System.out.println("Reclamos Verdecillo    =>" + getMaxRecVerdecillo());
        System.out.println("Reclamos Verd. Comun   =>" + getMaxRecVerdComun());
        System.out.println("Reclamos Verd. Serrano =>" + getMaxRecVerdSerrano());
        System.out.println("___________________________________");
        System.out.println("Datos Recibidos de Reclamos");
        System.out.println("___________________________________");
        System.out.println("Cimbeles Camachuelo    =>" + getMaxCimCamachuelo());
        System.out.println("Cimbeles Jilguero      =>" + getMaxCimJilguero());
        System.out.println("Cimbeles Lugano        =>" + getMaxCimLugano());
        System.out.println("Cimbeles Pard Comun    =>" + getMaxCimPardComun());
        System.out.println("Cimbeles Picogordo     =>" + getMaxCimPicogordo());
        System.out.println("Cimbeles Pinz Comun    =>" + getMaxCimPinzComun());
        System.out.println("Cimbeles Pinz Real     =>" + getMaxCimPinzReal());
        System.out.println("Cimbeles Piquituerto   =>" + getMaxCimPiquituerto());
        System.out.println("Cimbeles Verdecillo    =>" + getMaxCimVerdecillo());
        System.out.println("Cimbeles Verd. Comun   =>" + getMaxCimVerdComun());
        System.out.println("Cimbeles Verd. Serrano =>" + getMaxCimVerdSerrano());
        System.out.println("___________________________________");

    }

    public void imprimirDatosParametrosAves(){
        System.out.println("Parametros Recibidos de Camachuelo");
        System.out.println("___________________________________");
        System.out.println("MinAla       => " + minAlaCamachuelo);
        System.out.println("MaxAla       => " + maxAlaCamachuelo);
        System.out.println("MinPico      => " + minPicoCamachuelo);
        System.out.println("MaxPico      => " + maxPicoCamachuelo);
        System.out.println("MinTarso     => " + minTarsoCamachuelo);
        System.out.println("MaxTarso     => " + maxTarsoCamachuelo);
        System.out.println("MinPeso      => " + minPesoCamachuelo);
        System.out.println("MaxPeso      => " + maxPesoCamachuelo);
        System.out.println("___________________________________");
        System.out.println("Parametros Recibidos de Jilguero");
        System.out.println("___________________________________");
        System.out.println("MinAla       => " + minAlaJilguero);
        System.out.println("MaxAla       => " + maxAlaJilguero);
        System.out.println("MinPico      => " + minPicoJilguero);
        System.out.println("MaxPico      => " + maxPicoJilguero);
        System.out.println("MinTarso     => " + minTarsoJilguero);
        System.out.println("MaxTarso     => " + maxTarsoJilguero);
        System.out.println("MinPeso      => " + minPesoJilguero);
        System.out.println("MaxPeso      => " + maxPesoJilguero);
        System.out.println("___________________________________");
        System.out.println("Parametros Recibidos de Lugano");
        System.out.println("___________________________________");
        System.out.println("MinAla       => " + minAlaLugano);
        System.out.println("MaxAla       => " + maxAlaLugano);
        System.out.println("MinPico      => " + minPicoLugano);
        System.out.println("MaxPico      => " + maxPicoLugano);
        System.out.println("MinTarso     => " + minTarsoLugano);
        System.out.println("MaxTarso     => " + maxTarsoLugano);
        System.out.println("MinPeso      => " + minPesoLugano);
        System.out.println("MaxPeso      => " + maxPesoLugano);
        System.out.println("___________________________________");
        System.out.println("Parametros Recibidos de PardComun");
        System.out.println("___________________________________");
        System.out.println("MinAla       => " + minAlaPardComun);
        System.out.println("MaxAla       => " + maxAlaPardComun);
        System.out.println("MinPico      => " + minPicoPardComun);
        System.out.println("MaxPico      => " + maxPicoPardComun);
        System.out.println("MinTarso     => " + minTarsoPardComun);
        System.out.println("MaxTarso     => " + maxTarsoPardComun);
        System.out.println("MinPeso      => " + minPesoPardComun);
        System.out.println("MaxPeso      => " + maxPesoPardComun);
        System.out.println("___________________________________");
        System.out.println("Parametros Recibidos de Picogordo");
        System.out.println("___________________________________");
        System.out.println("MinAla       => " + minAlaPicogordo);
        System.out.println("MaxAla       => " + maxAlaPicogordo);
        System.out.println("MinPico      => " + minPicoPicogordo);
        System.out.println("MaxPico      => " + maxPicoPicogordo);
        System.out.println("MinTarso     => " + minTarsoPicogordo);
        System.out.println("MaxTarso     => " + maxTarsoPicogordo);
        System.out.println("MinPeso      => " + minPesoPicogordo);
        System.out.println("MaxPeso      => " + maxPesoPicogordo);
        System.out.println("___________________________________");
        System.out.println("Parametros Recibidos de PinzComun");
        System.out.println("___________________________________");
        System.out.println("MinAla       => " + minAlaPinzComun);
        System.out.println("MaxAla       => " + maxAlaPinzComun);
        System.out.println("MinPico      => " + minPicoPinzComun);
        System.out.println("MaxPico      => " + maxPicoPinzComun);
        System.out.println("MinTarso     => " + minTarsoPinzComun);
        System.out.println("MaxTarso     => " + maxTarsoPinzComun);
        System.out.println("MinPeso      => " + minPesoPinzComun);
        System.out.println("MaxPeso      => " + maxPesoPinzComun);
        System.out.println("___________________________________");
        System.out.println("Parametros Recibidos de PinzReal");
        System.out.println("___________________________________");
        System.out.println("MinAla       => " + minAlaPinzReal);
        System.out.println("MaxAla       => " + maxAlaPinzReal);
        System.out.println("MinPico      => " + minPicoPinzReal);
        System.out.println("MaxPico      => " + maxPicoPinzReal);
        System.out.println("MinTarso     => " + minTarsoPinzReal);
        System.out.println("MaxTarso     => " + maxTarsoPinzReal);
        System.out.println("MinPeso      => " + minPesoPinzReal);
        System.out.println("MaxPeso      => " + maxPesoPinzReal);
        System.out.println("___________________________________");
        System.out.println("Parametros Recibidos de Piquituerto");
        System.out.println("___________________________________");
        System.out.println("MinAla       => " + minAlaPiquituerto);
        System.out.println("MaxAla       => " + maxAlaPiquituerto);
        System.out.println("MinPico      => " + minPicoPiquituerto);
        System.out.println("MaxPico      => " + maxPicoPiquituerto);
        System.out.println("MinTarso     => " + minTarsoPiquituerto);
        System.out.println("MaxTarso     => " + maxTarsoPiquituerto);
        System.out.println("MinPeso      => " + minPesoPiquituerto);
        System.out.println("MaxPeso      => " + maxPesoPiquituerto);
        System.out.println("___________________________________");
        System.out.println("Parametros Recibidos de Verdecillo");
        System.out.println("___________________________________");
        System.out.println("MinAla       => " + minAlaVerdecillo);
        System.out.println("MaxAla       => " + maxAlaVerdecillo);
        System.out.println("MinPico      => " + minPicoVerdecillo);
        System.out.println("MaxPico      => " + maxPicoVerdecillo);
        System.out.println("MinTarso     => " + minTarsoVerdecillo);
        System.out.println("MaxTarso     => " + maxTarsoVerdecillo);
        System.out.println("MinPeso      => " + minPesoVerdecillo);
        System.out.println("MaxPeso      => " + maxPesoVerdecillo);
        System.out.println("___________________________________");
        System.out.println("Parametros Recibidos de VerdComun");
        System.out.println("___________________________________");
        System.out.println("MinAla       => " + minAlaVerdComun);
        System.out.println("MaxAla       => " + maxAlaVerdComun);
        System.out.println("MinPico      => " + minPicoVerdComun);
        System.out.println("MaxPico      => " + maxPicoVerdComun);
        System.out.println("MinTarso     => " + minTarsoVerdComun);
        System.out.println("MaxTarso     => " + maxTarsoVerdComun);
        System.out.println("MinPeso      => " + minPesoVerdComun);
        System.out.println("MaxPeso      => " + maxPesoVerdComun);
        System.out.println("___________________________________");
        System.out.println("Parametros Recibidos de VerdSerrano");
        System.out.println("___________________________________");
        System.out.println("MinAla       => " + minAlaVerdSerrano);
        System.out.println("MaxAla       => " + maxAlaVerdSerrano);
        System.out.println("MinPico      => " + minPicoVerdSerrano);
        System.out.println("MaxPico      => " + maxPicoVerdSerrano);
        System.out.println("MinTarso     => " + minTarsoVerdSerrano);
        System.out.println("MaxTarso     => " + maxTarsoVerdSerrano);
        System.out.println("MinPeso      => " + minPesoVerdSerrano);
        System.out.println("MaxPeso      => " + maxPesoVerdSerrano);
        System.out.println("___________________________________");
    }


    public void readObject(int numGrupo) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Limites_Anillamiento");

        query.whereEqualTo("NumGrupo", numGrupo);

        query.findInBackground((objects, e) -> {
            if (e == null){
                ParseObject  obj = objects.get(0);

                minNAnilla = obj.getInt("NAnillaMin");
                maxNAnilla = obj.getInt("NAnillaMax");

                numeroGrupo  = obj.getInt("NumGrupo");
            }
        });
    }

    public void imprimirDatosAnillamiento() {
        System.out.println(" ** Datos Anillamiento Recibidos **");
        System.out.println("___________________________________");
        System.out.println("ANILLA MAX            =>" + maxNAnilla);
        System.out.println("ANILLA MIN            =>" + minNAnilla);
        System.out.println("___________________________________");
        System.out.println("ANILLABLE Camachuelo  =>" + isAnillableCamachuelo());
        System.out.println("ANILLABLE VerdSerrano =>" + isAnillableVerdSerrano());
        System.out.println("ANILLABLE VerdComun   =>" + isAnillableVerdComun());
        System.out.println("ANILLABLE Picogordo   =>" + isAnillablePicogordo());
        System.out.println("ANILLABLE Piquituerto =>" + isAnillablePiquituerto());
        System.out.println("ANILLABLE PardComun   =>" + isAnillablePardComun());
        System.out.println("ANILLABLE PinzComun   =>" + isAnillablePinzComun());
        System.out.println("ANILLABLE PinzReal    =>" + isAnillablePinzReal());
        System.out.println("ANILLABLE Verdecillo  =>" + isAnillableVerdecillo());
        System.out.println("ANILLABLE Jilguero    =>" + isAnillableJilguero());
        System.out.println("ANILLABLE Lugano      =>" + isAnillableLugano());
        System.out.println("___________________________________");

    }

}
