package automjeti;


public abstract class  Automjeti {
    
    private String modeli; //readable
    private int maksShpejtesia; //readable
    private int shpejtesia;
    private boolean ndezur;
    
    public Automjeti(String m, int mSh, int sh, boolean nd)throws AutomjetiException
    {
            if(m == null || m.trim().equals(""))
                throw new AutomjetiException("Modeli nuk mund te jete i zbrazet!");
            if(mSh < 0)
                throw new AutomjetiException("Shpejtesia maks nuk mund te jete negative!");
            if(sh < 0 || sh > mSh)
                throw new AutomjetiException("Shpejtesia duhet te jete pozitive dhe me e vogel+"
                        + "se shpejtesia maksimale !");
            
                modeli = m;
                maksShpejtesia = mSh;
                shpejtesia = sh;
                ndezur = nd;
    }
    
    public String getModeli()
    {
        return modeli;
    }
    
    public int getMaksShpejtesia()
    {
        return maksShpejtesia;
    }
    
    public void setShpejtesia(int sh)throws AutomjetiException
    {
         if(sh < 0 || sh > getMaksShpejtesia())
                throw new AutomjetiException("Shpejtesia duhet te jete pozitive dhe me e vogel+"
                        + "se shpejtesia maksimale !");
         shpejtesia = sh;
    
    }
    
    public int getShpejtesia()
    {
       return shpejtesia;
    }
    
    public boolean getNdezur()
    {
        return ndezur;
    }
    
    public void setNdezur(boolean nd)
    {
        ndezur = nd;
    }
    
    public abstract void shpejto(int km_h) throws AutomjetiException;
    
    public abstract void ngadalso(int km_h) throws AutomjetiException;
    
    public String toString(){
        
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append(" -> ");
        sb.append("modeli:");
        sb.append(modeli);
        sb.append("\n");
             
        sb.append(shpejtesia);
        sb.append(":");
        sb.append(" ndezur/fikur?");
        sb.append(ndezur);
        return sb.toString();
    
    }
    
}
