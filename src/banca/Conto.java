/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banca;

/**
 *
 * @author cristiana
 */
public class Conto {

    private String iban;
    private String cf;
    private double saldo;

    public Conto(String iban, String cf) {
        this.iban = iban;
        this.cf = cf;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean prelievo(double a) {
        if (a >= 0 && a <= saldo) {
            saldo -= a;
            return true;
        } else {
            return false;
        }
    }

    public boolean deposito(double a) {
        if (a >= 0) {
            saldo += a;
            return true;
        } else {
            return false;
        }
    }

    String getIban() {
        return iban;
    }

    public String toString(){
        return iban+" "+cf+" "+saldo;
    }
}
