package bancaV3.accountables;

public class AbbonamentoSky implements Accountable{

    public static final double COSTO_INTR = 19;
    public static final double COSTO_CINEMA = 15;
    public static final double COSTO_SPORT = 15;
    public static final double COSTO_EVENTO = 5;
    private boolean hasIntrattenimento, hasSport, hasCinema;
    private int nEventi;
    
    public AbbonamentoSky(boolean hasIntrattenimento, boolean hasSport, boolean hasCinema) {
        this.hasIntrattenimento = hasIntrattenimento;
        this.hasSport = hasSport;
        this.hasCinema = hasCinema;
    }
    
    public void addEvento(){
        nEventi++;
    }
    
    @Override
    public double getImporto() {
        double costoReturn = 0;
        
        if(hasIntrattenimento){
            costoReturn += COSTO_INTR;
        }
        if(hasCinema){
            costoReturn += COSTO_CINEMA;
        }
        if(hasSport){
            costoReturn += COSTO_SPORT;
        }
        
        costoReturn += nEventi*COSTO_EVENTO;
        
        nEventi = 0;
        return -costoReturn;
    }
    
}
