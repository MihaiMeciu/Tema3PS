package Server;

import Logic.ActiveAccount;
import Logic.CreditAccount;
import Logic.Deposit;
import Logic.User;

/**
 * Created by Devene on 5/1/2016.
 */
public class NewClientCommand implements Tranzactii {
    private String nume;
    private String pass;
    private String tip;
    private String adr;
    private String tel;
    private double suma;
    private double com;
    private double inte;
    public NewClientCommand(String nume,String adr,String tel,String tip,double suma,double com,double inte,String pass){
        this.nume = nume;
        this.adr = adr;
        this.tel = tel;
        this.tip = tip;
        this.pass = pass;
        this.suma = suma;
        this.com = com;
        this.inte = inte;
    }
    public boolean execute(){
        User user = new User(nume,pass,adr,tel,"client");
        String iden = user.insert(user);
        switch (tip){
            case "Activ":{
                ActiveAccount cont = new ActiveAccount();
                boolean nou = cont.Account(nume,tip,iden,suma,com,inte);
                break;
            }
            case "Credit":{
                CreditAccount cont = new CreditAccount();
                boolean nou = cont.Account(nume,tip,iden,suma,com,inte);
                break;
            }
            case "Depozit":{
                Deposit cont = new Deposit();
                boolean nou = cont.Account(nume,tip,iden,suma,com,inte);
                break;
            }
        }
        return true;
    }
}
