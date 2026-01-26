package basic_32;

public class Engine {
    int horsePower;
    double torque;
    double speed;
    String fuelType;

    public void setHorsePower(int horsePower) { this.horsePower = horsePower; }

    public void setTorque(double torque) { this.torque = torque; }

    public void setSpeed(double speed) { this.speed = speed; }

    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    public int getHorsePower() { return horsePower; }

    public double getTorque() { return torque; }

    public String getFuelType() { return fuelType; }

    public double getSpeed() { return speed; }
}
