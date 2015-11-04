package bancaV2.conti;

import bancaV2.ContoType;
import bancaV2.conti.AbstractConto;

public class ContoDeposito extends AbstractConto {

    public ContoDeposito(String iban, String cf, double saldo) {
        super(iban, cf, 0.0);
    }

    @Override
    public boolean operazione(double amount) {
        if (amount > 0) {
            return super.operazione(amount);
        } else {
            return false;
        }
    }

}
