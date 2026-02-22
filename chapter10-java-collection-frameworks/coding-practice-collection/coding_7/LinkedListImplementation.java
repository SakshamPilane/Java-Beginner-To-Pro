package coding_7;

import java.util.*;

class LinkedListImplementation {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter elements into LinkedList of size 10: ");
            for (int i = 0; i < 10; i++) {
                list.add(input.nextInt());
            }
            System.out.print("Enter element to add first: ");
            list.addFirst(input.nextInt());
            System.out.print("Enter element to add last: ");
            list.addLast(input.nextInt());

            System.out.println("Updated Linked List = " + list);

            System.out.println("Removing first element");
            list.removeFirst();
            System.out.println("Removing last element");
            list.removeLast();

            System.out.println("Updated Linked List = " + list);
        }
    }
}
