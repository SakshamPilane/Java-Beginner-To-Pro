package advance_4;

public class Animal {
    protected int animalAge;

    public Animal(int animalAge) {
        this.animalAge = animalAge;
        System.out.println("Animal Created!");
        System.out.println("Age = " + animalAge);
    }
}