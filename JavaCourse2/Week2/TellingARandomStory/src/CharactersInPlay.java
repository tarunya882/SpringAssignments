import edu.duke.FileResource;

import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> characters;
    private ArrayList<Integer> characterCounts;
    public CharactersInPlay(){
        characters=new ArrayList<>();
        characterCounts=new ArrayList<>();
    }
    public void update(String person){
        int idx=characters.indexOf(person);
        if(idx==-1){
            characters.add(person);
            characterCounts.add(1);
        }
        else{
            int freq=characterCounts.get(idx);
            characterCounts.set(idx,freq+1);
        }
    }
    public void findAllCharacters(){
        characters.clear();
        characterCounts.clear();
        FileResource fr=new FileResource("macbethSmall.txt");
        for(String str:fr.lines()){
            int idx=str.indexOf(".");
            String name="";
            if(idx!=-1){
                name=str.substring(0,idx);
                update(name);
            }
        }
    }
    public void charactersWithNumParts(int num1,int num2){
        for (int i=0;i<characterCounts.size();i++){
            if(characterCounts.get(i)>=num1&&characterCounts.get(i)<=num2)
                System.out.println(characters.get(i));
        }
    }
    public void tester(){
        findAllCharacters();
        int maxIdx=0;
        for (int i=0;i<characters.size();i++){
            if(characterCounts.get(i)>characterCounts.get(maxIdx))
                maxIdx=i;
        }
        System.out.println("Main Character & its counting parts is "+characters.get(maxIdx)+" "+characterCounts.get(maxIdx));
        charactersWithNumParts(1,3);
    }
    public static void main(String[] args){
        CharactersInPlay cp=new CharactersInPlay();
        cp.tester();
    }
}

