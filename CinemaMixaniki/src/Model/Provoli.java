package Model;

import java.util.Date;

public class Provoli {

    private Tainia tainia;
    private Aithousa aithousa;
    private int day;
    private Date time;

    public Provoli(Tainia tainia, Aithousa aithousa, int day, Date time) {
        if(day < 0 || day > 6) {
            day = 0;
        }

        this.tainia = tainia;
        this.aithousa = aithousa;
        this.day = day;
        this.time = time;
    }

    public void setTainia(Tainia tainia) {
        this.tainia = tainia;
    }

    public void setAithousa(Aithousa aithousa) {
        this.aithousa = aithousa;
    }

    public void setDay(int day) {
        if(day < 0 || day > 6) {
            day = 0;
        }

        this.day = day;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Tainia getTainia() {
        return tainia;
    }

    public Aithousa getAithousa() {
        return aithousa;
    }

    public int getDay() {
        return day;
    }

    public Date getTime() {
        return time;
    }
}
