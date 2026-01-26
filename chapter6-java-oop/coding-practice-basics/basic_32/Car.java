package basic_32;

public class Car {
    String name;
    String brand;
    double average;
    String brakesType;
    Engine engineObj;

    public String getName() { return name; }

    public String getBrand() { return brand; }

    public double getAverage() { return average; }

    public String getBrakesType() { return brakesType; }

    public Engine getEngineObj() { return engineObj; }

    public void setName(String name) { this.name = name; }

    public void setBrand(String brand) { this.brand = brand; }

    public void setBrakesType(String brakesType) { this.brakesType = brakesType; }

    public void setAverage(double average) { this.average = average; }

    public void setEngineObj(Engine engineObj) { this.engineObj = engineObj; }
}
