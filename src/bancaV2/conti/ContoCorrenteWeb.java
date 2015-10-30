package bancaV2.conti;


public class ContoCorrenteWeb extends ContoCorrente {

    private boolean loggedIn;
    private String password;
    private boolean firstlogin;

    public ContoCorrenteWeb(double saldo, String iban, String cf) {
        super(saldo, iban, cf);
        this.type=ContoType.WEB;
        this.password = "changeme";
        this.loggedIn=false;
        this.firstlogin=true;
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
        if (firstlogin && logIn(password)) {
            this.password = newPassword;
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
        if (password.equals(this.password)) {
            this.loggedIn = true;
            this.firstlogin=false;
        } else {
            this.loggedIn = false;
        }
        return loggedIn;
    }

}
