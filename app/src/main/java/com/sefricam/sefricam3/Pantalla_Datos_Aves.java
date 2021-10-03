package com.sefricam.sefricam3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

public class Pantalla_Datos_Aves extends Activity implements  View.OnClickListener{

    //UI Parameters
    private Button btn_Enviar, btn_Volver;
    private TextView tv_Hora;
    private EditText etn_EjemplaresCapturados;
    private EditText etn_NumeroAnilla;
    private EditText et_NumeroAnillaPreexistente;
    private EditText etnd_Peso;
    private EditText etnd_LongitudTarso;
    private EditText etnd_LongitudPico;
    private EditText etnd_LongitudTerceraPrimaria;
    private RadioGroup rbg_Localizacion;
    private RadioGroup rbg_Sexo;
    private RadioGroup rbg_Edad;
    private RadioGroup rbg_CondicionFisica;
    private RadioGroup rbg_Grasa;
    private RadioGroup rbg_MusculoPectoral;
    private RadioGroup rbg_Muda;
    private RadioGroup rbg_PlacaInc;
    private RadioGroup rbg_EspeciesAves;
    //Radio Buttons para las Especies
    private RadioButton rb_EspecieCamachuelo;
    private RadioButton rb_EspecieJilguero;
    private RadioButton rb_EspecieLugano;
    private RadioButton rb_EspeciePardComun;
    private RadioButton rb_EspeciePicogordo;
    private RadioButton rb_EspeciePinzComun;
    private RadioButton rb_EspeciePinzReal;
    private RadioButton rb_EspeciePiquituerto;
    private RadioButton rb_EspecieVerdecillo;
    private RadioButton rb_EspecieVerdComun;
    private RadioButton rb_EspecieVerdSerrano;
    //Radio Buttons para la Localizacion
    private RadioButton rb_LocalizacionLocal;
    private RadioButton rb_LocalizacionNoLocal;
    private RadioButton rb_LocalizacionIndeterminado;
    //Radio Buttons para el Sexo
    private RadioButton rb_SexoMacho;
    private RadioButton rb_SexoHembra;
    private RadioButton rb_SexoIndeterminado;
    //Radio Buttons para la Edad
    private RadioButton rb_EdadJuvenil;
    private RadioButton rb_EdadAdulto;
    //Radio Buttons para la Condicion Fisica
    private RadioButton rb_CondicionBuena;
    private RadioButton rb_CondicionLesiones;
    private RadioButton rb_CondicionEnfermedad;
    private RadioButton rb_CondicionMalformacion;
    //Radio Buttons para la Grasa
    private RadioButton rb_GrasaAusente;
    private RadioButton rb_GrasaInter;
    private RadioButton rb_GrasaInter_Abd;
    private RadioButton rb_GrasaInter_Abd_Pectoral;
    //Radio Buttons para el Musculo Pectoral
    private RadioButton rb_MusculoQEvidente;
    private RadioButton rb_MusculoQDistinguible;
    private RadioButton rb_MusculoQLigera;
    private RadioButton rb_MusculoNoQ;
    //Radio Buttons para la Muda
    private RadioButton rb_MudaAusente;
    private RadioButton rb_MudaEnCurso;
    private RadioButton rb_MudaTerminada;
    //Radio Buttons para la Placa Incubatriz
    private RadioButton rb_PlacaIncNoEvidencia;
    private RadioButton rb_PlacaIncIncompleta;
    private RadioButton rb_PlacaIncMEvidente;
    private TextView tv_PlacaInc;

    //Class Parameters
    private Envio envio;
    private DatosAves ave;
    private Limites limites;
    //Biometric parameters for the birds
    private double maxPeso, maxTarso, maxAla, maxPico, minPeso, minTarso, minAla, minPico;

