package basic_20;

public class Bike extends Vehicle {

    private boolean hasGear;

    public void setHasGear(boolean hasGear) {
        this.hasGear = hasGear;
    }

    public boolean hasGear() {
        return hasGear;
    }

    @Override
    public void displayDetails() {
        System.out.println("Vehicle Type: Bike");
        System.out.println("Name: " + getName());
        System.out.println("Fuel Type: " + getFuelType());
        System.out.println("Average: " + getAverage());
        System.out.println("Year Bought: " + getYearBought());
        System.out.println("Has Gear: " + hasGear());
    }
}
