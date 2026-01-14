package basic_11;

public class Box {
    float width, height, depth;

    public Box()
    {
        System.out.println("Welcome to Box Class lets calculate its volume!!");
    }

    public Box(float w, float h, float d)
    {
        width = w;
        height = h;
        depth = d;
    }

    public Float volume()
    {
        return width * height * depth;
    }
}
