package Logic;

import java.sql.*;
import java.util.Random;

/**
 * Created by Devene on 3/21/2016.
 */
public class Account {

    private Connection con;
    private Statement st;
    private ResultSet rez;
    private PreparedStatement pst;

    boolean Account(String owner,String tip,double suma,double com,double inte){
        return true;
    }
    public void Connect() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
        }catch (Exception ex) {
            System.out.println("Errot: " + ex);
        }
    }
    public String find(String nume,String tip){
        Connect();
        try{
            st = con.createStatement();
            rez = st.executeQuery("select * from bank.accounts where nume=\'"+nume+"\' and tip=\'"+tip+"\'");
            if(rez.next()){
                String date = rez.getString("nume")+","+rez.getString("idCont")+","+String.valueOf(rez.getDouble("suma"))+","+String.valueOf(rez.getDouble("dobanda"))+","+String.valueOf(rez.getDouble("interes"))+","+String.valueOf(rez.getDouble("comision"));
                closeCon();
                return date;
            }
            closeCon();
            return "";
        }catch (Exception ex){
            closeCon();
            return "";
        }
    }
    public String getAccounts(){
        Connect();
        try{
            st = con.createStatement();
            rez = st.executeQuery("select nume,tip from bank.accounts");
            String accounts = "";
            while(rez.next()){
                accounts  =accounts + rez.getString("nume")+","+rez.getString("tip")+";";
            }
            closeCon();
            return accounts;
        }catch (Exception ex){
            closeCon();
            return "";
        }
    }
    public double getSuma(String nume,String tip){
        Connect();
        try{
            st = con.createStatement();
            rez = st.executeQuery("select suma from bank.accounts where nume=\'"+nume+"\' and tip=\'"+tip+"\'");
            double suma=-1.0;
            if(rez.next()){
                suma  =rez.getDouble("suma");
            }
            closeCon();
            return suma;
        }catch (Exception ex){
            closeCon();
            return -1.0;
        }
    }
    protected boolean Insert(String values) {
        Connect();
        try {
            String[] val = values.split(",");
            st = con.createStatement();
            rez = st.executeQuery("select * from bank.accounts where nume=\'"+val[0]+"\' and tip=\'"+val[1]+"\'");
            if (rez.next()){
                return false;
            }
            String idCont = "ROBTRL"+val[1].charAt(0)+val[2]+"XX";
            int res = st.executeUpdate("insert into bank.accounts values (default,\'"+val[0]+"\',\'"+val[1]+"\',\'"+idCont+"\',\'"+val[3]+"\',\'0.0\',\'"+val[5]+"\',\'"+val[4]+"\')");
            closeCon();
            return true;
        } catch (Exception ex){
            return false;
        }
    }
    public void update(String nume,double amount,String tip){
        Connect();
        try{
            st = con.createStatement();
            int res = st.executeUpdate("update bank.accounts set suma=\'" + String.valueOf(amount) + "\' where nume=\'" + nume + "\' and tip=\'" + tip + "\'");
            closeCon();
        }catch (Exception ex){
            closeCon();
        }
    }
    public void updateDobanda(String nume,String tip,double dob){
        try{
            double sumaI = getSuma(nume,tip);
            sumaI=sumaI+dob;
            Connect();
            st = con.createStatement();
            int res = st.executeUpdate("update bank.accounts set suma=\'" + String.valueOf(sumaI) + "\' where nume=\'" + nume + "\' and tip=\'" + tip + "\'");
            res = st.executeUpdate("update bank.accounts set dobanda=\'" + String.valueOf(dob) + "\' where nume=\'" + nume + "\' and tip=\'" + tip + "\'");
            closeCon();
        }catch (Exception ex){

        }
    }
    protected void CleanUp(){
        try{
            if (rez != null) {
                rez.close();
            }
            if (st != null) {
                st.close();
            }
        }catch (Exception ex){
            System.out.print("Error :"+ex);
        }
    }
    public void closeCon() {
        try {
            if (rez != null) {
                rez.close();
            }

            if (st != null) {
                st.close();
            }

            if (con != null) {
                con.close();
            }
        } catch (Exception e) {

        }
    }
}
