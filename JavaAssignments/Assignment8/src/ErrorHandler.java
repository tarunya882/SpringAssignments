import java.io.*;
import java.util.*;
public class ErrorHandler{
    public static void errorThrower(){
        try{
            int x=0;
            int y=10;
            int divide=y/x;

            int a[]=new int[5];
            int s=a[10];

            int b[ ] = null;
            int j = b[0] ;
        }
        catch (Exception a){
            a.getMessage();
        }
        finally {
            System.out.println("All errors are caught");
        }
    }
    public static void main(String[] args)throws IOException{
        errorThrower();
    }
}
