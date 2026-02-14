package coding_2;

class Test {

    public static void main(String[] args) {
        print("Saksham");
        print(100);
        Test t = new Test();
        print(t);

    }
    public static <T> void print(T value)
    {
        System.out.println(value);
    }
}
