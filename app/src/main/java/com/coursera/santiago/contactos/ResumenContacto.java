package com.coursera.santiago.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class ResumenContacto extends AppCompatActivity {

    TextView tvNombreCompleto;
    TextView tvFechaNacimiento;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;
    Calendar cfechaNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_contacto);
        Bundle parametros = getIntent().getExtras();

        tvNombreCompleto = findViewById(R.id.tvNombreCompleto);
        tvFechaNacimiento = findViewById(R.id.tvFechaNacimiento);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvEmail = findViewById(R.id.tvEMail);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        cfechaNacimiento = (Calendar)parametros.get(getResources().getString(R.string.pFechaNacimiento));

        tvNombreCompleto.setText(parametros.getString(getResources().getString(R.string.pNombreCompleto)));
        tvTelefono.setText(parametros.getString(getResources().getString(R.string.pTelefono)));
        tvEmail.setText(parametros.getString(getResources().getString(R.string.pEmail)));
        tvDescripcion.setText(parametros.getString(getResources().getString(R.string.pDescripcionContacto)));

        StringBuilder sbFecha = new StringBuilder().
                append(cfechaNacimiento.get(Calendar.DAY_OF_MONTH)).append("/").
                append(cfechaNacimiento.get(Calendar.MONTH)+1).append("/").
                append(cfechaNacimiento.get(Calendar.YEAR));
        tvFechaNacimiento.setText(sbFecha.toString());

    }

    public void editar(View v){
        Intent edicion = new Intent(this, MainActivity.class);
        edicion.putExtra(getResources().getString(R.string.pNombreCompleto), tvNombreCompleto.getText().toString());
        edicion.putExtra(getResources().getString(R.string.pEmail), tvEmail.getText().toString());
        edicion.putExtra(getResources().getString(R.string.pTelefono), tvTelefono.getText().toString());
        edicion.putExtra(getResources().getString(R.string.pDescripcionContacto), tvDescripcion.getText().toString());
        edicion.putExtra(getResources().getString(R.string.pFechaNacimiento), cfechaNacimiento);
        startActivity(edicion);
        finish();
    }
}
