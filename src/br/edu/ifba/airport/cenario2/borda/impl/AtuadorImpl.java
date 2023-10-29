package br.edu.ifba.airport.cenario2.borda.impl;

import java.util.List;

import br.edu.ifba.airport.cenario2.borda.atuador.Atuador;
import br.edu.ifba.airport.cenario2.modelo.Trafego;

public class AtuadorImpl implements Atuador<Trafego, String> {

    private static final int VALOR_MEDIO_POR_VOO = 500;
    private static final int VALOR_PASSAGEM = 60;
    private double mediaGeral = 0;

    // O(N^3)
    @Override
    public String atuar(List<Trafego> leituras) {
        double faturamento = 0;

        for (Trafego leitura : leituras) {
            for (int v = 0; v < leitura.getVoos(); v++) {

                for (int p = 0; p < leitura.getPassageiros(); p++) {
                    faturamento += leitura.getPassageiros() * VALOR_PASSAGEM;
                }
                faturamento += VALOR_MEDIO_POR_VOO * leitura.getVoos() * 100;
            }
            faturamento -= leitura.getDistancia() * 10;
        }

        // Calcula o lucro médio
        double faturamentoMedio = faturamento / leituras.size();
        this.mediaGeral += faturamentoMedio;
        // Verifica a situação financeira
        if (faturamentoMedio >= this.mediaGeral / leituras.size()) {
            return "Situação financeira estável";
        } else {
            return "Situação financeira instável";
        }
    }

}