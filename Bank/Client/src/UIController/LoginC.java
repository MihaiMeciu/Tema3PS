package UIController;

import Client.Request;
import Logic.User;
import Server.LoginCommand;
import UI.LoginUI;
import UI.OptionUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 3/20/2016.
 */
public class LoginC {

    private LoginUI view;
    public static OptionUI op;

    public LoginC() {
        this.view = Main.view;
        view.addSubmitListener(new LoginListener());
    }

    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nume = view.user.getText();
            char[] pas = view.pass.getPassword();
            String pass = String.valueOf(pas);
            LoginCommand login = new LoginCommand(nume,pass);
            Request comm = new Request();
            boolean access = comm.requestTranz(login);
            if(access==true){
                String cont = login.getSession();
                String[] val = cont.split(",");
                Session  client = new Session(val[0],val[1]);
                view.hide();
                if(op==null) {
                    op = new OptionUI(client.getTip());
                }else{
                    op.show();
                }
                OptiuniC opC = new OptiuniC(client);
            }
        }
    }
}
