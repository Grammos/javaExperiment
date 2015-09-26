package sportisti;

public class Bokseri extends Sportisti implements Individual {
    
    private String kategoria;
    private String rekordi;

    public Bokseri(String e, int m, String k, String r) throws SportistiException {
        super(e, m);
        
        if( k == null || k.trim().equals(""))
            throw new SportistiException("Kategoria eshte e zbrazet!");
        if( r == null || r.trim().equals(""))
            throw new SportistiException("Sportisti ka vlere te zbrazet!");
        this.kategoria = k;
        this.rekordi = r;
            
    }

    @Override
    boolean perdoreDuart() {
         return true;
    }
    
    public String getKategoria(){
        return kategoria;
    }
    
    @Override
    public String getRekordi(){
        return rekordi;
    }
    
    public String toString(){
            return this.getClass().getName()+
                    " - " + super.toString() + " - "
                    + kategoria + " -" + rekordi;
    }
    
    
  
}
