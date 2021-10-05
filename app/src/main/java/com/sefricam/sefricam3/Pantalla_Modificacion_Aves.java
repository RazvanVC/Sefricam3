package com.sefricam.sefricam3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.content.res.AppCompatResources;

import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Objects;

public class Pantalla_Modificacion_Aves extends Activity implements AdapterView.OnItemSelectedListener, View.OnClickListener{


    private Envio envio;
    private Limites limites;
    private DatosAves ave;
    private String selected;
    private Spinner sp_EnvioAvesSeleccionado;
    private Button btn_ContinuarModificacionAves, btn_VolverModificacionAves, btn_NuevoEnvioModificacionAves, btn_ModificacionEnvioModificacionAves;
    private final ArrayList<DatosAves> enviosRecibidos = new ArrayList<>();
    private TextView tv_MA_TextoSeleccion;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_modificacion_aves);
        selected = "";

        //Carga de datos recuperados de la BD
        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            envio = (Envio) datos.getSerializable("ENVIO");
            limites = (Limites) datos.getSerializable("LIMITES");
            ave = (DatosAves) datos.getSerializable("AVE");
        }

        //Inicio de los Elementos del layout
        iniciarFindView();
        iniciarOnClickListener();
        iniciarSpinners();


    }

    private void iniciarSpinners() {
        ArrayList <String> envios = cargarEnvios();
        ArrayAdapter<String> adapterEnvios = new ArrayAdapter<>(this, R.layout.spinner, envios);
        sp_EnvioAvesSeleccionado.setAdapter(adapterEnvios);
    }

    private ArrayList<String> cargarEnvios() {
        ArrayList <String> enviosCargados = new ArrayList<>();
        enviosCargados.add("Seleccione un envio");

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Datos_Aves");

        query.whereEqualTo("NumGrupo",limites.getNumeroGrupo());
        query.findInBackground((objects, e) -> {
            if (e == null){
                ParseObject obj;
                ArrayList<Integer> avesAnilladas = new ArrayList<>();
                for (int i = 0; i<objects.size(); i++){
                    DatosAves localAve;
                    obj = objects.get(i);

                    localAve = getAve(obj);
                    avesAnilladas.add(localAve.getnAnilla());
                    if (localAve.getLatitud() == envio.getLatitud() && localAve.getLongitud() == envio.getLongitud()){
                        enviosRecibidos.add(localAve);
                    }

                }
                for (int i = 0; i<enviosRecibidos.size(); i++){
                    DatosAves localAve = enviosRecibidos.get(i);

                    if (localAve.getnAnilla()==0){
                        enviosCargados.add(localAve.getAnillaPreexistente());
                    } else  {
                        enviosCargados.add(String.valueOf(localAve.getnAnilla()));
                    }

                }
                limites.setAvesAnilladas(avesAnilladas);
                if (enviosCargados.size()==1){
                    enviosCargados.add(0,"No hay datos");
                }
            } else {
                enviosCargados.add("FIN ENVIOS CARGADOS");
            }


        });

        return enviosCargados;
    }

    private DatosAves getAve(ParseObject obj) {

        DatosAves localAve = new DatosAves(Integer.parseInt(Objects.requireNonNull(obj.getNumber("NumGrupo")).toString()),
                Objects.requireNonNull(obj.getDate("FechaCap")),
                Double.parseDouble(Objects.requireNonNull(obj.getNumber("Latitud")).toString()),
                Double.parseDouble(Objects.requireNonNull(obj.getNumber("Longitud")).toString()));

        localAve.setHoraCaptura(obj.getString("HoraCap"));
        localAve.setEspecie(Integer.parseInt(Objects.requireNonNull(obj.getNumber("Especie")).toString()));
        localAve.setnEjemplares(Integer.parseInt(Objects.requireNonNull(obj.getNumber("NEjemplares")).toString()));

        localAve.setnAnilla(Integer.parseInt(Objects.requireNonNull(obj.getNumber("NumAnilla")).toString()));
        localAve.setAnillaPreexistente(obj.getString("AnillaPre"));
        localAve.setPeso(Double.parseDouble(Objects.requireNonNull(obj.getNumber("Peso")).toString()));
        localAve.setLongitudTarso(Double.parseDouble(Objects.requireNonNull(obj.getNumber("LongTarso")).toString()));
        localAve.setLongitudPico(Double.parseDouble(Objects.requireNonNull(obj.getNumber("LongPico")).toString()));
        localAve.setLongitudTerceraPrimaria(Double.parseDouble(Objects.requireNonNull(obj.getNumber("LongTerPrim")).toString()));
        localAve.setLocalizacion(Integer.parseInt(Objects.requireNonNull(obj.getNumber("Localizacion")).toString()));
        localAve.setSexo(Integer.parseInt(Objects.requireNonNull(obj.getNumber("Sexo")).toString()));
        localAve.setEdad(Integer.parseInt(Objects.requireNonNull(obj.getNumber("Edad")).toString()));
        localAve.setCondicionFisica(Integer.parseInt(Objects.requireNonNull(obj.getNumber("CondFisica")).toString()));
        localAve.setGrasa(Integer.parseInt(Objects.requireNonNull(obj.getNumber("Grasa")).toString()));
        localAve.setMusculoPectoral(Integer.parseInt(Objects.requireNonNull(obj.getNumber("MuscPectoral")).toString()));
        localAve.setMuda(Integer.parseInt(Objects.requireNonNull(obj.getNumber("Muda")).toString()));
        localAve.setPlacaIncubatriz(Integer.parseInt(Objects.requireNonNull(obj.getNumber("PlacIncubatriz")).toString()));
        localAve.setObjectID(obj.getObjectId());

        return localAve;
    }

    private void iniciarFindView() {
        sp_EnvioAvesSeleccionado = findViewById(R.id.sp_MA_EnvioAvesSeleccionado);
        btn_ContinuarModificacionAves = findViewById(R.id.btn_MA_ContinuarModificacionAves);
        btn_VolverModificacionAves = findViewById(R.id.btn_MA_VolverModificacionAves);
        btn_ModificacionEnvioModificacionAves = findViewById(R.id.btn_MA_ModificacionEnvioModificacionAves);
        btn_NuevoEnvioModificacionAves = findViewById(R.id.btn_MA_NuevoEnvioModificacionAves);
        tv_MA_TextoSeleccion = findViewById(R.id.tv_MA_TextoSeleccion);
    }

    private void iniciarOnClickListener() {
        btn_ContinuarModificacionAves.setOnClickListener(this);
        btn_VolverModificacionAves.setOnClickListener(this);
        btn_ModificacionEnvioModificacionAves.setOnClickListener(this);
        btn_NuevoEnvioModificacionAves.setOnClickListener(this);

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        if (v == btn_NuevoEnvioModificacionAves){
            sp_EnvioAvesSeleccionado.setVisibility(View.INVISIBLE);
            tv_MA_TextoSeleccion.setVisibility(View.INVISIBLE);
            btn_NuevoEnvioModificacionAves.setBackground(AppCompatResources.getDrawable(this, R.drawable.boton_semiredondeado_apagado));
            btn_ModificacionEnvioModificacionAves.setBackground(AppCompatResources.getDrawable(this, R.drawable.boton_semiredondeado));
            selected = "Nuevo";
        }
        if (v == btn_ModificacionEnvioModificacionAves){
            sp_EnvioAvesSeleccionado.setVisibility(View.VISIBLE);
            tv_MA_TextoSeleccion.setVisibility(View.VISIBLE);
            btn_ModificacionEnvioModificacionAves.setBackground(AppCompatResources.getDrawable(this, R.drawable.boton_semiredondeado_apagado));
            btn_NuevoEnvioModificacionAves.setBackground(AppCompatResources.getDrawable(this, R.drawable.boton_semiredondeado));
            selected = "Modificacion";
        }
        if (v == btn_ContinuarModificacionAves){
            if (selected.equals("Nuevo")){
                Intent activity = new Intent(Pantalla_Modificacion_Aves.this,Pantalla_Datos_Aves.class);
                activity.putExtra("ENVIO", envio);
                activity.putExtra("LIMITES", limites);
                activity.putExtra("AVE", ave);
                finish();
                startActivity(activity);
            }
            else if (selected.equals("Modificacion")){
                if (sp_EnvioAvesSeleccionado.getSelectedItemPosition()!=0){
                    Intent activity = new Intent(Pantalla_Modificacion_Aves.this,Pantalla_Datos_Aves.class);
                    ave = enviosRecibidos.get(sp_EnvioAvesSeleccionado.getSelectedItemPosition()-1);
                    ave.setModificacion(true);
                    activity.putExtra("AVE", ave);
                    activity.putExtra("ENVIO", envio);
                    activity.putExtra("LIMITES", limites);
                    finish();
                    startActivity(activity);
                }
                else Toast.makeText(this, "Se tiene que seleccionar un envío", Toast.LENGTH_SHORT).show();
            } else Toast.makeText(this, "No has seleccionado ninguna opción", Toast.LENGTH_SHORT).show();

        }
        if (v == btn_VolverModificacionAves){
            Intent activity = new Intent(Pantalla_Modificacion_Aves.this,Pantalla_Menu_Metodos_Y_Captura.class);
            activity.putExtra("ENVIO", envio);
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
