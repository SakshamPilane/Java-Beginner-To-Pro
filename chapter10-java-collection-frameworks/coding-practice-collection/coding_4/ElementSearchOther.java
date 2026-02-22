package coding_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ElementSearchOther {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in))
        {
            List<Integer> list = new ArrayList<>(10);
            System.out.print("Enter 10 elements into List: ");
            for (int i = 0; i < 10; i++) {
                list.add(input.nextInt());
            }

            System.out.print("Enter element to search: ");
            int element = input.nextInt();

            int pos = list.indexOf(element);

            if (pos == -1)
            {
                System.out.println("Element Not Found!");
            }
            else
            {
                System.out.println("Element Found at position = " + (pos+1));
                System.out.println("In List = " + list);
            }
        }
    }
}
