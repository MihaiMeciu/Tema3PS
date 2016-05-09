package UIController;

import Client.Request;
import Logic.User;
import Server.NewOperatorCommand;
import UI.NewOperatorUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 3/20/2016.
 */
public class NewOperatorC {
    private NewOperatorUI view;

    public NewOperatorC() {
        this.view = OptiuniC.newO;
        view.addAddListener(new AddListener());
        view.addBakcListener(new BackListener());
    }

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String owner = view.nume.getText();
            String adr = view.adr.getText();
            String tel = view.tel.getText();
            char[] pas = view.pass.getPassword();
            String pass = String.valueOf(pas);
            NewOperatorCommand oper = new NewOperatorCommand(owner,adr,tel,pass);
            Request comm = new Request();
            boolean access = comm.requestTranz(oper);
        }
    }

    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            LoginC.op.show();
            view.hide();
        }
    }
}
