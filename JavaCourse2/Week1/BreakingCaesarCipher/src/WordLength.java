import edu.duke.FileResource;

import java.io.File;
import java.io.IOException;

public class WordLength {
    public static void countWordLengths(FileResource resource,int[] counts){
        for (String word:resource.words()){
            int len=word.length();
            Character c1=word.charAt(0);
            Character c2=word.charAt(len-1);
            if(!Character.isLetter(c1))
                len--;
            if(!Character.isLetter(c2)&&len!=1)
                len--;
            counts[len]++;
        }
        for(int i=0;i<counts.length;i++){
            System.out.println("Words of length "+i +" "+counts[i]);
        }
    }
    public static void testCountWordLengths(){
        FileResource fr=new FileResource("smallHamlet.txt");
        int counts[]=new int[31];
        countWordLengths(fr,counts);
    }
    public static int indexOfMax(int[] values){
        int max=0;
        int maxIdx=0;
        for(int i=0;i<values.length;i++){
            if(values[i]>max) {
                max = values[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    public static void main(String args[])throws IOException{
        testCountWordLengths();
    }
}
