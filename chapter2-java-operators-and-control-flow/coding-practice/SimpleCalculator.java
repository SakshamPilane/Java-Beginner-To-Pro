import java.io.*;
public class SimpleCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter first operand: ");
        double firstOperand = Double.parseDouble(br.readLine());
        System.out.print("Enter Operator eg:(+,-,/,*): ");
        char operator = br.readLine().charAt(0);
        System.out.print("Enter first operand: ");
        double secondOperand = Double.parseDouble(br.readLine());

        switch(operator) {
            case '*':
                System.out.print(firstOperand + " * " + secondOperand + " = " + (firstOperand * secondOperand));
                break;
            case '/':
                if (secondOperand != 0) {
                    System.out.print(firstOperand + " / " + secondOperand + " = " + (firstOperand / secondOperand));
                }
                else {
                    System.out.print("Denominator Cannot be Zero! Indefinite Answer");
                }
                break;
            case '+':
                System.out.print(firstOperand + " + " + secondOperand + " = " + (firstOperand + secondOperand));
                break;
            case '-':
                System.out.print(firstOperand + " - " + secondOperand + " = " + (firstOperand - secondOperand));
                break;
            default:
                System.out.print("Wrong Input!! Invalid Operator");
        }
        br.close();
    }
}
