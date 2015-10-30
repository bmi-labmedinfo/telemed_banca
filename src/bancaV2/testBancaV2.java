package bancaV2;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import bancaV2.conti.ContoType;

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
        b.operazione("UBI2", 200); //fails since not logged in
//        b.logIn("UBI2", "changeme");
        b.changePass("UBI2", "changeme", "newpass");//you have to change your pass as first operation;
        b.logIn("UBI2", "newpass");
        b.operazione("UBI2", 2500);
        b.operazione("UBI2", -100);
        b.operazione("UBI3", 5000);
        b.operazione("UBI3", -1000); //fails since it's deposit
        System.out.println(b);

        Stipendio s1 = new Stipendio(1300);
        AbbonamentoSky abb1 = new AbbonamentoSky(true, true, true);
        AbbonamentoSky abb2 = new AbbonamentoSky(true, false, false);
        b.addAccountable("UBI0", abb1);
        b.changePass("UBI2", "changeme", "newpass");
        b.addAccountable("UBI2", abb2);
        b.addAccountable("UBI3", s1);
        b.fineMese();
        System.out.println("FINE MESE TRIGGERED");
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

}
