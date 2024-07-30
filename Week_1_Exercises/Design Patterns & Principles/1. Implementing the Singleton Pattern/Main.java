// SingletonTest.java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        if (logger1 == logger2) {
            System.out.println("Logger is a singleton. Both references point to the same instance.");
        } else {
            System.out.println("Logger is not a singleton. References point to different instances.");
        }
        System.out.print("Enter a message to log: ");
        String message = scanner.nextLine();

        logger1.log(message);

        scanner.close();
    }
}
