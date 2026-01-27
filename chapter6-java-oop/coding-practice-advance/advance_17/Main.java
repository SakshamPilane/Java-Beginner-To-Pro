package advance_17;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = { new Car(), new Bike() };
        for (Vehicle vehicle : vehicles) {
            vehicle.start();
        }
    }
}
