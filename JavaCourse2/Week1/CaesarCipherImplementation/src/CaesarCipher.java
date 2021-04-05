import org.apache.commons.csv.*;
import edu.duke.*;

import java.io.IOException;
import java.util.Locale;

public class CaesarCipher {
    public static String encrypt(String input,int key){
        String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphal=alpha.toLowerCase();
        StringBuilder encrypt=new StringBuilder(input);
        String newStrUpp=alpha.substring(key)+alpha.substring(0,key);
        String newStrLow=alphal.substring(key)+alphal.substring(0,key);
        for (int i=0;i<input.length();i++){
            if(Character.isLowerCase(input.charAt(i))){
                int idx=alphal.indexOf(input.charAt(i));
                if(idx!=-1)
                    encrypt.setCharAt(i,newStrLow.charAt(idx));
            }
            if(Character.isUpperCase(input.charAt(i))){
                int idx=alpha.indexOf(input.charAt(i));
                if(idx!=-1)
                    encrypt.setCharAt(i,newStrUpp.charAt(idx));
            }
        }
        return encrypt.toString();
    }
    public static String encryptTwoKeys(String input,int key1,int key2){
        String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphal=alpha.toLowerCase();
        StringBuilder encrypt=new StringBuilder(input);
        String newStrUpp1=alpha.substring(key1)+alpha.substring(0,key1);
        String newStrLow1=alphal.substring(key1)+alphal.substring(0,key1);
        String newStrUpp2=alpha.substring(key2)+alpha.substring(0,key2);
        String newStrLow2=alphal.substring(key2)+alphal.substring(0,key2);
        for (int i=0;i<input.length();i+=2) {
            if ((i % 2 == 0) && Character.isLowerCase(input.charAt(i))) {
                int idx = alphal.indexOf(input.charAt(i));
                if (idx != -1)
                    encrypt.setCharAt(i, newStrLow1.charAt(idx));
            }
            if (Character.isUpperCase(input.charAt(i))) {
                int idx = alpha.indexOf(input.charAt(i));
                if (idx != -1)
                    encrypt.setCharAt(i, newStrUpp1.charAt(idx));
            }
        }
        for (int i=1;i<input.length();i+=2) {
            if ((i % 2 != 0) && Character.isLowerCase(input.charAt(i))) {
                int idx = alphal.indexOf(input.charAt(i));
                if (idx != -1)
                    encrypt.setCharAt(i, newStrLow2.charAt(idx));
            }
            if (Character.isUpperCase(input.charAt(i))) {
                int idx = alpha.indexOf(input.charAt(i));
                if (idx != -1)
                    encrypt.setCharAt(i, newStrUpp2.charAt(idx));
            }
        }
        return encrypt.toString();
    }
    public static void main(String args[])throws IOException {
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, 23);
        System.out.println("key is " + 23 + "\n" + encrypted);
        System.out.println(encryptTwoKeys("First Legion", 23, 17));
    }
}
