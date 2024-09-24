package basicException;
import java.util.Scanner;
class InsufficientFundException extends Exception{
    InsufficientFundException(String message){
        super(message);
    }
}

public class Program7 {

    void checkBalance(int bal, int w) throws InsufficientFundException{
        if(bal < w){
            throw new InsufficientFundException("Insufficient balance: ");
        }
        else{
            System.out.println("Transaction successfully: ");
            System.out.println("Your balance is: "+(bal-w));
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Program7 p = new Program7();

        System.out.println("Enter a balance: ");
        int bal = sc.nextInt();

        System.out.println("Enter withdraw balance: ");
        int withdraw = sc.nextInt();

        try{
            p.checkBalance(bal, withdraw);
        }
        catch(InsufficientFundException e){
            System.out.println(e.getMessage());
        }
    }
}
