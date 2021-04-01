public class Gerbil extends Rodent{
    public Gerbil(){
        System.out.println("Gerbil activities");
    }
    @Override
    void eat() {
        System.out.println("Gerbil is easting");
    }

    @Override
    void jump() {
        System.out.println("Gerbil is jumping");
    }

    @Override
    void makeSound() {
        System.out.println("Gerbil is making sound");
    }

    @Override
    void run() {
        System.out.println("Gerbil is running");
    }
}
