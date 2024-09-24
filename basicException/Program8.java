package basicException;
import java.io.IOException;

public class Program8 {

    void filecheck()throws IOException{
        try{
            throw new IOException("file reading time exception: ");
        }
        catch(Exception e){
            throw new IOException("file is not here: ");
        }
    }
    public static void main(String[] args) {

        Program8 p =new Program8();
        try {
            p.filecheck();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }
}
