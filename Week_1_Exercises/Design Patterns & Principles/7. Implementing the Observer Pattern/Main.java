import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter stock name: ");
        String stockName = scanner.nextLine();
        StockMarket stockMarket = new StockMarket(stockName);

        System.out.print("Enter mobile app name: ");
        String mobileAppName = scanner.nextLine();
        Observer mobileApp = new MobileApp(mobileAppName);
        stockMarket.registerObserver(mobileApp);

        System.out.print("Enter web app name: ");
        String webAppName = scanner.nextLine();
        Observer webApp = new WebApp(webAppName);
        stockMarket.registerObserver(webApp);

        boolean running = true;
        while (running) {
            System.out.print("Enter new stock price or type 'exit' to quit: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                running = false;
            } else {
                try {
                    double newPrice = Double.parseDouble(input);
                    stockMarket.setStockPrice(newPrice);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price. Please enter a valid number.");
                }
            }
        }

        scanner.close();
    }
}
