package advance_2;

public class Vehicle {
    protected String model;
    protected double speed;

    Vehicle(String model, double speed) {
        this.model = model;
        this.speed = speed;
    }

    public void displayDetails() {
        System.out.println("Model = " + model);
        System.out.println("Speed = " + speed);
    }
}
