package bancaV2;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import bancaV2.conti.ContoType;
import newConto.*;

/**
 *
 * @author cristiana
 */
public class testBancaV2 {

    public static void main(String[] args) {
        Banca b = new Banca("UBI");
        add(b, "AAA", ContoType.CORRENTE);
        add(b, "BBB", ContoType.CORRENTE);
        add(b, "CCC", ContoType.WEB);
        add(b, "DDD", ContoType.DEPOSITO);
        
        b.operazione("UBI0", 1000);
        b.operazione("UBI1", 2000);
        b.operazione("UBI1", -30);
        b.operazione("UBI2", 200);
        b.logIn("UBI2", "changeme");
        b.operazione("UBI2", 2500);
        b.operazione("UBI2", -100);
        b.operazione("UBI3", 5000);
        b.operazione("UBI3", -1000);
        System.out.println(b);
        
        Stipendio s1 = new Stipendio(1300);
        AbbonamentoSky abb1 = new AbbonamentoSky(true, true, true);
        AbbonamentoSky abb2 = new AbbonamentoSky(true, false, false);
        b.addAccountable("UBI0", abb1);
        b.addAccountable("UBI2", abb2);
        b.addAccountable("UBI3", s1);
        b.fineMese();
        System.out.println(b);
    }
        private static void add(Banca b, String cf, ContoType type) {
        Conto c;
        if ((c = b.aggiungiConto(cf, type)) != null) {
            System.out.println("Aggiunto il conto " + c.getIban() + " intestato a "
                    + cf + " saldo " + c.getSaldo());
        } else {
            System.out.println("Impossibile aprire il conto per " + cf);
        }
    }
        //    private static void movimento(Banca b, String iban, double amount) {
//        if (b.operazione(iban, amount)) {
//            System.out.println("Operazione sul conto " + iban + " avvenuta con successo");
//        } else {
//            System.out.println("Operazione sul conto " + iban + " fallita");
//        }
//    }
}
