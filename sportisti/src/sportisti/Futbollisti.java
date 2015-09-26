package sportisti;

public class Futbollisti extends Sportisti {
    
    private String pozita;
    
    public Futbollisti(String e, int m, String p) throws SportistiException {
        super(e, m);
        
        if(p == null || p.trim().equals(""))
            throw new SportistiException("Pozite nuk mund te jete e zbrazet!");
        this.pozita = p;
    }
    
    public String getPozita(){
        return pozita;
    }
    
    @Override
    boolean perdoreDuart() {
        return false;
    }
    
    @Override
    public String toString(){
    
        return this.getClass().getName()+
                "-" + super.toString() + " - " + pozita;
    
    }
   
}
