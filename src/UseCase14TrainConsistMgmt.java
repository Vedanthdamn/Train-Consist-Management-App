import java.util.*;

class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

public class UseCase14TrainConsistMgmt {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" UC14 - Handle Invalid Bogie Capacity ");
        System.out.println("======================================\n");

        try {
            Bogie validBogie = new Bogie("Sleeper", 72);
            System.out.println("Created Bogie: " + validBogie.name + " -> " + validBogie.capacity);

            Bogie invalidBogie = new Bogie("AC Chair", 0); // will throw exception

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}