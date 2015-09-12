package libri;

public class Enciklopedia extends Libri{
    
    private int nrAutoreve;
    
    public Enciklopedia(int i, String t, int vP, int nA) throws LibriException{
        super(i, t, vP);
        if(nA <= 0)
			throw new LibriException("Numri i autoreve duhet te jete pozitiv!");
		nrAutoreve = nA;
    }
    
    @Override
    public boolean kaDetyra() {
        return false;
    }
    
    public int getNrAutoreve(){ return nrAutoreve; }
	
	public void setNrAutoreve(int nA)throws LibriException{
		if(nA <= 0)
			throw new LibriException("Numri i autoreve duhet te jete pozitiv!");
		nrAutoreve = nA;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Enciklopedia ");
		sb.append(super.toString());
		sb.append(" ka ");
		sb.append(nrAutoreve);
		sb.append(" autore");
		return sb.toString();  //"Enciklopedia " + super.toString() + " ka " + nrAutoreve + " autore";
	}
   
    
}
