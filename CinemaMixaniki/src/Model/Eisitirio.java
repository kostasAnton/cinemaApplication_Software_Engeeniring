package Model;

public class Eisitirio {

    private Pelatis pelatis;
    private Provoli provoli;
    private Kratisi kratisi;
    private Thesi thesi;

    public Eisitirio(Pelatis pelatis, Provoli provoli, Kratisi kratisi, Thesi thesi) {
        this.pelatis = pelatis;
        this.provoli = provoli;
        this.kratisi = kratisi;
        this.thesi = thesi;
    }

    public Thesi getThesi() {
        return thesi;
    }

    public void setThesi(Thesi thesi) {
        this.thesi = thesi;
    }

    public Kratisi getKratisi() {
        return kratisi;
    }

    public void setKratisi(Kratisi kratisi) {
        this.kratisi = kratisi;
    }

    public Pelatis getPelatis() {
        return pelatis;
    }

    public void setPelatis(Pelatis pelatis) {
        this.pelatis = pelatis;
    }

    public Provoli getProvoli() {
        return provoli;
    }

    public void setProvoli(Provoli provoli) {
        this.provoli = provoli;
    }
}
