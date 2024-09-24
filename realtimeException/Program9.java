
class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) {
        super(message);
    }
}

class InvalidPaymentDetailsException extends RuntimeException {
    public InvalidPaymentDetailsException(String message) {
        super(message);
    }
}

class PaymentDetails {
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private double amount;

    public PaymentDetails(String cardNumber, String cardHolderName, String expirationDate, double amount) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.amount = amount;
    }

    
    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public double getAmount() {
        return amount;
    }
}


class PaymentProcessingSystem {
    public void processPayment(PaymentDetails paymentDetails) throws PaymentFailedException {
       
        if (paymentDetails.getCardNumber() == null || paymentDetails.getCardNumber().isEmpty()) {
            throw new InvalidPaymentDetailsException("Card number cannot be null or empty.");
        }
        if (paymentDetails.getCardHolderName() == null || paymentDetails.getCardHolderName().isEmpty()) {
            throw new InvalidPaymentDetailsException("Cardholder name cannot be null or empty.");
        }
        if (paymentDetails.getExpirationDate() == null || paymentDetails.getExpirationDate().isEmpty()) {
            throw new InvalidPaymentDetailsException("Expiration date cannot be null or empty.");
        }
        if (paymentDetails.getAmount() <= 0) {
            throw new InvalidPaymentDetailsException("Payment amount must be greater than zero.");
        }

        try {
            if (paymentDetails.getCardNumber().length() < 16) {
                throw new PaymentFailedException("Transaction failed: Invalid card number.");
            }

            System.out.println("Payment of $" + paymentDetails.getAmount() + " processed successfully for " + paymentDetails.getCardHolderName());

        } catch (PaymentFailedException e) {
            throw new PaymentFailedException("Payment processing error: " + e.getMessage());
        }
    }
}

public class Program9 {
    public static void main(String[] args) {
        PaymentProcessingSystem paymentSystem = new PaymentProcessingSystem();

        PaymentDetails payment1 = new PaymentDetails("1234567812345678", "Alice Smith", "12/24", 150.0);
        PaymentDetails payment2 = new PaymentDetails("", "Bob Johnson", "11/25", 100.0); // Invalid card number
        PaymentDetails payment3 = new PaymentDetails("12345678", "Charlie Brown", "10/23", 200.0); // Invalid card number

        
        try {
            paymentSystem.processPayment(payment1); 

        } catch (PaymentFailedException e) {
            System.out.println("Payment error: " + e.getMessage());
            logError(e);
        } catch (InvalidPaymentDetailsException e) {
            System.out.println("Invalid payment details error: " + e.getMessage());
            logError(e);
        }
    }
    public static void logError(Exception e) {
        System.out.println("Logging error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
    }
}
