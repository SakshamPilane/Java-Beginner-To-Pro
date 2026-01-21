package basic_27;

public class Child extends Parent{

    @Override
    public void display(String cName, int cAge)
    {
        System.out.println("Child Class");
        System.out.println("Child Name = " + cName);
        System.out.println("Child Age = " + cAge);
    }

    @Override
    public void display(String cName, double cAge)
    {
        System.out.println("Child Class");
        System.out.println("Child Name = " + cName);
        System.out.println("Child Age = " + cAge);
    }
}