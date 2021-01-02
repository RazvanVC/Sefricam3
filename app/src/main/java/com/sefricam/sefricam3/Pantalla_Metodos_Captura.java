package com.sefricam.sefricam3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class Pantalla_Metodos_Captura extends Activity implements View.OnClickListener{

    private Spinner sp_CimbelesCamachuelo, sp_CimbelesJilguero, sp_CimbelesLugano, sp_CimbelesPardilloComun, sp_CimbelesPicogordo, sp_CimbelesPinzonComun, sp_CimbelesPinzonReal, sp_CimbelesPiquituerto, sp_CimbelesVerdecillo, sp_CimbelesVerdonComun, sp_CimbelesVerdonSerrano;
    private Spinner sp_ReclamosCamachuelo, sp_ReclamosJilguero, sp_ReclamosLugano, sp_ReclamosPardilloComun, sp_ReclamosPicogordo, sp_ReclamosPinzonComun, sp_ReclamosPinzonReal, sp_ReclamosPiquituerto, sp_ReclamosVerdecillo, sp_ReclamosVerdonComun, sp_ReclamosVerdonSerrano;
    private Button btn_Guardar, btn_Volver;
    private EditText etn_NumeroMallas, etn_LongitudRed;
    private EditText etn_CapturasCamachuelo, etn_CapturasJilguero, etn_CapturasLugano, etn_CapturasPardilloComun, etn_CapturasPicogordo, etn_CapturasPinzonComun, etn_CapturasPinzonReal, etn_CapturasPiquituerto, etn_CapturasVerdecillo, etn_CapturasVerdonComun, etn_CapturasVerdonSerrano;
    private EditText  et_Observaciones;

    private RadioGroup rbg_ControlAgentes,rbg_Coto;
    private RadioButton rb_SiControl, rb_NoControl, rb_CotoSI, rb_CotoNO;
    private CheckBox cb_ControlSeprona, cb_ControlForestales, cb_ControlPoliciaMunicipal, cb_ControlPoliciaNacional, cb_ControlOtros;

    private ArrayList<Integer> ControlAgentes = new ArrayList<>();

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

        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            recuperarDatosRecibidos(datos);

            System.out.println("Datos recibidos en Metodos de Captura");
            imprimirDatosRecibidos();
        }

        setContentView(R.layout.pantalla_metodos_captura);
        iniciarComponentes();
        iniciarSpinners();
        iniciarOnClickListener();

        if (mCapturasCompletado){
            cargarDatos();
        }
    }

    private void cargarDatos() {
        etn_NumeroMallas.setText(String.valueOf(metodosCaptura.getNumeroMallas()));
        etn_LongitudRed.setText(String.valueOf(metodosCaptura.getLongitudRed()));

        if (metodosCaptura.isCoto()) rb_CotoSI.setChecked(true);
        else rb_CotoNO.setChecked(true);

        llenarControlAgentes();

        //Spinners Reclamos
        sp_ReclamosCamachuelo.setSelection(metodosCaptura.getReclamosCamachuelo());
        sp_ReclamosJilguero.setSelection(metodosCaptura.getReclamosJilguero());
        sp_ReclamosLugano.setSelection(metodosCaptura.getReclamosLugano());
        sp_ReclamosPardilloComun.setSelection(metodosCaptura.getReclamosPardilloComun());
        sp_ReclamosPicogordo.setSelection(metodosCaptura.getReclamosPicogordo());
        sp_ReclamosPinzonComun.setSelection(metodosCaptura.getReclamosPinzonComun());
        sp_ReclamosPinzonReal.setSelection(metodosCaptura.getReclamosPinzonReal());
        sp_ReclamosPiquituerto.setSelection(metodosCaptura.getReclamosPiquituerto());
        sp_ReclamosVerdecillo.setSelection(metodosCaptura.getReclamosVerdecillo());
        sp_ReclamosVerdonComun.setSelection(metodosCaptura.getReclamosVerdonComun());
        sp_ReclamosVerdonSerrano.setSelection(metodosCaptura.getReclamosVerdonSerrano());

        //Spinners Cimbeles
        sp_CimbelesCamachuelo.setSelection(metodosCaptura.getCimbelesCamachuelo());
        sp_CimbelesJilguero.setSelection(metodosCaptura.getCimbelesJilguero());
        sp_CimbelesLugano.setSelection(metodosCaptura.getCimbelesLugano());
        sp_CimbelesPardilloComun.setSelection(metodosCaptura.getCimbelesPardilloComun());
        sp_CimbelesPicogordo.setSelection(metodosCaptura.getCimbelesPicogordo());
        sp_CimbelesPinzonComun.setSelection(metodosCaptura.getCimbelesPinzonComun());
        sp_CimbelesPinzonReal.setSelection(metodosCaptura.getCimbelesPinzonReal());
        sp_CimbelesPiquituerto.setSelection(metodosCaptura.getCimbelesPiquituerto());
        sp_CimbelesVerdecillo.setSelection(metodosCaptura.getCimbelesVerdecillo());
        sp_CimbelesVerdonComun.setSelection(metodosCaptura.getCimbelesVerdonComun());
        sp_CimbelesVerdonSerrano.setSelection(metodosCaptura.getCimbelesVerdonSerrano());

        //Capturas
        etn_CapturasCamachuelo.setText(String.valueOf(metodosCaptura.getCapturasCamachuelo()));
        etn_CapturasJilguero.setText(String.valueOf(metodosCaptura.getCapturasJilguero()));
        etn_CapturasLugano.setText(String.valueOf(metodosCaptura.getCapturasLugano()));
        etn_CapturasPardilloComun.setText(String.valueOf(metodosCaptura.getCapturasPardilloComun()));
        etn_CapturasPicogordo.setText(String.valueOf(metodosCaptura.getCapturasPicogordo()));
        etn_CapturasPinzonComun.setText(String.valueOf(metodosCaptura.getCapturasPinzonComun()));
        etn_CapturasPinzonReal.setText(String.valueOf(metodosCaptura.getCapturasPinzonReal()));
        etn_CapturasPiquituerto.setText(String.valueOf(metodosCaptura.getCapturasPiquituerto()));
        etn_CapturasVerdecillo.setText(String.valueOf(metodosCaptura.getCapturasVerdecillo()));
        etn_CapturasVerdonComun.setText(String.valueOf(metodosCaptura.getCapturasVerdonComun()));
        etn_CapturasVerdonSerrano.setText(String.valueOf(metodosCaptura.getCapturasVerdonSerrano()));

        et_Observaciones.setText(metodosCaptura.getObservaciones());
    }

    private void llenarControlAgentes() {
        int i = 0;
        while (i<metodosCaptura.getControlAgentes().size()){
            switch (metodosCaptura.getControlAgentes().get(i)){
                case 0:
                    rb_NoControl.setChecked(true);
                    break;
                case 1:
                    rb_SiControl.setChecked(true);
                    cb_ControlSeprona.setChecked(true);
                    cb_ControlForestales.setClickable(true);
                    cb_ControlOtros.setClickable(true);
                    cb_ControlPoliciaMunicipal.setClickable(true);
                    cb_ControlPoliciaNacional.setClickable(true);
                    cb_ControlSeprona.setClickable(true);
                    break;
                case 2:
                    rb_SiControl.setChecked(true);
                    cb_ControlForestales.setChecked(true);
                    cb_ControlForestales.setClickable(true);
                    cb_ControlOtros.setClickable(true);
                    cb_ControlPoliciaMunicipal.setClickable(true);
                    cb_ControlPoliciaNacional.setClickable(true);
                    cb_ControlSeprona.setClickable(true);
                    break;
                case 3:
                    rb_SiControl.setChecked(true);
                    cb_ControlPoliciaMunicipal.setChecked(true);
                    cb_ControlForestales.setClickable(true);
                    cb_ControlOtros.setClickable(true);
                    cb_ControlPoliciaMunicipal.setClickable(true);
                    cb_ControlPoliciaNacional.setClickable(true);
                    cb_ControlSeprona.setClickable(true);
                    break;
                case 4:
                    rb_SiControl.setChecked(true);
                    cb_ControlPoliciaNacional.setChecked(true);
                    cb_ControlForestales.setClickable(true);
                    cb_ControlOtros.setClickable(true);
                    cb_ControlPoliciaMunicipal.setClickable(true);
                    cb_ControlPoliciaNacional.setClickable(true);
                    cb_ControlSeprona.setClickable(true);
                    break;
                case 5:
                    rb_SiControl.setChecked(true);
                    cb_ControlOtros.setChecked(true);
                    cb_ControlForestales.setClickable(true);
                    cb_ControlOtros.setClickable(true);
                    cb_ControlPoliciaMunicipal.setClickable(true);
                    cb_ControlPoliciaNacional.setClickable(true);
                    cb_ControlSeprona.setClickable(true);
                    break;
            }
            i++;
        }
    }

    private void iniciarOnClickListener() {
        rb_SiControl.setOnClickListener(this);
        rb_NoControl.setOnClickListener(this);
        btn_Guardar.setOnClickListener(this);
        btn_Volver.setOnClickListener(this);
    }

    private void iniciarComponentes() {

        etn_LongitudRed = (EditText) findViewById(R.id.etn_LongitudRed);
        etn_NumeroMallas = (EditText) findViewById(R.id.etn_NumeroMallas);

        rbg_Coto = findViewById(R.id.rbg_Coto);
        rb_CotoSI = findViewById(R.id.rb_CotoSI);
        rb_CotoNO = findViewById(R.id.rb_CotoNO);

        rbg_ControlAgentes = findViewById(R.id.rbg_ControlAgentes);
        rb_NoControl = (RadioButton) findViewById(R.id.rb_NoControlAgentes);
        rb_SiControl = (RadioButton) findViewById(R.id.rb_SiControlAgentes);

        cb_ControlSeprona = (CheckBox) findViewById(R.id.cb_ControlAgentesSeprona);
        cb_ControlForestales = (CheckBox) findViewById(R.id.cb_ControlAgentesForestales);
        cb_ControlPoliciaNacional = (CheckBox) findViewById(R.id.cb_ControlAgentesPoliciaNacional);
        cb_ControlPoliciaMunicipal = (CheckBox) findViewById(R.id.cb_ControlAgentesPoliciaMunicipal);
        cb_ControlOtros = (CheckBox) findViewById(R.id.cb_ControlAgentesOtros);

        //Spinners Reclamos
        sp_ReclamosCamachuelo = (Spinner) findViewById(R.id.sp_ReclamosCamachuelo);
        sp_ReclamosJilguero = (Spinner) findViewById(R.id.sp_ReclamosJilguero);
        sp_ReclamosLugano = (Spinner) findViewById(R.id.sp_ReclamosLugano);
        sp_ReclamosPardilloComun = (Spinner) findViewById(R.id.sp_ReclamosPardilloComun);
        sp_ReclamosPicogordo = (Spinner) findViewById(R.id.sp_ReclamosPicogordo);
        sp_ReclamosPinzonComun = (Spinner) findViewById(R.id.sp_ReclamosPinzonComun);
        sp_ReclamosPinzonReal = (Spinner) findViewById(R.id.sp_ReclamosPinzonReal);
        sp_ReclamosPiquituerto = (Spinner) findViewById(R.id.sp_ReclamosPiquituerto);
        sp_ReclamosVerdecillo = (Spinner) findViewById(R.id.sp_ReclamosVerdecillo);
        sp_ReclamosVerdonComun = (Spinner) findViewById(R.id.sp_ReclamosVerdonComun);
        sp_ReclamosVerdonSerrano = (Spinner) findViewById(R.id.sp_ReclamosVerdonSerrano);

        //Spinners Cimbeles
        sp_CimbelesCamachuelo = (Spinner) findViewById(R.id.sp_CimbelesCamachuelo);
        sp_CimbelesJilguero = (Spinner) findViewById(R.id.sp_CimbelesJilguero);
        sp_CimbelesLugano = (Spinner) findViewById(R.id.sp_CimbelesLugano);
        sp_CimbelesPardilloComun = (Spinner) findViewById(R.id.sp_CimbelesPardilloComun);
        sp_CimbelesPicogordo = (Spinner) findViewById(R.id.sp_CimbelesPicogordo);
        sp_CimbelesPinzonComun = (Spinner) findViewById(R.id.sp_CimbelesPinzonComun);
        sp_CimbelesPinzonReal = (Spinner) findViewById(R.id.sp_CimbelesPinzonReal);
        sp_CimbelesPiquituerto = (Spinner) findViewById(R.id.sp_CimbelesPiquituerto);
        sp_CimbelesVerdecillo = (Spinner) findViewById(R.id.sp_CimbelesVerdecillo);
        sp_CimbelesVerdonComun = (Spinner) findViewById(R.id.sp_CimbelesVerdonComun);
        sp_CimbelesVerdonSerrano = (Spinner) findViewById(R.id.sp_CimbelesVerdonSerrano);

        //EditText Capturas
        etn_CapturasCamachuelo = (EditText) findViewById(R.id.etn_CapturasCamachuelo);
        etn_CapturasJilguero  = (EditText) findViewById(R.id.etn_CapturasJilguero);
        etn_CapturasLugano  = (EditText) findViewById(R.id.etn_CapturasLugano);
        etn_CapturasPardilloComun = (EditText) findViewById(R.id.etn_CapturasPardilloComun);
        etn_CapturasPicogordo = (EditText) findViewById(R.id.etn_CapturasPicogordo);
        etn_CapturasPinzonComun = (EditText) findViewById(R.id.etn_CapturasPinzonComun);
        etn_CapturasPinzonReal = (EditText) findViewById(R.id.etn_CapturasPinzonReal);
        etn_CapturasPiquituerto = (EditText) findViewById(R.id.etn_CapturasPiquituerto);
        etn_CapturasVerdecillo = (EditText) findViewById(R.id.etn_CapturasVerdecillo);
        etn_CapturasVerdonComun = (EditText) findViewById(R.id.etn_CapturasVerdonComun);
        etn_CapturasVerdonSerrano = (EditText) findViewById(R.id.etn_CapturasVerdonSerrano);

        et_Observaciones = (EditText) findViewById(R.id.et_ObservacionesMetodos);
        btn_Guardar = (Button) findViewById(R.id.btn_GuardarMetodos);
        btn_Volver = (Button) findViewById(R.id.btn_VolverMetodos);
    }

    private void iniciarSpinners() {
        String [] opciones = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        ArrayAdapter<String> adapterOpciones = new ArrayAdapter<String>(this, R.layout.spinner, opciones);

        //Spinners Reclamos
        sp_ReclamosCamachuelo.setAdapter(adapterOpciones);
        sp_ReclamosJilguero.setAdapter(adapterOpciones);
        sp_ReclamosLugano.setAdapter(adapterOpciones);
        sp_ReclamosPardilloComun.setAdapter(adapterOpciones);
        sp_ReclamosPicogordo.setAdapter(adapterOpciones);
        sp_ReclamosPinzonComun.setAdapter(adapterOpciones);
        sp_ReclamosPinzonReal.setAdapter(adapterOpciones);
        sp_ReclamosPiquituerto.setAdapter(adapterOpciones);
        sp_ReclamosVerdecillo.setAdapter(adapterOpciones);
        sp_ReclamosVerdonComun.setAdapter(adapterOpciones);
        sp_ReclamosVerdonSerrano.setAdapter(adapterOpciones);

        //Spinners Cimbeles
        sp_CimbelesCamachuelo.setAdapter(adapterOpciones);
        sp_CimbelesJilguero.setAdapter(adapterOpciones);
        sp_CimbelesLugano.setAdapter(adapterOpciones);
        sp_CimbelesPardilloComun.setAdapter(adapterOpciones);
        sp_CimbelesPicogordo.setAdapter(adapterOpciones);
        sp_CimbelesPinzonComun.setAdapter(adapterOpciones);
        sp_CimbelesPinzonReal.setAdapter(adapterOpciones);
        sp_CimbelesPiquituerto.setAdapter(adapterOpciones);
        sp_CimbelesVerdecillo.setAdapter(adapterOpciones);
        sp_CimbelesVerdonComun.setAdapter(adapterOpciones);
        sp_CimbelesVerdonSerrano.setAdapter(adapterOpciones);

    }

    @Override
    public void onClick(View v) {
        if (v == btn_Volver){
            Intent activity = new Intent(this, Pantalla_Menu_Metodos_Y_Captura.class);
            guardarParametros(activity);

            startActivity(activity);
            finish();
        }
        if (v == btn_Guardar){
            if (comprobarCampos()){
                asignacionValores();
                mCapturasCompletado = true;
                Intent activity = new Intent(this, Pantalla_Menu_Metodos_Y_Captura.class);
                guardarParametros(activity);

                startActivity(activity);
                finish();
            } else {
                Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_LONG).show();
            }
        }
        if (v == rb_NoControl){
            cb_ControlOtros.setChecked(false);
            cb_ControlPoliciaMunicipal.setChecked(false);
            cb_ControlPoliciaNacional.setChecked(false);
            cb_ControlForestales.setChecked(false);
            cb_ControlSeprona.setChecked(false);

            cb_ControlForestales.setClickable(false);
            cb_ControlOtros.setClickable(false);
            cb_ControlPoliciaMunicipal.setClickable(false);
            cb_ControlPoliciaNacional.setClickable(false);
            cb_ControlSeprona.setClickable(false);

        }
        if (v == rb_SiControl){
            cb_ControlForestales.setClickable(true);
            cb_ControlOtros.setClickable(true);
            cb_ControlPoliciaMunicipal.setClickable(true);
            cb_ControlPoliciaNacional.setClickable(true);
            cb_ControlSeprona.setClickable(true);
        }
    }

    private void asignacionValores() {

        int numeroMallas = Integer.parseInt(etn_NumeroMallas.getText().toString());
        int longitudRed = Integer.parseInt(etn_LongitudRed.getText().toString());

        asignarControlAgentes();
        boolean coto = false;
        if (rbg_Coto.getCheckedRadioButtonId()==R.id.rb_CotoSI) {
            coto = true;
        }

        //Spinner Reclamos
        int reclamosCamachuelo = sp_ReclamosCamachuelo.getSelectedItemPosition();
        int reclamosJilguero = sp_ReclamosJilguero.getSelectedItemPosition();
        int reclamosLugano = sp_ReclamosLugano.getSelectedItemPosition();
        int reclamosPardilloComun = sp_ReclamosPardilloComun.getSelectedItemPosition();
        int reclamosPicogordo = sp_ReclamosPicogordo.getSelectedItemPosition();
        int reclamosPinzonComun = sp_ReclamosPinzonComun.getSelectedItemPosition();
        int reclamosPinzonReal = sp_ReclamosPinzonReal.getSelectedItemPosition();
        int reclamosPiquituerto = sp_ReclamosPiquituerto.getSelectedItemPosition();
        int reclamosVerdecillo = sp_ReclamosVerdecillo.getSelectedItemPosition();
        int reclamosVerdonComun = sp_ReclamosVerdonComun.getSelectedItemPosition();
        int reclamosVerdonSerrano = sp_ReclamosVerdonSerrano.getSelectedItemPosition();

        //Spinner Cimbeles
        int cimbelesCamachuelo = sp_CimbelesCamachuelo.getSelectedItemPosition();
        int cimbelesJilguero = sp_CimbelesJilguero.getSelectedItemPosition();
        int cimbelesLugano = sp_CimbelesLugano.getSelectedItemPosition();
        int cimbelesPardilloComun = sp_CimbelesPardilloComun.getSelectedItemPosition();
        int cimbelesPicogordo = sp_CimbelesPicogordo.getSelectedItemPosition();
        int cimbelesPinzonComun = sp_CimbelesPinzonComun.getSelectedItemPosition();
        int cimbelesPinzonReal = sp_CimbelesPinzonReal.getSelectedItemPosition();
        int cimbelesPiquituerto = sp_CimbelesPiquituerto.getSelectedItemPosition();
        int cimbelesVerdecillo = sp_CimbelesVerdecillo.getSelectedItemPosition();
        int cimbelesVerdonComun = sp_CimbelesVerdonComun.getSelectedItemPosition();
        int cimbelesVerdonSerrano = sp_CimbelesVerdonSerrano.getSelectedItemPosition();

        //EditText Capturas
        int capturasCamachuelo = Integer.parseInt(etn_CapturasCamachuelo.getText().toString());
        int capturasJilguero = Integer.parseInt(etn_CapturasJilguero.getText().toString());
        int capturasLugano = Integer.parseInt(etn_CapturasLugano.getText().toString());
        int capturasPardilloComun = Integer.parseInt(etn_CapturasPardilloComun.getText().toString());
        int capturasPicogordo = Integer.parseInt(etn_CapturasPicogordo.getText().toString());
        int capturasPinzonComun = Integer.parseInt(etn_CapturasPinzonComun.getText().toString());
        int capturasPinzonReal = Integer.parseInt(etn_CapturasPinzonReal.getText().toString());
        int capturasPiquituerto = Integer.parseInt(etn_CapturasPiquituerto.getText().toString());
        int capturasVerdecillo = Integer.parseInt(etn_CapturasVerdecillo.getText().toString());
        int capturasVerdonComun = Integer.parseInt(etn_CapturasVerdonComun.getText().toString());
        int capturasVerdonSerrano = Integer.parseInt(etn_CapturasVerdonSerrano.getText().toString());

        String observaciones = et_Observaciones.getText().toString();

        metodosCaptura = new MetodosCaptura(numeroMallas, longitudRed, coto,ControlAgentes, reclamosCamachuelo, cimbelesCamachuelo, capturasCamachuelo, reclamosJilguero, cimbelesJilguero, capturasJilguero, reclamosLugano, cimbelesLugano, capturasLugano, reclamosPardilloComun, cimbelesPardilloComun, capturasPardilloComun, reclamosPicogordo, cimbelesPicogordo, capturasPicogordo, reclamosPinzonComun, cimbelesPinzonComun, capturasPinzonComun, reclamosPinzonReal, cimbelesPinzonReal, capturasPinzonReal, reclamosPiquituerto, cimbelesPiquituerto, capturasPiquituerto, reclamosVerdecillo, cimbelesVerdecillo, capturasVerdecillo, reclamosVerdonComun, cimbelesVerdonComun, capturasVerdonComun, reclamosVerdonSerrano, cimbelesVerdonSerrano, capturasVerdonSerrano, observaciones);
    }

    private void asignarControlAgentes() {
        if (rb_SiControl.isChecked()){
            if (cb_ControlSeprona.isChecked()) ControlAgentes.add(1);
            if (cb_ControlForestales.isChecked()) ControlAgentes.add(2);
            if (cb_ControlPoliciaMunicipal.isChecked()) ControlAgentes.add(3);
            if (cb_ControlPoliciaNacional.isChecked()) ControlAgentes.add(4);
            if (cb_ControlOtros.isChecked()) ControlAgentes.add(5);
        }
        if (rb_NoControl.isChecked()) ControlAgentes.add(0);
    }

    private boolean comprobarCampos() {
        boolean comprobado =  true;

        if (TextUtils.isEmpty(etn_NumeroMallas.getText().toString())) comprobado = false;
        if (TextUtils.isEmpty(etn_LongitudRed.getText().toString())) comprobado = false;

        if (rbg_Coto.getCheckedRadioButtonId()==-1) comprobado =false;
        if (rbg_ControlAgentes.getCheckedRadioButtonId()==-1)
            comprobado=false;
        if (rbg_ControlAgentes.getCheckedRadioButtonId()!=-1)
            if (rbg_ControlAgentes.getCheckedRadioButtonId()==R.id.rb_SiControlAgentes){
                if (
                    !cb_ControlOtros.isChecked()
                    &&!cb_ControlPoliciaNacional.isChecked()
                    &&!cb_ControlPoliciaMunicipal.isChecked()
                    &&!cb_ControlForestales.isChecked()
                    &&!cb_ControlSeprona.isChecked()
                )
                comprobado=false;
            }
        return comprobado;
    }

    private void guardarParametros(Intent actividadDestino) {

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

    private void imprimirDatosRecibidos() {
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
