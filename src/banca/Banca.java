/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banca;

/**
 *
 * @author cristiana
 */
public class Banca {

    private static String IBAN;
    private String nome;
    private Conto[] conti;
    private int contiInseriti;

    public Banca(String nome, int nConti) {
        this.conti = new Conto[nConti];
        contiInseriti = 0;
        this.nome = nome;
        IBAN = "IT00000" + nome+"000";

    }

    public String getName() {
        return nome;
    }

    public Conto aggiungiConto(String cf, double amount) {
        if (contiInseriti < conti.length) {
            String iban = IBAN + (contiInseriti + 1);
            Conto c = new Conto(iban, cf);
            c.deposito(amount);
            conti[contiInseriti++] = c;
            return c;
        } else {
            return null;
        }
    }

    public Conto aggiungiConto(String cf) {
        if (contiInseriti < conti.length) {
            String iban = IBAN + (contiInseriti + 1);
            Conto c = new Conto(iban, cf);
            conti[contiInseriti++] = c;
            return c;
        } else {
            return null;
        }
    }

    public boolean operazione(String iban, double amount) {
        Conto c = getConto(iban);
        if (c != null) {
            if (amount > 0) {
                return c.deposito(amount);
            } else {
                return c.prelievo(-amount);
            }
        } else {
            return false;
        }
    }

    public Conto getConto(String iban) {
        for (int i = 0; i < contiInseriti; i++) {
            if (conti[i].getIban().equals(iban)) {
                return conti[i];
            }
        }
        return null;
    }

    public double totaleSaldi() {
        double tot = 0;
        for (int i = 0; i < contiInseriti; i++) {
            tot += conti[i].getSaldo();
        }
        return tot;
    }

    public String toString() {
        String s = "\nBanca " + nome + "\n";
        s += "------------\n";
        s += contiInseriti + " conti attivi\n";
        s += "------------\n";
        for (int i = 0; i < contiInseriti; i++) {
            s += conti[i].toString() + "\n";
        }
        s += "------------\n";
        return s + "\n";
    }
}
