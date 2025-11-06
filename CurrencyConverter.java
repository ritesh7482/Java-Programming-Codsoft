import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    // Static exchange rate table (base: USD)
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD", 1.0);      // Base
        exchangeRates.put("INR", 83.20);    // Indian Rupee
        exchangeRates.put("EUR", 0.93);     // Euro
        exchangeRates.put("GBP", 0.80);     // British Pound
        exchangeRates.put("JPY", 151.50);   // Japanese Yen
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=======================================");
        System.out.println("         💱 CURRENCY CONVERTER");
        System.out.println("=======================================");

        while (true) {
            System.out.println("\nAvailable Currencies: USD, INR, EUR, GBP, JPY");
            System.out.print("Enter base currency (e.g., USD): ");
            String from = sc.next().toUpperCase();

            System.out.print("Enter target currency (e.g., INR): ");
            String to = sc.next().toUpperCase();

            if (!exchangeRates.containsKey(from) || !exchangeRates.containsKey(to)) {
                System.out.println("⚠️  Invalid currency code! Please try again.");
                continue;
            }

            System.out.print("Enter amount to convert: ");
            double amount = sc.nextDouble();

            if (amount <= 0) {
                System.out.println("⚠️  Amount must be greater than 0!");
                continue;
            }

            double convertedAmount = convertCurrency(from, to, amount);

            System.out.println("\n---------------------------------------");
            System.out.printf("💰 %.2f %s = %.2f %s%n", amount, from, convertedAmount, to);
            System.out.println("---------------------------------------");

            System.out.print("\nDo you want to convert another amount? (yes/no): ");
            String again = sc.next().trim().toLowerCase();

            if (!again.equals("yes")) {
                System.out.println("\n👋 Thank you for using the Currency Converter!");
                break;
            }
        }

        sc.close();
    }

    // Method to perform conversion
    private static double convertCurrency(String from, String to, double amount) {
        double amountInUSD = amount / exchangeRates.get(from);  // Convert to USD first
        return amountInUSD * exchangeRates.get(to);             // Convert to target currency
    }
}
