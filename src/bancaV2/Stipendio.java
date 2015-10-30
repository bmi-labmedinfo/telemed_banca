package bancaV2;

public class Stipendio implements Accountable{

    private double cifraBase, cifraReale;
    private final double COSTO_ORA = 15;
    

    public Stipendio(double cifraBase) {
        this.cifraBase = cifraBase;
        this.cifraReale = cifraBase;
    }
    
    public void addStraordinario(int oreStr){
        cifraReale += COSTO_ORA*oreStr;
    }
    
    @Override
    public double getImporto() {
        double cifraReturn = cifraReale;
        cifraReale = cifraBase;
        return cifraReturn;
    }
    
}
