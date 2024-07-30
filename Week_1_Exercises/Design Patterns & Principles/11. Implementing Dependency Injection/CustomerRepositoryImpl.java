import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private List<Customer> customers;

    public CustomerRepositoryImpl() {
        // Initialize with some dummy customers
        customers = new ArrayList<>();
        customers.add(new Customer(1, "Shinchan Nohara"));
        customers.add(new Customer(2, "Jeffrey Dahmer"));
        customers.add(new Customer(3, "Captain America"));
        customers.add(new Customer(4, "Bob The Builder"));
        customers.add(new Customer(5, "Baba Ramdev"));
    }

    @Override
    public Customer findCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}
