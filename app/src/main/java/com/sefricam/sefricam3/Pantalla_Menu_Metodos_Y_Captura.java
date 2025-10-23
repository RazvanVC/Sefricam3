package com.sefricam.sefricam3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import com.sefricam.sefricam3.GridRegistry;

public class Pantalla_Menu_Metodos_Y_Captura extends Activity implements View.OnClickListener {

    // UI Parameters
    private Button btn_DatosAves;
    private Button btn_DatosEntorno;
    private Button btn_DatosMetodos;
    private Button btn_DatosAvistamiento;
    private Button btn_MiEnvio;
    private Button btn_Enviar;
    private Button btn_Volver;
    private TextView tv_Fecha;
    private EditText etnd_Latitud;
    private EditText etnd_Longitud;

    // Class Parameters
    private Envio envio;
    private Limites limites;

    /**
     * Initialize the screen and all its components
     * @param savedInstanceState bundle of data that receives when it starts the screen
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_menu_metodos_y_capturas);

        startFindView();
        setOnClickListener();

        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            retrieveData(datos);
            if (envio.isMCapturaCompletado() && envio.isAvistamientoCompletado() && envio.isEntornoCompletado() && !envio.isEnvioCompletado()){
                Toast.makeText(this, "Ya puedes enviar los datos e introducir la latitud y longitud, asi como la fecha", Toast.LENGTH_LONG).show();
                tv_Fecha.setEnabled(true);
                etnd_Latitud.setEnabled(true);
                etnd_Longitud.setEnabled(true);
                btn_Enviar.setEnabled(true);
                btn_Enviar.setBackgroundResource(R.drawable.boton_redondeado);
            }
            if (envio.isEnvioCompletado()){
                tv_Fecha.setText(convertDateToString(envio.getFecha()));
                etnd_Latitud.setText(String.valueOf(envio.getLatitud()));
                etnd_Longitud.setText(String.valueOf(envio.getLongitud()));
                enableDataButtons(envio.isModificacion());
                if (envio.isModificacion()) btn_Enviar.setText(R.string.PMMC_btn_Modificar);
            }
            // Comprobacion de Datos, descomentar la lineas de codigo cuando quieras comprobar los parametros que vas recibiendo
            envio.printData(this.getClass().getName());
        }
    }

    /**
     * Init the UI elements into the code
     */
    private void startFindView() {

        //Button
        btn_DatosAves = findViewById(R.id.btn_DatosAves);
        btn_DatosAvistamiento = findViewById(R.id.btn_DatosAvistamientos);
        btn_DatosMetodos = findViewById(R.id.btn_MetodosCaptura);
        btn_DatosEntorno = findViewById(R.id.btn_DatosEntorno);
        btn_MiEnvio = findViewById(R.id.btn_MiEnvio);
        btn_Volver = findViewById(R.id.btn_VolverMenuPrincipalMC);
        btn_Enviar = findViewById(R.id.btn_EnviarMC);

        //Text View
        tv_Fecha = findViewById(R.id.tv_FechaDeTomaIntroducida);
        etnd_Latitud = findViewById(R.id.etnd_Latitud);
        etnd_Longitud = findViewById(R.id.etnd_Longitud);
    }

    /**
     * Sets all the click listener for the UI elements
     */
    public void setOnClickListener(){
        //Button
        btn_DatosAves.setOnClickListener(this);
        btn_DatosAvistamiento.setOnClickListener(this);
        btn_DatosMetodos.setOnClickListener(this);
        btn_DatosEntorno.setOnClickListener(this);
        btn_MiEnvio.setOnClickListener(this);
        btn_Enviar.setOnClickListener(this);
        btn_Volver.setOnClickListener(this);

        //EditText
        tv_Fecha.setOnClickListener(this);
    }

