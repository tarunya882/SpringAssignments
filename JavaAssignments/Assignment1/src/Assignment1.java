import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        SearchFiles searchFiles= new SearchFiles();
        Scanner input=new Scanner(System.in);
        String pattern="";
        while(true) {
            System.out.println("Enter a pattern to search");
            pattern=input.nextLine();
            if(pattern.equalsIgnoreCase("Done")) {
                break;
            }
            searchFiles.printFiles(".xml");
       }
    }
}

