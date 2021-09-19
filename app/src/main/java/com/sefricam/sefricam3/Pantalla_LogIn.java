package com.sefricam.sefricam3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Parse
import com.parse.ParseUser;

public class Pantalla_LogIn extends Activity {

    private EditText email,password;
    private Limites limites;

    /**
     * Crea la pantalla de inicio de sesion
     * @param savedInstanceState bundle de datos que se recibe de la pantalla anterior
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_login);

        email = findViewById(R.id.ete_EmailInicio);
        password = findViewById(R.id.etp_ContrasenaIncio);

        Button btn_Login = findViewById(R.id.btn_IniciarSesion);

        btn_Login.setOnClickListener(view -> {
            if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                Toast.makeText(Pantalla_LogIn.this, "Los campos no pueden estar vacios", Toast.LENGTH_SHORT).show();
            } else {
                loginUserParse(email.getText().toString(), password.getText().toString());
            }
        });
    }

    /**
     *
     * @param emailLogin email que se manda a la BD
     * @param password contraseña del usuario que está intentando registrarse
     */
    private void loginUserParse(final String emailLogin, String password){
        ParseUser.logInInBackground(emailLogin, password, (parseUser, e) -> {
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
        });
    }
}
