package advance_23;

public class Car {
    private final Engine engine;   // HAS-A relationship

    Car() {
        engine = new Engine();
    }

    void startCar() {
        engine.start();
        System.out.println("Car is running");
    }
}