    /**
     * Initialize the screen and all its components
     * @param savedInstanceState bundle of data that receives when it starts the screen
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_datos_aves);

        Bundle datos = this.getIntent().getExtras();

        if (datos != null) {
            recuperarDatosRecibidos(datos);
        }

        startFindView();
        setOnClickListener();
        if (ave.isModificacion()) loadData();
    }

    /**
     * If we receive a modification we load the data into the fields
     */
    private void loadData() {
        btn_Enviar.setText(R.string.PDA_btn_Modificar);
        tv_Hora.setText(ave.getHoraCaptura());

        switch (ave.getEspecie()){
            case 1:
                rb_EspecieCamachuelo.setChecked(true);
                break;
            case 2:
                rb_EspecieJilguero.setChecked(true);
                break;
            case 3:
                rb_EspecieLugano.setChecked(true);
                break;
            case 4:
                rb_EspeciePardComun.setChecked(true);
                break;
            case 5:
                rb_EspeciePicogordo.setChecked(true);
                break;
            case 6:
                rb_EspeciePinzComun.setChecked(true);
                break;
            case 7:
                rb_EspeciePinzReal.setChecked(true);
                break;
            case 8:
                rb_EspeciePiquituerto.setChecked(true);
                break;
            case 9:
                rb_EspecieVerdecillo.setChecked(true);
                break;
            case 10:
                rb_EspecieVerdComun.setChecked(true);
                break;
            case 11:
                rb_EspecieVerdSerrano.setChecked(true);
                break;
        }

        etn_EjemplaresCapturados.setText(String.valueOf(ave.getnEjemplares()));
        etn_NumeroAnilla.setText(String.valueOf(ave.getnAnilla()));
        et_NumeroAnillaPreexistente.setText(ave.getAnillaPreexistente());
        etnd_Peso.setText(String.valueOf(ave.getPeso()));
        etnd_LongitudTarso.setText(String.valueOf(ave.getLongitudTarso()));
        etnd_LongitudPico.setText(String.valueOf(ave.getLongitudPico()));
        etnd_LongitudTerceraPrimaria.setText(String.valueOf(ave.getLongitudTerceraPrimaria()));

        switch (ave.getLocalizacion()){
            case 1:
                rb_LocalizacionLocal.setChecked(true);
                break;
            case 2:
                rb_LocalizacionNoLocal.setChecked(true);
                break;
            case 3:
                rb_LocalizacionIndeterminado.setChecked(true);
                break;
        }

        switch (ave.getSexo()){
            case 1:
                rb_SexoMacho.setChecked(true);
                switchPlacaIncubatriz(false);
                break;
            case 2:
                rb_SexoHembra.setChecked(true);
                switchPlacaIncubatriz(true);
                break;
            case 3:
                rb_SexoIndeterminado.setChecked(true);
                switchPlacaIncubatriz(false);
                break;
        }

        switch (ave.getEdad()){
            case 1:
                rb_EdadJuvenil.setChecked(true);
                break;
            case 2:
                rb_EdadAdulto.setChecked(true);
                break;
        }

        switch (ave.getCondicionFisica()){
            case 1:
                rb_CondicionBuena.setChecked(true);
                break;
            case 2:
                rb_CondicionLesiones.setChecked(true);
                break;
            case 3:
                rb_CondicionEnfermedad.setChecked(true);
                break;
            case 4:
                rb_CondicionMalformacion.setChecked(true);
                break;
        }

        switch (ave.getGrasa()){
            case 1:
                rb_GrasaAusente.setChecked(true);
                break;
            case 2:
                rb_GrasaInter.setChecked(true);
                break;
            case 3:
                rb_GrasaInter_Abd.setChecked(true);
                break;
            case 4:
                rb_GrasaInter_Abd_Pectoral.setChecked(true);
                break;
        }

        switch (ave.getMusculoPectoral()){
            case 1:
                rb_MusculoQEvidente.setChecked(true);
                break;
            case 2:
                rb_MusculoQDistinguible.setChecked(true);
                break;
            case 3:
                rb_MusculoQLigera.setChecked(true);
                break;
            case 4:
                rb_MusculoNoQ.setChecked(true);
                break;
        }

        switch (ave.getMuda()){
            case 1:
                rb_MudaAusente.setChecked(true);
                break;
            case 2:
                rb_MudaEnCurso.setChecked(true);
                break;
            case 3:
                rb_MudaTerminada.setChecked(true);
                break;
        }

        switch (ave.getPlacaIncubatriz()){
            case 0:
                break;
            case 1:
                rb_PlacaIncNoEvidencia.setChecked(true);
                break;
            case 2:
                rb_PlacaIncIncompleta.setChecked(true);
                break;
            case 3:
                rb_PlacaIncMEvidente.setChecked(true);
                break;
        }
    }

