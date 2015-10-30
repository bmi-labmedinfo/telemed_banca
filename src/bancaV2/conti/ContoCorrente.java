package bancaV2.conti;

import bancaV2.Accountable;

public class ContoCorrente extends AbstractConto {

    public ContoCorrente(double saldo, String iban, String cf) {
        super(ContoType.CORRENTE, iban, cf, 0.0);
    }

    @Override
    public boolean operazione(double amount) {
        return updateSaldo(amount);
    }
}
