public class Mouse extends Rodent{
    public Mouse(){
        System.out.println("Mouse activities");
    }
    @Override
    void eat() {
        System.out.println("Mouse is easting");
    }

    @Override
    void jump() {
        System.out.println("Mouse is jumping");
    }

    @Override
    void makeSound() {
        System.out.println("Mouse is making sound");
    }

    @Override
    void run() {
        System.out.println("Mouse is running");
    }
}
