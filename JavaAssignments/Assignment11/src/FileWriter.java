import java.io.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class InpOutEg {
    public static void main(String[] args) throws FileNotFoundException,IOException{
        File f=new File(args[0]);
        BufferedReader br=new BufferedReader(new FileReader(f));
        Map<Character,Integer>characterCount=new HashMap<Character,Integer>();
        int c;
        File resFile=new File("result.txt");
        BufferedWriter bw=new BufferedWriter(new FileWriter(resFile));
        while ((c=br.read()) != -1){
            char ch=(char) c;
            if(characterCount.containsKey(ch)){
                characterCount.put(ch,characterCount.get(ch)+1);
            }
            else
                characterCount.put(ch,1);
        }
        for(Character ch:characterCount.keySet()){
            bw.write("Character:"+ch+" Count:"+characterCount.get(ch)+"\n");
        }
        bw.flush();
    }
}
