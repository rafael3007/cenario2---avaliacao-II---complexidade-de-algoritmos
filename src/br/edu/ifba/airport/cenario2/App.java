package br.edu.ifba.airport.cenario2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

// import com.github.javafaker.Faker;

import br.edu.ifba.airport.cenario2.borda.impl.SensoresImpl;
import br.edu.ifba.airport.cenario2.modelo.Aeroporto;
import br.edu.ifba.airport.cenario2.nuvem.impl.ExecutorImpl;

public class App {
    private static final int TOTAL_DE_PACIENTES = 10;
    private static final int TOTAL_DE_LEITURAS = 100;

    private static List<Thread> executores = new ArrayList<>();

    // linear, O(N)
    public static void iniciarProcessamentoDeLeituras(Map<Aeroporto, SensoresImpl> aeroportos) {
        for (Entry<Aeroporto, SensoresImpl> item : aeroportos.entrySet()) {
            Aeroporto aeroporto = item.getKey();
            SensoresImpl sensores = item.getValue();

            Thread executor = new Thread(new ExecutorImpl(aeroporto, sensores, TOTAL_DE_LEITURAS));
            executores.add(executor);

            executor.start();
        }
    }

    // linear, O(N)
    public static void esperarFinalizacaoDeProcessamento() throws InterruptedException {
        for (Thread executor : executores) {
            executor.join();
        }
    }

    // linear, O(N)
    public static Map<Aeroporto, SensoresImpl> gerarAeroportos() {
        // Faker faker = new Faker(Locale.forLanguageTag("pt-BR"));

        Map<Aeroporto, SensoresImpl> aeroportos = new TreeMap<>();
        for (int i = 0; i < TOTAL_DE_PACIENTES; i++) {
            Aeroporto aeroporto = new Aeroporto("#" + i, "--> #" + i);

            aeroportos.put(aeroporto, new SensoresImpl());
        }

        return aeroportos;
    }

    public static void main(String[] args) throws Exception {
        Map<Aeroporto, SensoresImpl> aeroportos = gerarAeroportos();

        System.out.println("iniciando o processamento");
        iniciarProcessamentoDeLeituras(aeroportos);
        esperarFinalizacaoDeProcessamento();

        System.out.println("processamento finalizado");
    }
}
