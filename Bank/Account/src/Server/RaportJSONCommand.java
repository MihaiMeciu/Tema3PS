package Server;

import Logic.Raport;
import Logic.RaportFactory;

/**
 * Created by Devene on 5/3/2016.
 */
public class RaportJSONCommand implements Tranzactii {
    private String nume;
    private String begin;
    private String end;
    RaportFactory fabrica = new RaportFactory();
    public RaportJSONCommand(String nume,String begin,String end){
        this.nume = nume;
        this.begin = begin;
        this.end = end;
    }
    public boolean execute(){
        if(!nume.equals("")){
            if(begin.contains("-")){
                if(end.contains("-")){
                    Raport rap = fabrica.getRaport("JSON",nume,begin,end);
                    rap.generate("D:\\Proiecte\\Tema2Ps\\rap.json");
                }
            }
        }
        return true;
    }
}
