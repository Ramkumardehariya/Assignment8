import java.util.HashMap;
import java.util.Map;

class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}

class InvalidCustomerDataException extends RuntimeException {
    public InvalidCustomerDataException(String message) {
        super(message);
    }
}

class Customer {
    private int id;
    private String name;
    private String email;

   
    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidCustomerDataException("Invalid customer name.");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new InvalidCustomerDataException("Invalid email format.");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer[ID=" + id + ", Name=" + name + ", Email=" + email + "]";
    }
}
class CustomerManagementSystem {
    private Map<Integer, Customer> customers;

    
    public CustomerManagementSystem() {
        customers = new HashMap<>();
    }

    
    public void addCustomer(int id, String name, String email) {
        if (customers.containsKey(id)) {
            throw new InvalidCustomerDataException("Customer with this ID already exists.");
        }
        Customer customer = new Customer(id, name, email);
        customers.put(id, customer);
        System.out.println("Customer added successfully: " + customer);
    }

    
    public void updateCustomer(int id, String name, String email) throws CustomerNotFoundException {
        Customer customer = customers.get(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
        }
        customer.setName(name);
        customer.setEmail(email);
        System.out.println("Customer updated successfully: " + customer);
    }

    
    public void deleteCustomer(int id) throws CustomerNotFoundException {
        Customer customer = customers.remove(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
        }
        System.out.println("Customer deleted successfully: " + customer);
    }

    
    public void getCustomer(int id) throws CustomerNotFoundException {
        Customer customer = customers.get(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
        }
        System.out.println("Customer details: " + customer);
    }
}

public class Program5 {
    public static void main(String[] args) {
        CustomerManagementSystem cms = new CustomerManagementSystem();

        try {
            cms.addCustomer(1, "John Doe", "john@example.com");
            cms.addCustomer(2, "Jane Smith", "jane@example.com");
            cms.updateCustomer(1, "Johnathon Doe", "johnathon@example.com");
            cms.deleteCustomer(2);
            cms.deleteCustomer(3);

        } catch (CustomerNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            logError(e);
        } catch (InvalidCustomerDataException e) {
            System.out.println("Data validation error: " + e.getMessage());
            logError(e);
        }
    }

    
    public static void logError(Exception e) {
        System.out.println("Logging error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
    }
}