    /**
     * Called when the activity has detected the user's press of the back
     * key.  The default implementation simply finishes the current activity,
     * but you can override this to do whatever you want.
     */
    @Override
    public void onBackPressed() {
        if (!envio.isEnvioCompletado()){
            AlertDialog.Builder exit = new AlertDialog.Builder(this);
            exit.setMessage("Aun no se han enviado los datos\n¿Desea volver sin enviar?");
            exit.setPositiveButton("SI", (dialog, which) -> {
                Intent activity = new Intent(Pantalla_Menu_Metodos_Y_Captura.this, Pantalla_Menu_Intermedio.class);
                activity.putExtra("EMAIL",envio.getEmail());
                activity.putExtra("LIMITES", limites);
                startActivity(activity);
                finish();
            });
            exit.setNegativeButton("NO", (dialog, which) -> dialog.cancel());

            AlertDialog dialog = exit.create();
            dialog.show();
        } else if (envio.isModificacion()){
            AlertDialog.Builder exit = new AlertDialog.Builder(this);
            exit.setMessage("Si vuelves los cambios no enviados no se guardarán\n¿Desea volver igualmente?");
            exit.setPositiveButton("SI", (dialog, which) -> {
                Intent activity = new Intent(Pantalla_Menu_Metodos_Y_Captura.this, Pantalla_Menu_Intermedio.class);
                activity.putExtra("EMAIL",envio.getEmail());
                activity.putExtra("LIMITES", limites);
                startActivity(activity);
                finish();
            });
            exit.setNegativeButton("NO", (dialog, which) -> dialog.cancel());

            AlertDialog dialog = exit.create();
            dialog.show();
        } else {
            Intent activity = new Intent(Pantalla_Menu_Metodos_Y_Captura.this, Pantalla_Menu_Intermedio.class);
            activity.putExtra("EMAIL",envio.getEmail());
            activity.putExtra("LIMITES", limites);
            startActivity(activity);
            finish();
        }
    }

    /**
     * Handle the onClick event for the UI elements
     * @param view the view that was clicked
     */
    @Override
    public void onClick(View view){
        if (view == tv_Fecha){
            // Get Current Date
            final Calendar c = Calendar.getInstance();
            c.setTimeZone(TimeZone.getTimeZone("UTC"));
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            @SuppressLint("SetTextI18n") DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    (view1, year, monthOfYear, dayOfMonth) -> tv_Fecha.setText(dayOfMonth+"-"+(monthOfYear+1)+"-"+year), mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (view == btn_DatosAves){
            Intent activity;
            if (envio.isModificacion()) activity = new Intent(Pantalla_Menu_Metodos_Y_Captura.this, Pantalla_Modificacion_Aves.class);
            else activity = new Intent(Pantalla_Menu_Metodos_Y_Captura.this, Pantalla_Datos_Aves.class);
            Calendar c = Calendar.getInstance();
            c.setTime(envio.getFecha());
            c.setTimeZone(TimeZone.getTimeZone("UTC"));
            c.add(Calendar.HOUR, 2);
            if (c.get(Calendar.HOUR_OF_DAY)>=22) c.add(Calendar.HOUR,-20);
            activity.putExtra("AVE", new DatosAves(limites.getNumeroGrupo(),c.getTime(),envio.getLatitud(),envio.getLongitud()));
            saveData(activity);
            startActivity(activity);
            finish();
        }
        if (view == btn_DatosEntorno){
            Intent activity = new Intent(this, Pantalla_Datos_Entorno.class);
            saveData(activity);
            startActivity(activity);
            finish();
        }
        if (view == btn_DatosMetodos){
            Intent activity = new Intent(this, Pantalla_Metodos_Captura.class);
            saveData(activity);
            startActivity(activity);
            finish();
        }
        if (view == btn_DatosAvistamiento){
            Intent activity = new Intent(this,Pantalla_Datos_Avistamiento.class);
            saveData(activity);
            startActivity(activity);
            finish();
        }
        if (view == btn_MiEnvio){
            Intent activity = new Intent(this, Pantalla_Mi_Envio.class);
            saveData(activity);
            startActivity(activity);
            finish();
        }
        if (view == btn_Enviar){
            if (envio.isModificacion()){
                updateObject();
            } else {
                if (comprobarValores()){
                    tv_Fecha.setClickable(false);
                    etnd_Latitud.setEnabled(false);
                    etnd_Longitud.setEnabled(false);
                    setValues();
                    sendObject();
                    envio.setEnvioCompletado(true);
                } else {
                    Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_LONG).show();
                }
                System.out.println(comprobarValores());
            }
        }
        if (view == btn_Volver){
            onBackPressed();
        }
    }

