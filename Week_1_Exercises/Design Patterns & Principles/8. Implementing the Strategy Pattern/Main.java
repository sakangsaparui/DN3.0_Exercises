// Main.java
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Create payment context
            PaymentContext paymentContext = new PaymentContext();

            // Get user input for payment method
            System.out.println("Choose payment method: ");
            System.out.println("1. Credit Card");
            System.out.println("2. PayPal");

            int choice = 0;
            boolean validChoice = false;

            // Input validation for payment method choice
            while (!validChoice) {
                try {
                    choice = scanner.nextInt();
                    if (choice == 1 || choice == 2) {
                        validChoice = true;
                    } else {
                        System.out.println("Invalid choice. Please enter 1 for Credit Card or 2 for PayPal.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear invalid input
                }
            }
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter cardholder name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter card number: ");
                    String cardNumber = scanner.nextLine();
                    paymentContext.setPaymentStrategy(new CreditCardPayment(name, cardNumber));
                    break;
                case 2:
                    System.out.print("Enter PayPal email: ");
                    String email = scanner.nextLine();
                    paymentContext.setPaymentStrategy(new PayPalPayment(email));
                    break;
            }

            // Input validation for payment amount
            int amount = 0;
            boolean validAmount = false;

            while (!validAmount) {
                try {
                    System.out.print("Enter amount to pay: ");
                    amount = scanner.nextInt();
                    if (amount > 0) {
                        validAmount = true;
                    } else {
                        System.out.println("Amount must be greater than 0.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid amount.");
                    scanner.next(); // Clear invalid input
                }
            }

            // Execute payment
            paymentContext.executePayment(amount);

        } finally {
            scanner.close(); // Ensure scanner is closed
        }
    }
}
