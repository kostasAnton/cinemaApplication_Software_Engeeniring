package Controller;

import Model.Dieuthintis;
import Model.Pelatis;
import Model.User;
import Persistance.DbEmulator;
import View.UILogin;
import java.util.ArrayList;

public class Handler {
    
    private UILogin uiLogin;
    
    public Handler() {
        uiLogin = new UILogin(this);
        uiLogin.setVisible(true);
    }

    public UILogin getUiLogin() {
        return uiLogin;
    }

    public void setUiLogin(UILogin uiLogin) {
        this.uiLogin = uiLogin;
    }
    
    public void elegxosUser(String userName, String password) {
        ArrayList<User> uList = DbEmulator.getInstance().selectUsers();
        for(User u : uList) {
            if(u.getUserName().equals(userName)) {
                if(u.getPassword().equals(password)) {
                    if(u instanceof Dieuthintis) {
                        DieuthintisHandler dieuthintisHandler = new DieuthintisHandler((Dieuthintis)u);
                    }
                    else if(u instanceof Pelatis) {
                        PelatisHandler pelatisHandler = new PelatisHandler((Pelatis) u);
                    }
                    
                    uiLogin.dispose();
                }
            }
        }
    }
}
