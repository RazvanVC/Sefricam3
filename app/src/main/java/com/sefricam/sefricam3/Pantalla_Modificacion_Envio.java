package com.sefricam.sefricam3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class Pantalla_Modificacion_Envio extends Activity implements View.OnClickListener{

    // UI Parameters
    private Spinner sp_EnvioSeleccionado;
    private Button btn_ContinuarModificacionEnvio, btn_VolverModificacionEnvio;

    // Class Parameters
    private Envio envio;
    private Limites limites;
    private final ArrayList<Envio> enviosRecibidos = new ArrayList<>();

    /**
     * Initialize the screen and all its components
     * @param savedInstanceState bundle of data that receives when it starts the screen
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_modificacion_envio);

        //Carga de datos recuperados de la BD
        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            envio = (Envio) datos.getSerializable("ENVIO");
            limites = (Limites) datos.getSerializable("LIMITES");
            System.out.println(limites);
            System.out.println("NUMERO GRUPO MOD: " + limites.getNumeroGrupo());
        }

        //Inicio de los Elementos del layout
        startFindView();
        startOnClickListeners();
        startSpinners();

    }


    /**
     * Retrieves all Envios from Parse Database which have the same DNI as the user.
     * @return an String Array filled with the keys of the objects
     */
    private ArrayList<String> cargarEnvios() {
        ArrayList <String> enviosCargados = new ArrayList<>();
        enviosCargados.add("Seleccione un envio");

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Datos_Entorno");
        query.whereEqualTo("DNI",envio.getDNI());
        query.findInBackground((objects, e) -> {
            if (e == null){
                chargeEnvios(objects);
                for (int i = 0; i<enviosRecibidos.size(); i++){
                    Envio localEnvio = enviosRecibidos.get(i);
                    Calendar localCalendar = Calendar.getInstance();
                    localCalendar.setTime(localEnvio.getFecha());
                    enviosCargados.add(localCalendar.get(Calendar.DAY_OF_MONTH) + "/" + (localCalendar.get(Calendar.MONTH)+1) + "/" + localCalendar.get(Calendar.YEAR) +" - " + localEnvio.getDNI());
                }
                /* Checks if the array have just one element */
                if (enviosCargados.size()==1){
                    enviosCargados.remove(0);
                    enviosCargados.add(getString(R.string.PME_NoDataFound));
                }
            } else {
                enviosCargados.remove(0);
                enviosCargados.add(getString(R.string.PME_NoDataFound));
            }
        });
        return enviosCargados;
    }

    /**
     * Put in Envios ArrayList all the Envio from the Parse Database
     * @param objects arraylist filled with the database objects
     */
    private void chargeEnvios(java.util.List<ParseObject> objects) {
        ParseObject obj;
        for (int i = 0; i< objects.size(); i++){
            obj = objects.get(i);

            Envio localEnvio = new Envio(envio.getDNI(), envio.getEmail());
            DatosAvistamiento da = getDatosAvistamiento(obj);
            DatosEntorno de = getDatosEntorno(obj);
            MetodosCaptura mc = getMetodosCaptura(obj);

            localEnvio.setDatosAvistamiento(da);
            localEnvio.setAvistamientoCompletado(true);
            localEnvio.setDatosEntorno(de);
            localEnvio.setEntornoCompletado(true);
            localEnvio.setMetodosCaptura(mc);
            localEnvio.setMCapturaCompletado(true);
            localEnvio.setModificacion(true);
            localEnvio.setEnvioCompletado(true);

            Calendar c = Calendar.getInstance();
            c.setTime(Objects.requireNonNull(obj.getDate("Fecha")));
            c.add(Calendar.DAY_OF_MONTH, -1);
            localEnvio.setFecha(c.getTime());
            localEnvio.setLatitud(Double.parseDouble(String.valueOf(obj.getNumber("Latitud"))));
            localEnvio.setLongitud(Double.parseDouble(String.valueOf(obj.getNumber("Longitud"))));
            localEnvio.setObjectID(obj.getObjectId());
            enviosRecibidos.add(localEnvio);
        }
    }

    /**
     * Extracts all the data to compose a MetodosCaptura Object
     * @param obj object from where the data is extracted
     * @return a new MetodosCaptura object from the data
     */
    private MetodosCaptura getMetodosCaptura(ParseObject obj) {
        ArrayList<Boolean> ca = new ArrayList<>();
        for (int i = 1; i<7; i++){
            String key = "CA0"+i;
            ca.add(obj.getBoolean(key));
        }

        return new MetodosCaptura(
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("NumMallas")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("LongRed")).toString()),
                obj.getBoolean("Coto"),
                ca,
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("RecCamachuelo")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CimCamachuelo")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapCamachueloM")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapCamachueloH")).toString()),

                Integer.parseInt(Objects.requireNonNull(obj.getNumber("RecJilguero")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CimJilguero")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapJilgueroM")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapJilgueroH")).toString()),

                Integer.parseInt(Objects.requireNonNull(obj.getNumber("RecLugano")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CimLugano")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapLuganoM")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapLuganoH")).toString()),

                Integer.parseInt(Objects.requireNonNull(obj.getNumber("RecPardComun")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CimPardComun")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapPardComunM")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapPardComunH")).toString()),

                Integer.parseInt(Objects.requireNonNull(obj.getNumber("RecPicogordo")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CimPicogordo")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapPicogordoM")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapPicogordoH")).toString()),

                Integer.parseInt(Objects.requireNonNull(obj.getNumber("RecPinzComun")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CimPinzComun")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapPinzComunM")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapPinzComunH")).toString()),

                Integer.parseInt(Objects.requireNonNull(obj.getNumber("RecPinzReal")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CimPinzReal")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapPinzRealM")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapPinzRealH")).toString()),

                Integer.parseInt(Objects.requireNonNull(obj.getNumber("RecPiquituerto")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CimPiquituerto")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapPiquituertoM")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapPiquituertoH")).toString()),

                Integer.parseInt(Objects.requireNonNull(obj.getNumber("RecVerdecillo")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CimVerdecillo")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapVerdecilloM")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapVerdecilloH")).toString()),

                Integer.parseInt(Objects.requireNonNull(obj.getNumber("RecVerdComun")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CimVerdComun")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapVerdComunM")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapVerdComunH")).toString()),

                Integer.parseInt(Objects.requireNonNull(obj.getNumber("RecVerdSerrano")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CimVerdSerrano")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapVerdSerranoM")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("CapVerdSerranoH")).toString()),

                obj.getString("Observaciones")
        );
    }

    /**
     * Extracts all the data to compose a DatosEntorno Object
     * @param obj object from where the data is extracted
     * @return a new DatosEntorno object from the data
     */
    private DatosEntorno getDatosEntorno(ParseObject obj) {
        ArrayList<Integer> plantas = new ArrayList<>();

        for (int i = 1; i<37; i++){
            String field;
            if (i<10) field = "EP0".concat(String.valueOf(i));
            else field = "EP".concat(String.valueOf(i));

            System.out.println("GMC - " + field);
            plantas.add(Integer.valueOf(Objects.requireNonNull(obj.getNumber(field)).toString()));
        }

        return new DatosEntorno(
                Double.parseDouble(Objects.requireNonNull(obj.getNumber("TempInicial")).toString()),
                Double.parseDouble(Objects.requireNonNull(obj.getNumber("TempFinal")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("Zonificacion")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("Viento")).toString()),
                obj.getString("DirViento"),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("Nubes")).toString()),
                Integer.parseInt(Objects.requireNonNull(obj.getNumber("Lluvia")).toString()),
                plantas,
                obj.getString("EP37"),
                obj.getString("EP38")
        );
    }

    /**
     * Extracts all the data to compose a DatosAvistamiento Object
     * @param obj object from where the data is extracted
     * @return a new DatosAvistamiento object from the data
     */
    private DatosAvistamiento getDatosAvistamiento(ParseObject obj) {
        ArrayList<Integer> hora08 = new ArrayList<>(), hora09 = new ArrayList<>(), hora10 = new ArrayList<>(), hora11 = new ArrayList<>(), hora12 = new ArrayList<>(), hora13 = new ArrayList<>(), hora14 = new ArrayList<>();
        for (int i = 8; i<15; i++) {
            ArrayList<String> headers = new ArrayList<>();
            headers.add("Cam"); headers.add("Jil"); headers.add("Lug"); headers.add("PardC"); headers.add("Pic");headers.add("PinC");headers.add("PinR");headers.add("Piq");headers.add("Verd");headers.add("VerdC");headers.add("VerdS");
            for (int z = 0; z<headers.size(); z++){
                String field;
                switch (i){
                    case 8:
                        field = headers.get(z).concat("08");
                        hora08.add(Integer.valueOf(Objects.requireNonNull(obj.getNumber(field)).toString()));
                        break;
                    case 9:
                        field = headers.get(z).concat("09");
                        hora09.add(Integer.valueOf(Objects.requireNonNull(obj.getNumber(field)).toString()));
                        break;
                    case 10:
                        field = headers.get(z).concat("10");
                        hora10.add(Integer.valueOf(Objects.requireNonNull(obj.getNumber(field)).toString()));
                        break;
                    case 11:
                        field = headers.get(z).concat("11");
                        hora11.add(Integer.valueOf(Objects.requireNonNull(obj.getNumber(field)).toString()));
                        break;
                    case 12:
                        field = headers.get(z).concat("12");
                        hora12.add(Integer.valueOf(Objects.requireNonNull(obj.getNumber(field)).toString()));
                        break;
                    case 13:
                        field = headers.get(z).concat("13");
                        hora13.add(Integer.valueOf(Objects.requireNonNull(obj.getNumber(field)).toString()));
                        break;
                    case 14:
                        field = headers.get(z).concat("14");
                        hora14.add(Integer.valueOf(Objects.requireNonNull(obj.getNumber(field)).toString()));
                        break;
                }
            }
        }
        return new DatosAvistamiento(
                obj.getString("HoraInicio"),
                obj.getString("HoraFin"),
                hora08,
                hora09,
                hora10,
                hora11,
                hora12,
                hora13,
                hora14
        );
    }

    /**
     * Init the UI elements into the code
     */
    private void startFindView() {
        sp_EnvioSeleccionado = findViewById(R.id.sp_EnvioSeleccionado);
        btn_ContinuarModificacionEnvio = findViewById(R.id.btn_ContinuarModificacionEnvio);
        btn_VolverModificacionEnvio = findViewById(R.id.btn_VolverModificacionEnvio);
    }

    /**
     * Sets all the click listener for the UI elements
     */
    private void startOnClickListeners() {
        btn_ContinuarModificacionEnvio.setOnClickListener(this);
        btn_VolverModificacionEnvio.setOnClickListener(this);
    }

    /**
     * Init the UI spinners and fills them with data
     */
    private void startSpinners() {
        ArrayList <String> envios = cargarEnvios();
        ArrayAdapter<String> adapterEnvios = new ArrayAdapter<>(this, R.layout.spinner, envios);
        sp_EnvioSeleccionado.setAdapter(adapterEnvios);
    }

    /**
     * Called when a view has been clicked.
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v == btn_ContinuarModificacionEnvio){
            if (sp_EnvioSeleccionado.getSelectedItemPosition()!=0){
                Intent activity = new Intent(Pantalla_Modificacion_Envio.this,Pantalla_Menu_Metodos_Y_Captura.class);
                envio = enviosRecibidos.get(sp_EnvioSeleccionado.getSelectedItemPosition()-1);
                activity.putExtra("ENVIO", envio);
                activity.putExtra("LIMITES", limites);
                finish();
                startActivity(activity);
            }else Toast.makeText(this, "Se tiene que seleccionar un envío", Toast.LENGTH_SHORT).show();
        }
        if (v == btn_VolverModificacionEnvio){
            Intent activity = new Intent(Pantalla_Modificacion_Envio.this,Pantalla_Menu_Intermedio.class);
            activity.putExtra("EMAIL",envio.getEmail());
            activity.putExtra("LIMITES", limites);
            startActivity(activity);
        }

    }
}
