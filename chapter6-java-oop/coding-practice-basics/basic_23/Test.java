package basic_23;

public class Test {
    public static void main(String[] args) {
        Playable obj;

        obj = new Guitar();
        obj.play();

        obj = new Radio();
        obj.play();

        obj = new VideoPlayer();
        obj.play();
    }
}
