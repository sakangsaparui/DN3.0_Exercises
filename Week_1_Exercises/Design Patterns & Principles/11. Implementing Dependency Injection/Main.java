import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        CustomerService customerService = new CustomerService(customerRepository);

        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();

        Customer customer = customerService.getCustomerById(customerId);
        System.out.println("Found customer: " + customer);

        scanner.close();
    }
}
