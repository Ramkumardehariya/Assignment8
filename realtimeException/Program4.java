
class PolicyExpiredException extends Exception {
    public PolicyExpiredException(String message) {
        super(message);
    }
}

class PaymentPendingException extends Exception {
    public PaymentPendingException(String message) {
        super(message);
    }
}

class NonComplianceException extends Exception {
    public NonComplianceException(String message) {
        super(message);
    }
}


class PolicyRenewal {

    
    public void renewPolicy(boolean isPolicyExpired, boolean isPaymentPending, boolean isCompliant)
            throws PolicyExpiredException, PaymentPendingException, NonComplianceException {

        
        if (isPolicyExpired) {
            throw new PolicyExpiredException("Policy has expired and cannot be renewed.");
        }

        
        if (isPaymentPending) {
            throw new PaymentPendingException("Policy renewal cannot proceed due to pending payments.");
        }

        
        if (!isCompliant) {
            throw new NonComplianceException("Policyholder has not met compliance requirements for renewal.");
        }

        
        System.out.println("Policy renewed successfully!");
    }
}

public class Program4 {
    public static void main(String[] args) {
        PolicyRenewal policyRenewal = new PolicyRenewal();

        
        boolean isPolicyExpired = false;
        boolean isPaymentPending = true;  
        boolean isCompliant = true;

        try {
            
            policyRenewal.renewPolicy(isPolicyExpired, isPaymentPending, isCompliant);
        } catch (PolicyExpiredException | PaymentPendingException | NonComplianceException e) {
            
            System.out.println("Error: " + e.getMessage());
            notifyPolicyholder(e);
        }
    }

    public static void notifyPolicyholder(Exception e) {
        System.out.println("Notifying policyholder: " + e.getClass().getSimpleName() + " - " + e.getMessage());
    }
}
