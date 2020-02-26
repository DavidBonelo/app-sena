package com.example.ejercicio;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etmail;
    EditText etpass;
    Button btnsignin;
    Button btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etmail = findViewById(R.id.etmail);
        etpass = findViewById(R.id.etpass);

        btnsignin = findViewById(R.id.btnsignin);
        btnsignup = findViewById(R.id.btnsignup);


        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = etmail.getText().toString();
                String pass = etpass.getText().toString();

                if ((mail.isEmpty()) && pass.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Debe ingresar el correo electronico y la contraseña", Toast.LENGTH_SHORT).show();
                    etmail.requestFocus();
                } else if (mail.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Debe ingresar el correo electronico", Toast.LENGTH_SHORT).show();
                    etmail.requestFocus();
                } else if (pass.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Debe ingresar la contraseña", Toast.LENGTH_SHORT).show();
                    etpass.requestFocus();
                } else {
                    Toast.makeText(getApplicationContext(), "Bienvenidio " + mail + " Su contraseña es: " + pass, Toast.LENGTH_SHORT).show();
                }

            }
        });
        final Intent intenttoreg = new Intent(LoginActivity.this,RegistroActivity.class);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lanzo la actividad registro y espero respuesta
                startActivityForResult(intenttoreg,444);
            }
        });

    }

    // Metodo que se ejecuta cuando se regresa a esta actividad despues de que finaliza una actividad que se inicio con startActivityForResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 444) {
            // Si se completo el registro, finaliza login e inicia x pasando datos(un intent) del registro
            if (resultCode == RESULT_OK) {
                finish();
                startActivity(data);
            } else Toast.makeText(this, "Registro fallido", Toast.LENGTH_SHORT).show();

        }
    }
}
