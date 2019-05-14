package Persistance;

import Model.Aithousa;
import Model.Dieuthintis;
import Model.Kratisi;
import Model.Pelatis;
import Model.Provoli;
import Model.Tainia;
import Model.Thesi;
import Model.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DbEmulator {
    
    private static DbEmulator instance;
    
    private final ArrayList<User> usersList;
    private final ArrayList<Thesi> theseisList;
    private final ArrayList<Aithousa> aithousesList;
    private final ArrayList<Tainia> tainiesList;
    private final ArrayList<Provoli> provolesList;
    private final ArrayList<Kratisi> kratisiList;
    
    private DbEmulator() {
        usersList = new ArrayList<>();
        theseisList = new ArrayList<>();
        aithousesList = new ArrayList<>();
        tainiesList = new ArrayList<>();
        provolesList = new ArrayList<>();
        kratisiList = new ArrayList<>();
        
        fillTables();
    }
    
    public static DbEmulator getInstance() {
        if(instance == null) {
            instance = new DbEmulator();
        }
        return instance;
    }
    
    public ArrayList<User> selectUsers() {
        ArrayList<User> uList = new ArrayList<>();
        for(User u : usersList) {
            uList.add(u);
        }
        return uList;
    }
    
    public ArrayList<Thesi> selectTheseis() {
        ArrayList<Thesi> tList = new ArrayList<>();
        for(Thesi t : theseisList) {
            tList.add(t);
        }
        return tList;
    }
    
    public ArrayList<Aithousa> selectAithouses() {
        ArrayList<Aithousa> aList = new ArrayList<>();
        for(Aithousa a : aithousesList) {
            aList.add(a);
        }
        return aList;
    }
    
    public ArrayList<Tainia> selectTainies() {
        ArrayList<Tainia> tList = new ArrayList<>();
        for(Tainia t : tainiesList) {
            tList.add(t);
        }
        return tList;
    }
    
    public ArrayList<Provoli> selectProvoles() {
        ArrayList<Provoli> pList = new ArrayList<>();
        for(Provoli p : provolesList) {
            pList.add(p);
        }
        return pList;
    }
    
    public ArrayList<Kratisi> selectKratiseis() {
        ArrayList<Kratisi> kList = new ArrayList<>();
        for(Kratisi k : kratisiList) {
            kList.add(k);
        }
        return kList;
    }
    
    public void insertThesi(Thesi thesi) {
        theseisList.add(thesi);
    }
    
    public void insertAithousa(Aithousa a) {
        aithousesList.add(a);
    }
    
    public void insertTainia(Tainia t) {
        tainiesList.add(t);
    }
    
    public void insertProvoli(Provoli p) {
        provolesList.add(p);
    }
    
    public void insertKratisi(Kratisi k) {
        kratisiList.add(k);
    }
    
    public void deleteThesi(Thesi t) {
        theseisList.remove(t);
    }
    
    public void deleteAithousa(Aithousa a) {
        aithousesList.remove(a);
    }
    
    public void deleteTainia(Tainia t) {
        tainiesList.remove(t);
    }
    
    public void deleteProvoli(Provoli p) {
        provolesList.remove(p);
    }
    
    public void deleteKratisi(Kratisi k) {
        kratisiList.remove(k);
    }
    
    private void fillTables() {
        usersList.add(new Dieuthintis("admin", "123"));
        usersList.add(new Pelatis("pelatis", "123", "normal"));
        usersList.add(new Pelatis("foithths", "123", "student"));
        usersList.add(new Pelatis("paidi", "123", "under10"));
        usersList.add(new Pelatis("hlikiwmenos", "123", "above60"));
        
        for(int i = 1; i <= 3; i++) {
            Aithousa a = new Aithousa("Aithousa " + i);
            ArrayList<Thesi> tList = new ArrayList<>();
            for(int j = 1; j <= 15; j++) {
                Thesi t = new Thesi(a, j);
                tList.add(t);
                theseisList.add(t);
            }
            a.setTheseisList(tList);
            aithousesList.add(a);
        }
        
        tainiesList.add(new Tainia("Tainia 1", "Peripeteia", 96, "Perigrafi 1", 10.0));
        tainiesList.add(new Tainia("Tainia 2", "Drama", 118, "Perigrafi 2", 17.0));
        tainiesList.add(new Tainia("Tainia 3", "Komodia", 103, "Perigrafi 3", 12.0));
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        
        try {
            provolesList.add(new Provoli(tainiesList.get(0), aithousesList.get(0), 1, dateFormat.parse("19:00")));
            provolesList.add(new Provoli(tainiesList.get(1), aithousesList.get(1), 4, dateFormat.parse("21:15")));
            provolesList.add(new Provoli(tainiesList.get(2), aithousesList.get(2), 5, dateFormat.parse("22:40")));
        } catch(ParseException e) { /* Ignored */ }
        
        kratisiList.add(new Kratisi((Pelatis)usersList.get(1), provolesList.get(0)));
    }
}
