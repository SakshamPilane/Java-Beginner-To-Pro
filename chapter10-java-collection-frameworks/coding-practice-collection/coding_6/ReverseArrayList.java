package coding_6;

import java.util.*;

class ReverseArrayList {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in))
        {
            List<Integer> list = new ArrayList<>(10);

            System.out.print("Enter 10 Elements into ArrayList: ");
            for (int i = 0; i < 10; i++) {
                list.add(input.nextInt());
            }

            reverseArrayListMethod(list);

            System.out.print("Reverse List = ");
            for (int num : list)
            {
                System.out.print(num + " ");
            }
        }
    }

    public static void reverseArrayListMethod(List<Integer> list)
    {
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            int temp = list.get(j);
            list.set(j,list.get(i));
            list.set(i, temp);
        }
    }
}
