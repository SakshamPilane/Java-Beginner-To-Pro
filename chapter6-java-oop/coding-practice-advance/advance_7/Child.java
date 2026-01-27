package advance_7;

public class Child extends Parent {
    @Override
    public void printGen()
    {
        super.printGen();
        System.out.println("This is Child class! Level 3 Generation.");
    }
}