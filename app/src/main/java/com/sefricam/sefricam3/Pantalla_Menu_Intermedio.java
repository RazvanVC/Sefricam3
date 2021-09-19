package com.sefricam.sefricam3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Objects;


public class Pantalla_Menu_Intermedio extends Activity implements View.OnClickListener{

    // UI Elements
    private Button btn_Salir, btn_MenuCapturasEntorno, btn_Envios, btn_Modificacion_Envio, btn_Mi_Cuadricula;
    private TextView tv_NGrupo, tv_DNI, tv_Bienvenida;

    // Class Elements
    private Limites limites;
    private String email;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_menu_intermedio);

        //Starting the elements from the UI
        startFindView();
        setOnClickListener();

        //Charging the data from the DB into the application
        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            email = datos.getString("EMAIL");
            limites = (Limites) datos.getSerializable("LIMITES");
            cargarDatos(email);
        }
    }

    /**
     * Get the user data from the DB
     * @param email search element for the query
     */
    private void cargarDatos(String email) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("_User");
        query.whereEqualTo("username",email);
        query.findInBackground((objects, e) -> {
            if (e == null){
                ParseObject obj = objects.get(objects.size()-1);
                try {
                    tv_Bienvenida.append(obj.getString("Nombre")+"!");
                    tv_DNI.setText(obj.getString("DNI"));
                    tv_NGrupo.setText(Objects.requireNonNull(obj.getNumber("NumGrupo")).toString());
                    limites = new Limites(obj.getInt("NumGrupo"));
                } catch (Exception x){
                    assert false;
                    Toast.makeText(Pantalla_Menu_Intermedio.this, "ERROR: " + e.getCode(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    /**
     * Init the UI elements into the code
     */
    private void startFindView() {
        tv_DNI = findViewById(R.id.tv_DNI);
        tv_NGrupo = findViewById(R.id.tv_NGrupo);
        tv_Bienvenida = findViewById(R.id.tv_Bienvenida);
        btn_Salir = findViewById(R.id.btn_Salir);
        btn_MenuCapturasEntorno = findViewById(R.id.btn_Menu_Capturas_Entorno);
        btn_Modificacion_Envio = findViewById(R.id.btn_Modificacion_Envio);
        btn_Envios = findViewById(R.id.btn_Consular_Envios);
        btn_Mi_Cuadricula = findViewById(R.id.btn_Mi_Cuadricula);
    }

    /**
     * Sets all the click listener for the UI elements
     */
    public void setOnClickListener(){
        btn_Salir.setOnClickListener(this);
        btn_Envios.setOnClickListener(this);
        btn_Modificacion_Envio.setOnClickListener(this);
        btn_Mi_Cuadricula.setOnClickListener(this);
        btn_MenuCapturasEntorno.setOnClickListener(this);
    }

    /**
     * Called when the activity has detected the user's press of the back
     * key.  The default implementation simply finishes the current activity,
     * but you can override this to do whatever you want.
     * Overrides it for a message that ask if you want to leave the application
     */
    @Override
    public void onBackPressed() {
        AlertDialog.Builder exit = new AlertDialog.Builder(this);
        exit.setMessage("¿Quieres salir de la aplicación?");
        exit.setPositiveButton("SI", (dialog, which) -> {
            startActivity(new Intent(Pantalla_Menu_Intermedio.this, Pantalla_Bienvenida.class));
            finish();
        });
        exit.setNegativeButton("NO", (dialog, which) -> dialog.cancel());

        AlertDialog dialog = exit.create();
        dialog.show();
    }

    /**
     * Handle the onClick event for the UI elements
     * @param view the view that was clicked
     */
    @Override
    public void onClick(View view){
        if (view == btn_Salir){
            onBackPressed();
        }
        if (view == btn_MenuCapturasEntorno){
            Intent activity = new Intent(Pantalla_Menu_Intermedio.this,Pantalla_Menu_Metodos_Y_Captura.class);
            chargeActivity(activity, view);
        }
        if (view == btn_Modificacion_Envio) {
            Intent activity = new Intent(Pantalla_Menu_Intermedio.this,Pantalla_Modificacion_Envio.class);
            chargeActivity(activity, view);
        }
        if (view == btn_Mi_Cuadricula) {
            Intent activity = new Intent(Pantalla_Menu_Intermedio.this,Pantalla_Mi_Cuadricula.class);
            chargeActivity(activity, view);
        }
        if (view == btn_Envios){
            Intent activity = new Intent(Pantalla_Menu_Intermedio.this,Pantalla_Mis_Datos.class);
            chargeActivity(activity, view);
        }
    }

    /**
     * Handle the new activity that starts, putting all the necessary parameters in the bundle
     * @param activity the activity that will start
     * @param view the view that was clicked
     */
    private void chargeActivity(Intent activity, View view) {
        if (view == btn_MenuCapturasEntorno || view == btn_Modificacion_Envio) activity.putExtra("ENVIO", new Envio(tv_DNI.getText().toString(), email));
        else activity.putExtra("EMAIL",email);
        activity.putExtra("LIMITES", limites);
        finish();
        startActivity(activity);
    }
}
