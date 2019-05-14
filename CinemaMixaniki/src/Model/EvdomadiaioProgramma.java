package Model;

import java.util.ArrayList;

public class EvdomadiaioProgramma {

    private int etos;
    private int evdomada;
    private ArrayList<Provoli> provolesList;

    public EvdomadiaioProgramma(int etos, int evdomada, ArrayList<Provoli> p) {
        this.etos = etos;
        this.evdomada = evdomada;
        this.provolesList = p;
    }

    public EvdomadiaioProgramma(int etos, int evdomada) {
        this(etos, evdomada, new ArrayList<Provoli>());
    }

    public void setEtos(int etos) {
        this.etos = etos;
    }

    public void setEvdomada(int evdomada) {
        this.evdomada = evdomada;
    }

    public void setProvoles(ArrayList<Provoli> p) {
        this.provolesList = p;
    }

    public int getEtos() {
        return etos;
    }

    public int getEvdomada() {
        return evdomada;
    }

    public ArrayList<Provoli> getProvoles() {
        return provolesList;
    }
}
