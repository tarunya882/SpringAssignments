import edu.duke.*;

import java.io.IOException;

public class TestCaesarCipherTwo {
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
    public static String halfOfString(String message,int start){
        String hS="";
        for(int i=start;i<message.length();i=i+2){
            hS=hS+message.charAt(i);
        }
        return hS;
    }
    public static String breakCaesarCipher(String input){
        String input1=halfOfString(input,0);
        String input2=halfOfString(input,1);
        int[] cnt1=countLetters(input1);
        int idx1=maxIndex(cnt1);
        int key1=idx1-4;
        if(idx1<4){
            key1=26-(4-idx1);
        }
        int[] cnt2=countLetters(input1);
        int idx2=maxIndex(cnt2);
        int key2=idx2-4;
        if(idx2<4){
            key2=26-(4-idx2);
        }
        CaesarCipherTwo cc=new CaesarCipherTwo(key1,key2);
        return cc.decrypt(input);
    }
    public static void simpleTests(){
        FileResource fr=new FileResource();
        String str=fr.toString();
        CaesarCipherTwo cc=new CaesarCipherTwo(17,3);
        System.out.println("Encrypted String: "+cc.encrypt(str));
        System.out.println("Decrypted String: "+cc.decrypt(cc.encrypt(str)));
        System.out.println(breakCaesarCipher(cc.encrypt(str)));
    }
    public static void main(String args[])throws IOException{
        simpleTests();
    }
}
