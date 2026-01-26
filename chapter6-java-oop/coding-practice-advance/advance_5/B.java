package advance_5;

public class B extends A{

    public B(int number)
    {
        super.number = number;
    }
    public void display()
    {
        System.out.println("Number entered = " + super.number);
    }
}
