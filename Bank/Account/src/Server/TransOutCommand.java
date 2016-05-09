package Server;

import Logic.Account;
import Logic.Transfer;
import Logic.User;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by Devene on 5/3/2016.
 */
public class TransOutCommand implements Tranzactii {
    private String nume;
    private String numeD;
    private double suma;
    private String tipS;
    private String tipD;
    private String detalii;
    public TransOutCommand(String nume,String numeD,double suma,String tipS,String tipD,String detalii){
        this.nume = nume;
        this.numeD = numeD;
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
        String dateD = contD.find(numeD,tipD);
        String[] start = dateS.split(",");
        String[] dest = dateD.split(",");
        double amount = Double.parseDouble(start[2]);
        double comm = Double.parseDouble(start[4]);
        double amountD = Double.parseDouble(dest[2]);
        Calendar cal = Calendar.getInstance();
        Timestamp timp = new Timestamp(cal.getTime().getTime());
        if(amount-suma-comm<0 && tipS.equals("Credit")){
            contS.update(cont.getNume(),amount-suma-comm, tipS);
            contD.update(numeD,amountD+suma, tipD);
            Transfer rap = new Transfer(timp,cont.getNume(),start[1],numeD,dest[1],suma,detalii);
            rap.intsert(rap);
        }else if(amount-suma-comm>=0){
            contS.update(cont.getNume(),amount-suma-comm, tipS);
            contD.update(numeD,amountD+suma, tipD);
            Transfer rap = new Transfer(timp,cont.getNume(),start[1],numeD,dest[1],suma,detalii);
            rap.intsert(rap);
        }
        return true;
    }
}
