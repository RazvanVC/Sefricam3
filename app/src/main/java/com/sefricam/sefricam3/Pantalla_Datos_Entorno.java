package com.sefricam.sefricam3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Pantalla_Datos_Entorno extends Activity implements View.OnClickListener {

    // UI Parameters
    private EditText etnd_TemperaturaInicio;
    private EditText etnd_TemperaturaFin;
    private RadioGroup rbg_FuerzaViento;
    private RadioGroup rbg_Nubes;
    private RadioGroup rbg_Lluvia;
    private RadioGroup rbg_Zonificacion;
    private RadioGroup rbg_DireccionViento;
    private RadioButton rb_Zonficacion01;
    private RadioButton rb_Zonficacion02;
    private RadioButton rb_Zonficacion03;
    private RadioButton rb_Zonficacion04;
    private RadioButton rb_Zonficacion05;
    private RadioButton rb_Zonficacion06;
    private RadioButton rb_Zonficacion07;
    private RadioButton rb_Zonficacion08;
    private RadioButton rb_Zonficacion09;
    private RadioButton rb_Zonficacion10;
    private RadioButton rb_Zonficacion11;
    private RadioButton rb_DirVientoN;
    private RadioButton rb_DirVientoS;
    private RadioButton rb_DirVientoE;
    private RadioButton rb_DirVientoO;
    private RadioButton rb_DirVientoNE;
    private RadioButton rb_DirVientoNO;
    private RadioButton rb_DirVientoSE;
    private RadioButton rb_DirVientoSO;
    private RadioButton rb_VientoCalma;
    private RadioButton rb_VientoLigero;
    private RadioButton rb_VientoFuerte;
    private RadioButton rb_NubesAusente;
    private RadioButton rb_NubesNYC;
    private RadioButton rb_NubesCubierto;
    private RadioButton rb_NubesMCubierto;
    private RadioButton rb_LluviaAusente;
    private RadioButton rb_LluviaIntermitente;
    private RadioButton rb_LluviaLigera;
    private RadioButton rb_LluviaFuerte;
    private RadioButton rb_LluviaMFuerte;
    private EditText et_Especie37;
    private EditText et_Especie38;
    private TextView tv_DireccionViento;
    private Button btn_Guardar;
    private Button btn_Volver;
    private final RadioButton[][] rbEspecie = new RadioButton[36][3];

    //Class Parameters
    private Envio envio;
    private Limites limites;

    /**
     * Initialize the screen and all its components
     * @param savedInstanceState bundle of data that receives when it starts the screen
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_datos_entorno);

        startFindView();
        setOnClickListeners();

        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            retrieveData(datos);
            // The following line is just to see what data is received here
            // envio.printData(this.getClass().getName());
        }

        if (envio.isEntornoCompletado()) loadData();


    }

    /**
     * Init the UI elements into the code
     */
    private void startFindView() {
        etnd_TemperaturaInicio = findViewById(R.id.etnd_TemperaturaInicio);
        etnd_TemperaturaFin = findViewById(R.id.etnd_TemperaturaFin);

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

        rbg_FuerzaViento = findViewById(R.id.rbg_FuerzaViento);
        rb_VientoCalma = findViewById(R.id.rb_VientoCalma);
        rb_VientoLigero = findViewById(R.id.rb_VientoLigero);
        rb_VientoFuerte = findViewById(R.id.rb_VientoFuerte);

        tv_DireccionViento = findViewById(R.id.tv_DireccionViento);
        rbg_DireccionViento = findViewById(R.id.rbg_DireccionViento);
        rb_DirVientoN = findViewById(R.id.rb_DirN);
        rb_DirVientoS = findViewById(R.id.rb_DirS);
        rb_DirVientoE = findViewById(R.id.rb_DirE);
        rb_DirVientoO = findViewById(R.id.rb_DirO);
        rb_DirVientoNE = findViewById(R.id.rb_DirNE);
        rb_DirVientoNO = findViewById(R.id.rb_DirNO);
        rb_DirVientoSE = findViewById(R.id.rb_DirSE);
        rb_DirVientoSO = findViewById(R.id.rb_DirSO);

        rbg_Nubes = findViewById(R.id.rbg_Nubes);
        rb_NubesAusente = findViewById(R.id.rb_NubesAusente);
        rb_NubesNYC = findViewById(R.id.rb_NubesNYC);
        rb_NubesCubierto = findViewById(R.id.rb_NubesCubierto);
        rb_NubesMCubierto = findViewById(R.id.rb_NubesMCubierto);

        rbg_Lluvia = findViewById(R.id.rbg_Lluvia);
        rb_LluviaAusente = findViewById(R.id.rb_LluviaAusente);
        rb_LluviaIntermitente = findViewById(R.id.rb_LluviaIntermitente);
        rb_LluviaLigera = findViewById(R.id.rb_LluviaLigera);
        rb_LluviaFuerte = findViewById(R.id.rb_LluviaFuerte);
        rb_LluviaMFuerte = findViewById(R.id.rb_LluviaMFuerte);

        for (int i = 1; i <= 36; i++) {
            for (int j = 0; j < 3; j++) {
                String suffix = j == 0 ? "N" : (j == 1 ? "S" : "A");
                int resId = getResources().getIdentifier(
                    String.format("rb_Especie%02d%s", i, suffix),
                    "id", getPackageName());
                rbEspecie[i - 1][j] = findViewById(resId);
                int finalI = i;
                rbEspecie[i - 1][j].setOnClickListener(v -> {
                    // ensure exclusive selection per species
                    for (int k = 0; k < 3; k++) {
                        if (rbEspecie[finalI - 1][k] != v) rbEspecie[finalI - 1][k].setChecked(false);
                    }
                });
            }
        }

        et_Especie37 = findViewById(R.id.et_Especie37);
        et_Especie38 = findViewById(R.id.et_Especie38);

        btn_Guardar = findViewById(R.id.btn_GuardarEntorno);
        btn_Volver = findViewById(R.id.btn_VolverEntorno);
    }

    /**
     * Sets all the click listener for the UI elements
     */
    private void setOnClickListeners() {
        btn_Volver.setOnClickListener(this);
        btn_Guardar.setOnClickListener(this);
        rb_VientoCalma.setOnClickListener(this);
        rb_VientoFuerte.setOnClickListener(this);
        rb_VientoLigero.setOnClickListener(this);
    }

    /**
     * Handle the onClick event for the UI elements
     * @param view the view that was clicked
     */
    @Override
    public void onClick(View view) {
        if (view == btn_Guardar){
            if (checkData()){
                setValues();
                envio.setEntornoCompletado(true);
                Intent activity = new Intent(this, Pantalla_Menu_Metodos_Y_Captura.class);
                saveData(activity);

                startActivity(activity);
                finish();
            } else {
                Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_LONG).show();
            }
        }
        if (view == btn_Volver){
            Intent activity = new Intent(this, Pantalla_Menu_Metodos_Y_Captura.class);
            saveData(activity);

            startActivity(activity);
            finish();
        }
        if (view == rb_VientoCalma){
            tv_DireccionViento.setTextColor(getColor(R.color.Gris));
            rb_DirVientoN.setChecked(false);
            rb_DirVientoN.setClickable(false);
            rb_DirVientoN.setTextColor(getColor(R.color.Gris));
            rb_DirVientoNO.setChecked(false);
            rb_DirVientoNO.setClickable(false);
            rb_DirVientoNO.setTextColor(getColor(R.color.Gris));
            rb_DirVientoNE.setChecked(false);
            rb_DirVientoNE.setClickable(false);
            rb_DirVientoNE.setTextColor(getColor(R.color.Gris));
            rb_DirVientoS.setChecked(false);
            rb_DirVientoS.setClickable(false);
            rb_DirVientoS.setTextColor(getColor(R.color.Gris));
            rb_DirVientoSE.setChecked(false);
            rb_DirVientoSE.setClickable(false);
            rb_DirVientoSE.setTextColor(getColor(R.color.Gris));
            rb_DirVientoSO.setChecked(false);
            rb_DirVientoSO.setClickable(false);
            rb_DirVientoSO.setTextColor(getColor(R.color.Gris));
            rb_DirVientoE.setChecked(false);
            rb_DirVientoE.setClickable(false);
            rb_DirVientoE.setTextColor(getColor(R.color.Gris));
            rb_DirVientoO.setChecked(false);
            rb_DirVientoO.setClickable(false);
            rb_DirVientoO.setTextColor(getColor(R.color.Gris));
        }
        if (view == rb_VientoLigero){
            tv_DireccionViento.setTextColor(getColor(R.color.VerdePrimario));
            rb_DirVientoN.setChecked(false);
            rb_DirVientoN.setClickable(true);
            rb_DirVientoN.setTextColor(getColor(R.color.VerdePrimario));
            rb_DirVientoNO.setChecked(false);
            rb_DirVientoNO.setClickable(true);
            rb_DirVientoNO.setTextColor(getColor(R.color.VerdePrimario));
            rb_DirVientoNE.setChecked(false);
            rb_DirVientoNE.setClickable(true);
            rb_DirVientoNE.setTextColor(getColor(R.color.VerdePrimario));
            rb_DirVientoS.setChecked(false);
            rb_DirVientoS.setClickable(true);
            rb_DirVientoS.setTextColor(getColor(R.color.VerdePrimario));
            rb_DirVientoSE.setChecked(false);
            rb_DirVientoSE.setClickable(true);
            rb_DirVientoSE.setTextColor(getColor(R.color.VerdePrimario));
            rb_DirVientoSO.setChecked(false);
            rb_DirVientoSO.setClickable(true);
            rb_DirVientoSO.setTextColor(getColor(R.color.VerdePrimario));
            rb_DirVientoE.setChecked(false);
            rb_DirVientoE.setClickable(true);
            rb_DirVientoE.setTextColor(getColor(R.color.VerdePrimario));
            rb_DirVientoO.setChecked(false);
            rb_DirVientoO.setClickable(true);
            rb_DirVientoO.setTextColor(getColor(R.color.VerdePrimario));
        }
        if (view == rb_VientoFuerte){
            tv_DireccionViento.setTextColor(getColor(R.color.VerdePrimario));
            rb_DirVientoN.setChecked(false);
            rb_DirVientoN.setClickable(true);
            rb_DirVientoN.setTextColor(getColor(R.color.VerdePrimario));
            rb_DirVientoNO.setChecked(false);
            rb_DirVientoNO.setClickable(true);
            rb_DirVientoNO.setTextColor(getColor(R.color.VerdePrimario));
            rb_DirVientoNE.setChecked(false);
            rb_DirVientoNE.setClickable(true);
            rb_DirVientoNE.setTextColor(getColor(R.color.VerdePrimario));
            rb_DirVientoS.setChecked(false);
            rb_DirVientoS.setClickable(true);
            rb_DirVientoS.setTextColor(getColor(R.color.VerdePrimario));
            rb_DirVientoSE.setChecked(false);
            rb_DirVientoSE.setClickable(true);
            rb_DirVientoSE.setTextColor(getColor(R.color.VerdePrimario));
            rb_DirVientoSO.setChecked(false);
            rb_DirVientoSO.setClickable(true);
            rb_DirVientoSO.setTextColor(getColor(R.color.VerdePrimario));
            rb_DirVientoE.setChecked(false);
            rb_DirVientoE.setClickable(true);
            rb_DirVientoE.setTextColor(getColor(R.color.VerdePrimario));
            rb_DirVientoO.setChecked(false);
            rb_DirVientoO.setClickable(true);
            rb_DirVientoO.setTextColor(getColor(R.color.VerdePrimario));
        }
    }

    /**
     * Checks if all the data is filled and valid
     * @return true if all is OK, else false
     */
    private boolean checkData() {
        double temperaturaMinima = limites.getMinTemp();
        double temperaturaMaxima = limites.getMaxTemp();
        if (rbg_Zonificacion.getCheckedRadioButtonId()==-1) return false;
        if (rbg_FuerzaViento.getCheckedRadioButtonId()==-1) return false;
        if (!rb_VientoCalma.isChecked()){
            if (rbg_DireccionViento.getCheckedRadioButtonId()==-1) return false;
        }
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

    /**
     * Puts the data in the Envio Object
     */
    private void setValues() {
        int zonificacion = 0;
        int viento = 0;
        String direccionViento = "0";
        int nubes = 0;
        int lluvia = 0;


        double tInicio = Double.parseDouble(etnd_TemperaturaInicio.getText().toString());
        double tFin = Double.parseDouble(etnd_TemperaturaFin.getText().toString());

        int checkedIdZonificacion = rbg_Zonificacion.getCheckedRadioButtonId();
        if (checkedIdZonificacion == R.id.rb_Zonificacion01) {
            zonificacion = 1;
        } else if (checkedIdZonificacion == R.id.rb_Zonificacion02) {
            zonificacion = 2;
        } else if (checkedIdZonificacion == R.id.rb_Zonificacion03) {
            zonificacion = 3;
        } else if (checkedIdZonificacion == R.id.rb_Zonificacion04) {
            zonificacion = 4;
        } else if (checkedIdZonificacion == R.id.rb_Zonificacion05) {
            zonificacion = 5;
        } else if (checkedIdZonificacion == R.id.rb_Zonificacion06) {
            zonificacion = 6;
        } else if (checkedIdZonificacion == R.id.rb_Zonificacion07) {
            zonificacion = 7;
        } else if (checkedIdZonificacion == R.id.rb_Zonificacion08) {
            zonificacion = 8;
        } else if (checkedIdZonificacion == R.id.rb_Zonificacion09) {
            zonificacion = 9;
        } else if (checkedIdZonificacion == R.id.rb_Zonificacion10) {
            zonificacion = 10;
        } else if (checkedIdZonificacion == R.id.rb_Zonificacion11) {
            zonificacion = 11;
        }

        int checkedIdFuerzaViento = rbg_FuerzaViento.getCheckedRadioButtonId();
        if (checkedIdFuerzaViento == R.id.rb_VientoCalma) {
            viento = 1;
        } else if (checkedIdFuerzaViento == R.id.rb_VientoLigero) {
            viento = 2;
        } else if (checkedIdFuerzaViento == R.id.rb_VientoFuerte) {
            viento = 3;
        }


        if (rb_VientoLigero.isChecked() || rb_VientoFuerte.isChecked()) {
            int checkedIdViento = rbg_DireccionViento.getCheckedRadioButtonId();
            if (checkedIdViento == R.id.rb_DirN) {
                direccionViento = "N";
            } else if (checkedIdViento == R.id.rb_DirS) {
                direccionViento = "S";
            } else if (checkedIdViento == R.id.rb_DirE) {
                direccionViento = "E";
            } else if (checkedIdViento == R.id.rb_DirO) {
                direccionViento = "O";
            } else if (checkedIdViento == R.id.rb_DirNE) {
                direccionViento = "NE";
            } else if (checkedIdViento == R.id.rb_DirNO) {
                direccionViento = "NO";
            } else if (checkedIdViento == R.id.rb_DirSE) {
                direccionViento = "SE";
            } else if (checkedIdViento == R.id.rb_DirSO) {
                direccionViento = "SO";
            }
        } else {
            direccionViento = "0";
        }


        int checkedIdNubes = rbg_Nubes.getCheckedRadioButtonId();
        if (checkedIdNubes == R.id.rb_NubesAusente) {
            nubes = 1;
        } else if (checkedIdNubes == R.id.rb_NubesNYC) {
            nubes = 2;
        } else if (checkedIdNubes == R.id.rb_NubesCubierto) {
            nubes = 3;
        } else if (checkedIdNubes == R.id.rb_NubesMCubierto) {
            nubes = 4;
        }

        int checkedIdLluvia = rbg_Lluvia.getCheckedRadioButtonId();
        if (checkedIdLluvia == R.id.rb_LluviaAusente) {
            lluvia = 1;
        } else if (checkedIdLluvia == R.id.rb_LluviaIntermitente) {
            lluvia = 2;
        } else if (checkedIdLluvia == R.id.rb_LluviaLigera) {
            lluvia = 3;
        } else if (checkedIdLluvia == R.id.rb_LluviaFuerte) {
            lluvia = 4;
        } else if (checkedIdLluvia == R.id.rb_LluviaMFuerte) {
            lluvia = 5;
        }

        ArrayList<Integer> plantas = setPlantas();

        String ep37, ep38;
        if (et_Especie37.getText().toString().isEmpty()) ep37 = "-";
        else ep37 = et_Especie37.getText().toString();

        if (et_Especie38.getText().toString().isEmpty()) ep38 = "-";
        else ep38 = et_Especie38.getText().toString();

        envio.setDatosEntorno( new DatosEntorno(tInicio, tFin, zonificacion, viento, direccionViento, nubes, lluvia, plantas, ep37, ep38) );
    }

    /**
     * Transforms the UI data into a array
     * @return a Integer Array witch contains UI data
     */
    @SuppressLint("NonConstantResourceId")
    private ArrayList<Integer> setPlantas() {
        ArrayList<Integer> plantasSeleccionadas = new ArrayList<>();
        for (int i = 0; i < 36; i++) {
            int val = 0;
            if (rbEspecie[i][1].isChecked()) val = 1;
            else if (rbEspecie[i][2].isChecked()) val = 2;
            plantasSeleccionadas.add(val);
        }
        return plantasSeleccionadas;
    }

    /**
     * Save the parameters to send to a certain activity
     * @param actividadDestino activity where data is send
     */
    private void saveData(Intent actividadDestino) {
        actividadDestino.putExtra("ENVIO", envio);
        actividadDestino.putExtra("LIMITES", limites);
    }

    /**
     * Retrieve the data received from a certain activity
     * @param datos bundle where the data is located
     */
    private void retrieveData(Bundle datos) {
        envio = (Envio) datos.getSerializable("ENVIO");
        limites = (Limites) datos.getSerializable("LIMITES");
    }

    /**
     * Loads the data into the UI components
     */
    private void loadData() {

        etnd_TemperaturaInicio.setText(String.valueOf(envio.getDatosEntorno().getTInicio()));
        etnd_TemperaturaFin.setText(String.valueOf(envio.getDatosEntorno().getTFin()));

        switch (envio.getDatosEntorno().getZonificacion()){
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

        switch (envio.getDatosEntorno().getViento()) {
            case 1:
                rb_VientoCalma.setChecked(true);
                tv_DireccionViento.setTextColor(getColor(R.color.Gris));
                rb_DirVientoN.setChecked(false);
                rb_DirVientoN.setClickable(false);
                rb_DirVientoN.setTextColor(getColor(R.color.Gris));
                rb_DirVientoNO.setChecked(false);
                rb_DirVientoNO.setClickable(false);
                rb_DirVientoNO.setTextColor(getColor(R.color.Gris));
                rb_DirVientoNE.setChecked(false);
                rb_DirVientoNE.setClickable(false);
                rb_DirVientoNE.setTextColor(getColor(R.color.Gris));
                rb_DirVientoS.setChecked(false);
                rb_DirVientoS.setClickable(false);
                rb_DirVientoS.setTextColor(getColor(R.color.Gris));
                rb_DirVientoSE.setChecked(false);
                rb_DirVientoSE.setClickable(false);
                rb_DirVientoSE.setTextColor(getColor(R.color.Gris));
                rb_DirVientoSO.setChecked(false);
                rb_DirVientoSO.setClickable(false);
                rb_DirVientoSO.setTextColor(getColor(R.color.Gris));
                rb_DirVientoE.setChecked(false);
                rb_DirVientoE.setClickable(false);
                rb_DirVientoE.setTextColor(getColor(R.color.Gris));
                rb_DirVientoO.setChecked(false);
                rb_DirVientoO.setClickable(false);
                rb_DirVientoO.setTextColor(getColor(R.color.Gris));
                break;
            case 2:
                rb_VientoLigero.setChecked(true);

                tv_DireccionViento.setTextColor(getColor(R.color.VerdePrimario));
                rb_DirVientoN.setClickable(true);
                rb_DirVientoN.setTextColor(getColor(R.color.VerdePrimario));
                rb_DirVientoNO.setClickable(true);
                rb_DirVientoNO.setTextColor(getColor(R.color.VerdePrimario));
                rb_DirVientoNE.setClickable(true);
                rb_DirVientoNE.setTextColor(getColor(R.color.VerdePrimario));
                rb_DirVientoS.setClickable(true);
                rb_DirVientoS.setTextColor(getColor(R.color.VerdePrimario));
                rb_DirVientoSE.setClickable(true);
                rb_DirVientoSE.setTextColor(getColor(R.color.VerdePrimario));
                rb_DirVientoSO.setClickable(true);
                rb_DirVientoSO.setTextColor(getColor(R.color.VerdePrimario));
                rb_DirVientoE.setClickable(true);
                rb_DirVientoE.setTextColor(getColor(R.color.VerdePrimario));
                rb_DirVientoO.setClickable(true);
                rb_DirVientoO.setTextColor(getColor(R.color.VerdePrimario));
                break;
            case 3:
                rb_VientoFuerte.setChecked(true);

                tv_DireccionViento.setTextColor(getColor(R.color.VerdePrimario));
                rb_DirVientoN.setClickable(true);
                rb_DirVientoN.setTextColor(getColor(R.color.VerdePrimario));
                rb_DirVientoNO.setClickable(true);
                rb_DirVientoNO.setTextColor(getColor(R.color.VerdePrimario));
                rb_DirVientoNE.setClickable(true);
                rb_DirVientoNE.setTextColor(getColor(R.color.VerdePrimario));
                rb_DirVientoS.setClickable(true);
                rb_DirVientoS.setTextColor(getColor(R.color.VerdePrimario));
                rb_DirVientoSE.setClickable(true);
                rb_DirVientoSE.setTextColor(getColor(R.color.VerdePrimario));
                rb_DirVientoSO.setClickable(true);
                rb_DirVientoSO.setTextColor(getColor(R.color.VerdePrimario));
                rb_DirVientoE.setClickable(true);
                rb_DirVientoE.setTextColor(getColor(R.color.VerdePrimario));
                rb_DirVientoO.setClickable(true);
                rb_DirVientoO.setTextColor(getColor(R.color.VerdePrimario));
                break;
        }

        loadWindDirection();

        switch (envio.getDatosEntorno().getNubes()){
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
        switch (envio.getDatosEntorno().getLluvia()){
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
        while (i < envio.getDatosEntorno().getPlantas().size()) {
            int planta = envio.getDatosEntorno().getPlantas().get(i);
            loadPlantas(i, planta);
            i++;
        }

        et_Especie37.setText(envio.getDatosEntorno().getEP37());
        et_Especie38.setText(envio.getDatosEntorno().getEP38());
    }

    /**
     * Loads the wind direction in to the UI
     */
    private void loadWindDirection() {
        switch (envio.getDatosEntorno().getDireccionViento()) {
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
            case "0":
                break;
        }
    }

    /**
     * Checks the RadioButtons on the UI
     * @param numero the number of planta that must be checked
     * @param planta the state in which is checked
     */
    private void loadPlantas(int numero, int planta) {
        // clear all
        for (int j = 0; j < 3; j++) rbEspecie[numero][j].setChecked(false);
        // set selected
        if (planta >= 0 && planta < 3) rbEspecie[numero][planta].setChecked(true);
    }
}
