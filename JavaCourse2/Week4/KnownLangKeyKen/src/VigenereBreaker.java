import java.io.File;
import java.io.IOException;
import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public static String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        String sliced="";
        for (int i=whichSlice;i<message.length();i=i+totalSlices){
            sliced=sliced+message.charAt(i);
        }
        return sliced;
    }

    public static int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        CaesarCracker cc=new CaesarCracker(mostCommon);
        for (int i=0;i<key.length;i++){
            String str=sliceString(encrypted,i,klength);
            key[i]=cc.getKey(str);
            System.out.println(key[i]);
        }
        return key;
    }
    public static void testSlice(){
        System.out.println(sliceString("abcdefghijklm", 0, 3));
    }
    public static void breakVigenere () {
        //WRITE YOUR CODE HERE
        FileResource fr=new FileResource();
        String encrypted= fr.asString();
        int []key=tryKeyLength(encrypted,5,'e');
        VigenereCipher vc=new VigenereCipher(key);
        System.out.println(vc.decrypt(encrypted));
    }
    public static void main(String args[])throws IOException{
        breakVigenere();
        testSlice();
    }
}
