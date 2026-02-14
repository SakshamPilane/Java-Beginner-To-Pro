package coding_6;

public class Calculator <T extends Number>{

    public double square(T value)
    {
        return value.doubleValue() * value.doubleValue();
    }

}
