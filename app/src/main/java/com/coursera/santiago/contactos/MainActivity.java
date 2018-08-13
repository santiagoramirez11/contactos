package com.coursera.santiago.contactos;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextInputEditText tietNombreCompleto;
    TextInputEditText tietTelefono;
    TextInputEditText tietEmail;
    TextInputEditText tietDescripcionContacto;
    DatePicker dpFechaNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tietNombreCompleto = findViewById(R.id.tietNombreCompleto);
        tietTelefono = findViewById(R.id.tietTelefono);
        tietEmail = findViewById(R.id.tietEMail);
        tietDescripcionContacto = findViewById(R.id.tietDescripcion);
        dpFechaNacimiento = findViewById(R.id.dpFechaNacimiento);


        Bundle parametros = getIntent().getExtras();
        if(parametros != null){
            tietNombreCompleto.setText(parametros.getString(getResources().getString(R.string.pNombreCompleto)));
            Calendar cFechaNacimiento = (Calendar)parametros.get(getResources().getString(R.string.pFechaNacimiento));
            dpFechaNacimiento.updateDate(cFechaNacimiento.get(Calendar.YEAR), cFechaNacimiento.get(Calendar.MONTH),
                    cFechaNacimiento.get(Calendar.DAY_OF_MONTH));
            tietTelefono.setText(parametros.getString(getResources().getString(R.string.pTelefono)));
            tietEmail.setText(parametros.getString(getResources().getString(R.string.pEmail)));
            tietDescripcionContacto.setText(parametros.getString(getResources().getString(R.string.pDescripcionContacto)));
        }
    }

    public void siguienteActividad(View v){
        Intent siguienteVentana = new Intent(this, ResumenContacto.class);
        siguienteVentana.putExtra(getResources().getString(R.string.pNombreCompleto), tietNombreCompleto.getText().toString());
        siguienteVentana.putExtra(getResources().getString(R.string.pEmail), tietEmail.getText().toString());
        siguienteVentana.putExtra(getResources().getString(R.string.pTelefono), tietTelefono.getText().toString());
        siguienteVentana.putExtra(getResources().getString(R.string.pDescripcionContacto), tietDescripcionContacto.getText().toString());
        Calendar cExtracionFechaNacimiento = Calendar.getInstance();
        cExtracionFechaNacimiento.set(dpFechaNacimiento.getYear(),dpFechaNacimiento.getMonth()
                ,dpFechaNacimiento.getDayOfMonth());
        siguienteVentana.putExtra(getResources().getString(R.string.pFechaNacimiento),
                cExtracionFechaNacimiento);
        startActivity(siguienteVentana);
        finish();
    }
}
