package com.sefricam.sefricam3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.parse.Parse;
import com.parse.ParseInstallation;

public class Pantalla_Bienvenida extends Activity {

    /**
     * Pantalla que inicia la aplicacion
     * @param savedInstanceState bundle de datos que recibe la pantalla
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                // if defined
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build()
        );

        ParseInstallation.getCurrentInstallation().saveInBackground();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_bienvenida);


        Button btn_Start = findViewById(R.id.btn_Comenzar);

        btn_Start.setOnClickListener(view -> startActivity(new Intent(Pantalla_Bienvenida.this, Pantalla_LogIn.class)));

    }
}
