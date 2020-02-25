package com.example.ejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Session2Command;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity {

    EditText etname;
    EditText etlname;
    EditText etmail;
    EditText etphone;
    EditText etpass;
    Button btnsend;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etname = findViewById(R.id.etname);
        etlname = findViewById(R.id.etlname);
        etmail = findViewById(R.id.etmail);
        etphone = findViewById(R.id.etphone);
        etpass = findViewById(R.id.etpass);
        btnsend = findViewById(R.id.btnsend);
        btnlogin = findViewById(R.id.btnlogin);

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etname.getText().toString(),
                        lname = etlname.getText().toString(),
                        mail = etmail.getText().toString(),
                        phone = etphone.getText().toString(),
                        pass = etpass.getText().toString();

                String msg_errors = "";

                Intent intenttodata = new Intent(RegistroActivity.this, DataActivity.class);

                if (name.isEmpty()) msg_errors += "Debe ingresar el nombre\n";
                if (lname.isEmpty()) msg_errors = msg_errors + "Debe ingresar el apellido\n";
                if (mail.isEmpty()) msg_errors += "Debe ingresar el correo electronico\n";
                if (phone.isEmpty()) msg_errors += "Debe ingresar el telefono\n";
                if (pass.isEmpty()) msg_errors += "Debe ingresar la contraseña\n";

                //Verifica si los campos no estan vacios y agrega el putextra
                boolean bool = !name.isEmpty() &&
                                !lname.isEmpty() &&
                                !mail.isEmpty() &&
                                !phone.isEmpty() &&
                                !pass.isEmpty();
                if (bool) {
                    intenttodata.putExtra("name", name);
                    intenttodata.putExtra("lname", lname);
                    intenttodata.putExtra("mail", mail);
                    intenttodata.putExtra("phone", phone);
                    intenttodata.putExtra("pass", pass);
                    //como esta actividad se inicio con un startActivityForResult, cuando termina esta actividad, tengo que enviar un resultado (obligatorio??)
                    // Envio resultado ok que definí que cerrrará la LoginActivity
                    setResult(RESULT_OK,intenttodata);
                    finish();

                } else {
                    //mensaje de error emergente
                    AlertDialog.Builder message = new AlertDialog.Builder(RegistroActivity.this);
                    message.setTitle("No se pudo registrar");
                    message.setMessage(msg_errors);
                    message.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //cierra el AlertDialog
                            dialog.cancel();
                        }
                    });
                    AlertDialog dialog = message.create();
                    dialog.show();
                }
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}