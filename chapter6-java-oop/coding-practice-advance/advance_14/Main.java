package advance_14;

public class Main {
    public static void main(String[] args) {
        Playable playObj;

        playObj = new Football();
        playObj.play();

        playObj = new Guitar();
        playObj.play();

        playObj = new Piano();
        playObj.play();
    }
}
