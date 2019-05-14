package Model;

import java.util.ArrayList;

public class Kratisi {

    private Pelatis pelatis;
    private Provoli provoli;
    private ArrayList<Eisitirio> eisitiriaList;

    public Kratisi(Pelatis pelatis, Provoli provoli, ArrayList<Eisitirio> eisitiriaList) {
        this.pelatis = pelatis;
        this.provoli = provoli;
        this.eisitiriaList = eisitiriaList;
    }

    public Kratisi(Pelatis pelatis, Provoli provoli) {
        this(pelatis, provoli, new ArrayList<Eisitirio>());
    }

    public Pelatis getPelatis() {
        return pelatis;
    }

    public Provoli getProvoli() {
        return provoli;
    }

    public ArrayList<Eisitirio> getEisitiriaList() {
        return eisitiriaList;
    }

    public void setPelatis(Pelatis pelatis) {
        this.pelatis = pelatis;
    }

    public void setProvoli(Provoli provoli) {
        this.provoli = provoli;
    }

    public void setEisitiriaList(ArrayList<Eisitirio> eisitiriaList) {
        this.eisitiriaList = eisitiriaList;
    }
}
