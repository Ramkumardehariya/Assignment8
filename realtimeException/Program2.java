import java.time.LocalDate;

class FraudulentClaimException extends RuntimeException {
    public FraudulentClaimException(String message) {
        super(message);
    }
}

class InvalidClaimAmountException extends RuntimeException {
    public InvalidClaimAmountException(String message) {
        super(message);
    }
}

class ClaimProcessingSystem {

    public void processClaim(double claimAmount, LocalDate claimDate, double coverageAmount, LocalDate policyStartDate) {
        
        if (claimAmount > coverageAmount) {
            throw new InvalidClaimAmountException("Claim amount exceeds policy coverage.");
        }

        if (claimDate.isBefore(policyStartDate)) {
            throw new FraudulentClaimException("Claim date is before policy start date, possible fraud detected.");
        }

        System.out.println("Claim processed successfully!");
    }
}

public class Program2 {
    public static void main(String[] args) {
        ClaimProcessingSystem claimProcessingSystem = new ClaimProcessingSystem();

        double claimAmount = 5000.0;
        LocalDate claimDate = LocalDate.of(2023, 9, 1);
        double coverageAmount = 4000.0;
        LocalDate policyStartDate = LocalDate.of(2023, 1, 1);

        try {
            claimProcessingSystem.processClaim(claimAmount, claimDate, coverageAmount, policyStartDate);
        } catch (InvalidClaimAmountException | FraudulentClaimException e) {
            System.out.println("Error processing claim: " + e.getMessage());
            notifyClaimsDepartment(e);
        }
    }
    
    public static void notifyClaimsDepartment(RuntimeException e) {
        System.out.println("Sending notification to Claims Department for further investigation...");
        System.out.println("Issue: " + e.getClass().getSimpleName() + " - " + e.getMessage());
    }
}
