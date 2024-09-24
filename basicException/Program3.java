package basicException;
import java.util.Scanner;

class InvalidAgeException extends Exception{
    InvalidAgeException(String message){
        super(message);
    }
}

public class Program3 {

    void validate(int age) throws InvalidAgeException
    {
        if(age < 18 || age > 100){
            throw new InvalidAgeException("You are not valid for vote ");
        }
        else{
            System.out.println("You are valid for vote ");
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Program3 p = new Program3();

        System.out.println("Enter your age: ");

        int age = sc.nextInt();

        try {
            p.validate(age);
        } catch (InvalidAgeException e) {
            System.out.println("Cautgh a message: ");
            System.out.println(e.getMessage());
        }
        finally{
            sc.close();
            System.out.println("Finally run it ");
        }
    }
}
