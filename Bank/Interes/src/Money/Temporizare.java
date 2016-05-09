package Money;

import Money.Dobanda;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Devene on 5/5/2016.
 */
public class Temporizare {
    private int ore;
    private Dobanda bani;
    public Temporizare(int ore){
        this.ore = ore;
        bani = new Dobanda();
    }
    public void timp(){
        Timer crono = new Timer();
        crono.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                bani.updateDobanda();
            }
        },ore*3600*1000,ore*3600*1000);
    }
}
