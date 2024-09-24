import java.util.Map;
import java.util.HashMap;
class UpgradeNotAllowedException extends Exception {
    public UpgradeNotAllowedException(String message) {
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
    private String type; 
    private boolean isEligibleForUpgrade;


    public Policy(int id, String type, boolean isEligibleForUpgrade) {
        this.id = id;
        this.type = type;
        this.isEligibleForUpgrade = isEligibleForUpgrade;
    }


    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public boolean isEligibleForUpgrade() {
        return isEligibleForUpgrade;
    }


    public void upgrade() {
        if ("Basic".equals(type)) {
            type = "Standard"; 
        } else if ("Standard".equals(type)) {
            type = "Premium"; 
        }
    }
}


class PolicyUpgrade {
    private Map<Integer, Policy> policies;

    
    public PolicyUpgrade() {
        policies = new HashMap<>();
    }


    public void addPolicy(int id, String type, boolean isEligibleForUpgrade) {
        Policy policy = new Policy(id, type, isEligibleForUpgrade);
        policies.put(id, policy);
        System.out.println("Policy added successfully: ID=" + id + ", Type=" + type);
    }

  
    public void upgradePolicy(int id) throws UpgradeNotAllowedException, PolicyNotFoundException {
        Policy policy = policies.get(id);
        if (policy == null) {
            throw new PolicyNotFoundException("Policy with ID " + id + " not found.");
        }

        if (!policy.isEligibleForUpgrade()) {
            throw new UpgradeNotAllowedException("Upgrade not allowed for policy ID " + id + ": not eligible for upgrade.");
        }

        
        policy.upgrade();
        System.out.println("Policy with ID " + id + " has been upgraded to " + policy.getType() + ".");
    }
}

public class Program8 {
    public static void main(String[] args) {
        PolicyUpgrade policyUpgrade = new PolicyUpgrade();

        
        policyUpgrade.addPolicy(1, "Basic", true);
        policyUpgrade.addPolicy(2, "Standard", true);
        policyUpgrade.addPolicy(3, "Premium", false); 

        try {
            policyUpgrade.upgradePolicy(1); 
            policyUpgrade.upgradePolicy(2); 
            policyUpgrade.upgradePolicy(3); 

        } catch (UpgradeNotAllowedException e) {
            System.out.println("Upgrade error: " + e.getMessage());
            logError(e);
        } catch (PolicyNotFoundException e) {
            System.out.println("Policy error: " + e.getMessage());
            logError(e);
        }
    }

    public static void logError(Exception e) {
        System.out.println("Logging error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
    }
}
