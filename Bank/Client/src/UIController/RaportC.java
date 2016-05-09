package UIController;

import Client.Request;
import Server.RaportJSONCommand;
import Server.RaportXMLCommand;
import UI.RaportUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Devene on 3/20/2016.
 */
public class RaportC {
    private RaportUI view;
    public RaportC(){
        this.view = OptiuniC.rap;
        view.addBackListener(new BackListener());
        view.addXMLListener(new XMLListener());
        view.addJSONListener(new JSONListener());
    }

    class BackListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            LoginC.op.show();
            view.hide();
        }
    }
    class XMLListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String nume = view.oper.getText();
            String begin = view.begin.getText();
            String end = view.end.getText();
            RaportXMLCommand oper = new RaportXMLCommand(nume,begin,end);
            Request comm = new Request();
            boolean access = comm.requestTranz(oper);
        }
    }
    class JSONListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String nume = view.oper.getText();
            String begin = view.begin.getText();
            String end = view.end.getText();
            RaportJSONCommand oper = new RaportJSONCommand(nume,begin,end);
            Request comm = new Request();
            boolean access = comm.requestTranz(oper);
        }
    }
}
