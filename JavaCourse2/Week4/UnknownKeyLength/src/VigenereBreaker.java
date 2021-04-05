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
    public static HashSet<String> readDictionary(FileResource fr){
        HashSet<String>strList=new HashSet<String>();
        for(String line: fr.lines()){
            strList.add(line.toLowerCase(Locale.ROOT));
        }
        return strList;
    }
    public static int countWords(String message,HashSet<String>dictionary){
        int realWrd=0;
        String[] words=message.split("\\W+");
        for(String word:words){
            String word1=word.toLowerCase();
            if(dictionary.contains(word1)){
                realWrd+=1;
            }
        }
        System.out.println("len is"+realWrd);
        return realWrd;
    }
    public static String breakForLanguage(String encrypted,HashSet<String>dictionary){
        int maxRealCnt=0;
        String maxRealWrd="";
        for (int i=1;i<=6;i++){
            int[] key=tryKeyLength(encrypted,i,'e');
            VigenereCipher vc=new VigenereCipher(key);
            String st=vc.decrypt(encrypted);
            int cntReal=countWords(st,dictionary);
            if(cntReal>maxRealCnt) {
                maxRealCnt = cntReal;
                maxRealWrd=st;
            }
        }
        return maxRealWrd;
    }
    public static int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        CaesarCracker cc=new CaesarCracker(mostCommon);
        for (int i=0;i<klength;i++){
            String str=sliceString(encrypted,i,klength);
            key[i]=cc.getKey(str);
        }
        return key;
    }


    public static void breakVigenere () {
        //WRITE YOUR CODE HERE
        System.out.println("Select file to decrypt");
        FileResource fr=new FileResource();
     //   String encrypted= fr.asString();
      //  int []key=tryKeyLength(encrypted,5,'e');
      //  VigenereCipher vc=new VigenereCipher(key);
     //   System.out.println("Decrypted message "+vc.decrypt(encrypted));

        FileResource fr1=new FileResource("dictionaries/English");
        HashSet<String>hs=readDictionary(fr1);
        String encrypted= fr.asString().toLowerCase();
        int[] key1=tryKeyLength(encrypted,5,'e');
      //  VigenereCipher vc1=new VigenereCipher(key1);
        String s1=breakForLanguage(encrypted,hs);
        System.out.println("decrypted msg: "+s1);
        System.out.println("Valid words count "+countWords(s1,hs));
    }
    public static void main(String args[])throws IOException{
        breakVigenere();
    }
}
