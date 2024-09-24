package basicException;
import java.util.Scanner;

class NegativeNumberException extends RuntimeException{
    NegativeNumberException(String message){
        super(message);
    }
}

public class Program4 {

    void validate(int num){
        if(num < 0){
            throw new NegativeNumberException("Money cannot negative ");
        }
        else{
            System.out.println("Money is possible: ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Program4 p = new Program4();

        System.out.println("Enter any number: ");

        int num = sc.nextInt();

        try {
            p.validate(num);
        } catch (NegativeNumberException e) {
            System.out.println("Cautch message: ");
            System.out.println(e.getMessage());
        }
    }
}
