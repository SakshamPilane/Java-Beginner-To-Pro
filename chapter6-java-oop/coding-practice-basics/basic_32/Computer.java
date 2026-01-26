package basic_32;

public class Computer {
    String name;
    String type;
    CPU cpu;

    public Computer(CPU cpu) {
        this.cpu = cpu;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CPU getCpu() {
        return cpu;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}