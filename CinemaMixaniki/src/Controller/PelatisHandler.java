package Controller;

import Model.Eisitirio;
import Model.Kratisi;
import Model.Pelatis;
import Model.Provoli;
import Persistance.DbEmulator;
import View.UIPelatis;
import java.util.ArrayList;

public class PelatisHandler {

    private final Pelatis pelatis;
    private final UIPelatis uiPelatis;

    public PelatisHandler(Pelatis u) {
        pelatis = u;
        uiPelatis = new UIPelatis(this);
        uiPelatis.setVisible(true);
        update();
    }

    public Pelatis getPelatis() {
        return pelatis;
    }

    public ArrayList<Kratisi> getKratiseis() {
        ArrayList<Kratisi> kList = new ArrayList<>();
        for(Kratisi k : DbEmulator.getInstance().selectKratiseis()) {
            if(k.getPelatis().getUserName().equals(pelatis.getUserName())) {
                kList.add(k);
            }
        }

        return kList;
    }

    public void addKratisi(Kratisi k) {
        DbEmulator.getInstance().insertKratisi(k);
        update();
    }

    public void editKratisi(Kratisi k, Provoli p, ArrayList<Eisitirio> eList) {
        k.setProvoli(p);
        k.setEisitiriaList(eList);
        update();
    }

    public void removeKratisi(Kratisi k) {
        DbEmulator.getInstance().deleteKratisi(k);
        update();
    }

    public ArrayList<Provoli> getProvoles() {
        return DbEmulator.getInstance().selectProvoles();
    }

    private void update() {
        ArrayList kList = new ArrayList<>();
        for(Kratisi k : DbEmulator.getInstance().selectKratiseis()) {
            if(pelatis.getUserName().equals(k.getPelatis().getUserName())) {
                kList.add(k);
            }
        }
        uiPelatis.setTableData(kList);
    }
}
