import edu.duke.FileResource;

import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.IOException;

public class TestCaesarCipher {
    public static int[] countLetters(String s){
        int letterCnt[]=new int[26];
        String alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i=0;i<s.length();i++){
            char ch=Character.toUpperCase(s.charAt(i));
            int idx=alpha.indexOf(ch);
            if(idx!=-1){
                letterCnt[idx]++;
            }
        }
        return letterCnt;
    }
    public static int maxIndex(int[] a){
        int max=0;
        int maxIdx=0;
        for (int i=0;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
                maxIdx=i;
            }
        }
        return maxIdx;
    }
    public static void simpleTests(){
        FileResource fr=new FileResource();
        String str=fr.toString();
        CaesarCipher cc=new CaesarCipher(18);
        System.out.println("Encrypted String: "+cc.encrypt(str));
        System.out.println("Decrypted String: "+cc.decrypt(cc.encrypt(str)));
        System.out.println(breakCaesarCipher(cc.encrypt(str)));
    }
    public static String breakCaesarCipher(String input){
        int[] cnt=countLetters(input);
        int idx=maxIndex(cnt);
        int key=idx-4;
        if(idx<4){
            key=26-(4-idx);
        }
        CaesarCipher cc=new CaesarCipher(key);
        return cc.decrypt(input);
    }
    public static void main(String args[])throws IOException{
        simpleTests();
    }
}
