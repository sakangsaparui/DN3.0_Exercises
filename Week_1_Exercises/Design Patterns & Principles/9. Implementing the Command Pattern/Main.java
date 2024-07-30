import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        while (true) {
            System.out.println("Enter 'on' to turn the light on, 'off' to turn the light off, or 'exit' to quit:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("on")) {
                remote.setCommand(lightOn);
                remote.pressButton();
            } else if (input.equalsIgnoreCase("off")) {
                remote.setCommand(lightOff);
                remote.pressButton();
            } else if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid input. Please enter 'on', 'off', or 'exit'.");
            }
        }

        scanner.close();
    }
}
