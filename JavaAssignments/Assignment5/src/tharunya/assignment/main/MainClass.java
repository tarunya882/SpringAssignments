package tharunya.assignment.main;

import tharunya.assignment.data.Data;
import tharunya.assignment.singleton.Singleton;

public class MainClass {
    public static void main(String[] args) {
        Data data=new Data();
        data.printMemberVars();
        data.printLocalVars();
        Singleton singleton=Singleton.initialize("Singleton");
        singleton.printString();
    }
}
