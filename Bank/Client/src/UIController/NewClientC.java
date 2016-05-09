package UIController;

import Client.Request;
import Server.NewClientCommand;
import UI.NewClientUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 3/20/2016.
 */
public class NewClientC {
    private NewClientUI view;

    public NewClientC() {
        this.view = OptiuniC.newC;
        view.addAddListener(new AddListener());
        view.addBakcListener(new BackListener());
    }

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String owner = view.nume.getText();
            String adr = view.adr.getText();
            String tel = view.tel.getText();
            String tip = (String) view.tipCombo.getSelectedItem();
            double suma = Double.parseDouble(view.suma.getText());
            double com = Double.parseDouble(view.com.getText());
            double inte = Double.parseDouble(view.inte.getText());
            char[] pas = view.pass.getPassword();
            String pass = String.valueOf(pas);
            NewClientCommand oper;
            if(tip.equals("Activ")){
                oper = new NewClientCommand(owner, adr, tel, tip, suma, 0.0, -1.0, pass);
            }else if(tip.equals("Credit")){
                oper = new NewClientCommand(owner, adr, tel, tip, suma, com, inte, pass);
            }else{
                oper = new NewClientCommand(owner, adr, tel, tip, suma, 0.0, inte, pass);
            }
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
