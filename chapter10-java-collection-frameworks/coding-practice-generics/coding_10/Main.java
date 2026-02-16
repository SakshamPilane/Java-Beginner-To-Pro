package coding_10;

public class Main {
    public static void main(String[] args) {
        new GenericConstructor((short) 11);
        new GenericConstructor((byte) 12);
        new GenericConstructor(13);
        new GenericConstructor(14L);
        new GenericConstructor(15.55F);
        new GenericConstructor(193.32);
        new GenericConstructor('S');
        new GenericConstructor(true);
        new GenericConstructor("Saksham");
    }
}
