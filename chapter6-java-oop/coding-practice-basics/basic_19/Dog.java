package basic_19;

public class Dog extends Animal{

    @Override
    public void sound()
    {
        bark();
    }

    public void bark()
    {
        System.out.println("Dog Barks...");
    }
}
