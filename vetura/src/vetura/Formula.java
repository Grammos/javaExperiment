package vetura;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Formula extends VeturaGaruese implements Gara, Runnable{

    public Formula(int vP, String m, int pS) throws GaraException {
        super(vP, m, pS);
        if(2014 - vP > 3)
            throw new GaraException("Formula eshte e vjeter!");
    }

    @Override
    public void gara() {
        distanca += 100;
        System.out.print(getClass().getName() + "" + modeli + "garoi" + distanca + "metra");
    }

    @Override
    public void run() {
      //An instance of this class is used to generate a stream of pseudorandom numbers. The class uses a 48-bit seed, 
        //which is modified using a linear congruential formula. (See Donald Knuth, The Art of Computer Programming, Volume 2, Section 3.2.1.)
        Random r = new Random();
        while(distanca < 5000){
        gara();
            try {
                /**
                 * 
                 * The nextInt(int n) method is used to get a pseudorandom, uniformly 
                 * distributed int value between 0 (inclusive) and the specified value (exclusive), 
                 * drawn from this random number generator's sequence.
                 * */
                Thread.sleep(r.nextInt(2000));
            } catch (InterruptedException ex) {
               ex.printStackTrace();
            }  
        }    
    }
    
    


}
