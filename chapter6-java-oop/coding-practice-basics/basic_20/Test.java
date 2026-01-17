package basic_20;

public class Test {
    public static void main(String[] args) {

        Vehicle vehicle;

        vehicle = new Car();
        vehicle.setName("Honda City");
        vehicle.setFuelType("Petrol");
        vehicle.setAverage(18.5);
        vehicle.setYearBought(2022);
        ((Car) vehicle).setBrakingSystem("ABS");
        vehicle.displayDetails();

        System.out.println();

        vehicle = new Bike();
        vehicle.setName("Yamaha FZ");
        vehicle.setFuelType("Petrol");
        vehicle.setAverage(45.0);
        vehicle.setYearBought(2021);
        ((Bike) vehicle).setHasGear(true);
        vehicle.displayDetails();
    }
}
