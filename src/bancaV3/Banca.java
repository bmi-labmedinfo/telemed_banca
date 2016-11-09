package bancaV3;

import bancaV3.accountables.Accountable;
import bancaV3.conti.ContoDeposito;
import bancaV3.conti.ContoCorrenteWeb;
import bancaV3.conti.ContoCorrente;
import bancaV3.exceptions.IncorrectPasswordException;
import bancaV3.exceptions.InvalidIbanException;
import bancaV3.exceptions.InvalidOperationException;
import bancaV3.exceptions.NotLoggedInException;
import java.io.InputStream;
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
        Conto c = null;
        try {
            c = get(iban);
            return c.operazione(amount);
        } catch (InvalidOperationException | InvalidIbanException e) {
            System.out.println("Conto " + iban + ": " + e.getMessage());
        } catch (NotLoggedInException e) {
            System.out.println("Conto " + iban + ": " + e.getMessage());
        }
        return false;
    }

    private Conto get(String iban) {
        if (conti.containsKey(iban)) {
            return conti.get(iban);
        } else {
            throw new InvalidIbanException(iban + " not valid");
        }
    }

    public boolean changePass(String iban, String oldPass, String newPass) {
        boolean res = false;
        Conto c = get(iban);
        if (c instanceof ContoCorrenteWeb) {
            res = ((ContoCorrenteWeb) c).setPassword(oldPass, newPass);
        }
        return res;
    }

    /**
     *
     * @param iban
     * @param acc
     */
    public boolean addAccountable(String iban, Accountable acc) {
        Conto c;
        try {
            c = get(iban);
            return c.addAccountable(acc);
        } catch (InvalidIbanException | InvalidOperationException e) {
            System.out.println("Conto " + iban + ": " + e.getMessage());
        }
        return true;
    }

    /**
     *
     * @param iban
     * @param password
     */
    public boolean logIn(String iban, String password) {
        boolean res = false;
        int attempt = 0;
        Conto c = null;
        while (attempt < 3) {
            try {
                c = get(iban);

                attempt++;
                if (c instanceof ContoCorrenteWeb) {
                    res = ((ContoCorrenteWeb) c).logIn(password);
                }
                return res;
            } catch (InvalidIbanException | InvalidOperationException e) {
                System.out.println("Conto " + iban + ": " + e.getMessage());
                return res;
            } catch (IncorrectPasswordException e) {
                System.out.println("Insert the password: ");
                Scanner in = new Scanner(System.in);
                password = in.nextLine();

            }
        }
        return false;
    }

    public void fineMese() {
        for (Conto c : conti.values()) {
            c.fineMese();
        }
    }

    private String genIban() {
        return nome + conti.size();
    }

    public String toString() {
        String s = "\nBanca " + nome + "\n";
        s += "------------\n";
        s += (conti == null ? 0 : conti.size()) + " conti attivi\n";
        s += "------------\n";
        for (Conto c : conti.values()) {
            s += c.printDetails() + "\n";
        }
        s += "------------\n";
        return s + "\n";
    }

}
