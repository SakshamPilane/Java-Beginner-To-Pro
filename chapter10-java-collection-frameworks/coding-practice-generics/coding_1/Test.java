package coding_1;

class Test {
    public static void main(String[] args) {
        Container<String> c1 = new Container<>();
        c1.setValue("Saksham");
        System.out.println(c1.getValue());

        Container<Integer> c2 = new Container<>();
        c2.setValue(21);
        System.out.println(c2.getValue());

        Container<Double> c3 = new Container<>();
        c3.setValue(100.33);
        System.out.println(c3.getValue());
    }
}
