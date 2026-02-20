package coding_2;

import java.util.*;

class ArrayListInsertion {
    public static void main(String[] args) {
        int i;
        try (Scanner input = new Scanner(System.in))
        {
            List<Integer> list = new ArrayList<>(10);
            System.out.print("Enter 10 Elements into Array List = ");
            for (i = 0; i < 10; i++) {
                list.add(input.nextInt());
            }

            if (!list.isEmpty()) {
                System.out.print("List = [");
                for (int j = 0; j < list.size(); j++) {
                    System.out.print(list.get(j));
                    if (j != list.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.print("]");
            }
        }
    }
}
