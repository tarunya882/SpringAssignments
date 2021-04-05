
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.*;
import edu.duke.*;
public class Tester
{
    public static void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }

    public static void testLogAnalyzer() {
        // complete method
        LogAnalyzer la=new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
        la.countUniqueIPs();
        la.printAllHigherThanNum(200);
        la.uniqueIPVisitsOnDay("Sep 14");
        la.uniqueIPVisitsOnDay("Sep 30");
        la.countUniqueIPsInRange(200,299);
        System.out.println(la.countUniqueIPsInRange(300,399));
        la.readFile("weblog3-short_log");
        HashMap<String,Integer>ipAddrCnt=la.countVisitsPerIP();
        ArrayList<String>ipCount=la.iPsMostVisits(ipAddrCnt);
        for (int i=0;i<ipCount.size();i++){
            System.out.println("List of IP addresses that all have the maximum number of visits to this website"+ ipCount.get(i));
        }
        HashMap<String,ArrayList<String>>ipDay= la.iPsForDays();
        for (String ip:ipDay.keySet()){
            System.out.println(ip+" "+ipDay.get(ip));
        }
        System.out.println("Day with most ip visits "+la.dayWithMostIPVisits(ipDay));
        ArrayList<String>ipList=la.iPsWithMostVisitsOnDay(ipDay,"Sep 30");
      //  System.out.println(ipList);
        for (int i=0;i<ipList.size();i++){
            System.out.println("Ip list on day Sep 30 with max ip visits "+ipList.get(i));
        }
    }
    public static void main(String[] args)throws IOException
    {
        testLogAnalyzer();
    }
}