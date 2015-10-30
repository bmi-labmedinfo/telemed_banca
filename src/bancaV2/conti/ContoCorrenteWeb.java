package bancaV2.conti;


public class ContoCorrenteWeb extends ContoCorrente {

    private boolean loggedIn;
    private String password;

    public ContoCorrenteWeb(double saldo, String iban, String cf) {
        super(saldo, iban, cf);
        this.type=ContoType.WEB;
        this.password = "changeme";
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
        if (oldPassword.equals(this.password)) {
            this.password = newPassword;
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
        if (password.equals(this.password)) {
            this.loggedIn = true;
        } else {
            this.loggedIn = false;
        }
        return loggedIn;
    }

}
