package basic_19;

public class Cat extends Animal{

    @Override
    public void sound()
    {
        meow();
    }

    public void meow()
    {
        System.out.println("Cat Meows...");
    }
}
