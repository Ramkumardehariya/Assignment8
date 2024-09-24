import java.util.Scanner;


class InvalidAgeException extends Exception{
    InvalidAgeException(String message){
        super(message);
    }
}

class PoorDrivingRecordException extends Exception{

    PoorDrivingRecordException(String message){
        super(message);
    }
}

class HealthIssueException extends Exception{
    HealthIssueException(String message){
        super(message);
    }
}

class PolicyApplication{

    void validateAge(int age) throws InvalidAgeException{
        if(age < 18 || age > 65){
            throw new InvalidAgeException("Your age must be greater than 18 and less than 65");
        }
        
    }

    void validateAccident(int accident) throws PoorDrivingRecordException{
        if(accident > 2){
            throw new PoorDrivingRecordException("Poor driving record");
        }
        
    }
    void validateHealth(int health) throws HealthIssueException{
        if(health > 1){
            throw new HealthIssueException("Your health is not good");
        }
        
    }

    void checkProcess(int age, int accident, int health) throws InvalidAgeException, PoorDrivingRecordException, HealthIssueException{
        validateAge(age);
        validateAccident(accident);
        validateHealth(health);
        System.out.println("Application process successfully ");
    }
}


public class Program1 {

    void logError(Exception e){
        System.out.println("Logging Error "+e.getClass().getSimpleName()+" - "+e.getMessage());
    }
    public static void main(String[] args) {
        PolicyApplication process = new PolicyApplication();
        Program1 p = new Program1();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your age: ");
        int age = sc.nextInt();

        System.out.println("Enter your accident record: ");
        int accident = sc.nextInt();

        System.out.println("Enter your health issuse: ");
        int health = sc.nextInt();

        try{
            process.checkProcess(age, accident, health);
        }
        catch(InvalidAgeException | PoorDrivingRecordException | HealthIssueException e){
            System.out.println("Error processing application");
            p.logError(e);
        }
    }
}
