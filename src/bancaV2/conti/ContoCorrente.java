package bancaV2.conti;

import bancaV2.ContoType;
import bancaV2.Accountable;

public class ContoCorrente extends AbstractConto {

    public ContoCorrente(String iban, String cf, double saldo) {
        super(iban, cf, 0.0);
    }
}