    /**
     * Sets the fields for the ParseObject to send or modify
     * @param entity Datos_Entorno instance where are saved the fields
     */
    private void assignFields(ParseObject entity) {

        Calendar c = Calendar.getInstance();
        c.setTime(envio.getFecha());
        c.setTimeZone(TimeZone.getTimeZone("UTC"));
        c.add(Calendar.HOUR, 2);
        if (c.get(Calendar.HOUR_OF_DAY)>=22) c.add(Calendar.HOUR,-20);
        entity.put("Fecha",c.getTime());
        entity.put("Latitud",envio.getLatitud());
        entity.put("Longitud",envio.getLongitud());
        entity.put("Cuadricula", cuadricula());
        entity.put("DNI",envio.getDNI());
        entity.put("NumGrupo", limites.getNumeroGrupo());

        //Entorno
        entity.put("TempInicial",envio.getDatosEntorno().getTInicio());
        entity.put("TempFinal",envio.getDatosEntorno().getTFin());
        entity.put("Zonificacion",envio.getDatosEntorno().getZonificacion());
        entity.put("Viento",envio.getDatosEntorno().getViento());
        entity.put("DirViento",envio.getDatosEntorno().getDireccionViento());
        entity.put("Nubes",envio.getDatosEntorno().getNubes());
        entity.put("Lluvia",envio.getDatosEntorno().getLluvia());

        //Plantas
        entity.put("EP01", envio.getDatosEntorno().getPlantas().get(0));
        entity.put("EP02", envio.getDatosEntorno().getPlantas().get(1));
        entity.put("EP03", envio.getDatosEntorno().getPlantas().get(2));
        entity.put("EP04", envio.getDatosEntorno().getPlantas().get(3));
        entity.put("EP05", envio.getDatosEntorno().getPlantas().get(4));
        entity.put("EP06", envio.getDatosEntorno().getPlantas().get(5));
        entity.put("EP07", envio.getDatosEntorno().getPlantas().get(6));
        entity.put("EP08", envio.getDatosEntorno().getPlantas().get(7));
        entity.put("EP09", envio.getDatosEntorno().getPlantas().get(8));
        entity.put("EP10", envio.getDatosEntorno().getPlantas().get(9));
        entity.put("EP11", envio.getDatosEntorno().getPlantas().get(10));
        entity.put("EP12", envio.getDatosEntorno().getPlantas().get(11));
        entity.put("EP13", envio.getDatosEntorno().getPlantas().get(12));
        entity.put("EP14", envio.getDatosEntorno().getPlantas().get(13));
        entity.put("EP15", envio.getDatosEntorno().getPlantas().get(14));
        entity.put("EP16", envio.getDatosEntorno().getPlantas().get(15));
        entity.put("EP17", envio.getDatosEntorno().getPlantas().get(16));
        entity.put("EP18", envio.getDatosEntorno().getPlantas().get(17));
        entity.put("EP19", envio.getDatosEntorno().getPlantas().get(18));
        entity.put("EP20", envio.getDatosEntorno().getPlantas().get(19));
        entity.put("EP21", envio.getDatosEntorno().getPlantas().get(20));
        entity.put("EP22", envio.getDatosEntorno().getPlantas().get(21));
        entity.put("EP23", envio.getDatosEntorno().getPlantas().get(22));
        entity.put("EP24", envio.getDatosEntorno().getPlantas().get(23));
        entity.put("EP25", envio.getDatosEntorno().getPlantas().get(24));
        entity.put("EP26", envio.getDatosEntorno().getPlantas().get(25));
        entity.put("EP27", envio.getDatosEntorno().getPlantas().get(26));
        entity.put("EP28", envio.getDatosEntorno().getPlantas().get(27));
        entity.put("EP29", envio.getDatosEntorno().getPlantas().get(28));
        entity.put("EP30", envio.getDatosEntorno().getPlantas().get(29));
        entity.put("EP31", envio.getDatosEntorno().getPlantas().get(30));
        entity.put("EP32", envio.getDatosEntorno().getPlantas().get(31));
        entity.put("EP33", envio.getDatosEntorno().getPlantas().get(32));
        entity.put("EP34", envio.getDatosEntorno().getPlantas().get(33));
        entity.put("EP35", envio.getDatosEntorno().getPlantas().get(34));
        entity.put("EP36", envio.getDatosEntorno().getPlantas().get(35));
        entity.put("EP39", envio.getDatosEntorno().getPlantas().get(36));
        entity.put("EP40", envio.getDatosEntorno().getPlantas().get(37));
        entity.put("EP41", envio.getDatosEntorno().getPlantas().get(38));
        entity.put("EP42", envio.getDatosEntorno().getPlantas().get(39));
        entity.put("EP43", envio.getDatosEntorno().getPlantas().get(40));
        entity.put("EP44", envio.getDatosEntorno().getPlantas().get(41));
        entity.put("EP37", envio.getDatosEntorno().getEP37());
        entity.put("EP38", envio.getDatosEntorno().getEP38());

        //Metodos Captura
        entity.put("Participantes", envio.getMetodosCaptura().getNumeroParticipantes());
        entity.put("NumMallas", envio.getMetodosCaptura().getNumeroMallas());
        entity.put("LongRed",envio.getMetodosCaptura().getLongitudRed());
        entity.put("Coto",envio.getMetodosCaptura().isCoto());

        entity.put("CA01", envio.getMetodosCaptura().getControlAgentes().get(0));
        entity.put("CA02", envio.getMetodosCaptura().getControlAgentes().get(1));
        entity.put("CA03", envio.getMetodosCaptura().getControlAgentes().get(2));
        entity.put("CA04", envio.getMetodosCaptura().getControlAgentes().get(3));
        entity.put("CA05", envio.getMetodosCaptura().getControlAgentes().get(4));
        entity.put("CA06", envio.getMetodosCaptura().getControlAgentes().get(5));

        entity.put("RecCamachuelo", envio.getMetodosCaptura().getReclamosCamachuelo());
        entity.put("CapCamachueloM", envio.getMetodosCaptura().getCapturasCamachueloM());
        entity.put("CapCamachueloH", envio.getMetodosCaptura().getCapturasCamachueloH());
        entity.put("CimCamachuelo", envio.getMetodosCaptura().getCimbelesCamachuelo());

        entity.put("RecJilguero", envio.getMetodosCaptura().getReclamosJilguero());
        entity.put("CapJilgueroM", envio.getMetodosCaptura().getCapturasJilgueroM());
        entity.put("CapJilgueroH", envio.getMetodosCaptura().getCapturasJilgueroH());
        entity.put("CimJilguero", envio.getMetodosCaptura().getCimbelesJilguero());

        entity.put("RecLugano", envio.getMetodosCaptura().getReclamosLugano());
        entity.put("CapLuganoM", envio.getMetodosCaptura().getCapturasLuganoM());
        entity.put("CapLuganoH", envio.getMetodosCaptura().getCapturasLuganoH());
        entity.put("CimLugano", envio.getMetodosCaptura().getCimbelesLugano());

        entity.put("RecPardComun", envio.getMetodosCaptura().getReclamosPardComun());
        entity.put("CapPardComunM", envio.getMetodosCaptura().getCapturasPardComunM());
        entity.put("CapPardComunH", envio.getMetodosCaptura().getCapturasPardComunH());
        entity.put("CimPardComun", envio.getMetodosCaptura().getCimbelesPardComun());

        entity.put("RecPicogordo", envio.getMetodosCaptura().getReclamosPicogordo());
        entity.put("CapPicogordoM", envio.getMetodosCaptura().getCapturasPicogordoM());
        entity.put("CapPicogordoH", envio.getMetodosCaptura().getCapturasPicogordoH());
        entity.put("CimPicogordo", envio.getMetodosCaptura().getCimbelesPicogordo());

        entity.put("RecPinzComun", envio.getMetodosCaptura().getReclamosPinzonComun());
        entity.put("CapPinzComunM", envio.getMetodosCaptura().getCapturasPinzonComunM());
        entity.put("CapPinzComunH", envio.getMetodosCaptura().getCapturasPinzonComunH());
        entity.put("CimPinzComun", envio.getMetodosCaptura().getCimbelesPinzonComun());

        entity.put("RecPinzReal", envio.getMetodosCaptura().getReclamosPinzonReal());
        entity.put("CapPinzRealM", envio.getMetodosCaptura().getCapturasPinzonRealM());
        entity.put("CapPinzRealH", envio.getMetodosCaptura().getCapturasPinzonRealH());
        entity.put("CimPinzReal", envio.getMetodosCaptura().getCimbelesPinzonReal());

        entity.put("RecPiquituerto", envio.getMetodosCaptura().getReclamosPiquituerto());
        entity.put("CapPiquituertoM", envio.getMetodosCaptura().getCapturasPiquituertoM());
        entity.put("CapPiquituertoH", envio.getMetodosCaptura().getCapturasPiquituertoH());
        entity.put("CimPiquituerto", envio.getMetodosCaptura().getCimbelesPiquituerto());

        entity.put("RecVerdecillo", envio.getMetodosCaptura().getReclamosVerdecillo());
        entity.put("CapVerdecilloM", envio.getMetodosCaptura().getCapturasVerdecilloM());
        entity.put("CapVerdecilloH", envio.getMetodosCaptura().getCapturasVerdecilloH());
        entity.put("CimVerdecillo", envio.getMetodosCaptura().getCimbelesVerdecillo());

        entity.put("RecVerdComun", envio.getMetodosCaptura().getReclamosVerdComun());
        entity.put("CapVerdComunM", envio.getMetodosCaptura().getCapturasVerdComunM());
        entity.put("CapVerdComunH", envio.getMetodosCaptura().getCapturasVerdComunH());
        entity.put("CimVerdComun", envio.getMetodosCaptura().getCimbelesVerdComun());

        entity.put("RecVerdSerrano", envio.getMetodosCaptura().getReclamosVerdSerrano());
        entity.put("CapVerdSerranoM", envio.getMetodosCaptura().getCapturasVerdSerranoM());
        entity.put("CapVerdSerranoH", envio.getMetodosCaptura().getCapturasVerdSerranoH());
        entity.put("CimVerdSerrano", envio.getMetodosCaptura().getCimbelesVerdSerrano());

        entity.put("Observaciones",envio.getMetodosCaptura().getObservaciones());

        //Datos Avistamiento
        entity.put("HoraInicio",envio.getDatosAvistamiento().getHoraInicio());
        entity.put("HoraFin",envio.getDatosAvistamiento().getHoraFin());

        //Avistamientos Camachuelo
        entity.put("Cam08", envio.getDatosAvistamiento().getHora08().get(0));
        entity.put("Cam09", envio.getDatosAvistamiento().getHora09().get(0));
        entity.put("Cam10", envio.getDatosAvistamiento().getHora10().get(0));
        entity.put("Cam11", envio.getDatosAvistamiento().getHora11().get(0));
        entity.put("Cam12", envio.getDatosAvistamiento().getHora12().get(0));
        entity.put("Cam13", envio.getDatosAvistamiento().getHora13().get(0));
        entity.put("Cam14", envio.getDatosAvistamiento().getHora14().get(0));

        //Avistamientos Jilguero
        entity.put("Jil08", envio.getDatosAvistamiento().getHora08().get(1));
        entity.put("Jil09", envio.getDatosAvistamiento().getHora09().get(1));
        entity.put("Jil10", envio.getDatosAvistamiento().getHora10().get(1));
        entity.put("Jil11", envio.getDatosAvistamiento().getHora11().get(1));
        entity.put("Jil12", envio.getDatosAvistamiento().getHora12().get(1));
        entity.put("Jil13", envio.getDatosAvistamiento().getHora13().get(1));
        entity.put("Jil14", envio.getDatosAvistamiento().getHora14().get(1));

        //Avistamientos Lugano
        entity.put("Lug08", envio.getDatosAvistamiento().getHora08().get(2));
        entity.put("Lug09", envio.getDatosAvistamiento().getHora09().get(2));
        entity.put("Lug10", envio.getDatosAvistamiento().getHora10().get(2));
        entity.put("Lug11", envio.getDatosAvistamiento().getHora11().get(2));
        entity.put("Lug12", envio.getDatosAvistamiento().getHora12().get(2));
        entity.put("Lug13", envio.getDatosAvistamiento().getHora13().get(2));
        entity.put("Lug14", envio.getDatosAvistamiento().getHora14().get(2));

        //Avistamientos Pardillo Comun
        entity.put("PardC08", envio.getDatosAvistamiento().getHora08().get(3));
        entity.put("PardC09", envio.getDatosAvistamiento().getHora09().get(3));
        entity.put("PardC10", envio.getDatosAvistamiento().getHora10().get(3));
        entity.put("PardC11", envio.getDatosAvistamiento().getHora11().get(3));
        entity.put("PardC12", envio.getDatosAvistamiento().getHora12().get(3));
        entity.put("PardC13", envio.getDatosAvistamiento().getHora13().get(3));
        entity.put("PardC14", envio.getDatosAvistamiento().getHora14().get(3));

        //Avistamientos Picogordo
        entity.put("Pic08", envio.getDatosAvistamiento().getHora08().get(4));
        entity.put("Pic09", envio.getDatosAvistamiento().getHora09().get(4));
        entity.put("Pic10", envio.getDatosAvistamiento().getHora10().get(4));
        entity.put("Pic11", envio.getDatosAvistamiento().getHora11().get(4));
        entity.put("Pic12", envio.getDatosAvistamiento().getHora12().get(4));
        entity.put("Pic13", envio.getDatosAvistamiento().getHora13().get(4));
        entity.put("Pic14", envio.getDatosAvistamiento().getHora14().get(4));

        //Avistamientos
        entity.put("PinC08", envio.getDatosAvistamiento().getHora08().get(5));
        entity.put("PinC09", envio.getDatosAvistamiento().getHora09().get(5));
        entity.put("PinC10", envio.getDatosAvistamiento().getHora10().get(5));
        entity.put("PinC11", envio.getDatosAvistamiento().getHora11().get(5));
        entity.put("PinC12", envio.getDatosAvistamiento().getHora12().get(5));
        entity.put("PinC13", envio.getDatosAvistamiento().getHora13().get(5));
        entity.put("PinC14", envio.getDatosAvistamiento().getHora14().get(5));

        //Avistamientos
        entity.put("PinR08", envio.getDatosAvistamiento().getHora08().get(6));
        entity.put("PinR09", envio.getDatosAvistamiento().getHora09().get(6));
        entity.put("PinR10", envio.getDatosAvistamiento().getHora10().get(6));
        entity.put("PinR11", envio.getDatosAvistamiento().getHora11().get(6));
        entity.put("PinR12", envio.getDatosAvistamiento().getHora12().get(6));
        entity.put("PinR13", envio.getDatosAvistamiento().getHora13().get(6));
        entity.put("PinR14", envio.getDatosAvistamiento().getHora14().get(6));

        //Avistamientos
        entity.put("Piq08", envio.getDatosAvistamiento().getHora08().get(7));
        entity.put("Piq09", envio.getDatosAvistamiento().getHora09().get(7));
        entity.put("Piq10", envio.getDatosAvistamiento().getHora10().get(7));
        entity.put("Piq11", envio.getDatosAvistamiento().getHora11().get(7));
        entity.put("Piq12", envio.getDatosAvistamiento().getHora12().get(7));
        entity.put("Piq13", envio.getDatosAvistamiento().getHora13().get(7));
        entity.put("Piq14", envio.getDatosAvistamiento().getHora14().get(7));

        //Avistamientos
        entity.put("Verd08", envio.getDatosAvistamiento().getHora08().get(8));
        entity.put("Verd09", envio.getDatosAvistamiento().getHora09().get(8));
        entity.put("Verd10", envio.getDatosAvistamiento().getHora10().get(8));
        entity.put("Verd11", envio.getDatosAvistamiento().getHora11().get(8));
        entity.put("Verd12", envio.getDatosAvistamiento().getHora12().get(8));
        entity.put("Verd13", envio.getDatosAvistamiento().getHora13().get(8));
        entity.put("Verd14", envio.getDatosAvistamiento().getHora14().get(8));

        //Avistamientos
        entity.put("VerdC08", envio.getDatosAvistamiento().getHora08().get(9));
        entity.put("VerdC09", envio.getDatosAvistamiento().getHora09().get(9));
        entity.put("VerdC10", envio.getDatosAvistamiento().getHora10().get(9));
        entity.put("VerdC11", envio.getDatosAvistamiento().getHora11().get(9));
        entity.put("VerdC12", envio.getDatosAvistamiento().getHora12().get(9));
        entity.put("VerdC13", envio.getDatosAvistamiento().getHora13().get(9));
        entity.put("VerdC14", envio.getDatosAvistamiento().getHora14().get(9));

        //Avistamientos
        entity.put("VerdS08", envio.getDatosAvistamiento().getHora08().get(10));
        entity.put("VerdS09", envio.getDatosAvistamiento().getHora09().get(10));
        entity.put("VerdS10", envio.getDatosAvistamiento().getHora10().get(10));
        entity.put("VerdS11", envio.getDatosAvistamiento().getHora11().get(10));
        entity.put("VerdS12", envio.getDatosAvistamiento().getHora12().get(10));
        entity.put("VerdS13", envio.getDatosAvistamiento().getHora13().get(10));
        entity.put("VerdS14", envio.getDatosAvistamiento().getHora14().get(10));

        entity.put("VersionApp",envio.getVersionNumber());
    }

