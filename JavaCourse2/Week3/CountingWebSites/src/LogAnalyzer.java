


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
    public ArrayList<String> uniqueIPVisitsOnDay(String someday){
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
        return uniqueIp;
    }
    public int countUniqueIPsInRange(int low,int high){
        int cnt=0;
        for (LogEntry le:this.records){
            int statusCode=le.getStatusCode();
            if(statusCode>=low&&statusCode<=high)
                cnt++;
        }
        return cnt;
    }
    public HashMap<String,Integer> countVisitsPerIP(){
        HashMap<String,Integer>map=new HashMap<>();
        for (LogEntry le:records){
            String ip= le.getIpAddress();
            if(!map.containsKey(ip)){
                map.put(ip,1);
            }
            else {
                int cnt= map.get(ip);
                map.put(ip, cnt+1);
            }
        }
        return map;
    }
    public int mostNumberVisitsByIP(HashMap<String,Integer>counts){
        int max=0;
        for(String s:counts.keySet()){
            int currVisit=counts.get(s);
            if(currVisit>max)
                max=currVisit;
        }
        return max;
    }
    public ArrayList<String> iPsMostVisits(HashMap<String,Integer>counts){
        ArrayList<String>maxIps=new ArrayList<>();
        int max=mostNumberVisitsByIP(counts);
        for (String s:counts.keySet()){
            int currVisit=counts.get(s);
            if(currVisit==max) {
                maxIps.add(s);
            }
        }
        return maxIps;
    }
    public HashMap<String,ArrayList<String>> iPsForDays(){
        HashMap<String,ArrayList<String>>map=new HashMap<String,ArrayList<String>>();
        ArrayList<String>ips=new ArrayList<String>();
        for (LogEntry le:records){
            Date d=le.getAccessTime();
            String day=d.toString();
            ips=uniqueIPVisitsOnDay(day);
            map.put(day,ips);
        }
        return map;
    }
    public String dayWithMostIPVisits(HashMap<String,ArrayList<String>>dayIps){
        String maxIpDay="";
        int max=0;
        for(String s:dayIps.keySet()){
            if(dayIps.get(s).size()>max) {
                max = dayIps.get(s).size();
                maxIpDay=s;
            }
        }
        return maxIpDay;
    }
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>>ips,String day){
        ArrayList<String>maxIpsForDay=uniqueIPVisitsOnDay(day);
        HashMap<String,Integer>cnt=new HashMap<String,Integer>();
        for(String ip:maxIpsForDay){
            if(!cnt.containsKey(ip)){
                cnt.put(ip,1);
            }
            else {
                cnt.put(ip,cnt.get(ip)+1);
            }
        }
        return iPsMostVisits(cnt);
    }
}


