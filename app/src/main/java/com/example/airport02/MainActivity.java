package com.example.airport02;

import android.os.Bundle;
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

        // Criar lista de voos fictícios
        listaVoos = gerarVoosFicticios();

        // Criar adapter e associar à ListView
        adapter = new Flight_Adapter(this, listaVoos);
        listView.setAdapter(adapter);
    }

    // Gerar voos fictícios
    private ArrayList<Flight> gerarVoosFicticios() {
        ArrayList<Flight> voos = new ArrayList<>();
        voos.add(new Flight("Lisboa (LIS)", "TP123", "10:30", "10:45"));
        voos.add(new Flight("Porto (OPO)", "FR456", "11:00", "11:05"));
        voos.add(new Flight("Madrid (MAD)", "IB789", "12:15", "12:20"));
        voos.add(new Flight("Paris (CDG)", "AF321", "13:40", "13:50"));
        voos.add(new Flight("Londres (LHR)", "BA654", "14:00", "14:10"));
        return voos;
    }
}