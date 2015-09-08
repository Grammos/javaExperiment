package automjeti;


public class Automobili extends Automjeti implements Vozitet {
    
    private int nrIDyerve;

    public Automobili(String m, int mSh, int sh, boolean nd, int nrD) throws AutomjetiException {
        
        super(m, mSh, sh, nd); 
        if(nrD < 1)
            throw new AutomjetiException("Numri i dyerve duhet te jete me shume se 1!");
        nrIDyerve = nrD;
    }
    
    public int getNrIDyerve(){
        
        return nrIDyerve;
    }

    @Override
    public void shpejto(int km_h) throws AutomjetiException {
        
        if(getShpejtesia() + km_h > getMaksShpejtesia())  
            setShpejtesia(getMaksShpejtesia());  
        else
           setShpejtesia(getShpejtesia() + km_h);
     
    }

    @Override
    public void ngadalso(int km_h) throws AutomjetiException {
         if(getShpejtesia() - km_h < 0)
             setShpejtesia(0);
         else
             setShpejtesia(getShpejtesia() - km_h);
    }

    @Override
    public void ndeze() {
        System.out.println("Makina eshte e ndezur!");
    }

    @Override
    public void fike() {
         System.out.println("Makina eshte e fikur");
    }
    
    
}
