package basic_20;

public abstract class Vehicle {

    private String name;
    private String fuelType;
    private double average;
    private int yearBought;

    // Common setters
    public void setName(String name) {
        this.name = name;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public void setYearBought(int yearBought) {
        this.yearBought = yearBought;
    }

    // Common getters
    public String getName() {
        return name;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getAverage() {
        return average;
    }

    public int getYearBought() {
        return yearBought;
    }

    public abstract void displayDetails();
}
