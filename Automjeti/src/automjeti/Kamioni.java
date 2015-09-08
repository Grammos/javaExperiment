package automjeti;


public class Kamioni extends Automjeti implements Vozitet{
    
    private double kapaciteti;

    public Kamioni(String m, int mSh, int sh, boolean nd, double k) throws AutomjetiException {
        super(m, mSh, sh, nd);
        if(k < 0.2)
            throw new AutomjetiException("Kamioni nuk mund te kete tonazh negative!");
        this.kapaciteti = k;
    }
    
    public double getKapaciteti(){
        return kapaciteti;
    }
    

    @Override
    public void shpejto(int km_h) throws AutomjetiException {
        if(getShpejtesia() + km_h > getMaksShpejtesia())
            setShpejtesia(getMaksShpejtesia());
        else
            setShpejtesia(getShpejtesia() + km_h);
    }

    @Override
    public void ngadalso(int km_h) throws AutomjetiException {
        if(getShpejtesia() - km_h < 0)
            setShpejtesia(0);
        else
            setShpejtesia(getShpejtesia() - km_h);       
    }

    @Override
    public void ndeze() {
       System.out.println("Kamioni eshte ndezur!");
    }

    @Override
    public void fike() {
        System.out.println("Kamioni eshte fikur");
    }
    
}
