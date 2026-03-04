package com.example.airport02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Flight> listaVoos;
    private Flight_Adapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main),
                (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                });

        listView = findViewById(R.id.ListView);
        Button btnAddFlight = findViewById(R.id.btnAddFlight);

        listaVoos = gerarVoosFicticios();
        adapter = new Flight_Adapter(this, listaVoos);
        listView.setAdapter(adapter);

        // CLICK NA LISTA (abrir detalhes)
        listView.setOnItemClickListener((parent, view, position, id) -> {

            Flight voo = listaVoos.get(position);

            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);

            intent.putExtra("position", position);
            intent.putExtra("origem", voo.getOrigem());
            intent.putExtra("numero", voo.getNumeroVoo());
            intent.putExtra("prevista", voo.getHoraPrevista());
            intent.putExtra("final", voo.getHoraFinal());
            intent.putExtra("data", voo.getData());
            intent.putExtra("companhia", voo.getCompanhia());
            intent.putExtra("terminal", voo.getTerminal());

            startActivityForResult(intent, 1);
        });

        // BOTÃO ADICIONAR VOO
        btnAddFlight.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddFlightActivity.class);
            startActivityForResult(intent, 2);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // NOVO VOO
        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {

            Flight novoVoo = new Flight(
                    data.getStringExtra("origem"),
                    data.getStringExtra("numero"),
                    data.getStringExtra("prevista"),
                    data.getStringExtra("final"),
                    data.getStringExtra("data"),
                    data.getStringExtra("companhia"),
                    data.getStringExtra("terminal")
            );

            listaVoos.add(novoVoo);
            adapter.notifyDataSetChanged();
        }

        // DELETE
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            int position = data.getIntExtra("deletePosition", -1);

            if (position != -1) {
                listaVoos.remove(position);
                adapter.notifyDataSetChanged();
            }
        }
    }

    private ArrayList<Flight> gerarVoosFicticios() {
        ArrayList<Flight> voos = new ArrayList<>();
        voos.add(new Flight("Lisboa (LIS)", "TP123", "10:30", "10:45", "04/06/2026", "TAP Air Portugal", "Terminal 1"));
        voos.add(new Flight("Porto (OPO)", "FR456", "11:00", "11:05", "04/06/2026", "Ryanair", "Terminal 2"));
        voos.add(new Flight("Madrid (MAD)", "IB789", "12:15", "12:20", "04/06/2026", "Iberia", "Terminal 1"));
        voos.add(new Flight("Paris (CDG)", "AF321", "13:40", "13:50", "05/06/2026", "Virgin Atlantic", "Terminal 1"));
        voos.add(new Flight("Londres (LHR)", "BA654", "14:00", "14:10", "04/03/2026", "Qatar Airways", "Terminal 1"));
        return voos;
    }
}