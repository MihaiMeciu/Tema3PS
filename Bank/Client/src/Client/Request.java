package Client;

import Server.Tranzactii;


/**
 * Created by Devene on 5/1/2016.
 */
public class Request {
    public boolean requestTranz(Tranzactii tranz){
       return tranz.execute();
    }
}
