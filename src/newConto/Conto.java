/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newConto;

/**
 *
 * @author cristiana
 */
public class Conto {

    private String iban;
    private String cf;
    private double saldo;
    private static final int HISTORY = 10;
    private double movimenti[];
    private int last;

    public Conto(String iban, String cf) {
        this.iban = iban;
        this.cf = cf;
        this.movimenti = new double[HISTORY];
        last = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean prelievo(double a) {
        if (a >= 0 && a <= saldo) {
            movimenti[last%HISTORY] = -a;
            last++;
            saldo -= a;
            return true;
        } else {
            return false;
        }
    }

    public boolean deposito(double a) {
        if (a >= 0) {
            saldo += a;
            movimenti[last%HISTORY] = a;
            last++;
            return true;
        } else {
            return false;
        }
    }

    String getIban() {
        return iban;
    }

//    public String toString() {
//    String s = "";
//        int i = 0;
//        while (i < movimenti.length) {
//            if (--last < 0 ) {
//                last = movimenti.length-1;
//            }
//            if (movimenti[last%HISTORY] != 0) {
//                s += movimenti[last%HISTORY] + ", ";
//            }
//            
//            
//            i++;
//        }
//        return iban + " " + cf + " " + saldo + "\n" + s;
//    }
    
    public String toString() {
    String s = "";
        int i = last, k=0;
        while (k < HISTORY) {
            if (movimenti[i%HISTORY] != 0) {
                s += movimenti[i%HISTORY] + " ";
            }
            i++;
            k++;
        }
        return iban + " " + cf + " " + saldo + "\n" + s;
    }
}
