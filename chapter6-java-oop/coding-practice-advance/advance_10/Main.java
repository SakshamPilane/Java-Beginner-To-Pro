package advance_10;

public class Main {
    public static void main(String[] args) {
        Animal[] animalObj = new Animal[]{new Dog(), new Cat(), new Cow()};

        for (Animal animal : animalObj) {
            animal.sound();
        }
    }
}
