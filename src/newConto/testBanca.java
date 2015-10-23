/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newConto;

/**
 *
 * @author cristiana
 */
public class testBanca {

    public static void main(String[] args) {
        Banca b = new Banca("UBI", 10);
        add(b, "AAA", 10000);
        add(b, "BBB", 234000);
        add(b, "CCC", 3000);
        add(b, "DDD", 100);
        add(b, "EEE", 2500);
        add(b, "FFF", 900);
        add(b, "GGG", 10);

        System.out.println(b.toString());
        System.out.println("Banca " + b.getName() + "totale saldi iniziale = " 
                + b.totaleSaldi());

        movimento(b, "IT00000UBI0004", 2000);
        movimento(b, "IT00000UBI0002", -100);
        movimento(b, "IT00000UBI0003", 200);
        movimento(b, "IT00000UBI0002", -2000);
        movimento(b, "IT00000UBI0004", -3000);
        System.out.println("Banca " + b.getName() + "totale saldi = " 
                + b.totaleSaldi());

        Banca b1 = new Banca("BNL", 10);
        add(b1, "ZAAA", 1000);
        add(b1, "ZBBB", 23400);
        add(b1, "ZCCC", 300);
        add(b1, "ZDDD", 10);
        add(b1, "ZEEE", 250);
        add(b1, "ZFFF", 90);
        add(b1, "ZGGG", 4);

        System.out.println(b1.toString());
        System.out.println("Banca " + b1.getName() + " totale saldi iniziale = " 
                + b1.totaleSaldi());

        movimento(b1, "IT00000BNL0004", 300);
        movimento(b1, "IT00000BNL0002", -500);
        movimento(b1, "IT00000BNL0003", 3400);
        movimento(b1, "IT00000BNL0002", -40000);
        movimento(b1, "IT00000BNL0004", -200);
        System.out.println("Banca " + b1.getName() + " totale saldi = " 
                + b1.totaleSaldi());

    }

    private static void add(Banca b, String cf, double amount) {
        Conto c;
        if ((c = b.aggiungiConto(cf, amount)) != null) {
            System.out.println("Aggiunto il conto " + c.getIban() + " intestato a "
                    + cf + " saldo " + c.getSaldo());
        } else {
            System.out.println("Impossibile aprire il conto per " + cf);
        }
    }

    private static void movimento(Banca b, String iban, double amount) {
        if (b.operazione(iban, amount)) {
            System.out.println("Operazione sul conto " + iban + " avvenuta con successo");
        } else {
            System.out.println("Operazione sul conto " + iban + " fallita");
        }
    }

}
