import java.util.Scanner;

public class SwapOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("Original numbers:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // Swapping numbers using a temporary variable
        int temp = a;
        a =b;
        b = temp;

        System.out.println("After swapping:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