    /**
     * Init the UI elements into the code
     */
    private void startFindView() {
        //Text View Hora Captura
        tv_Hora = findViewById(R.id.tv_HoraCapturaAve);

        //RB Especie aves
        rbg_EspeciesAves = findViewById(R.id.rbg_EspeciesAves);
        rb_EspecieCamachuelo = findViewById(R.id.rb_EspecieCamachuelo);
        rb_EspecieJilguero = findViewById(R.id.rb_EspecieJilguero);
        rb_EspecieLugano = findViewById(R.id.rb_EspecieLugano);
        rb_EspeciePardComun = findViewById(R.id.rb_EspeciePardComun);
        rb_EspeciePicogordo = findViewById(R.id.rb_EspeciePicogordo);
        rb_EspeciePinzComun = findViewById(R.id.rb_EspeciePinzComun);
        rb_EspeciePinzReal = findViewById(R.id.rb_EspeciePinzReal);
        rb_EspeciePiquituerto = findViewById(R.id.rb_EspeciePiquituerto);
        rb_EspecieVerdecillo = findViewById(R.id.rb_EspecieVerdecillo);
        rb_EspecieVerdComun = findViewById(R.id.rb_EspecieVerdComun);
        rb_EspecieVerdSerrano = findViewById(R.id.rb_EspecieVerdSerrano);

        etn_EjemplaresCapturados = findViewById(R.id.etn_EjemplaresCapturados);

        //Datos del ave
        etn_NumeroAnilla = findViewById(R.id.etn_NumeroAnilla);
        et_NumeroAnillaPreexistente = findViewById(R.id.et_NumeroAnillaPrexistente);
        etnd_Peso = findViewById(R.id.etnd_Peso);
        etnd_LongitudTarso = findViewById(R.id.etnd_LongitudTarso);
        etnd_LongitudPico = findViewById(R.id.etnd_LongitudPico);
        etnd_LongitudTerceraPrimaria = findViewById(R.id.etnd_LongitudTerceraPrimaria);

        //Radio Buttons Localizacion
        rbg_Localizacion = findViewById(R.id.rbg_Localizacion);
        rb_LocalizacionLocal =findViewById(R.id.rb_LocalizacionLocal);
        rb_LocalizacionNoLocal =findViewById(R.id.rb_LocalizacionNoLocal);
        rb_LocalizacionIndeterminado =findViewById(R.id.rb_LocalizacionIndeterminado);

        //Radio Buttons Sexo
        rbg_Sexo = findViewById(R.id.rbg_Sexo);
        rb_SexoMacho = findViewById(R.id.rb_SexoMacho);
        rb_SexoHembra = findViewById(R.id.rb_SexoHembra);
        rb_SexoIndeterminado = findViewById(R.id.rb_SexoIndeterminado);

        //Radio Buttons Edad
        rbg_Edad = findViewById(R.id.rbg_Edad);
        rb_EdadJuvenil = findViewById(R.id.rb_EdadJuvenil);
        rb_EdadAdulto = findViewById(R.id.rb_EdadAdulto);

        //Radio Buttons Condicion Fisica
        rbg_CondicionFisica = findViewById(R.id.rbg_CondicionFisica);
        rb_CondicionBuena = findViewById(R.id.rb_CondicionBuena);
        rb_CondicionLesiones = findViewById(R.id.rb_CondicionLesiones);
        rb_CondicionEnfermedad = findViewById(R.id.rb_CondicionEnfermedad);
        rb_CondicionMalformacion = findViewById(R.id.rb_CondicionMalformacion);

        //Radio Buttons Grasa
        rbg_Grasa = findViewById(R.id.rbg_Grasa);
        rb_GrasaAusente = findViewById(R.id.rb_GrasaAusente);
        rb_GrasaInter = findViewById(R.id.rb_GrasaInter);
        rb_GrasaInter_Abd = findViewById(R.id.rb_GrasaInter_Abd);
        rb_GrasaInter_Abd_Pectoral = findViewById(R.id.rb_GrasaInter_Abd_Pectoral);

        //Radio Buttons Musculo Pectoral
        rbg_MusculoPectoral = findViewById(R.id.rbg_MusculoPectoral);
        rb_MusculoQEvidente = findViewById(R.id.rb_MusculoQEvidente);
        rb_MusculoQLigera = findViewById(R.id.rb_MusculoQLigera);
        rb_MusculoQDistinguible = findViewById(R.id.rb_MusculoQDistinguible);
        rb_MusculoNoQ = findViewById(R.id.rb_MusculoNoQ);

        //Radio Buttons Muda
        rbg_Muda = findViewById(R.id.rbg_Muda);
        rb_MudaAusente = findViewById(R.id.rb_MudaAusente);
        rb_MudaEnCurso = findViewById(R.id.rb_MudaEnCurso);
        rb_MudaTerminada = findViewById(R.id.rb_MudaTerminada);

        //Placa Incubatriz
        tv_PlacaInc = findViewById(R.id.tv_PlacaInc);
        rbg_PlacaInc = findViewById(R.id.rbg_PlacaInc);
        rb_PlacaIncNoEvidencia = findViewById(R.id.rb_PlacaIncNoEvidencia);
        rb_PlacaIncIncompleta = findViewById(R.id.rb_PlacaIncIncompleta);
        rb_PlacaIncMEvidente = findViewById(R.id.rb_PlacaIncMEvidente);

        //Botones de Control
        btn_Volver = findViewById(R.id.btn_VolverAves);
        btn_Enviar = findViewById(R.id.btn_EnviarAves);

    }

