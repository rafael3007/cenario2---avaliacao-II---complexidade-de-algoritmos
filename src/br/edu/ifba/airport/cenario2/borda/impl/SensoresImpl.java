package br.edu.ifba.airport.cenario2.borda.impl;

import java.util.Random;

import br.edu.ifba.airport.cenario2.borda.sensores.Sensores;
import br.edu.ifba.airport.cenario2.modelo.Trafego;

public class SensoresImpl implements Sensores<Trafego> {

    private static final int VOOS_NORMAIS = 10;
    private static final int DISTANCIA_NORMAL = 300;
    private static final int QUANTIDADE_NORMAL_PASSAGEIROS = 80;

    private static final int OSCILACAO_MAXIMA_VOOS = 50;
    private static final int OSCILACAO_MAXIMA_DISTANCIA = 10;
    private static final int OSCILACAO_MAXIMA_PASSAGEIROS = 50;

    private Trafego ultimaLeitura = new Trafego(VOOS_NORMAIS, DISTANCIA_NORMAL, QUANTIDADE_NORMAL_PASSAGEIROS);

    // constante, O(1)
    @Override
    public boolean temLeitura() {
        Random randomizador = new Random();

        int oscilacao = randomizador.nextInt(OSCILACAO_MAXIMA_VOOS);
        boolean somarVoos = randomizador.nextBoolean();
        int voos = (int) (somarVoos ? VOOS_NORMAIS + (VOOS_NORMAIS * oscilacao / 100)
                : VOOS_NORMAIS - (VOOS_NORMAIS * oscilacao / 100));

        oscilacao = randomizador.nextInt(OSCILACAO_MAXIMA_DISTANCIA);
        boolean somarDistancia = randomizador.nextBoolean();
        int distancia = (int) (somarDistancia ? DISTANCIA_NORMAL + (DISTANCIA_NORMAL * oscilacao / 100)
                : DISTANCIA_NORMAL - (DISTANCIA_NORMAL * oscilacao / 100));

        oscilacao = randomizador.nextInt(OSCILACAO_MAXIMA_PASSAGEIROS);
        boolean somarPassageiros = randomizador.nextBoolean();
        int passageiros = (int) (somarPassageiros
                ? QUANTIDADE_NORMAL_PASSAGEIROS + (QUANTIDADE_NORMAL_PASSAGEIROS * oscilacao / 100)
                : QUANTIDADE_NORMAL_PASSAGEIROS - (QUANTIDADE_NORMAL_PASSAGEIROS * oscilacao / 100));

        ultimaLeitura = new Trafego(voos, distancia, passageiros);

        return true;
    }

    @Override
    public Trafego getLeitura() {
        return ultimaLeitura;
    }

}
