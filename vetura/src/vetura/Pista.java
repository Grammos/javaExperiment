package vetura;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 IV. Krijoni klasën Pista që ka metodën main, ku do të krijoni një ArrayList ku do t’i shtoni dy instanca të 
 * Formula (Thread) dhe dy instanca të NASCAR (Thread) nese veq nuk ekzistojnë në listë 
 * (Dy VeturaGaruese janë të njeta nese e kanë modelin e njejtë), 
 * e pastaj të përshkohet vargu dhe të filloi gara (starto thread‐ët). T’i jepet përparësi instancave të NASCAR.
 */
public class Pista {
    
    ArrayList<VeturaGaruese> veturat;
    
    public Pista(){
        veturat = new ArrayList<>();     
    }
    
    public void shtoVetura(VeturaGaruese v) throws GaraException{
        if(v == null){
            throw new GaraException("Vetura e painicializuar!");
        }
        if(veturat.contains(v)){
            throw new GaraException("Kjo veture ekziston ne list!");
        }
        veturat.add(v);
    }
    
    public void startoThreadet(){ 
        for(VeturaGaruese v : veturat){
            Thread t = new Thread((Runnable)v);
            if(v instanceof Nascar)
                t.setPriority(Thread.MAX_PRIORITY);
            t.start();
        }
    }
    
    public static void main(String [] args){
    
        
        try {
            Pista p = new Pista();
            p.shtoVetura(new Formula(2012, "Ferrari", 1));
            p.shtoVetura(new Formula(2013, "Mercedes", 2));
            p.shtoVetura(new Nascar(2014, "Nascar 1", 3));
            p.shtoVetura(new Nascar(2010, "Nascar 2", 4));
            p.startoThreadet();
            
        } catch (GaraException ex) {
            ex.printStackTrace();
        }
        
    
    
    
    
    }
    
    
    
 
}