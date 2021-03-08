package com.sefricam.sefricam3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Pantalla_Menu_Metodos_Y_Captura extends Activity implements View.OnClickListener, ActivityCompat.OnRequestPermissionsResultCallback{

    private Button btn_Localizar, btn_DatosAves, btn_DatosEntorno, btn_Metodos, btn_DatosAvistamiento, btn_Enviar, btn_Volver, btn_MiEnvio;
    private TextView tv_Fecha;
    private EditText etnd_Latitud, etnd_Longitud;

    private double latitud,longitud, datosEnviados;
    private Date fecha;

    private Map<String, ArrayList> avistamientos = new HashMap<>();


    //PARAMETROS QUE VAN ROTANDO
    private boolean envioCompletado;
    private MetodosCaptura metodosCaptura;
    private DatosAvistamiento datosAvistamiento;
    private DatosEntorno datosEntorno;
    private Limites limites;
    private boolean mCapturasCompletado,avistamientoCompletado,entornoCompletado;
    private String email;
    private String DNI;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_menu_metodos_y_capturas);

        iniciarFindView();
        iniciarOnClickListener();

        btn_DatosAves.setEnabled(true);

        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            recuperarDatosRecibidos(datos);

            if (envioCompletado){
                tv_Fecha.setText(datos.getString("FECHA"));
                etnd_Longitud.setText(String.valueOf(datos.getDouble("LONGITUD")));
                etnd_Latitud.setText(String.valueOf(datos.getDouble("LATITUD")));
                tv_Fecha.setClickable(false);
                //etnd_Latitud.setEnabled(false);
                //etnd_Longitud.setEnabled(false);

                //Desactivacion de botones
                //desactivarBotonesDatos();

            }
            System.out.println("Datos recibidos en Main Menu");
            imprimirDatosRecibidos();
        }
        if (mCapturasCompletado && avistamientoCompletado && entornoCompletado && !envioCompletado){
            Toast.makeText(this, "Ya puedes enviar los datos e introducir la latitud y longitud, asi como la fecha", Toast.LENGTH_LONG).show();
            tv_Fecha.setEnabled(true);
            etnd_Latitud.setEnabled(true);
            etnd_Longitud.setEnabled(true);
            btn_Enviar.setEnabled(true);
            etnd_Latitud.setText(datos.getString("LATITUD"));
            etnd_Longitud.setText(datos.getString("LONGITUD"));
            tv_Fecha.setText(datos.getString("FECHA"));
            btn_Enviar.setBackgroundResource(R.drawable.boton_redondeado);
        }
    }

    /**
     * Asigna a las variables creadas arriba su correspondiente boton de la actividad
     */
    private void iniciarFindView() {

        //Button
        btn_Localizar = (Button) findViewById(R.id.btn_LocalizacionActual);
        btn_DatosAves = (Button) findViewById(R.id.btn_DatosAves);
        btn_DatosAvistamiento = (Button) findViewById(R.id.btn_DatosAvistamientos);
        btn_Metodos = (Button) findViewById(R.id.btn_MetodosCaptura);
        btn_DatosEntorno = (Button) findViewById(R.id.btn_DatosEntorno);
        btn_MiEnvio = findViewById(R.id.btn_MiEnvio);
        btn_Volver = (Button) findViewById(R.id.btn_VolverMenuPrincipalMC);
        btn_Enviar = (Button) findViewById(R.id.btn_EnviarMC);

        //Text View
        tv_Fecha = findViewById(R.id.tv_FechaDeTomaIntroducida);
        etnd_Latitud = findViewById(R.id.etnd_Latitud);
        etnd_Longitud = findViewById(R.id.etnd_Longitud);
    }

    /**
     * Inicia todos los click listeners para que los botones sean funcionales
     */
    public void iniciarOnClickListener(){
        //Button
        btn_Localizar.setOnClickListener(this);
        btn_DatosAves.setOnClickListener(this);
        btn_DatosAvistamiento.setOnClickListener(this);
        btn_Metodos.setOnClickListener(this);
        btn_DatosEntorno.setOnClickListener(this);
        btn_MiEnvio.setOnClickListener(this);
        btn_Enviar.setOnClickListener(this);
        btn_Volver.setOnClickListener(this);

        //EditText
        tv_Fecha.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
         /*if (view == btn_Localizar){

            ActivityCompat.requestPermissions(Pantalla_Menu_Metodos_Y_Captura.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this, "No se pudo realizar la validación", Toast.LENGTH_SHORT).show();

                return;
            }else
            {
                LocationManager locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                Location loc = locManager.getLastKnownLocation(GPS_PROVIDER);
                etnd_Longitud.setText(String.valueOf(loc.getLongitude()));
                etnd_Latitud.setText(String.valueOf(loc.getLatitude()));
            }
        }*/
        if (view == tv_Fecha){
            final Calendar c = Calendar.getInstance();
            Date dt = new Date(System.currentTimeMillis());
            c.setTime(dt);
            int dia = 1;
            int mes = c.get(Calendar.MONTH);
            int ano = c.get(Calendar.YEAR);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onDateSet(DatePicker datePicker, int dayOfMonth, int month, int year) {

                    tv_Fecha.setText(year + "/" + (month+1) + "/" + dayOfMonth);
                }
            },dia, mes, ano);

            datePickerDialog.updateDate(ano, mes,1);
            datePickerDialog.show();
        }
        if (view == btn_DatosAves){
            System.out.println("Boton Datos de Aves");
            Intent activity = new Intent(Pantalla_Menu_Metodos_Y_Captura.this,Pantalla_Datos_Aves.class);
            guardarParametros(activity);

            startActivity(activity);
            finish();
        }
        if (view == btn_DatosEntorno){
            System.out.println("Boton Datos de Entorno");
            Intent activity = new Intent(this, Pantalla_Datos_Entorno.class);
            guardarParametros(activity);

            startActivity(activity);
            finish();
        }
        if (view == btn_Metodos){
            System.out.println("Boton Metodos de Captura");
            Intent activity = new Intent(this, Pantalla_Metodos_Captura.class);
            guardarParametros(activity);

            startActivity(activity);
            finish();
        }
        if (view == btn_DatosAvistamiento){
            System.out.println("Boton Datos de Avistamiento");
            Intent activity = new Intent(this,Pantalla_Datos_Avistamiento.class);
            guardarParametros(activity);

            startActivity(activity);
            finish();
        }
        if (view == btn_MiEnvio){
            System.out.println("Boton de Mi Envio");
            Intent activity = new Intent(this, Pantalla_Mi_Envio.class);
            guardarParametros(activity);

            startActivity(activity);
            finish();

        }
        if (view == btn_Enviar){

            if (comprobarValores()){
                //actualizarDatosEnviados();
                tv_Fecha.setClickable(false);
                etnd_Latitud.setEnabled(false);
                etnd_Longitud.setEnabled(false);
                asignacionValores();
                envioDatos();
                envioCompletado = true;

            } else {
                //Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_LONG).show();
            }
        }
        if (view == btn_Volver){
            Intent activity = new Intent(Pantalla_Menu_Metodos_Y_Captura.this, Pantalla_Menu_Intermedio.class);
            activity.putExtra("EMAIL",email);
            activity.putExtra("LIMITES", limites);
            startActivity(activity);
            finish();
        }

    }

    public static Date convertStringToData(String getDate){
        Date today = null;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");

        try {
            today = simpleDate.parse(getDate);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return today;
    }

    private void envioDatos() {

        //Parse Send
        ParseObject entity = new ParseObject("Datos_Entorno");

        //General

        entity.put("Fecha",fecha);
        entity.put("Latitud",latitud);
        entity.put("Longitud",longitud);
        entity.put("Cuadricula", cuadricula());
        entity.put("DNI",DNI);

        //Entorno
        entity.put("TempInicial",datosEntorno.gettInicio());
        entity.put("TempFinal",datosEntorno.gettFin());
        entity.put("Zonificacion",datosEntorno.getZonificacion());
        entity.put("Viento",datosEntorno.getViento());
        entity.put("DirViento",datosEntorno.getDireccionViento());
        entity.put("Nubes",datosEntorno.getNubes());
        entity.put("Lluvia",datosEntorno.getLluvia());

        //Plantas
        entity.put("EP01", datosEntorno.getPlantas().get(0));
        entity.put("EP02", datosEntorno.getPlantas().get(1));
        entity.put("EP03", datosEntorno.getPlantas().get(2));
        entity.put("EP04", datosEntorno.getPlantas().get(3));
        entity.put("EP05", datosEntorno.getPlantas().get(4));
        entity.put("EP06", datosEntorno.getPlantas().get(5));
        entity.put("EP07", datosEntorno.getPlantas().get(6));
        entity.put("EP08", datosEntorno.getPlantas().get(7));
        entity.put("EP09", datosEntorno.getPlantas().get(8));
        entity.put("EP10", datosEntorno.getPlantas().get(9));
        entity.put("EP11", datosEntorno.getPlantas().get(10));
        entity.put("EP12", datosEntorno.getPlantas().get(11));
        entity.put("EP13", datosEntorno.getPlantas().get(12));
        entity.put("EP14", datosEntorno.getPlantas().get(13));
        entity.put("EP15", datosEntorno.getPlantas().get(14));
        entity.put("EP16", datosEntorno.getPlantas().get(15));
        entity.put("EP17", datosEntorno.getPlantas().get(16));
        entity.put("EP18", datosEntorno.getPlantas().get(17));
        entity.put("EP19", datosEntorno.getPlantas().get(18));
        entity.put("EP20", datosEntorno.getPlantas().get(19));
        entity.put("EP21", datosEntorno.getPlantas().get(20));
        entity.put("EP22", datosEntorno.getPlantas().get(21));
        entity.put("EP23", datosEntorno.getPlantas().get(22));
        entity.put("EP24", datosEntorno.getPlantas().get(23));
        entity.put("EP25", datosEntorno.getPlantas().get(24));
        entity.put("EP26", datosEntorno.getPlantas().get(25));
        entity.put("EP27", datosEntorno.getPlantas().get(26));
        entity.put("EP28", datosEntorno.getPlantas().get(27));
        entity.put("EP29", datosEntorno.getPlantas().get(28));
        entity.put("EP30", datosEntorno.getPlantas().get(29));
        entity.put("EP31", datosEntorno.getPlantas().get(30));
        entity.put("EP32", datosEntorno.getPlantas().get(31));
        entity.put("EP33", datosEntorno.getPlantas().get(32));
        entity.put("EP34", datosEntorno.getPlantas().get(33));
        entity.put("EP35", datosEntorno.getPlantas().get(34));
        entity.put("EP36", datosEntorno.getPlantas().get(35));
        entity.put("EP37", datosEntorno.getEP37());
        entity.put("EP38", datosEntorno.getEP38());

        //Metodos Captura
        entity.put("NumMallas", metodosCaptura.getNumeroMallas());
        entity.put("Longred",metodosCaptura.getLongitudRed());
        entity.put("Coto",metodosCaptura.isCoto());

        entity.put("CA01", metodosCaptura.getControlAgentes().get(0));
        entity.put("CA02", metodosCaptura.getControlAgentes().get(1));
        entity.put("CA03", metodosCaptura.getControlAgentes().get(2));
        entity.put("CA04", metodosCaptura.getControlAgentes().get(3));
        entity.put("CA05", metodosCaptura.getControlAgentes().get(4));
        entity.put("CA06", metodosCaptura.getControlAgentes().get(5));

        entity.put("RecCamachuelo", metodosCaptura.getReclamosCamachuelo());
        entity.put("CapCamachueloM", metodosCaptura.getCapturasCamachueloM());
        entity.put("CapCamachueloH", metodosCaptura.getCapturasCamachueloH());
        entity.put("CimCamachuelo", metodosCaptura.getCimbelesCamachuelo());

        entity.put("RecJilguero", metodosCaptura.getReclamosJilguero());
        entity.put("CapJilgueroM", metodosCaptura.getCapturasJilgueroM());
        entity.put("CapJilgueroH", metodosCaptura.getCapturasJilgueroH());
        entity.put("CimJilguero", metodosCaptura.getCimbelesJilguero());

        entity.put("RecLugano", metodosCaptura.getReclamosLugano());
        entity.put("CapLuganoM", metodosCaptura.getCapturasLuganoM());
        entity.put("CapLuganoH", metodosCaptura.getCapturasLuganoH());
        entity.put("CimLugano", metodosCaptura.getCimbelesLugano());

        entity.put("RecPardComun", metodosCaptura.getReclamosPardComun());
        entity.put("CapPardComunM", metodosCaptura.getCapturasPardComunM());
        entity.put("CapPardComunH", metodosCaptura.getCapturasPardComunH());
        entity.put("CimPardComun", metodosCaptura.getCimbelesPardComun());

        entity.put("RecPicogordo", metodosCaptura.getReclamosPicogordo());
        entity.put("CapPicogordoM", metodosCaptura.getCapturasPicogordoM());
        entity.put("CapPicogordoH", metodosCaptura.getCapturasPicogordoH());
        entity.put("CimPicogordo", metodosCaptura.getCimbelesPicogordo());

        entity.put("RecPinzComun", metodosCaptura.getReclamosPinzonComun());
        entity.put("CapPinzComunM", metodosCaptura.getCapturasPinzonComunM());
        entity.put("CapPinzComunH", metodosCaptura.getCapturasPinzonComunH());
        entity.put("CimPinzComun", metodosCaptura.getCimbelesPinzonComun());

        entity.put("RecPinzReal", metodosCaptura.getReclamosPinzonReal());
        entity.put("CapPinzRealM", metodosCaptura.getCapturasPinzonRealM());
        entity.put("CapPinzRealH", metodosCaptura.getCapturasPinzonRealH());
        entity.put("CimPinzReal", metodosCaptura.getCimbelesPinzonReal());

        entity.put("RecPiquituerto", metodosCaptura.getReclamosPiquituerto());
        entity.put("CapPiquituertoM", metodosCaptura.getCapturasPiquituertoM());
        entity.put("CapPiquituertoH", metodosCaptura.getCapturasPiquituertoH());
        entity.put("CimPiquituerto", metodosCaptura.getCimbelesPiquituerto());

        entity.put("RecVerdecillo", metodosCaptura.getReclamosVerdecillo());
        entity.put("CapVerdecilloM", metodosCaptura.getCapturasVerdecilloM());
        entity.put("CapVerdecilloH", metodosCaptura.getCapturasVerdecilloH());
        entity.put("CimVerdecillo", metodosCaptura.getCimbelesVerdecillo());

        entity.put("RecVerdComun", metodosCaptura.getReclamosVerdComun());
        entity.put("CapVerdComunM", metodosCaptura.getCapturasVerdComunM());
        entity.put("CapVerdComunH", metodosCaptura.getCapturasVerdComunH());
        entity.put("CimVerdComun", metodosCaptura.getCimbelesVerdComun());

        entity.put("RecVerdSerrano", metodosCaptura.getReclamosVerdSerrano());
        entity.put("CapVerdSerranoM", metodosCaptura.getCapturasVerdSerranoM());
        entity.put("CapVerdSerranoH", metodosCaptura.getCapturasVerdSerranoH());
        entity.put("CimVerdSerrano", metodosCaptura.getCimbelesVerdSerrano());

        entity.put("Observaciones",metodosCaptura.getObservaciones());

        //Datos Avistamiento
        entity.put("HoraInicio",datosAvistamiento.getHoraInicio());
        entity.put("HoraFin",datosAvistamiento.getHoraFin());

        //Avistamientos Camachuelo
        entity.put("Cam08", datosAvistamiento.getHora08().get(0));
        entity.put("Cam09", datosAvistamiento.getHora09().get(0));
        entity.put("Cam10", datosAvistamiento.getHora10().get(0));
        entity.put("Cam11", datosAvistamiento.getHora11().get(0));
        entity.put("Cam12", datosAvistamiento.getHora12().get(0));
        entity.put("Cam13", datosAvistamiento.getHora13().get(0));
        entity.put("Cam14", datosAvistamiento.getHora14().get(0));

        //Avistamientos Jilguero
        entity.put("Jil08", datosAvistamiento.getHora08().get(1));
        entity.put("Jil09", datosAvistamiento.getHora09().get(1));
        entity.put("Jil10", datosAvistamiento.getHora10().get(1));
        entity.put("Jil11", datosAvistamiento.getHora11().get(1));
        entity.put("Jil12", datosAvistamiento.getHora12().get(1));
        entity.put("Jil13", datosAvistamiento.getHora13().get(1));
        entity.put("Jil14", datosAvistamiento.getHora14().get(1));

        //Avistamientos Lugano
        entity.put("Lug08", datosAvistamiento.getHora08().get(2));
        entity.put("Lug09", datosAvistamiento.getHora09().get(2));
        entity.put("Lug10", datosAvistamiento.getHora10().get(2));
        entity.put("Lug11", datosAvistamiento.getHora11().get(2));
        entity.put("Lug12", datosAvistamiento.getHora12().get(2));
        entity.put("Lug13", datosAvistamiento.getHora13().get(2));
        entity.put("Lug14", datosAvistamiento.getHora14().get(2));

        //Avistamientos Pardillo Comun
        entity.put("PardC08", datosAvistamiento.getHora08().get(3));
        entity.put("PardC09", datosAvistamiento.getHora09().get(3));
        entity.put("PardC10", datosAvistamiento.getHora10().get(3));
        entity.put("PardC11", datosAvistamiento.getHora11().get(3));
        entity.put("PardC12", datosAvistamiento.getHora12().get(3));
        entity.put("PardC13", datosAvistamiento.getHora13().get(3));
        entity.put("PardC14", datosAvistamiento.getHora14().get(3));

        //Avistamientos Picogordo
        entity.put("Pic08", datosAvistamiento.getHora08().get(4));
        entity.put("Pic09", datosAvistamiento.getHora09().get(4));
        entity.put("Pic10", datosAvistamiento.getHora10().get(4));
        entity.put("Pic11", datosAvistamiento.getHora11().get(4));
        entity.put("Pic12", datosAvistamiento.getHora12().get(4));
        entity.put("Pic13", datosAvistamiento.getHora13().get(4));
        entity.put("Pic14", datosAvistamiento.getHora14().get(4));

        //Avistamientos
        entity.put("PinC08", datosAvistamiento.getHora08().get(5));
        entity.put("PinC09", datosAvistamiento.getHora09().get(5));
        entity.put("PinC10", datosAvistamiento.getHora10().get(5));
        entity.put("PinC11", datosAvistamiento.getHora11().get(5));
        entity.put("PinC12", datosAvistamiento.getHora12().get(5));
        entity.put("PinC13", datosAvistamiento.getHora13().get(5));
        entity.put("PinC14", datosAvistamiento.getHora14().get(5));

        //Avistamientos
        entity.put("PinR08", datosAvistamiento.getHora08().get(6));
        entity.put("PinR09", datosAvistamiento.getHora09().get(6));
        entity.put("PinR10", datosAvistamiento.getHora10().get(6));
        entity.put("PinR11", datosAvistamiento.getHora11().get(6));
        entity.put("PinR12", datosAvistamiento.getHora12().get(6));
        entity.put("PinR13", datosAvistamiento.getHora13().get(6));
        entity.put("PinR14", datosAvistamiento.getHora14().get(6));

        //Avistamientos
        entity.put("Piq08", datosAvistamiento.getHora08().get(7));
        entity.put("Piq09", datosAvistamiento.getHora09().get(7));
        entity.put("Piq10", datosAvistamiento.getHora10().get(7));
        entity.put("Piq11", datosAvistamiento.getHora11().get(7));
        entity.put("Piq12", datosAvistamiento.getHora12().get(7));
        entity.put("Piq13", datosAvistamiento.getHora13().get(7));
        entity.put("Piq14", datosAvistamiento.getHora14().get(7));

        //Avistamientos
        entity.put("Verd08", datosAvistamiento.getHora08().get(8));
        entity.put("Verd09", datosAvistamiento.getHora09().get(8));
        entity.put("Verd10", datosAvistamiento.getHora10().get(8));
        entity.put("Verd11", datosAvistamiento.getHora11().get(8));
        entity.put("Verd12", datosAvistamiento.getHora12().get(8));
        entity.put("Verd13", datosAvistamiento.getHora13().get(8));
        entity.put("Verd14", datosAvistamiento.getHora14().get(8));

        //Avistamientos
        entity.put("VerdC08", datosAvistamiento.getHora08().get(9));
        entity.put("VerdC09", datosAvistamiento.getHora09().get(9));
        entity.put("VerdC10", datosAvistamiento.getHora10().get(9));
        entity.put("VerdC11", datosAvistamiento.getHora11().get(9));
        entity.put("VerdC12", datosAvistamiento.getHora12().get(9));
        entity.put("VerdC13", datosAvistamiento.getHora13().get(9));
        entity.put("VerdC14", datosAvistamiento.getHora14().get(9));

        //Avistamientos
        entity.put("VerdS08", datosAvistamiento.getHora08().get(10));
        entity.put("VerdS09", datosAvistamiento.getHora09().get(10));
        entity.put("VerdS10", datosAvistamiento.getHora10().get(10));
        entity.put("VerdS11", datosAvistamiento.getHora11().get(10));
        entity.put("VerdS12", datosAvistamiento.getHora12().get(10));
        entity.put("VerdS13", datosAvistamiento.getHora13().get(10));
        entity.put("VerdS14", datosAvistamiento.getHora14().get(10));

        //ENVIAR OBJETO

        entity.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e==null){
                    //Save was done
                    actualizarDatosEnviados();
                    Toast.makeText(Pantalla_Menu_Metodos_Y_Captura.this, "Se ha realizado el envío correctamente", Toast.LENGTH_SHORT).show();
                    desactivarBotonesDatos();

                }else{
                    //Something went wrong
                    Toast.makeText(Pantalla_Menu_Metodos_Y_Captura.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void desactivarBotonesDatos() {
        btn_DatosAves.setEnabled(true);
        btn_DatosAves.setBackground(getDrawable(R.drawable.boton_semiredondeado));
        btn_DatosAves.setPadding(5,0,0,0);
        btn_DatosEntorno.setEnabled(false);
        btn_DatosEntorno.setBackground(getDrawable(R.drawable.boton_semiredondeado_apagado));
        btn_DatosEntorno.setPadding(5,0,0,0);
        btn_Metodos.setEnabled(false);
        btn_Metodos.setBackground(getDrawable(R.drawable.boton_semiredondeado_apagado));
        btn_Metodos.setPadding(5,0,0,0);
        btn_DatosAvistamiento.setEnabled(false);
        btn_DatosAvistamiento.setBackground(getDrawable(R.drawable.boton_semiredondeado_apagado));
        btn_DatosAvistamiento.setPadding(5,0,0,0);
        btn_Enviar.setEnabled(false);
        btn_Enviar.setBackground(getDrawable(R.drawable.boton_redondeado_apagado));
    }

    private void actualizarDatosEnviados() {
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser!= null){
            int fichasEnviadas  = currentUser.getInt("NumFichas");
            fichasEnviadas++;
            currentUser.put("NumFichas", fichasEnviadas);
            currentUser.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if(e==null){
                        //Save successfull
                        Toast.makeText(Pantalla_Menu_Metodos_Y_Captura.this, "Save Successful", Toast.LENGTH_SHORT).show();
                    }else{
                        // Something went wrong while saving
                        Toast.makeText(Pantalla_Menu_Metodos_Y_Captura.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }



    private void asignacionValores() {
        fecha = convertStringToData(tv_Fecha.getText().toString());
        latitud = Double.parseDouble(etnd_Latitud.getText().toString());
        longitud = Double.parseDouble(etnd_Longitud.getText().toString());
    }

    private boolean comprobarValores() {

        if (tv_Fecha.getText().toString().equals("-- / -- / ----")) return false;
        if (etnd_Longitud.getText().toString().isEmpty()) return false;
        if (etnd_Latitud.getText().toString().isEmpty()) return false;
        try {
            Double.parseDouble(etnd_Longitud.getText().toString());
            Double.parseDouble(etnd_Latitud.getText().toString());
        } catch (Exception e){
            return false;
        }

        if (!(Double.parseDouble(etnd_Longitud.getText().toString())<limites.getMaxLon() && Double.parseDouble(etnd_Longitud.getText().toString())>limites.getMinLon())){
            Toast.makeText(this, "La longitud no entra en los parámetros establecidos", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!(Double.parseDouble(etnd_Latitud.getText().toString())<limites.getMaxLat() && Double.parseDouble(etnd_Latitud.getText().toString())>limites.getMinLat())){
            Toast.makeText(this, "La latitud no entra en los parámetros establecidos", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void guardarParametros(Intent actividadDestino) {

        imprimirDatosRecibidos();

        actividadDestino.putExtra("EMAIL",email);
        actividadDestino.putExtra("DNI",DNI);
        actividadDestino.putExtra("ENVIO_COMPLETADO",envioCompletado);
        actividadDestino.putExtra("DATOS_AVISTAMIENTO", (Serializable) datosAvistamiento);
        actividadDestino.putExtra("DATOS_ENTORNO", (Serializable) datosEntorno);
        actividadDestino.putExtra("DATOS_CAPTURA", (Serializable) metodosCaptura);
        actividadDestino.putExtra("ENTORNO_COMPLETADO", entornoCompletado);
        actividadDestino.putExtra("MCAPTURAS_COMPLETADO", mCapturasCompletado);
        actividadDestino.putExtra("AVISTAMIENTO_COMPLETADO", avistamientoCompletado);
        actividadDestino.putExtra("LIMITES", limites);

        if (entornoCompletado && mCapturasCompletado && avistamientoCompletado){
            actividadDestino.putExtra("LATITUD", etnd_Latitud.getText().toString());
            actividadDestino.putExtra("LONGITUD", etnd_Longitud.getText().toString());
            actividadDestino.putExtra("FECHA", tv_Fecha.getText().toString());
        }
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

    /**
     * Asignacion de cuadrícula
     * @return código de cuadricula según coordenadas
     */
    private String cuadricula(){
        //Primer valor
        String codCuadricula = "";
        double x = (longitud - 3.123);
        double x1 = x/0.1159;
        double x2 = 12-x1;
        if(x2<0) x2=0.0;
        double x3 = Math.ceil(x2);

        //Segundo valor
        double y = (latitud - 39.937133);
        double y1 = y/0.08878954;
        double y2 = 14-y1;
        if(y2<0) y2=0.0;
        double y3 = Math.ceil(y2);

        //Juntar los dos numeros
        int ix3 = (int) x3;
        int iy3 = (int) y3;

        String sValor1 = String.valueOf(ix3);
        String sValor2= String.valueOf(iy3);

        String svalorDef = sValor1.concat(sValor2);
        int numCuadricula = Integer.parseInt(svalorDef);

        switch (numCuadricula){
            case 37:
                codCuadricula = "01UKA10";
                break;
            case 38:
                codCuadricula = "02UKB10";
                break;
            case 29:
                codCuadricula = "03UKC09";
                break;
            case 39:
                codCuadricula = "04UKC10";
                break;
            case 110:
                codCuadricula = "05UKD08";
                break;
            case 210:
                codCuadricula = "06UKD09";
                break;
            case 310:
                codCuadricula = "07UKD10";
                break;
            case 111:
                codCuadricula = "08UKE08";
                break;
            case 211:
                codCuadricula = "09UKE09";
                break;
            case 91:
                codCuadricula = "10VLE06";
                break;
            case 82:
                codCuadricula = "11VLF05";
                break;
            case 92:
                codCuadricula = "12VLF06";
                break;
            case 102:
                codCuadricula = "13VLF07";
                break;
            case 63:
                codCuadricula = "14VLG03";
                break;
            case 73:
                codCuadricula = "15VLG04";
                break;
            case 83:
                codCuadricula = "16VLG05";
                break;
            case 93:
                codCuadricula = "17VLG06";
                break;
            case 103:
                codCuadricula = "18VLG07";
                break;
            case 64:
                codCuadricula = "19VLH03";
                break;
            case 74:
                codCuadricula = "20VLH04";
                break;
            case 84:
                codCuadricula = "21VLH05";
                break;
            case 94:
                codCuadricula = "22VLH06";
                break;
            case 55:
                codCuadricula = "23VLI02";
                break;
            case 65:
                codCuadricula = "24VLI03";
                break;
            case 75:
                codCuadricula = "25VLI04";
                break;
            case 85:
                codCuadricula = "26VLI05";
                break;
            case 95:
                codCuadricula = "27VLI06";
                break;
            case 46:
                codCuadricula = "28VLJ01";
                break;
            case 56:
                codCuadricula = "29VLJ02";
                break;
            case 66:
                codCuadricula = "30VLJ03";
                break;
            case 76:
                codCuadricula = "31VLJ04";
                break;
            case 86:
                codCuadricula = "32VLJ05";
                break;
            case 96:
                codCuadricula = "33VLJ06";
                break;
            case 47:
                codCuadricula = "34VKA01";
                break;
            case 57:
                codCuadricula = "35VKA02";
                break;
            case 67:
                codCuadricula = "36VKA03";
                break;
            case 77:
                codCuadricula = "37VKA04";
                break;

            case 87:
                codCuadricula = "38VKA05";
                break;
            case 97:
                codCuadricula = "39VKA06";
                break;
            case 107:
                codCuadricula = "40VKA07";
                break;
            case 48:
                codCuadricula = "41VKB01";
                break;
            case 58:
                codCuadricula = "42VKB02";
                break;
            case 68:
                codCuadricula = "43VKB03";
                break;
            case 78:
                codCuadricula = "44VKB04";
                break;
            case 88:
                codCuadricula = "45VKB05";
                break;
            case 98:
                codCuadricula = "46VKB06";
                break;
            case 108:
                codCuadricula = "47VKB07";
                break;
            case 118:
                codCuadricula = "48VKB08";
                break;
            case 49:
                codCuadricula = "49VKC01";
                break;
            case 59:
                codCuadricula = "50VKC02";
                break;
            case 69:
                codCuadricula = "51VKC03";
                break;
            case 79:
                codCuadricula = "52VKC04";
                break;
            case 89:
                codCuadricula = "53VKC05";
                break;
            case 99:
                codCuadricula = "54VKC06";
                break;
            case 109:
                codCuadricula = "55VKC07";
                break;
            case 119:
                codCuadricula = "56VKC08";
                break;
            case 129:
                codCuadricula = "57VKC09";
                break;
            case 410:
                codCuadricula = "58VKD01";
                break;
            case 510:
                codCuadricula = "59VKD02";
                break;
            case 610:
                codCuadricula = "60VKD03";
                break;
            case 710:
                codCuadricula = "61VKD04";
                break;
            case 810:
                codCuadricula = "62VKD05";
                break;
            case 910:
                codCuadricula = "63VKD06";
                break;
            case 1010:
                codCuadricula = "64VKD07";
                break;
            case 1110:
                codCuadricula = "65VKD08";
                break;
            case 1210:
                codCuadricula = "66VKD09";
                break;
            case 411:
                codCuadricula = "67VKE01";
                break;
            case 511:
                codCuadricula = "68VKE02";
                break;
            case 611:
                codCuadricula = "69VKE03";
                break;
            case 711:
                codCuadricula = "70VKE04";
                break;
            case 811:
                codCuadricula = "71VKE05";
                break;
            case 911:
                codCuadricula = "72VKE06";
                break;
            case 1011:
                codCuadricula = "73VKE07";
                break;
            case 1111:
                codCuadricula = "74VKE08";
                break;

            case 1211:
                codCuadricula = "75VKE09";
                break;
            case 712:
                codCuadricula = "76VKF04";
                break;
            case 812:
                codCuadricula = "77VKF05";
                break;
            case 912:
                codCuadricula = "78VKF06";
                break;
            case 1012:
                codCuadricula = "79VKF07";
                break;
            case 1112:
                codCuadricula = "80VKF08";
                break;
            case 1212:
                codCuadricula = "81VKF09";
                break;
            case 913:
                codCuadricula = "82VKG06";
                break;
            case 1013:
                codCuadricula = "83VKG07";
                break;
            case 1113:
                codCuadricula = "84VKG08";
                break;
            case 1213:
                codCuadricula = "85VKG09";
                break;
            case 814:
                codCuadricula = "86VKH05";
                break;

            default:
                codCuadricula = "ERROR";
                break;
        }

        return codCuadricula;
    }
}
