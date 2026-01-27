package advance_7;

public class Parent extends Grandparent{
    @Override
    public void printGen()
    {
        super.printGen();
        System.out.println("This is Parent class! Level 2 Generation.");
    }
}
