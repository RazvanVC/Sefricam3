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

    //Camachuelo
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

    public double getMinAlaCamachuelo() {
        return minAlaCamachuelo;
    }

    public void setMinAlaCamachuelo(int minAlaCamachuelo) {
        this.minAlaCamachuelo = minAlaCamachuelo;
    }

    public double getMaxAlaCamachuelo() {
        return maxAlaCamachuelo;
    }

    public void setMaxAlaCamachuelo(int maxAlaCamachuelo) {
        this.maxAlaCamachuelo = maxAlaCamachuelo;
    }

    public double getMinPicoCamachuelo() {
        return minPicoCamachuelo;
    }

    public void setMinPicoCamachuelo(int minPicoCamachuelo) {
        this.minPicoCamachuelo = minPicoCamachuelo;
    }

    public double getMaxPicoCamachuelo() {
        return maxPicoCamachuelo;
    }

    public void setMaxPicoCamachuelo(int maxPicoCamachuelo) {
        this.maxPicoCamachuelo = maxPicoCamachuelo;
    }

    public double getMinTarsoCamachuelo() {
        return minTarsoCamachuelo;
    }

    public void setMinTarsoCamachuelo(int minTarsoCamachuelo) {
        this.minTarsoCamachuelo = minTarsoCamachuelo;
    }

    public double getMaxTarsoCamachuelo() {
        return maxTarsoCamachuelo;
    }

    public void setMaxTarsoCamachuelo(int maxTarsoCamachuelo) {
        this.maxTarsoCamachuelo = maxTarsoCamachuelo;
    }

    public double getMinPesoCamachuelo() {
        return minPesoCamachuelo;
    }

    public void setMinPesoCamachuelo(int minPesoCamachuelo) {
        this.minPesoCamachuelo = minPesoCamachuelo;
    }

    public double getMaxPesoCamachuelo() {
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

    public double getMinAlaJilguero() {
        return minAlaJilguero;
    }

    public void setMinAlaJilguero(double minAlaJilguero) {
        this.minAlaJilguero = minAlaJilguero;
    }

    public double getMaxAlaJilguero() {
        return maxAlaJilguero;
    }

    public void setMaxAlaJilguero(double maxAlaJilguero) {
        this.maxAlaJilguero = maxAlaJilguero;
    }

    public double getMinPicoJilguero() {
        return minPicoJilguero;
    }

    public void setMinPicoJilguero(double minPicoJilguero) {
        this.minPicoJilguero = minPicoJilguero;
    }

    public double getMaxPicoJilguero() {
        return maxPicoJilguero;
    }

    public void setMaxPicoJilguero(double maxPicoJilguero) {
        this.maxPicoJilguero = maxPicoJilguero;
    }

    public double getMinTarsoJilguero() {
        return minTarsoJilguero;
    }

    public void setMinTarsoJilguero(double minTarsoJilguero) {
        this.minTarsoJilguero = minTarsoJilguero;
    }

    public double getMaxTarsoJilguero() {
        return maxTarsoJilguero;
    }

    public void setMaxTarsoJilguero(double maxTarsoJilguero) {
        this.maxTarsoJilguero = maxTarsoJilguero;
    }

    public double getMinPesoJilguero() {
        return minPesoJilguero;
    }

    public void setMinPesoJilguero(double minPesoJilguero) {
        this.minPesoJilguero = minPesoJilguero;
    }

    public double getMaxPesoJilguero() {
        return maxPesoJilguero;
    }

    public void setMaxPesoJilguero(double maxPesoJilguero) {
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

    public double getMinAlaLugano() {
        return minAlaLugano;
    }

    public void setMinAlaLugano(double minAlaLugano) {
        this.minAlaLugano = minAlaLugano;
    }

    public double getMaxAlaLugano() {
        return maxAlaLugano;
    }

    public void setMaxAlaLugano(double maxAlaLugano) {
        this.maxAlaLugano = maxAlaLugano;
    }

    public double getMinPicoLugano() {
        return minPicoLugano;
    }

    public void setMinPicoLugano(double minPicoLugano) {
        this.minPicoLugano = minPicoLugano;
    }

    public double getMaxPicoLugano() {
        return maxPicoLugano;
    }

    public void setMaxPicoLugano(double maxPicoLugano) {
        this.maxPicoLugano = maxPicoLugano;
    }

    public double getMinTarsoLugano() {
        return minTarsoLugano;
    }

    public void setMinTarsoLugano(double minTarsoLugano) {
        this.minTarsoLugano = minTarsoLugano;
    }

    public double getMaxTarsoLugano() {
        return maxTarsoLugano;
    }

    public void setMaxTarsoLugano(double maxTarsoLugano) {
        this.maxTarsoLugano = maxTarsoLugano;
    }

    public double getMinPesoLugano() {
        return minPesoLugano;
    }

    public void setMinPesoLugano(double minPesoLugano) {
        this.minPesoLugano = minPesoLugano;
    }

    public double getMaxPesoLugano() {
        return maxPesoLugano;
    }

    public void setMaxPesoLugano(double maxPesoLugano) {
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

    public double getMinAlaPardComun() {
        return minAlaPardComun;
    }

    public void setMinAlaPardComun(double minAlaPardComun) {
        this.minAlaPardComun = minAlaPardComun;
    }

    public double getMaxAlaPardComun() {
        return maxAlaPardComun;
    }

    public void setMaxAlaPardComun(double maxAlaPardComun) {
        this.maxAlaPardComun = maxAlaPardComun;
    }

    public double getMinPicoPardComun() {
        return minPicoPardComun;
    }

    public void setMinPicoPardComun(double minPicoPardComun) {
        this.minPicoPardComun = minPicoPardComun;
    }

    public double getMaxPicoPardComun() {
        return maxPicoPardComun;
    }

    public void setMaxPicoPardComun(double maxPicoPardComun) {
        this.maxPicoPardComun = maxPicoPardComun;
    }

    public double getMinTarsoPardComun() {
        return minTarsoPardComun;
    }

    public void setMinTarsoPardComun(double minTarsoPardComun) {
        this.minTarsoPardComun = minTarsoPardComun;
    }

    public double getMaxTarsoPardComun() {
        return maxTarsoPardComun;
    }

    public void setMaxTarsoPardComun(double maxTarsoPardComun) {
        this.maxTarsoPardComun = maxTarsoPardComun;
    }

    public double getMinPesoPardComun() {
        return minPesoPardComun;
    }

    public void setMinPesoPardComun(double minPesoPardComun) {
        this.minPesoPardComun = minPesoPardComun;
    }

    public double getMaxPesoPardComun() {
        return maxPesoPardComun;
    }

    public void setMaxPesoPardComun(double maxPesoPardComun) {
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

    public double getMinAlaPicogordo() {
        return minAlaPicogordo;
    }

    public void setMinAlaPicogordo(double minAlaPicogordo) {
        this.minAlaPicogordo = minAlaPicogordo;
    }

    public double getMaxAlaPicogordo() {
        return maxAlaPicogordo;
    }

    public void setMaxAlaPicogordo(double maxAlaPicogordo) {
        this.maxAlaPicogordo = maxAlaPicogordo;
    }

    public double getMinPicoPicogordo() {
        return minPicoPicogordo;
    }

    public void setMinPicoPicogordo(double minPicoPicogordo) {
        this.minPicoPicogordo = minPicoPicogordo;
    }

    public double getMaxPicoPicogordo() {
        return maxPicoPicogordo;
    }

    public void setMaxPicoPicogordo(double maxPicoPicogordo) {
        this.maxPicoPicogordo = maxPicoPicogordo;
    }

    public double getMinTarsoPicogordo() {
        return minTarsoPicogordo;
    }

    public void setMinTarsoPicogordo(double minTarsoPicogordo) {
        this.minTarsoPicogordo = minTarsoPicogordo;
    }

    public double getMaxTarsoPicogordo() {
        return maxTarsoPicogordo;
    }

    public void setMaxTarsoPicogordo(double maxTarsoPicogordo) {
        this.maxTarsoPicogordo = maxTarsoPicogordo;
    }

    public double getMinPesoPicogordo() {
        return minPesoPicogordo;
    }

    public void setMinPesoPicogordo(double minPesoPicogordo) {
        this.minPesoPicogordo = minPesoPicogordo;
    }

    public double getMaxPesoPicogordo() {
        return maxPesoPicogordo;
    }

    public void setMaxPesoPicogordo(double maxPesoPicogordo) {
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

    public double getMinAlaPinzComun() {
        return minAlaPinzComun;
    }

    public void setMinAlaPinzComun(double minAlaPinzComun) {
        this.minAlaPinzComun = minAlaPinzComun;
    }

    public double getMaxAlaPinzComun() {
        return maxAlaPinzComun;
    }

    public void setMaxAlaPinzComun(double maxAlaPinzComun) {
        this.maxAlaPinzComun = maxAlaPinzComun;
    }

    public double getMinPicoPinzComun() {
        return minPicoPinzComun;
    }

    public void setMinPicoPinzComun(double minPicoPinzComun) {
        this.minPicoPinzComun = minPicoPinzComun;
    }

    public double getMaxPicoPinzComun() {
        return maxPicoPinzComun;
    }

    public void setMaxPicoPinzComun(double maxPicoPinzComun) {
        this.maxPicoPinzComun = maxPicoPinzComun;
    }

    public double getMinTarsoPinzComun() {
        return minTarsoPinzComun;
    }

    public void setMinTarsoPinzComun(double minTarsoPinzComun) {
        this.minTarsoPinzComun = minTarsoPinzComun;
    }

    public double getMaxTarsoPinzComun() {
        return maxTarsoPinzComun;
    }

    public void setMaxTarsoPinzComun(double maxTarsoPinzComun) {
        this.maxTarsoPinzComun = maxTarsoPinzComun;
    }

    public double getMinPesoPinzComun() {
        return minPesoPinzComun;
    }

    public void setMinPesoPinzComun(double minPesoPinzComun) {
        this.minPesoPinzComun = minPesoPinzComun;
    }

    public double getMaxPesoPinzComun() {
        return maxPesoPinzComun;
    }

    public void setMaxPesoPinzComun(double maxPesoPinzComun) {
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

    public double getMinAlaPinzReal() {
        return minAlaPinzReal;
    }

    public void setMinAlaPinzReal(double minAlaPinzReal) {
        this.minAlaPinzReal = minAlaPinzReal;
    }

    public double getMaxAlaPinzReal() {
        return maxAlaPinzReal;
    }

    public void setMaxAlaPinzReal(double maxAlaPinzReal) {
        this.maxAlaPinzReal = maxAlaPinzReal;
    }

    public double getMinPicoPinzReal() {
        return minPicoPinzReal;
    }

    public void setMinPicoPinzReal(double minPicoPinzReal) {
        this.minPicoPinzReal = minPicoPinzReal;
    }

    public double getMaxPicoPinzReal() {
        return maxPicoPinzReal;
    }

    public void setMaxPicoPinzReal(double maxPicoPinzReal) {
        this.maxPicoPinzReal = maxPicoPinzReal;
    }

    public double getMinTarsoPinzReal() {
        return minTarsoPinzReal;
    }

    public void setMinTarsoPinzReal(double minTarsoPinzReal) {
        this.minTarsoPinzReal = minTarsoPinzReal;
    }

    public double getMaxTarsoPinzReal() {
        return maxTarsoPinzReal;
    }

    public void setMaxTarsoPinzReal(double maxTarsoPinzReal) {
        this.maxTarsoPinzReal = maxTarsoPinzReal;
    }

    public double getMinPesoPinzReal() {
        return minPesoPinzReal;
    }

    public void setMinPesoPinzReal(double minPesoPinzReal) {
        this.minPesoPinzReal = minPesoPinzReal;
    }

    public double getMaxPesoPinzReal() {
        return maxPesoPinzReal;
    }

    public void setMaxPesoPinzReal(double maxPesoPinzReal) {
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

    public double getMinAlaPiquituerto() {
        return minAlaPiquituerto;
    }

    public void setMinAlaPiquituerto(double minAlaPiquituerto) {
        this.minAlaPiquituerto = minAlaPiquituerto;
    }

    public double getMaxAlaPiquituerto() {
        return maxAlaPiquituerto;
    }

    public void setMaxAlaPiquituerto(double maxAlaPiquituerto) {
        this.maxAlaPiquituerto = maxAlaPiquituerto;
    }

    public double getMinPicoPiquituerto() {
        return minPicoPiquituerto;
    }

    public void setMinPicoPiquituerto(double minPicoPiquituerto) {
        this.minPicoPiquituerto = minPicoPiquituerto;
    }

    public double getMaxPicoPiquituerto() {
        return maxPicoPiquituerto;
    }

    public void setMaxPicoPiquituerto(double maxPicoPiquituerto) {
        this.maxPicoPiquituerto = maxPicoPiquituerto;
    }

    public double getMinTarsoPiquituerto() {
        return minTarsoPiquituerto;
    }

    public void setMinTarsoPiquituerto(double minTarsoPiquituerto) {
        this.minTarsoPiquituerto = minTarsoPiquituerto;
    }

    public double getMaxTarsoPiquituerto() {
        return maxTarsoPiquituerto;
    }

    public void setMaxTarsoPiquituerto(double maxTarsoPiquituerto) {
        this.maxTarsoPiquituerto = maxTarsoPiquituerto;
    }

    public double getMinPesoPiquituerto() {
        return minPesoPiquituerto;
    }

    public void setMinPesoPiquituerto(double minPesoPiquituerto) {
        this.minPesoPiquituerto = minPesoPiquituerto;
    }

    public double getMaxPesoPiquituerto() {
        return maxPesoPiquituerto;
    }

    public void setMaxPesoPiquituerto(double maxPesoPiquituerto) {
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

    public double getMinAlaVerdecillo() {
        return minAlaVerdecillo;
    }

    public void setMinAlaVerdecillo(double minAlaVerdecillo) {
        this.minAlaVerdecillo = minAlaVerdecillo;
    }

    public double getMaxAlaVerdecillo() {
        return maxAlaVerdecillo;
    }

    public void setMaxAlaVerdecillo(double maxAlaVerdecillo) {
        this.maxAlaVerdecillo = maxAlaVerdecillo;
    }

    public double getMinPicoVerdecillo() {
        return minPicoVerdecillo;
    }

    public void setMinPicoVerdecillo(double minPicoVerdecillo) {
        this.minPicoVerdecillo = minPicoVerdecillo;
    }

    public double getMaxPicoVerdecillo() {
        return maxPicoVerdecillo;
    }

    public void setMaxPicoVerdecillo(double maxPicoVerdecillo) {
        this.maxPicoVerdecillo = maxPicoVerdecillo;
    }

    public double getMinTarsoVerdecillo() {
        return minTarsoVerdecillo;
    }

    public void setMinTarsoVerdecillo(double minTarsoVerdecillo) {
        this.minTarsoVerdecillo = minTarsoVerdecillo;
    }

    public double getMaxTarsoVerdecillo() {
        return maxTarsoVerdecillo;
    }

    public void setMaxTarsoVerdecillo(double maxTarsoVerdecillo) {
        this.maxTarsoVerdecillo = maxTarsoVerdecillo;
    }

    public double getMinPesoVerdecillo() {
        return minPesoVerdecillo;
    }

    public void setMinPesoVerdecillo(double minPesoVerdecillo) {
        this.minPesoVerdecillo = minPesoVerdecillo;
    }

    public double getMaxPesoVerdecillo() {
        return maxPesoVerdecillo;
    }

    public void setMaxPesoVerdecillo(double maxPesoVerdecillo) {
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

    public double getMinAlaVerdComun() {
        return minAlaVerdComun;
    }

    public void setMinAlaVerdComun(double minAlaVerdComun) {
        this.minAlaVerdComun = minAlaVerdComun;
    }

    public double getMaxAlaVerdComun() {
        return maxAlaVerdComun;
    }

    public void setMaxAlaVerdComun(double maxAlaVerdComun) {
        this.maxAlaVerdComun = maxAlaVerdComun;
    }

    public double getMinPicoVerdComun() {
        return minPicoVerdComun;
    }

    public void setMinPicoVerdComun(double minPicoVerdComun) {
        this.minPicoVerdComun = minPicoVerdComun;
    }

    public double getMaxPicoVerdComun() {
        return maxPicoVerdComun;
    }

    public void setMaxPicoVerdComun(double maxPicoVerdComun) {
        this.maxPicoVerdComun = maxPicoVerdComun;
    }

    public double getMinTarsoVerdComun() {
        return minTarsoVerdComun;
    }

    public void setMinTarsoVerdComun(double minTarsoVerdComun) {
        this.minTarsoVerdComun = minTarsoVerdComun;
    }

    public double getMaxTarsoVerdComun() {
        return maxTarsoVerdComun;
    }

    public void setMaxTarsoVerdComun(double maxTarsoVerdComun) {
        this.maxTarsoVerdComun = maxTarsoVerdComun;
    }

    public double getMinPesoVerdComun() {
        return minPesoVerdComun;
    }

    public void setMinPesoVerdComun(double minPesoVerdComun) {
        this.minPesoVerdComun = minPesoVerdComun;
    }

    public double getMaxPesoVerdComun() {
        return maxPesoVerdComun;
    }

    public void setMaxPesoVerdComun(double maxPesoVerdComun) {
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

    public double getMinAlaVerdSerrano() {
        return minAlaVerdSerrano;
    }

    public void setMinAlaVerdSerrano(double minAlaVerdSerrano) {
        this.minAlaVerdSerrano = minAlaVerdSerrano;
    }

    public double getMaxAlaCVerdSerrano() {
        return maxAlaVerdSerrano;
    }

    public void setMaxAlaCVerdSerrano(double maxAlaCVerdSerrano) {
        this.maxAlVerdSerrano = maxAlaCVerdSerrano;
    }

    public double getMinPicoVerdSerrano() {
        return minPicoVerdSerrano;
    }

    public void setMinPicoVerdSerrano(double minPicoVerdSerrano) {
        this.minPicoVerdSerrano = minPicoVerdSerrano;
    }

    public double getMaxPicoVerdSerrano() {
        return maxPicoVerdSerrano;
    }

    public void setMaxPicoVerdSerrano(double maxPicoVerdSerrano) {
        this.maxPicoVerdSerrano = maxPicoVerdSerrano;
    }

    public double getMinTarsoVerdSerrano() {
        return minTarsoVerdSerrano;
    }

    public void setMinTarsoVerdSerrano(double minTarsoVerdSerrano) {
        this.minTarsoVerdSerrano = minTarsoVerdSerrano;
    }

    public double getMaxTarsoVerdSerrano() {
        return maxTarsoVerdSerrano;
    }

    public void setMaxTarsoVerdSerrano(double maxTarsoVerdSerrano) {
        this.maxTarsoVerdSerrano = maxTarsoVerdSerrano;
    }

    public double getMinPesoVerdSerrano() {
        return minPesoVerdSerrano;
    }

    public void setMinPesoVerdSerrano(double minPesoVerdSerrano) {
        this.minPesoVerdSerrano = minPesoVerdSerrano;
    }

    public double getMaxPesoVerdSerrano() {
        return maxPesoVerdSerrano;
    }

    public void setMaxPesoVerdSerrano(double maxPesoVerdSerrano) {
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
                        if (obj != null){
                            minNAnilla = obj.getInt("NAnillaMin");
                            maxNAnilla = obj.getInt("NAnillaMax");
                        }
                    } catch (Exception x){
                        System.out.println("ERROR EN LA RECUPERACION DE DATOS");
                    }
                }
            }
        });
    }
}
