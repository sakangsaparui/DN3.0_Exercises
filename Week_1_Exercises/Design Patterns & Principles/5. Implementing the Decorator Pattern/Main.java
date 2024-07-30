import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Notifier emailNotifier = new EmailNotifier();

        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        while (true) {
            System.out.println("Enter your message:");
            String message = scanner.nextLine();

            slackNotifier.send(message);

            System.out.println("Do you want to send another notification? (yes/no)");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("no")) {
                break;
            }
        }

        scanner.close();
    }
}
