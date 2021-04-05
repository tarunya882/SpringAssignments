import java.io.File;
import java.util.Scanner;
import java.util.regex.*;

class SearchFiles {
    public void printFiles(String pattern) {
        String homeDirectory = "./";
        File[] listOfFiles = new File(homeDirectory).listFiles();
        printFilesPath(listOfFiles, pattern);
    }
    public void printFilesPath(File[] listOfFiles, String pattern) {
        if (listOfFiles == null) {
            return;
        }
        for (File file : listOfFiles) {
            if (file.isDirectory()) {
                File[] list = file.listFiles();
                printFilesPath(list, pattern);
            }
            else {
                Pattern givenPattern = Pattern.compile(pattern);
                Matcher matcher = givenPattern.matcher(file.getName());
                System.out.println(file.getAbsolutePath());
                if (matcher.matches()) {
                    System.out.println(file.getAbsolutePath());
                }
                else {
                    System.out.println("Not found");
                }
            }
        }
    }
}
