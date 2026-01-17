package basic_20;

public class Car extends Vehicle {

    private String brakingSystem;

    public void setBrakingSystem(String brakingSystem) {
        this.brakingSystem = brakingSystem;
    }

    public String getBrakingSystem() {
        return brakingSystem;
    }

    @Override
    public void displayDetails() {
        System.out.println("Vehicle Type: Car");
        System.out.println("Name: " + getName());
        System.out.println("Fuel Type: " + getFuelType());
        System.out.println("Average: " + getAverage());
        System.out.println("Year Bought: " + getYearBought());
        System.out.println("Braking System: " + getBrakingSystem());
    }
}
