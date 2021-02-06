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

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.Serializable;
import java.util.ArrayList;

public class Pantalla_Metodos_Captura extends Activity implements View.OnClickListener{

    private Button btn_Guardar, btn_Volver;
    private EditText etn_NumeroMallas, etn_LongitudRed;

    private EditText etn_CimbelesCamachuelo, etn_ReclamosCamachuelo, etn_CapturasCamachueloM, etn_CapturasCamachueloH;
    private EditText etn_CimbelesJilguero, etn_ReclamosJilguero, etn_CapturasJilgueroM, etn_CapturasJilgueroH;
    private EditText etn_CimbelesLugano, etn_ReclamosLugano, etn_CapturasLuganoM, etn_CapturasLuganoH;
    private EditText etn_CimbelesPardilloComun, etn_ReclamosPardilloComun, etn_CapturasPardilloComunM, etn_CapturasPardilloComunH;
    private EditText etn_CimbelesPicogordo, etn_ReclamosPicogordo, etn_CapturasPicogordoM, etn_CapturasPicogordoH;
    private EditText etn_CimbelesPinzonComun, etn_ReclamosPinzonComun, etn_CapturasPinzonComunM, etn_CapturasPinzonComunH;
    private EditText etn_CimbelesPinzonReal, etn_ReclamosPinzonReal, etn_CapturasPinzonRealM, etn_CapturasPinzonRealH;
    private EditText etn_CimbelesPiquituerto, etn_ReclamosPiquituerto, etn_CapturasPiquituertoM, etn_CapturasPiquituertoH;
    private EditText etn_CimbelesVerdecillo, etn_ReclamosVerdecillo, etn_CapturasVerdecilloM, etn_CapturasVerdecilloH;
    private EditText etn_CimbelesVerderonComun, etn_ReclamosVerderonComun, etn_CapturasVerderonComunM, etn_CapturasVerderonComunH;
    private EditText etn_CimbelesVerderonSerrano, etn_ReclamosVerderonSerrano, etn_CapturasVerderonSerranoM, etn_CapturasVerderonSerranoH;

    private EditText et_Observaciones;

    private RadioGroup rbg_ControlAgentes,rbg_Coto;
    private RadioButton rb_SiControl, rb_NoControl, rb_CotoSI, rb_CotoNO;
    private CheckBox cb_ControlSeprona, cb_ControlForestales, cb_ControlPoliciaMunicipal, cb_ControlPoliciaNacional, cb_ControlOtros;

    private ArrayList<Integer> ControlAgentes = new ArrayList<>();

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

        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            recuperarDatosRecibidos(datos);

