import java.util.Scanner;

public class CurrencyConverter {
    // Exchange rates from USD to other currencies
    private static final double EUR_RATE = 0.85; // USD to EUR
    private static final double GBP_RATE = 0.75; // USD to GBP
    private static final double INR_RATE = 75.0; // USD to INR
    private static final double JPY_RATE = 110.0; // USD to JPY

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nCurrency Converter");
            System.out.println("1. USD to EUR");
            System.out.println("2. USD to GBP");
            System.out.println("3. USD to INR");
            System.out.println("4. USD to JPY");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter amount in USD: ");
                double amount = scanner.nextDouble();
                double convertedAmount = convertCurrency(choice, amount);
                String currency = getCurrencyName(choice);
                System.out.printf("Converted Amount: %.2f %s\n", convertedAmount, currency);
            } else if (choice != 5) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        System.out.println("Thank you for using the Currency Converter.");
        scanner.close();
    }

    private static double convertCurrency(int choice, double amount) {
        switch (choice) {
            case 1:
                return amount * EUR_RATE;
            case 2:
                return amount * GBP_RATE;
            case 3:
                return amount * INR_RATE;
            case 4:
                return amount * JPY_RATE;
            default:
                return 0;
        }
    }

    private static String getCurrencyName(int choice) {
        switch (choice) {
            case 1:
                return "EUR";
            case 2:
                return "GBP";
            case 3:
                return "INR";
            case 4:
                return "JPY";
            default:
                return "";
        }
    }
}
