package com.sefricam.sefricam4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Parse
import com.parse.ParseUser;

public class Pantalla_LogIn extends Activity {

    // UI Parameters
    private EditText email,password;

    // Class Parameters
    private Limites limites;

    /**
     * Initialize the screen and all its components
     * @param savedInstanceState bundle of data that receives when it starts the screen
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_login);

        // Initialize UI elements
        email = findViewById(R.id.ete_EmailInicio);
        password = findViewById(R.id.etp_ContrasenaIncio);
        Button btn_Login = findViewById(R.id.btn_IniciarSesion);

        // Sets onClick method for the button
        btn_Login.setOnClickListener(view -> {
            if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                Toast.makeText(Pantalla_LogIn.this, "Los campos no pueden estar vacios", Toast.LENGTH_SHORT).show();
            } else {
                loginUserParse(email.getText().toString(), password.getText().toString());
            }
        });
    }

    /**
     * Login the aplication
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
