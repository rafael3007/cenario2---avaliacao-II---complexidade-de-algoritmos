package br.edu.ifba.airport.cenario2.modelo;

import java.util.ArrayList;
import java.util.List;

// constante, O(1)
public class Aeroporto implements Comparable<Aeroporto> {

    private String id = "";
    private String nome = "";

    private List<Trafego> leituras = new ArrayList<>();
    private Trafego ultimaLeitura = null;

    public Aeroporto(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Trafego> getLeituras() {
        return leituras;
    }

    public void setLeituras(List<Trafego> leituras) {
        this.leituras = leituras;
    }

    public Trafego getUltimaLeitura() {
        return ultimaLeitura;
    }

    public void setUltimaLeitura(Trafego ultimaLeitura) {
        this.ultimaLeitura = ultimaLeitura;
    }

    public void onLeitura(Trafego leitura) {
        this.leituras.add(leitura);
        this.ultimaLeitura = leitura;
    }

    @Override
    public int compareTo(Aeroporto outroAeroporto) {
        return id.compareTo(outroAeroporto.getId());
    }

}
