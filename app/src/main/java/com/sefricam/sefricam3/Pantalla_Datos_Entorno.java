package com.sefricam.sefricam3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Pantalla_Datos_Entorno extends Activity implements View.OnClickListener {

    private Spinner sp_Zonificacion, sp_DireccionViento;
    private Button btn_Guardar, btn_Volver;

    //Coponentes
    private EditText etnd_TemperaturaInicio, etnd_TemperaturaFin;
    private RadioGroup rbg_FuerzaViento, rbg_Nubes, rbg_Lluvia;
    private RadioButton rb_VientoCalma, rb_VientoLigero, rb_VientoFuerte;
    private RadioButton rb_NubesAusente, rb_NubesNYC, rb_NubesCubierto, rb_NubesMCubierto;
    private RadioButton rb_LluviaAusente, rb_LluviaIntermitente, rb_LluviaLigera, rb_LluviaFuerte, rb_LluviaMFuerte;
    private CheckBox cb_Especie01, cb_Especie02, cb_Especie03, cb_Especie04, cb_Especie05;
    private CheckBox cb_Especie06, cb_Especie07, cb_Especie08, cb_Especie09, cb_Especie10;
    private CheckBox cb_Especie11, cb_Especie12, cb_Especie13, cb_Especie14, cb_Especie15;
    private CheckBox cb_Especie16, cb_Especie17, cb_Especie18, cb_Especie19, cb_Especie20;
    private CheckBox cb_Especie21, cb_Especie22, cb_Especie23, cb_Especie24, cb_Especie25;
    private CheckBox cb_Especie26, cb_Especie27, cb_Especie28, cb_Especie29, cb_Especie30;
    private CheckBox cb_Especie31, cb_Especie32, cb_Especie33, cb_Especie34, cb_Especie35, cb_Especie36;
    private EditText et_Especie37, et_Especie38;

    private int viento;
    private int nubes;
    private int lluvia;

    //Parametros
    private boolean envioCompletado;
    private MetodosCaptura metodosCaptura;
    private DatosAvistamiento datosAvistamiento;
    private DatosEntorno datosEntorno;
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
        iniciarSpinners();
        iniciarOnClickListeners();

        if (entornoCompletado){
            cargarDatos();
            System.out.println(datosEntorno.toString());
        }
    }

    private void cargarDatos() {
        etnd_TemperaturaInicio.setText(String.valueOf(datosEntorno.gettInicio()));
        etnd_TemperaturaFin.setText(String.valueOf(datosEntorno.gettFin()));
        sp_Zonificacion.setSelection(datosEntorno.getZonificacion());
        switch (datosEntorno.getDireccionViento()){
            case "N":
                sp_DireccionViento.setSelection(1);
                break;
            case "S":
                sp_DireccionViento.setSelection(2);
                break;
            case "E":
                sp_DireccionViento.setSelection(3);
                break;
            case "O":
                sp_DireccionViento.setSelection(4);
                break;
            case "NE":
                sp_DireccionViento.setSelection(5);
                break;
            case "NO":
                sp_DireccionViento.setSelection(6);
                break;
            case "SE":
                sp_DireccionViento.setSelection(7);
                break;
            case "SO":
                sp_DireccionViento.setSelection(8);
                break;
        }
        switch (datosEntorno.getViento()){
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

        //Metodo a cambiar ya que el array va a pasar a ser booleano y de tamaño fijo
        while (i < datosEntorno.getPlantas().size()) {
            boolean planta = datosEntorno.getPlantas().get(i);
            marcarPlanta(planta, i);
            i++;
        }
    }

    private void marcarPlanta(boolean planta, Integer numero) {
        switch (numero) {
            case 0:
                cb_Especie01.setChecked(planta);
                break;
            case 1:
                cb_Especie02.setChecked(planta);
                break;
            case 2:
                cb_Especie03.setChecked(planta);
                break;
            case 3:
                cb_Especie04.setChecked(planta);
                break;
            case 4:
                cb_Especie05.setChecked(planta);
                break;
            case 5:
                cb_Especie06.setChecked(planta);
                break;
            case 6:
                cb_Especie07.setChecked(planta);
                break;
            case 7:
                cb_Especie08.setChecked(planta);
                break;
            case 8:
                cb_Especie09.setChecked(planta);
                break;
            case 9:
                cb_Especie10.setChecked(planta);
                break;
            case 10:
                cb_Especie11.setChecked(planta);
                break;
            case 11:
                cb_Especie12.setChecked(planta);
                break;
            case 12:
                cb_Especie13.setChecked(planta);
                break;
            case 13:
                cb_Especie14.setChecked(planta);
                break;
            case 14:
                cb_Especie15.setChecked(planta);
                break;
            case 15:
                cb_Especie16.setChecked(planta);
                break;
            case 16:
                cb_Especie17.setChecked(planta);
                break;
            case 17:
                cb_Especie18.setChecked(planta);
                break;
            case 18:
                cb_Especie19.setChecked(planta);
                break;
            case 19:
                cb_Especie20.setChecked(planta);
                break;
            case 20:
                cb_Especie21.setChecked(planta);
                break;
            case 21:
                cb_Especie22.setChecked(planta);
                break;
            case 22:
                cb_Especie23.setChecked(planta);
                break;
            case 23:
                cb_Especie24.setChecked(planta);
                break;
            case 24:
                cb_Especie25.setChecked(planta);
                break;
            case 25:
                cb_Especie26.setChecked(planta);
                break;
            case 26:
                cb_Especie27.setChecked(planta);
                break;
            case 27:
                cb_Especie28.setChecked(planta);
                break;
            case 28:
                cb_Especie29.setChecked(planta);
                break;
            case 29:
                cb_Especie30.setChecked(planta);
                break;
            case 30:
                cb_Especie31.setChecked(planta);
                break;
            case 31:
                cb_Especie32.setChecked(planta);
                break;
            case 32:
                cb_Especie33.setChecked(planta);
                break;
            case 33:
                cb_Especie34.setChecked(planta);
                break;
            case 34:
                cb_Especie35.setChecked(planta);
                break;
            case 35:
                cb_Especie36.setChecked(planta);
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

        //Spinner Zonificacion
        sp_Zonificacion = findViewById(R.id.sp_Zonificacion);

        //Radio Button Group Viento
        rbg_FuerzaViento = findViewById(R.id.rbg_FuerzaViento);
        rb_VientoCalma = findViewById(R.id.rb_VientoCalma);
        rb_VientoLigero = findViewById(R.id.rb_VientoLigero);
        rb_VientoFuerte = findViewById(R.id.rb_VientoFuerte);

        //Spinner Direccion Viento
        sp_DireccionViento = findViewById(R.id.sp_DireccionViento);

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

        //Check Box Especies Plantas
        cb_Especie01 = findViewById(R.id.cb_Especie01);
        cb_Especie02 = findViewById(R.id.cb_Especie02);
        cb_Especie03 = findViewById(R.id.cb_Especie03);
        cb_Especie04 = findViewById(R.id.cb_Especie04);
        cb_Especie05 = findViewById(R.id.cb_Especie05);
        cb_Especie06 = findViewById(R.id.cb_Especie06);
        cb_Especie07 = findViewById(R.id.cb_Especie07);
        cb_Especie08 = findViewById(R.id.cb_Especie08);
        cb_Especie09 = findViewById(R.id.cb_Especie09);
        cb_Especie10 = findViewById(R.id.cb_Especie10);
        cb_Especie11 = findViewById(R.id.cb_Especie11);
        cb_Especie12 = findViewById(R.id.cb_Especie12);
        cb_Especie13 = findViewById(R.id.cb_Especie13);
        cb_Especie14 = findViewById(R.id.cb_Especie14);
        cb_Especie15 = findViewById(R.id.cb_Especie15);
        cb_Especie16 = findViewById(R.id.cb_Especie16);
        cb_Especie17 = findViewById(R.id.cb_Especie17);
        cb_Especie18 = findViewById(R.id.cb_Especie18);
        cb_Especie19 = findViewById(R.id.cb_Especie19);
        cb_Especie20 = findViewById(R.id.cb_Especie20);
        cb_Especie21 = findViewById(R.id.cb_Especie21);
        cb_Especie22 = findViewById(R.id.cb_Especie22);
        cb_Especie23 = findViewById(R.id.cb_Especie23);
        cb_Especie24 = findViewById(R.id.cb_Especie24);
        cb_Especie25 = findViewById(R.id.cb_Especie25);
        cb_Especie26 = findViewById(R.id.cb_Especie26);
        cb_Especie27 = findViewById(R.id.cb_Especie27);
        cb_Especie28 = findViewById(R.id.cb_Especie28);
        cb_Especie29 = findViewById(R.id.cb_Especie29);
        cb_Especie30 = findViewById(R.id.cb_Especie30);
        cb_Especie31 = findViewById(R.id.cb_Especie31);
        cb_Especie32 = findViewById(R.id.cb_Especie32);
        cb_Especie33 = findViewById(R.id.cb_Especie33);
        cb_Especie34 = findViewById(R.id.cb_Especie34);
        cb_Especie35 = findViewById(R.id.cb_Especie35);
        cb_Especie36 = findViewById(R.id.cb_Especie36);

        et_Especie37 = findViewById(R.id.et_Especie37);
        et_Especie38 = findViewById(R.id.et_Especie38);

        //Botones
        btn_Guardar = findViewById(R.id.btn_GuardarEntorno);
        btn_Volver = findViewById(R.id.btn_VolverEntorno);


    }

    private void iniciarSpinners() {
        String [] zonificacion = {"Seleccione el que corresponda","Afloramientos Rocosos y Rasos", "Cultivos", "Láminas y Cursos de Agua", "Dehesa y zonas adehesadas", "Plantaciones de Frondosas y Coníferas", "Vegetación Arbórea de Coníferas", "Vegetación Arbórea de Frondosas", "Vegetación de Matorral", "Vegetación Herbácea", "Viñedos, Olivares y Otros Frutales", "Zonas Artificiales"};
        ArrayAdapter<String> adapterZonificacion = new ArrayAdapter<String>(this, R.layout.spinner,zonificacion);
        sp_Zonificacion.setAdapter(adapterZonificacion);

        String [] direccionViento = {"Seleccione la que corresponda","N","S","E","O","NE","NO","SE","SO"};
        ArrayAdapter<String> adapterDireccionViento = new ArrayAdapter<>(this,R.layout.spinner,direccionViento);
        sp_DireccionViento.setAdapter(adapterDireccionViento);
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
        boolean comprobado;
        double temperaturaMinima = -15.0;
        double temperaturaMaxima = +40.0;
        if (sp_Zonificacion.getSelectedItem().toString().equals("Seleccione el que corresponda")) return false;
        if (rbg_FuerzaViento.getCheckedRadioButtonId()==-1) return false;
        if (sp_DireccionViento.getSelectedItem().toString().equals("Seleccione la que corresponda")) return false;
        if (rbg_Nubes.getCheckedRadioButtonId()==-1) return false;
        if (rbg_Lluvia.getCheckedRadioButtonId()==-1) return false;
        try {
            Double.valueOf(etnd_TemperaturaInicio.getText().toString());
            Double.valueOf(etnd_TemperaturaFin.getText().toString());
        }catch (Exception e){
            return false;
        }
        if (Double.parseDouble(etnd_TemperaturaFin.getText().toString()) < temperaturaMinima || Double.parseDouble(etnd_TemperaturaInicio.getText().toString()) < temperaturaMinima) {
            Toast.makeText(this, "La temperatura ha de ser superior a "+temperaturaMinima, Toast.LENGTH_LONG).show();
            return  false;
        }
        if (Double.parseDouble(etnd_TemperaturaFin.getText().toString()) > temperaturaMaxima || Double.parseDouble(etnd_TemperaturaInicio.getText().toString()) > temperaturaMaxima) {
            Toast.makeText(this, "La temperatura ha de ser inferior a "+temperaturaMaxima, Toast.LENGTH_LONG).show();
            return  false;
        }
        comprobado = comprobarCheckBox();
        return comprobado;
    }

    private boolean comprobarCheckBox() {
        boolean checkBoxComprobados = false;
        if (cb_Especie01.isChecked()) checkBoxComprobados=true;
        if (cb_Especie02.isChecked()) checkBoxComprobados=true;
        if (cb_Especie03.isChecked()) checkBoxComprobados=true;
        if (cb_Especie04.isChecked()) checkBoxComprobados=true;
        if (cb_Especie05.isChecked()) checkBoxComprobados=true;
        if (cb_Especie06.isChecked()) checkBoxComprobados=true;
        if (cb_Especie07.isChecked()) checkBoxComprobados=true;
        if (cb_Especie08.isChecked()) checkBoxComprobados=true;
        if (cb_Especie09.isChecked()) checkBoxComprobados=true;
        if (cb_Especie10.isChecked()) checkBoxComprobados=true;
        if (cb_Especie11.isChecked()) checkBoxComprobados=true;
        if (cb_Especie12.isChecked()) checkBoxComprobados=true;
        if (cb_Especie13.isChecked()) checkBoxComprobados=true;
        if (cb_Especie14.isChecked()) checkBoxComprobados=true;
        if (cb_Especie15.isChecked()) checkBoxComprobados=true;
        if (cb_Especie16.isChecked()) checkBoxComprobados=true;
        if (cb_Especie17.isChecked()) checkBoxComprobados=true;
        if (cb_Especie18.isChecked()) checkBoxComprobados=true;
        if (cb_Especie19.isChecked()) checkBoxComprobados=true;
        if (cb_Especie20.isChecked()) checkBoxComprobados=true;
        if (cb_Especie21.isChecked()) checkBoxComprobados=true;
        if (cb_Especie22.isChecked()) checkBoxComprobados=true;
        if (cb_Especie23.isChecked()) checkBoxComprobados=true;
        if (cb_Especie24.isChecked()) checkBoxComprobados=true;
        if (cb_Especie25.isChecked()) checkBoxComprobados=true;
        if (cb_Especie26.isChecked()) checkBoxComprobados=true;
        if (cb_Especie27.isChecked()) checkBoxComprobados=true;
        if (cb_Especie28.isChecked()) checkBoxComprobados=true;
        if (cb_Especie29.isChecked()) checkBoxComprobados=true;
        if (cb_Especie30.isChecked()) checkBoxComprobados=true;
        if (cb_Especie31.isChecked()) checkBoxComprobados=true;
        if (cb_Especie32.isChecked()) checkBoxComprobados=true;
        if (cb_Especie33.isChecked()) checkBoxComprobados=true;
        if (cb_Especie34.isChecked()) checkBoxComprobados=true;
        if (cb_Especie35.isChecked()) checkBoxComprobados=true;
        return checkBoxComprobados;
    }

    private void asignacionValores(){

        //Datos
        Double tInicio = Double.parseDouble(etnd_TemperaturaInicio.getText().toString());
        Double tFin = Double.parseDouble(etnd_TemperaturaFin.getText().toString());
        int zonificacion = sp_Zonificacion.getSelectedItemPosition();
        switch (rbg_FuerzaViento.getCheckedRadioButtonId()){
            case R.id.rb_VientoCalma:
                viento=1;
                break;
            case R.id.rb_VientoLigero:
                viento=2;
                break;
            case R.id.rb_VientoFuerte:
                viento=3;
                break;
        }
        String direccionViento = sp_DireccionViento.getSelectedItem().toString();
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
                lluvia=3;
                break;
            case R.id.rb_LluviaFuerte:
                lluvia=4;
                break;
            case R.id.rb_LluviaMFuerte:
                lluvia = 5;
                break;
        }
        ArrayList<Boolean> plantas = escogerPlantas();

        datosEntorno = new DatosEntorno(tInicio, tFin, zonificacion, viento, direccionViento, nubes, lluvia, plantas, et_Especie37.getText().toString(), et_Especie38.getText().toString());


    }

    private ArrayList<Boolean> escogerPlantas() {
        ArrayList<Boolean> plantasSeleccionadas = new ArrayList<>();

        plantasSeleccionadas.add(cb_Especie01.isChecked());
        plantasSeleccionadas.add(cb_Especie02.isChecked());
        plantasSeleccionadas.add(cb_Especie03.isChecked());
        plantasSeleccionadas.add(cb_Especie04.isChecked());
        plantasSeleccionadas.add(cb_Especie05.isChecked());
        plantasSeleccionadas.add(cb_Especie06.isChecked());
        plantasSeleccionadas.add(cb_Especie07.isChecked());
        plantasSeleccionadas.add(cb_Especie08.isChecked());
        plantasSeleccionadas.add(cb_Especie09.isChecked());
        plantasSeleccionadas.add(cb_Especie10.isChecked());
        plantasSeleccionadas.add(cb_Especie11.isChecked());
        plantasSeleccionadas.add(cb_Especie12.isChecked());
        plantasSeleccionadas.add(cb_Especie13.isChecked());
        plantasSeleccionadas.add(cb_Especie14.isChecked());
        plantasSeleccionadas.add(cb_Especie15.isChecked());
        plantasSeleccionadas.add(cb_Especie16.isChecked());
        plantasSeleccionadas.add(cb_Especie17.isChecked());
        plantasSeleccionadas.add(cb_Especie18.isChecked());
        plantasSeleccionadas.add(cb_Especie19.isChecked());
        plantasSeleccionadas.add(cb_Especie20.isChecked());
        plantasSeleccionadas.add(cb_Especie21.isChecked());
        plantasSeleccionadas.add(cb_Especie22.isChecked());
        plantasSeleccionadas.add(cb_Especie23.isChecked());
        plantasSeleccionadas.add(cb_Especie24.isChecked());
        plantasSeleccionadas.add(cb_Especie25.isChecked());
        plantasSeleccionadas.add(cb_Especie26.isChecked());
        plantasSeleccionadas.add(cb_Especie27.isChecked());
        plantasSeleccionadas.add(cb_Especie28.isChecked());
        plantasSeleccionadas.add(cb_Especie29.isChecked());
        plantasSeleccionadas.add(cb_Especie30.isChecked());
        plantasSeleccionadas.add(cb_Especie31.isChecked());
        plantasSeleccionadas.add(cb_Especie32.isChecked());
        plantasSeleccionadas.add(cb_Especie33.isChecked());
        plantasSeleccionadas.add(cb_Especie34.isChecked());
        plantasSeleccionadas.add(cb_Especie35.isChecked());
        plantasSeleccionadas.add(cb_Especie36.isChecked());

        return plantasSeleccionadas;
    }

    private void guardarParametros(Intent actividadDestino) {

        imprimirDatos();

        actividadDestino.putExtra("EMAIL",email);
        actividadDestino.putExtra("DNI",DNI);
        actividadDestino.putExtra("ENVIO_COMPLETADO",envioCompletado);
        actividadDestino.putExtra("DATOS_AVISTAMIENTO", (Serializable) datosAvistamiento);
        actividadDestino.putExtra("DATOS_ENTORNO", (Serializable) datosEntorno);
        actividadDestino.putExtra("DATOS_CAPTURA", (Serializable) metodosCaptura);
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
    }

    private void imprimirDatos() {
        System.out.println("____________________________________________________");
        System.out.println("EMAIL                  => " + email);
        System.out.println("DNI                    => " + DNI);
        System.out.println("____________________________________________________");
        System.out.println("ESTADO ENTORNO         => " + entornoCompletado);
        System.out.println("DATOS ENTORNO          => " + datosEntorno);
        System.out.println("ESTADO METODOS CAPTURA => " + mCapturasCompletado);
        System.out.println("METODOS CAPTURA        => " + metodosCaptura);
        System.out.println("ESTADO AVISTAMIENTO    => " + avistamientoCompletado);
        System.out.println("DATOS AVISTAMIENTO     => " + datosAvistamiento);
        System.out.println("____________________________________________________");
    }
}
