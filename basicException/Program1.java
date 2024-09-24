package basicException;
import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        System.out.println("Enter a second number for divide: ");
        int d = sc.nextInt();
        int s = 0;

        try {
            s = n/d;
        } catch (ArithmeticException e) {
            System.out.println("here is arithmatic exception: ");
        }

        System.out.println(s);
    }
}
