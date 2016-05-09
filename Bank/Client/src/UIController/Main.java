package UIController;

import Money.Temporizare;
import UI.LoginUI;

/**
 * Created by Devene on 3/23/2016.
 */
public class Main {
    public static LoginUI view;
    private static Temporizare timp;
    public static void main(String[] args){
        timp = new Temporizare(24);
        timp.timp();
        view = new LoginUI();
        LoginC cont = new LoginC();
    }
}