    /**
     * Sends a new Datos_Entorno object to the Parse Database
     */
    private void sendObject() {
        ParseObject entity = new ParseObject("Datos_Entorno");

        assignFields(entity);

        entity.saveInBackground(e -> {
            if (e==null){
                //Save was done
                updateUser();
                Toast.makeText(Pantalla_Menu_Metodos_Y_Captura.this, "Se ha realizado el envío correctamente", Toast.LENGTH_SHORT).show();
                enableDataButtons(envio.isModificacion());

            }else{
                //Something went wrong
                Toast.makeText(Pantalla_Menu_Metodos_Y_Captura.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * Sends a Datos_Entorno update to an object
     */
    private void updateObject() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Datos_Entorno");

        // Retrieve the object by id
        query.getInBackground(envio.getObjectID(), (entity, e) -> {
            if (e == null) {
                //Object was successfully retrieved
                // Update the fields we want to
                assignFields(entity);
                //All other fields will remain the same
                entity.saveInBackground(e1 -> {
                    if (e1 ==null){
                        Toast.makeText(Pantalla_Menu_Metodos_Y_Captura.this, "Se ha actualizado el envío correctamente", Toast.LENGTH_SHORT).show();

                    }else{
                        //Something went wrong
                        Toast.makeText(Pantalla_Menu_Metodos_Y_Captura.this, e1.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                // something went wrong
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * Updates User data with the new send
     */
    private void updateUser() {
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser!= null){
            int fichasEnviadas  = currentUser.getInt("NumFichas");
            fichasEnviadas++;
            currentUser.put("NumFichas", fichasEnviadas);
            currentUser.saveInBackground(e -> {
                if(e==null){
                    //Save successful
                    Toast.makeText(Pantalla_Menu_Metodos_Y_Captura.this, "Save Successful", Toast.LENGTH_SHORT).show();
                }else{
                    // Something went wrong while saving
                    Toast.makeText(Pantalla_Menu_Metodos_Y_Captura.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    /**
     * Convert Date to String
     * @param fecha Date value to convert to String
     * @return a formatted String value, extracted from the date
     */
    private String convertDateToString(Date fecha) {
        String today = null;
        @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Calendar c = Calendar.getInstance();
            assert fecha != null;
            c.setTimeZone(TimeZone.getTimeZone("UTC"));
            c.setTime(fecha);
            fecha = c.getTime();
            today = dateFormat.format(fecha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return today;
    }

    /**
     * Convert a String to Date
     * @param stringDate a String object that is wished to convert to Date Object
     * @return the Date Object that is obtained from formatting the String
     */
    public static Date convertStringToDate(String stringDate){
        Date today = null;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy");

        try {
            today = simpleDate.parse(stringDate);
            System.out.println(today);
            Calendar c = Calendar.getInstance();
            assert today != null;
            c.setTimeZone(TimeZone.getTimeZone("UTC"));
            c.setTime(today);
            today = c.getTime();
            System.out.println(today);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return today;
    }

    /**
     * Changes the button state if is an modification or not
     * @param modificacion true if is a modification, false if not
     */
    @SuppressLint("UseCompatLoadingForDrawables")
    private void enableDataButtons(boolean modificacion) {
        tv_Fecha.setClickable(false);
        etnd_Latitud.setEnabled(false);
        etnd_Longitud.setEnabled(false);
        btn_DatosAves.setEnabled(true);
        btn_DatosAves.setBackground(getDrawable(R.drawable.boton_semiredondeado));
        btn_DatosAves.setPadding(5,0,0,0);

        btn_DatosEntorno.setEnabled(modificacion);
        btn_DatosMetodos.setEnabled(modificacion);
        btn_DatosAvistamiento.setEnabled(modificacion);
        btn_Enviar.setEnabled(modificacion);

        if (modificacion){
            btn_DatosEntorno.setBackground(getDrawable(R.drawable.boton_semiredondeado));
            btn_DatosMetodos.setBackground(getDrawable(R.drawable.boton_semiredondeado));
            btn_DatosAvistamiento.setBackground(getDrawable(R.drawable.boton_semiredondeado));
            btn_Enviar.setBackground(getDrawable(R.drawable.boton_redondeado));
        } else {
            btn_DatosEntorno.setBackground(getDrawable(R.drawable.boton_semiredondeado_apagado));
            btn_DatosMetodos.setBackground(getDrawable(R.drawable.boton_semiredondeado_apagado));
            btn_DatosAvistamiento.setBackground(getDrawable(R.drawable.boton_semiredondeado_apagado));
            btn_Enviar.setBackground(getDrawable(R.drawable.boton_redondeado_apagado));
        }
    }

    /**
     * Sets Date, Latitude, and Longitude to the Envio Object
     */
    private void setValues() {
        envio.setFecha(convertStringToDate(tv_Fecha.getText().toString()));
        envio.setLatitud(Double.parseDouble(etnd_Latitud.getText().toString()));
        envio.setLongitud(Double.parseDouble(etnd_Longitud.getText().toString()));
    }

    /**
     * Checks if all the submitted data is in certain limits
     * @return true if all its alright, false if not
     */
    private boolean comprobarValores() {
        System.out.println(tv_Fecha.getText().toString().equals("__-__-____"));
        if (tv_Fecha.getText().toString().equals("__-__-____")) return false;
        if (etnd_Longitud.getText().toString().isEmpty()) return false;
        if (etnd_Latitud.getText().toString().isEmpty()) return false;
        try {
            Double.parseDouble(etnd_Longitud.getText().toString());
            Double.parseDouble(etnd_Latitud.getText().toString());
        } catch (Exception e){
            return false;
        }
        if (!(Double.parseDouble(etnd_Longitud.getText().toString())<limites.getMaxLon() && Double.parseDouble(etnd_Longitud.getText().toString())>limites.getMinLon())){
            Toast.makeText(this, "La longitud no se encuentra en los parámetros establecidos", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!(Double.parseDouble(etnd_Latitud.getText().toString())<limites.getMaxLat() && Double.parseDouble(etnd_Latitud.getText().toString())>limites.getMinLat())){
            Toast.makeText(this, "La latitud no se encuentra en los parámetros establecidos", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
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
     * Assign the Cuadricula field
     * @return Cuadricula code based on the coordinates
     */
    private String cuadricula(){// 1) Elige el conjunto de celdas (todas por defecto).
        java.util.List<GridRegistry.GridCell> cells = GridRegistry.all();

        // 2) Coordenadas del envío (grados, con signo ±)
        double lat = envio.getLatitud();
        double lon = envio.getLongitud();

        // 3) Encuentra la grid más cercana inyectando la distancia en KM
        GridRegistry.GridCell nearest = GridRegistry.findNearest(
                lat,    // (lat, lon)
                lon,
                cells,
                this::miDistanciaKm
        );

        // 4) Devuelve denominación o "ERROR" si no hay celdas
        return (nearest != null) ? nearest.denominacion() : "ERROR";

        /*
        //Primer valor
        double x = 12-((envio.getLongitud() - 3.123)/0.1159);
        if(x<0) x=0.0;
        x = Math.ceil(x);

        //Segundo valor
        double y = 14-((envio.getLatitud() - 39.937133)/0.08878954);
        if(y<0) y=0.0;
        y = Math.ceil(y);

        //Juntar los dos numeros
        int numCuadricula = Integer.parseInt(String.valueOf((int) x).concat(String.valueOf((int) y)));

        return switch (numCuadricula) {
            case 37 -> "01UKA10";
            case 38 -> "02UKB10";
            case 29 -> "03UKC09";
            case 39 -> "04UKC10";
            case 110 -> "05UKD08";
            case 210 -> "06UKD09";
            case 310 -> "07UKD10";
            case 111 -> "08UKE08";
            case 211 -> "09UKE09";
            case 91 -> "10VLE06";
            case 82 -> "11VLF05";
            case 92 -> "12VLF06";
            case 102 -> "13VLF07";
            case 63 -> "14VLG03";
            case 73 -> "15VLG04";
            case 83 -> "16VLG05";
            case 93 -> "17VLG06";
            case 103 -> "18VLG07";
            case 64 -> "19VLH03";
            case 74 -> "20VLH04";
            case 84 -> "21VLH05";
            case 94 -> "22VLH06";
            case 55 -> "23VLI02";
            case 65 -> "24VLI03";
            case 75 -> "25VLI04";
            case 85 -> "26VLI05";
            case 95 -> "27VLI06";
            case 46 -> "28VLJ01";
            case 56 -> "29VLJ02";
            case 66 -> "30VLJ03";
            case 76 -> "31VLJ04";
            case 86 -> "32VLJ05";
            case 96 -> "33VLJ06";
            case 47 -> "34VKA01";
            case 57 -> "35VKA02";
            case 67 -> "36VKA03";
            case 77 -> "37VKA04";
            case 87 -> "38VKA05";
            case 97 -> "39VKA06";
            case 107 -> "40VKA07";
            case 48 -> "41VKB01";
            case 58 -> "42VKB02";
            case 68 -> "43VKB03";
            case 78 -> "44VKB04";
            case 88 -> "45VKB05";
            case 98 -> "46VKB06";
            case 108 -> "47VKB07";
            case 118 -> "48VKB08";
            case 49 -> "49VKC01";
            case 59 -> "50VKC02";
            case 69 -> "51VKC03";
            case 79 -> "52VKC04";
            case 89 -> "53VKC05";
            case 99 -> "54VKC06";
            case 109 -> "55VKC07";
            case 119 -> "56VKC08";
            case 129 -> "57VKC09";
            case 410 -> "58VKD01";
            case 510 -> "59VKD02";
            case 610 -> "60VKD03";
            case 710 -> "61VKD04";
            case 810 -> "62VKD05";
            case 910 -> "63VKD06";
            case 1010 -> "64VKD07";
            case 1110 -> "65VKD08";
            case 1210 -> "66VKD09";
            case 411 -> "67VKE01";
            case 511 -> "68VKE02";
            case 611 -> "69VKE03";
            case 711 -> "70VKE04";
            case 811 -> "71VKE05";
            case 911 -> "72VKE06";
            case 1011 -> "73VKE07";
            case 1111 -> "74VKE08";
            case 1211 -> "75VKE09";
            case 712 -> "76VKF04";
            case 812 -> "77VKF05";
            case 912 -> "78VKF06";
            case 1012 -> "79VKF07";
            case 1112 -> "80VKF08";
            case 1212 -> "81VKF09";
            case 913 -> "82VKG06";
            case 1013 -> "83VKG07";
            case 1113 -> "84VKG08";
            case 1213 -> "85VKG09";
            case 814 -> "86VKH05";
            default -> "ERROR";
        };*/
    }

    /** Distancia Haversine en KM (lat/lon en grados). NO usa ABS, respeta signos ±. */
    private double miDistanciaKm(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371.0088; // km
        double phi1 = Math.toRadians(lat1);
        double phi2 = Math.toRadians(lat2);
        double dPhi = Math.toRadians(lat2 - lat1);
        double dLam = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dPhi/2)*Math.sin(dPhi/2)
                + Math.cos(phi1)*Math.cos(phi2)*Math.sin(dLam/2)*Math.sin(dLam/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
