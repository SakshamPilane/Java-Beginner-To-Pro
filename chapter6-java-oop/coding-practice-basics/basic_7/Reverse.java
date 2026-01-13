package basic_7;

public class Reverse {

    public int reverseNumber(int n)
    {
        int revNumber = 0;
        while (n > 0)
        {
            revNumber = (revNumber * 10) + (n % 10);
            n = n / 10;
        }
        return revNumber;
    }

    public static void main(String[] args) {
        Reverse obj = new Reverse();
        System.out.println("Reverse Number for 12345 is " + obj.reverseNumber(12345));
    }
}
