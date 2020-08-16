package com.oscarcruz.petagramfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class Contacto extends AppCompatActivity {


    Toolbar miActionBar;


    EditText email;
    EditText subject;
    EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        miActionBar = (Toolbar) findViewById(R.id.miToolbar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        email = findViewById(R.id.tilEmail);
        subject = findViewById(R.id.tilAsunto);
        message = findViewById(R.id.tilMensaje);

        Button btnenviar = findViewById(R.id.boton_enviar);
        btnenviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                validarDatos();
            }

            private boolean esNombreValido(String nombre) {
                Pattern patron = Pattern.compile("^[a-zA-Z á-úÁ-Ú]+$");
                if (!patron.matcher(nombre).matches() || nombre.length() > 30) {
                    subject.setError("Nombre inválido");
                    return false;
                } else {
                    subject.setError(null);
                }

                return true;
            }

             private boolean esCorreoValido(String correo) {
                if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                    email.setError("Correo electrónico inválido");
                    return false;
                } else {
                    email.setError(null);
                }

                return true;
            }

            private boolean esMensajeValido(String mensajes) {
                if (message.getText().toString().isEmpty()) {
                    message.setError("Escriba un mensaje");
                    return false;
                } else {
                    message.setError(null);
                }

                return true;
            }

            private void sendEmail() {
                String mEmail = email.getText().toString();
                String mSubject = subject.getText().toString();
                String mMessage = message.getText().toString();


                JavaMailAPI javaMailAPI = new JavaMailAPI(this, mEmail, mSubject, mMessage);

                javaMailAPI.execute();
            }
            private void validarDatos() {
                String nombre = subject.getText().toString();
                String correo = email.getText().toString();
                String mensajes = message.getText().toString();

                boolean a = esNombreValido(nombre);
                boolean b = esCorreoValido(correo);
                boolean c = esMensajeValido(mensajes);


                if (a && b && c) {
                    sendEmail();

                }
            }

        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.mAcercaDe:
                Intent intent1 = new Intent(this, AcercaDe.class);
                startActivity(intent1);
                break;

            case R.id.mContacto:
                Intent intent2 = new Intent(this, Contacto.class);
                startActivity(intent2);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_p,menu);
        return true;
    }
}