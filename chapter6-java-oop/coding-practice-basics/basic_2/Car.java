package basic_2;

public class Car {
    public void start()
    {
        System.out.println("Car Starts....");
    }

    public void stop()
    {
        System.out.println("Car Stops....");
    }

    public static void main(String[] args) {
        Car c = new Car();
        c.start();
        c.stop();
    }
}
