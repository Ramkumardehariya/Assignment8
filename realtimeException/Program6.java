import java.util.Map;
import java.util.HashMap;

class CancellationNotAllowedException extends Exception {
    public CancellationNotAllowedException(String message) {
        super(message);
    }
}


class PolicyNotFoundException extends Exception {
    public PolicyNotFoundException(String message) {
        super(message);
    }
}


class Policy {
    private int id;
    private String status; 

    
    public Policy(int id) {
        this.id = id;
        this.status = "Active";
    }

    
    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    
    public void cancel() {
        this.status = "Cancelled";
    }
}

class PolicyCancellation {
    private Map<Integer, Policy> policies;

    
    public PolicyCancellation() {
        policies = new HashMap<>();
    }

    
    public void addPolicy(int id) {
        Policy policy = new Policy(id);
        policies.put(id, policy);
        System.out.println("Policy added successfully: ID=" + id);
    }

    
    public void cancelPolicy(int id) throws CancellationNotAllowedException, PolicyNotFoundException {
        Policy policy = policies.get(id);
        if (policy == null) {
            throw new PolicyNotFoundException("Policy with ID " + id + " not found.");
        }
        

        if ("Cancelled".equals(policy.getStatus())) {
            throw new CancellationNotAllowedException("Cancellation not allowed: Policy is already cancelled.");
        }
        
        
        policy.cancel();
        System.out.println("Policy with ID " + id + " has been cancelled.");
    }
}

public class Program6 {
    public static void main(String[] args) {
        PolicyCancellation policyCancellation = new PolicyCancellation();

        
        policyCancellation.addPolicy(1);
        policyCancellation.addPolicy(2);

        try {
            policyCancellation.cancelPolicy(1);
            policyCancellation.cancelPolicy(1);
            
        } catch (CancellationNotAllowedException e) {
            System.out.println("Error: " + e.getMessage());
            logError(e);
        } catch (PolicyNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            logError(e);
        }
    }

    public static void logError(Exception e) {
        System.out.println("Logging error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
    }
}
