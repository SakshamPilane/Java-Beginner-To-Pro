package coding_6;

class Calculator <T extends Number>{

    public double square(T value)
    {
        return value.doubleValue() * value.doubleValue();
    }

}
