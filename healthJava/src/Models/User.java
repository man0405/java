package Models;

public class User {
    private String id;
    private String username;
    private String password;
    private double weigh;
    private double heigh;
    


    public User() {
        super();
    }
    public User(double weigh, double heigh) {
        this.weigh = weigh;
        this.heigh = heigh;
    }

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public double getWeigh() {
        return weigh;
    }
    public void setWeigh(double weigh) {
        this.weigh = weigh;
    }
    public double getHeigh() {
        return heigh;
    }
    public void setHeigh(double heigh) {
        this.heigh = heigh;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
