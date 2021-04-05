import org.apache.commons.csv.*;
import edu.duke.*;

import java.io.IOException;

public class WordPlay {
    public static boolean isVowel(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
            return true;
        else if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
            return true;
        else
            return false;
    }
    public static String replaceVowels(String phrase,char ch){
        StringBuilder str=new StringBuilder(phrase);
        for(int i=0;i<str.length();i++){
            if(isVowel(str.charAt(i))){
                str.setCharAt(i,ch);
            }
        }
        return str.toString();
    }
    public static String emphasize(String name,char ch){
        StringBuilder str=new StringBuilder(name);
        for(int i=0;i<str.length();i++){
            if((str.charAt(i)==ch)&&(i+1)%2==0){
                str.setCharAt(i,'+');
            }
            else if(str.charAt(i)==ch&&(i+1)%2!=0)
                str.setCharAt(i,'*');
        }
        return str.toString();
    }
    public static void main(String[] args)throws IOException{
        String str="dna ctgaaactga";
        Character ch='a';
        System.out.println(replaceVowels(str,ch));
        System.out.println(emphasize(str,ch));
        String str1="Mary Bella Abracadabra";
        Character ch1='a';
        System.out.println(replaceVowels(str1,ch1));
        System.out.println(emphasize(str,ch1));
    }
}
