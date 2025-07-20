package com.sefricam.sefricam3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla_Mi_Envio extends Activity implements View.OnClickListener{

    // UI Parameters
    private ImageView iv_DatosCheckBoxEntorno;
    private TextView tv_DatosTemperaturaInicio;
    private TextView tv_DatosTemperaturaFin;
    private TextView tv_DatosZonificacion;
    private TextView tv_DatosDireccionViento;
    private TextView tv_DatosViento;
    private TextView tv_DatosNubes;
    private TextView tv_DatosLluvia;
    private TextView tv_DatosPlantas;
    private TextView tv_DatosNumeroParticipantes;
    private ImageView iv_DatosCheckBoxCapturas;
    private TextView tv_DatosNumeroMallas;
    private TextView tv_DatosLongitudRed;
    private TextView tv_DatosCoto;
    private TextView tv_DatosControlAgentes;
    private TextView tv_DatosReclamosCamachuelo;
    private TextView tv_DatosCimbelesCamachuelo;
    private TextView tv_DatosCapturasCamachueloM;
    private TextView tv_DatosCapturasCamachueloH;
    private TextView tv_DatosReclamosJilguero;
    private TextView tv_DatosCimbelesJilguero;
    private TextView tv_DatosCapturasJilgueroM;
    private TextView tv_DatosCapturasJilgueroH;
    private TextView tv_DatosReclamosLugano;
    private TextView tv_DatosCimbelesLugano;
    private TextView tv_DatosCapturasLuganoM;
    private TextView tv_DatosCapturasLuganoH;
    private TextView tv_DatosReclamosPardilloComun;
    private TextView tv_DatosCimbelesPardilloComun;
    private TextView tv_DatosCapturasPardilloComunM;
    private TextView tv_DatosCapturasPardilloComunH;
    private TextView tv_DatosReclamosPicogordo;
    private TextView tv_DatosCimbelesPicogordo;
    private TextView tv_DatosCapturasPicogordoM;
    private TextView tv_DatosCapturasPicogordoH;
    private TextView tv_DatosReclamosPinzonComun;
    private TextView tv_DatosCimbelesPinzonComun;
    private TextView tv_DatosCapturasPinzonComunM;
    private TextView tv_DatosCapturasPinzonComunH;
    private TextView tv_DatosReclamosPinzonReal;
    private TextView tv_DatosCimbelesPinzonReal;
    private TextView tv_DatosCapturasPinzonRealM;
    private TextView tv_DatosCapturasPinzonRealH;
    private TextView tv_DatosReclamosPiquituerto;
    private TextView tv_DatosCimbelesPiquituerto;
    private TextView tv_DatosCapturasPiquituertoM;
    private TextView tv_DatosCapturasPiquituertoH;
    private TextView tv_DatosReclamosVerdecillo;
    private TextView tv_DatosCimbelesVerdecillo;
    private TextView tv_DatosCapturasVerdecilloM;
    private TextView tv_DatosCapturasVerdecilloH;
    private TextView tv_DatosReclamosVerderonComun;
    private TextView tv_DatosCimbelesVerderonComun;
    private TextView tv_DatosCapturasVerderonComunM;
    private TextView tv_DatosCapturasVerderonComunH;
    private TextView tv_DatosReclamosVerderonSerrano;
    private TextView tv_DatosCimbelesVerderonSerrano;
    private TextView tv_DatosCapturasVerderonSerranoM;
    private TextView tv_DatosCapturasVerderonSerranoH;
    private TextView tv_DatosObservaciones;
    private ImageView iv_DatosCheckBoxAvistamiento;
    private TextView tv_DatosHoraInicio;
    private TextView tv_DatosHoraFin;
    private TextView tv_DatosEspecieCamachuelo08;
    private TextView tv_DatosEspecieJilguero08;
    private TextView tv_DatosEspecieLugano08;
    private TextView tv_DatosEspeciePardilloComun08;
    private TextView tv_DatosEspeciePicogordo08;
    private TextView tv_DatosEspeciePinzonComun08;
    private TextView tv_DatosEspeciePinzonReal08;
    private TextView tv_DatosEspeciePiquituerto08;
    private TextView tv_DatosEspecieVerdecillo08;
    private TextView tv_DatosEspecieVerderonComun08;
    private TextView tv_DatosEspecieVerderonSerrano08;
    private TextView tv_DatosEspecieCamachuelo09;
    private TextView tv_DatosEspecieJilguero09;
    private TextView tv_DatosEspecieLugano09;
    private TextView tv_DatosEspeciePardilloComun09;
    private TextView tv_DatosEspeciePicogordo09;
    private TextView tv_DatosEspeciePinzonComun09;
    private TextView tv_DatosEspeciePinzonReal09;
    private TextView tv_DatosEspeciePiquituerto09;
    private TextView tv_DatosEspecieVerdecillo09;
    private TextView tv_DatosEspecieVerderonComun09;
    private TextView tv_DatosEspecieVerderonSerrano09;
    private TextView tv_DatosEspecieCamachuelo10;
    private TextView tv_DatosEspecieJilguero10;
    private TextView tv_DatosEspecieLugano10;
    private TextView tv_DatosEspeciePardilloComun10;
    private TextView tv_DatosEspeciePicogordo10;
    private TextView tv_DatosEspeciePinzonComun10;
    private TextView tv_DatosEspeciePinzonReal10;
    private TextView tv_DatosEspeciePiquituerto10;
    private TextView tv_DatosEspecieVerdecillo10;
    private TextView tv_DatosEspecieVerderonComun10;
    private TextView tv_DatosEspecieVerderonSerrano10;
    private TextView tv_DatosEspecieCamachuelo11;
    private TextView tv_DatosEspecieJilguero11;
    private TextView tv_DatosEspecieLugano11;
    private TextView tv_DatosEspeciePardilloComun11;
    private TextView tv_DatosEspeciePicogordo11;
    private TextView tv_DatosEspeciePinzonComun11;
    private TextView tv_DatosEspeciePinzonReal11;
    private TextView tv_DatosEspeciePiquituerto11;
    private TextView tv_DatosEspecieVerdecillo11;
    private TextView tv_DatosEspecieVerderonComun11;
    private TextView tv_DatosEspecieVerderonSerrano11;
    private TextView tv_DatosEspecieCamachuelo12;
    private TextView tv_DatosEspecieJilguero12;
    private TextView tv_DatosEspecieLugano12;
    private TextView tv_DatosEspeciePardilloComun12;
    private TextView tv_DatosEspeciePicogordo12;
    private TextView tv_DatosEspeciePinzonComun12;
    private TextView tv_DatosEspeciePinzonReal12;
    private TextView tv_DatosEspeciePiquituerto12;
    private TextView tv_DatosEspecieVerdecillo12;
    private TextView tv_DatosEspecieVerderonComun12;
    private TextView tv_DatosEspecieVerderonSerrano12;
    private TextView tv_DatosEspecieCamachuelo13;
    private TextView tv_DatosEspecieJilguero13;
    private TextView tv_DatosEspecieLugano13;
    private TextView tv_DatosEspeciePardilloComun13;
    private TextView tv_DatosEspeciePicogordo13;
    private TextView tv_DatosEspeciePinzonComun13;
    private TextView tv_DatosEspeciePinzonReal13;
    private TextView tv_DatosEspeciePiquituerto13;
    private TextView tv_DatosEspecieVerdecillo13;
    private TextView tv_DatosEspecieVerderonComun13;
    private TextView tv_DatosEspecieVerderonSerrano13;
    private TextView tv_DatosEspecieCamachuelo14;
    private TextView tv_DatosEspecieJilguero14;
    private TextView tv_DatosEspecieLugano14;
    private TextView tv_DatosEspeciePardilloComun14;
    private TextView tv_DatosEspeciePicogordo14;
    private TextView tv_DatosEspeciePinzonComun14;
    private TextView tv_DatosEspeciePinzonReal14;
    private TextView tv_DatosEspeciePiquituerto14;
    private TextView tv_DatosEspecieVerdecillo14;
    private TextView tv_DatosEspecieVerderonComun14;
    private TextView tv_DatosEspecieVerderonSerrano14;
    private Button btn_VolverDatos;

    // Class Parameters
    private Envio envio;
    private Limites limites;

    /**
     * Initialize the screen and all its components
     * @param savedInstanceState bundle of data that receives when it starts the screen
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            retrieveData(datos);
        }

        setContentView(R.layout.pantalla_mi_envio);
        startFindView();
        setOnClickListener();

        if (envio.isEntornoCompletado()) loadDatosEntorno();

        if (envio.isMCapturaCompletado()) loadMetodosCapturas();

        if (envio.isAvistamientoCompletado()) loadDatosAvistamiento();

    }

    /**
     * Init the UI elements into the code
     */
    private void startFindView() {
        //Datos Entorno
        iv_DatosCheckBoxEntorno = findViewById(R.id.iv_DatosCheckBoxEntorno);
        tv_DatosTemperaturaInicio = findViewById(R.id.tv_DatosTemperaturaInicio);
        tv_DatosTemperaturaFin = findViewById(R.id.tv_DatosTemperaturaFin);
        tv_DatosZonificacion = findViewById(R.id.tv_DatosZonificacion);
        tv_DatosDireccionViento = findViewById(R.id.tv_DatosDireccionViento);
        tv_DatosViento = findViewById(R.id.tv_DatosViento);
        tv_DatosNubes = findViewById(R.id.tv_DatosNubes);
        tv_DatosLluvia = findViewById(R.id.tv_DatosLluvia);
        tv_DatosPlantas = findViewById(R.id.tv_DatosPlantas);

        //Metodos de captura
        iv_DatosCheckBoxCapturas = findViewById(R.id.iv_DatosCheckBoxCapturas);
        tv_DatosNumeroParticipantes = findViewById(R.id.tv_DatosNumeroParticipantes);
        tv_DatosNumeroMallas = findViewById(R.id.tv_DatosNumeroMallas);
        tv_DatosLongitudRed = findViewById(R.id.tv_DatosLongitudRed);
        tv_DatosCoto = findViewById(R.id.tv_DatosCoto);
        tv_DatosControlAgentes = findViewById(R.id.tv_DatosControlAgentes);
        tv_DatosReclamosCamachuelo =  findViewById(R.id.tv_DatosReclamosCamachuelo);
        tv_DatosCimbelesCamachuelo = findViewById(R.id.tv_DatosCimbelesCamachuelo);
        tv_DatosCapturasCamachueloM =  findViewById(R.id.tv_DatosCapturasCamachueloM);
        tv_DatosCapturasCamachueloH =  findViewById(R.id.tv_DatosCapturasCamachueloH);
        tv_DatosReclamosJilguero = findViewById(R.id.tv_DatosReclamosJilguero);
        tv_DatosCimbelesJilguero = findViewById(R.id.tv_DatosCimbelesJilguero);
        tv_DatosCapturasJilgueroM = findViewById(R.id.tv_DatosCapturasJilgueroM);
        tv_DatosCapturasJilgueroH = findViewById(R.id.tv_DatosCapturasJilgueroH);
        tv_DatosReclamosLugano = findViewById(R.id.tv_DatosReclamosLugano);
        tv_DatosCimbelesLugano = findViewById(R.id.tv_DatosCimbelesLugano);
        tv_DatosCapturasLuganoM = findViewById(R.id.tv_DatosCapturasLuganoM);
        tv_DatosCapturasLuganoH = findViewById(R.id.tv_DatosCapturasLuganoH);
        tv_DatosReclamosPardilloComun = findViewById(R.id.tv_DatosReclamosPardilloComun);
        tv_DatosCimbelesPardilloComun = findViewById(R.id.tv_DatosCimbelesPardilloComun);
        tv_DatosCapturasPardilloComunM = findViewById(R.id.tv_DatosCapturasPardilloComunM);
        tv_DatosCapturasPardilloComunH = findViewById(R.id.tv_DatosCapturasPardilloComunH);
        tv_DatosReclamosPicogordo =  findViewById(R.id.tv_DatosReclamosPicogordo);
        tv_DatosCimbelesPicogordo = findViewById(R.id.tv_DatosCimbelesPicogordo);
        tv_DatosCapturasPicogordoM = findViewById(R.id.tv_DatosCapturasPicogordoM);
        tv_DatosCapturasPicogordoH = findViewById(R.id.tv_DatosCapturasPicogordoH);
        tv_DatosReclamosPinzonComun = findViewById(R.id.tv_DatosReclamosPinzonComun);
        tv_DatosCimbelesPinzonComun = findViewById(R.id.tv_DatosCimbelesPinzonComun);
        tv_DatosCapturasPinzonComunM = findViewById(R.id.tv_DatosCapturasPinzonComunM);
        tv_DatosCapturasPinzonComunH = findViewById(R.id.tv_DatosCapturasPinzonComunH);
        tv_DatosReclamosPinzonReal = findViewById(R.id.tv_DatosReclamosPinzonReal);
        tv_DatosCimbelesPinzonReal = findViewById(R.id.tv_DatosCimbelesPinzonReal);
        tv_DatosCapturasPinzonRealM = findViewById(R.id.tv_DatosCapturasPinzonRealM);
        tv_DatosCapturasPinzonRealH = findViewById(R.id.tv_DatosCapturasPinzonRealH);
        tv_DatosReclamosPiquituerto = findViewById(R.id.tv_DatosReclamosPiquituerto);
        tv_DatosCimbelesPiquituerto = findViewById(R.id.tv_DatosCimbelesPiquituerto);
        tv_DatosCapturasPiquituertoM = findViewById(R.id.tv_DatosCapturasPiquituertoM);
        tv_DatosCapturasPiquituertoH = findViewById(R.id.tv_DatosCapturasPiquituertoH);
        tv_DatosReclamosVerdecillo = findViewById(R.id.tv_DatosReclamosVerdecillo);
        tv_DatosCimbelesVerdecillo = findViewById(R.id.tv_DatosCimbelesVerdecillo);
        tv_DatosCapturasVerdecilloM = findViewById(R.id.tv_DatosCapturasVerdecilloM);
        tv_DatosCapturasVerdecilloH = findViewById(R.id.tv_DatosCapturasVerdecilloH);
        tv_DatosReclamosVerderonComun = findViewById(R.id.tv_DatosReclamosVerderonComun);
        tv_DatosCimbelesVerderonComun = findViewById(R.id.tv_DatosCimbelesVerderonComun);
        tv_DatosCapturasVerderonComunM = findViewById(R.id.tv_DatosCapturasVerderonComunM);
        tv_DatosCapturasVerderonComunH = findViewById(R.id.tv_DatosCapturasVerderonComunH);
        tv_DatosReclamosVerderonSerrano = findViewById(R.id.tv_DatosReclamosVerderonSerrano);
        tv_DatosCimbelesVerderonSerrano = findViewById(R.id.tv_DatosCimbelesVerderonSerrano);
        tv_DatosCapturasVerderonSerranoM = findViewById(R.id.tv_DatosCapturasVerderonSerranoM);
        tv_DatosCapturasVerderonSerranoH = findViewById(R.id.tv_DatosCapturasVerderonSerranoH);
        tv_DatosObservaciones = findViewById(R.id.tv_DatosObservaciones);

        //Datos Avistamiento
        iv_DatosCheckBoxAvistamiento = findViewById(R.id.iv_DatosCheckBoxAvistamiento);
        tv_DatosHoraInicio = findViewById(R.id.tv_DatosHoraInicio);
        tv_DatosHoraFin = findViewById(R.id.tv_DatosHoraFin);
        //Hora 08:00
        tv_DatosEspecieCamachuelo08 = findViewById(R.id.tv_DatosEspecieCamachuelo08);
        tv_DatosEspecieJilguero08 = findViewById(R.id.tv_DatosEspecieJilguero08);
        tv_DatosEspecieLugano08 = findViewById(R.id.tv_DatosEspecieLugano08);
        tv_DatosEspeciePardilloComun08 = findViewById(R.id.tv_DatosEspeciePardilloComun08);
        tv_DatosEspeciePicogordo08 = findViewById(R.id.tv_DatosEspeciePicogordo08);
        tv_DatosEspeciePinzonComun08 = findViewById(R.id.tv_DatosEspeciePinzonComun08);
        tv_DatosEspeciePinzonReal08 = findViewById(R.id.tv_DatosEspeciePinzonReal08);
        tv_DatosEspeciePiquituerto08 =  findViewById(R.id.tv_DatosEspeciePiquituerto08);
        tv_DatosEspecieVerdecillo08 = findViewById(R.id.tv_DatosEspecieVerdecillo08);
        tv_DatosEspecieVerderonComun08 = findViewById(R.id.tv_DatosEspecieVerderonComun08);
        tv_DatosEspecieVerderonSerrano08 = findViewById(R.id.tv_DatosEspecieVerderonSerrano08);
        //Hora 09:00
        tv_DatosEspecieCamachuelo09 = findViewById(R.id.tv_DatosEspecieCamachuelo09);
        tv_DatosEspecieJilguero09 = findViewById(R.id.tv_DatosEspecieJilguero09);
        tv_DatosEspecieLugano09 = findViewById(R.id.tv_DatosEspecieLugano09);
        tv_DatosEspeciePardilloComun09 = findViewById(R.id.tv_DatosEspeciePardilloComun09);
        tv_DatosEspeciePicogordo09 = findViewById(R.id.tv_DatosEspeciePicogordo09);
        tv_DatosEspeciePinzonComun09 = findViewById(R.id.tv_DatosEspeciePinzonComun09);
        tv_DatosEspeciePinzonReal09 = findViewById(R.id.tv_DatosEspeciePinzonReal09);
        tv_DatosEspeciePiquituerto09 = findViewById(R.id.tv_DatosEspeciePiquituerto09);
        tv_DatosEspecieVerdecillo09 = findViewById(R.id.tv_DatosEspecieVerdecillo09);
        tv_DatosEspecieVerderonComun09 = findViewById(R.id.tv_DatosEspecieVerderonComun09);
        tv_DatosEspecieVerderonSerrano09 = findViewById(R.id.tv_DatosEspecieVerderonSerrano09);
        //Hora 10:00
        tv_DatosEspecieCamachuelo10 = findViewById(R.id.tv_DatosEspecieCamachuelo10);
        tv_DatosEspecieJilguero10 = findViewById(R.id.tv_DatosEspecieJilguero10);
        tv_DatosEspecieLugano10 = findViewById(R.id.tv_DatosEspecieLugano10);
        tv_DatosEspeciePardilloComun10 = findViewById(R.id.tv_DatosEspeciePardilloComun10);
        tv_DatosEspeciePicogordo10 = findViewById(R.id.tv_DatosEspeciePicogordo10);
        tv_DatosEspeciePinzonComun10 = findViewById(R.id.tv_DatosEspeciePinzonComun10);
        tv_DatosEspeciePinzonReal10 = findViewById(R.id.tv_DatosEspeciePinzonReal10);
        tv_DatosEspeciePiquituerto10 = findViewById(R.id.tv_DatosEspeciePiquituerto10);
        tv_DatosEspecieVerdecillo10 = findViewById(R.id.tv_DatosEspecieVerdecillo10);
        tv_DatosEspecieVerderonComun10 = findViewById(R.id.tv_DatosEspecieVerderonComun10);
        tv_DatosEspecieVerderonSerrano10 = findViewById(R.id.tv_DatosEspecieVerderonSerrano10);
        //Hora 11:00
        tv_DatosEspecieCamachuelo11 = findViewById(R.id.tv_DatosEspecieCamachuelo11);
        tv_DatosEspecieJilguero11 = findViewById(R.id.tv_DatosEspecieJilguero11);
        tv_DatosEspecieLugano11 = findViewById(R.id.tv_DatosEspecieLugano11);
        tv_DatosEspeciePardilloComun11 = findViewById(R.id.tv_DatosEspeciePardilloComun11);
        tv_DatosEspeciePicogordo11 = findViewById(R.id.tv_DatosEspeciePicogordo11);
        tv_DatosEspeciePinzonComun11 = findViewById(R.id.tv_DatosEspeciePinzonComun11);
        tv_DatosEspeciePinzonReal11 = findViewById(R.id.tv_DatosEspeciePinzonReal11);
        tv_DatosEspeciePiquituerto11 = findViewById(R.id.tv_DatosEspeciePiquituerto11);
        tv_DatosEspecieVerdecillo11 = findViewById(R.id.tv_DatosEspecieVerdecillo11);
        tv_DatosEspecieVerderonComun11 = findViewById(R.id.tv_DatosEspecieVerderonComun11);
        tv_DatosEspecieVerderonSerrano11 = findViewById(R.id.tv_DatosEspecieVerderonSerrano11);
        //Hora 12:00
        tv_DatosEspecieCamachuelo12 = findViewById(R.id.tv_DatosEspecieCamachuelo12);
        tv_DatosEspecieJilguero12 = findViewById(R.id.tv_DatosEspecieJilguero12);
        tv_DatosEspecieLugano12 = findViewById(R.id.tv_DatosEspecieLugano12);
        tv_DatosEspeciePardilloComun12 = findViewById(R.id.tv_DatosEspeciePardilloComun12);
        tv_DatosEspeciePicogordo12 = findViewById(R.id.tv_DatosEspeciePicogordo12);
        tv_DatosEspeciePinzonComun12 = findViewById(R.id.tv_DatosEspeciePinzonComun12);
        tv_DatosEspeciePinzonReal12 =  findViewById(R.id.tv_DatosEspeciePinzonReal12);
        tv_DatosEspeciePiquituerto12 = findViewById(R.id.tv_DatosEspeciePiquituerto12);
        tv_DatosEspecieVerdecillo12 = findViewById(R.id.tv_DatosEspecieVerdecillo12);
        tv_DatosEspecieVerderonComun12 = findViewById(R.id.tv_DatosEspecieVerderonComun12);
        tv_DatosEspecieVerderonSerrano12 = findViewById(R.id.tv_DatosEspecieVerderonSerrano12);
        //Hora 13:00
        tv_DatosEspecieCamachuelo13 = findViewById(R.id.tv_DatosEspecieCamachuelo13);
        tv_DatosEspecieJilguero13 = findViewById(R.id.tv_DatosEspecieJilguero13);
        tv_DatosEspecieLugano13 = findViewById(R.id.tv_DatosEspecieLugano13);
        tv_DatosEspeciePardilloComun13 = findViewById(R.id.tv_DatosEspeciePardilloComun13);
        tv_DatosEspeciePicogordo13 = findViewById(R.id.tv_DatosEspeciePicogordo13);
        tv_DatosEspeciePinzonComun13 = findViewById(R.id.tv_DatosEspeciePinzonComun13);
        tv_DatosEspeciePinzonReal13 = findViewById(R.id.tv_DatosEspeciePinzonReal13);
        tv_DatosEspeciePiquituerto13 = findViewById(R.id.tv_DatosEspeciePiquituerto13);
        tv_DatosEspecieVerdecillo13 = findViewById(R.id.tv_DatosEspecieVerdecillo13);
        tv_DatosEspecieVerderonComun13 = findViewById(R.id.tv_DatosEspecieVerderonComun13);
        tv_DatosEspecieVerderonSerrano13 = findViewById(R.id.tv_DatosEspecieVerderonSerrano13);
        //Hora 14
        tv_DatosEspecieCamachuelo14 = findViewById(R.id.tv_DatosEspecieCamachuelo14);
        tv_DatosEspecieJilguero14 = findViewById(R.id.tv_DatosEspecieJilguero14);
        tv_DatosEspecieLugano14 = findViewById(R.id.tv_DatosEspecieLugano14);
        tv_DatosEspeciePardilloComun14 = findViewById(R.id.tv_DatosEspeciePardilloComun14);
        tv_DatosEspeciePicogordo14 = findViewById(R.id.tv_DatosEspeciePicogordo14);
        tv_DatosEspeciePinzonComun14 = findViewById(R.id.tv_DatosEspeciePinzonComun14);
        tv_DatosEspeciePinzonReal14 = findViewById(R.id.tv_DatosEspeciePinzonReal14);
        tv_DatosEspeciePiquituerto14 = findViewById(R.id.tv_DatosEspeciePiquituerto14);
        tv_DatosEspecieVerdecillo14 = findViewById(R.id.tv_DatosEspecieVerdecillo14);
        tv_DatosEspecieVerderonComun14 = findViewById(R.id.tv_DatosEspecieVerderonComun14);
        tv_DatosEspecieVerderonSerrano14 = findViewById(R.id.tv_DatosEspecieVerderonSerrano14);

        //Buttons
        btn_VolverDatos = findViewById(R.id.btn_VolverMiEnvio);
    }

    /**
     * Sets all the click listener for the UI elements
     */
    private void setOnClickListener() {
        btn_VolverDatos.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v == btn_VolverDatos){
            Intent activity = new Intent(this,Pantalla_Menu_Metodos_Y_Captura.class);
            saveData(activity);
            startActivity(activity);
            finish();
        }
    }

    /**
     * Loads DatosEntorno Class in to the UI
     */
    @SuppressLint({"SetTextI18n", "UseCompatLoadingForDrawables"})
    private void loadDatosEntorno() {
        iv_DatosCheckBoxEntorno.setBackground(getDrawable(R.drawable.baseline_check_box_24));

        tv_DatosTemperaturaInicio.setText(envio.getDatosEntorno().getTInicio() + " ºC");
        tv_DatosTemperaturaFin.setText(envio.getDatosEntorno().getTFin()+" ºC");
        switch (envio.getDatosEntorno().getZonificacion()){
            case 1:
                tv_DatosZonificacion.setText("Afloramientos Rocosos y Rasos");
                break;
            case 2:
                tv_DatosZonificacion.setText("Cultivos");
                break;
            case 3:
                tv_DatosZonificacion.setText("Láminas y Cursos de Agua");
                break;
            case 4:
                tv_DatosZonificacion.setText("Dehesa y zonas adehesadas");
                break;
            case 5:
                tv_DatosZonificacion.setText("Plantaciones de Frondosas y Coníferas");
                break;
            case 6:
                tv_DatosZonificacion.setText("Vegetación Arbórea de Coníferas");
                break;
            case 7:
                tv_DatosZonificacion.setText("Vegetación Arbórea de Frondosas");
                break;
            case 8:
                tv_DatosZonificacion.setText("Vegetación de Matorral");
                break;
            case 9:
                tv_DatosZonificacion.setText("Vegetación Herbácea");
                break;
            case 10:
                tv_DatosZonificacion.setText("Viñedos, Olivares y Otros Frutales");
                break;
            case 11:
                tv_DatosZonificacion.setText("Zonas Artificiales");
                break;
        }
        tv_DatosDireccionViento.setText(envio.getDatosEntorno().getDireccionViento());
        switch (envio.getDatosEntorno().getViento()){
            case 1:
                tv_DatosViento.setText("Calma");
                break;
            case 2:
                tv_DatosViento.setText("Ligero");
                break;
            case 3:
                tv_DatosViento.setText("Fuerte");
                break;
        }
        switch (envio.getDatosEntorno().getNubes()){
            case 1:
                tv_DatosNubes.setText("Ausentes");
                break;
            case 2:
                tv_DatosNubes.setText("Nubes y claros");
                break;
            case 3:
                tv_DatosNubes.setText("Cubierto");
                break;
            case 4:
                tv_DatosNubes.setText("Muy Cubierto");
                break;
        }
        switch (envio.getDatosEntorno().getLluvia()){
            case 1:
                tv_DatosLluvia.setText("Ausentes");
                break;
            case 2:
                tv_DatosLluvia.setText("Intermitente");
                break;
            case 3:
                tv_DatosLluvia.setText("Ligera");
                break;
            case 4:
                tv_DatosLluvia.setText("Fuerte");
                break;
            case 5:
                tv_DatosLluvia.setText("Muy fuerte");
                break;
        }
        int i = 0;
        while (i<envio.getDatosEntorno().getPlantas().size()){
            String estado = "No encontrado";
            int estadoRecuperado = envio.getDatosEntorno().getPlantas().get(i);
            System.out.println("Estado"+i+": "+estadoRecuperado);
            if (estadoRecuperado == 1) estado = "Encontrado";
            if (envio.getDatosEntorno().getPlantas().get(i) == 2) estado = "Abundante";
            if (i < 9) tv_DatosPlantas.append(("0" + (i + 1)) + ". " + estado + "\n");
            else tv_DatosPlantas.append((i + 1) + ". " + estado + "\n");
            i++;
        }

        if (!envio.getDatosEntorno().getEP37().equals("_"))tv_DatosPlantas.append("37. "+envio.getDatosEntorno().getEP37()+"\n");
        else tv_DatosPlantas.append("37. No encontrado\n");

        if (!envio.getDatosEntorno().getEP38().isEmpty())tv_DatosPlantas.append("38. "+envio.getDatosEntorno().getEP38());
        else tv_DatosPlantas.append("38. No encontrado");
    }

    /**
     * Loads MetodosCaptura Class in to the UI
     */
    @SuppressLint({"UseCompatLoadingForDrawables", "SetTextI18n"})
    private void loadMetodosCapturas() {
        iv_DatosCheckBoxCapturas.setBackground(getDrawable(R.drawable.baseline_check_box_24));
        tv_DatosNumeroParticipantes.setText(String.valueOf(envio.getMetodosCaptura().getNumeroParticipantes()));
        tv_DatosNumeroMallas.setText(String.valueOf(envio.getMetodosCaptura().getNumeroMallas()));
        tv_DatosLongitudRed.setText(String.valueOf(envio.getMetodosCaptura().getLongitudRed()));
        if (envio.getMetodosCaptura().isCoto()){
           tv_DatosCoto.setText("Si");
        } else {
            tv_DatosCoto.setText("No");
        }
        int i = 0;

        while (i < envio.getMetodosCaptura().getControlAgentes().size()){
            switch (i){
                case 0:
                    if (!envio.getMetodosCaptura().getControlAgentes().get(i))
                    tv_DatosControlAgentes.append("No hay control");
                    break;
                case 1:
                    if (envio.getMetodosCaptura().getControlAgentes().get(i))
                    tv_DatosControlAgentes.append("Seprona\n");
                    break;
                case 2:
                    if (envio.getMetodosCaptura().getControlAgentes().get(i))
                    tv_DatosControlAgentes.append("Agentes Forestales\n");
                    break;
                case 3:
                    if (envio.getMetodosCaptura().getControlAgentes().get(i))
                    tv_DatosControlAgentes.append("Policía Local\n");
                    break;
                case 4:
                    if (envio.getMetodosCaptura().getControlAgentes().get(i))
                    tv_DatosControlAgentes.append("Policía Nacional\n");
                    break;
                case 5:
                    if (envio.getMetodosCaptura().getControlAgentes().get(i))
                    tv_DatosControlAgentes.append("Otros");
                    break;
            }
            i++;
        }


        tv_DatosReclamosCamachuelo.setText(String.valueOf(envio.getMetodosCaptura().getReclamosCamachuelo()));
        tv_DatosCimbelesCamachuelo.setText(String.valueOf(envio.getMetodosCaptura().getCimbelesCamachuelo()));
        tv_DatosCapturasCamachueloM.setText(String.valueOf(envio.getMetodosCaptura().getCapturasCamachueloM()));
        tv_DatosCapturasCamachueloH.setText(String.valueOf(envio.getMetodosCaptura().getCapturasCamachueloH()));
        tv_DatosReclamosJilguero.setText(String.valueOf(envio.getMetodosCaptura().getReclamosJilguero()));
        tv_DatosCimbelesJilguero.setText(String.valueOf(envio.getMetodosCaptura().getCimbelesJilguero()));
        tv_DatosCapturasJilgueroM.setText(String.valueOf(envio.getMetodosCaptura().getCapturasJilgueroM()));
        tv_DatosCapturasJilgueroH.setText(String.valueOf(envio.getMetodosCaptura().getCapturasJilgueroH()));
        tv_DatosReclamosLugano.setText(String.valueOf(envio.getMetodosCaptura().getReclamosLugano()));
        tv_DatosCimbelesLugano.setText(String.valueOf(envio.getMetodosCaptura().getCimbelesLugano()));
        tv_DatosCapturasLuganoM.setText(String.valueOf(envio.getMetodosCaptura().getCapturasLuganoM()));
        tv_DatosCapturasLuganoH.setText(String.valueOf(envio.getMetodosCaptura().getCapturasLuganoH()));
        tv_DatosReclamosPardilloComun.setText(String.valueOf(envio.getMetodosCaptura().getReclamosPardComun()));
        tv_DatosCimbelesPardilloComun.setText(String.valueOf(envio.getMetodosCaptura().getCimbelesPardComun()));
        tv_DatosCapturasPardilloComunM.setText(String.valueOf(envio.getMetodosCaptura().getCapturasPardComunM()));
        tv_DatosCapturasPardilloComunH.setText(String.valueOf(envio.getMetodosCaptura().getCapturasPardComunH()));
        tv_DatosReclamosPicogordo.setText(String.valueOf(envio.getMetodosCaptura().getReclamosPicogordo()));
        tv_DatosCimbelesPicogordo.setText(String.valueOf(envio.getMetodosCaptura().getCimbelesPicogordo()));
        tv_DatosCapturasPicogordoM.setText(String.valueOf(envio.getMetodosCaptura().getCapturasPicogordoM()));
        tv_DatosCapturasPicogordoH.setText(String.valueOf(envio.getMetodosCaptura().getCapturasPicogordoH()));
        tv_DatosReclamosPinzonComun.setText(String.valueOf(envio.getMetodosCaptura().getReclamosPinzonComun()));
        tv_DatosCimbelesPinzonComun.setText(String.valueOf(envio.getMetodosCaptura().getCimbelesPinzonComun()));
        tv_DatosCapturasPinzonComunM.setText(String.valueOf(envio.getMetodosCaptura().getCapturasPinzonComunM()));
        tv_DatosCapturasPinzonComunH.setText(String.valueOf(envio.getMetodosCaptura().getCapturasPinzonComunH()));
        tv_DatosReclamosPinzonReal.setText(String.valueOf(envio.getMetodosCaptura().getReclamosPinzonReal()));
        tv_DatosCimbelesPinzonReal.setText(String.valueOf(envio.getMetodosCaptura().getCimbelesPinzonReal()));
        tv_DatosCapturasPinzonRealM.setText(String.valueOf(envio.getMetodosCaptura().getCapturasPinzonRealM()));
        tv_DatosCapturasPinzonRealH.setText(String.valueOf(envio.getMetodosCaptura().getCapturasPinzonRealH()));
        tv_DatosReclamosPiquituerto.setText(String.valueOf(envio.getMetodosCaptura().getReclamosPiquituerto()));
        tv_DatosCimbelesPiquituerto.setText(String.valueOf(envio.getMetodosCaptura().getCimbelesPiquituerto()));
        tv_DatosCapturasPiquituertoM.setText(String.valueOf(envio.getMetodosCaptura().getCapturasPiquituertoM()));
        tv_DatosCapturasPiquituertoH.setText(String.valueOf(envio.getMetodosCaptura().getCapturasPiquituertoH()));
        tv_DatosReclamosVerdecillo.setText(String.valueOf(envio.getMetodosCaptura().getReclamosVerdecillo()));
        tv_DatosCimbelesVerdecillo.setText(String.valueOf(envio.getMetodosCaptura().getCimbelesVerdecillo()));
        tv_DatosCapturasVerdecilloM.setText(String.valueOf(envio.getMetodosCaptura().getCapturasVerdecilloM()));
        tv_DatosCapturasVerdecilloH.setText(String.valueOf(envio.getMetodosCaptura().getCapturasVerdecilloH()));
        tv_DatosReclamosVerderonComun.setText(String.valueOf(envio.getMetodosCaptura().getReclamosVerdComun()));
        tv_DatosCimbelesVerderonComun.setText(String.valueOf(envio.getMetodosCaptura().getCimbelesVerdComun()));
        tv_DatosCapturasVerderonComunM.setText(String.valueOf(envio.getMetodosCaptura().getCapturasVerdComunM()));
        tv_DatosCapturasVerderonComunH.setText(String.valueOf(envio.getMetodosCaptura().getCapturasVerdComunH()));
        tv_DatosReclamosVerderonSerrano.setText(String.valueOf(envio.getMetodosCaptura().getReclamosVerdSerrano()));
        tv_DatosCimbelesVerderonSerrano.setText(String.valueOf(envio.getMetodosCaptura().getCimbelesVerdSerrano()));
        tv_DatosCapturasVerderonSerranoM.setText(String.valueOf(envio.getMetodosCaptura().getCapturasVerdSerranoM()));
        tv_DatosCapturasVerderonSerranoH.setText(String.valueOf(envio.getMetodosCaptura().getCapturasVerdSerranoH()));

        tv_DatosObservaciones.setText(String.valueOf(envio.getMetodosCaptura().getObservaciones()));
    }

    /**
     * Loads DatosAvistamiento Class in to the UI
     */
    @SuppressLint("UseCompatLoadingForDrawables")
    private void loadDatosAvistamiento() {
        iv_DatosCheckBoxAvistamiento.setBackground(getDrawable(R.drawable.baseline_check_box_24));

        tv_DatosHoraInicio.setText(envio.getDatosAvistamiento().getHoraInicio());
        tv_DatosHoraFin.setText(envio.getDatosAvistamiento().getHoraFin());

        int posicion = 0;
        while (posicion < envio.getDatosAvistamiento().getHora08().size()){
            switch (posicion){
                case 0:
                    tv_DatosEspecieCamachuelo08.setText(String.valueOf(envio.getDatosAvistamiento().getHora08().get(posicion)));
                    break;
                case 1:
                    tv_DatosEspecieJilguero08.setText(String.valueOf(envio.getDatosAvistamiento().getHora08().get(posicion)));
                    break;
                case 2:
                    tv_DatosEspecieLugano08.setText(String.valueOf(envio.getDatosAvistamiento().getHora08().get(posicion)));
                    break;
                case 3:
                    tv_DatosEspeciePardilloComun08.setText(String.valueOf(envio.getDatosAvistamiento().getHora08().get(posicion)));
                    break;
                case 4:
                    tv_DatosEspeciePicogordo08.setText(String.valueOf(envio.getDatosAvistamiento().getHora08().get(posicion)));
                    break;
                case 5:
                    tv_DatosEspeciePinzonComun08.setText(String.valueOf(envio.getDatosAvistamiento().getHora08().get(posicion)));
                    break;
                case 6:
                    tv_DatosEspeciePinzonReal08.setText(String.valueOf(envio.getDatosAvistamiento().getHora08().get(posicion)));
                    break;
                case 7:
                    tv_DatosEspeciePiquituerto08.setText(String.valueOf(envio.getDatosAvistamiento().getHora08().get(posicion)));
                    break;
                case 8:
                    tv_DatosEspecieVerdecillo08.setText(String.valueOf(envio.getDatosAvistamiento().getHora08().get(posicion)));
                    break;
                case 9:
                    tv_DatosEspecieVerderonComun08.setText(String.valueOf(envio.getDatosAvistamiento().getHora08().get(posicion)));
                    break;
                case 10:
                    tv_DatosEspecieVerderonSerrano08.setText(String.valueOf(envio.getDatosAvistamiento().getHora08().get(posicion)));
                    break;
            }
            posicion++;
        }

        posicion = 0;
        while (posicion < envio.getDatosAvistamiento().getHora09().size()){
            switch (posicion){
                case 0:
                    tv_DatosEspecieCamachuelo09.setText(String.valueOf(envio.getDatosAvistamiento().getHora09().get(posicion)));
                    break;
                case 1:
                    tv_DatosEspecieJilguero09.setText(String.valueOf(envio.getDatosAvistamiento().getHora09().get(posicion)));
                    break;
                case 2:
                    tv_DatosEspecieLugano09.setText(String.valueOf(envio.getDatosAvistamiento().getHora09().get(posicion)));
                    break;
                case 3:
                    tv_DatosEspeciePardilloComun09.setText(String.valueOf(envio.getDatosAvistamiento().getHora09().get(posicion)));
                    break;
                case 4:
                    tv_DatosEspeciePicogordo09.setText(String.valueOf(envio.getDatosAvistamiento().getHora09().get(posicion)));
                    break;
                case 5:
                    tv_DatosEspeciePinzonComun09.setText(String.valueOf(envio.getDatosAvistamiento().getHora09().get(posicion)));
                    break;
                case 6:
                    tv_DatosEspeciePinzonReal09.setText(String.valueOf(envio.getDatosAvistamiento().getHora09().get(posicion)));
                    break;
                case 7:
                    tv_DatosEspeciePiquituerto09.setText(String.valueOf(envio.getDatosAvistamiento().getHora09().get(posicion)));
                    break;
                case 8:
                    tv_DatosEspecieVerdecillo09.setText(String.valueOf(envio.getDatosAvistamiento().getHora09().get(posicion)));
                    break;
                case 9:
                    tv_DatosEspecieVerderonComun09.setText(String.valueOf(envio.getDatosAvistamiento().getHora09().get(posicion)));
                    break;
                case 10:
                    tv_DatosEspecieVerderonSerrano09.setText(String.valueOf(envio.getDatosAvistamiento().getHora09().get(posicion)));
                    break;
            }
            posicion++;
        }

        posicion = 0;
        while (posicion < envio.getDatosAvistamiento().getHora10().size()){
            switch (posicion){
                case 0:
                    tv_DatosEspecieCamachuelo10.setText(String.valueOf(envio.getDatosAvistamiento().getHora10().get(posicion)));
                    break;
                case 1:
                    tv_DatosEspecieJilguero10.setText(String.valueOf(envio.getDatosAvistamiento().getHora10().get(posicion)));
                    break;
                case 2:
                    tv_DatosEspecieLugano10.setText(String.valueOf(envio.getDatosAvistamiento().getHora10().get(posicion)));
                    break;
                case 3:
                    tv_DatosEspeciePardilloComun10.setText(String.valueOf(envio.getDatosAvistamiento().getHora10().get(posicion)));
                    break;
                case 4:
                    tv_DatosEspeciePicogordo10.setText(String.valueOf(envio.getDatosAvistamiento().getHora10().get(posicion)));
                    break;
                case 5:
                    tv_DatosEspeciePinzonComun10.setText(String.valueOf(envio.getDatosAvistamiento().getHora10().get(posicion)));
                    break;
                case 6:
                    tv_DatosEspeciePinzonReal10.setText(String.valueOf(envio.getDatosAvistamiento().getHora10().get(posicion)));
                    break;
                case 7:
                    tv_DatosEspeciePiquituerto10.setText(String.valueOf(envio.getDatosAvistamiento().getHora10().get(posicion)));
                    break;
                case 8:
                    tv_DatosEspecieVerdecillo10.setText(String.valueOf(envio.getDatosAvistamiento().getHora10().get(posicion)));
                    break;
                case 9:
                    tv_DatosEspecieVerderonComun10.setText(String.valueOf(envio.getDatosAvistamiento().getHora10().get(posicion)));
                    break;
                case 10:
                    tv_DatosEspecieVerderonSerrano10.setText(String.valueOf(envio.getDatosAvistamiento().getHora10().get(posicion)));
                    break;
            }
            posicion++;
        }

        posicion = 0;
        while (posicion < envio.getDatosAvistamiento().getHora11().size()){
            switch (posicion){
                case 0:
                    tv_DatosEspecieCamachuelo11.setText(String.valueOf(envio.getDatosAvistamiento().getHora11().get(posicion)));
                    break;
                case 1:
                    tv_DatosEspecieJilguero11.setText(String.valueOf(envio.getDatosAvistamiento().getHora11().get(posicion)));
                    break;
                case 2:
                    tv_DatosEspecieLugano11.setText(String.valueOf(envio.getDatosAvistamiento().getHora11().get(posicion)));
                    break;
                case 3:
                    tv_DatosEspeciePardilloComun11.setText(String.valueOf(envio.getDatosAvistamiento().getHora11().get(posicion)));
                    break;
                case 4:
                    tv_DatosEspeciePicogordo11.setText(String.valueOf(envio.getDatosAvistamiento().getHora11().get(posicion)));
                    break;
                case 5:
                    tv_DatosEspeciePinzonComun11.setText(String.valueOf(envio.getDatosAvistamiento().getHora11().get(posicion)));
                    break;
                case 6:
                    tv_DatosEspeciePinzonReal11.setText(String.valueOf(envio.getDatosAvistamiento().getHora11().get(posicion)));
                    break;
                case 7:
                    tv_DatosEspeciePiquituerto11.setText(String.valueOf(envio.getDatosAvistamiento().getHora11().get(posicion)));
                    break;
                case 8:
                    tv_DatosEspecieVerdecillo11.setText(String.valueOf(envio.getDatosAvistamiento().getHora11().get(posicion)));
                    break;
                case 9:
                    tv_DatosEspecieVerderonComun11.setText(String.valueOf(envio.getDatosAvistamiento().getHora11().get(posicion)));
                    break;
                case 10:
                    tv_DatosEspecieVerderonSerrano11.setText(String.valueOf(envio.getDatosAvistamiento().getHora11().get(posicion)));
                    break;
            }
            posicion++;
        }

        posicion = 0;
        while (posicion < envio.getDatosAvistamiento().getHora12().size()){
            switch (posicion){
                case 0:
                    tv_DatosEspecieCamachuelo12.setText(String.valueOf(envio.getDatosAvistamiento().getHora12().get(posicion)));
                    break;
                case 1:
                    tv_DatosEspecieJilguero12.setText(String.valueOf(envio.getDatosAvistamiento().getHora12().get(posicion)));
                    break;
                case 2:
                    tv_DatosEspecieLugano12.setText(String.valueOf(envio.getDatosAvistamiento().getHora12().get(posicion)));
                    break;
                case 3:
                    tv_DatosEspeciePardilloComun12.setText(String.valueOf(envio.getDatosAvistamiento().getHora12().get(posicion)));
                    break;
                case 4:
                    tv_DatosEspeciePicogordo12.setText(String.valueOf(envio.getDatosAvistamiento().getHora12().get(posicion)));
                    break;
                case 5:
                    tv_DatosEspeciePinzonComun12.setText(String.valueOf(envio.getDatosAvistamiento().getHora12().get(posicion)));
                    break;
                case 6:
                    tv_DatosEspeciePinzonReal12.setText(String.valueOf(envio.getDatosAvistamiento().getHora12().get(posicion)));
                    break;
                case 7:
                    tv_DatosEspeciePiquituerto12.setText(String.valueOf(envio.getDatosAvistamiento().getHora12().get(posicion)));
                    break;
                case 8:
                    tv_DatosEspecieVerdecillo12.setText(String.valueOf(envio.getDatosAvistamiento().getHora12().get(posicion)));
                    break;
                case 9:
                    tv_DatosEspecieVerderonComun12.setText(String.valueOf(envio.getDatosAvistamiento().getHora12().get(posicion)));
                    break;
                case 10:
                    tv_DatosEspecieVerderonSerrano12.setText(String.valueOf(envio.getDatosAvistamiento().getHora12().get(posicion)));
                    break;
            }
            posicion++;
        }

        posicion = 0;
        while (posicion < envio.getDatosAvistamiento().getHora13().size()){
            switch (posicion){
                case 0:
                    tv_DatosEspecieCamachuelo13.setText(String.valueOf(envio.getDatosAvistamiento().getHora13().get(posicion)));
                    break;
                case 1:
                    tv_DatosEspecieJilguero13.setText(String.valueOf(envio.getDatosAvistamiento().getHora13().get(posicion)));
                    break;
                case 2:
                    tv_DatosEspecieLugano13.setText(String.valueOf(envio.getDatosAvistamiento().getHora13().get(posicion)));
                    break;
                case 3:
                    tv_DatosEspeciePardilloComun13.setText(String.valueOf(envio.getDatosAvistamiento().getHora13().get(posicion)));
                    break;
                case 4:
                    tv_DatosEspeciePicogordo13.setText(String.valueOf(envio.getDatosAvistamiento().getHora13().get(posicion)));
                    break;
                case 5:
                    tv_DatosEspeciePinzonComun13.setText(String.valueOf(envio.getDatosAvistamiento().getHora13().get(posicion)));
                    break;
                case 6:
                    tv_DatosEspeciePinzonReal13.setText(String.valueOf(envio.getDatosAvistamiento().getHora13().get(posicion)));
                    break;
                case 7:
                    tv_DatosEspeciePiquituerto13.setText(String.valueOf(envio.getDatosAvistamiento().getHora13().get(posicion)));
                    break;
                case 8:
                    tv_DatosEspecieVerdecillo13.setText(String.valueOf(envio.getDatosAvistamiento().getHora13().get(posicion)));
                    break;
                case 9:
                    tv_DatosEspecieVerderonComun13.setText(String.valueOf(envio.getDatosAvistamiento().getHora13().get(posicion)));
                    break;
                case 10:
                    tv_DatosEspecieVerderonSerrano13.setText(String.valueOf(envio.getDatosAvistamiento().getHora13().get(posicion)));
                    break;
            }
            posicion++;
        }

        posicion = 0;
        while (posicion < envio.getDatosAvistamiento().getHora14().size()){
            switch (posicion){
                case 0:
                    tv_DatosEspecieCamachuelo14.setText(String.valueOf(envio.getDatosAvistamiento().getHora14().get(posicion)));
                    break;
                case 1:
                    tv_DatosEspecieJilguero14.setText(String.valueOf(envio.getDatosAvistamiento().getHora14().get(posicion)));
                    break;
                case 2:
                    tv_DatosEspecieLugano14.setText(String.valueOf(envio.getDatosAvistamiento().getHora14().get(posicion)));
                    break;
                case 3:
                    tv_DatosEspeciePardilloComun14.setText(String.valueOf(envio.getDatosAvistamiento().getHora14().get(posicion)));
                    break;
                case 4:
                    tv_DatosEspeciePicogordo14.setText(String.valueOf(envio.getDatosAvistamiento().getHora14().get(posicion)));
                    break;
                case 5:
                    tv_DatosEspeciePinzonComun14.setText(String.valueOf(envio.getDatosAvistamiento().getHora14().get(posicion)));
                    break;
                case 6:
                    tv_DatosEspeciePinzonReal14.setText(String.valueOf(envio.getDatosAvistamiento().getHora14().get(posicion)));
                    break;
                case 7:
                    tv_DatosEspeciePiquituerto14.setText(String.valueOf(envio.getDatosAvistamiento().getHora14().get(posicion)));
                    break;
                case 8:
                    tv_DatosEspecieVerdecillo14.setText(String.valueOf(envio.getDatosAvistamiento().getHora14().get(posicion)));
                    break;
                case 9:
                    tv_DatosEspecieVerderonComun14.setText(String.valueOf(envio.getDatosAvistamiento().getHora14().get(posicion)));
                    break;
                case 10:
                    tv_DatosEspecieVerderonSerrano14.setText(String.valueOf(envio.getDatosAvistamiento().getHora14().get(posicion)));
                    break;
            }
            posicion++;
        }

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

}
