

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
    }
    public static void main(String[] args)throws IOException
    {
        testLogAnalyzer();
    }
}
