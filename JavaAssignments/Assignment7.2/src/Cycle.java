public class Cycle {
    void noOfWheels(){
        System.out.println("No of wheels");
    }
    public static void main(String[] args){
        //upcasting
        Cycle firstCycle=new Unicycle();
        Cycle secondCycle=new Bicycle();
        Cycle thirdCycle=new Tricycle();

        //downcasting
        Unicycle first=(Unicycle) firstCycle;
        Bicycle second=(Bicycle) secondCycle;
        Tricycle third=(Tricycle) thirdCycle;
        first.balance();
        second.balance();
    }
}
