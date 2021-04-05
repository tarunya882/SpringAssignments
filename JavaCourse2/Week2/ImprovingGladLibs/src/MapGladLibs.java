import edu.duke.*;
import java.util.*;

public class MapGladLibs {
   /* private ArrayList<String> adjectiveList;
    private ArrayList<String> nounList;
    private ArrayList<String> colorList;
    private ArrayList<String> countryList;
    private ArrayList<String> nameList;
    private ArrayList<String> animalList;
    private ArrayList<String> timeList;
    private ArrayList<String> fruitList;
    private ArrayList<String> verbsLIst;*/
    private HashMap<String,ArrayList<String>>myMap;
    private ArrayList<String>wordSeen;
    private ArrayList<String>categoryList;
    private Random myRandom;
    private int totalWords=0;



    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";

    public MapGladLibs(){
        myMap=new HashMap<String, ArrayList<String>>();
        wordSeen=new ArrayList<String>();
        categoryList=new ArrayList<String>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
     //   myMap=new HashMap<String, ArrayList<String>>();
    }

    public MapGladLibs(String source){
        myMap=new HashMap<String, ArrayList<String>>();
        wordSeen=new ArrayList<String>();
        categoryList=new ArrayList<String>();
        initializeFromSource(source);
        myRandom = new Random();
    }

    private void initializeFromSource(String source) {
        /*adjectiveList= readIt(source+"/adjective.txt");
        nounList = readIt(source+"/noun.txt");
        colorList = readIt(source+"/color.txt");
        countryList = readIt(source+"/country.txt");
        nameList = readIt(source+"/name.txt");
        animalList = readIt(source+"/animal.txt");
        timeList = readIt(source+"/timeframe.txt");
        fruitList=readIt(source+"/fruit.txt");
        verbList=readIt(source+"/verb.txt");*/
        String category[]={"adjective","noun","color","country","name","animal","timeframe","fruit","verb"};
        for (String s:category){
            ArrayList<String>words=readIt(source+"/"+s+".txt");
            myMap.put(s,words);
        }
    }


    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }

    private String getSubstitute(String label) {
        if(!categoryList.contains(label)){
            categoryList.add(label);
        }
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        else if(myMap.containsKey(label)){
            return randomFrom(myMap.get(label));
        }
        else
            return "**UNKNOWN**";
    }
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        String prefix = w.substring(0,first);
        String suffix = w.substring(last+1);
        String sub="";
        while (true){
            sub = getSubstitute(w.substring(first+1,last));
            int idx=wordSeen.indexOf(sub);
            if(idx!=-1) {
                wordSeen.add(sub);
                totalWords++;
            }
            else
                break;
        }
        return prefix+sub+suffix;
    }

    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }

    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }

    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    public int totalWordsInMap(){
        int wordCnt=0;
        for(String s:myMap.keySet()){
            wordCnt=myMap.get(s).size();
        }
        return wordCnt;
    }

    private int totalWordsConsidered(){
        int totalWrds=0;
        for (String key:myMap.keySet()){
            if(categoryList.contains(key))
                totalWrds+=myMap.get(key).size();
        }
        return totalWrds;
    }
    public void makeStory(){
        System.out.println("\n");
        String story1=fromTemplate("madtemplate2.txt");
        printOut(story1, 60);
        System.out.println("No of words replaced "+totalWords);
        System.out.println("Total words in map "+totalWordsInMap());
        System.out.println("Total words considered "+totalWordsConsidered());
    }

    public static void main(String[] args) {
        MapGladLibs mg=new MapGladLibs();
        mg.makeStory();
    }
}
