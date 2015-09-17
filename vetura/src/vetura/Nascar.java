package vetura;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Nascar extends VeturaGaruese implements Gara, Runnable{

    public Nascar(int vP, String m, int pS) throws GaraException {
        super(vP, m, pS);
        if(2014 - vP > 5)
            throw new GaraException("");
    }

    @Override
    public void gara() {
        distanca += 100;
        System.out.println(getClass().getName() + "" + modeli + "garoi" + distanca + "metra");
      
    }

    @Override
    public void run() {
       Random r = new Random();
       while( distanca < 500){
           gara();
           
           try {
               Thread.sleep(r.nextInt(2000));
               
           } catch (InterruptedException ex) {
               ex.printStackTrace();
           }
           
            
       
       
       }
    }
    
}
