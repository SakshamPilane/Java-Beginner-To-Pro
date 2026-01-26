package basic_32;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("========== COMPOSITION DEMONSTRATION ==========");

        car(input);
        human(input);
        computer(input);

        System.out.println("\n========== PROGRAM ENDED ==========");
        input.close();
    }

    // ---------------- CAR ----------------
    public static void car(Scanner input) {

        System.out.println("\n----- CAR DETAILS -----");

        Engine engineObj = new Engine();
        System.out.print("Enter engine horse power: ");
        engineObj.setHorsePower(input.nextInt());
        System.out.print("Enter engine torque: ");
        engineObj.setTorque(input.nextDouble());
        System.out.print("Enter engine speed: ");
        engineObj.setSpeed(input.nextDouble());
        input.nextLine();
        System.out.print("Enter engine fuel type: ");
        engineObj.setFuelType(input.nextLine());

        Car carObj = new Car();
        carObj.setEngineObj(engineObj);

        System.out.print("Enter car name: ");
        carObj.setName(input.nextLine());
        System.out.print("Enter car brand: ");
        carObj.setBrand(input.nextLine());
        System.out.print("Enter car average: ");
        carObj.setAverage(input.nextDouble());
        input.nextLine();
        System.out.print("Enter car brake types: ");
        carObj.setBrakesType(input.nextLine());

        System.out.println("\n--- CAR OUTPUT ---");
        System.out.println("Name        : " + carObj.getName());
        System.out.println("Brand       : " + carObj.getBrand());
        System.out.println("Average     : " + carObj.getAverage());
        System.out.println("Brakes Type : " + carObj.getBrakesType());
        System.out.println("Horse Power : " + carObj.getEngineObj().getHorsePower());
        System.out.println("Torque      : " + carObj.getEngineObj().getTorque());
        System.out.println("Speed       : " + carObj.getEngineObj().getSpeed());
        System.out.println("Fuel Type   : " + carObj.getEngineObj().getFuelType());
    }

    // ---------------- HUMAN ----------------
    public static void human(Scanner input) {

        System.out.println("\n----- HUMAN DETAILS -----");

        Heart heartObj = new Heart();
        System.out.print("Enter heart rate: ");
        heartObj.setHeartRate(input.nextInt());
        input.nextLine();
        System.out.print("Enter blood group: ");
        heartObj.setBloodGroup(input.nextLine());

        Human humanObj = new Human(heartObj);
        System.out.print("Enter human name: ");
        humanObj.setName(input.nextLine());
        System.out.print("Enter human age: ");
        humanObj.setAge(input.nextInt());

        System.out.println("\n--- HUMAN OUTPUT ---");
        System.out.println("Name        : " + humanObj.getName());
        System.out.println("Age         : " + humanObj.getAge());
        System.out.println("Heart Rate  : " + humanObj.getHeart().getHeartRate());
        System.out.println("Blood Group : " + humanObj.getHeart().getBloodGroup());
    }

    // ---------------- COMPUTER ----------------
    public static void computer(Scanner input) {

        System.out.println("\n----- COMPUTER DETAILS -----");

        CPU cpuObj = new CPU();
        System.out.print("Enter CPU brand: ");
        cpuObj.setBrand(input.nextLine());
        System.out.print("Enter number of cores: ");
        cpuObj.setCores(input.nextInt());
        System.out.print("Enter clock speed (GHz): ");
        cpuObj.setClockSpeed(input.nextDouble());
        input.nextLine();

        Computer computerObj = new Computer(cpuObj);
        System.out.print("Enter computer name: ");
        computerObj.setName(input.nextLine());
        System.out.print("Enter computer type: ");
        computerObj.setType(input.nextLine());

        System.out.println("\n--- COMPUTER OUTPUT ---");
        System.out.println("Name        : " + computerObj.getName());
        System.out.println("Type        : " + computerObj.getType());
        System.out.println("CPU Brand   : " + computerObj.getCpu().getBrand());
        System.out.println("CPU Cores   : " + computerObj.getCpu().getCores());
        System.out.println("CPU Speed   : " + computerObj.getCpu().getClockSpeed() + " GHz");
    }
}