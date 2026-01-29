package coding_2;

public class ArrayOutOfBoundsHandling {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException{
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index accessed");
        }
    }
}
