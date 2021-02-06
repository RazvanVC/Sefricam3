package com.sefricam.sefricam3;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.Serializable;

public class Limites implements Serializable {
    private int minLat, maxLat, minLon, maxLon, minTemp, maxTemp, minNAnilla, maxNAnilla;
    private int maxRecCamachuelo, maxCimCamachuelo, minAlaCamachuelo, maxAlaCamachuelo, minPicoCamachuelo, maxPicoCamachuelo, minTarsoCamachuelo, maxTarsoCamachuelo, minPesoCamachuelo, maxPesoCamachuelo;
    private int maxRecJilguero, maxCimJilguero, minAlaJilguero, maxAlaJilguero, minPicoJilguero, maxPicoJilguero, minTarsoJilguero, maxTarsoJilguero, minPesoJilguero, maxPesoJilguero;
    private int maxRecLugano, maxCimLugano, minAlaLugano, maxAlaLugano, minPicoLugano, maxPicoLugano, minTarsoLugano, maxTarsoLugano, minPesoLugano, maxPesoLugano;
    private int maxRecPardComun, maxCimPardComun, minAlaPardComun, maxAlaPardComun, minPicoPardComun, maxPicoPardComun, minTarsoPardComun, maxTarsoPardComun, minPesoPardComun, maxPesoPardComun;
    private int maxRecPicogordo, maxCimPicogordo, minAlaPicogordo, maxAlaPicogordo, minPicoPicogordo, maxPicoPicogordo, minTarsoPicogordo, maxTarsoPicogordo, minPesoPicogordo, maxPesoPicogordo;
    private int maxRecPinzComun, maxCimPinzComun, minAlaPinzComun, maxAlaPinzComun, minPicoPinzComun, maxPicoPinzComun, minTarsoPinzComun, maxTarsoPinzComun, minPesoPinzComun, maxPesoPinzComun;
    private int maxRecPinzReal, maxCimPinzReal, minAlaPinzReal, maxAlaPinzReal, minPicoPinzReal, maxPicoPinzReal, minTarsoPinzReal, maxTarsoPinzReal, minPesoPinzReal, maxPesoPinzReal;
    private int maxRecPiquituerto, maxCimPiquituerto, minAlaPiquituerto, maxAlaPiquituerto, minPicoPiquituerto, maxPicoPiquituerto, minTarsoPiquituerto, maxTarsoPiquituerto, minPesoPiquituerto, maxPesoPiquituerto;
    private int maxRecVerdecillo, maxCimVerdecillo, minAlaVerdecillo, maxAlaVerdecillo, minPicoVerdecillo, maxPicoVerdecillo, minTarsoVerdecillo, maxTarsoVerdecillo, minPesoVerdecillo, maxPesoVerdecillo;
    private int maxRecVerdComun, maxCimVerdComun, minAlaVerdComun, maxAlaVerdComun, minPicoVerdComun, maxPicoVerdComun, minTarsoVerdComun, maxTarsoVerdComun, minPesoVerdComun, maxPesoVerdComun;
    private int maxRecVerdSerrano, maxCimVerdSerrano, minAlaVerdSerrano, maxAlaCVerdSerrano, minPicoVerdSerrano, maxPicoVerdSerrano, minTarsoVerdSerrano, maxTarsoVerdSerrano, minPesoVerdSerrano, maxPesoVerdSerrano;

    public Limites() {
        readObject();
    }

    private void readObject() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Limites");

