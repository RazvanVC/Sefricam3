package com.sefricam.sefricam3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class Pantalla_Modificacion_Envio extends Activity implements View.OnClickListener{


    public String email, DNI;
    private Limites limites;
    private Spinner sp_EnvioSeleccionado;
    private Button btn_ContinuarModificacionEnvio, btn_VolverModificacionEnvio;


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
            DNI = datos.getString("DNI");
            email = datos.getString("EMAIL");
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

        /*
        * Carga de los datos desde la BD
        * Pasar por parametro el numero de grupo (recibir de la pantalla anterior)
        * Como formato de la lista de seleccionables, recuperar el envio en formato DNI-Fecha
        */

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
            activity.putExtra("EMAIL",email);
            activity.putExtra("DNI",DNI);
            activity.putExtra("DATOS_AVES", (Serializable) null);
            activity.putExtra("DATOS_ENTORNO", (Serializable) null);
            activity.putExtra("DATOS_CAPTURA", (Serializable) null);
            activity.putExtra("ENTORNO_COMPLETADO", false);
            activity.putExtra("MCAPTURAS_COMPLETADO", false);
            activity.putExtra("AVISTAMIENTO_COMPLETADO", false);
            activity.putExtra("ENVIO_COMPLETADO",false);
            activity.putExtra("LIMITES", limites);
            finish();
            startActivity(activity);

        }
        if (v == btn_VolverModificacionEnvio){
            Intent activity = new Intent(Pantalla_Modificacion_Envio.this,Pantalla_Menu_Intermedio.class);
            activity.putExtra("EMAIL",email);
            activity.putExtra("LIMITES", limites);
            startActivity(activity);
        }

    }
}
