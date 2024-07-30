public class StudentView {
    public void displayStudentDetails(String name, int id, double grade) {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grade: " + grade);
    }

    public void displayMenu() {
        System.out.println("1. Create/Update Student");
        System.out.println("2. View Student");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    public void promptForName() {
        System.out.print("Enter Student Name: ");
    }

    public void promptForId() {
        System.out.print("Enter Student ID: ");
    }

    public void promptForGrade() {
        System.out.print("Enter Student Grade: ");
    }
}
