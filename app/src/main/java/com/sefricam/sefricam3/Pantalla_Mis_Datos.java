package com.sefricam.sefricam3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class Pantalla_Mis_Datos extends Activity {

    private String email;
    private TextView tv_NombreDatos, tv_ApellidosDatos, tv_DNIDatos, tv_NumeroGrupoDatos, tv_CapturasDatos, tv_DatosEnviadosDatos;
    private Button btn_VolverDatos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_mis_datos);

        iniciarFindView();
        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            email = datos.getString("EMAIL");
            cargarDatos(email);
        }


        btn_VolverDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity = new Intent(Pantalla_Mis_Datos.this,Pantalla_Menu_Intermedio.class);
                activity.putExtra("EMAIL",email);
                startActivity(activity);
            }
        });
    }

    private void iniciarFindView() {
        btn_VolverDatos = findViewById(R.id.btn_VolverDatos);
        tv_NombreDatos = findViewById(R.id.tv_NombreDatos);
        tv_ApellidosDatos = findViewById(R.id.tv_ApellidosDatos);
        tv_DNIDatos = findViewById(R.id.tv_DNIDatos);
        tv_NumeroGrupoDatos = findViewById(R.id.tv_NumeroGrupoDatos);
        tv_CapturasDatos = findViewById(R.id.tv_CapturasEnviadasDatos);
        tv_DatosEnviadosDatos = findViewById(R.id.tv_DatosEnviadosDatos);
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
                        tv_NombreDatos.append(obj.getString("Nombre"));
                        tv_ApellidosDatos.setText(obj.getString("Apellidos"));
                        tv_DNIDatos.setText(obj.getString("DNI"));
                        tv_NumeroGrupoDatos.setText(obj.getNumber("NumGrupo").toString());
                        tv_CapturasDatos.setText(obj.getNumber("NumAves").toString());
                        tv_DatosEnviadosDatos.setText(obj.getNumber("NumFichas").toString());
                    } catch (Exception x){
                        Toast.makeText(Pantalla_Mis_Datos.this, "ERROR: " + e.getCode(), Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }
}
