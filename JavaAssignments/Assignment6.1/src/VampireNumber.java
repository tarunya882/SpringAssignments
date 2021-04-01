import java.util.ArrayList;
import java.util.Arrays;

public class VampireNumber {
    public void printVampireNumbers(int count){
        ArrayList<Integer>vampireList=new ArrayList<Integer>();
        String[] str1, str2;
        int product, currentCount = 0;
        for(int i = 10; i < 1000; i++) {
            for(int j = 10; j < 1000; j++) {
                if(currentCount >= count)
                    return;
                product = i * j;
                int numberLength=String.valueOf(product).length();
                int lengthOfi=String.valueOf(i).length();
                int lengthOfj=String.valueOf(j).length();
                if(numberLength%2!=0&&(lengthOfi!=lengthOfj)){
                    continue;
                }
                str1 = String.valueOf(product).split("");
                str2 = (String.valueOf(i) + String.valueOf(j)).split("");
                Arrays.sort(str1);
                Arrays.sort(str2);
                if(Arrays.equals(str1, str2)) {
                    if(!vampireList.contains(product)) {
                        vampireList.add(product);
                        currentCount++;
                        System.out.println(" "+ currentCount + ". vampire number: " +product);
                    }
                }
            }
        }
    }
}
