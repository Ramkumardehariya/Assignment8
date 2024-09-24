package basicException;
import java.util.Scanner;
import java.util.InputMismatchException;;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        try {
            System.out.println("Enter a number: ");
            int n = sc.nextInt();
    
            System.out.println("Enter a second number for divide: ");
            int d = sc.nextInt();

            int s = n/d;
        } 
        catch (ArithmeticException e) {
            System.out.println("here is arithmatic exception: ");
        }
        catch(InputMismatchException e2){
            System.out.println("Please enter a valid input");
        }
    }
}
