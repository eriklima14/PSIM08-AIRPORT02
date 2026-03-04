package com.example.airport02;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        Intent intent = getIntent();

        int position = intent.getIntExtra("position", -1);

        String origem = intent.getStringExtra("origem");
        String numero = intent.getStringExtra("numero");
        String data = intent.getStringExtra("data");
        String companhia = intent.getStringExtra("companhia");
        String terminal = intent.getStringExtra("terminal");

        ((TextView)findViewById(R.id.tvData)).setText("Data: " + data);
        ((TextView)findViewById(R.id.tvOrigem)).setText("Origem: " + origem);
        ((TextView)findViewById(R.id.tvNumero)).setText("Voo: " + numero);
        ((TextView)findViewById(R.id.tvCompanhia)).setText("Companhia: " + companhia);
        ((TextView)findViewById(R.id.tvTerminal)).setText("Terminal: " + terminal);

        Button btnOK = findViewById(R.id.btnOK);
        Button btnDelete = findViewById(R.id.btnDelete);

        btnOK.setOnClickListener(v -> finish());

        btnDelete.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("deletePosition", position);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
