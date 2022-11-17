package Models;

public class Account extends User {
    private String idAccount;
    private String accountName;
    private String password;
    private User user;



    
    public Account() {
        super();
    }
    
    public Account(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
    }

    public Account(String idAccount, String accountName, String password, User user) {
        this.idAccount = idAccount;
        this.accountName = accountName;
        this.password = password;
        this.user = user;
    }



    public String getIdAccount() {
        return idAccount;
    }
    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    
}
