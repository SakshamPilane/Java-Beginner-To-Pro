package coding_1;

class Container<T> {

    private T typeValue;

    public void setValue(T typeValue)
    {
        this.typeValue = typeValue;
    }

    public T getValue()
    {
        return typeValue;
    }
}
