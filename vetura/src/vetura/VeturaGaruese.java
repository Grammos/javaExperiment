
package vetura;

public abstract class VeturaGaruese {
    
    protected int vitiProdhimit;
    protected String modeli;
    protected int pozitaStartuese;
    protected int distanca = 0;
    
    VeturaGaruese(int vP, String m, int pS) throws GaraException {
        if(vP < 1950)
            throw new GaraException("Vetura shume e vjeter!");
       if(m == null || m.trim().isEmpty())
            throw new GaraException("Modeli nuk mund te jete i zbrazet.");
        if(pS < 0)
           throw new GaraException("Pozita nuk mund te jete negative");
        
        vitiProdhimit = vP;
        modeli = m;
        pozitaStartuese = pS;
    
    }
    
    public int getVitiProdhimit(){
        return vitiProdhimit;
    }
    
    public String getModeli(){
        return modeli;
    }
    
    public int getPozitaStartuese(){
        return pozitaStartuese;
    }
    
    public boolean equals(Object o){
        if(o instanceof VeturaGaruese)
            return ((VeturaGaruese)o).getModeli().equals(modeli);
        return false;
    }
    
    
    
}
