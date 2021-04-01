import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String sentence=br.readLine();
        boolean b= Pattern.matches("^[A-Z][^\\.]*.",sentence);
        System.out.println(b);
    }
}