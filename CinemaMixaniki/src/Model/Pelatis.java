package Model;

public class Pelatis extends User {

    String category;

    public Pelatis(String userName, String password, String c) {
        super(userName, password);
        category = c;
    }

    public void setCategory(String c) {
        category = c;
    }

    public String getCategory() {
        return category;
    }
}
