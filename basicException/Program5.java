package basicException;
import java.util.Scanner;

public class Program5 {

    int divide(int num, int d){
        return num/d;   
    }

    void stringPrint(String str){
        System.out.println("String length is: "+str.length());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Program5 p = new Program5();

        
        try {
            int result = p.divide(10,0);
            System.out.println(result);

            String str = null;
            p.stringPrint(str);

        } 
        catch (ArithmeticException e) {
            System.out.println("here is arithmatic exception: ");
        }
        catch(NullPointerException e2){
            System.out.println("nullPointer exception occurr");
        }
        catch(Exception e){
            System.out.println("this is generic exception");
        }
        finally{
            System.out.println("This is finally code");
        }
    }
}
