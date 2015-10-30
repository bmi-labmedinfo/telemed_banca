package bancaV2.conti;

import bancaV2.conti.AbstractConto;

public class ContoDeposito extends AbstractConto {

    public ContoDeposito(double saldo, String iban, String cf) {
        super(ContoType.DEPOSITO, iban, cf, 0.0);
    }

    @Override
    public boolean operazione(double amount) {
        if (amount >= 0) {
            return updateSaldo(amount);
        } else {
            return false; //cannot pull money out of a conto which is "deposito"
        }
    }
}
