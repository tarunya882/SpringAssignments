package tharunya.assignment.data;

public class Data {
    private int firstVariable;
    private char secondVariable;
    public Data(){

    }
    public void printMemberVars(){
        System.out.println("Integer is "+firstVariable+" Character is "+secondVariable);
    }
    public void printLocalVars(){
        int firstVariable;
        char secondVariable;
        System.out.println("Integer is "+firstVariable+" Character is "+secondVariable);
        System.out.println("This cannot be done.");
        // Local variables should be initialized before printing
    }
}
