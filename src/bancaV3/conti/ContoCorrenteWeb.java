package bancaV3.conti;

import bancaV3.exceptions.NotLoggedInException;
import bancaV3.exceptions.IncorrectPasswordException;
import bancaV3.exceptions.InvalidOperationException;
import bancaV3.ContoType;

public class ContoCorrenteWeb extends ContoCorrente {

    private boolean loggedIn;
    private String password;
    private boolean firstlogin;

    public ContoCorrenteWeb(String iban, String cf, double saldo) {
        super(iban, cf, saldo);
        this.password = "changeme";
        this.loggedIn = false;
        this.firstlogin = true;
    }

    public boolean operazione(double amount) {
        if (!loggedIn) {
            throw new NotLoggedInException();
        } else {
            return super.operazione(amount);
        }
    }

    public boolean setPassword(String oldPassword, String newPassword) {
        /*
         note that you can only change password one time in the life of one ContoCorrenteWeb object!
         */
        try {
            if (firstlogin && oldPassword.equals(this.password)) {
                this.password = newPassword;
                this.firstlogin = false;
                this.loggedIn = false;
                return true;
            } else {
                throw new InvalidOperationException("Conto " + this.getIban() + ": password change not allowed ");
            }
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     *
     * @param password
     */
    public boolean logIn(String password) {
        /*
         with this implementation of login you are forced to change password first
         after changing pass you can log in normally
         */
        this.loggedIn = false;
//        try {
        if (password.equals(this.password)) {
            if (!firstlogin) {
                this.loggedIn = true;
                this.firstlogin = false;
            } else {
                throw new InvalidOperationException("please change the default password");
            }
        } else {
             throw new IncorrectPasswordException();
        }
        return loggedIn;
    }

}
