package br.edu.ifba.airport.cenario2.borda.atuador;

import java.util.List;

public interface Atuador<Leitura, Resultado> {

    Resultado atuar(List<Leitura> leituras);

}
