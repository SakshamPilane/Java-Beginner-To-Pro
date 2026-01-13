package basic_6;

public class Calculator {
    float firstNumber, secondNumber;

    public float add()
    {
        return firstNumber + secondNumber;
    }
    public float sub()
    {
        return firstNumber - secondNumber;
    }
    public float mul()
    {
        return firstNumber * secondNumber;
    }
    public String div()
    {
        if (secondNumber != 0)
        {
            return Float.toString(firstNumber/secondNumber);
        }
        else
        {
            return "Undefined";
        }
    }

    public static void main(String[] args) {
        Calculator obj = new Calculator();
        obj.firstNumber = 10;
        obj.secondNumber = 0;
        System.out.println("Addition of Number " + obj.firstNumber + " and " + obj.secondNumber + " is = " + obj.add());
        System.out.println("Substraction of Number " + obj.secondNumber + " from " + obj.firstNumber + " is = " + obj.sub());
        System.out.println("Multiplication of Number " + obj.firstNumber + " and " + obj.secondNumber + " is = " + obj.mul());
        System.out.println("Division of Number " + obj.firstNumber + " from " + obj.secondNumber + " is = " + obj.div());
    }
}
