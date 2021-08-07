package com.sefricam.sefricam3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.Serializable;
import java.util.List;


public class Pantalla_Menu_Intermedio extends Activity implements View.OnClickListener{

    private Button btn_Salir, btn_MenuCapturasEntorno, btn_Envios, btn_Modificacion_Envio, btn_Mi_Cuadricula;
    public String email;
    private TextView tv_NGrupo, tv_DNI, tv_Bienvenida;
    private Limites limites;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_menu_intermedio);

        //Inicio de los Elementos del layout
        iniciarFindView();
        iniciarOnClickListener();

        //Carga de datos recuperados de la BD
        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            email = datos.getString("EMAIL");
            limites = (Limites) datos.getSerializable("LIMITES");
            /*limites.imprimirDatosRecYCim();
            limites.imprimirDatosParametrosAves();
            limites.imprimirDatosAnillamiento();*/
            cargarDatos(email);
        }
    }

    private void cargarDatos(String email) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("_User");
        query.whereEqualTo("username",email);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null){
                    ParseObject obj = null;
                    for (int i = 0; i<objects.size(); i++){
                        obj = objects.get(i);
                    }
                    try {
                        tv_Bienvenida.append(obj.getString("Nombre")+"!");
                        tv_DNI.setText(obj.getString("DNI"));
                        tv_NGrupo.setText(obj.getNumber("NumGrupo").toString());
                        limites = new Limites(obj.getInt("NumGrupo"));
                    } catch (Exception x){
                        Toast.makeText(Pantalla_Menu_Intermedio.this, "ERROR: " + e.getCode(), Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }

    /**
     * Asigna a las variables creadas arriba su correspondiente boton de la actividad
     */
    private void iniciarFindView() {
        tv_DNI = (TextView) findViewById(R.id.tv_DNI);
        tv_NGrupo = (TextView) findViewById(R.id.tv_NGrupo);
        tv_Bienvenida = (TextView) findViewById(R.id.tv_Bienvenida);
        btn_Salir = (Button) findViewById(R.id.btn_Salir);
        btn_MenuCapturasEntorno = (Button) findViewById(R.id.btn_Menu_Capturas_Entorno);
        btn_Modificacion_Envio = findViewById(R.id.btn_Modificacion_Envio);
        btn_Envios = (Button) findViewById(R.id.btn_Consular_Envios);
        btn_Mi_Cuadricula = findViewById(R.id.btn_Mi_Cuadricula);
    }

    /**
     * Inicia todos los click listeners para que los botones sean funcionales
     */
    public void iniciarOnClickListener(){
        btn_Salir.setOnClickListener(this);
        btn_Envios.setOnClickListener(this);
        btn_Modificacion_Envio.setOnClickListener(this);
        btn_Mi_Cuadricula.setOnClickListener(this);
        btn_MenuCapturasEntorno.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){

        if (view == btn_Salir){
            startActivity(new Intent(Pantalla_Menu_Intermedio.this, Pantalla_Bienvenida.class));
            finish();
        }
        if (view == btn_MenuCapturasEntorno){
            Intent activity = new Intent(Pantalla_Menu_Intermedio.this,Pantalla_Menu_Metodos_Y_Captura.class);

            activity.putExtra("ENVIO", new Envio(tv_DNI.getText().toString(), email));
            // Delete after full implementation from here
            activity.putExtra("EMAIL",email);
            activity.putExtra("DNI",tv_DNI.getText().toString());
            activity.putExtra("DATOS_AVES", (Serializable) null);
            activity.putExtra("DATOS_ENTORNO", (Serializable) null);
            activity.putExtra("DATOS_CAPTURA", (Serializable) null);
            activity.putExtra("ENTORNO_COMPLETADO", false);
            activity.putExtra("MCAPTURAS_COMPLETADO", false);
            activity.putExtra("AVISTAMIENTO_COMPLETADO", false);
            activity.putExtra("ENVIO_COMPLETADO",false);
            // Until here
            activity.putExtra("LIMITES", limites);
            finish();
            startActivity(activity);
        }
        if (view == btn_Modificacion_Envio) {
            Intent activity = new Intent(Pantalla_Menu_Intermedio.this,Pantalla_Modificacion_Envio.class);
            activity.putExtra("EMAIL",email);
            activity.putExtra("DNI",tv_DNI.getText().toString());
            activity.putExtra("LIMITES", limites);
            finish();
            startActivity(activity);
        }
        if (view == btn_Mi_Cuadricula) {
            Intent activity = new Intent(Pantalla_Menu_Intermedio.this,Pantalla_Mi_Cuadricula.class);
            activity.putExtra("EMAIL",email);
            activity.putExtra("LIMITES", limites);
            finish();
            startActivity(activity);
        }
        if (view == btn_Envios){
            Intent activity = new Intent(Pantalla_Menu_Intermedio.this,Pantalla_Mis_Datos.class);
            activity.putExtra("EMAIL",email);
            activity.putExtra("LIMITES", limites);
            finish();
            startActivity(activity);
        }
    }
}
