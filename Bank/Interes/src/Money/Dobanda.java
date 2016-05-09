package Money;

import Logic.Account;

/**
 * Created by Devene on 5/5/2016.
 */
public class Dobanda {
    private Account conturi;
    public Dobanda(){
        conturi = new Account();
    }
    public void updateDobanda() {
        String accounts = conturi.getAccounts();
        if (!accounts.equals("")) {
            String[] lista = accounts.split(";");
                for (String c : lista) {
                    String[] date = c.split(",");
                    if(!date[1].equals("Activ")) {
                        String valori = conturi.find(date[0], date[1]);
                        String[] num = valori.split(",");
                        double suma = Double.parseDouble(num[2]);
                        double interes = Double.parseDouble(num[4]);
                        double dob = (suma * (interes / 100.0));
                        String res = String.format("%.2f", dob);
                        dob = Double.parseDouble(res);
                        conturi.updateDobanda(date[0], date[1], dob);
                    }
                }
        }
    }
}
