public class Demoexception {
    public static void main(String[] args) {
        int i, j, k = 0;
        int a[] = new int[4];
        i = 8;
        j = 0;
        try {
            k = i / j; // This will throw ArithmeticException
            for (int c = 0; c < 4; c++) { // Loop should go from 0 to 3 to stay within array bounds
                a[c] = c + 1;
            }
            for (int value : a) {
                System.out.println(value);
            }
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Maximum number of values is 4: " + e);
        }
    }
}
 