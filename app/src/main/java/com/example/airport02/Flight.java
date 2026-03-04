package com.example.airport02;

public class Flight
{
    private String origem;
    private String numeroVoo;
    private String horaPrevista;
    private String horaFinal;

    private String data;
    private String companhia;
    private String terminal;

    public Flight(String origem, String numeroVoo, String horaPrevista, String horaFinal, String data, String companhia, String terminal)
    {
        this.origem = origem;
        this.numeroVoo = numeroVoo;
        this.horaPrevista = horaPrevista;
        this.horaFinal = horaFinal;
        this.data = data;
        this.companhia = companhia;
        this.terminal = terminal;
    }

    // Métodos
    public String getOrigem() { return origem; }
    public String getNumeroVoo() { return numeroVoo; }
    public String getHoraPrevista() { return horaPrevista; }
    public String getHoraFinal() { return horaFinal; }
    public String getData() { return data; }
    public String getCompanhia() { return companhia; }
    public String getTerminal() { return terminal; }
}
