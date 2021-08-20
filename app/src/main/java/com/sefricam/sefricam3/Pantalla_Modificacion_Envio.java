package com.sefricam.sefricam3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pantalla_Modificacion_Envio extends Activity implements AdapterView.OnItemSelectedListener, View.OnClickListener{


    private Envio envio;
    private Limites limites;
    private Spinner sp_EnvioSeleccionado;
    private Button btn_ContinuarModificacionEnvio, btn_VolverModificacionEnvio;
    private ArrayList<Envio> enviosRecibidos = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_modificacion_envio);

        //Inicio de los Elementos del layout
        iniciarFindView();
        iniciarOnClickListener();
        iniciarSpinners();

        //Carga de datos recuperados de la BD
        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            envio = (Envio) datos.getSerializable("ENVIO");
            limites = (Limites) datos.getSerializable("LIMITES");
        }
    }

    private void iniciarSpinners() {
        ArrayList <String> envios = cargarEnvios();
        ArrayAdapter<String> adapterEnvios = new ArrayAdapter<String>(this, R.layout.spinner,envios);
        sp_EnvioSeleccionado.setAdapter(adapterEnvios);
    }

    private ArrayList<String> cargarEnvios() {
        ArrayList <String> enviosCargados = new ArrayList<>();
        enviosCargados.add("Seleccione un envio");

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Datos_Entorno");
        query.whereEqualTo("NumGrupo",limites.getNumeroGrupo());
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null){
                    ParseObject obj = null;
                    for (int i = 0; i<objects.size(); i++){
                        obj = objects.get(i);
                    }
                    try {
                        ArrayList<Integer> hora08 = new ArrayList<>(), hora09 = new ArrayList<>(), hora10 = new ArrayList<>(), hora11 = new ArrayList<>(), hora12 = new ArrayList<>(), hora13 = new ArrayList<>(), hora14 = new ArrayList<>();
                        for (int i = 8; i<15; i++) {
                            ArrayList<String> headers = new ArrayList<>();
                            headers.add("Cam"); headers.add("Jil"); headers.add("Lug"); headers.add("PardC"); headers.add("Pic");headers.add("PinC");headers.add("PinR");headers.add("Piq");headers.add("Verd");headers.add("VerdC");headers.add("VerdS");
                            for (int z = 0; z<headers.size(); z++){
                                String field = "";
                                switch (i){
                                    case 8:
                                        field = headers.get(z).concat("08");
                                        hora08.add(Integer.valueOf(obj.getNumber(field).toString()));
                                        break;
                                    case 9:
                                        field = headers.get(z).concat("09");
                                        hora09.add(Integer.valueOf(obj.getNumber(field).toString()));
                                        break;
                                    case 10:
                                        field = headers.get(z).concat("10");
                                        hora10.add(Integer.valueOf(obj.getNumber(field).toString()));
                                        break;
                                    case 11:
                                        field = headers.get(z).concat("11");
                                        hora11.add(Integer.valueOf(obj.getNumber(field).toString()));
                                        break;
                                    case 12:
                                        field = headers.get(z).concat("12");
                                        hora12.add(Integer.valueOf(obj.getNumber(field).toString()));
                                        break;
                                    case 13:
                                        field = headers.get(z).concat("13");
                                        hora13.add(Integer.valueOf(obj.getNumber(field).toString()));
                                        break;
                                    case 14:
                                        field = headers.get(z).concat("14");
                                        hora14.add(Integer.valueOf(obj.getNumber(field).toString()));
                                        break;
                                }
                            }
                        }

                        DatosAvistamiento da = new DatosAvistamiento(
                                obj.getString("HoraIncio"),
                                obj.getString("HoraFin"),
                                hora08,
                                hora09,
                                hora10,
                                hora11,
                                hora12,
                                hora13,
                                hora14
                        );
                        ArrayList<Integer> plantas = new ArrayList<>();

                        for (int i = 1; i<37; i++){
                            String field = "EP"+i;
                            plantas.add(Integer.valueOf(obj.getNumber(field).toString()));
                        }

                        DatosEntorno de = new DatosEntorno(
                                Double.parseDouble(obj.getNumber("TempInicio").toString()),
                                Double.parseDouble(obj.getNumber("TempFinal").toString()),
                                Integer.valueOf(obj.getNumber("Zonificacion").toString()),
                                Integer.valueOf(obj.getNumber("Viento").toString()),
                                obj.getString("DirViento"),
                                Integer.valueOf(obj.getNumber("Nubes").toString()),
                                Integer.valueOf(obj.getNumber("Lluvia").toString()),
                                plantas,
                                obj.getString("EP37"),
                                obj.getString("EP38")
                        );

                        /*MetodosCaptura dmc = new MetodosCaptura(

                        );*/

                        envio.setDatosAvistamiento(da);
                        envio.setAvistamientoCompletado(true);
                        envio.setDatosEntorno(de);
                        envio.setEntornoCompletado(true);
                        

                    } catch (Exception x){
                        Toast.makeText(Pantalla_Modificacion_Envio.this, "ERROR: " + e.getCode(), Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

        return enviosCargados;
    }


    private void iniciarFindView() {
        sp_EnvioSeleccionado = findViewById(R.id.sp_EnvioSeleccionado);
        btn_ContinuarModificacionEnvio = findViewById(R.id.btn_ContinuarModificacionEnvio);
        btn_VolverModificacionEnvio = findViewById(R.id.btn_VolverModificacionEnvio);
    }

    private void iniciarOnClickListener() {
        btn_ContinuarModificacionEnvio.setOnClickListener(this);
        btn_VolverModificacionEnvio.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v == btn_ContinuarModificacionEnvio){
            Intent activity = new Intent(Pantalla_Modificacion_Envio.this,Pantalla_Menu_Metodos_Y_Captura.class);

            activity.putExtra("ENVIO", envio);

            activity.putExtra("LIMITES", limites);
            finish();
            startActivity(activity);

        }
        if (v == btn_VolverModificacionEnvio){
            Intent activity = new Intent(Pantalla_Modificacion_Envio.this,Pantalla_Menu_Intermedio.class);
            activity.putExtra("EMAIL",envio.getEmail());
            activity.putExtra("LIMITES", limites);
            startActivity(activity);
        }

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
        if (parent.getId() == R.id.sp_EnvioSeleccionado){

        }
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
}
