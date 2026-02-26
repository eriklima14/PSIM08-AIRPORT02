package com.example.airport02;

public class Flight
{
    private String origem;
    private String numeroVoo;
    private String horaPrevista;
    private String horaFinal;

    public Flight(String origem, String numeroVoo, String horaPrevista, String horaFinal)
    {
        this.origem = origem;
        this.numeroVoo = numeroVoo;
        this.horaPrevista = horaPrevista;
        this.horaFinal = horaFinal;
    }

    // Métodos
    public String getOrigem() { return origem; }
    public String getNumeroVoo() { return numeroVoo; }
    public String getHoraPrevista() { return horaPrevista; }
    public String getHoraFinal() { return horaFinal; }
}
