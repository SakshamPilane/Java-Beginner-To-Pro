package advance_23;

public class House {
    private final Door door;   // HAS-A relationship

    House() {
        door = new Door();
    }

    void enterHouse() {
        door.open();
        System.out.println("Entered the house");
    }
}