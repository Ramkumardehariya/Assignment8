
class QuoteGenerationException extends Exception {
    public QuoteGenerationException(String message) {
        super(message);
    }
}


class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}

class Customer {
    private String name;
    private int age;
    private String healthStatus; 
    private String vehicleType; 

   
    public Customer(String name, int age, String healthStatus, String vehicleType) {
        this.name = name;
        this.age = age;
        this.healthStatus = healthStatus;
        this.vehicleType = vehicleType;
    }

    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}


class InsuranceQuoteSystem {

    public double generateQuote(Customer customer) throws QuoteGenerationException {
        
        if (customer.getAge() < 0) {
            throw new InvalidInputException("Age cannot be negative.");
        }
        if (customer.getHealthStatus() == null || customer.getVehicleType() == null) {
            throw new InvalidInputException("Health status and vehicle type cannot be null.");
        }

        try {
            
            double baseQuote = 100.0;

            if (customer.getAge() < 25) {
                baseQuote += 50; 
            } else if (customer.getAge() > 60) {
                baseQuote += 30; 
            }

            
            switch (customer.getHealthStatus()) {
                case "Poor":
                    baseQuote += 100;
                    break;
                case "Fair":
                    baseQuote += 50; 
                    break;
                case "Good":
                    break;
                default:
                    throw new QuoteGenerationException("Invalid health status.");
            }

            
            if ("Motorcycle".equalsIgnoreCase(customer.getVehicleType())) {
                baseQuote += 70; 
            }

            return baseQuote;

        } catch (Exception e) {
            throw new QuoteGenerationException("Error generating quote: " + e.getMessage());
        }
    }
}

public class Program7 {
    public static void main(String[] args) {
        InsuranceQuoteSystem quoteSystem = new InsuranceQuoteSystem();

        
        Customer customer1 = new Customer("Alice", 22, "Good", "Car");
        Customer customer2 = new Customer("Bob", 45, "Fair", "Motorcycle");
        Customer customer3 = new Customer("Charlie", 65, "Poor", "Car");

        try {
            
            double quote1 = quoteSystem.generateQuote(customer1);
            System.out.println("Quote for " + customer1.getName() + ": $" + quote1);

            double quote2 = quoteSystem.generateQuote(customer2);
            System.out.println("Quote for " + customer2.getName() + ": $" + quote2);

            double quote3 = quoteSystem.generateQuote(customer3);
            System.out.println("Quote for " + customer3.getName() + ": $" + quote3);

        } catch (QuoteGenerationException e) {
            System.out.println("Quote generation error: " + e.getMessage());
            logError(e);
        } catch (InvalidInputException e) {
            System.out.println("Input validation error: " + e.getMessage());
            logError(e);
        }
    }

    
    public static void logError(Exception e) {
        System.out.println("Logging error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
    }
}
