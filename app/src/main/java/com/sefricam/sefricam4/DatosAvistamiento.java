package com.sefricam.sefricam4;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Getter;

/**
 * This is a Object Class in order to make data more readable at debug. Contains all the data related
 * to the DatosAvistamiento that we store in the Parse DB
 */
@Getter
public class DatosAvistamiento implements Serializable {

    private final String horaInicio;
    private final String horaFin;

    private final ArrayList<Integer> hora08;
    private final ArrayList<Integer> hora09;
    private final ArrayList<Integer> hora10;
    private final ArrayList<Integer> hora11;
    private final ArrayList<Integer> hora12;
    private final ArrayList<Integer> hora13;
    private final ArrayList<Integer> hora14;

    public DatosAvistamiento(String horaInicio, String horaFin, ArrayList<Integer> hora08, ArrayList<Integer> hora09, ArrayList<Integer> hora10, ArrayList<Integer> hora11, ArrayList<Integer> hora12, ArrayList<Integer> hora13, ArrayList<Integer> hora14) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.hora08 = hora08;
        this.hora09 = hora09;
        this.hora10 = hora10;
        this.hora11 = hora11;
        this.hora12 = hora12;
        this.hora13 = hora13;
        this.hora14 = hora14;
    }

}
