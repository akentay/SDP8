package vehiclerental;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RentalService service = new RentalService();
        Scanner sc = new Scanner(System.in);

        System.out.println("");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Show fleet");
            System.out.println("2 - Rent vehicle");
            System.out.println("3 - Return vehicle");
            System.out.println("4 - Maintenance info");
            System.out.println("0 - Exit");
            System.out.print("Choice: ");
            String c = sc.nextLine().trim();
            switch (c) {
                case "1": service.showFleet(); break;
                case "2": service.rentVehicleInteractive(); break;
                case "3": service.returnVehicleInteractive(); break;
                case "4": service.maintenanceInfoInteractive(); break;
                case "0": System.out.println("Bye"); return;
                default: System.out.println("Invalid"); break;
            }
        }
    }
}
