import java.util.Scanner;

public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentId(int id) {
        model.setId(id);
    }

    public void setStudentGrade(double grade) {
        model.setGrade(grade);
    }

    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }

    public void processInput(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                view.promptForName();
                scanner.nextLine();  // Consume newline
                String name = scanner.nextLine();
                setStudentName(name);

                view.promptForId();
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid ID.");
                    scanner.next(); // Consume the invalid input
                }
                int id = scanner.nextInt();
                setStudentId(id);

                view.promptForGrade();
                while (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a valid grade.");
                    scanner.next(); // Consume the invalid input
                }
                double grade = scanner.nextDouble();
                setStudentGrade(grade);
                break;

            case 2:
                updateView();
                break;

            case 3:
                System.out.println("Exiting...");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