    /**
     * Sets all the click listener for the UI elements
     */
    private void setOnClickListener() {
        btn_Enviar.setOnClickListener(this);
        btn_Volver.setOnClickListener(this);
        tv_Hora.setOnClickListener(this);
        rb_SexoIndeterminado.setOnClickListener(this);
        rb_SexoHembra.setOnClickListener(this);
        rb_SexoMacho.setOnClickListener(this);

    }

    /**
     * Handle the onClick event for the UI elements
     * @param view the view that was clicked
     */
    @Override
    public void onClick(View view) {
        if (view == btn_Enviar){
            if (checkValues()){
                setAveObject();
                Intent activity = new Intent(this, Pantalla_Menu_Metodos_Y_Captura.class);
                guardarParametros(activity);

                if (ave.isModificacion()) modifyData();
                else sendData();

                startActivity(activity);
                finish();
            }
        }
        if (view == btn_Volver){
            Intent activity = new Intent(this, Pantalla_Menu_Metodos_Y_Captura.class);
            guardarParametros(activity);

            startActivity(activity);
            finish();
        }
        if (view == tv_Hora){
            TimePickerDialog recogerHora = new TimePickerDialog(this, (view1, hourOfDay, minute) -> {
                String hora;
                if (minute<10){
                    hora = hourOfDay+":0"+minute;
                } else {
                    hora = hourOfDay+":"+minute;
                }
                tv_Hora.setText(hora);
            }, 7, 0, true);
            recogerHora.show();
        }
        if (view == rb_SexoHembra){
            switchPlacaIncubatriz(true);
        }
        if (view == rb_SexoMacho){
            switchPlacaIncubatriz(false);
        }
        if (view == rb_SexoIndeterminado){
            switchPlacaIncubatriz(false);
        }
    }

    /**
     * Sets the placa Incubatriz UI section to active or not
     * @param b if b==true its clickable else is not
     */
    private void switchPlacaIncubatriz(boolean b) {
        if (b){
            tv_PlacaInc.setTextColor(getColor(R.color.VerdePrimario));
            rb_PlacaIncMEvidente.setTextColor(getColor(R.color.VerdePrimario));
            rb_PlacaIncIncompleta.setTextColor(getColor(R.color.VerdePrimario));
            rb_PlacaIncNoEvidencia.setTextColor(getColor(R.color.VerdePrimario));
        } else {
            tv_PlacaInc.setTextColor(getColor(R.color.Gris));
            rb_PlacaIncMEvidente.setTextColor(getColor(R.color.Gris));
            rb_PlacaIncIncompleta.setTextColor(getColor(R.color.Gris));
            rb_PlacaIncNoEvidencia.setTextColor(getColor(R.color.Gris));
        }
        rb_PlacaIncMEvidente.setClickable(b);
        rb_PlacaIncIncompleta.setClickable(b);
        rb_PlacaIncNoEvidencia.setClickable(b);

    }

