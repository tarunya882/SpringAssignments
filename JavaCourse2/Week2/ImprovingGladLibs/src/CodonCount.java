import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

import edu.duke.*;
import org.apache.commons.csv.*;
public class CodonCount {
    private HashMap<String,Integer>codonMap;
    public CodonCount(){
        this.codonMap=new HashMap<>();
    }
    public void buildCodonMap(int start,String dna){
        codonMap.clear();
        for (int i=start;i<dna.length()-3;i+=3){
            String codon=dna.substring(i,i+3);
            if(this.codonMap.containsKey(codon)){
                int cnt=this.codonMap.get(codon);
                this.codonMap.put(codon,cnt+1);
            }
            else
                this.codonMap.put(codon,1);
        }
    }
    public String getMostCommonCodon(){
        int largeCodon=0;
        String freqCodon="";
        for(String st:this.codonMap.keySet()){
            if(this.codonMap.get(st)>largeCodon){
                largeCodon=this.codonMap.get(st);
                freqCodon=st;
            }
        }
        return freqCodon;
    }
    public void printCodonCounts(int start,int end){
        for (String st:this.codonMap.keySet()){
            int cnt=this.codonMap.get(st);
            if(cnt>=start&&cnt<=end)
                System.out.println(st+" "+this.codonMap.get(st));
        }
    }
    public void tester(){
        FileResource fr=new FileResource("smalldna.txt");
        String dna= fr.asString().toUpperCase();
        for (int i=0;i<3;i++){
            this.buildCodonMap(i,dna);
            System.out.println(getMostCommonCodon());
            printCodonCounts(1,4);
        }
    }
    public static void main(String[] args)throws IOException{
        CodonCount cc=new CodonCount();
        cc.tester();
    }
}
