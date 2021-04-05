import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class WordsInFiles {
    private HashMap<String, ArrayList<String>> wordMap;
    public WordsInFiles(){
        this.wordMap=new HashMap<>();
    }
    private void addWordsFromFile(File f){
        FileResource fr=new FileResource(f);
        for (String st:fr.words()){
            if(wordMap.containsKey(st)){
                ArrayList<String>file=new ArrayList<>();
                String fname=f.getName();
                if(!file.contains(fname))
                    file.add(fname);
            }
            else {
                ArrayList<String>file=new ArrayList<>();
                file.add(f.getName());
                wordMap.put(st,file);
            }
        }
    }
    public void buildWordFileMap(){
        wordMap.clear();
        DirectoryResource dr=new DirectoryResource();
        for (File f:dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    public int maxNumber(){
        int maxLen=0;
        for (String st:wordMap.keySet()){
            int len=wordMap.get(st).size();
            if(len>maxLen){
                maxLen=len;
            }
        }
        return maxLen;
    }
    public ArrayList wordsInNumFiles(int number){
        ArrayList<String>words=new ArrayList<>();
        for(String st:wordMap.keySet()){
            int len=wordMap.get(st).size();
            if(len==number){
                words.add(st);
            }
        }
        return words;
    }
    public void printFilesIn(String word){
        ArrayList<String>file=this.wordMap.get(word);
        for (String f:file){
            System.out.println(f+" ");
        }
    }
    public void tester(){
        buildWordFileMap();
        int max=maxNumber();
        ArrayList<String>words=wordsInNumFiles(max);
        for (String st:words){
            printFilesIn(st);
        }
    }
    public static void main(String[] args){
        WordsInFiles wf=new WordsInFiles();
        wf.tester();
    }
}

