package UIController;

import Client.Request;
import Server.TransGenCommand;
import UI.TransferGenUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 3/20/2016.
 */
public class TransferGenC {
    private TransferGenUI view;

    public TransferGenC() {
        this.view = OptiuniC.trG;
        view.addTransListener(new TransListener());
        view.addBackListener(new BackListener());
    }

    class TransListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String numeS = view.numeC.getText();
            String numeD = view.numeD.getText();
            double suma = Double.parseDouble(view.sumaC.getText());
            String tipS = (String)view.contS.getSelectedItem();
            String tipD = (String)view.contD.getSelectedItem();
            String detalii = view.detTA.getText();
            TransGenCommand oper = new TransGenCommand(numeS,numeD,suma,tipS,tipD,detalii);
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
