import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student student = new Student();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        while (true) {
            view.displayMenu();
            int choice = scanner.nextInt();
            controller.processInput(choice, scanner);
        }
    }
}
