package sportisti;

public class Vrapuesi extends Atleti implements Individual {
    
    private int distanca;
    private String rekordi;
    

    public Vrapuesi(String e, int m, int nrM, int d, String r) throws SportistiException {
        super(e, m, nrM);
        
        if(d <= 0 )
            throw new SportistiException("Distanca jo vlere negative dhe zero!");
        if(r==null|| r.trim().equals(""))
			throw new SportistiException("Rekord nuk mund te jete i zbrazt, apo i pa inicializuar");
        this.distanca = d;
        this.rekordi = r;
    }
    
   
    @Override
    boolean perdoreDuart(){
        return false;
    }
    

    @Override
    public String getRekordi() {
       return rekordi;
    }
    
    public int getDistanca(){
        return distanca;
    }
    
    @Override
    public String toString(){
	return super.toString() + " - distanca:" + distanca + " rekordi:" + rekordi; 
    }   
}
