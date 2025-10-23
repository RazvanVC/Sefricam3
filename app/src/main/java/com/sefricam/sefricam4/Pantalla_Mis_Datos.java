package com.sefricam.sefricam4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Objects;

import com.parse.ParseObject;
import com.parse.ParseQuery;

public class Pantalla_Mis_Datos extends Activity {

    // UI Parameters
    private TextView tv_NombreDatos, tv_ApellidosDatos, tv_DNIDatos, tv_NumeroGrupoDatos, tv_CapturasDatos, tv_DatosEnviadosDatos;
    private Button btn_VolverDatos;

    //Class Parameters
    private String email;
    private Limites limites;

    /**
     * Initialize the screen and all its components
     * @param savedInstanceState bundle of data that receives when it starts the screen
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_mis_datos);

        startFindView();

        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            email = datos.getString("EMAIL");
            limites = (Limites) datos.getSerializable("LIMITES");
            loadUserData(email);
        }

        //Sets the click listener and onClick method fo the button
        btn_VolverDatos.setOnClickListener(v -> onBackPressed());
    }

    /**
     * Called when the activity has detected the user's press of the back
     * key.  The default implementation simply finishes the current activity,
     * but you can override this to do whatever you want.
     */
    @Override
    public void onBackPressed() {
        Intent activity = new Intent(Pantalla_Mis_Datos.this,Pantalla_Menu_Intermedio.class);
        activity.putExtra("EMAIL",email);
        activity.putExtra("LIMITES", limites);
        startActivity(activity);
    }

    /**
     * Init the UI elements into the code
     */
    private void startFindView() {
        btn_VolverDatos = findViewById(R.id.btn_VolverDatos);
        tv_NombreDatos = findViewById(R.id.tv_NombreDatos);
        tv_ApellidosDatos = findViewById(R.id.tv_ApellidosDatos);
        tv_DNIDatos = findViewById(R.id.tv_DNIDatos);
        tv_NumeroGrupoDatos = findViewById(R.id.tv_NumeroGrupoDatos);
        tv_CapturasDatos = findViewById(R.id.tv_CapturasEnviadasDatos);
        tv_DatosEnviadosDatos = findViewById(R.id.tv_DatosEnviadosDatos);
    }

    /**
     * Charge the used data in the UI
     * @param email query parameter to find the user
     */
    private void loadUserData(String email) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("_User");
        query.whereEqualTo("username",email);
        query.findInBackground((objects, e) -> {
            if (e == null){
                ParseObject obj = null;
                for (int i = 0; i<objects.size(); i++){
                    obj = objects.get(i);
                }
                try {
                    tv_NombreDatos.append(Objects.requireNonNull(obj).getString("Nombre"));
                    tv_ApellidosDatos.setText(obj.getString("Apellidos"));
                    tv_DNIDatos.setText(obj.getString("DNI"));
                    tv_NumeroGrupoDatos.setText(Objects.requireNonNull(obj.getNumber("NumGrupo")).toString());
                    tv_CapturasDatos.setText(Objects.requireNonNull(obj.getNumber("NumAves")).toString());
                    tv_DatosEnviadosDatos.setText(Objects.requireNonNull(obj.getNumber("NumFichas")).toString());
                } catch (Exception x){
                    Toast.makeText(Pantalla_Mis_Datos.this, "ERROR: " + Objects.requireNonNull(x).getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
