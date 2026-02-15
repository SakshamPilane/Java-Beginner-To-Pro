package coding_6;

class Test {
    public static void main(String[] args) {
        Calculator<Integer> calcTestObj1 = new Calculator<>();
        System.out.println("Square of 13 = " + calcTestObj1.square(13));

        Calculator<Double> calcTestObj2 = new Calculator<>();
        System.out.println("Square of 13.33 = " + calcTestObj2.square(13.33));
    }
}