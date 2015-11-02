package bancaV2.conti;

import bancaV2.ContoType;

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

    @Override
    public boolean operazione(double amount) {
        if (!loggedIn) {
            return false;
        } else {
            return super.operazione(amount);
        }
    }

    public boolean setPassword(String oldPassword, String newPassword) {
        /*
        note that you can only change password one time in the life of one ContoCorrenteWeb object!
         */
        if (firstlogin && oldPassword.equals(this.password)) {
            this.password = newPassword;
            this.firstlogin = false;
            this.loggedIn = false;
            return true;
        } else {
            return false;
        }
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
        if (password.equals(this.password) && !firstlogin) {
            this.loggedIn = true;
            this.firstlogin = false;
        } else {
            this.loggedIn = false;
        }
        return loggedIn;
    }

}