        // The query will search for a ParseObject, given its objectId.
        // When the query finishes running, it will invoke the GetCallback
        // with either the object, or the exception thrown
        query.getInBackground("AWmV7DLevo", new GetCallback<ParseObject>() {
            public void done(ParseObject result, ParseException e) {
                if (e == null) {
                    //Datos Generales
                    minLat = result.getInt("MinLat");
                    maxLat = result.getInt("MaxLat");
                    minLon = result.getInt("MinLon");
                    maxLon = result.getInt("MaxLon");
                    minTemp = result.getInt("MinTemp");
                    maxTemp = result.getInt("MaxTemp");

                    //Datos Aves
                    maxRecCamachuelo = result.getInt("MaxRecCamachuelo");
                    maxCimCamachuelo = result.getInt("MaxCimCamachuelo");
                    minAlaCamachuelo = result.getInt("MinAlaCamachuelo");
                    

                } else {
                    System.out.println("ERROR: No es posible leer los datos");
                }
            }
        });
    }

    public int getMinLat() {
        return minLat;
    }

    public int getMaxLat() {
        return maxLat;
    }

    public int getMinLon() {
        return minLon;
    }

    public int getMaxLon() {
        return maxLon;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
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

    public int getMinAlaCamachuelo() {
        return minAlaCamachuelo;
    }

    public int getMaxAlaCamachuelo() {
        return maxAlaCamachuelo;
    }

    public int getMinPicoCamachuelo() {
        return minPicoCamachuelo;
    }

    public int getmaxPicoCamachuelo() {
        return maxPicoCamachuelo;
    }

    public int getMinTarsoCamachuelo() {
        return minTarsoCamachuelo;
    }

    public int getMaxTarsoCamachuelo() {
        return maxTarsoCamachuelo;
    }

    public int getMinPesoCamachuelo() {
        return minPesoCamachuelo;
    }

    public int getMaxPesoCamachuelo() {
        return maxPesoCamachuelo;
    }

    public int getMaxRecJilguero() {
        return maxRecJilguero;
    }

    public int getMaxCimJilguero() {
        return maxCimJilguero;
    }

    public int getMinAlaJilguero() {
        return minAlaJilguero;
    }

    public int getMaxAlaJilguero() {
        return maxAlaJilguero;
    }

    public int getMinPicoJilguero() {
        return minPicoJilguero;
    }

    public int getmaxPicoJilguero() {
        return maxPicoJilguero;
    }

    public int getMinTarsoJilguero() {
        return minTarsoJilguero;
    }

    public int getMaxTarsoJilguero() {
        return maxTarsoJilguero;
    }

    public int getMinPesoJilguero() {
        return minPesoJilguero;
    }

    public int getMaxPesoJilguero() {
        return maxPesoJilguero;
    }

    public int getMaxRecLugano() {
        return maxRecLugano;
    }

    public int getMaxCimLugano() {
        return maxCimLugano;
    }

    public int getMinAlaLugano() {
        return minAlaLugano;
    }

    public int getMaxAlaLugano() {
        return maxAlaLugano;
    }

    public int getMinPicoLugano() {
        return minPicoLugano;
    }

    public int getmaxPicoLugano() {
        return maxPicoLugano;
    }

    public int getMinTarsoLugano() {
        return minTarsoLugano;
    }

    public int getMaxTarsoLugano() {
        return maxTarsoLugano;
    }

    public int getMinPesoLugano() {
        return minPesoLugano;
    }

    public int getMaxPesoLugano() {
        return maxPesoLugano;
    }

    public int getMaxRecPardComun() {
        return maxRecPardComun;
    }

    public int getMaxCimPardComun() {
        return maxCimPardComun;
    }

    public int getMinAlaPardComun() {
        return minAlaPardComun;
    }

    public int getMaxAlaPardComun() {
        return maxAlaPardComun;
    }

    public int getMinPicoPardComun() {
        return minPicoPardComun;
    }

    public int getmaxPicoPardComun() {
        return maxPicoPardComun;
    }

    public int getMinTarsoPardComun() {
        return minTarsoPardComun;
    }

    public int getMaxTarsoPardComun() {
        return maxTarsoPardComun;
    }

    public int getMinPesoPardComun() {
        return minPesoPardComun;
    }

    public int getMaxPesoPardComun() {
        return maxPesoPardComun;
    }

    public int getMaxRecPicogordo() {
        return maxRecPicogordo;
    }

    public int getMaxCimPicogordo() {
        return maxCimPicogordo;
    }

    public int getMinAlaPicogordo() {
        return minAlaPicogordo;
    }

    public int getMaxAlaPicogordo() {
        return maxAlaPicogordo;
    }

    public int getMinPicoPicogordo() {
        return minPicoPicogordo;
    }

    public int getmaxPicoPicogordo() {
        return maxPicoPicogordo;
    }

    public int getMinTarsoPicogordo() {
        return minTarsoPicogordo;
    }

    public int getMaxTarsoPicogordo() {
        return maxTarsoPicogordo;
    }

    public int getMinPesoPicogordo() {
        return minPesoPicogordo;
    }

    public int getMaxPesoPicogordo() {
        return maxPesoPicogordo;
    }

    public int getMaxRecPinzComun() {
        return maxRecPinzComun;
    }

    public int getMaxCimPinzComun() {
        return maxCimPinzComun;
    }

    public int getMinAlaPinzComun() {
        return minAlaPinzComun;
    }

    public int getMaxAlaPinzComun() {
        return maxAlaPinzComun;
    }

    public int getMinPicoPinzComun() {
        return minPicoPinzComun;
    }

    public int getmaxPicoPinzComun() {
        return maxPicoPinzComun;
    }

    public int getMinTarsoPinzComun() {
        return minTarsoPinzComun;
    }

    public int getMaxTarsoPinzComun() {
        return maxTarsoPinzComun;
    }

    public int getMinPesoPinzComun() {
        return minPesoPinzComun;
    }

    public int getMaxPesoPinzComun() {
        return maxPesoPinzComun;
    }

    public int getMaxRecPinzReal() {
        return maxRecPinzReal;
    }

    public int getMaxCimPinzReal() {
        return maxCimPinzReal;
    }

    public int getMinAlaPinzReal() {
        return minAlaPinzReal;
    }

    public int getMaxAlaPinzReal() {
        return maxAlaPinzReal;
    }

    public int getMinPicoPinzReal() {
        return minPicoPinzReal;
    }

    public int getmaxPicoPinzReal() {
        return maxPicoPinzReal;
    }

    public int getMinTarsoPinzReal() {
        return minTarsoPinzReal;
    }

    public int getMaxTarsoPinzReal() {
        return maxTarsoPinzReal;
    }

    public int getMinPesoPinzReal() {
        return minPesoPinzReal;
    }

    public int getMaxPesoPinzReal() {
        return maxPesoPinzReal;
    }

    public int getMaxRecPiquituerto() {
        return maxRecPiquituerto;
    }

    public int getMaxCimPiquituerto() {
        return maxCimPiquituerto;
    }

    public int getMinAlaPiquituerto() {
        return minAlaPiquituerto;
    }

    public int getMaxAlaPiquituerto() {
        return maxAlaPiquituerto;
    }

    public int getMinPicoPiquituerto() {
        return minPicoPiquituerto;
    }

    public int getmaxPicoPiquituerto() {
        return maxPicoPiquituerto;
    }

    public int getMinTarsoPiquituerto() {
        return minTarsoPiquituerto;
    }

    public int getMaxTarsoPiquituerto() {
        return maxTarsoPiquituerto;
    }

    public int getMinPesoPiquituerto() {
        return minPesoPiquituerto;
    }

    public int getMaxPesoPiquituerto() {
        return maxPesoPiquituerto;
    }

    public int getMaxRecVerdecillo() {
        return maxRecVerdecillo;
    }

    public int getMaxCimVerdecillo() {
        return maxCimVerdecillo;
    }

    public int getMinAlaVerdecillo() {
        return minAlaVerdecillo;
    }

    public int getMaxAlaVerdecillo() {
        return maxAlaVerdecillo;
    }

    public int getMinPicoVerdecillo() {
        return minPicoVerdecillo;
    }

    public int getmaxPicoVerdecillo() {
        return maxPicoVerdecillo;
    }

    public int getMinTarsoVerdecillo() {
        return minTarsoVerdecillo;
    }

    public int getMaxTarsoVerdecillo() {
        return maxTarsoVerdecillo;
    }

    public int getMinPesoVerdecillo() {
        return minPesoVerdecillo;
    }

    public int getMaxPesoVerdecillo() {
        return maxPesoVerdecillo;
    }

    public int getMaxRecVerdComun() {
        return maxRecVerdComun;
    }

    public int getMaxCimVerdComun() {
        return maxCimVerdComun;
    }

    public int getMinAlaVerdComun() {
        return minAlaVerdComun;
    }

    public int getMaxAlaVerdComun() {
        return maxAlaVerdComun;
    }

    public int getMinPicoVerdComun() {
        return minPicoVerdComun;
    }

    public int getmaxPicoVerdComun() {
        return maxPicoVerdComun;
    }

    public int getMinTarsoVerdComun() {
        return minTarsoVerdComun;
    }

    public int getMaxTarsoVerdComun() {
        return maxTarsoVerdComun;
    }

    public int getMinPesoVerdComun() {
        return minPesoVerdComun;
    }

    public int getMaxPesoVerdComun() {
        return maxPesoVerdComun;
    }

    public int getMaxRecVerdSerrano() {
        return maxRecVerdSerrano;
    }

    public int getMaxCimVerdSerrano() {
        return maxCimVerdSerrano;
    }

    public int getMinAlaVerdSerrano() {
        return minAlaVerdSerrano;
    }

    public int getMaxAlaCVerdSerrano() {
        return maxAlaCVerdSerrano;
    }

    public int getMinPicoVerdSerrano() {
        return minPicoVerdSerrano;
    }

    public int getmaxPicoVerdSerrano() {
        return maxPicoVerdSerrano;
    }

    public int getMinTarsoVerdSerrano() {
        return minTarsoVerdSerrano;
    }

    public int getMaxTarsoVerdSerrano() {
        return maxTarsoVerdSerrano;
    }

    public int getMinPesoVerdSerrano() {
        return minPesoVerdSerrano;
    }

    public int getMaxPesoVerdSerrano() {
        return maxPesoVerdSerrano;
    }

    public int getMinNAnilla() {
        return minNAnilla;
    }

}
