package personi;

public abstract class Personi {
    
    private String emri;
    private int vitiLindjes;
    private char gjinia;
    
    public Personi(String e, int vL, char gj) throws PersoniException{
       
        if(e == null || e.trim().equals(""))
            throw new PersoniException("Emri nuk mund te jete i zbrazet!");
        if(vL < 0)
            throw new PersoniException("Viti i lindjes nuk mund te jete negativ!");
        if( gj!= 'M' && gj!= 'F')
            throw new PersoniException("Gjinia duhet te jete mashkull ose femer jo dicka tjeter!");     
        emri = e;
        vitiLindjes = vL;
        gjinia = gj;  
    }
    
    public String getEmri(){
        return emri;
    }
    
    public int getVitiLindjes(){
        return vitiLindjes;
    }
    
    public char getGjinia(){
        return gjinia;
    }
    
    public void setEmri(String e)throws PersoniException{
          if(e == null || e.trim().equals(""))
            throw new PersoniException("Emri nuk mund te jete i zbrazet!");
          emri = e;
        
    }
    
    public void setGjinia(char gj)throws PersoniException{
          if( gj!= 'M' && gj!= 'F')
            throw new PersoniException("Gjinia duhet te jete mashkull ose femer jo dicka tjeter!");  
          gjinia = gj;
      
    }
    
    public void setVitiLindjes(int vL) throws PersoniException{
        if(vL < 0)
            throw new PersoniException("Viti i lindjes nuk mund te jete negativ!");
        vitiLindjes = vL;
    
    }
    
}
