import java.util.Scanner;

public class ReverseOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int a = sc.nextInt();
        int reversed = 0;

        while (a != 0) {
            int digit = a % 10; // Get the last digit
            reversed = reversed * 10 + digit; // Append the digit to reversed number
            a /= 10; // Remove the last digit from the original number
        }

        System.out.println("Reversed number: " + reversed);
    }
}
