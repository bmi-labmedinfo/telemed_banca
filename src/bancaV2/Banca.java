package bancaV2;


import bancaV2.conti.ContoDeposito;
import bancaV2.conti.ContoCorrenteWeb;
import bancaV2.conti.ContoCorrente;
import java.util.*;

public class Banca {

    private String nome;
    private Map<String, Conto> conti;

    /**
     *
     * @param iban
     * @param cf
     * @param type
     */
    public Conto aggiungiConto(String cf, ContoType type) {
        Conto c = null;
        switch (type) {
            case CORRENTE:
                c = new ContoCorrente(genIban(), cf, 0.0);
                break;
            case WEB:
                c = new ContoCorrenteWeb(genIban(), cf, 0.0);
                break;
            case DEPOSITO:
                c = new ContoDeposito(genIban(), cf, 0.0);
                break;
        }
        conti.put(c.getIban(), c);
        return c;
    }

    /**
     *
     * @param nome
     */
    public Banca(String nome) {
        this.nome = nome;
        conti = new LinkedHashMap<>();
    }

    /**
     *
     * @param iban
     * @param amount
     */
    public boolean operazione(String iban, double amount) {
        Conto c = conti.get(iban);
        return c.operazione(amount);
    }
    
    public boolean changePass(String iban, String oldPass, String newPass) {
        boolean res = false;
        Conto c = conti.get(iban);
        if (c instanceof ContoCorrenteWeb){
            res = ((ContoCorrenteWeb)c).setPassword(oldPass, newPass);
        }
        return res;
    }

    /**
     *
     * @param iban
     * @param acc
     */
    public boolean addAccountable(String iban, Accountable acc) {
        Conto c = conti.get(iban);
        return c.addAccountable(acc);
    }

    /**
     *
     * @param iban
     * @param password
     */
    public boolean logIn(String iban, String password) {
        boolean res = false;
        Conto c = conti.get(iban);
        if (c instanceof ContoCorrenteWeb){
            res = ((ContoCorrenteWeb)c).logIn(password);
        }
        return res;
    }

    public void fineMese() {
       for (Conto c : conti.values()) {
               c.fineMese();
           }
    }

    private String genIban() {
        return nome+conti.size();
    }
    
        public String toString() {
        String s = "\nBanca " + nome + "\n";
        s += "------------\n";
        s += (conti==null?0:conti.size()) + " conti attivi\n";
        s += "------------\n";
        for (Conto c:conti.values()) {
                s += c.printDetails() + "\n";
        }
        s += "------------\n";
        return s + "\n";
    }

}
