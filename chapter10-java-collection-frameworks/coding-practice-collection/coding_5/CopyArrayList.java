package coding_5;

import java.util.*;

class CopyArrayList {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in))
        {
            List<Integer> list1 = new ArrayList<>(10);
            List<Integer> list2 = new ArrayList<>(10);

            System.out.print("Enter 10 Elements into first ArrayList: ");
            for (int i = 0; i < 10; i++) {
                list1.add(input.nextInt());
            }

            list2.addAll(list1);

            System.out.print("Copied new ArrayList = ");
            for (int num : list2) {
                System.out.print(num + " ");
            }
        }
    }
}
