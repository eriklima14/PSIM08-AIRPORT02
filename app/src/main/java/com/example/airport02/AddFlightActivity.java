package com.example.airport02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddFlightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flight);

        EditText etOrigem = findViewById(R.id.etOrigem);
        EditText etNumero = findViewById(R.id.etNumero);
        EditText etPrevista = findViewById(R.id.etPrevista);
        EditText etFinal = findViewById(R.id.etFinal);
        EditText etData = findViewById(R.id.etData);
        EditText etCompanhia = findViewById(R.id.etCompanhia);
        EditText etTerminal = findViewById(R.id.etTerminal);

        Button btnAdd = findViewById(R.id.btnAdicionar);
        Button btnCancel = findViewById(R.id.btnCancelar);

        btnAdd.setOnClickListener(v -> {

            Intent resultIntent = new Intent();

            resultIntent.putExtra("origem", etOrigem.getText().toString());
            resultIntent.putExtra("numero", etNumero.getText().toString());
            resultIntent.putExtra("prevista", etPrevista.getText().toString());
            resultIntent.putExtra("final", etFinal.getText().toString());
            resultIntent.putExtra("data", etData.getText().toString());
            resultIntent.putExtra("companhia", etCompanhia.getText().toString());
            resultIntent.putExtra("terminal", etTerminal.getText().toString());

            setResult(RESULT_OK, resultIntent);
            finish();
        });

        btnCancel.setOnClickListener(v -> finish());
    }
}