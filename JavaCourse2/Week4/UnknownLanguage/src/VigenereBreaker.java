import java.io.File;
import java.io.IOException;
import java.io.*;
import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public static String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        StringBuilder sliced=new StringBuilder();
        for (int i=whichSlice;i<message.length();i=i+totalSlices){
            sliced.append(message.charAt(i));
            //sliced=sliced+message.charAt(i);
        }
        return sliced.toString();
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
        String words[]=message.split("\\W+");
        for(String word:words){
            word=word.toLowerCase();
            if(dictionary.contains(word)){
                realWrd++;
            }
        }
        System.out.println("No of real words "+realWrd);
        return realWrd;
    }
    public static String breakForLanguage(String encrypted,HashSet<String>dictionary){
        int maxRealCnt=Integer.MIN_VALUE;
        String maxRealWrd="";
        Character ch=mostCommonCharIn(dictionary);
        for (int i=1;i<=100;i++){
            int[] key=tryKeyLength(encrypted,i,ch);
            VigenereCipher vc=new VigenereCipher(key);
            String st=vc.decrypt(encrypted);
            int cntReal=countWords(st,dictionary);
            if(cntReal>maxRealCnt) {
                maxRealCnt = cntReal;
                maxRealWrd=st;
            }
        }
        System.out.println(maxRealCnt);
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
    public static char mostCommonCharIn(HashSet<String>dictionary){
        HashMap<Character,Integer>hm=new HashMap<Character,Integer>();
        int maxcnt=0;
        Character maxCh='a';
        for(String str:dictionary){
            for (int i=0;i<str.length();i++){
                if(hm.containsKey(str.charAt(i))){
                    hm.put(str.charAt(i),hm.get(str.charAt(i))+1);
                }
                else
                    hm.put(str.charAt(i),1);
            }
        }
        for(Character ch: hm.keySet()){
            int cnt=hm.get(ch);
            if(cnt>maxcnt){
                maxcnt=cnt;
                maxCh=ch;
            }
        }
        return maxCh;
    }
    public static void breakForAllLangs(String encrypted,HashMap<String,HashSet<String>>languages){
        for(String s:languages.keySet()){
            HashSet<String>hs=languages.get(s);
            String st=breakForLanguage(encrypted,hs);
            System.out.println(st);
        }
    }
    public static void breakVigenere () {
        //WRITE YOUR CODE HERE
        System.out.println("Select a file to decrypt");
        FileResource fr=new FileResource();
        String str=fr.asString().toLowerCase();
        HashMap<String,HashSet<String>>langwrdMap=new HashMap<String,HashSet<String>>();
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource fre=new FileResource(f);
            HashSet<String>hs=readDictionary(fre);
            String name=f.getName();
            langwrdMap.put(name,hs);
        }
        breakForAllLangs(str,langwrdMap);
    }
    public static void main(String args[])throws IOException{
        breakVigenere();
    }
}
