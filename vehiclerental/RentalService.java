package vehiclerental;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalService {
    private final List<Vehicle> fleet = new ArrayList<>();

    public RentalService() {
        // sample initial fleet
        fleet.add(new Car("CAR-001", "Toyota Corolla", 5));
        fleet.add(new Car("CAR-002", "Honda Civic", 5));
        fleet.add(new Bike("BIKE-01", "City Bike", false));
        fleet.add(new Bike("BIKE-02", "E-Bike Pro", true));
        fleet.add(new Van("VAN-1", "Iveco Cargo", 8.0));
    }

    public void showFleet() {
        System.out.println("Available fleet:");
        for (Vehicle v : fleet) {
            System.out.println(" - " + v.getId() + " : " + v.getMakeModel() + (v.isRented() ? " [RENTED]" : " [FREE]"));
        }
    }

    public Vehicle findById(String id) {
        for (Vehicle v : fleet) if (v.getId().equalsIgnoreCase(id)) return v;
        return null;
    }

    public void rentVehicleInteractive() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter vehicle id to rent:");
        String id = sc.nextLine().trim();
        Vehicle v = findById(id);
        if (v == null) {
            System.out.println("Vehicle not found.");
            return;
        }
        if (v.isRented()) {
            System.out.println("Sorry, vehicle already rented.");
            return;
        }

        System.out.print("Your name: ");
        String renter = sc.nextLine().trim();

        System.out.print("Pricing type (hourly/daily): ");
        String pricing = sc.nextLine().trim().toLowerCase();
        if (!pricing.equals("hourly") && !pricing.equals("daily")) {
            System.out.println("Invalid pricing; defaulting to hourly.");
            pricing = "hourly";
        }

        System.out.print("Duration (int): ");
        int duration;
        try { duration = Integer.parseInt(sc.nextLine().trim()); }
        catch (NumberFormatException e) { System.out.println("Invalid number, aborting."); return; }

        RentalCostVisitor costVisitor = new RentalCostVisitor(duration, pricing);
        double cost = v.accept(costVisitor);
        System.out.printf("Total rental cost: %.2f%n", cost);

        RegistrationVisitor regVisitor = new RegistrationVisitor(renter);
        String contract = v.accept(regVisitor);
        System.out.println("Generated contract: " + contract);

        v.setRented(true);
        System.out.println("Vehicle " + v.getId() + " is now marked as RENTED.");
    }

    public void returnVehicleInteractive() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter vehicle id to return: ");
        String id = sc.nextLine().trim();
        Vehicle v = findById(id);
        if (v == null) { System.out.println("Not found."); return; }
        if (!v.isRented()) { System.out.println("Vehicle already free."); return; }
        v.setRented(false);
        System.out.println("Vehicle returned. Thank you!");
    }

    public void maintenanceInfoInteractive() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter vehicle id for maintenance info: ");
        String id = sc.nextLine().trim();
        Vehicle v = findById(id);
        if (v == null) { System.out.println("Not found."); return; }
        MaintenanceVisitor mv = new MaintenanceVisitor();
        String guide = v.accept(mv);
        System.out.println(guide);
    }
}
