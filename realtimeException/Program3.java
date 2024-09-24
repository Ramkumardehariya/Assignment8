
class DataNotFoundException extends Exception {
    public DataNotFoundException(String message) {
        super(message);
    }
}

class CalculationException extends RuntimeException {
    public CalculationException(String message) {
        super(message);
    }
}


class PremiumCalculator {

    public double calculateLifePremium(int age, boolean hasHealthIssues) throws DataNotFoundException {
       
        if (age <= 0) {
            throw new DataNotFoundException("Age data is missing or invalid.");
        }

        
        double basePremium = 5000;
        if (age > 50) {
            basePremium += 2000;
        }
        if (hasHealthIssues) {
            basePremium += 3000;
        }

        return basePremium;
    }

    
    public double calculateHealthPremium(int age, boolean hasPreExistingConditions) throws DataNotFoundException {
       
        if (age <= 0) {
            throw new DataNotFoundException("Age data is missing or invalid.");
        }

        
        double basePremium = 4000;
        if (age > 45) {
            basePremium += 2500;
        }
        if (hasPreExistingConditions) {
            basePremium += 3500;
        }

        return basePremium;
    }

    
    public double calculateVehiclePremium(String vehicleType, int vehicleAge) throws DataNotFoundException {
        
        if (vehicleType == null || vehicleType.isEmpty()) {
            throw new DataNotFoundException("Vehicle type data is missing.");
        }

        
        double basePremium;
        switch (vehicleType.toLowerCase()) {
            case "car":
                basePremium = 3000;
                break;
            case "bike":
                basePremium = 1500;
                break;
            case "truck":
                basePremium = 5000;
                break;
            default:
                throw new CalculationException("Invalid vehicle type for premium calculation.");
        }

        
        if (vehicleAge > 5) {
            basePremium += 1000;
        }

        return basePremium;
    }
}

public class Program3 {
    public static void main(String[] args) {
        PremiumCalculator calculator = new PremiumCalculator();

        int age = 55;
        boolean hasHealthIssues = true;
        String vehicleType = "car";
        int vehicleAge = 6;

        try {
            double lifePremium = calculator.calculateLifePremium(age, hasHealthIssues);
            System.out.println("Life Insurance Premium: $" + lifePremium);

            double healthPremium = calculator.calculateHealthPremium(age, hasHealthIssues);
            System.out.println("Health Insurance Premium: $" + healthPremium);

            double vehiclePremium = calculator.calculateVehiclePremium(vehicleType, vehicleAge);
            System.out.println("Vehicle Insurance Premium: $" + vehiclePremium);

        } catch (DataNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            logError(e);
        } catch (CalculationException e) {
         
            System.out.println("Error: " + e.getMessage());
            logError(e);
        } catch (Exception e) {
      
            System.out.println("Unexpected error: " + e.getMessage());
            logError(e);
        }
    }

    
    public static void logError(Exception e) {
        System.out.println("Logging error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
    }
}
