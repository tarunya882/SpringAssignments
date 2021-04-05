import java.util.ArrayList;
import java.io.*;
import java.util.Locale;

import edu.duke.*;
import org.apache.commons.csv.*;
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    public WordFrequencies(){
        this.myWords=new ArrayList<String>();
        this.myFreqs=new ArrayList<Integer>();
    }
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr=new FileResource("testwordfreqs.txt");
        for(String str:fr.words()){
            str=str.toLowerCase();
            int idx=myWords.indexOf(str);
            if(idx!=-1){
                int freq=myFreqs.get(idx);
                myFreqs.set(idx,freq+1);
            }
            else{
                myWords.add(str);
                myFreqs.add(1);
            }
        }
    }
    public void tester(){
        findUnique();
        System.out.println("No of unique words "+myWords.size());
        for (int i=0;i<myFreqs.size();i++) {
            System.out.println("Frequency of " +myWords.get(i)+" is "+myFreqs.get(i));
        }
        int idx=findIndexOfMax();
        System.out.println("The word that occurs most often and its count is  "+myWords.get(idx)+ " "+myFreqs.get(idx));
    }
    public int findIndexOfMax(){
        int maxIdx=0;
        int maxVal=myFreqs.get(0);
        for(int i=0;i<myFreqs.size();i++){
            if(myFreqs.get(i)>maxIdx) {
                maxVal = myFreqs.get(i);
                maxIdx=i;
            }
        }
        return maxIdx;
    }
    public static void main(String[] args)throws IOException{
        WordFrequencies wf=new WordFrequencies();
        wf.tester();
    }
}
