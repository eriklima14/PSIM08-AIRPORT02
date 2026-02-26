package com.example.airport02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class Flight_Adapter extends BaseAdapter {

    private Context context;
    private List<Flight> listaVoos;

    public Flight_Adapter(Context context, List<Flight> listaVoos) {
        this.context = context;
        this.listaVoos = listaVoos;
    }

    @Override
    public int getCount() {
        return listaVoos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaVoos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.flight_item, parent, false);
        }

        Flight voo = listaVoos.get(position);

        TextView tvOrigin = convertView.findViewById(R.id.tvOrigin);
        TextView tvFlightNumber = convertView.findViewById(R.id.tvFlightNumber);
        TextView tvExpectedTime = convertView.findViewById(R.id.tvExpectedTime);
        TextView tvActualTime = convertView.findViewById(R.id.tvActualTime);

        tvOrigin.setText(voo.getOrigem());
        tvFlightNumber.setText(context.getString(R.string.label_flight) + " " + voo.getNumeroVoo());
        tvExpectedTime.setText(context.getString(R.string.label_expected) + " " + voo.getHoraPrevista());
        tvActualTime.setText(voo.getHoraFinal());

        return convertView;
    }
}