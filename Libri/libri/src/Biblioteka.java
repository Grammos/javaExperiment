import libri.*;
import java.io.*;

public class Biblioteka {
    
    private String emri;
    private Libri[] librat;
    private int index = 0;
    
    private String fileOut = null;
    private FileWriter fw = null;
    private String fileIn = null;
    private FileReader fr = null;
    private BufferedReader br = null;
    
    public Biblioteka(String e, int nrLibrave, String fOut)throws LibriException, IOException{
        
        if(e == null || e.trim().equals(""))
            throw new LibriException("Emri i bibliotekes nuk mund te jete i zbrazet!");
        if(nrLibrave < 50)
            throw new LibriException("Numri i librave duhet te jete se paku 50! ");
        if(fOut == null || fOut.trim().endsWith(""))
            throw new IOException("Emri i output file-it nuk mund te jete i zbrazet!");
        emri = e;
        librat = new Libri[nrLibrave];
        fileOut = fOut;
        fw = new FileWriter(fileOut);       
    }
    
    public boolean ekziston (Libri l) throws LibriException{
        
        if( l == null)
            throw new LibriException("Libri nuk eshte e inicializuar!");
        for(int i = 0; i < index; i++){
                if(librat[i].equals(l))
                    return true;
        }
        return false;
    }
    
    public void shtoLibrin (Libri l) throws LibriException{
        if(l == null)
            throw new LibriException("Libri nuk eshte inicializur!");
        if(index == librat.length)
            throw new LibriException("Nuk ka vend ne varg!");
        if(ekziston(l))
            throw new LibriException("Libri ekziston ne varg!");
        librat[index++]=l;
    }
    
    public void lexoLibrat(String fileIn) throws LibriException, IOException, NumberFormatException{
        if(fileIn == null || fileIn.trim().equals(""))
            throw new LibriException("Emri i input file-it nuk mund te jete i zbrazet!");
        this.fileIn = fileIn;
        fr = new FileReader(fileIn);
        br = new BufferedReader(fr);
        String line = null;
        Libri l = null;
        while((line = br.readLine()) != null){
            String[] libri = line.split(";");
            if(libri.length < 5)
                throw new IOException("Numri i parametrave hyres nuk eshte ne rregull!");
            String lloji = libri[0];
            int isbn = Integer.parseInt(libri[1]);
            String titulli = libri[2];
            int vitiPublikimit = Integer.parseInt(libri[3]);
            if(lloji.equals("LibriShkollor")){
                String drejtimi = libri[4];
                l = new LibriShkollor(isbn, titulli, vitiPublikimit, drejtimi);
            }
            else if(lloji.equals("Enciklopedia")){
                int nrAutoreve = Integer.parseInt(libri[4]);
                l = new Enciklopedia(isbn, titulli, vitiPublikimit, nrAutoreve);
            }
            else 
                throw new IOException("Libri duhet te jete ose Liber Shkollor ose Enciklopedi!");
            shtoLibrin(l);
                        
            }
        
          }
    
    public LibriShkollor firstDrejtimi(String d)throws LibriException{
		if(index == 0)
			throw new LibriException("Nuk ka asnje liber ne varg!");
		for(int i = 0;  i < index; i++){
			if(librat[i] instanceof LibriShkollor){
				LibriShkollor l = (LibriShkollor)librat[i];
				if(l.getDrejtimi().equals(d))
					return l;
			}
		}
		System.out.println("Nuk ka asnje Liber Shkollor me kete drejtim: "  + d);
		return null;
	}
    public Enciklopedia maxNumriAutoreve() throws LibriException{
        if(index == 0)
            throw new LibriException("Nuk ka asnje liber ne varg!");
        Enciklopedia temp = null;
        for(int i = 0; i < index; i++){
            if(librat[i] instanceof Enciklopedia){
                Enciklopedia e = (Enciklopedia)librat[i];
                if(temp == null || temp.getNrAutoreve() <= e.getNrAutoreve())
                    temp = e;
            
            }
        }
        if(temp == null)
            System.out.println("Nuk ka asnje Enciklopedi ne varg!");
        
        return temp;
        
        }
    
    public void shkruajLibrat() throws IOException{
        if(index == 0)
            shkruaj("Nuk ka asnje liber ne varg!");
        for(int i = 0; i < index; i++){
            shkruaj(librat[i].toString());
            if(i < index - 1)
                shkruaj("\n");
        }      
    }
    
    public void shkruaj(String s) throws IOException{
        fw.write(s);
        fw.flush();      
    }
    
    public void closeResources(){
        try{
            
            if(fr != null)
                fr.close();
            if(fw != null)
                fw.close();
        }
        catch(IOException ioe){}   
    }
    
    public static void main(String [] args){
        Biblioteka b = null; 
        try{
                b = new Biblioteka("UBT Library", 50, "biblioteka.out");
                b.lexoLibrat("libri.in");
                b.shkruaj("Librat qe gjenden ne biblioteke:");
                b.shkruaj("\n");
                b.shkruajLibrat();
                b.shkruaj("\n");
                b.shkruaj("\n");
                b.shkruaj("Libri i fundit me numrin me te madh te autoreve:");
		b.shkruaj("\n" + b.maxNumriAutoreve());
		b.shkruaj("\n");
		b.shkruaj("\n");
		b.shkruaj("Librii pare me drejtimin SHKI 1:");
		b.shkruaj("\n" + b.firstDrejtimi("SHKI 1"));
     
        }
        catch(LibriException | IOException |  NumberFormatException lioe){
            lioe.printStackTrace();
        
        }
        finally{
                    if(b != null)
                        b.closeResources();	
        }
   
    
        }
        
    
    }
    
        
        
 
    
   
