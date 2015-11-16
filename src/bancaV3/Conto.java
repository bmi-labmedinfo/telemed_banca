package bancaV3;

import bancaV3.accountables.Accountable;
import bancaV3.exceptions.InvalidOperationException;

public interface Conto {

	double getSaldo();

	boolean operazione(double amount);

	boolean addAccountable(Accountable acc);

	boolean fineMese();

	String getIban();
        
        String printDetails();

}