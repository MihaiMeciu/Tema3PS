package Server;

import Logic.User;

/**
 * Created by Devene on 5/1/2016.
 */
public class LoginCommand implements Tranzactii {
    private User client;
    private String nume;
    private String pass;
    public LoginCommand(String nume,String pass){
        this.nume = nume;
        this.pass = pass;
    }
    public boolean execute(){
        client = client.findByNP(nume,pass);
        if(client!=null)
            return true;
        else
            return false;
    }
    public String getSession(){
        return client.getNume()+","+client.getTip();
    }
}
