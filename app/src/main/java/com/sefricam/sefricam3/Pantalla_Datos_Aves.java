package com.sefricam.sefricam3;

import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Pantalla_Datos_Aves extends Activity implements AdapterView.OnItemSelectedListener, View.OnClickListener{

    private Button btn_Enviar, btn_Volver;
    private Spinner sp_Especies, sp_Capturas;
    private TextView tv_Hora;

    //Datos
    private String hora,especie,anillaPreexistente;
    private int numeroAnilla,localizacion,sexo,edad,nEjemplares,condicionFisica,grasa,musculoPectoral,muda,placaIncubatriz;
    private Double peso, longitudTarso, longitudPico, longitudTerceraPrimaria, capturasEnviadas;

    private double pesoMax, longitudTarsoMax, longitudPicoMax, longitudTerceraPrimariaMax,pesoMin, longitudTarsoMin, longitudPicoMin, longitudTerceraPrimariaMin;

    private EditText etn_NumeroAnilla, et_NumeroAnillaPreexistente, etnd_Peso, etnd_LongitudTarso, etnd_LongitudPico, etnd_LongitudTerceraPrimaria;
    private RadioGroup rbg_Localizacion, rbg_Sexo, rbg_Edad, rbg_CondicionFisica, rbg_Grasa, rbg_MusculoPectoral,rbg_Muda,rbg_PlacaInc;

    //Parametros
    private boolean envioCompletado;
    private MetodosCaptura metodosCaptura;
    private DatosAvistamiento datosAvistamiento;
    private DatosEntorno datosEntorno;
    private Limites limites;
    private boolean mCapturasCompletado,avistamientoCompletado,entornoCompletado;
    private String email,DNI;
    public FirebaseFirestore db;
    private String fecha, latitud, longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_datos_aves);

        db = FirebaseFirestore.getInstance();
        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            recuperarDatosRecibidos(datos);
            //Datos Recibidos de Menu Metodos y Capturas

            System.out.println("Datos recibidos en Datos Aves");
            imprimirDatosRecibidos();
        }

        iniciarFindView();
        iniciarOnClickListener();
        iniciarSpinners();

        cargarDatos(email);
    }

    private void cargarDatos(String email) {


        db.collection("users")
                .whereEqualTo("Email",email)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                DNI=(""+document.getData().get("DNI"));
                                capturasEnviadas =  Double.parseDouble(Objects.requireNonNull(document.getData().get("Capturas Enviadas")).toString());
                            }
                        }else{

                        }
                    }
                });

    }

    private void iniciarSpinners() {
        String [] nCapturas = {"-","0","1","2","3","4","5","6","7","8","9","10+"};
        ArrayAdapter<String> adapterCapturas = new ArrayAdapter<String>(this, R.layout.spinner,nCapturas);
        //sp_Capturas.setAdapter(adapterCapturas);
        String [] especies = {"Seleccione la especie","Camachuelo","Jilguero","Lúgano","Pardillo Común","Picogordo","Pinzón Común","Pinzón Real","Piquituerto","Verdecillo","Verderón Común","Verderón Serrano"};
        ArrayAdapter<String> adapterEspecies = new ArrayAdapter<String>(this, R.layout.spinner,especies);
        sp_Especies.setAdapter(adapterEspecies);
    }

    private void iniciarOnClickListener() {
        btn_Enviar.setOnClickListener(this);
        btn_Volver.setOnClickListener(this);
        tv_Hora.setOnClickListener(this);
    }

    private void iniciarFindView() {
        //Text View Hora Captura
        tv_Hora = (TextView) findViewById(R.id.tv_HoraCapturaAve);

        //Spinner Especie de Ave
        sp_Especies = (Spinner) findViewById(R.id.sp_Especie);

        //Datos del ave
        etn_NumeroAnilla = findViewById(R.id.etn_NumeroAnilla);
        et_NumeroAnillaPreexistente = findViewById(R.id.et_NumeroAnillaPrexistente);
        etnd_Peso = findViewById(R.id.etnd_Peso);
        etnd_LongitudTarso = findViewById(R.id.etnd_LongitudTarso);
        etnd_LongitudPico = findViewById(R.id.etnd_LongitudPico);
        etnd_LongitudTerceraPrimaria = findViewById(R.id.etnd_LongitudTerceraPrimaria);

        //Radio Button Group Ave Local
        rbg_Localizacion = findViewById(R.id.rbg_Localizacion);

        rbg_Sexo = findViewById(R.id.rbg_Sexo);

        rbg_Edad = findViewById(R.id.rbg_Edad);

        //sp_Capturas = (Spinner) findViewById(R.id.sp_Capturas);

        rbg_CondicionFisica = findViewById(R.id.rbg_CondicionFisica);

        rbg_Grasa = findViewById(R.id.rbg_Grasa);

        rbg_MusculoPectoral = findViewById(R.id.rbg_MusculoPectoral);

        rbg_Muda = findViewById(R.id.rbg_Muda);

        rbg_PlacaInc = findViewById(R.id.rbg_PlacaInc);

        btn_Volver = (Button) findViewById(R.id.btn_VolverAves);
        btn_Enviar = (Button) findViewById(R.id.btn_EnviarAves);


    }

    @Override
    public void onClick(View v) {
        if (v == btn_Enviar){
            if (comprobarValores()){
                asignacionValores();
                Intent activity = new Intent(this, Pantalla_Menu_Metodos_Y_Captura.class);
                guardarParametros(activity);

                activity.putExtra("FECHA",fecha);
                activity.putExtra("LATITUD", latitud);
                activity.putExtra("LONGITUD", longitud);

                envioDatos();
                startActivity(activity);
                finish();
            } else {
                Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_LONG).show();
            }
        }
        if (v == btn_Volver){
            Intent activity = new Intent(this, Pantalla_Menu_Metodos_Y_Captura.class);
            guardarParametros(activity);

            activity.putExtra("FECHA",fecha);
            activity.putExtra("LATITUD", latitud);
            activity.putExtra("LONGITUD", longitud);

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

    }

    private void envioDatos() {
        Map<String, Object> docData = new HashMap<>();
        //Formatear como date
        docData.put("Fecha Captura", fecha);
        docData.put("Latitud", latitud);
        docData.put("Longitud", longitud);
        docData.put("Hora Captura",hora);
        docData.put("Especie",especie);
        docData.put("Numero Ejemplares",nEjemplares);
        docData.put("Numero Anilla",numeroAnilla);
        docData.put("Anillla Preexistente",anillaPreexistente);
        docData.put("Peso",peso);
        docData.put("Longitud Tarso",longitudTarso);
        docData.put("Longitud Pico", longitudPico);
        docData.put("Longitud Tercera Primaria", longitudTerceraPrimaria);
        docData.put("Localizacion",localizacion);
        docData.put("Sexo",sexo);
        docData.put("Edad",edad);
        docData.put("Condicion Fisica",condicionFisica);
        docData.put("Grasa",grasa);
        docData.put("Musculo Pectoral",musculoPectoral);
        docData.put("Muda",muda);
        docData.put("Placa Incubatriz",placaIncubatriz);

        String rutaDocumento = ""+DNI+fecha+hora;
        db.collection("Aves").document(rutaDocumento)
                .set(docData)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Pantalla_Datos_Aves.this, "Se ha enviado correctamente los datos", Toast.LENGTH_LONG).show();
                        DocumentReference userRef = db.collection("users").document(DNI);
                        capturasEnviadas++;
                        userRef.update("Capturas Enviadas", capturasEnviadas);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Pantalla_Datos_Aves.this, "Algo no ha ido bien, vuelva a intentarlo.\nSi ve que el error persiste póngase en contacto con un administrador", Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void asignacionValores() {
        hora = tv_Hora.getText().toString();
        especie = sp_Especies.getSelectedItem().toString();
        if (!etn_NumeroAnilla.getText().toString().isEmpty()) numeroAnilla = Integer.parseInt(etn_NumeroAnilla.getText().toString());
        if (!et_NumeroAnillaPreexistente.getText().toString().isEmpty()) anillaPreexistente = et_NumeroAnillaPreexistente.getText().toString();
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
        nEjemplares = sp_Capturas.getSelectedItemPosition();
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
        boolean comprobado  = true;
        if (tv_Hora.getText().toString().equals("--:--")) comprobado = false;
        if (sp_Especies.getSelectedItemPosition()==0) comprobado = false;
        //if (Integer.parseInt(etn_NumeroAnilla.getText().toString())<1) comprobado =false;
        //if (Integer.parseInt(etn_NumeroAnilla.getText().toString())>20000) comprobado=false;
        //if (et_NumeroAnillaPreexistente.length()>30) comprobado=false;
        if (etnd_Peso.getText().toString().isEmpty()) comprobado=false;
        //if (Double.parseDouble(etnd_Peso.getText().toString())<pesoMin)comprobado=false;
        //if (Double.parseDouble(etnd_Peso.getText().toString())>pesoMax)comprobado=false;
        if (etnd_LongitudTarso.getText().toString().isEmpty()) comprobado=false;
        //if (Double.parseDouble(etnd_LongitudTarso.getText().toString())<longitudTarsoMin)comprobado=false;
        //if (Double.parseDouble(etnd_LongitudTarso.getText().toString())>longitudTarsoMax)comprobado=false;
        if (etnd_LongitudPico.getText().toString().isEmpty()) comprobado=false;
        //if (Double.parseDouble(etnd_LongitudPico.getText().toString())<longitudPicoMin)comprobado=false;
        //if (Double.parseDouble(etnd_LongitudPico.getText().toString())>longitudPicoMax)comprobado=false;
        if (etnd_LongitudTerceraPrimaria.getText().toString().isEmpty()) comprobado=false;
        //if (Double.parseDouble(etnd_LongitudTerceraPrimaria.getText().toString())<longitudTerceraPrimariaMin)comprobado=false;
        //if (Double.parseDouble(etnd_LongitudTerceraPrimaria.getText().toString())>longitudTerceraPrimariaMax)comprobado=false;
        if (rbg_Localizacion.getCheckedRadioButtonId()==-1) comprobado=false;
        if (rbg_Sexo.getCheckedRadioButtonId()==-1)comprobado=false;
        if (rbg_Edad.getCheckedRadioButtonId()==-1)comprobado=false;
        if (sp_Capturas.getSelectedItemPosition()==0)comprobado=false;
        if (rbg_CondicionFisica.getCheckedRadioButtonId()==-1)comprobado=false;
        if (rbg_Grasa.getCheckedRadioButtonId()==-1)comprobado=false;
        if (rbg_MusculoPectoral.getCheckedRadioButtonId()==-1)comprobado=false;
        if (rbg_Muda.getCheckedRadioButtonId()==-1) comprobado=false;
        if (rbg_Sexo.getCheckedRadioButtonId()==R.id.rb_SexoHembra){
            if (rbg_PlacaInc.getCheckedRadioButtonId()==-1)comprobado=false;
        }
        return comprobado;
    }

    /**
     * <p>Callback method to be invoked when an item in this view has been
     * selected. This callback is invoked only when the newly selected
     * position is different from the previously selected position or if
     * there was no selected item.</p>
     * <p>
     * Implementers can call getItemAtPosition(position) if they need to access the
     * data associated with the selected item.
     *
     * @param parent   The AdapterView where the selection happened
     * @param view     The view within the AdapterView that was clicked
     * @param position The position of the view in the adapter
     * @param id       The row id of the item that is selected
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Implementacion de los pesos maximos y minimos
        if (parent.getId()==R.id.sp_Especie){
            switch (parent.getSelectedItemPosition()){
                case 0:
                    break;
                default:
                    habilitarDatosPajaros();
                    pesoMax = 500;
                    longitudPicoMax = 10;
                    longitudTarsoMax = 10;
                    longitudTerceraPrimariaMax = 10;
                    pesoMin=0;
                    longitudPicoMin = 0;
                    longitudTarsoMin = 0;
                    longitudTerceraPrimariaMin = 0;
                    break;
            }
        }
    }

    private void habilitarDatosPajaros() {
        etn_NumeroAnilla.setEnabled(true);
        et_NumeroAnillaPreexistente.setEnabled(true);
        etnd_LongitudPico.setEnabled(true);
        etnd_LongitudTarso.setEnabled(true);
        etnd_LongitudTerceraPrimaria.setEnabled(true);
        etnd_Peso.setEnabled(true);
    }

    /**
     * Callback method to be invoked when the selection disappears from this
     * view. The selection can disappear for instance when touch is activated
     * or when the adapter becomes empty.
     *
     * @param parent The AdapterView that now contains no selected item.
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void guardarParametros(Intent actividadDestino) {

        imprimirDatosRecibidos();

        actividadDestino.putExtra("EMAIL",email);
        actividadDestino.putExtra("DNI",DNI);
        actividadDestino.putExtra("ENVIO_COMPLETADO",envioCompletado);
        actividadDestino.putExtra("DATOS_AVISTAMIENTO", datosAvistamiento);
        actividadDestino.putExtra("DATOS_ENTORNO", datosEntorno);
        actividadDestino.putExtra("DATOS_CAPTURA", metodosCaptura);
        actividadDestino.putExtra("ENTORNO_COMPLETADO", entornoCompletado);
        actividadDestino.putExtra("MCAPTURAS_COMPLETADO", mCapturasCompletado);
        actividadDestino.putExtra("AVISTAMIENTO_COMPLETADO", avistamientoCompletado);
        actividadDestino.putExtra("LIMITES", limites);

        if (mCapturasCompletado && entornoCompletado && avistamientoCompletado){
            actividadDestino.putExtra("FECHA", fecha);
            actividadDestino.putExtra("LATITUD", latitud);
            actividadDestino.putExtra("LONGITUD", longitud);
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

        if (mCapturasCompletado && avistamientoCompletado && entornoCompletado){
            fecha = datos.getString("FECHA");
            latitud = datos.getString("LATITUD");
            longitud = datos.getString("LONGITUD");
        }
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
        System.out.println("FECHA                  => " + fecha);
        System.out.println("LATITUD                => " + latitud);
        System.out.println("LONGITUD               => " + longitud);
    }
}
