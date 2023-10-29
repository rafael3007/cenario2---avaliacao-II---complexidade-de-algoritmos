package br.edu.ifba.airport.cenario2.borda.sensores;

public interface Sensores<Leitura> {

    public boolean temLeitura();

    public Leitura getLeitura();

}