    /**
     * Update the bird object into the DB
     */
    private void modifyData() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Datos_Aves");

        // Retrieve the object by id
        query.getInBackground(ave.getObjectID(), (entity, e) -> {
            if (e == null) {
                //noinspection ConstantConditions
                entity = assignFields(entity);

                entity.saveInBackground(e1 -> {
                    if (e1 ==null){
                        //Save was done
                        Toast.makeText(Pantalla_Datos_Aves.this, "Se ha actualizado el envío correctamente", Toast.LENGTH_SHORT).show();
                    }else{
                        //Something went wrong
                        Toast.makeText(Pantalla_Datos_Aves.this, e1.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            } else {
                e.printStackTrace();
                // something went wrong
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Send a new Datos_Aves object to the DB
     */
    public void sendData() {
        ParseObject entity = new ParseObject("Datos_Aves");

        assignFields(entity);

        entity.saveInBackground(e -> {
            if (e==null){
                //Save was done
                updateUserData();
                Toast.makeText(Pantalla_Datos_Aves.this, "Se ha realizado el envío correctamente", Toast.LENGTH_SHORT).show();
            }else{
                //Something went wrong
                Toast.makeText(Pantalla_Datos_Aves.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Sets the fields to the object to send
     * @param entity the object that is sent
     * @return the object with the assigned fields
     */
    private ParseObject assignFields(ParseObject entity) {

        entity.put("NumGrupo",ave.getNumGrupo());
        entity.put("FechaCap",ave.getFechaCaptura());
        entity.put("Latitud",ave.getLatitud());
        entity.put("Longitud",ave.getLongitud());
        entity.put("HoraCap",ave.getHoraCaptura());
        entity.put("Especie",ave.getEspecie());
        entity.put("NEjemplares",ave.getnEjemplares());
        entity.put("NumAnilla",ave.getnAnilla());
        entity.put("AnillaPre",ave.getAnillaPreexistente());
        entity.put("Peso",ave.getPeso());
        entity.put("LongTarso",ave.getLongitudTarso());
        entity.put("LongPico",ave.getLongitudPico());
        entity.put("LongTerPrim",ave.getLongitudTerceraPrimaria());
        entity.put("Localizacion",ave.getLocalizacion());
        entity.put("Sexo",ave.getSexo());
        entity.put("Edad",ave.getEdad());
        entity.put("CondFisica",ave.getCondicionFisica());
        entity.put("Grasa",ave.getGrasa());
        entity.put("MuscPectoral",ave.getMusculoPectoral());
        entity.put("Muda",ave.getMuda());
        entity.put("PlacIncubatriz",ave.getPlacaIncubatriz());

        return entity;
    }

    /**
     * Updates the UserData with the new Datos_Aves send
     */
    private void updateUserData() {
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser!= null){
            int avesEnviadas  = currentUser.getInt("NumAves");
            avesEnviadas++;
            currentUser.put("NumAves", avesEnviadas);
            currentUser.saveInBackground(e -> {
                if(e==null){
                    //Save successful
                    Toast.makeText(Pantalla_Datos_Aves.this, "Save Successful", Toast.LENGTH_SHORT).show();
                }else{
                    // Something went wrong while saving
                    Toast.makeText(Pantalla_Datos_Aves.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    /**
     * Sets to the Ave Object the values from the UI
     */
    @SuppressLint("NonConstantResourceId")
    private void setAveObject() {

        ave.setHoraCaptura(tv_Hora.getText().toString());

        //Asignacion de especie
        switch (rbg_EspeciesAves.getCheckedRadioButtonId()){
            case R.id.rb_EspecieCamachuelo:
                ave.setEspecie(1);
                break;
            case R.id.rb_EspecieJilguero:
                ave.setEspecie(2);
                break;
            case R.id.rb_EspecieLugano:
                ave.setEspecie(3);
                break;
            case R.id.rb_EspeciePardComun:
                ave.setEspecie(4);
                break;
            case R.id.rb_EspeciePicogordo:
                ave.setEspecie(5);
                break;
            case R.id.rb_EspeciePinzComun:
                ave.setEspecie(6);
                break;
            case R.id.rb_EspeciePinzReal:
                ave.setEspecie(7);
                break;
            case R.id.rb_EspeciePiquituerto:
                ave.setEspecie(8);
                break;
            case R.id.rb_EspecieVerdecillo:
                ave.setEspecie(9);
                break;
            case R.id.rb_EspecieVerdComun:
                ave.setEspecie(10);
                break;
            case R.id.rb_EspecieVerdSerrano:
                ave.setEspecie(11);
                break;
        }

        //Asignacion de anilla
        if (!etn_NumeroAnilla.getText().toString().isEmpty()) {
            ave.setnAnilla(Integer.parseInt(etn_NumeroAnilla.getText().toString()));
            ave.setAnillaPreexistente("");
        } else {
            ave.setnAnilla(0);
            ave.setAnillaPreexistente(et_NumeroAnillaPreexistente.getText().toString());
        }

        //Asignación de parámetros
        ave.setPeso(Double.parseDouble(etnd_Peso.getText().toString()));
        ave.setLongitudTarso(Double.parseDouble(etnd_LongitudTarso.getText().toString()));
        ave.setLongitudPico(Double.parseDouble(etnd_LongitudPico.getText().toString()));
        ave.setLongitudTerceraPrimaria(Double.parseDouble(etnd_LongitudTerceraPrimaria.getText().toString()));

        switch (rbg_Localizacion.getCheckedRadioButtonId()){
            case R.id.rb_LocalizacionLocal:
                ave.setLocalizacion(1);
                break;
            case R.id.rb_LocalizacionNoLocal:
                ave.setLocalizacion(2);
                break;
            case R.id.rb_LocalizacionIndeterminado:
                ave.setLocalizacion(3);
                break;
        }
        switch (rbg_Sexo.getCheckedRadioButtonId()){
            case R.id.rb_SexoMacho:
                ave.setSexo(1);
                break;
            case R.id.rb_SexoHembra:
                ave.setSexo(2);
                break;
            case R.id.rb_SexoIndeterminado:
                ave.setSexo(3);
                break;
        }
        switch (rbg_Edad.getCheckedRadioButtonId()){
            case R.id.rb_EdadJuvenil:
                ave.setEdad(1);
                break;
            case R.id.rb_EdadAdulto:
                ave.setEdad(2);
                break;
        }

        ave.setnEjemplares(Integer.parseInt(etn_EjemplaresCapturados.getText().toString()));

        switch (rbg_CondicionFisica.getCheckedRadioButtonId()){
            case R.id.rb_CondicionBuena:
                ave.setCondicionFisica(1);
                break;
            case R.id.rb_CondicionLesiones:
                ave.setCondicionFisica(2);
                break;
            case R.id.rb_CondicionEnfermedad:
                ave.setCondicionFisica(3);
                break;
            case R.id.rb_CondicionMalformacion:
                ave.setCondicionFisica(4);
                break;
        }
        switch (rbg_Grasa.getCheckedRadioButtonId()){
            case R.id.rb_GrasaAusente:
                ave.setGrasa(1);
                break;
            case R.id.rb_GrasaInter:
                ave.setGrasa(2);
                break;
            case R.id.rb_GrasaInter_Abd:
                ave.setGrasa(3);
                break;
            case R.id.rb_GrasaInter_Abd_Pectoral:
                ave.setGrasa(4);
                break;
        }
        switch (rbg_MusculoPectoral.getCheckedRadioButtonId()){
            case R.id.rb_MusculoQEvidente:
                ave.setMusculoPectoral(1);
                break;
            case R.id.rb_MusculoQDistinguible:
                ave.setMusculoPectoral(2);
                break;
            case R.id.rb_MusculoQLigera:
                ave.setMusculoPectoral(3);
                break;
            case R.id.rb_MusculoNoQ:
                ave.setMusculoPectoral(4);
                break;
        }
        switch (rbg_Muda.getCheckedRadioButtonId()){
            case R.id.rb_MudaAusente:
                ave.setMuda(1);
                break;
            case R.id.rb_MudaEnCurso:
                ave.setMuda(2);
                break;
            case R.id.rb_MudaTerminada:
                ave.setMuda(3);
                break;
        }
        if (ave.getSexo()==2){
            switch (rbg_PlacaInc.getCheckedRadioButtonId()){
                case R.id.rb_PlacaIncNoEvidencia:
                    ave.setPlacaIncubatriz(1);
                    break;
                case R.id.rb_PlacaIncIncompleta:
                    ave.setPlacaIncubatriz(2);
                    break;
                case R.id.rb_PlacaIncMEvidente:
                    ave.setPlacaIncubatriz(3);
                    break;
            }
        } else ave.setPlacaIncubatriz(0);

    }

    /**
     * Check that the values are in the right range
     * @return true if all its OK else, false
     */
    private boolean checkValues() {

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
            if (Integer.parseInt(etn_NumeroAnilla.getText().toString())!=99999){
                if (Integer.parseInt(etn_NumeroAnilla.getText().toString())<limites.getMinNAnilla() || Integer.parseInt(etn_NumeroAnilla.getText().toString())>limites.getMaxNAnilla()){
                    Toast.makeText(this, "El numero de anilla no corresponde a tus limites de anillamiento", Toast.LENGTH_SHORT).show();
                    return false;
                }
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

        setBiometricParameters();

        if(Double.parseDouble(etnd_Peso.getText().toString())!=0){
            if (Double.parseDouble(etnd_Peso.getText().toString())<minPeso || Double.parseDouble(etnd_Peso.getText().toString())>maxPeso){
                Toast.makeText(this, "El peso no se correspone a los parámetros del ave seleccionada", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if(Double.parseDouble(etnd_LongitudTarso.getText().toString())!=0){
            if (Double.parseDouble(etnd_LongitudTarso.getText().toString())<minTarso || Double.parseDouble(etnd_LongitudTarso.getText().toString())>maxTarso){
                Toast.makeText(this, "La longitud del tarso no se correspone a los parámetros del ave seleccionada", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if(Double.parseDouble(etnd_LongitudPico.getText().toString())!=0){
            if (Double.parseDouble(etnd_LongitudPico.getText().toString())<minPico || Double.parseDouble(etnd_LongitudPico.getText().toString())>maxPico){
                Toast.makeText(this, "La longitud del pico no se correspone a los parámetros del ave seleccionada", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if(Double.parseDouble(etnd_LongitudTerceraPrimaria.getText().toString())!=0){
            if (Double.parseDouble(etnd_LongitudTerceraPrimaria.getText().toString())<minAla || Double.parseDouble(etnd_LongitudTerceraPrimaria.getText().toString())>maxAla){
                Toast.makeText(this, "La longitud de la tercera primaria no se correspone a los parámetros del ave seleccionada", Toast.LENGTH_SHORT).show();
                return false;
            }
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

    /**
     * Assign the fields in to the new Activity
     * @param actividadDestino the activity were are send
     */
    private void guardarParametros(Intent actividadDestino) {
        actividadDestino.putExtra("ENVIO", envio);
        actividadDestino.putExtra("LIMITES", limites);
    }

    /**
     * Retrieve the data from the previous activity
     * @param datos bundle from the previous activity
     */
    private void recuperarDatosRecibidos(Bundle datos) {
        envio = (Envio) datos.getSerializable("ENVIO");
        limites = (Limites) datos.getSerializable("LIMITES");
        ave = (DatosAves) datos.getSerializable("AVE");
    }

    /**
     * Sets the biometric parameters according to the type of bird selected
     */
    @SuppressLint("NonConstantResourceId")
    private void setBiometricParameters() {
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

    /**
     * Prints the received data from an activity
     */
    private void imprimirDatosRecibidos() {
        System.out.println("____________________________________________________");
        System.out.println("LIMITES                => " + limites);
        System.out.println("ENVIO                  => " + envio);
        System.out.println("____________________________________________________");
    }
}
