package Server;

import Logic.Account;
import Logic.Transfer;
import Logic.User;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by Devene on 5/3/2016.
 */
public class TransInCommand implements Tranzactii {
    private String nume;
    private double suma;
    private String tipS;
    private String tipD;
    private String detalii;
    public TransInCommand(String nume,double suma,String tipS,String tipD,String detalii){
        this.nume = nume;
        this.suma = suma;
        this.tipD = tipD;
        this.tipS = tipS;
        this.detalii = detalii;
    }
    public boolean execute(){
        User cont = User.findByN(nume);
        Account contS = new Account();
        Account contD = new Account();
        String dateS = contS.find(cont.getNume(),tipS);
        String dateD = contD.find(cont.getNume(),tipD);
        String[] start = dateS.split(",");
        String[] dest = dateD.split(",");
        double amount = Double.parseDouble(start[2]);
        double comm = Double.parseDouble(start[4]);
        double amountD = Double.parseDouble(dest[2]);
        Calendar cal = Calendar.getInstance();
        Timestamp timp = new Timestamp(cal.getTime().getTime());
        if(amount-suma-comm<0 && tipS.equals("Credit")){
            contS.update(cont.getNume(),amount-suma-comm, tipS);
            contD.update(cont.getNume(),amountD+suma, tipD);
            Transfer rap = new Transfer(timp,cont.getNume(),start[1],cont.getNume(),dest[1],suma,detalii);
            rap.intsert(rap);
        }else if(amount-suma-comm>=0){
            contS.update(cont.getNume(),amount-suma-comm, tipS);
            Transfer rap = new Transfer(timp,cont.getNume(),start[1],cont.getNume(),dest[1],suma,detalii);
            rap.intsert(rap);
        }
        return true;
    }
}
