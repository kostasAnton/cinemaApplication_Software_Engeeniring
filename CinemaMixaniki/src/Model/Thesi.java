package Model;

public class Thesi {
    
    private Aithousa aithousa;
    private int number;
    
    public Thesi(Aithousa aithousa, int number) {
        this.aithousa = aithousa;
        this.number = number;
    }
    
    public void setAithousa(Aithousa aithousa) {
        this.aithousa = aithousa;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    public Aithousa getAithousa() {
        return aithousa;
    }
    
    public int getNumber() {
        return number;
    }
}
