import java.util.Scanner;

public class Main {

    public static void handleUserInput(double currentValue, double growthRate, int years) {

        double futureValue = predictFutureValue(currentValue, growthRate, years);

        System.out.printf("The predicted future value after %d years is: %.2f%n", years, futureValue);

        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to perform another calculation? (yes/no): ");
        String response = sc.next().trim().toLowerCase();

        if (response.equals("yes")) {
    
            System.out.print("Enter the current value: ");
            currentValue = sc.nextDouble();
            
            System.out.print("Enter the annual growth rate (in %): ");
            growthRate = sc.nextDouble() / 100;
            
            System.out.print("Enter the number of years: ");
            years = sc.nextInt();

            handleUserInput(currentValue, growthRate, years);
        } else {

            System.out.println("Thank you for using the financial forecasting tool!");
        }
        sc.close();
    }

    public static double predictFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        } else {
            return predictFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the current value: ");
        double currentValue = scanner.nextDouble();

        System.out.print("Enter the annual growth rate (in %): ");
        double growthRate = scanner.nextDouble() / 100;

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        handleUserInput(currentValue, growthRate, years);

        scanner.close();
    }
    
}
