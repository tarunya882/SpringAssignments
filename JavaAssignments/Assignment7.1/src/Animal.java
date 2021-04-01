public class Animal {
    public static void main(String[] args){
        Rodent r[]={new Mouse(),
                new Gerbil(),
                new Hamster()};
        for (Rodent i:r){
            i.eat();
            i.run();
            i.makeSound();
            i.jump();
        }
    }
}
