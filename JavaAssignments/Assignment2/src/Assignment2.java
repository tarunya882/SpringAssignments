import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        CheckString cs=new CheckString();
        System.out.println(cs.checkString(input));
    }
}
