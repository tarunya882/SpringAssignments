public class Tester {
    public static void main(String[] args) {
        Bike[] array=new Bike[10];
        //Result: Initialization messages arent printed as objects havent been created.

        Bike[] newArray=new Bike[]{new Bike("yamaha"),new Bike("Royal Enfield"),};
        //Initialization messages are printed here as objects are created
    }
}
