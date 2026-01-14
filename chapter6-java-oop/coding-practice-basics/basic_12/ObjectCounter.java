package basic_12;

public class ObjectCounter {
    static int count;

    public ObjectCounter()
    {
        count++;
    }

    public int totalCount()
    {
        return count;
    }
}
