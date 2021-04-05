import edu.duke.FileResource;

import java.io.IOException;

public class CaesarBreaker {
    public static String decrypt(String encrypt,int key){
        CaesarCipher cc=new CaesarCipher();
        String message = cc.encrypt(encrypt, 26 - key);
        return message;
    }
    public static String halfOfString(String message,int start){
        String hS="";
        for(int i=start;i<message.length();i=i+2){
            hS=hS+message.charAt(i);
        }
        return hS;
    }
    public static int getKey(String s){
        int[] cl=countLetters(s);
        int maxIdx=maxIndex(cl);
        return maxIdx;
    }
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

    public static String decryptTwoKeys(String encrypted){
        String str1=halfOfString(encrypted,0);
        String str2=halfOfString(encrypted,1);
        int key1=getKey(str1);
        int key2=getKey(str2);
        CaesarCipher cc=new CaesarCipher();
        String decrypted=cc.encryptTwoKeys(encrypted,26-key1,26-key2);
        System.out.println(key1+" "+key2);
        return decrypted;
    }
    public static void testDecrypt(){
        FileResource fr=new FileResource("wordsLotsOfEsEncrypted.txt");
        String str=fr.toString();
        System.out.println(decryptTwoKeys(str));
    }
    public static void testHalf(){
        System.out.println(halfOfString("Qbkm Zgis", 0));
    }
    public static void main(String args[])throws IOException{
        testDecrypt();
        testHalf();
    }
}


