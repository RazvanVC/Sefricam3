package com.sefricam.sefricam3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Pantalla_Datos_Entorno extends Activity implements View.OnClickListener {


    private Button btn_Guardar, btn_Volver;

    //Coponentes
    private EditText etnd_TemperaturaInicio, etnd_TemperaturaFin;
    private RadioGroup rbg_FuerzaViento, rbg_Nubes, rbg_Lluvia, rbg_Zonificacion, rbg_DireccionViento;
    private RadioButton rb_Zonficacion01, rb_Zonficacion02, rb_Zonficacion03, rb_Zonficacion04, rb_Zonficacion05,
            rb_Zonficacion06, rb_Zonficacion07, rb_Zonficacion08, rb_Zonficacion09, rb_Zonficacion10, rb_Zonficacion11;
    private RadioButton rb_DirVientoN , rb_DirVientoS, rb_DirVientoE, rb_DirVientoO, rb_DirVientoNE, rb_DirVientoNO, rb_DirVientoSE, rb_DirVientoSO;
    private RadioButton rb_VientoCalma, rb_VientoLigero, rb_VientoFuerte;
    private RadioButton rb_NubesAusente, rb_NubesNYC, rb_NubesCubierto, rb_NubesMCubierto;
    private RadioButton rb_LluviaAusente, rb_LluviaIntermitente, rb_LluviaLigera, rb_LluviaFuerte, rb_LluviaMFuerte;
    private RadioGroup rbg_Especie01, rbg_Especie02, rbg_Especie03, rbg_Especie04, rbg_Especie05;
    private RadioGroup rbg_Especie06, rbg_Especie07, rbg_Especie08, rbg_Especie09, rbg_Especie10;
    private RadioGroup rbg_Especie11, rbg_Especie12, rbg_Especie13, rbg_Especie14, rbg_Especie15;
    private RadioGroup rbg_Especie16, rbg_Especie17, rbg_Especie18, rbg_Especie19, rbg_Especie20;
    private RadioGroup rbg_Especie21, rbg_Especie22, rbg_Especie23, rbg_Especie24, rbg_Especie25;
    private RadioGroup rbg_Especie26, rbg_Especie27, rbg_Especie28, rbg_Especie29, rbg_Especie30;
    private RadioGroup rbg_Especie31, rbg_Especie32, rbg_Especie33, rbg_Especie34, rbg_Especie35, rbg_Especie36;

    private EditText et_Especie37, et_Especie38;

    /*
    private  String direccionViento;
    private int viento;
    private int nubes;
    private int lluvia;*/

    //Parametros
    private boolean envioCompletado;
    private MetodosCaptura metodosCaptura;
    private DatosAvistamiento datosAvistamiento;
    private DatosEntorno datosEntorno;
    private Limites limites;
    private boolean mCapturasCompletado,avistamientoCompletado,entornoCompletado;
    private String email;
    private String DNI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_datos_entorno);

        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            recuperarDatosRecibidos(datos);

            System.out.println("Datos recibidos en Datos de Entorno");
            imprimirDatos();
        }

        iniciarFindView();
        iniciarOnClickListeners();

        if (entornoCompletado){
            cargarDatos();
            System.out.println(datosEntorno.toString());
        }
    }

    private void cargarDatos() {

        etnd_TemperaturaInicio.setText(String.valueOf(datosEntorno.gettInicio()));
        etnd_TemperaturaFin.setText(String.valueOf(datosEntorno.gettFin()));

        switch (datosEntorno.getZonificacion()){
            case 1:
                rb_Zonficacion01.setChecked(true);
                break;
            case 2:
                rb_Zonficacion02.setChecked(true);
                break;
            case 3:
                rb_Zonficacion03.setChecked(true);
                break;
            case 4:
                rb_Zonficacion04.setChecked(true);
                break;
            case 5:
                rb_Zonficacion05.setChecked(true);
                break;
            case 6:
                rb_Zonficacion06.setChecked(true);
                break;
            case 7:
                rb_Zonficacion07.setChecked(true);
                break;
            case 8:
                rb_Zonficacion08.setChecked(true);
                break;
            case 9:
                rb_Zonficacion09.setChecked(true);
                break;
            case 10:
                rb_Zonficacion10.setChecked(true);
                break;
            case 11:
                rb_Zonficacion11.setChecked(true);
                break;
        }

        cargarDireccionViento();

        switch (datosEntorno.getViento()) {
            case 1:
                rb_VientoCalma.setChecked(true);
                break;
            case 2:
                rb_VientoLigero.setChecked(true);
                break;
            case 3:
                rb_VientoFuerte.setChecked(true);
                break;
        }
        switch (datosEntorno.getNubes()){
            case 1:
                rb_NubesAusente.setChecked(true);
                break;
            case 2:
                rb_NubesNYC.setChecked(true);
                break;
            case 3:
                rb_NubesCubierto.setChecked(true);
                break;
            case 4:
                rb_NubesMCubierto.setChecked(true);
                break;
        }
        switch (datosEntorno.getLluvia()){
            case 1:
                rb_LluviaAusente.setChecked(true);
                break;
            case 2:
                rb_LluviaIntermitente.setChecked(true);
                break;
            case 3:
                rb_LluviaLigera.setChecked(true);
                break;
            case 4:
                rb_LluviaFuerte.setChecked(true);
                break;
            case 5:
                rb_LluviaMFuerte.setChecked(true);
                break;
        }


        int i = 0;
        while (i < datosEntorno.getPlantas().size()) {
            int planta = datosEntorno.getPlantas().get(i);
            marcarPlanta(i, planta);
            i++;
        }

        et_Especie37.setText(datosEntorno.getEP37());
        et_Especie38.setText(datosEntorno.getEP38());
    }


    private void marcarPlanta(int numero, int planta) {
        switch (numero) {
            case 0:
                if (planta == 0) {
                    rbg_Especie01.check(R.id.rb_Especie01N);
                } else if (planta == 1) {
                    rbg_Especie01.check(R.id.rb_Especie01S);
                } else if (planta == 2) {
                    rbg_Especie01.check(R.id.rb_Especie01A);
                }
                break;
            case 1:
                if (planta == 0) {
                    rbg_Especie02.check(R.id.rb_Especie02N);
                } else if (planta == 1) {
                    rbg_Especie02.check(R.id.rb_Especie02S);
                } else if (planta == 2) {
                    rbg_Especie02.check(R.id.rb_Especie02A);
                }
                break;
            case 2:
                if (planta == 0) {
                    rbg_Especie03.check(R.id.rb_Especie03N);
                } else if (planta == 1) {
                    rbg_Especie03.check(R.id.rb_Especie03S);
                } else if (planta == 2) {
                    rbg_Especie03.check(R.id.rb_Especie03A);
                }
                break;
            case 3:
                if (planta == 0) {
                    rbg_Especie04.check(R.id.rb_Especie04N);
                } else if (planta == 1) {
                    rbg_Especie04.check(R.id.rb_Especie04S);
                } else if (planta == 2) {
                    rbg_Especie04.check(R.id.rb_Especie04A);
                }
                break;
            case 4:
                if (planta == 0) {
                    rbg_Especie05.check(R.id.rb_Especie05N);
                } else if (planta == 1) {
                    rbg_Especie05.check(R.id.rb_Especie05S);
                } else if (planta == 2) {
                    rbg_Especie05.check(R.id.rb_Especie05A);
                }
                break;
            case 5:
                if (planta == 0) {
                    rbg_Especie06.check(R.id.rb_Especie06N);
                } else if (planta == 1) {
                    rbg_Especie06.check(R.id.rb_Especie06S);
                } else if (planta == 2) {
                    rbg_Especie06.check(R.id.rb_Especie06A);
                }
                break;
            case 6:
                if (planta == 0) {
                    rbg_Especie07.check(R.id.rb_Especie07N);
                } else if (planta == 1) {
                    rbg_Especie07.check(R.id.rb_Especie07S);
                } else if (planta == 2) {
                    rbg_Especie07.check(R.id.rb_Especie07A);
                }
                break;
            case 7:
                if (planta == 0) {
                    rbg_Especie08.check(R.id.rb_Especie08N);
                } else if (planta == 1) {
                    rbg_Especie08.check(R.id.rb_Especie08S);
                } else if (planta == 2) {
                    rbg_Especie08.check(R.id.rb_Especie08A);
                }
                break;
            case 8:
                if (planta == 0) {
                    rbg_Especie09.check(R.id.rb_Especie09N);
                } else if (planta == 1) {
                    rbg_Especie09.check(R.id.rb_Especie09S);
                } else if (planta == 2) {
                    rbg_Especie09.check(R.id.rb_Especie09A);
                }
                break;
            case 9:
                if (planta == 0) {
                    rbg_Especie10.check(R.id.rb_Especie10N);
                } else if (planta == 1) {
                    rbg_Especie10.check(R.id.rb_Especie10S);
                } else if (planta == 2) {
                    rbg_Especie10.check(R.id.rb_Especie10A);
                }
                break;
            case 10:
                if (planta == 0) {
                    rbg_Especie11.check(R.id.rb_Especie11N);
                } else if (planta == 1) {
                    rbg_Especie11.check(R.id.rb_Especie11S);
                } else if (planta == 2) {
                    rbg_Especie11.check(R.id.rb_Especie11A);
                }
                break;
            case 11:
                if (planta == 0) {
                    rbg_Especie12.check(R.id.rb_Especie12N);
                } else if (planta == 1) {
                    rbg_Especie12.check(R.id.rb_Especie12S);
                } else if (planta == 2) {
                    rbg_Especie12.check(R.id.rb_Especie12A);
                }
                break;
            case 12:
                if (planta == 0) {
                    rbg_Especie13.check(R.id.rb_Especie13N);
                } else if (planta == 1) {
                    rbg_Especie13.check(R.id.rb_Especie13S);
                } else if (planta == 2) {
                    rbg_Especie13.check(R.id.rb_Especie13A);
                }
                break;
            case 13:
                if (planta == 0) {
                    rbg_Especie14.check(R.id.rb_Especie14N);
                } else if (planta == 1) {
                    rbg_Especie14.check(R.id.rb_Especie14S);
                } else if (planta == 2) {
                    rbg_Especie14.check(R.id.rb_Especie14A);
                }
                break;
            case 14:
                if (planta == 0) {
                    rbg_Especie15.check(R.id.rb_Especie15N);
                } else if (planta == 1) {
                    rbg_Especie15.check(R.id.rb_Especie15S);
                } else if (planta == 2) {
                    rbg_Especie15.check(R.id.rb_Especie15A);
                }
                break;
            case 15:
                if (planta == 0) {
                    rbg_Especie16.check(R.id.rb_Especie16N);
                } else if (planta == 1) {
                    rbg_Especie16.check(R.id.rb_Especie16S);
                } else if (planta == 2) {
                    rbg_Especie16.check(R.id.rb_Especie16A);
                }
                break;
            case 16:
                if (planta == 0) {
                    rbg_Especie17.check(R.id.rb_Especie17N);
                } else if (planta == 1) {
                    rbg_Especie17.check(R.id.rb_Especie17S);
                } else if (planta == 2) {
                    rbg_Especie17.check(R.id.rb_Especie17A);
                }
                break;
            case 17:
                if (planta == 0) {
                    rbg_Especie18.check(R.id.rb_Especie18N);
                } else if (planta == 1) {
                    rbg_Especie18.check(R.id.rb_Especie18S);
                } else if (planta == 2) {
                    rbg_Especie18.check(R.id.rb_Especie18A);
                }
                break;
            case 18:
                if (planta == 0) {
                    rbg_Especie19.check(R.id.rb_Especie19N);
                } else if (planta == 1) {
                    rbg_Especie19.check(R.id.rb_Especie19S);
                } else if (planta == 2) {
                    rbg_Especie19.check(R.id.rb_Especie19A);
                }
                break;
            case 19:
                if (planta == 0) {
                    rbg_Especie20.check(R.id.rb_Especie20N);
                } else if (planta == 1) {
                    rbg_Especie20.check(R.id.rb_Especie20S);
                } else if (planta == 2) {
                    rbg_Especie20.check(R.id.rb_Especie20A);
                }
                break;
            case 20:
                if (planta == 0) {
                    rbg_Especie21.check(R.id.rb_Especie21N);
                } else if (planta == 1) {
                    rbg_Especie21.check(R.id.rb_Especie21S);
                } else if (planta == 2) {
                    rbg_Especie21.check(R.id.rb_Especie21A);
                }
                break;
            case 21:
                if (planta == 0) {
                    rbg_Especie22.check(R.id.rb_Especie22N);
                } else if (planta == 1) {
                    rbg_Especie22.check(R.id.rb_Especie22S);
                } else if (planta == 2) {
                    rbg_Especie22.check(R.id.rb_Especie22A);
                }
                break;
            case 22:
                if (planta == 0) {
                    rbg_Especie23.check(R.id.rb_Especie23N);
                } else if (planta == 1) {
                    rbg_Especie23.check(R.id.rb_Especie23S);
                } else if (planta == 2) {
                    rbg_Especie23.check(R.id.rb_Especie23A);
                }
                break;
            case 23:
                if (planta == 0) {
                    rbg_Especie24.check(R.id.rb_Especie24N);
                } else if (planta == 1) {
                    rbg_Especie24.check(R.id.rb_Especie24S);
                } else if (planta == 2) {
                    rbg_Especie24.check(R.id.rb_Especie24A);
                }
                break;
            case 24:
                if (planta == 0) {
                    rbg_Especie25.check(R.id.rb_Especie25N);
                } else if (planta == 1) {
                    rbg_Especie25.check(R.id.rb_Especie25S);
                } else if (planta == 2) {
                    rbg_Especie25.check(R.id.rb_Especie25A);
                }
                break;
            case 25:
                if (planta == 0) {
                    rbg_Especie26.check(R.id.rb_Especie26N);
                } else if (planta == 1) {
                    rbg_Especie26.check(R.id.rb_Especie26S);
                } else if (planta == 2) {
                    rbg_Especie26.check(R.id.rb_Especie26A);
                }
                break;
            case 26:
                if (planta == 0) {
                    rbg_Especie27.check(R.id.rb_Especie27N);
                } else if (planta == 1) {
                    rbg_Especie27.check(R.id.rb_Especie27S);
                } else if (planta == 2) {
                    rbg_Especie27.check(R.id.rb_Especie27A);
                }
                break;
            case 27:
                if (planta == 0) {
                    rbg_Especie28.check(R.id.rb_Especie28N);
                } else if (planta == 1) {
                    rbg_Especie28.check(R.id.rb_Especie28S);
                } else if (planta == 2) {
                    rbg_Especie28.check(R.id.rb_Especie28A);
                }
                break;
            case 28:
                if (planta == 0) {
                    rbg_Especie29.check(R.id.rb_Especie29N);
                } else if (planta == 1) {
                    rbg_Especie29.check(R.id.rb_Especie29S);
                } else if (planta == 2) {
                    rbg_Especie29.check(R.id.rb_Especie29A);
                }
                break;
            case 29:
                if (planta == 0) {
                    rbg_Especie30.check(R.id.rb_Especie30N);
                } else if (planta == 1) {
                    rbg_Especie30.check(R.id.rb_Especie30S);
                } else if (planta == 2) {
                    rbg_Especie30.check(R.id.rb_Especie30A);
                }
                break;
            case 30:
                if (planta == 0) {
                    rbg_Especie31.check(R.id.rb_Especie31N);
                } else if (planta == 1) {
                    rbg_Especie31.check(R.id.rb_Especie31S);
                } else if (planta == 2) {
                    rbg_Especie31.check(R.id.rb_Especie31A);
                }
                break;
            case 31:
                if (planta == 0) {
                    rbg_Especie32.check(R.id.rb_Especie32N);
                } else if (planta == 1) {
                    rbg_Especie32.check(R.id.rb_Especie32S);
                } else if (planta == 2) {
                    rbg_Especie32.check(R.id.rb_Especie32A);
                }
                break;
            case 32:
                if (planta == 0) {
                    rbg_Especie33.check(R.id.rb_Especie33N);
                } else if (planta == 1) {
                    rbg_Especie33.check(R.id.rb_Especie33S);
                } else if (planta == 2) {
                    rbg_Especie33.check(R.id.rb_Especie33A);
                }
                break;
            case 33:
                if (planta == 0) {
                    rbg_Especie34.check(R.id.rb_Especie34N);
                } else if (planta == 1) {
                    rbg_Especie34.check(R.id.rb_Especie34S);
                } else if (planta == 2) {
                    rbg_Especie34.check(R.id.rb_Especie34A);
                }
                break;
            case 34:
                if (planta == 0) {
                    rbg_Especie35.check(R.id.rb_Especie35N);
                } else if (planta == 1) {
                    rbg_Especie35.check(R.id.rb_Especie35S);
                } else if (planta == 2) {
                    rbg_Especie35.check(R.id.rb_Especie35A);
                }
                break;
            case 35:
                if (planta == 0) {
                    rbg_Especie36.check(R.id.rb_Especie36N);
                } else if (planta == 1) {
                    rbg_Especie36.check(R.id.rb_Especie36S);
                } else if (planta == 2) {
                    rbg_Especie36.check(R.id.rb_Especie36A);
                }
                break;
        }
    }

    private void iniciarOnClickListeners() {
        btn_Volver.setOnClickListener(this);
        btn_Guardar.setOnClickListener(this);
    }

    private void iniciarFindView() {
        //Temperaturas INICIO y FIN
        etnd_TemperaturaInicio = findViewById(R.id.etnd_TemperaturaInicio);
        etnd_TemperaturaFin = findViewById(R.id.etnd_TemperaturaFin);

        //Radio Button Grupo Zonificacion
        rbg_Zonificacion = findViewById(R.id.rbg_Zonificacion);
        rb_Zonficacion01 = findViewById(R.id.rb_Zonificacion01);
        rb_Zonficacion02 = findViewById(R.id.rb_Zonificacion02);
        rb_Zonficacion03 = findViewById(R.id.rb_Zonificacion03);
        rb_Zonficacion04 = findViewById(R.id.rb_Zonificacion04);
        rb_Zonficacion05 = findViewById(R.id.rb_Zonificacion05);
        rb_Zonficacion06 = findViewById(R.id.rb_Zonificacion06);
        rb_Zonficacion07 = findViewById(R.id.rb_Zonificacion07);
        rb_Zonficacion08 = findViewById(R.id.rb_Zonificacion08);
        rb_Zonficacion09 = findViewById(R.id.rb_Zonificacion09);
        rb_Zonficacion10 = findViewById(R.id.rb_Zonificacion10);
        rb_Zonficacion11 = findViewById(R.id.rb_Zonificacion11);

        //Radio Button Group Viento
        rbg_FuerzaViento = findViewById(R.id.rbg_FuerzaViento);
        rb_VientoCalma = findViewById(R.id.rb_VientoCalma);
        rb_VientoLigero = findViewById(R.id.rb_VientoLigero);
        rb_VientoFuerte = findViewById(R.id.rb_VientoFuerte);

        //Radio Button Group Direccion Viento
        rbg_DireccionViento = findViewById(R.id.rbg_DireccionViento);
        rb_DirVientoN = findViewById(R.id.rb_DirN);
        rb_DirVientoS = findViewById(R.id.rb_DirS);
        rb_DirVientoE = findViewById(R.id.rb_DirE);
        rb_DirVientoE = findViewById(R.id.rb_DirO);
        rb_DirVientoNE = findViewById(R.id.rb_DirNE);
        rb_DirVientoNE = findViewById(R.id.rb_DirNO);
        rb_DirVientoSE = findViewById(R.id.rb_DirSE);
        rb_DirVientoSE = findViewById(R.id.rb_DirSO);


        //Radio Button Group Nubes
        rbg_Nubes = findViewById(R.id.rbg_Nubes);
        rb_NubesAusente = findViewById(R.id.rb_NubesAusente);
        rb_NubesNYC = findViewById(R.id.rb_NubesNYC);
        rb_NubesCubierto = findViewById(R.id.rb_NubesCubierto);
        rb_NubesMCubierto = findViewById(R.id.rb_NubesMCubierto);

        //Radio Button Group Lluvia
        rbg_Lluvia = findViewById(R.id.rbg_Lluvia);
        rb_LluviaAusente = findViewById(R.id.rb_LluviaAusente);
        rb_LluviaIntermitente = findViewById(R.id.rb_LluviaIntermitente);
        rb_LluviaLigera = findViewById(R.id.rb_LluviaLigera);
        rb_LluviaFuerte = findViewById(R.id.rb_LluviaFuerte);
        rb_LluviaMFuerte = findViewById(R.id.rb_LluviaMFuerte);

        //Radio Button Group Especie Plantas
        rbg_Especie01 = findViewById(R.id.rbg_Especie01);
        rbg_Especie02 = findViewById(R.id.rbg_Especie02);
        rbg_Especie03 = findViewById(R.id.rbg_Especie03);
        rbg_Especie04 = findViewById(R.id.rbg_Especie04);
        rbg_Especie05 = findViewById(R.id.rbg_Especie05);
        rbg_Especie06 = findViewById(R.id.rbg_Especie06);
        rbg_Especie07 = findViewById(R.id.rbg_Especie07);
        rbg_Especie08 = findViewById(R.id.rbg_Especie08);
        rbg_Especie09 = findViewById(R.id.rbg_Especie09);
        rbg_Especie10 = findViewById(R.id.rbg_Especie10);
        rbg_Especie11 = findViewById(R.id.rbg_Especie11);
        rbg_Especie12 = findViewById(R.id.rbg_Especie12);
        rbg_Especie13 = findViewById(R.id.rbg_Especie13);
        rbg_Especie14 = findViewById(R.id.rbg_Especie14);
        rbg_Especie15 = findViewById(R.id.rbg_Especie15);
        rbg_Especie16 = findViewById(R.id.rbg_Especie16);
        rbg_Especie17 = findViewById(R.id.rbg_Especie17);
        rbg_Especie18 = findViewById(R.id.rbg_Especie18);
        rbg_Especie19 = findViewById(R.id.rbg_Especie19);
        rbg_Especie20 = findViewById(R.id.rbg_Especie20);
        rbg_Especie21 = findViewById(R.id.rbg_Especie21);
        rbg_Especie22 = findViewById(R.id.rbg_Especie22);
        rbg_Especie23 = findViewById(R.id.rbg_Especie23);
        rbg_Especie24 = findViewById(R.id.rbg_Especie24);
        rbg_Especie25 = findViewById(R.id.rbg_Especie25);
        rbg_Especie26 = findViewById(R.id.rbg_Especie26);
        rbg_Especie27 = findViewById(R.id.rbg_Especie27);
        rbg_Especie28 = findViewById(R.id.rbg_Especie28);
        rbg_Especie29 = findViewById(R.id.rbg_Especie29);
        rbg_Especie30 = findViewById(R.id.rbg_Especie30);
        rbg_Especie31 = findViewById(R.id.rbg_Especie31);
        rbg_Especie32 = findViewById(R.id.rbg_Especie32);
        rbg_Especie33 = findViewById(R.id.rbg_Especie33);
        rbg_Especie34 = findViewById(R.id.rbg_Especie34);
        rbg_Especie35 = findViewById(R.id.rbg_Especie35);
        rbg_Especie36 = findViewById(R.id.rbg_Especie36);

        et_Especie37 = findViewById(R.id.et_Especie37);
        et_Especie38 = findViewById(R.id.et_Especie38);

        //Botones
        btn_Guardar = findViewById(R.id.btn_GuardarEntorno);
        btn_Volver = findViewById(R.id.btn_VolverEntorno);


    }

    @Override
    public void onClick(View v) {
        if (v == btn_Guardar){
            if (comprobarCampos()){
                asignacionValores();
                entornoCompletado = true;
                Intent activity = new Intent(this, Pantalla_Menu_Metodos_Y_Captura.class);
                guardarParametros(activity);

                startActivity(activity);
                finish();
            } else {
                Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_LONG).show();
            }
        }
        if (v == btn_Volver){
            Intent activity = new Intent(this, Pantalla_Menu_Metodos_Y_Captura.class);
            guardarParametros(activity);

            startActivity(activity);
            finish();
        }
    }

    private boolean comprobarCampos() {
        double temperaturaMinima = limites.getMinTemp();
        double temperaturaMaxima = limites.getMaxTemp();
        if (rbg_Zonificacion.getCheckedRadioButtonId()==-1) return false;
        if (rbg_FuerzaViento.getCheckedRadioButtonId()==-1) return false;
        if (rbg_DireccionViento.getCheckedRadioButtonId()==-1) return false;
        if (rbg_Nubes.getCheckedRadioButtonId()==-1) return false;
        if (rbg_Lluvia.getCheckedRadioButtonId()==-1) return false;
        try {
            Double.valueOf(etnd_TemperaturaInicio.getText().toString());
            Double.valueOf(etnd_TemperaturaFin.getText().toString());
        }catch (Exception e){
            Toast.makeText(this, "La temperatura ha de ser un valor numérico", Toast.LENGTH_LONG).show();
            return false;
        }
        if (Double.parseDouble(etnd_TemperaturaFin.getText().toString()) < temperaturaMinima || Double.parseDouble(etnd_TemperaturaInicio.getText().toString()) < temperaturaMinima) {
            Toast.makeText(this, "La temperatura ha de ser superior a " + temperaturaMinima, Toast.LENGTH_LONG).show();
            return false;
        }
        if (Double.parseDouble(etnd_TemperaturaFin.getText().toString()) > temperaturaMaxima || Double.parseDouble(etnd_TemperaturaInicio.getText().toString()) > temperaturaMaxima) {
            Toast.makeText(this, "La temperatura ha de ser inferior a " + temperaturaMaxima, Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    @SuppressLint("NonConstantResourceId")
    private void asignacionValores() {
        //Declaracion
        int zonificacion = 0;
        int viento = 0;
        String direccionViento = "N";
        int nubes = 0;
        int lluvia = 0;

        //Datos
        double tInicio = Double.parseDouble(etnd_TemperaturaInicio.getText().toString());
        double tFin = Double.parseDouble(etnd_TemperaturaFin.getText().toString());

        //Cambiar pot RB
        switch (rbg_Zonificacion.getCheckedRadioButtonId()){
            case R.id.rb_Zonificacion01:
                zonificacion = 1;
                break;
            case R.id.rb_Zonificacion02:
                zonificacion = 2;
                break;
            case R.id.rb_Zonificacion03:
                zonificacion = 3;
                break;
            case R.id.rb_Zonificacion04:
                zonificacion = 4;
                break;
            case R.id.rb_Zonificacion05:
                zonificacion = 5;
                break;
            case R.id.rb_Zonificacion06:
                zonificacion = 6;
                break;
            case R.id.rb_Zonificacion07:
                zonificacion = 7;
                break;
            case R.id.rb_Zonificacion08:
                zonificacion = 8;
                break;
            case R.id.rb_Zonificacion09:
                zonificacion = 9;
                break;
            case R.id.rb_Zonificacion10:
                zonificacion = 10;
                break;
            case R.id.rb_Zonificacion11:
                zonificacion = 11;
                break;
        }

        switch (rbg_FuerzaViento.getCheckedRadioButtonId()) {
            case R.id.rb_VientoCalma:
                viento = 1;
                break;
            case R.id.rb_VientoLigero:
                viento = 2;
                break;
            case R.id.rb_VientoFuerte:
                viento=3;
                break;
        }
        
        switch (rbg_DireccionViento.getCheckedRadioButtonId()){
            case R.id.rb_DirN:
                direccionViento = "N";
                break;
            case R.id.rb_DirS:
                direccionViento = "S";
                break;
            case R.id.rb_DirE:
                direccionViento = "E";
                break;
            case R.id.rb_DirO:
                direccionViento = "O";
                break;
            case R.id.rb_DirNE:
                direccionViento = "NE";
                break;
            case R.id.rb_DirNO:
                direccionViento = "NO";
                break;
            case R.id.rb_DirSE:
                direccionViento = "SE";
                break;
            case R.id.rb_DirSO:
                direccionViento = "SO";
                break;
        }

        switch (rbg_Nubes.getCheckedRadioButtonId()){
            case R.id.rb_NubesAusente:
                nubes=1;
                break;
            case R.id.rb_NubesNYC:
                nubes=2;
                break;
            case R.id.rb_NubesCubierto:
                nubes=3;
                break;
            case R.id.rb_NubesMCubierto:
                nubes=4;
                break;
        }

        switch (rbg_Lluvia.getCheckedRadioButtonId()){
            case R.id.rb_LluviaAusente:
                lluvia=1;
                break;
            case R.id.rb_LluviaIntermitente:
                lluvia=2;
                break;
            case R.id.rb_LluviaLigera:
                lluvia = 3;
                break;
            case R.id.rb_LluviaFuerte:
                lluvia = 4;
                break;
            case R.id.rb_LluviaMFuerte:
                lluvia = 5;
                break;
        }

        ArrayList<Integer> plantas = escogerPlantas();

        String ep37, ep38;
        if (et_Especie37.getText().toString().equals("")) ep37 = "-";
        else ep37 = et_Especie37.getText().toString();

        if (et_Especie38.getText().toString().equals("")) ep38 = "-";
        else ep38 = et_Especie38.getText().toString();

        datosEntorno = new DatosEntorno(tInicio, tFin, zonificacion, viento, direccionViento, nubes, lluvia, plantas, ep37, ep38);

    }

    @SuppressLint("NonConstantResourceId")
    private ArrayList<Integer> escogerPlantas() {
        ArrayList<Integer> plantasSeleccionadas = new ArrayList<>();
        switch (rbg_Especie01.getCheckedRadioButtonId()) {
            case R.id.rb_Especie01N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie01S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie01A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie02.getCheckedRadioButtonId()) {
            case R.id.rb_Especie02N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie02S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie02A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie03.getCheckedRadioButtonId()) {
            case R.id.rb_Especie03N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie03S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie03A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie04.getCheckedRadioButtonId()) {
            case R.id.rb_Especie04N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie04S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie04A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie05.getCheckedRadioButtonId()) {
            case R.id.rb_Especie05N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie05S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie05A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie06.getCheckedRadioButtonId()) {
            case R.id.rb_Especie06N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie06S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie06A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie07.getCheckedRadioButtonId()) {
            case R.id.rb_Especie07N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie07S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie07A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie08.getCheckedRadioButtonId()) {
            case R.id.rb_Especie08N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie08S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie08A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie09.getCheckedRadioButtonId()) {
            case R.id.rb_Especie09N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie09S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie09A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie10.getCheckedRadioButtonId()) {
            case R.id.rb_Especie10N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie10S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie10A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie11.getCheckedRadioButtonId()) {
            case R.id.rb_Especie11N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie11S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie11A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie12.getCheckedRadioButtonId()) {
            case R.id.rb_Especie12N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie12S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie12A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie13.getCheckedRadioButtonId()) {
            case R.id.rb_Especie13N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie13S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie13A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie14.getCheckedRadioButtonId()) {
            case R.id.rb_Especie14N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie14S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie14A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie15.getCheckedRadioButtonId()) {
            case R.id.rb_Especie15N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie15S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie15A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie16.getCheckedRadioButtonId()) {
            case R.id.rb_Especie16N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie16S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie16A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie17.getCheckedRadioButtonId()) {
            case R.id.rb_Especie17N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie17S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie17A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie18.getCheckedRadioButtonId()) {
            case R.id.rb_Especie18N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie18S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie18A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie19.getCheckedRadioButtonId()) {
            case R.id.rb_Especie19N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie19S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie19A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie20.getCheckedRadioButtonId()) {
            case R.id.rb_Especie20N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie20S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie20A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie21.getCheckedRadioButtonId()) {
            case R.id.rb_Especie21N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie21S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie21A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie22.getCheckedRadioButtonId()) {
            case R.id.rb_Especie22N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie22S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie22A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie23.getCheckedRadioButtonId()) {
            case R.id.rb_Especie23N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie23S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie23A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie24.getCheckedRadioButtonId()) {
            case R.id.rb_Especie24N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie24S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie24A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie25.getCheckedRadioButtonId()) {
            case R.id.rb_Especie25N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie25S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie25A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie26.getCheckedRadioButtonId()) {
            case R.id.rb_Especie26N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie26S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie26A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie27.getCheckedRadioButtonId()) {
            case R.id.rb_Especie27N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie27S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie27A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie28.getCheckedRadioButtonId()) {
            case R.id.rb_Especie28N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie28S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie28A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie29.getCheckedRadioButtonId()) {
            case R.id.rb_Especie29N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie29S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie29A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie30.getCheckedRadioButtonId()) {
            case R.id.rb_Especie30N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie30S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie30A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie31.getCheckedRadioButtonId()) {
            case R.id.rb_Especie31N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie31S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie31A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie32.getCheckedRadioButtonId()) {
            case R.id.rb_Especie32N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie32S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie32A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie33.getCheckedRadioButtonId()) {
            case R.id.rb_Especie33N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie33S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie33A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie34.getCheckedRadioButtonId()) {
            case R.id.rb_Especie34N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie34S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie34A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie35.getCheckedRadioButtonId()) {
            case R.id.rb_Especie35N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie35S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie35A:
                plantasSeleccionadas.add(2);
                break;
        }
        switch (rbg_Especie36.getCheckedRadioButtonId()) {
            case R.id.rb_Especie36N:
                plantasSeleccionadas.add(0);
                break;
            case R.id.rb_Especie36S:
                plantasSeleccionadas.add(1);
                break;
            case R.id.rb_Especie36A:
                plantasSeleccionadas.add(2);
                break;
        }

        return plantasSeleccionadas;
    }

    private void guardarParametros(Intent actividadDestino) {

        imprimirDatos();

        actividadDestino.putExtra("EMAIL", email);
        actividadDestino.putExtra("DNI", DNI);
        actividadDestino.putExtra("ENVIO_COMPLETADO",envioCompletado);
        actividadDestino.putExtra("DATOS_AVISTAMIENTO", datosAvistamiento);
        actividadDestino.putExtra("DATOS_ENTORNO", datosEntorno);
        actividadDestino.putExtra("DATOS_CAPTURA", metodosCaptura);
        actividadDestino.putExtra("ENTORNO_COMPLETADO", entornoCompletado);
        actividadDestino.putExtra("MCAPTURAS_COMPLETADO", mCapturasCompletado);
        actividadDestino.putExtra("AVISTAMIENTO_COMPLETADO", avistamientoCompletado);

    }

    private void recuperarDatosRecibidos(Bundle datos) {
        email = datos.getString("EMAIL");
        DNI = datos.getString("DNI");
        envioCompletado = datos.getBoolean("ENVIO_COMPLETADO");
        mCapturasCompletado = datos.getBoolean("MCAPTURAS_COMPLETADO");
        avistamientoCompletado = datos.getBoolean("AVISTAMIENTO_COMPLETADO");
        entornoCompletado = datos.getBoolean("ENTORNO_COMPLETADO");
        metodosCaptura = (MetodosCaptura) datos.getSerializable("DATOS_CAPTURA");
        datosAvistamiento = (DatosAvistamiento) datos.getSerializable("DATOS_AVISTAMIENTO");
        datosEntorno = (DatosEntorno) datos.getSerializable("DATOS_ENTORNO");
        limites = (Limites) datos.getSerializable("LIMITES");
    }

    private void imprimirDatos() {
        System.out.println("____________________________________________________");
        System.out.println("EMAIL                  => " + email);
        System.out.println("DNI                    => " + DNI);
        System.out.println("LIMITES                => " + limites);
        System.out.println("____________________________________________________");
        System.out.println("ESTADO ENTORNO         => " + entornoCompletado);
        System.out.println("DATOS ENTORNO          => " + datosEntorno);
        System.out.println("ESTADO METODOS CAPTURA => " + mCapturasCompletado);
        System.out.println("METODOS CAPTURA        => " + metodosCaptura);
        System.out.println("ESTADO AVISTAMIENTO    => " + avistamientoCompletado);
        System.out.println("DATOS AVISTAMIENTO     => " + datosAvistamiento);
        System.out.println("____________________________________________________");
    }

    /**
     * Carga los datos de direccion de viento en el Spinner
     */
    private void cargarDireccionViento() {
        switch (datosEntorno.getDireccionViento()) {
            case "N":
                rb_DirVientoN.setChecked(true);
                break;
            case "S":
                rb_DirVientoS.setChecked(true);
                break;
            case "E":
                rb_DirVientoE.setChecked(true);
                break;
            case "O":
                rb_DirVientoO.setChecked(true);
                break;
            case "NE":
                rb_DirVientoNE.setChecked(true);
                break;
            case "NO":
                rb_DirVientoNO.setChecked(true);
                break;
            case "SE":
                rb_DirVientoSE.setChecked(true);
                break;
            case "SO":
                rb_DirVientoSO.setChecked(true);
                break;
        }
    }
}
