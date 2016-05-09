package UIController;

import Client.Request;
import Server.ViewCommand;
import UI.ViewUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 3/20/2016.
 */
public class ViewC {
    private ViewUI view;

    public ViewC() {
        this.view = OptiuniC.det;
        view.addSaveListener(new SaveListener());
        view.addBackListener(new BackListener());
        view.addSearchListener(new SearchListner());
    }

    class SaveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nume = view.nume.getText();
            String adr = view.adr.getText();
            String tel = view.tel.getText();
            char[] pasV = view.passV.getPassword();
            char[] pasN1 = view.passN1.getPassword();
            char[] pasN2 = view.passN2.getPassword();
            String passV = String.valueOf(pasV);
            String passN1 = String.valueOf(pasN1);
            String passN2 = String.valueOf(pasN2);
            ViewCommand oper = new ViewCommand(nume,adr,tel,passV,passN1,passN2);
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
    class SearchListner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nume = view.nume.getText();
            ViewCommand oper = new ViewCommand();
            String session = oper.getSession(nume);
            if(!session.equals("No account found!")) {
                String[] val = session.split(",");
                view.adr.setText(val[0]);
                view.tel.setText(val[1]);
                view.nume.setText(val[2]);
            }
        }
    }
}
