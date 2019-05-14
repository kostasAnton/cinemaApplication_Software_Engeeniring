package Controller;

import Model.Aithousa;
import Model.Dieuthintis;
import Model.EvdomadiaioProgramma;
import Model.Provoli;
import Model.Tainia;
import Persistance.DbEmulator;
import View.UIProgramma;
import java.util.ArrayList;
import java.util.Date;

public class DieuthintisHandler {

    private Dieuthintis dieuthintis;
    private EvdomadiaioProgramma programma;
    private UIProgramma uiProgramma;

    public DieuthintisHandler(Dieuthintis dieuthintis) {
        this.dieuthintis = dieuthintis;
        programma = new EvdomadiaioProgramma(0, 0);
        
        uiProgramma = new UIProgramma(this);
        uiProgramma.setVisible(true);
        
        update();
    }

    public void setDieuthintis(Dieuthintis dieuthintis) {
        this.dieuthintis = dieuthintis;
    }

    public void setProgramma(EvdomadiaioProgramma programma) {
        this.programma = programma;
    }
    
    public void setUIProgramma(UIProgramma uiProgramma) {
        this.uiProgramma = uiProgramma;
    }

    public Dieuthintis getDieuthintis() {
        return dieuthintis;
    }

    public EvdomadiaioProgramma getProgramma() {
        return programma;
    }
    
    public UIProgramma getUIProgramma() {
        return uiProgramma;
    }
    
    public ArrayList<Aithousa> getAithouses() {
        return DbEmulator.getInstance().selectAithouses();
    }
    
    public ArrayList<Tainia> getTainies() {
        return DbEmulator.getInstance().selectTainies();
    }

    public void addProvoli(Provoli p) {
        DbEmulator.getInstance().insertProvoli(p);
        update();
    }

    public void removeProvoli(Provoli p) {
        DbEmulator.getInstance().deleteProvoli(p);
        update();
    }

    public void editProvoli(Provoli p, Tainia t, Aithousa a, int day, Date time) {
        p.setTainia(t);
        p.setAithousa(a);
        p.setDay(day);
        p.setTime(time);
        
        update();
    }
    
    private void update() {
        programma.setProvoles(DbEmulator.getInstance().selectProvoles());
        uiProgramma.setProgrammaTableData(programma);
    }
}
