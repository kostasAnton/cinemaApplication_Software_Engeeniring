package Model;

public class Tainia {

    private String titlos;
    private String eidos;
    private int diarkeia;
    private String perigrafh;
    private double timi;

    public Tainia(String titlos, String eidos, int diarkeia, String perigrafh, double timi) {
        this.titlos = titlos;
        this.eidos = eidos;
        this.diarkeia = diarkeia;
        this.perigrafh = perigrafh;
        this.timi = timi;
    }

    public void setTitlos(String titlos) {
        this.titlos = titlos;
    }

    public void setEidos(String eidos) {
        this.eidos = eidos;
    }

    public void setDiarkeia(int diarkeia) {
        this.diarkeia = diarkeia;
    }

    public void setPerigrafh(String perigrafh) {
        this.perigrafh = perigrafh;
    }

    public void setTimi(double timi) {
        this.timi = timi;
    }

    public String getTitlos() {
        return titlos;
    }

    public String getEidos() {
        return eidos;
    }

    public int getDiarkeia() {
        return diarkeia;
    }

    public String getPerigrafh() {
        return perigrafh;
    }

    public double getTimi() {
        return timi;
    }
}
