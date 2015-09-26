package sportisti;

public class Basketbollisti extends Sportisti{
    
    private double gjatesia;

    public Basketbollisti(String e, int m, double gj) throws SportistiException {
        super(e, m);
        
        if(gj<=0)
            throw new SportistiException("Gjatesia nuk mund te jete zero ose edhe - ");
        this.gjatesia = gj;
    }
    
    public double getGjatesia(){
        return gjatesia;
    }
    
    @Override
    boolean perdoreDuart() {
        return true;
    }
    
    @Override
    public String toString(){
    
        return this.getClass().getName()+ "-" +
                super.toString()+ "- " + gjatesia;
    
    }
    
}
