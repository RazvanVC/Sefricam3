package com.sefricam.sefricam3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Pantalla_Datos_Aves extends Activity implements  View.OnClickListener{

    private Button btn_Enviar, btn_Volver;
    private TextView tv_Hora;

    //Datos
    private String hora,anillaPreexistente;
    private int especie, numeroAnilla, localizacion, sexo, edad, nEjemplares, condicionFisica, grasa, musculoPectoral, muda, placaIncubatriz;
    private Double peso, longitudTarso, longitudPico, longitudTerceraPrimaria;

    private EditText etn_EjemplaresCapturados, etn_NumeroAnilla, et_NumeroAnillaPreexistente, etnd_Peso, etnd_LongitudTarso, etnd_LongitudPico, etnd_LongitudTerceraPrimaria;
    private RadioGroup rbg_Localizacion, rbg_Sexo, rbg_Edad, rbg_CondicionFisica, rbg_Grasa, rbg_MusculoPectoral,rbg_Muda,rbg_PlacaInc, rbg_EspeciesAves;
    private RadioButton rb_SexoMacho, rb_SexoHembra, rb_SexoIndeterminado;
    private TextView tv_PlacaInc;
    private RadioButton rb_PlacaIncNoEvidencia, rb_PlacaIncIncompleta, rb_PlacaIncMEvidente;

    //Parametros
    private Envio envio;
    private MetodosCaptura metodosCaptura;
    private DatosAvistamiento datosAvistamiento;
    private DatosEntorno datosEntorno;
    private Limites limites;
    private boolean mCapturasCompletado,avistamientoCompletado,entornoCompletado;
    private String email,DNI;
    private double maxPeso, maxTarso, maxAla, maxPico, minPeso, minTarso, minAla, minPico, latitud, longitud;;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_datos_aves);

        Bundle datos = this.getIntent().getExtras();

        if (datos != null) {
            recuperarDatosRecibidos(datos);

            System.out.println("Datos recibidos en Datos Aves");
            imprimirDatosRecibidos();
        }

        iniciarFindView();
        iniciarOnClickListener();
    }

    private void iniciarOnClickListener() {
        btn_Enviar.setOnClickListener(this);
        btn_Volver.setOnClickListener(this);
        tv_Hora.setOnClickListener(this);
        rb_SexoIndeterminado.setOnClickListener(this);
        rb_SexoHembra.setOnClickListener(this);
        rb_SexoMacho.setOnClickListener(this);

    }

    private void iniciarFindView() {

        //Text View Hora Captura
        tv_Hora = findViewById(R.id.tv_HoraCapturaAve);

        //RB Especie aves
        rbg_EspeciesAves = findViewById(R.id.rbg_EspeciesAves);

        etn_EjemplaresCapturados = findViewById(R.id.etn_EjemplaresCapturados);

        //Datos del ave
        etn_NumeroAnilla = findViewById(R.id.etn_NumeroAnilla);
        et_NumeroAnillaPreexistente = findViewById(R.id.et_NumeroAnillaPrexistente);
        etnd_Peso = findViewById(R.id.etnd_Peso);
        etnd_LongitudTarso = findViewById(R.id.etnd_LongitudTarso);
        etnd_LongitudPico = findViewById(R.id.etnd_LongitudPico);
        etnd_LongitudTerceraPrimaria = findViewById(R.id.etnd_LongitudTerceraPrimaria);

        //Radio Button Group Ave Local
        rbg_Localizacion = findViewById(R.id.rbg_Localizacion);

        //Sexo
        rbg_Sexo = findViewById(R.id.rbg_Sexo);
        rb_SexoMacho = findViewById(R.id.rb_SexoMacho);
        rb_SexoHembra = findViewById(R.id.rb_SexoHembra);
        rb_SexoIndeterminado = findViewById(R.id.rb_SexoIndeterminado);

        rbg_Edad = findViewById(R.id.rbg_Edad);


        rbg_CondicionFisica = findViewById(R.id.rbg_CondicionFisica);

        rbg_Grasa = findViewById(R.id.rbg_Grasa);

        rbg_MusculoPectoral = findViewById(R.id.rbg_MusculoPectoral);

        rbg_Muda = findViewById(R.id.rbg_Muda);

        //Placa Incubatriz
        tv_PlacaInc = findViewById(R.id.tv_PlacaInc);
        rbg_PlacaInc = findViewById(R.id.rbg_PlacaInc);
        rb_PlacaIncNoEvidencia = findViewById(R.id.rb_PlacaIncNoEvidencia);
        rb_PlacaIncIncompleta = findViewById(R.id.rb_PlacaIncIncompleta);
        rb_PlacaIncMEvidente = findViewById(R.id.rb_PlacaIncMEvidente);

        btn_Volver = findViewById(R.id.btn_VolverAves);
        btn_Enviar = findViewById(R.id.btn_EnviarAves);

    }

    @Override
    public void onClick(View v) {
        if (v == btn_Enviar){
            if (comprobarValores()){
                asignacionValores();
                Intent activity = new Intent(this, Pantalla_Menu_Metodos_Y_Captura.class);
                guardarParametros(activity);

                envioDatos();
                startActivity(activity);
                finish();
            }
        }
        if (v == btn_Volver){
            Intent activity = new Intent(this, Pantalla_Menu_Metodos_Y_Captura.class);
            guardarParametros(activity);

            startActivity(activity);
            finish();
        }
        if (v == tv_Hora){
            TimePickerDialog recogerHora = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    if (minute<10){
                        hora = hourOfDay+":0"+minute;
                    } else {
                        hora = hourOfDay+":"+minute;
                    }
                    tv_Hora.setText(hora);
                }
            }, 7, 0, true);
            recogerHora.show();
        }
        if (v == rb_SexoHembra){
            tv_PlacaInc.setTextColor(getColor(R.color.VerdePrimario));
            rb_PlacaIncMEvidente.setTextColor(getColor(R.color.VerdePrimario));
            rb_PlacaIncIncompleta.setTextColor(getColor(R.color.VerdePrimario));
            rb_PlacaIncNoEvidencia.setTextColor(getColor(R.color.VerdePrimario));
            rb_PlacaIncMEvidente.setClickable(true);
            rb_PlacaIncIncompleta.setClickable(true);
            rb_PlacaIncNoEvidencia.setClickable(true);
        }
        if (v == rb_SexoMacho){
            tv_PlacaInc.setTextColor(getColor(R.color.Gris));
            rb_PlacaIncMEvidente.setTextColor(getColor(R.color.Gris));
            rb_PlacaIncIncompleta.setTextColor(getColor(R.color.Gris));
            rb_PlacaIncNoEvidencia.setTextColor(getColor(R.color.Gris));
            rb_PlacaIncMEvidente.setClickable(false);
            rb_PlacaIncIncompleta.setClickable(false);
            rb_PlacaIncNoEvidencia.setClickable(false);
            rb_PlacaIncMEvidente.setChecked(false);
            rb_PlacaIncIncompleta.setChecked(false);
            rb_PlacaIncNoEvidencia.setChecked(false);
        }
        if (v == rb_SexoIndeterminado){
            tv_PlacaInc.setTextColor(getColor(R.color.Gris));
            rb_PlacaIncMEvidente.setTextColor(getColor(R.color.Gris));
            rb_PlacaIncIncompleta.setTextColor(getColor(R.color.Gris));
            rb_PlacaIncNoEvidencia.setTextColor(getColor(R.color.Gris));
            rb_PlacaIncMEvidente.setClickable(false);
            rb_PlacaIncIncompleta.setClickable(false);
            rb_PlacaIncNoEvidencia.setClickable(false);
            rb_PlacaIncMEvidente.setChecked(false);
            rb_PlacaIncIncompleta.setChecked(false);
            rb_PlacaIncNoEvidencia.setChecked(false);
        }
    }

    public void envioDatos() {
        ParseObject entity = new ParseObject("Datos_Aves");

        entity.put("NumGrupo",limites.getNumeroGrupo());
        entity.put("FechaCap", envio.getFecha());
        entity.put("Latitud", latitud);
        entity.put("Longitud", longitud);
        entity.put("HoraCap", hora);
        entity.put("Especie", especie);
        entity.put("NEjemplares", nEjemplares);
        entity.put("NumAnilla", numeroAnilla);
        entity.put("AnillaPre", anillaPreexistente);
        entity.put("Peso", peso);
        entity.put("LongTarso", longitudTarso);
        entity.put("LongPico", longitudPico);
        entity.put("LongTerPrim", longitudTerceraPrimaria);
        entity.put("Localizacion", localizacion);
        entity.put("Sexo", sexo);
        entity.put("Edad", edad);
        entity.put("CondFisica", condicionFisica);
        entity.put("Grasa", grasa);
        entity.put("MuscPectoral", musculoPectoral);
        entity.put("Muda", muda);
        entity.put("PlacIncubatriz", placaIncubatriz);

        // Saves the new object.
        // Notice that the SaveCallback is totally optional!
        entity.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e==null){
                    //Save was done
                    actualizarDatosEnviados();
                    Toast.makeText(Pantalla_Datos_Aves.this, "Se ha realizado el envío correctamente", Toast.LENGTH_SHORT).show();
                }else{
                    //Something went wrong
                    Toast.makeText(Pantalla_Datos_Aves.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void actualizarDatosEnviados() {
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser!= null){
            int avesEnviadas  = currentUser.getInt("NumAves");
            avesEnviadas++;
            currentUser.put("NumAves", avesEnviadas);
            currentUser.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if(e==null){
                        //Save successfull
                        Toast.makeText(Pantalla_Datos_Aves.this, "Save Successful", Toast.LENGTH_SHORT).show();
                    }else{
                        // Something went wrong while saving
                        Toast.makeText(Pantalla_Datos_Aves.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    @SuppressLint("NonConstantResourceId")
    private void asignacionValores() {

        hora = tv_Hora.getText().toString();

        //Asignacion de especie
        switch (rbg_EspeciesAves.getCheckedRadioButtonId()){
            case R.id.rb_EspecieCamachuelo:
                especie = 1;
                break;
            case R.id.rb_EspecieJilguero:
                especie = 2;
                break;
            case R.id.rb_EspecieLugano:
                especie = 3;
                break;
            case R.id.rb_EspeciePardComun:
                especie = 4;
                break;
            case R.id.rb_EspeciePicogordo:
                especie = 5;
                break;
            case R.id.rb_EspeciePinzComun:
                especie = 6;
                break;
            case R.id.rb_EspeciePinzReal:
                especie = 7;
                break;
            case R.id.rb_EspeciePiquituerto:
                especie = 8;
                break;
            case R.id.rb_EspecieVerdecillo:
                especie = 9;
                break;
            case R.id.rb_EspecieVerdComun:
                especie = 10;
                break;
            case R.id.rb_EspecieVerdSerrano:
                especie = 11;
                break;
        }

        //Asignacion de anilla
        if (!etn_NumeroAnilla.getText().toString().isEmpty()) {
            numeroAnilla = Integer.parseInt(etn_NumeroAnilla.getText().toString());
            anillaPreexistente = "";
        } else {
            numeroAnilla = 0;
            anillaPreexistente = et_NumeroAnillaPreexistente.getText().toString();
        }

        //Asignación de parámetros
        peso = Double.parseDouble(etnd_Peso.getText().toString());
        longitudTarso =Double.parseDouble(etnd_LongitudTarso.getText().toString());
        longitudPico = Double.parseDouble(etnd_LongitudPico.getText().toString());
        longitudTerceraPrimaria = Double.parseDouble(etnd_LongitudTerceraPrimaria.getText().toString());

        switch (rbg_Localizacion.getCheckedRadioButtonId()){
            case R.id.rb_LocalizacionLocal:
                localizacion=1;
                break;
            case R.id.rb_LocalizacionNoLocal:
                localizacion=2;
                break;
            case R.id.rb_LocalizacionIndeterminado:
                localizacion=3;
                break;
        }
        switch (rbg_Sexo.getCheckedRadioButtonId()){
            case R.id.rb_SexoMacho:
                sexo=1;
                break;
            case R.id.rb_SexoHembra:
                sexo=2;
                break;
            case R.id.rb_SexoIndeterminado:
                sexo=3;
                break;
        }
        switch (rbg_Edad.getCheckedRadioButtonId()){
            case R.id.rb_EdadJuvenil:
                edad=1;
                break;
            case R.id.rb_EdadAdulto:
                edad=2;
                break;
        }

        nEjemplares = Integer.parseInt(etn_EjemplaresCapturados.getText().toString());

        switch (rbg_CondicionFisica.getCheckedRadioButtonId()){
            case R.id.rb_CondicionBuena:
                condicionFisica=1;
                break;
            case R.id.rb_CondicionLesiones:
                condicionFisica=2;
                break;
            case R.id.rb_CondicionEnfermedad:
                condicionFisica=3;
                break;
            case R.id.rb_CondicionMalformacion:
                condicionFisica=4;
                break;
        }
        switch (rbg_Grasa.getCheckedRadioButtonId()){
            case R.id.rb_GrasaAusente:
                grasa=1;
                break;
            case R.id.rb_GrasaInter:
                grasa=2;
                break;
            case R.id.rb_GrasaInter_Abd:
                grasa=3;
                break;
            case R.id.rb_GrasaInter_Abd_Pectoral:
                grasa=4;
                break;
        }
        switch (rbg_MusculoPectoral.getCheckedRadioButtonId()){
            case R.id.rb_MusculoQEvidente:
                musculoPectoral=1;
                break;
            case R.id.rb_MusculoQDistinguible:
                musculoPectoral=2;
                break;
            case R.id.rb_MusculoQLigera:
                musculoPectoral=3;
                break;
            case R.id.rb_MusculoNoQ:
                musculoPectoral=4;
                break;
        }
        switch (rbg_Muda.getCheckedRadioButtonId()){
            case R.id.rb_MudaAusente:
                muda=1;
                break;
            case R.id.rb_MudaEnCurso:
                muda=2;
                break;
            case R.id.rb_MudaTerminada:
                muda=3;
                break;
        }
        if (sexo==2){
            switch (rbg_PlacaInc.getCheckedRadioButtonId()){
                case R.id.rb_PlacaIncNoEvidencia:
                    placaIncubatriz=1;
                    break;
                case R.id.rb_PlacaIncIncompleta:
                    placaIncubatriz=2;
                    break;
                case R.id.rb_PlacaIncMEvidente:
                    placaIncubatriz=3;
                    break;
            }
        } else placaIncubatriz=0;

    }


    private boolean comprobarValores() {

        if (tv_Hora.getText().toString().equals("--:--")) {
            Toast.makeText(this, "ERROR: El campo de la hora no se puede quedar vacío", Toast.LENGTH_LONG).show();
            return false;
        }

        if (rbg_EspeciesAves.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR: Se ha de seleccionar una especie de ave", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (etn_EjemplaresCapturados.getText().toString().equals("0")){
            Toast.makeText(this, "ERROR: Las capturas tienen que ser distintas de cero", Toast.LENGTH_SHORT).show();
            return false;
        }



        //Comprobacion de parámetros dentro de límites
        if (!etn_NumeroAnilla.getText().toString().isEmpty()){
            if (!et_NumeroAnillaPreexistente.getText().toString().isEmpty()) {
                Toast.makeText(this, "No se puede anillar a un ave ya anillada", Toast.LENGTH_SHORT).show();
                return false;
            }
            /*
            System.out.println("MaxNAnilla => "+ limites.getMaxNAnilla());
            System.out.println("MinNAnilla => "+ limites.getMinNAnilla());
            System.out.println("AnillaActu => "+etn_NumeroAnilla.getText().toString());
            limites.imprimirDatosAnillamiento();*/
            if (Integer.parseInt(etn_NumeroAnilla.getText().toString())<limites.getMinNAnilla() || Integer.parseInt(etn_NumeroAnilla.getText().toString())>limites.getMaxNAnilla()){
                Toast.makeText(this, "El numero de anilla no corresponde a tus limites de anillamiento", Toast.LENGTH_SHORT).show();
                return false;
            }

        } else if (!et_NumeroAnillaPreexistente.getText().toString().isEmpty()) {
            if (!etn_NumeroAnilla.getText().toString().isEmpty()){
                Toast.makeText(this, "No se puede anillar a un ave ya anillada", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            Toast.makeText(this, "Se tiene que introducir al menos un tipo de anilla", Toast.LENGTH_SHORT).show();
            return false;
        }

        //Comprobacion de que los parámetros no estén vacios

        if (
                etnd_LongitudPico.getText().toString().equals("") ||
                        etnd_LongitudTarso.getText().toString().equals("") ||
                        etnd_LongitudTerceraPrimaria.getText().toString().equals("") ||
                        etnd_Peso.getText().toString().equals("")
        ){
            Toast.makeText(this, "Los parámetros del ave no pueden estar vacíos", Toast.LENGTH_SHORT).show();
            return false;
        }

        asignacionParametrosAves();

        if (Double.parseDouble(etnd_Peso.getText().toString())<minPeso || Double.parseDouble(etnd_Peso.getText().toString())>maxPeso){
            Toast.makeText(this, "El peso no se ajusta a los parámetros del ave seleccionada", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (Double.parseDouble(etnd_LongitudTarso.getText().toString())<minTarso || Double.parseDouble(etnd_LongitudTarso.getText().toString())>maxTarso){
            Toast.makeText(this, "La longitud del tarso no se ajusta a los parámetros del ave seleccionada", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (Double.parseDouble(etnd_LongitudPico.getText().toString())<minPico || Double.parseDouble(etnd_LongitudPico.getText().toString())>maxPico){
            Toast.makeText(this, "La longitud del pico no se ajusta a los parámetros del ave seleccionada", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (Double.parseDouble(etnd_LongitudTerceraPrimaria.getText().toString())<minAla || Double.parseDouble(etnd_LongitudTerceraPrimaria.getText().toString())>maxAla){
            Toast.makeText(this, "La longitud de la tercera primaria no se ajusta a los parámetros del ave seleccionada", Toast.LENGTH_SHORT).show();
            return false;
        }

        //Comprobacion del resto de campos

        if (rbg_Localizacion.getCheckedRadioButtonId()==-1) {
            Toast.makeText(this, "Se ha de seleccionar una localización", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (rbg_Sexo.getCheckedRadioButtonId()==-1) {
            Toast.makeText(this, "Se ha de seleccionar un sexo", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (rbg_Edad.getCheckedRadioButtonId()==-1){
            Toast.makeText(this, "Se ha de seleccionar una edad", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (rbg_CondicionFisica.getCheckedRadioButtonId()==-1){
            Toast.makeText(this, "Se ha de seleccionar una condición fisica", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (rbg_Grasa.getCheckedRadioButtonId()==-1){
            Toast.makeText(this, "Se ha de seleccionar una opción de grasa", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (rbg_MusculoPectoral.getCheckedRadioButtonId()==-1){
            Toast.makeText(this, "Se ha de seleccionar una opción de músculo pectoral", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (rbg_Muda.getCheckedRadioButtonId()==-1) {
            Toast.makeText(this, "Se ha de seleccionar un estado de muda", Toast.LENGTH_SHORT).show();
            return false;
        }

        //Placa incubatriz
        if (rbg_Sexo.getCheckedRadioButtonId()==R.id.rb_SexoHembra){
            if (rbg_PlacaInc.getCheckedRadioButtonId()==-1){
                Toast.makeText(this, "Se ha de seleccionar el estado de la placa incubatriz", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        return true;
    }

    private void guardarParametros(Intent actividadDestino) {
        actividadDestino.putExtra("ENVIO", envio);
        actividadDestino.putExtra("LIMITES", limites);
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



    private Date convertStringToData(String getDate){
        //Test Feature
        /*
        if (getDate == null){
            getDate = "16/01/2021";
            latitud = 0;
            longitud = 0;
        }*/

        System.out.println("LONG =>" + longitud);
        System.out.println("LAT =>" + latitud);

        Date today = null;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");

        try {
            today = simpleDate.parse(getDate);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return today;
    }

    @SuppressLint("NonConstantResourceId")
    private void asignacionParametrosAves() {
        switch (rbg_EspeciesAves.getCheckedRadioButtonId()){
            case R.id.rb_EspecieCamachuelo:
                maxPeso  = limites.getMaxPesoCamachuelo();
                maxTarso = limites.getMaxTarsoCamachuelo();
                maxAla = limites.getMaxAlaCamachuelo();
                maxPico = limites.getMaxPicoCamachuelo();

                minPeso  = limites.getMinPesoCamachuelo();
                minTarso = limites.getMinTarsoCamachuelo();
                minAla = limites.getMinAlaCamachuelo();
                minPico = limites.getMinPicoCamachuelo();
                break;
            case R.id.rb_EspecieJilguero:
                maxPeso  = limites.getMaxPesoJilguero();
                maxTarso = limites.getMaxTarsoJilguero();
                maxAla = limites.getMaxAlaJilguero();
                maxPico = limites.getMaxPicoCamachuelo();

                minPeso  = limites.getMinPesoJilguero();
                minTarso = limites.getMinTarsoJilguero();
                minAla = limites.getMinAlaJilguero();
                minPico = limites.getMinPicoJilguero();
                break;
            case R.id.rb_EspecieLugano:
                maxPeso  = limites.getMaxPesoLugano();
                maxTarso = limites.getMaxTarsoLugano();
                maxAla = limites.getMaxAlaLugano();
                maxPico = limites.getMaxPicoLugano();

                minPeso  = limites.getMinPesoLugano();
                minTarso = limites.getMinTarsoLugano();
                minAla = limites.getMinAlaLugano();
                minPico = limites.getMinPicoLugano();
                break;
            case R.id.rb_EspeciePardComun:
                maxPeso  = limites.getMaxPesoPardComun();
                maxTarso = limites.getMaxTarsoPardComun();
                maxAla = limites.getMaxAlaPardComun();
                maxPico = limites.getMaxPicoPardComun();

                minPeso  = limites.getMinPesoPardComun();
                minTarso = limites.getMinTarsoPardComun();
                minAla = limites.getMinAlaPardComun();
                minPico = limites.getMinPicoPardComun();
                break;
            case R.id.rb_EspeciePicogordo:
                maxPeso  = limites.getMaxPesoPicogordo();
                maxTarso = limites.getMaxTarsoPicogordo();
                maxAla = limites.getMaxAlaPicogordo();
                maxPico = limites.getMaxPicoPicogordo();

                minPeso  = limites.getMinPesoPicogordo();
                minTarso = limites.getMinTarsoPicogordo();
                minAla = limites.getMinAlaPicogordo();
                minPico = limites.getMinPicoPicogordo();
                break;
            case R.id.rb_EspeciePinzComun:
                maxPeso  = limites.getMaxPesoPinzComun();
                maxTarso = limites.getMaxTarsoPinzComun();
                maxAla = limites.getMaxAlaPinzComun();
                maxPico = limites.getMaxPicoPinzComun();

                minPeso  = limites.getMinPesoPinzComun();
                minTarso = limites.getMinTarsoPinzComun();
                minAla = limites.getMinAlaPinzComun();
                minPico = limites.getMinPicoPinzComun();
                break;
            case R.id.rb_EspeciePinzReal:
                maxPeso  = limites.getMaxPesoPinzReal();
                maxTarso = limites.getMaxTarsoPinzReal();
                maxAla = limites.getMaxAlaPinzReal();
                maxPico = limites.getMaxPicoPinzReal();

                minPeso  = limites.getMinPesoPinzReal();
                minTarso = limites.getMinTarsoPinzReal();
                minAla = limites.getMinAlaPinzReal();
                minPico = limites.getMinPicoPinzReal();
                break;
            case R.id.rb_EspeciePiquituerto:
                maxPeso  = limites.getMaxPesoPiquituerto();
                maxTarso = limites.getMaxTarsoPiquituerto();
                maxAla = limites.getMaxAlaPiquituerto();
                maxPico = limites.getMaxPicoPiquituerto();

                minPeso  = limites.getMinPesoPiquituerto();
                minTarso = limites.getMinTarsoPiquituerto();
                minAla = limites.getMinAlaPiquituerto();
                minPico = limites.getMinPicoPiquituerto();
                break;
            case R.id.rb_EspecieVerdecillo:
                maxPeso  = limites.getMaxPesoVerdecillo();
                maxTarso = limites.getMaxTarsoVerdecillo();
                maxAla = limites.getMaxAlaVerdecillo();
                maxPico = limites.getMaxPicoVerdecillo();

                minPeso  = limites.getMinPesoVerdecillo();
                minTarso = limites.getMinTarsoVerdecillo();
                minAla = limites.getMinAlaVerdecillo();
                minPico = limites.getMinPicoVerdecillo();
                break;
            case R.id.rb_EspecieVerdComun:
                maxPeso  = limites.getMaxPesoVerdComun();
                maxTarso = limites.getMaxTarsoVerdComun();
                maxAla = limites.getMaxAlaVerdComun();
                maxPico = limites.getMaxPicoVerdComun();

                minPeso  = limites.getMinPesoVerdComun();
                minTarso = limites.getMinTarsoVerdComun();
                minAla = limites.getMinAlaVerdComun();
                minPico = limites.getMinPicoVerdComun();
                break;
            case R.id.rb_EspecieVerdSerrano:
                maxPeso  = limites.getMaxPesoVerdSerrano();
                maxTarso = limites.getMaxTarsoVerdSerrano();
                maxAla = limites.getMaxAlaVerdSerrano();
                maxPico = limites.getMaxPicoVerdSerrano();

                minPeso  = limites.getMinPesoVerdSerrano();
                minTarso = limites.getMinTarsoVerdSerrano();
                minAla = limites.getMinAlaVerdSerrano();
                minPico = limites.getMinPicoVerdSerrano();
                break;
        }
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
        System.out.println("LATITUD                => " + latitud);
        System.out.println("LONGITUD               => " + longitud);
    }
}
