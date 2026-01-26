package basic_32;

public class CPU {
    String brand;
    int cores;
    double clockSpeed;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public void setClockSpeed(double clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public int getCores() {
        return cores;
    }

    public double getClockSpeed() {
        return clockSpeed;
    }
}