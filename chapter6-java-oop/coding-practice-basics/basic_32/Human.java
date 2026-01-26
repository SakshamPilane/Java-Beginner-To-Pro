package basic_32;

public class Human {
    String name;
    int age;
    Heart heart;

    public Human(Heart heart) {
        this.heart = heart;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Heart getHeart() {
        return heart;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}