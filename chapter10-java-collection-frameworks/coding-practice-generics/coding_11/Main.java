package coding_11;

import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();
        list.add(12.3);
        list.add(13.55);
        list.add(14.23);
        list.add(15D);
        list.add(16D);
        printNumber(list);
    }

    public static void printNumber(final List<? extends Number> list)
    {
        for (Number num : list)
        {
            System.out.print(num + " ");
        }
    }
}
