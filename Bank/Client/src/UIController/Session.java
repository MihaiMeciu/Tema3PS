package UIController;

/**
 * Created by Devene on 5/1/2016.
 */
public class Session {
    private String nume;
    private String tip;
    private String adr;
    private String tel;
    Session(String nume,String tip){
        this.nume = nume;
        this.tip = tip;
    }
    Session(String nume,String adr,String tel){
        this.nume = nume;
        this.adr = adr;
        this.tel = tel;
    }
    public String getNume(){
        return nume;
    }
    public String getTip(){ return tip; }
    public String getAdr(){ return adr; }
    public String getTel(){ return tel; }
}
