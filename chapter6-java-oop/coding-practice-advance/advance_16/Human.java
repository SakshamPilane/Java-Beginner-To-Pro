package advance_16;

public class Human implements Walkable, Runnable{

    @Override
    public void run() {
        System.out.println("Human Running!");
    }

    @Override
    public void walk() {
        System.out.println("Human Walking!");
    }
}
