public class Demo {
    public static void main(String[] args) {
        int i, j, k = 0;
        int a[] = new int[4];
        i = 8;
        j = 0;

        try {
            k = i / j; // This will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero: " + e);
        }

        try {
            for (int c = 0; c <=4; c++) { // Ensure the loop stays within array bounds
                a[c] = c +1;
            }
            for (int value : a) {
                System.out.println(value);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Maximum number of values is 4: " + e);
        }
    }
}
