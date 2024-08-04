import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Automobile {
    // Private attributes
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    // Default constructor
    public Automobile() {
        this.make = "";
        this.model = "";
        this.color = "";
        this.year = 0;
        this.mileage = 0;
    }

    // Parameterized constructor
    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    // Add a new vehicle method
    public String addVehicle(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "Vehicle added successfully.";
        } catch (Exception e) {
            return "Failed to add vehicle: " + e.getMessage();
        }
    }

    // List vehicle information (return string array)
    public String[] listVehicleInformation() {
        try {
            return new String[]{
                    "Make: " + this.make,
                    "Model: " + this.model,
                    "Color: " + this.color,
                    "Year: " + this.year,
                    "Mileage: " + this.mileage
            };
        } catch (Exception e) {
            return new String[]{"Error retrieving vehicle information: " + e.getMessage()};
        }
    }

    // Remove a vehicle method
    public String removeVehicle() {
        try {
            this.make = "";
            this.model = "";
            this.color = "";
            this.year = 0;
            this.mileage = 0;
            return "Vehicle removed successfully.";
        } catch (Exception e) {
            return "Failed to remove vehicle: " + e.getMessage();
        }
    }

    // Update vehicle attributes method
    public String updateVehicleAttributes(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "Vehicle attributes updated successfully.";
        } catch (Exception e) {
            return "Failed to update vehicle attributes: " + e.getMessage();
        }
    }
}

public class AutomobileInventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Automobile car = new Automobile("Toyota", "Corolla", "Blue", 2018, 30000);

        try {
            // List vehicle information
            System.out.println("Listing vehicle information:");
            String[] vehicleInfo = car.listVehicleInformation();
            for (String info : vehicleInfo) {
                System.out.println(info);
            }

            // Remove vehicle
            System.out.println("\n" + car.removeVehicle());

            // Add a new vehicle
            System.out.println("\nAdding a new vehicle...");
            System.out.println(car.addVehicle("Honda", "Civic", "Red", 2021, 10000));

            // List vehicle information again
            System.out.println("\nListing updated vehicle information:");
            vehicleInfo = car.listVehicleInformation();
            for (String info : vehicleInfo) {
                System.out.println(info);
            }

            // Update vehicle attributes
            System.out.println("\nUpdating vehicle attributes...");
            System.out.println(car.updateVehicleAttributes("Ford", "Mustang", "Yellow", 2022, 5000));

            // List vehicle information again
            System.out.println("\nListing updated vehicle information:");
            vehicleInfo = car.listVehicleInformation();
            for (String info : vehicleInfo) {
                System.out.println(info);
            }

            // Ask user if they want to print the information to a file
            System.out.print("\nDo you want to print the information to a file? (Y/N): ");
            String response = scanner.nextLine().trim();

            if (response.equalsIgnoreCase("Y")) {
                try (FileWriter writer = new FileWriter("C:\\Temp\\Autos.txt")) {
                    for (String info : vehicleInfo) {
                        writer.write(info + "\n");
                    }
                    System.out.println("Vehicle information printed to C:\\Temp\\Autos.txt.");
                } catch (IOException e) {
                    System.out.println("Failed to write to file: " + e.getMessage());
                }
            } else {
                System.out.println("File will not be printed.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
