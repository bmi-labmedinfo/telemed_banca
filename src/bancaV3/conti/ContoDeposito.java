package bancaV3.conti;

import bancaV3.exceptions.InvalidOperationException;
import bancaV3.accountables.Accountable;
import bancaV3.ContoType;
import bancaV3.conti.ContoCorrente;

public class ContoDeposito extends ContoCorrente {

    public ContoDeposito(String iban, String cf, double saldo) {
        super(iban, cf, 0.0);
    }

    /**
     *
     * @param amount
     * @return
     */
    @Override
    public boolean operazione(double amount){
        if (amount > 0) {
            return super.operazione(amount);
        } else {
            throw new InvalidOperationException();
        }
    }

    @Override
    public boolean addAccountable(Accountable acc) {
        if(acc.getImporto()<0)
            throw new InvalidOperationException("Accountable not allowed for this account.");
        else super.addAccountable(acc);
        return true;
    }

}
