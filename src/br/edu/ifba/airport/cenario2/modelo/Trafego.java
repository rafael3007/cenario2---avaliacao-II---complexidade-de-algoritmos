package br.edu.ifba.airport.cenario2.modelo;

// constante, O(1)
public class Trafego {
    private int voos = 0;
    private int distancia = 0;
    private int passageiros = 0;

    public int getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(int passageiros) {
        this.passageiros = passageiros;
    }

    public Trafego(int voos, int distancia, int passageiros) {
        this.voos = voos;
        this.distancia = distancia;
        this.passageiros = passageiros;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "Quantidade de voos: " + voos;
    }

    public int getVoos() {
        return voos;
    }

    public void setVoos(int voos) {
        this.voos = voos;
    }

}
