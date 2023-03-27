package Model;

public class User {
    private String name, address;
    private double mark;

    public User() {

    }

    public User(String name, String address, double mark) {
        this.name = name;
        this.address = address;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", address=" + address + ", mark=" + mark + "]";
    }
}
