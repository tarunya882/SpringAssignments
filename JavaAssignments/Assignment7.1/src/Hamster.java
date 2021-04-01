public class Hamster extends Rodent{
    public Hamster(){
        System.out.println("Hamster activities");
    }
    @Override
    void eat() {
        System.out.println("Hamster is easting");
    }

    @Override
    void jump() {
        System.out.println("Hamster is jumping");
    }

    @Override
    void makeSound() {
        System.out.println("Hamster is making sound");
    }

    @Override
    void run() {
        System.out.println("Hamster is running");
    }
}
