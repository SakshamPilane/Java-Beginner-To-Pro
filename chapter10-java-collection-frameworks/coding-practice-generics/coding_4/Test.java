package coding_4;

class Test {

    public static void main(String[] args) {
        GenericPair<Integer, String> gp = new GenericPair<>();
        gp.setValue1(21);
        gp.setValue2("Saksham");

        System.out.println("Age = " + gp.getValue1());
        System.out.println("Name = " + gp.getValue2());

        GenericPair<String, Double> gpNewObj = new GenericPair<>();
        gpNewObj.setValue1("Saksham Pilane");
        gpNewObj.setValue2(21.11);

        System.out.println("Exact Name = " + gpNewObj.getValue1());
        System.out.println("Exact Age = " + gpNewObj.getValue2());
    }
}
