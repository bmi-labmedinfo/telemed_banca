package bancaV3.conti;

import bancaV3.exceptions.InvalidOperationException;
import bancaV3.accountables.Accountable;
import bancaV3.Conto;
import java.util.ArrayList;
import java.util.List;

public class ContoCorrente implements Conto {
    private static final String SEP = ";";
    private double saldo;
    private String cf;
    private String iban;
    private List<Accountable> accountables;

    public ContoCorrente(String iban, String cf, double saldo) {
        this.iban = iban;
        this.cf = cf;
        this.saldo = saldo;
        this.accountables = new ArrayList<>();
    }

    @Override
    public boolean addAccountable(Accountable acc) {
        /* note: implementing this here allows for both conto deposito and corrente to have accountables that "withraw" money
        this is probably undesirable....homework: think about ho to prevent this
        (HINT for solution: override this impl in ContoDeposito)
        */
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

    @Override
    public boolean operazione(double amount){
       if (amount >= 0) {
            return deposito(amount);
        } else {
            return prelievo(-amount);
        }
    }
    
    private boolean prelievo(double amount) {
        if (amount <= saldo) {
            this.saldo -= amount;
            return true;
        } else {
            throw new InvalidOperationException("Conto: "+this.getIban()+" not allowed operation");
        }
    }

    private boolean deposito(double amount) {
            this.saldo += amount;
            return true;
    }

    public String getIban() {
        return iban;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    public String printDetails() {
        return "iban: " + iban + SEP + "\tintestatario: " + cf
                + SEP + "\tsaldo: " + saldo;
    }

}