            System.out.println("Datos recibidos en Metodos de Captura");
            imprimirDatosRecibidos();
        }

        setContentView(R.layout.pantalla_metodos_captura);
        iniciarComponentes();

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

        etn_CimbelesCamachuelo.setText(String.valueOf(metodosCaptura.getCimbelesCamachuelo()));
        etn_ReclamosCamachuelo.setText(String.valueOf(metodosCaptura.getReclamosCamachuelo()));
        etn_CapturasCamachueloM.setText(String.valueOf(metodosCaptura.getCapturasCamachueloM()));
        etn_CapturasCamachueloH.setText(String.valueOf(metodosCaptura.getCapturasCamachueloH()));

        etn_CimbelesJilguero.setText(String.valueOf(metodosCaptura.getCimbelesJilguero()));
        etn_ReclamosJilguero.setText(String.valueOf(metodosCaptura.getReclamosJilguero()));
        etn_CapturasJilgueroM.setText(String.valueOf(metodosCaptura.getCapturasJilgueroM()));
        etn_CapturasJilgueroH.setText(String.valueOf(metodosCaptura.getCapturasJilgueroH()));

        etn_CimbelesLugano.setText(String.valueOf(metodosCaptura.getCimbelesLugano()));
        etn_ReclamosLugano.setText(String.valueOf(metodosCaptura.getReclamosLugano()));
        etn_CapturasLuganoM.setText(String.valueOf(metodosCaptura.getCapturasLuganoM()));
        etn_CapturasLuganoH.setText(String.valueOf(metodosCaptura.getCapturasLuganoH()));

        etn_CimbelesPardilloComun.setText(String.valueOf(metodosCaptura.getCimbelesPardilloComun()));
        etn_ReclamosPardilloComun.setText(String.valueOf(metodosCaptura.getReclamosPardilloComun()));
        etn_CapturasPardilloComunM.setText(String.valueOf(metodosCaptura.getCapturasPardilloComunM()));
        etn_CapturasPardilloComunH.setText(String.valueOf(metodosCaptura.getCapturasPardilloComunH()));

        etn_CimbelesPicogordo.setText(String.valueOf(metodosCaptura.getCimbelesPicogordo()));
        etn_ReclamosPicogordo.setText(String.valueOf(metodosCaptura.getReclamosPicogordo()));
        etn_CapturasPicogordoM.setText(String.valueOf(metodosCaptura.getCapturasPicogordoM()));
        etn_CapturasPicogordoH.setText(String.valueOf(metodosCaptura.getCapturasPicogordoH()));

        etn_CimbelesPinzonComun.setText(String.valueOf(metodosCaptura.getCimbelesPinzonComun()));
        etn_ReclamosPinzonComun.setText(String.valueOf(metodosCaptura.getReclamosPinzonComun()));
        etn_CapturasPinzonComunM.setText(String.valueOf(metodosCaptura.getCapturasPinzonComunM()));
        etn_CapturasPinzonComunH.setText(String.valueOf(metodosCaptura.getCapturasPinzonComunH()));

        etn_CimbelesPinzonReal.setText(String.valueOf(metodosCaptura.getCimbelesPinzonReal()));
        etn_ReclamosPinzonReal.setText(String.valueOf(metodosCaptura.getReclamosPinzonReal()));
        etn_CapturasPinzonRealM.setText(String.valueOf(metodosCaptura.getCapturasPinzonRealM()));
        etn_CapturasPinzonRealH.setText(String.valueOf(metodosCaptura.getCapturasPinzonRealH()));

        etn_CimbelesPiquituerto.setText(String.valueOf(metodosCaptura.getCimbelesPiquituerto()));
        etn_ReclamosPiquituerto.setText(String.valueOf(metodosCaptura.getReclamosPiquituerto()));
        etn_CapturasPiquituertoM.setText(String.valueOf(metodosCaptura.getCapturasPiquituertoM()));
        etn_CapturasPiquituertoH.setText(String.valueOf(metodosCaptura.getCapturasPiquituertoH()));

        etn_CimbelesVerdecillo.setText(String.valueOf(metodosCaptura.getCimbelesVerdecillo()));
        etn_ReclamosVerdecillo.setText(String.valueOf(metodosCaptura.getReclamosVerdecillo()));
        etn_CapturasVerdecilloM.setText(String.valueOf(metodosCaptura.getCapturasVerdecilloM()));
        etn_CapturasVerdecilloH.setText(String.valueOf(metodosCaptura.getCapturasVerdecilloH()));

        etn_CimbelesVerderonComun.setText(String.valueOf(metodosCaptura.getCimbelesVerderonComun()));
        etn_ReclamosVerderonComun.setText(String.valueOf(metodosCaptura.getReclamosVerderonComun()));
        etn_CapturasVerderonComunM.setText(String.valueOf(metodosCaptura.getCapturasVerderonComunM()));
        etn_CapturasVerderonComunH.setText(String.valueOf(metodosCaptura.getCapturasVerderonComunH()));

        etn_CimbelesVerderonSerrano.setText(String.valueOf(metodosCaptura.getCimbelesVerderonSerrano()));
        etn_ReclamosVerderonSerrano.setText(String.valueOf(metodosCaptura.getReclamosVerderonSerrano()));
        etn_CapturasVerderonSerranoM.setText(String.valueOf(metodosCaptura.getCapturasVerderonSerranoM()));
        etn_CapturasVerderonSerranoH.setText(String.valueOf(metodosCaptura.getCapturasVerderonSerranoH()));

        //Capturas
        /*
        etn_CapturasCamachuelo.setText(String.valueOf(metodosCaptura.getCapturasCamachueloM()));
        etn_CapturasJilguero.setText(String.valueOf(metodosCaptura.getCapturasJilguero()));
        etn_CapturasLugano.setText(String.valueOf(metodosCaptura.getCapturasLugano()));
        etn_CapturasPardilloComun.setText(String.valueOf(metodosCaptura.getCapturasPardilloComun()));
        etn_CapturasPicogordo.setText(String.valueOf(metodosCaptura.getCapturasPicogordo()));
        etn_CapturasPinzonComun.setText(String.valueOf(metodosCaptura.getCapturasPinzonComun()));
        etn_CapturasPinzonReal.setText(String.valueOf(metodosCaptura.getCapturasPinzonReal()));
        etn_CapturasPiquituerto.setText(String.valueOf(metodosCaptura.getCapturasPiquituerto()));
        etn_CapturasVerdecillo.setText(String.valueOf(metodosCaptura.getCapturasVerdecillo()));
        etn_CapturasVerdonComun.setText(String.valueOf(metodosCaptura.getCapturasVerdonComun()));
        etn_CapturasVerdonSerrano.setText(String.valueOf(metodosCaptura.getCapturasVerdonSerrano()));*/

        et_Observaciones.setText(metodosCaptura.getObservaciones());
    }

    private void llenarControlAgentes() {
        if (!metodosCaptura.getControlAgentes().get(0)){
            rb_NoControl.setChecked(true);
        } else {
            rb_SiControl.setChecked(true);
            cb_ControlSeprona.setChecked(metodosCaptura.getControlAgentes().get(1));
            cb_ControlForestales.setClickable(metodosCaptura.getControlAgentes().get(2));
            cb_ControlOtros.setClickable(metodosCaptura.getControlAgentes().get(3));
            cb_ControlPoliciaMunicipal.setClickable(metodosCaptura.getControlAgentes().get(4));
            cb_ControlPoliciaNacional.setClickable(metodosCaptura.getControlAgentes().get(5));
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

        //EditText Reclamos
        etn_ReclamosCamachuelo = findViewById(R.id.etn_ReclamosCamachuelo);
        etn_ReclamosJilguero = findViewById(R.id.etn_ReclamosJilguero);
        etn_ReclamosLugano = findViewById(R.id.etn_ReclamosLugano);
        etn_ReclamosPardilloComun = findViewById(R.id.etn_ReclamosPardilloComun);
        etn_ReclamosPicogordo = findViewById(R.id.etn_ReclamosPicogordo);
        etn_ReclamosPinzonComun = findViewById(R.id.etn_ReclamosPinzonComun);
        etn_ReclamosPinzonReal = findViewById(R.id.etn_ReclamosPinzonReal);
        etn_ReclamosPiquituerto = findViewById(R.id.etn_ReclamosPiquituerto);
        etn_ReclamosVerdecillo = findViewById(R.id.etn_ReclamosVerdecillo);
        etn_ReclamosVerderonComun = findViewById(R.id.etn_ReclamosVerderonComun);
        etn_ReclamosVerderonSerrano = findViewById(R.id.etn_ReclamosVerderonSerrano);

        //Spinners Cimbeles
        etn_CimbelesCamachuelo = findViewById(R.id.etn_CimbelesCamachuelo);
        etn_CimbelesJilguero = findViewById(R.id.etn_CimbelesJilguero);
        etn_CimbelesLugano = findViewById(R.id.etn_CimbelesLugano);
        etn_CimbelesPardilloComun = findViewById(R.id.etn_CimbelesPardilloComun);
        etn_CimbelesPicogordo = findViewById(R.id.etn_CimbelesPicogordo);
        etn_CimbelesPinzonComun = findViewById(R.id.etn_CimbelesPinzonComun);
        etn_CimbelesPinzonReal = findViewById(R.id.etn_CimbelesPinzonReal);
        etn_CimbelesPiquituerto = findViewById(R.id.etn_CimbelesPiquituerto);
        etn_CimbelesVerdecillo = findViewById(R.id.etn_CimbelesVerdecillo);
        etn_CimbelesVerderonComun = findViewById(R.id.etn_CimbelesVerderonComun);
        etn_CimbelesVerderonSerrano = findViewById(R.id.etn_CimbelesVerderonSerrano);

        //EditText Capturas
        etn_CapturasCamachueloM = findViewById(R.id.etn_CapturasCamachueloM);
        etn_CapturasCamachueloH = findViewById(R.id.etn_CapturasCamachueloH);
        etn_CapturasJilgueroM = findViewById(R.id.etn_CapturasJilgueroM);
        etn_CapturasJilgueroH = findViewById(R.id.etn_CapturasJilgueroH);
        etn_CapturasLuganoM = findViewById(R.id.etn_CapturasLuganoM);
        etn_CapturasLuganoH = findViewById(R.id.etn_CapturasLuganoH);
        etn_CapturasPardilloComunM = findViewById(R.id.etn_CapturasPardilloComunM);
        etn_CapturasPardilloComunH = findViewById(R.id.etn_CapturasPardilloComunH);
        etn_CapturasPicogordoM = findViewById(R.id.etn_CapturasPicogordoM);
        etn_CapturasPicogordoH = findViewById(R.id.etn_CapturasPicogordoH);
        etn_CapturasPinzonComunM = findViewById(R.id.etn_CapturasPinzonComunM);
        etn_CapturasPinzonComunH = findViewById(R.id.etn_CapturasPinzonComunH);
        etn_CapturasPinzonRealM = findViewById(R.id.etn_CapturasPinzonRealM);
        etn_CapturasPinzonRealH = findViewById(R.id.etn_CapturasPinzonRealH);
        etn_CapturasPiquituertoM = findViewById(R.id.etn_CapturasPiquituertoM);
        etn_CapturasPiquituertoH = findViewById(R.id.etn_CapturasPiquituertoH);
        etn_CapturasVerdecilloM = findViewById(R.id.etn_CapturasVerdecilloM);
        etn_CapturasVerdecilloH = findViewById(R.id.etn_CapturasVerdecilloH);
        etn_CapturasVerderonComunM = findViewById(R.id.etn_CapturasVerderonComunM);
        etn_CapturasVerderonComunH = findViewById(R.id.etn_CapturasVerderonComunH);
        etn_CapturasVerderonSerranoM = findViewById(R.id.etn_CapturasVerderonSerranoM);
        etn_CapturasVerderonSerranoH = findViewById(R.id.etn_CapturasVerderonSerranoH);

        et_Observaciones = (EditText) findViewById(R.id.et_ObservacionesMetodos);
        btn_Guardar = (Button) findViewById(R.id.btn_GuardarMetodos);
        btn_Volver = (Button) findViewById(R.id.btn_VolverMetodos);
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

        System.out.println("1."+maxRecCamachuelo);
        int numeroMallas = Integer.parseInt(etn_NumeroMallas.getText().toString());
        int longitudRed = Integer.parseInt(etn_LongitudRed.getText().toString());

        asignarControlAgentes();
        boolean coto = false;
        if (rbg_Coto.getCheckedRadioButtonId()==R.id.rb_CotoSI) {
            coto = true;
        }


        //Spinner Reclamos


        //EditText Capturas
        /*
        int capturasCamachueloM = Integer.parseInt(etn_CapturasCamachueloM.getText().toString());
        int capturasJilguero = Integer.parseInt(etn_CapturasJilguero.getText().toString());
        int capturasLugano = Integer.parseInt(etn_CapturasLugano.getText().toString());
        int capturasPardilloComun = Integer.parseInt(etn_CapturasPardilloComun.getText().toString());
        int capturasPicogordo = Integer.parseInt(etn_CapturasPicogordo.getText().toString());
        int capturasPinzonComun = Integer.parseInt(etn_CapturasPinzonComun.getText().toString());
        int capturasPinzonReal = Integer.parseInt(etn_CapturasPinzonReal.getText().toString());
        int capturasPiquituerto = Integer.parseInt(etn_CapturasPiquituerto.getText().toString());
        int capturasVerdecillo = Integer.parseInt(etn_CapturasVerdecillo.getText().toString());
        int capturasVerdonComun = Integer.parseInt(etn_CapturasVerdonComun.getText().toString());
        int capturasVerdonSerrano = Integer.parseInt(etn_CapturasVerdonSerrano.getText().toString());*/

        String observaciones = et_Observaciones.getText().toString();

        //metodosCaptura = new MetodosCaptura(numeroMallas, longitudRed, coto,ControlAgentes, reclamosCamachuelo, cimbelesCamachuelo, capturasCamachuelo, reclamosJilguero, cimbelesJilguero, capturasJilguero, reclamosLugano, cimbelesLugano, capturasLugano, reclamosPardilloComun, cimbelesPardilloComun, capturasPardilloComun, reclamosPicogordo, cimbelesPicogordo, capturasPicogordo, reclamosPinzonComun, cimbelesPinzonComun, capturasPinzonComun, reclamosPinzonReal, cimbelesPinzonReal, capturasPinzonReal, reclamosPiquituerto, cimbelesPiquituerto, capturasPiquituerto, reclamosVerdecillo, cimbelesVerdecillo, capturasVerdecillo, reclamosVerdonComun, cimbelesVerdonComun, capturasVerdonComun, reclamosVerdonSerrano, cimbelesVerdonSerrano, capturasVerdonSerrano, observaciones);
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

        comprobado = comprobarCimbeles();
        comprobado = comprobarReclamos();
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

    private boolean comprobarReclamos() {
        boolean reclamoComprobado = false;


        return reclamoComprobado;
    }

    private boolean comprobarCimbeles() {

        return true;
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
        limites = (Limites) datos.getSerializable("LIMITES");
    }

    private void imprimirDatosRecibidos() {
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

}
