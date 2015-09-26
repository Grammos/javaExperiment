
package personi;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Kompania {
    private String emri;
    private ArrayList<Punetori>punetoret;
    
    public Kompania(String e)throws PersoniException{
        
        if(e == null || e.trim().isEmpty())
            throw new PersoniException("Emri nuk mund te jete i zbrazet!");
        emri = e;
        punetoret = new ArrayList<>();   
    }
    
    public void shtoPunetorin(Punetori p)throws PersoniException{
        if(p == null)
            throw new PersoniException("Personi i painicializuar!");
        if(punetoret.contains(p))
            throw new PersoniException("Personi ekziston!");
        punetoret.add(p);    
    }
    /*
    b. Ofroni metodën shfleto(String profesioni) që shfleton/afishon vetëm punëtorët që kanë profesionin (profesioni) 
    
    */
    public void shfleto(){
        for(Punetori p: punetoret){
            if(p.getProfesioni().equals("profesioni"))
                System.out.println(p);
        }
    }
    
    /*
    c. Ofroni metodën kthePunetorinMeTeVjeter() që kthen punëtorin më të vjetër të kompanisë 
    
    */
    public Punetori kthePunetorinMeTeVjeter(){
        Punetori res = null;
        for(Punetori p : punetoret){
            if(res == null || res.getVitiLindjes() > res.getVitiLindjes())
                res = p;    
        }
        return res;    
    }
    
    /*
        d. Klasa Kompania ka edhe metodën main ku do të krijohet Kompania me emrin “ABC”. Të krijohen edhe disa punëtorë dhe të 
    ruhen në ArrayList. 
    Po ashtu të testohet nëse ekziston ose jo ndonjë punëtorë i dhënë, si dhe të tregohet sa është numri 
    i punëtorëve në Kompaninë “ABC” 
    */
    public static void main(String [] args){
        try {
            Kompania k = new Kompania("ABC");
            //k.shtoPunetorin(new Punetori("Punetori 1", 1990, 'M', "profesioni", 1000));
            //k.shtoPunetorin(new Punetori("Punetori 2 ", 1980, 'M', "profesioni", 1001));
            k.shtoPunetorin(new Punetori("Punetori 3 ", 1970, 'F', "drejtor", 1002));
            //k.shtoPunetorin(new Punetori("Punetori 4 ", 1960, 'M', "profesioni", 1003));
            k.shfleto();
            
            System.out.println(k.kthePunetorinMeTeVjeter());
        } catch (PersoniException ep) {
            ep.printStackTrace();
            
        }
       
    
    
    
    }
    
    
    
}
