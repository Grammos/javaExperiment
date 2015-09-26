package personi;


public class Punetori extends Personi implements Punon {
    
    private int id;
    private String profesioni;
    
    public Punetori(String e, int vL, char gj, String p, int i)throws PersoniException{
        super(e, vL, gj);
         if(p == null || p.trim().equals(""))
            throw new PersoniException("Profesioni nuk mund te jete i zbrazet!");
        if(i < 0)
            throw new PersoniException("ID nuk mund te jete negativ!");
        
        profesioni = p;
        id = i;
        
    }
    
    public int getId(){
         return id;      
    }
    
   @Override
    public String getProfesioni() {
         return profesioni;  
    }
    
    public void setProfesioni(String p) throws PersoniException{
         if(p == null || p.trim().equals(""))
            throw new PersoniException("Profesioni nuk mund te jete i zbrazet!");
         profesioni = p;   
    }
    
    public String toString(){
       return id + ":" + getEmri() + "" + profesioni + "" + getGjinia(); 
    
    }
    
    public boolean equals(Object o){
        if(o instanceof Punetori){
            return id == ((Punetori)o).getId();
        }
        return false;   
    
    }
    
    
    

   
    
}
