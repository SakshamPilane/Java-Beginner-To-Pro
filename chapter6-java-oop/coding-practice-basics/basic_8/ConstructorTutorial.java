package basic_8;

public class ConstructorTutorial {
    public ConstructorTutorial()
    {
        System.out.println("Object Created!");
    }
    public void display()
    {
        System.out.println("Display Method");
    }

    public static void main(String[] args) {
        ConstructorTutorial obj = new ConstructorTutorial();
        obj.display();
    }
}
