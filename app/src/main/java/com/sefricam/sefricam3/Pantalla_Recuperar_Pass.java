package com.sefricam.sefricam3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class Pantalla_Recuperar_Pass extends Activity {

    private Button recuperarPass;
    private EditText email;
    private String textoemail;
    private FirebaseAuth mAuth;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_recuperar_contrasena);

        recuperarPass = findViewById(R.id.btn_RecuperarContrasena);
        email = findViewById(R.id.ete_EmailRecuperacion);
        mAuth = FirebaseAuth.getInstance();

        recuperarPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoemail = email.getText().toString();

                if (textoemail.isEmpty()){
                    Toast.makeText(Pantalla_Recuperar_Pass.this, "Tienes que introducir un email", Toast.LENGTH_SHORT).show();
                }else {
                    recuperarContraseña();
                    finish();
                }
            }
        });

    }

    private void recuperarContraseña(){
        mAuth.setLanguageCode("es");
        mAuth.sendPasswordResetEmail(textoemail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(Pantalla_Recuperar_Pass.this, "Se ha enviado un correo de recuperación", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Pantalla_Recuperar_Pass.this, "No se ha podido enviar un correo de verificación", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
