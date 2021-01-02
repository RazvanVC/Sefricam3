package com.sefricam.sefricam3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.Parse;
import com.parse.ParseInstallation;

public class Pantalla_Bienvenida extends Activity {

    private Button btn_Start;
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


        btn_Start = (Button) findViewById(R.id.btn_Comenzar);

        btn_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Pantalla_Bienvenida.this, Pantalla_LogIn.class));
            }
        });

    }
}
