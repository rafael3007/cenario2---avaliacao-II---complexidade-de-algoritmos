package br.edu.ifba.airport.cenario2.nuvem.impl;

import br.edu.ifba.airport.cenario2.borda.impl.AtuadorImpl;
import br.edu.ifba.airport.cenario2.borda.impl.SensoresImpl;
import br.edu.ifba.airport.cenario2.modelo.Aeroporto;
import br.edu.ifba.airport.cenario2.modelo.Trafego;
import br.edu.ifba.airport.cenario2.nuvem.executor.Executor;

public class ExecutorImpl extends Executor {

    private br.edu.ifba.airport.cenario2.modelo.Aeroporto aeroporto = null;
    private SensoresImpl sensores = null;

    AtuadorImpl banco = new AtuadorImpl(); // atenção aqui

    public ExecutorImpl(
            Aeroporto aeroporto, SensoresImpl sensores,
            int totalDeLeituras) {
        super(totalDeLeituras);

        this.aeroporto = aeroporto;
        this.sensores = sensores;

    }

    // constante, O(1)
    @Override
    public void processarLeitura(int leituraAtual) {
        if (sensores.temLeitura()) {
            Trafego leitura = sensores.getLeitura();
            aeroporto.onLeitura(leitura);

            // atenção aqui
            String informacoes = banco.atuar(aeroporto.getLeituras());
            informacoes = informacoes == "" ? "nenhum problema encontrado, " : informacoes;

            System.out
                    .println("leitura realizado no ciclo #" + leituraAtual + " para o Aeroporto " + aeroporto.getNome()
                            + ":" + informacoes);
        }
    }

}
