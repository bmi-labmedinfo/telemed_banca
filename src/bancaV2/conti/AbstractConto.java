package bancaV2.conti;

import bancaV2.Accountable;
import bancaV2.Conto;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConto implements Conto {

    private double saldo;
    protected ContoType type;
    private String cf;
    private String iban;
    private List<Accountable> accountables;

    public AbstractConto(ContoType type, String iban, String cf, double saldo) {
        this.type = type;
        this.iban = iban;
        this.cf = cf;
        this.saldo = saldo;
        this.accountables = new ArrayList<>();
    }

    @Override
    public boolean addAccountable(Accountable acc) {
        return accountables.add(acc);
    }

    public boolean fineMese() {
        for (Accountable acc : accountables) {
            double importo = acc.getImporto();
            boolean esito = operazione(importo);
            if (esito == false) {
                return false;
            }
        }
        return true;
    }

    protected boolean updateSaldo(double amount) {
         if (amount >= 0) {
            return deposito(amount);
        } else {
            return prelievo(-amount);
        }
    }

    private boolean prelievo(double amount) {
        if (amount >= 0 && amount <= saldo) {
            this.saldo -= amount;
            return true;
        } else {
            return false;
        }
    }


    private boolean deposito(double amount) {
        if (amount >= 0) {
            updateSaldo(amount);
            return true;
        } else {
            return false;
        }
    }

    public String getIban() {
        return iban;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    public ContoType getType() {
        return type;
    }

}
