package bancaV2;

public interface Conto {

	double getSaldo();

	boolean operazione(double amount);

	boolean addAccountable(Accountable acc);

	boolean fineMese();

	String getIban();
        
        String printDetails();

}