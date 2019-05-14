package Model;

import java.util.ArrayList;

public class Aithousa {

    private String name;
    private ArrayList<Thesi> theseisList;

    public Aithousa(String name, ArrayList<Thesi> theseisList) {
        this.name = name;
        this.theseisList = theseisList;
    }

    public Aithousa(String name) {
        this(name, new ArrayList<Thesi>());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTheseisList(ArrayList<Thesi> theseisList) {
        this.theseisList = theseisList;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Thesi> getTheseisList() {
        return theseisList;
    }
}
