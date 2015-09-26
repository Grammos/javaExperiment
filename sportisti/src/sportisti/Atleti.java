package sportisti;


public class Atleti extends Sportisti{
    
    private int nrMedaljeve;

    public Atleti(String e, int m, int nrM) throws SportistiException {
        super(e, m);
        
        if(nrM < 0)
            throw new SportistiException("Medaljet nuk mund te jene negative");
        
        this.nrMedaljeve = nrM;
    }
    
    public int getNrMedaljeve(){
        return nrMedaljeve;
    }
   
   
    @Override
    public String toString(){
    
        return this.getClass().getName() + "->"
                 + super.toString() + "-"+nrMedaljeve;
    }

    @Override
    boolean perdoreDuart() {
        return true;
    }

  
}
