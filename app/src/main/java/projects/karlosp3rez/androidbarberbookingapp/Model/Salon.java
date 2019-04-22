package projects.karlosp3rez.androidbarberbookingapp.Model;

public class Salon {
    private String name, address;

    public Salon() {
    }

    public Salon(String name, String address) {
        this.name = name;
        this.address = address;
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
}
