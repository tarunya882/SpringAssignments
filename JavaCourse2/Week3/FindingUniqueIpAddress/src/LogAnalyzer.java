

/**
 * Write a description of class LogAnalyzer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;
import org.apache.commons.csv.*;

public class LogAnalyzer
{
    private ArrayList<LogEntry> records;
    WebLogParser wp=new WebLogParser();
    public LogAnalyzer() {
        // complete constructor
        this.records=new ArrayList<>();
    }

    public void readFile(String filename) {
        // complete method
        FileResource fr=new FileResource(filename);
        for (String line: fr.lines()){
            //   WebLogParser wp=new WebLogParser();
            records.add(wp.parseEntry(line));
        }
    }

    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }
    public int countUniqueIPs(){
        ArrayList<String>ip=new ArrayList<>();
        for (LogEntry le:this.records){
            String ipAddr=le.getIpAddress();
            if(!ip.contains(ipAddr)) {
                ip.add(ipAddr);
            }
        }
        return ip.size();
    }
    public void printAllHigherThanNum(int num){
        for (LogEntry le:this.records){
            int statusCode=le.getStatusCode();
            if(statusCode>num)
                System.out.println(le);
        }
    }
    public void uniqueIPVisitsOnDay(String someday){
        ArrayList<String >uniqueIp=new ArrayList<>();
        for (LogEntry la:this.records){
            Date d=la.getAccessTime();
            String strDay=d.toString();
            String ip= la.getIpAddress();
            if((strDay.contains(someday))&&(!uniqueIp.contains(ip))){
                uniqueIp.add(ip);
            }
        }
        for (int i=0;i<uniqueIp.size();i++){
            System.out.println(uniqueIp.get(i));
        }
    }
    public int countUniqueIPsInRange(int low,int high){
        int counter=0;
        for (LogEntry le:this.records){
            int statusCode=le.getStatusCode();
            if(statusCode>=low&&statusCode<=high)
                counter++;
        }
        return counter;
    }
}
