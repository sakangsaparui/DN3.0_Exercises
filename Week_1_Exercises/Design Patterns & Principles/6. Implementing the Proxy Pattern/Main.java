import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the name of the image to display (or 'exit' to quit):");
            String filename = scanner.nextLine();

            if ("exit".equalsIgnoreCase(filename)) {
                break;
            }

            Image image = new ProxyImage(filename);
            image.display();
        }

        scanner.close();
    }
}
