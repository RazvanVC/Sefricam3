package com.sefricam.sefricam4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Pantalla_Metodos_Captura extends Activity implements View.OnClickListener{

    private Button btn_Guardar, btn_Volver;
    private EditText etn_NumeroMallas, etn_LongitudRed, etn_NumeroParticipantes;

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

    private final ArrayList<Boolean> ControlAgentes = new ArrayList<>();

    //Parametros
    private Envio envio;
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
        }

        setContentView(R.layout.pantalla_metodos_captura);
        iniciarComponentes();

        iniciarOnClickListener();


        if (mCapturasCompletado){
            cargarDatos();
        }


    }



    private void iniciarOnClickListener() {
        rb_SiControl.setOnClickListener(this);
        rb_NoControl.setOnClickListener(this);
        btn_Guardar.setOnClickListener(this);
        btn_Volver.setOnClickListener(this);
    }

    private void iniciarComponentes() {

        etn_NumeroParticipantes = findViewById(R.id.etn_NumeroParticipantes);
        etn_LongitudRed = findViewById(R.id.etn_LongitudRed);
        etn_NumeroMallas = findViewById(R.id.etn_NumeroMallas);

        rbg_Coto = findViewById(R.id.rbg_Coto);
        rb_CotoSI = findViewById(R.id.rb_CotoSI);
        rb_CotoNO = findViewById(R.id.rb_CotoNO);

        rbg_ControlAgentes = findViewById(R.id.rbg_ControlAgentes);
        rb_NoControl = findViewById(R.id.rb_NoControlAgentes);
        rb_SiControl = findViewById(R.id.rb_SiControlAgentes);

        cb_ControlSeprona = findViewById(R.id.cb_ControlAgentesSeprona);
        cb_ControlForestales = findViewById(R.id.cb_ControlAgentesForestales);
        cb_ControlPoliciaNacional = findViewById(R.id.cb_ControlAgentesPoliciaNacional);
        cb_ControlPoliciaMunicipal = findViewById(R.id.cb_ControlAgentesPoliciaMunicipal);
        cb_ControlOtros = findViewById(R.id.cb_ControlAgentesOtros);

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

        et_Observaciones = findViewById(R.id.et_ObservacionesMetodos);
        btn_Guardar = findViewById(R.id.btn_GuardarMetodos);
        btn_Volver = findViewById(R.id.btn_VolverMetodos);
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
                envio.setMCapturaCompletado(true);
                Intent activity = new Intent(this, Pantalla_Menu_Metodos_Y_Captura.class);
                guardarParametros(activity);

                startActivity(activity);
                finish();
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
        int reclamosCamachuelo;
        int reclamosJilguero;
        int reclamosLugano;
        int reclamosPardilloComun;
        int reclamosPicogordo;
        int reclamosPinzonComun;
        int reclamosPinzonReal;
        int reclamosPiquituerto;
        int reclamosVerdecillo;
        int reclamosVerderonComun;
        int reclamosVerderonSerrano;

        int cimbelesCamachuelo;
        int cimbelesJilguero;
        int cimbelesLugano;
        int cimbelesPardilloComun;
        int cimbelesPicogordo;
        int cimbelesPinzonComun;
        int cimbelesPinzonReal;
        int cimbelesPiquituerto;
        int cimbelesVerdecillo;
        int cimbelesVerderonComun;
        int cimbelesVerderonSerrano;

        int capturasCamachueloH;
        int capturasJilgueroH;
        int capturasLuganoH;
        int capturasPardilloComunH;
        int capturasPicogordoH;
        int capturasPinzonComunH;
        int capturasPinzonRealH;
        int capturasPiquituertoH;
        int capturasVerdecilloH;
        int capturasVerderonComunH;
        int capturasVerderonSerranoH;

        int capturasCamachueloM;
        int capturasJilgueroM;
        int capturasLuganoM;
        int capturasPardilloComunM;
        int capturasPicogordoM;
        int capturasPinzonComunM;
        int capturasPinzonRealM;
        int capturasPiquituertoM;
        int capturasVerdecilloM;
        int capturasVerderonComunM;
        int capturasVerderonSerranoM;
        int numeroMallas;
        double longitudRed;

        int numeroParticipantes = Integer.parseInt(etn_NumeroParticipantes.getText().toString());

        if (etn_NumeroMallas.getText().toString().isEmpty()) numeroMallas = 0;
        else numeroMallas = Integer.parseInt(etn_NumeroMallas.getText().toString());

        if (etn_LongitudRed.getText().toString().isEmpty()) longitudRed = 0;
        else longitudRed = Double.parseDouble(etn_LongitudRed.getText().toString());

        asignarControlAgentes();
        boolean coto = false;
        if (rbg_Coto.getCheckedRadioButtonId()==R.id.rb_CotoSI) {
            coto = true;
        }

        //Asignacion Reclamos
        if (etn_ReclamosCamachuelo.getText().toString().isEmpty()){
            reclamosCamachuelo = 0;
        } else reclamosCamachuelo = parseInt(etn_ReclamosCamachuelo.getText().toString());

        if (etn_ReclamosJilguero.getText().toString().isEmpty()){
            reclamosJilguero = 0;
        } else reclamosJilguero = parseInt(etn_ReclamosJilguero.getText().toString());

        if (etn_ReclamosLugano.getText().toString().isEmpty()){
            reclamosLugano = 0;
        } else reclamosLugano = parseInt(etn_ReclamosLugano.getText().toString());

        if (etn_ReclamosPardilloComun.getText().toString().isEmpty()){
            reclamosPardilloComun = 0;
        } else reclamosPardilloComun = parseInt(etn_ReclamosPardilloComun.getText().toString());

        if (etn_ReclamosPicogordo.getText().toString().isEmpty()){
            reclamosPicogordo = 0;
        } else reclamosPicogordo = parseInt(etn_ReclamosPicogordo.getText().toString());

        if (etn_ReclamosPinzonComun.getText().toString().isEmpty()){
            reclamosPinzonComun = 0;
        } else reclamosPinzonComun = parseInt(etn_ReclamosPinzonComun.getText().toString());

        if (etn_ReclamosPinzonReal.getText().toString().isEmpty()){
            reclamosPinzonReal = 0;
        } else reclamosPinzonReal = parseInt(etn_ReclamosPinzonReal.getText().toString());

        if (etn_ReclamosPiquituerto.getText().toString().isEmpty()){
            reclamosPiquituerto = 0;
        } else reclamosPiquituerto = parseInt(etn_ReclamosPiquituerto.getText().toString());

        if (etn_ReclamosVerdecillo.getText().toString().isEmpty()){
            reclamosVerdecillo = 0;
        } else reclamosVerdecillo = parseInt(etn_ReclamosVerdecillo.getText().toString());

        if (etn_ReclamosVerderonComun.getText().toString().isEmpty()){
            reclamosVerderonComun = 0;
        } else reclamosVerderonComun = parseInt(etn_ReclamosVerderonComun.getText().toString());

        if (etn_ReclamosVerderonSerrano.getText().toString().isEmpty()){
            reclamosVerderonSerrano = 0;
        } else reclamosVerderonSerrano = parseInt(etn_ReclamosVerderonSerrano.getText().toString());

        //Asignacion Cimbeles
        if (etn_CimbelesCamachuelo.getText().toString().isEmpty()){
            cimbelesCamachuelo = 0;
        } else cimbelesCamachuelo = parseInt(etn_CimbelesCamachuelo.getText().toString());

        if (etn_CimbelesJilguero.getText().toString().isEmpty()){
            cimbelesJilguero = 0;
        } else cimbelesJilguero = parseInt(etn_CimbelesJilguero.getText().toString());

        if (etn_CimbelesLugano.getText().toString().isEmpty()){
            cimbelesLugano = 0;
        } else cimbelesLugano = parseInt(etn_CimbelesLugano.getText().toString());

        if (etn_CimbelesPardilloComun.getText().toString().isEmpty()){
            cimbelesPardilloComun = 0;
        } else cimbelesPardilloComun = parseInt(etn_CimbelesPardilloComun.getText().toString());

        if (etn_CimbelesPicogordo.getText().toString().isEmpty()){
            cimbelesPicogordo = 0;
        } else cimbelesPicogordo = parseInt(etn_CimbelesPicogordo.getText().toString());

        if (etn_CimbelesPinzonComun.getText().toString().isEmpty()){
            cimbelesPinzonComun = 0;
        } else cimbelesPinzonComun = parseInt(etn_CimbelesPinzonComun.getText().toString());

        if (etn_CimbelesPinzonReal.getText().toString().isEmpty()){
            cimbelesPinzonReal = 0;
        } else cimbelesPinzonReal = parseInt(etn_CimbelesPinzonReal.getText().toString());

        if (etn_CimbelesPiquituerto.getText().toString().isEmpty()){
            cimbelesPiquituerto = 0;
        } else cimbelesPiquituerto = parseInt(etn_CimbelesPiquituerto.getText().toString());

        if (etn_CimbelesVerdecillo.getText().toString().isEmpty()){
            cimbelesVerdecillo = 0;
        } else cimbelesVerdecillo = parseInt(etn_CimbelesVerdecillo.getText().toString());

        if (etn_CimbelesVerderonComun.getText().toString().isEmpty()){
            cimbelesVerderonComun = 0;
        } else cimbelesVerderonComun = parseInt(etn_CimbelesVerderonComun.getText().toString());

        if (etn_CimbelesVerderonSerrano.getText().toString().isEmpty()){
            cimbelesVerderonSerrano = 0;
        } else cimbelesVerderonSerrano = parseInt(etn_CimbelesVerderonSerrano.getText().toString());

        //EditText Capturas
        if (etn_CapturasCamachueloM.getText().toString().isEmpty()){
            capturasCamachueloM = 0;
        } else capturasCamachueloM = Integer.parseInt(etn_CapturasCamachueloM.getText().toString());

        if (etn_CapturasJilgueroM.getText().toString().isEmpty()){
            capturasJilgueroM = 0;
        } else capturasJilgueroM = Integer.parseInt(etn_CapturasJilgueroM.getText().toString());

        if (etn_CapturasLuganoM.getText().toString().isEmpty()){
            capturasLuganoM = 0;
        } else capturasLuganoM = Integer.parseInt(etn_CapturasLuganoM.getText().toString());

        if (etn_CapturasPardilloComunM.getText().toString().isEmpty()){
            capturasPardilloComunM = 0;
        } else capturasPardilloComunM = Integer.parseInt(etn_CapturasPardilloComunM.getText().toString());

        if (etn_CapturasPicogordoM.getText().toString().isEmpty()){
            capturasPicogordoM = 0;
        } else capturasPicogordoM = Integer.parseInt(etn_CapturasPicogordoM.getText().toString());

        if (etn_CapturasPinzonComunM.getText().toString().isEmpty()){
            capturasPinzonComunM = 0;
        } else capturasPinzonComunM = Integer.parseInt(etn_CapturasPinzonComunM.getText().toString());

        if (etn_CapturasPinzonRealM.getText().toString().isEmpty()){
            capturasPinzonRealM = 0;
        } else capturasPinzonRealM = Integer.parseInt(etn_CapturasPinzonRealM.getText().toString());

        if (etn_CapturasPiquituertoM.getText().toString().isEmpty()){
            capturasPiquituertoM = 0;
        } else capturasPiquituertoM = Integer.parseInt(etn_CapturasPiquituertoM.getText().toString());

        if (etn_CapturasVerdecilloM.getText().toString().isEmpty()){
            capturasVerdecilloM = 0;
        } else capturasVerdecilloM = Integer.parseInt(etn_CapturasVerdecilloM.getText().toString());

        if (etn_CapturasVerderonComunM.getText().toString().isEmpty()){
            capturasVerderonComunM = 0;
        } else capturasVerderonComunM = Integer.parseInt(etn_CapturasVerderonComunM.getText().toString());

        if (etn_CapturasVerderonSerranoM.getText().toString().isEmpty()){
            capturasVerderonSerranoM = 0;
        } else capturasVerderonSerranoM = Integer.parseInt(etn_CapturasVerderonSerranoM.getText().toString());

        //EditText Capturas
        if (etn_CapturasCamachueloH.getText().toString().isEmpty()){
            capturasCamachueloH = 0;
        } else capturasCamachueloH = Integer.parseInt(etn_CapturasCamachueloH.getText().toString());

        if (etn_CapturasJilgueroH.getText().toString().isEmpty()){
            capturasJilgueroH = 0;
        } else capturasJilgueroH = Integer.parseInt(etn_CapturasJilgueroH.getText().toString());

        if (etn_CapturasLuganoH.getText().toString().isEmpty()){
            capturasLuganoH = 0;
        } else capturasLuganoH = Integer.parseInt(etn_CapturasLuganoH.getText().toString());

        if (etn_CapturasPardilloComunH.getText().toString().isEmpty()){
            capturasPardilloComunH = 0;
        } else capturasPardilloComunH = Integer.parseInt(etn_CapturasPardilloComunH.getText().toString());

        if (etn_CapturasPicogordoH.getText().toString().isEmpty()){
            capturasPicogordoH = 0;
        } else capturasPicogordoH = Integer.parseInt(etn_CapturasPicogordoH.getText().toString());

        if (etn_CapturasPinzonComunH.getText().toString().isEmpty()){
            capturasPinzonComunH = 0;
        } else capturasPinzonComunH = Integer.parseInt(etn_CapturasPinzonComunH.getText().toString());

        if (etn_CapturasPinzonRealH.getText().toString().isEmpty()){
            capturasPinzonRealH = 0;
        } else capturasPinzonRealH = Integer.parseInt(etn_CapturasPinzonRealH.getText().toString());

        if (etn_CapturasPiquituertoH.getText().toString().isEmpty()){
            capturasPiquituertoH = 0;
        } else capturasPiquituertoH = Integer.parseInt(etn_CapturasPiquituertoH.getText().toString());

        if (etn_CapturasVerdecilloH.getText().toString().isEmpty()){
            capturasVerdecilloH = 0;
        } else capturasVerdecilloH = Integer.parseInt(etn_CapturasVerdecilloH.getText().toString());

        if (etn_CapturasVerderonComunH.getText().toString().isEmpty()){
            capturasVerderonComunH = 0;
        } else capturasVerderonComunH = Integer.parseInt(etn_CapturasVerderonComunH.getText().toString());

        if (etn_CapturasVerderonSerranoH.getText().toString().isEmpty()){
            capturasVerderonSerranoH = 0;
        } else capturasVerderonSerranoH = Integer.parseInt(etn_CapturasVerderonSerranoH.getText().toString());


        String observaciones = et_Observaciones.getText().toString();

        envio.setMetodosCaptura(new MetodosCaptura(numeroParticipantes, numeroMallas, longitudRed, coto, ControlAgentes,
                reclamosCamachuelo, cimbelesCamachuelo, capturasCamachueloM, capturasCamachueloH,
                reclamosJilguero, cimbelesJilguero, capturasJilgueroM, capturasJilgueroH,
                reclamosLugano, cimbelesLugano, capturasLuganoM, capturasLuganoH,
                reclamosPardilloComun, cimbelesPardilloComun, capturasPardilloComunM, capturasPardilloComunH,
                reclamosPicogordo, cimbelesPicogordo, capturasPicogordoM, capturasPicogordoH,
                reclamosPinzonComun, cimbelesPinzonComun, capturasPinzonComunM, capturasPinzonComunH,
                reclamosPinzonReal, cimbelesPinzonReal, capturasPinzonRealM, capturasPinzonRealH,
                reclamosPiquituerto, cimbelesPiquituerto, capturasPiquituertoM, capturasPiquituertoH,
                reclamosVerdecillo, cimbelesVerdecillo, capturasVerdecilloM, capturasVerdecilloH,
                reclamosVerderonComun, cimbelesVerderonComun, capturasVerderonComunM, capturasVerderonComunH,
                reclamosVerderonSerrano, cimbelesVerderonSerrano, capturasVerderonSerranoM, capturasVerderonSerranoH,
                observaciones));
    }

    private void asignarControlAgentes() {
        if (rb_SiControl.isChecked())
            ControlAgentes.add(true);
        if (rb_NoControl.isChecked())
            ControlAgentes.add(false);

        ControlAgentes.add(cb_ControlSeprona.isChecked());
        ControlAgentes.add(cb_ControlForestales.isChecked());
        ControlAgentes.add(cb_ControlPoliciaMunicipal.isChecked());
        ControlAgentes.add(cb_ControlPoliciaNacional.isChecked());
        ControlAgentes.add(cb_ControlOtros.isChecked());
    }

    private boolean comprobarCampos() {


        if (TextUtils.isEmpty(etn_NumeroParticipantes.getText().toString())) return false;

        if (TextUtils.isEmpty(etn_NumeroMallas.getText().toString())) return false;

        if (TextUtils.isEmpty(etn_LongitudRed.getText().toString())) return false;

        if (!comprobarCimbeles()) return false;

        if (!comprobarReclamos()) return false;


        if (rbg_Coto.getCheckedRadioButtonId()==-1) return false;


        if (rbg_ControlAgentes.getCheckedRadioButtonId()==-1) return false;
        if (rbg_ControlAgentes.getCheckedRadioButtonId()!=-1) {
            if (rbg_ControlAgentes.getCheckedRadioButtonId() == R.id.rb_SiControlAgentes) {
                return cb_ControlOtros.isChecked()
                        || cb_ControlPoliciaNacional.isChecked()
                        || cb_ControlPoliciaMunicipal.isChecked()
                        || cb_ControlForestales.isChecked()
                        || cb_ControlSeprona.isChecked();
            }
        }
        return true;
    }

    private boolean comprobarReclamos() {

        if (!etn_ReclamosCamachuelo.getText().toString().isEmpty()){
            if (parseInt(etn_ReclamosCamachuelo.getText().toString())>limites.getMaxRecCamachuelo()) {
                Toast.makeText(this, "Los reclamos de Camachuelo no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_ReclamosJilguero.getText().toString().isEmpty()){
            if (parseInt(etn_ReclamosJilguero.getText().toString())>limites.getMaxRecJilguero()) {
                Toast.makeText(this, "Los reclamos de Jilguero no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_ReclamosLugano.getText().toString().isEmpty()) {
            if (parseInt(etn_ReclamosLugano.getText().toString()) > limites.getMaxRecLugano()) {
                Toast.makeText(this, "Los reclamos de Lugano no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_ReclamosPardilloComun.getText().toString().isEmpty()){
            if (parseInt(etn_ReclamosPardilloComun.getText().toString())>limites.getMaxRecPardComun()) {
                Toast.makeText(this, "Los reclamos de PardilloComun no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_ReclamosPicogordo.getText().toString().isEmpty()){
            if (parseInt(etn_ReclamosPicogordo.getText().toString())>limites.getMaxRecPicogordo()) {
                Toast.makeText(this, "Los reclamos de Picogordo no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_ReclamosPinzonComun.getText().toString().isEmpty()){
            if (parseInt(etn_ReclamosPinzonComun.getText().toString())>limites.getMaxRecPinzComun()) {
                Toast.makeText(this, "Los reclamos de PinzonComun no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_ReclamosPinzonReal.getText().toString().isEmpty()){
            if (parseInt(etn_ReclamosPinzonReal.getText().toString())>limites.getMaxRecPinzReal()) {
                Toast.makeText(this, "Los reclamos de PinzonReal no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_ReclamosPiquituerto.getText().toString().isEmpty()){
            if (parseInt(etn_ReclamosPiquituerto.getText().toString())>limites.getMaxRecPiquituerto()) {
                Toast.makeText(this, "Los reclamos de Piquituerto no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_ReclamosVerdecillo.getText().toString().isEmpty()){
            if (parseInt(etn_ReclamosVerdecillo.getText().toString())>limites.getMaxRecVerdecillo()) {
                Toast.makeText(this, "Los reclamos de Verdecillo no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_ReclamosVerderonComun.getText().toString().isEmpty()){
            if (parseInt(etn_ReclamosVerderonComun.getText().toString())>limites.getMaxRecVerdComun()) {
                Toast.makeText(this, "Los reclamos de VerderonComun no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_ReclamosVerderonSerrano.getText().toString().isEmpty()){
            if (parseInt(etn_ReclamosVerderonSerrano.getText().toString())>limites.getMaxRecVerdSerrano()) {
                Toast.makeText(this, "Los reclamos de VerderonSerrano no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        return true;
    }

    private boolean comprobarCimbeles() {

        if (!etn_CimbelesCamachuelo.getText().toString().isEmpty()){
            System.out.println("Cimbeles Cim =>" + parseInt(etn_CimbelesCamachuelo.getText().toString()));
            System.out.println("Cimbeles Grd =>" + limites.getMaxCimCamachuelo());
            System.out.println("Cimbeles Grd =>" + limites.getMaxRecCamachuelo());
            if (parseInt(etn_CimbelesCamachuelo.getText().toString())>limites.getMaxCimCamachuelo()) {
                Toast.makeText(this, "Los cimbeles de Camachuelo no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_CimbelesJilguero.getText().toString().isEmpty()){
            if (parseInt(etn_CimbelesJilguero.getText().toString())>limites.getMaxCimJilguero()) {
                Toast.makeText(this, "Los cimbeles de Jilguero no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_CimbelesLugano.getText().toString().isEmpty()){
            if (parseInt(etn_CimbelesLugano.getText().toString())>limites.getMaxCimLugano()) {
                Toast.makeText(this, "Los cimbeles de Lugano no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_CimbelesPardilloComun.getText().toString().isEmpty()){
            if (parseInt(etn_CimbelesPardilloComun.getText().toString())>limites.getMaxCimPardComun()) {
                Toast.makeText(this, "Los cimbeles de Pardillo Comun no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_CimbelesPicogordo.getText().toString().isEmpty()){
            if (parseInt(etn_CimbelesPicogordo.getText().toString())>limites.getMaxCimPicogordo()) {
                Toast.makeText(this, "Los cimbeles de Picogordo no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_CimbelesPinzonComun.getText().toString().isEmpty()){
            if (parseInt(etn_CimbelesPinzonComun.getText().toString())>limites.getMaxCimPinzComun()) {
                Toast.makeText(this, "Los cimbeles de Pinzon Comun no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_CimbelesPinzonReal.getText().toString().isEmpty()){
            if (parseInt(etn_CimbelesPinzonReal.getText().toString())>limites.getMaxCimPinzReal()) {
                Toast.makeText(this, "Los cimbeles de Pinzon Real no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_CimbelesPiquituerto.getText().toString().isEmpty()){
            if (parseInt(etn_CimbelesPiquituerto.getText().toString())>limites.getMaxCimPiquituerto()) {
                Toast.makeText(this, "Los cimbeles de Piquituerto no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_CimbelesVerdecillo.getText().toString().isEmpty()){
            if (parseInt(etn_CimbelesVerdecillo.getText().toString())>limites.getMaxCimVerdecillo()) {
                Toast.makeText(this, "Los cimbeles de Verdecillo no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_CimbelesVerderonComun.getText().toString().isEmpty()){
            if (parseInt(etn_CimbelesVerderonComun.getText().toString())>limites.getMaxCimVerdComun()) {
                Toast.makeText(this, "Los cimbeles de Verderon Comun no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (!etn_CimbelesVerderonSerrano.getText().toString().isEmpty()){
            if (parseInt(etn_CimbelesVerderonSerrano.getText().toString())>limites.getMaxCimVerdSerrano()) {
                Toast.makeText(this, "Los cimbeles de Verderon Serrano no coinciden con los límites", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        return true;
    }

    private void guardarParametros(Intent actividadDestino) {
        actividadDestino.putExtra("ENVIO", envio);
        actividadDestino.putExtra("LIMITES", limites);
    }

    private void cargarDatos() {
        etn_NumeroParticipantes.setText(String.valueOf(metodosCaptura.getNumeroParticipantes()));
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

        etn_CimbelesPardilloComun.setText(String.valueOf(metodosCaptura.getCimbelesPardComun()));
        etn_ReclamosPardilloComun.setText(String.valueOf(metodosCaptura.getReclamosPardComun()));
        etn_CapturasPardilloComunM.setText(String.valueOf(metodosCaptura.getCapturasPardComunM()));
        etn_CapturasPardilloComunH.setText(String.valueOf(metodosCaptura.getCapturasPardComunH()));

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

        etn_CimbelesVerderonComun.setText(String.valueOf(metodosCaptura.getCimbelesVerdComun()));
        etn_ReclamosVerderonComun.setText(String.valueOf(metodosCaptura.getReclamosVerdComun()));
        etn_CapturasVerderonComunM.setText(String.valueOf(metodosCaptura.getCapturasVerdComunM()));
        etn_CapturasVerderonComunH.setText(String.valueOf(metodosCaptura.getCapturasVerdComunH()));

        etn_CimbelesVerderonSerrano.setText(String.valueOf(metodosCaptura.getCimbelesVerdSerrano()));
        etn_ReclamosVerderonSerrano.setText(String.valueOf(metodosCaptura.getReclamosVerdSerrano()));
        etn_CapturasVerderonSerranoM.setText(String.valueOf(metodosCaptura.getCapturasVerdSerranoM()));
        etn_CapturasVerderonSerranoH.setText(String.valueOf(metodosCaptura.getCapturasVerdSerranoH()));

        et_Observaciones.setText(metodosCaptura.getObservaciones());
    }

    private void llenarControlAgentes() {
        System.out.println(metodosCaptura.getControlAgentes());
        if (metodosCaptura.getControlAgentes().get(0)){
            rb_SiControl.setChecked(true);
            cb_ControlSeprona.setChecked(metodosCaptura.getControlAgentes().get(1));
            cb_ControlForestales.setChecked(metodosCaptura.getControlAgentes().get(2));
            cb_ControlOtros.setChecked(metodosCaptura.getControlAgentes().get(3));
            cb_ControlPoliciaMunicipal.setChecked(metodosCaptura.getControlAgentes().get(4));
            cb_ControlPoliciaNacional.setChecked(metodosCaptura.getControlAgentes().get(5));
            cb_ControlSeprona.setClickable(true);
            cb_ControlForestales.setClickable(true);
            cb_ControlOtros.setClickable(true);
            cb_ControlPoliciaMunicipal.setClickable(true);
            cb_ControlPoliciaNacional.setClickable(true);
        } else {
            rb_NoControl.setChecked(true);
        }
    }

    private void recuperarDatosRecibidos(Bundle datos) {
        envio = (Envio) datos.getSerializable("ENVIO");

        DNI = envio.getDNI();
        email = envio.getEmail();
        mCapturasCompletado = envio.isMCapturaCompletado();
        avistamientoCompletado = envio.isAvistamientoCompletado();
        entornoCompletado = envio.isEntornoCompletado();
        metodosCaptura = envio.getMetodosCaptura();
        datosAvistamiento = envio.getDatosAvistamiento();
        datosEntorno = envio.getDatosEntorno();

        limites = (Limites) datos.getSerializable("LIMITES");
    }
}
