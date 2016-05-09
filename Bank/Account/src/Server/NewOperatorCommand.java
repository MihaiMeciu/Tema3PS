package Server;

import Logic.User;

/**
 * Created by Devene on 5/1/2016.
 */
public class NewOperatorCommand implements Tranzactii {
    private String nume;
    private String adr;
    private String tel;
    private String pass;
    public NewOperatorCommand(String nume,String adr,String tel,String pass){
        this.nume = nume;
        this.adr = adr;
        this.tel = tel;
        this.pass = pass;
    }
    public boolean execute(){
        User user = new User(nume,pass,adr,tel,"operator");
        user.insert(user);
        return true;
    }
}
