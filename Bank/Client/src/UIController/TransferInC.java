package UIController;

import Client.Request;
import Server.TransInCommand;
import UI.TransferInUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 3/20/2016.
 */
public class TransferInC {
    private TransferInUI view;
    private Session cont;

    public TransferInC(Session session) {
        this.view = OptiuniC.trI;
        view.addTransListener(new TransListener());
        view.addBackListener(new BackListener());
        this.cont = session;
    }

    class TransListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double suma = Double.parseDouble(view.sumaC.getText());
            String tipS = (String)view.contS.getSelectedItem();
            String tipD = (String)view.contD.getSelectedItem();
            String detalii = view.detTA.getText();
            TransInCommand oper = new TransInCommand(cont.getNume(),suma,tipS,tipD,detalii);
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
