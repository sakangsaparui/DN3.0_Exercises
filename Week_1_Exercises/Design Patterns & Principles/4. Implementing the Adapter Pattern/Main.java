import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PayPalGateway payPalGateway = new PayPalGateway();
        StripeGateway stripeGateway = new StripeGateway();
        SquareGateway squareGateway = new SquareGateway();

        PaymentProcessor payPalAdapter = new PayPalAdapter(payPalGateway);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeGateway);
        PaymentProcessor squareAdapter = new SquareAdapter(squareGateway);

        while (true) {
            System.out.println("Select payment gateway:");
            System.out.println("1. PayPal");
            System.out.println("2. Stripe");
            System.out.println("3. Square");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Exiting...");
                break;
            }

            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            System.out.print("Enter amount to process: $");
            double amount = scanner.nextDouble();

            switch (choice) {
                case 1:
                    payPalAdapter.processPayment(amount);
                    break;
                case 2:
                    stripeAdapter.processPayment(amount);
                    break;
                case 3:
                    squareAdapter.processPayment(amount);
                    break;
            }
        }

        scanner.close();
    }
}
