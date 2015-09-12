package libri;

public class LibriShkollor extends Libri {
    
    private String drejtimi;
    
    public LibriShkollor(int i, String t, int vP, String d) throws LibriException{
        super(i, t, vP);
        
        if(d == null || d.trim().equals(""))
            throw new LibriException("Drejtimi duhet te kete nje emer dhe jo te jete i zbarazet!");
        drejtimi = d;  
    }

   
    public String getDrejtimi(){
        return drejtimi;
    }
    
    public void setDrejtimi(String d) throws LibriException{
        if(d == null || d.trim().equals(""))
            throw new LibriException("Drejtimi duhete te kete nje emer dhe jo te jete i zbrazet!");
        drejtimi = d;
    }
    
    @Override
    public boolean kaDetyra() {
        return true;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Libri Shkollor");
        sb.append(super.toString());
        sb.append(" : ");
        sb.append(drejtimi);
        return sb.toString();
    }
    
  
    
}
