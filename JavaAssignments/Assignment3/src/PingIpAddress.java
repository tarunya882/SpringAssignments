import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PingIpAddress {
    static double findMedian(ArrayList<Double> a) {
        // First we sort the array
        Collections.sort(a);
        int n = a.size();
        // check for even case
        if (n % 2 != 0)
            return (double) a.get(n / 2);
        return (double) (a.get((n - 1) / 2) + a.get(n / 2)) / 2.0;
    }
    public static void main(String[] args) {
        String inputHost;
        int countOfHops;
        Scanner scanner = new Scanner(System.in);
        inputHost = scanner.nextLine();
        countOfHops = scanner.nextInt();
        ArrayList<Double> timeTaken = new ArrayList<>();
        try {
            Process process = Runtime.getRuntime().exec("ping -c" + countOfHops + " " + inputHost);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String s = "";
            int count=0;
            // reading output stream of the command
            while ((s = inputStream.readLine()) != null) {
                int i = s.indexOf("time");
                count++;
                System.out.println(count+" "+s);
                if (i != -1 && count<=countOfHops+1)
                    timeTaken.add(Double.parseDouble(s.substring(i + 5).split(" ")[0]));
            }
            //To keep Thread safe
            process.waitFor();
            process.destroy();
            //for to see the list of times
            for (Double i : timeTaken) {
                System.out.println(i);
            }
            System.out.println("Median of the times taken is " + findMedian(timeTaken));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}