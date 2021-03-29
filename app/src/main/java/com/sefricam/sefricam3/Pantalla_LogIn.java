package com.sefricam.sefricam3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//Parse
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.LogInCallback;

import java.util.List;

public class Pantalla_LogIn extends Activity {

    //public FirebaseAuth mAuth;

    private EditText email,password;
    private Limites limites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_login);

        email = findViewById(R.id.ete_EmailInicio);
        password = findViewById(R.id.etp_ContrasenaIncio);

        Button btn_Login = findViewById(R.id.btn_IniciarSesion);
        //TextView tv_RecuperarContrasena = findViewById(R.id.tv_RecuperarContrasena);

        /*tv_RecuperarContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Pantalla_LogIn.this, Pantalla_Recuperar_Pass.class)); }
        });*/

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temail, tpass;

                temail = email.getText().toString();
                tpass = password.getText().toString();

                if (temail.isEmpty() || tpass.isEmpty()){
                    Toast.makeText(Pantalla_LogIn.this, "Los campos se han de rellenar", Toast.LENGTH_SHORT).show();
                } else {
                    loginUserParse(temail, tpass);
                }
            }
        });
    }

    private void loginUserParse(final String emailLogin, String password){
        ParseUser.logInInBackground(emailLogin, password, new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if (parseUser != null) {

                    Intent activity =  new Intent(Pantalla_LogIn.this, Pantalla_Menu_Intermedio.class);
                    activity.putExtra("EMAIL", email.getText().toString());
                    activity.putExtra("LIMITES", limites);
                    startActivity(activity);
                    finish();
                } else {
                    ParseUser.logOut();
                    Toast.makeText(Pantalla_LogIn.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
