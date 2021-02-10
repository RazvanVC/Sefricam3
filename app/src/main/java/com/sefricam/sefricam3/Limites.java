package com.sefricam.sefricam3;

import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.Serializable;
import java.util.List;

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

                } else {
                    System.out.println("ERROR: No es posible leer los datos");
                }
            }
        });
    }

    public int getMinLat() {
        return minLat;
    }

    public void setMinLat(int minLat) {
        this.minLat = minLat;
    }

    public int getMaxLat() {
        return maxLat;
    }

    public void setMaxLat(int maxLat) {
        this.maxLat = maxLat;
    }

    public int getMinLon() {
        return minLon;
    }

    public void setMinLon(int minLon) {
        this.minLon = minLon;
    }

    public int getMaxLon() {
        return maxLon;
    }

    public void setMaxLon(int maxLon) {
        this.maxLon = maxLon;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getMinNAnilla() {
        return minNAnilla;
    }

    public void setMinNAnilla(int minNAnilla) {
        this.minNAnilla = minNAnilla;
    }

    public int getMaxNAnilla() {
        return maxNAnilla;
    }

    public void setMaxNAnilla(int maxNAnilla) {
        this.maxNAnilla = maxNAnilla;
    }

    public int getMaxRecCamachuelo() {
        return maxRecCamachuelo;
    }

    public void setMaxRecCamachuelo(int maxRecCamachuelo) {
        this.maxRecCamachuelo = maxRecCamachuelo;
    }

    public int getMaxCimCamachuelo() {
        return maxCimCamachuelo;
    }

    public void setMaxCimCamachuelo(int maxCimCamachuelo) {
        this.maxCimCamachuelo = maxCimCamachuelo;
    }

    public int getMinAlaCamachuelo() {
        return minAlaCamachuelo;
    }

    public void setMinAlaCamachuelo(int minAlaCamachuelo) {
        this.minAlaCamachuelo = minAlaCamachuelo;
    }

    public int getMaxAlaCamachuelo() {
        return maxAlaCamachuelo;
    }

    public void setMaxAlaCamachuelo(int maxAlaCamachuelo) {
        this.maxAlaCamachuelo = maxAlaCamachuelo;
    }

    public int getMinPicoCamachuelo() {
        return minPicoCamachuelo;
    }

    public void setMinPicoCamachuelo(int minPicoCamachuelo) {
        this.minPicoCamachuelo = minPicoCamachuelo;
    }

    public int getMaxPicoCamachuelo() {
        return maxPicoCamachuelo;
    }

    public void setMaxPicoCamachuelo(int maxPicoCamachuelo) {
        this.maxPicoCamachuelo = maxPicoCamachuelo;
    }

    public int getMinTarsoCamachuelo() {
        return minTarsoCamachuelo;
    }

    public void setMinTarsoCamachuelo(int minTarsoCamachuelo) {
        this.minTarsoCamachuelo = minTarsoCamachuelo;
    }

    public int getMaxTarsoCamachuelo() {
        return maxTarsoCamachuelo;
    }

    public void setMaxTarsoCamachuelo(int maxTarsoCamachuelo) {
        this.maxTarsoCamachuelo = maxTarsoCamachuelo;
    }

    public int getMinPesoCamachuelo() {
        return minPesoCamachuelo;
    }

    public void setMinPesoCamachuelo(int minPesoCamachuelo) {
        this.minPesoCamachuelo = minPesoCamachuelo;
    }

    public int getMaxPesoCamachuelo() {
        return maxPesoCamachuelo;
    }

    public void setMaxPesoCamachuelo(int maxPesoCamachuelo) {
        this.maxPesoCamachuelo = maxPesoCamachuelo;
    }

    public int getMaxRecJilguero() {
        return maxRecJilguero;
    }

    public void setMaxRecJilguero(int maxRecJilguero) {
        this.maxRecJilguero = maxRecJilguero;
    }

    public int getMaxCimJilguero() {
        return maxCimJilguero;
    }

    public void setMaxCimJilguero(int maxCimJilguero) {
        this.maxCimJilguero = maxCimJilguero;
    }

    public int getMinAlaJilguero() {
        return minAlaJilguero;
    }

    public void setMinAlaJilguero(int minAlaJilguero) {
        this.minAlaJilguero = minAlaJilguero;
    }

    public int getMaxAlaJilguero() {
        return maxAlaJilguero;
    }

    public void setMaxAlaJilguero(int maxAlaJilguero) {
        this.maxAlaJilguero = maxAlaJilguero;
    }

    public int getMinPicoJilguero() {
        return minPicoJilguero;
    }

    public void setMinPicoJilguero(int minPicoJilguero) {
        this.minPicoJilguero = minPicoJilguero;
    }

    public int getMaxPicoJilguero() {
        return maxPicoJilguero;
    }

    public void setMaxPicoJilguero(int maxPicoJilguero) {
        this.maxPicoJilguero = maxPicoJilguero;
    }

    public int getMinTarsoJilguero() {
        return minTarsoJilguero;
    }

    public void setMinTarsoJilguero(int minTarsoJilguero) {
        this.minTarsoJilguero = minTarsoJilguero;
    }

    public int getMaxTarsoJilguero() {
        return maxTarsoJilguero;
    }

    public void setMaxTarsoJilguero(int maxTarsoJilguero) {
        this.maxTarsoJilguero = maxTarsoJilguero;
    }

    public int getMinPesoJilguero() {
        return minPesoJilguero;
    }

    public void setMinPesoJilguero(int minPesoJilguero) {
        this.minPesoJilguero = minPesoJilguero;
    }

    public int getMaxPesoJilguero() {
        return maxPesoJilguero;
    }

    public void setMaxPesoJilguero(int maxPesoJilguero) {
        this.maxPesoJilguero = maxPesoJilguero;
    }

    public int getMaxRecLugano() {
        return maxRecLugano;
    }

    public void setMaxRecLugano(int maxRecLugano) {
        this.maxRecLugano = maxRecLugano;
    }

    public int getMaxCimLugano() {
        return maxCimLugano;
    }

    public void setMaxCimLugano(int maxCimLugano) {
        this.maxCimLugano = maxCimLugano;
    }

    public int getMinAlaLugano() {
        return minAlaLugano;
    }

    public void setMinAlaLugano(int minAlaLugano) {
        this.minAlaLugano = minAlaLugano;
    }

    public int getMaxAlaLugano() {
        return maxAlaLugano;
    }

    public void setMaxAlaLugano(int maxAlaLugano) {
        this.maxAlaLugano = maxAlaLugano;
    }

    public int getMinPicoLugano() {
        return minPicoLugano;
    }

    public void setMinPicoLugano(int minPicoLugano) {
        this.minPicoLugano = minPicoLugano;
    }

    public int getMaxPicoLugano() {
        return maxPicoLugano;
    }

    public void setMaxPicoLugano(int maxPicoLugano) {
        this.maxPicoLugano = maxPicoLugano;
    }

    public int getMinTarsoLugano() {
        return minTarsoLugano;
    }

    public void setMinTarsoLugano(int minTarsoLugano) {
        this.minTarsoLugano = minTarsoLugano;
    }

    public int getMaxTarsoLugano() {
        return maxTarsoLugano;
    }

    public void setMaxTarsoLugano(int maxTarsoLugano) {
        this.maxTarsoLugano = maxTarsoLugano;
    }

    public int getMinPesoLugano() {
        return minPesoLugano;
    }

    public void setMinPesoLugano(int minPesoLugano) {
        this.minPesoLugano = minPesoLugano;
    }

    public int getMaxPesoLugano() {
        return maxPesoLugano;
    }

    public void setMaxPesoLugano(int maxPesoLugano) {
        this.maxPesoLugano = maxPesoLugano;
    }

    public int getMaxRecPardComun() {
        return maxRecPardComun;
    }

    public void setMaxRecPardComun(int maxRecPardComun) {
        this.maxRecPardComun = maxRecPardComun;
    }

    public int getMaxCimPardComun() {
        return maxCimPardComun;
    }

    public void setMaxCimPardComun(int maxCimPardComun) {
        this.maxCimPardComun = maxCimPardComun;
    }

    public int getMinAlaPardComun() {
        return minAlaPardComun;
    }

    public void setMinAlaPardComun(int minAlaPardComun) {
        this.minAlaPardComun = minAlaPardComun;
    }

    public int getMaxAlaPardComun() {
        return maxAlaPardComun;
    }

    public void setMaxAlaPardComun(int maxAlaPardComun) {
        this.maxAlaPardComun = maxAlaPardComun;
    }

    public int getMinPicoPardComun() {
        return minPicoPardComun;
    }

    public void setMinPicoPardComun(int minPicoPardComun) {
        this.minPicoPardComun = minPicoPardComun;
    }

    public int getMaxPicoPardComun() {
        return maxPicoPardComun;
    }

    public void setMaxPicoPardComun(int maxPicoPardComun) {
        this.maxPicoPardComun = maxPicoPardComun;
    }

    public int getMinTarsoPardComun() {
        return minTarsoPardComun;
    }

    public void setMinTarsoPardComun(int minTarsoPardComun) {
        this.minTarsoPardComun = minTarsoPardComun;
    }

    public int getMaxTarsoPardComun() {
        return maxTarsoPardComun;
    }

    public void setMaxTarsoPardComun(int maxTarsoPardComun) {
        this.maxTarsoPardComun = maxTarsoPardComun;
    }

    public int getMinPesoPardComun() {
        return minPesoPardComun;
    }

    public void setMinPesoPardComun(int minPesoPardComun) {
        this.minPesoPardComun = minPesoPardComun;
    }

    public int getMaxPesoPardComun() {
        return maxPesoPardComun;
    }

    public void setMaxPesoPardComun(int maxPesoPardComun) {
        this.maxPesoPardComun = maxPesoPardComun;
    }

    public int getMaxRecPicogordo() {
        return maxRecPicogordo;
    }

    public void setMaxRecPicogordo(int maxRecPicogordo) {
        this.maxRecPicogordo = maxRecPicogordo;
    }

    public int getMaxCimPicogordo() {
        return maxCimPicogordo;
    }

    public void setMaxCimPicogordo(int maxCimPicogordo) {
        this.maxCimPicogordo = maxCimPicogordo;
    }

    public int getMinAlaPicogordo() {
        return minAlaPicogordo;
    }

    public void setMinAlaPicogordo(int minAlaPicogordo) {
        this.minAlaPicogordo = minAlaPicogordo;
    }

    public int getMaxAlaPicogordo() {
        return maxAlaPicogordo;
    }

    public void setMaxAlaPicogordo(int maxAlaPicogordo) {
        this.maxAlaPicogordo = maxAlaPicogordo;
    }

    public int getMinPicoPicogordo() {
        return minPicoPicogordo;
    }

    public void setMinPicoPicogordo(int minPicoPicogordo) {
        this.minPicoPicogordo = minPicoPicogordo;
    }

    public int getMaxPicoPicogordo() {
        return maxPicoPicogordo;
    }

    public void setMaxPicoPicogordo(int maxPicoPicogordo) {
        this.maxPicoPicogordo = maxPicoPicogordo;
    }

    public int getMinTarsoPicogordo() {
        return minTarsoPicogordo;
    }

    public void setMinTarsoPicogordo(int minTarsoPicogordo) {
        this.minTarsoPicogordo = minTarsoPicogordo;
    }

    public int getMaxTarsoPicogordo() {
        return maxTarsoPicogordo;
    }

    public void setMaxTarsoPicogordo(int maxTarsoPicogordo) {
        this.maxTarsoPicogordo = maxTarsoPicogordo;
    }

    public int getMinPesoPicogordo() {
        return minPesoPicogordo;
    }

    public void setMinPesoPicogordo(int minPesoPicogordo) {
        this.minPesoPicogordo = minPesoPicogordo;
    }

    public int getMaxPesoPicogordo() {
        return maxPesoPicogordo;
    }

    public void setMaxPesoPicogordo(int maxPesoPicogordo) {
        this.maxPesoPicogordo = maxPesoPicogordo;
    }

    public int getMaxRecPinzComun() {
        return maxRecPinzComun;
    }

    public void setMaxRecPinzComun(int maxRecPinzComun) {
        this.maxRecPinzComun = maxRecPinzComun;
    }

    public int getMaxCimPinzComun() {
        return maxCimPinzComun;
    }

    public void setMaxCimPinzComun(int maxCimPinzComun) {
        this.maxCimPinzComun = maxCimPinzComun;
    }

    public int getMinAlaPinzComun() {
        return minAlaPinzComun;
    }

    public void setMinAlaPinzComun(int minAlaPinzComun) {
        this.minAlaPinzComun = minAlaPinzComun;
    }

    public int getMaxAlaPinzComun() {
        return maxAlaPinzComun;
    }

    public void setMaxAlaPinzComun(int maxAlaPinzComun) {
        this.maxAlaPinzComun = maxAlaPinzComun;
    }

    public int getMinPicoPinzComun() {
        return minPicoPinzComun;
    }

    public void setMinPicoPinzComun(int minPicoPinzComun) {
        this.minPicoPinzComun = minPicoPinzComun;
    }

    public int getMaxPicoPinzComun() {
        return maxPicoPinzComun;
    }

    public void setMaxPicoPinzComun(int maxPicoPinzComun) {
        this.maxPicoPinzComun = maxPicoPinzComun;
    }

    public int getMinTarsoPinzComun() {
        return minTarsoPinzComun;
    }

    public void setMinTarsoPinzComun(int minTarsoPinzComun) {
        this.minTarsoPinzComun = minTarsoPinzComun;
    }

    public int getMaxTarsoPinzComun() {
        return maxTarsoPinzComun;
    }

    public void setMaxTarsoPinzComun(int maxTarsoPinzComun) {
        this.maxTarsoPinzComun = maxTarsoPinzComun;
    }

    public int getMinPesoPinzComun() {
        return minPesoPinzComun;
    }

    public void setMinPesoPinzComun(int minPesoPinzComun) {
        this.minPesoPinzComun = minPesoPinzComun;
    }

    public int getMaxPesoPinzComun() {
        return maxPesoPinzComun;
    }

    public void setMaxPesoPinzComun(int maxPesoPinzComun) {
        this.maxPesoPinzComun = maxPesoPinzComun;
    }

    public int getMaxRecPinzReal() {
        return maxRecPinzReal;
    }

    public void setMaxRecPinzReal(int maxRecPinzReal) {
        this.maxRecPinzReal = maxRecPinzReal;
    }

    public int getMaxCimPinzReal() {
        return maxCimPinzReal;
    }

    public void setMaxCimPinzReal(int maxCimPinzReal) {
        this.maxCimPinzReal = maxCimPinzReal;
    }

    public int getMinAlaPinzReal() {
        return minAlaPinzReal;
    }

    public void setMinAlaPinzReal(int minAlaPinzReal) {
        this.minAlaPinzReal = minAlaPinzReal;
    }

    public int getMaxAlaPinzReal() {
        return maxAlaPinzReal;
    }

    public void setMaxAlaPinzReal(int maxAlaPinzReal) {
        this.maxAlaPinzReal = maxAlaPinzReal;
    }

    public int getMinPicoPinzReal() {
        return minPicoPinzReal;
    }

    public void setMinPicoPinzReal(int minPicoPinzReal) {
        this.minPicoPinzReal = minPicoPinzReal;
    }

    public int getMaxPicoPinzReal() {
        return maxPicoPinzReal;
    }

    public void setMaxPicoPinzReal(int maxPicoPinzReal) {
        this.maxPicoPinzReal = maxPicoPinzReal;
    }

    public int getMinTarsoPinzReal() {
        return minTarsoPinzReal;
    }

    public void setMinTarsoPinzReal(int minTarsoPinzReal) {
        this.minTarsoPinzReal = minTarsoPinzReal;
    }

    public int getMaxTarsoPinzReal() {
        return maxTarsoPinzReal;
    }

    public void setMaxTarsoPinzReal(int maxTarsoPinzReal) {
        this.maxTarsoPinzReal = maxTarsoPinzReal;
    }

    public int getMinPesoPinzReal() {
        return minPesoPinzReal;
    }

    public void setMinPesoPinzReal(int minPesoPinzReal) {
        this.minPesoPinzReal = minPesoPinzReal;
    }

    public int getMaxPesoPinzReal() {
        return maxPesoPinzReal;
    }

    public void setMaxPesoPinzReal(int maxPesoPinzReal) {
        this.maxPesoPinzReal = maxPesoPinzReal;
    }

    public int getMaxRecPiquituerto() {
        return maxRecPiquituerto;
    }

    public void setMaxRecPiquituerto(int maxRecPiquituerto) {
        this.maxRecPiquituerto = maxRecPiquituerto;
    }

    public int getMaxCimPiquituerto() {
        return maxCimPiquituerto;
    }

    public void setMaxCimPiquituerto(int maxCimPiquituerto) {
        this.maxCimPiquituerto = maxCimPiquituerto;
    }

    public int getMinAlaPiquituerto() {
        return minAlaPiquituerto;
    }

    public void setMinAlaPiquituerto(int minAlaPiquituerto) {
        this.minAlaPiquituerto = minAlaPiquituerto;
    }

    public int getMaxAlaPiquituerto() {
        return maxAlaPiquituerto;
    }

    public void setMaxAlaPiquituerto(int maxAlaPiquituerto) {
        this.maxAlaPiquituerto = maxAlaPiquituerto;
    }

    public int getMinPicoPiquituerto() {
        return minPicoPiquituerto;
    }

    public void setMinPicoPiquituerto(int minPicoPiquituerto) {
        this.minPicoPiquituerto = minPicoPiquituerto;
    }

    public int getMaxPicoPiquituerto() {
        return maxPicoPiquituerto;
    }

    public void setMaxPicoPiquituerto(int maxPicoPiquituerto) {
        this.maxPicoPiquituerto = maxPicoPiquituerto;
    }

    public int getMinTarsoPiquituerto() {
        return minTarsoPiquituerto;
    }

    public void setMinTarsoPiquituerto(int minTarsoPiquituerto) {
        this.minTarsoPiquituerto = minTarsoPiquituerto;
    }

    public int getMaxTarsoPiquituerto() {
        return maxTarsoPiquituerto;
    }

    public void setMaxTarsoPiquituerto(int maxTarsoPiquituerto) {
        this.maxTarsoPiquituerto = maxTarsoPiquituerto;
    }

    public int getMinPesoPiquituerto() {
        return minPesoPiquituerto;
    }

    public void setMinPesoPiquituerto(int minPesoPiquituerto) {
        this.minPesoPiquituerto = minPesoPiquituerto;
    }

    public int getMaxPesoPiquituerto() {
        return maxPesoPiquituerto;
    }

    public void setMaxPesoPiquituerto(int maxPesoPiquituerto) {
        this.maxPesoPiquituerto = maxPesoPiquituerto;
    }

    public int getMaxRecVerdecillo() {
        return maxRecVerdecillo;
    }

    public void setMaxRecVerdecillo(int maxRecVerdecillo) {
        this.maxRecVerdecillo = maxRecVerdecillo;
    }

    public int getMaxCimVerdecillo() {
        return maxCimVerdecillo;
    }

    public void setMaxCimVerdecillo(int maxCimVerdecillo) {
        this.maxCimVerdecillo = maxCimVerdecillo;
    }

    public int getMinAlaVerdecillo() {
        return minAlaVerdecillo;
    }

    public void setMinAlaVerdecillo(int minAlaVerdecillo) {
        this.minAlaVerdecillo = minAlaVerdecillo;
    }

    public int getMaxAlaVerdecillo() {
        return maxAlaVerdecillo;
    }

    public void setMaxAlaVerdecillo(int maxAlaVerdecillo) {
        this.maxAlaVerdecillo = maxAlaVerdecillo;
    }

    public int getMinPicoVerdecillo() {
        return minPicoVerdecillo;
    }

    public void setMinPicoVerdecillo(int minPicoVerdecillo) {
        this.minPicoVerdecillo = minPicoVerdecillo;
    }

    public int getMaxPicoVerdecillo() {
        return maxPicoVerdecillo;
    }

    public void setMaxPicoVerdecillo(int maxPicoVerdecillo) {
        this.maxPicoVerdecillo = maxPicoVerdecillo;
    }

    public int getMinTarsoVerdecillo() {
        return minTarsoVerdecillo;
    }

    public void setMinTarsoVerdecillo(int minTarsoVerdecillo) {
        this.minTarsoVerdecillo = minTarsoVerdecillo;
    }

    public int getMaxTarsoVerdecillo() {
        return maxTarsoVerdecillo;
    }

    public void setMaxTarsoVerdecillo(int maxTarsoVerdecillo) {
        this.maxTarsoVerdecillo = maxTarsoVerdecillo;
    }

    public int getMinPesoVerdecillo() {
        return minPesoVerdecillo;
    }

    public void setMinPesoVerdecillo(int minPesoVerdecillo) {
        this.minPesoVerdecillo = minPesoVerdecillo;
    }

    public int getMaxPesoVerdecillo() {
        return maxPesoVerdecillo;
    }

    public void setMaxPesoVerdecillo(int maxPesoVerdecillo) {
        this.maxPesoVerdecillo = maxPesoVerdecillo;
    }

    public int getMaxRecVerdComun() {
        return maxRecVerdComun;
    }

    public void setMaxRecVerdComun(int maxRecVerdComun) {
        this.maxRecVerdComun = maxRecVerdComun;
    }

    public int getMaxCimVerdComun() {
        return maxCimVerdComun;
    }

    public void setMaxCimVerdComun(int maxCimVerdComun) {
        this.maxCimVerdComun = maxCimVerdComun;
    }

    public int getMinAlaVerdComun() {
        return minAlaVerdComun;
    }

    public void setMinAlaVerdComun(int minAlaVerdComun) {
        this.minAlaVerdComun = minAlaVerdComun;
    }

    public int getMaxAlaVerdComun() {
        return maxAlaVerdComun;
    }

    public void setMaxAlaVerdComun(int maxAlaVerdComun) {
        this.maxAlaVerdComun = maxAlaVerdComun;
    }

    public int getMinPicoVerdComun() {
        return minPicoVerdComun;
    }

    public void setMinPicoVerdComun(int minPicoVerdComun) {
        this.minPicoVerdComun = minPicoVerdComun;
    }

    public int getMaxPicoVerdComun() {
        return maxPicoVerdComun;
    }

    public void setMaxPicoVerdComun(int maxPicoVerdComun) {
        this.maxPicoVerdComun = maxPicoVerdComun;
    }

    public int getMinTarsoVerdComun() {
        return minTarsoVerdComun;
    }

    public void setMinTarsoVerdComun(int minTarsoVerdComun) {
        this.minTarsoVerdComun = minTarsoVerdComun;
    }

    public int getMaxTarsoVerdComun() {
        return maxTarsoVerdComun;
    }

    public void setMaxTarsoVerdComun(int maxTarsoVerdComun) {
        this.maxTarsoVerdComun = maxTarsoVerdComun;
    }

    public int getMinPesoVerdComun() {
        return minPesoVerdComun;
    }

    public void setMinPesoVerdComun(int minPesoVerdComun) {
        this.minPesoVerdComun = minPesoVerdComun;
    }

    public int getMaxPesoVerdComun() {
        return maxPesoVerdComun;
    }

    public void setMaxPesoVerdComun(int maxPesoVerdComun) {
        this.maxPesoVerdComun = maxPesoVerdComun;
    }

    public int getMaxRecVerdSerrano() {
        return maxRecVerdSerrano;
    }

    public void setMaxRecVerdSerrano(int maxRecVerdSerrano) {
        this.maxRecVerdSerrano = maxRecVerdSerrano;
    }

    public int getMaxCimVerdSerrano() {
        return maxCimVerdSerrano;
    }

    public void setMaxCimVerdSerrano(int maxCimVerdSerrano) {
        this.maxCimVerdSerrano = maxCimVerdSerrano;
    }

    public int getMinAlaVerdSerrano() {
        return minAlaVerdSerrano;
    }

    public void setMinAlaVerdSerrano(int minAlaVerdSerrano) {
        this.minAlaVerdSerrano = minAlaVerdSerrano;
    }

    public int getMaxAlaCVerdSerrano() {
        return maxAlaCVerdSerrano;
    }

    public void setMaxAlaCVerdSerrano(int maxAlaCVerdSerrano) {
        this.maxAlaCVerdSerrano = maxAlaCVerdSerrano;
    }

    public int getMinPicoVerdSerrano() {
        return minPicoVerdSerrano;
    }

    public void setMinPicoVerdSerrano(int minPicoVerdSerrano) {
        this.minPicoVerdSerrano = minPicoVerdSerrano;
    }

    public int getMaxPicoVerdSerrano() {
        return maxPicoVerdSerrano;
    }

    public void setMaxPicoVerdSerrano(int maxPicoVerdSerrano) {
        this.maxPicoVerdSerrano = maxPicoVerdSerrano;
    }

    public int getMinTarsoVerdSerrano() {
        return minTarsoVerdSerrano;
    }

    public void setMinTarsoVerdSerrano(int minTarsoVerdSerrano) {
        this.minTarsoVerdSerrano = minTarsoVerdSerrano;
    }

    public int getMaxTarsoVerdSerrano() {
        return maxTarsoVerdSerrano;
    }

    public void setMaxTarsoVerdSerrano(int maxTarsoVerdSerrano) {
        this.maxTarsoVerdSerrano = maxTarsoVerdSerrano;
    }

    public int getMinPesoVerdSerrano() {
        return minPesoVerdSerrano;
    }

    public void setMinPesoVerdSerrano(int minPesoVerdSerrano) {
        this.minPesoVerdSerrano = minPesoVerdSerrano;
    }

    public int getMaxPesoVerdSerrano() {
        return maxPesoVerdSerrano;
    }

    public void setMaxPesoVerdSerrano(int maxPesoVerdSerrano) {
        this.maxPesoVerdSerrano = maxPesoVerdSerrano;
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

    public void findGrupo(int numGrupo) {
        System.out.println("ANILLA MAX =>" + maxNAnilla);
        System.out.println("ANILLA MIN =>" + minNAnilla);

        ParseQuery<ParseObject> query= ParseQuery.getQuery("Limites_Anillamiento");
        query.whereEqualTo("NumGrupo",0);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null){
                    ParseObject obj = null;
                    for (int i = 0; i<objects.size(); i++){
                        obj = objects.get(i);
                    }
                    try {
                        minNAnilla = obj.getInt("NAnillaMin");
                        maxNAnilla = (Integer) obj.getNumber("NAnillaMax");
                    } catch (Exception x){
                        System.out.println("ERROR EN LA RECUPERACION DE DATOS");
                    }
                }
            }
        });
    }
}
