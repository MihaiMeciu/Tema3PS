package UIController;

import Client.Request;
import Server.TransOutCommand;
import UI.TransferOutUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Devene on 3/20/2016.
 */
public class TransferOutC {
    private TransferOutUI view;
    private Session cont;

    public TransferOutC(Session session) {
        this.view = OptiuniC.trO;
        view.addTransListener(new TransListener());
        view.addBackListener(new BackListener());
        this.cont = session;
        view.numeC.setText(cont.getNume());
        view.numeC.setEditable(false);
    }

    class TransListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String tipS = (String)view.contS.getSelectedItem();
            String tipD = (String)view.contD.getSelectedItem();
            String detalii = view.detTA.getText();
            double suma = Double.parseDouble(view.sumaD.getText());
            String nume = view.numeD.getText();
            TransOutCommand oper = new TransOutCommand(cont.getNume(),nume,suma,tipS,tipD,detalii);
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
