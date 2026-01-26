package advance_2;

public class Car extends Vehicle {

    Car(String model, double speed) {
        super(model, speed);
    }

    @Override
    public void displayDetails() {
        System.out.println("Car Details:");
        super.displayDetails();
    }
}
