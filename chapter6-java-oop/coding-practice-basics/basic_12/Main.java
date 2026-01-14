package basic_12;

public class Main {
    public static void main(String[] args) {
        ObjectCounter obj = null;
        for (int i = 0; i < 10; i++) {
            obj = new ObjectCounter();
        }
        System.out.println("Total Objects created = " + obj.totalCount());
    }
}
