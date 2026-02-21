package coding_3;

import java.util.*;

class MinMaxFindingClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<Integer> list = new ArrayList<>(10);

        System.out.print("Enter 10 Elements into Array List = ");
        for (int i = 0; i < 10; i++) {
            list.add(input.nextInt());
        }

        if (list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }
        else {
            Integer[] minMaxArray = findMinAndMax(list);
            System.out.println("Maximum Element found = " + minMaxArray[0] + "\nMinimum Element found = " + minMaxArray[1]);
        }
    }

    public static Integer[] findMinAndMax(List<Integer> list)
    {
        Integer maxElement = list.getFirst(), minElement = list.getFirst();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(maxElement) > 0)
            {
                maxElement = list.get(i);
            }
            if (list.get(i).compareTo(minElement) < 0)
            {
                minElement = list.get(i);
            }
        }
        return new Integer[]{maxElement, minElement};
    }
}
