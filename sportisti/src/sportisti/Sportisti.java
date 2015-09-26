package sportisti;

public abstract class Sportisti {
    
    private String emri;
    private int mosha;
    
    public Sportisti(String e, int m) throws SportistiException{
        if(e == null || e.trim().equals(""))
            throw new SportistiException("Emri eshte i zbrazet!");
        if(m <= 0)
            throw new SportistiException("Mosha e nje sportisi nuk mund te jete negative ose 0!");
        this.emri = e;
        this.mosha = m;
      }
    
    public String getEmri(){
        return emri;
    }
    
    public void setEmri(String e) throws SportistiException{
        if(e == null || e.trim().equals(""))
            throw new SportistiException("Emri eshte i zbrazet!");
        this.emri = e;
    }
    
    public int getMosha(){
        return mosha;
    }
    
    public void setMosha(int m) throws SportistiException{
        if(m <= 0)
           throw new SportistiException("Mosha e nje sportisi nuk mund te jete negative ose 0!");
        this.mosha = m;
    }
    
    abstract boolean  perdoreDuart(); 
    
    @Override
    public String toString(){
        return emri + ": " + mosha;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Sportisti){
            Sportisti sp = (Sportisti)o;
            return sp.getEmri().equals(emri) && sp.getMosha() == getMosha();
        }
        return false;
    
    }
}
