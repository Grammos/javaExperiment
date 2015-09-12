
package libri;

public abstract class Libri {
    
    private int isbn;
    private String titulli;
    private int vitiPublikimit;
    
    public Libri(int i, String t, int vP) throws LibriException{
    
        if(i < 0)
            throw new LibriException("Libri duhet te kete ISBN pozitive!");
        if(t == null || t.trim().equals(""))
            throw new LibriException("Libri duhet te kete nje titull!");
        if(vP < 0)
            throw new LibriException("Viti i publikimit duhet t'i perkete nje epoke se paku!");
        
        isbn = i;
        titulli = t;
        vitiPublikimit =  vP;
        
    }
    
    public int getIsbn(){
        return isbn;
    }
    
    public String getTitulli(){
        return titulli;
    }
    
    public void setTitulli(String t) throws LibriException{
        
        if(t == null || t.trim().equals(""))
            throw new LibriException("Libri duhet te kete nje titull!");
        
       titulli = t;
    
    }
    
    public int getVitiIPublikimit(){
        return vitiPublikimit;
    }
    
    public void setVitiIPublikimit(int vP) throws LibriException{ 
           if(vP < 0)
            throw new LibriException("Viti i publikimit duhet t'i perkete nje epoke se paku!");
           vitiPublikimit =  vP; 
    }
    
    public abstract boolean kaDetyra();
    
    public String toString(){
        
        StringBuilder sb = new StringBuilder();
        sb.append(isbn);
        sb.append(" : ");
        sb.append(titulli);
        sb.append(" - ");
        sb.append(vitiPublikimit);
        
        return sb.toString();
   
    }
    
    public boolean equals(Object o){
        if(o instanceof Libri)
        {
            return isbn == ((Libri)o).getIsbn();
        }
        return false;
    }
    
}
