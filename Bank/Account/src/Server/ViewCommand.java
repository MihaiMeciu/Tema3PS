package Server;

import Logic.Account;
import Logic.User;

/**
 * Created by Devene on 5/3/2016.
 */
public class ViewCommand implements Tranzactii{
    private String nume;
    private String adr;
    private String tel;
    private String passV;
    private String passN1;
    private String passN2;
    public ViewCommand(String nume,String adr,String tel,String passV,String passN1,String passN2){
        this.nume = nume;
        this.adr = adr;
        this.tel = tel;
        this.passV = passV;
        this.passN1 = passN1;
        this.passN2 = passN2;
    }
    public ViewCommand(){

    }
    public boolean execute(){
        if(!passV.equals("")) {
            User cont = User.findByNP(nume, passV);
            if(cont!=null) {
                if (passN1.equals(passN2)) {
                    cont.update(nume,adr,tel,passN1);
                }
            }
        }else{
            User cont = User.findByN(nume);
            cont.updateData(nume,adr,tel);
        }
        return true;
    }
    public String getSession(String nume){
        User cont = User.findByN(nume);
        if(cont!=null){
            String session=cont.getAdr()+","+cont.getTel()+","+cont.getNume();
            return session;
        }else{
            return "No account found!";
        }
    }

}