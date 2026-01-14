package basic_10;

public class ConstructorOverloading {
    String name;
    int age;
    float marks;
    public ConstructorOverloading(String a)
    {
        System.out.println("Object 1 Created");
        name = a;
    }

    public void display1()
    {
        System.out.println("Name = " + name);
        System.out.println();
    }

    public ConstructorOverloading(String a, int b)
    {
        System.out.println("Object 2 Created");
        name = a;
        age = b;
    }

    public void display2()
    {
        System.out.println("Name = " + name);
        System.out.println("Age = " + age);
        System.out.println();
    }

    public ConstructorOverloading(String a, int b, float c)
    {
        System.out.println("Object 3 Created");
        name = a;
        age = b;
        marks = c;
    }

    public void display3()
    {
        System.out.println("Name = " + name);
        System.out.println("Age = " + age);
        System.out.println("Marks = " + marks);
        System.out.println();
    }

    public static void main(String[] args) {
        ConstructorOverloading obj1 = new ConstructorOverloading("Saksham");
        obj1.display1();
        ConstructorOverloading obj2 = new ConstructorOverloading("Raj",20);
        obj2.display2();
        ConstructorOverloading obj3 = new ConstructorOverloading("Jay", 21, 98.5f);
        obj3.display3();
    }
}
