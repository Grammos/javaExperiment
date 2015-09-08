import automjeti.*;

public class Automjetet {
    
    private Automjeti[] automjetet;
    private int index = 0;
    
    public Automjetet(int n) throws AutomjetiException
    {
            if(n < 1)
                throw new AutomjetiException("Numri i automjeteve duhete te jete me"
                        + "i madh se 0");
        
            automjetet = new Automjeti[n];
    
    }
    
    public void addAutomjeti(Automjeti a) throws AutomjetiException
    {
        if (a == null)
            throw new AutomjetiException("Automjeti nuk eshte inicializuar!");
        if(index == automjetet.length)
            throw new AutomjetiException("Nuk ka vend ne varg!");
        
        automjetet [index++] = a;
    }
    
    public void automjetetENdezura()
    {
        for(int i = 0; i< index; i++){
            if(automjetet[i].getNdezur())
                System.out.println(automjetet[i]);
            super.toString();
        }
            
    }
    
    public static void main(String [] args)
    {
        try{
            Automjetet a = new Automjetet(6);
            a.addAutomjeti(new Automobili("BMW", 300, 0, true, 2));
            a.addAutomjeti(new Automobili("Golf", 280, 10, true, 4));
            a.addAutomjeti(new Kamioni("Mercedes", 200, 0, true, 4));
            a.addAutomjeti(new Kamioni("Bllah", 150, 0, true, 3));
            
            a.automjetetENdezura();
         
            
                                  
        
        }catch(AutomjetiException ae){
            
            ae.printStackTrace();
        
        }
         
    
    
    }
    
    
    
}
