package sportisti;
import java.util.*;

public class Olimpiada {
    
    ArrayList <Sportisti> sportistet;
    
    public Olimpiada(){
        sportistet = new ArrayList<Sportisti>();
    }
    
    public void shtoSportistin(Sportisti s) throws SportistiException{
        
        if(s == null)
            throw new SportistiException("Nuk eshte inicializuar!");
        if(sportistet.contains(s))
            throw new SportistiException("Sportisti gjenden ne ArrayList!");
        sportistet.add(s);
 
    }
    
    public void shtonjeSportist(final String e, final int m) throws SportistiException{
        
        shtoSportistin(new Sportisti(e,m){
            @Override
            public boolean perdoreDuart(){
                return true;
            }
        });
    }
    
   /*
    public void shtoNotues e cila shton nje notues ne ArrayList:
        o Notuesi eshte Atlet dhe implementon Individual. Ka edhe atributin
    (readonly)rekordi.
    */
    
    public void shtoNotues(final String e, final int m, final int nrM, final String rek) throws SportistiException{
        
        class Notuesi extends Atleti implements Individual{
            
            private String rekordi;
            
            public Notuesi(String em, int mo, int nrMe, String r)throws SportistiException{
                super(em, mo, nrMe);
                
                if( r ==null || r.trim().equals(""))
                    throw new SportistiException("r e pa inic ose zbrazt");
                this.rekordi = r;
            }
            
            @Override
            public  String getRekordi(){
                return rekordi;
            
            }
            
            @Override
            public String toString(){
                return super.toString() + "rekordi " + rekordi;
            }
            
            @Override
            public boolean perdoreDuart(){
                return true;    
            }
            
        }
        shtoSportistin(new Notuesi(e, m, nrM, rek));
    } 
    /**
     * 
     * public Iterator<Individual> rekordetIterator() e cila kthen nje instance te nje
        iteratori qe mundeson iterimin e instancave qe kane rekorde.
     *
     * @return  */
    public Iterator<Individual> rekordetIterator(){
        class RekordetIterator implements Iterator<Individual>{
            
            private int index = 0;
            
            @Override
            public boolean hasNext(){
                return index < sportistet.size();
            }
            
            @Override
            public Individual next(){
                Sportisti sp = sportistet.get(index++);
                
                if(sp instanceof Individual){
                    return (Individual)sp;
                }
                
                if(hasNext())
                    return next();
                return null;
            }
            /*
            Because the Iterator interface has a method called remove(),
            which you must implement in order to say that you have implemented 
            the Iterator interface.
            */
            
            @Override
            public void remove(){}
        }
    
        return new RekordetIterator();
    }
    
    /**
     * public Enumeration<Atleti> atletEnumerator kjo metode pranon ne konstruktor
    numrin e medaljeve dhe iteron vetem atletet qe kan me shum medalje.
     * 
     * */
    
    public Enumeration<Atleti> atletEnumerator(final int nrM){
        return new Enumeration<Atleti>(){
                private int index = 0;
                public boolean hasMoreElements(){
                    return index < sportistet.size();
                }
                public Atleti nextElement(){
                        Sportisti sp = sportistet.get(index++);
			if(sp instanceof Atleti && ((Atleti)sp).getNrMedaljeve() >  nrM)
				return (Atleti) sp;
			if(hasMoreElements())
				return nextElement();
				
			return null;
                    
                }
        };
    
    }
    /*
       Ofroni metodën main () ku do të krijoni një instancë të klasës Olimpiada, ku do t’i shtoni 2
        instanca të seciles klasë si dhe te testohen te gjitha metodat. 
    */
    
    public void shfleto(){
		for(Sportisti sp: sportistet)
		{
			System.out.println(sp);
		}
    }
	
    public static void main(String [] args){
        
        try {
        Olimpiada olimp = new Olimpiada();
        
        olimp.shtoSportistin(new Futbollisti("Del Piero" , 40, "Sulmues"));
        olimp.shtoSportistin(new Vrapuesi("Bolt" , 23, 25, 100, "Kampion bote"));
	olimp.shtoSportistin(new Bokseri("Luani", 49, "Heavy Weight", "Kampion Europe"));
        olimp.shtoNotues("Notues ", 17, 16, "Kampion i fmive");
	olimp.shtonjeSportist("Sportisti1", 22);
	
        Iterator <Individual> iteratori = olimp.rekordetIterator();
			
	System.out.println("(Me Iterator) Rekordet e sportisteve:");
			
	while(iteratori.hasNext())
	{
            Individual ind = iteratori.next();
	    if(ind!= null)
            System.out.println(ind);
	}
			
		
			
	System.out.println("\n\n(Me Enumerator) Sportistet me me shum medalje se 20:");
	Enumeration <Atleti> enumerator = olimp.atletEnumerator(20);
			
	while(enumerator.hasMoreElements())
	{
		Atleti atleti = enumerator.nextElement();
		if(atleti!= null)
		System.out.println(atleti);
	}
			
	System.out.println("\n\nShfleto te gjithe:");
			olimp.shfleto();
        
        }catch(SportistiException se){
            se.printStackTrace();
        }
    
    }
            
   
}
