public class UseCase18TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" UC18 - Linear Search for Bogie ID ");
        System.out.println("======================================\n");

        // Array of Bogie IDs
        String[] bogieIds = {
                "BG101",
                "BG205",
                "BG309",
                "BG412",
                "BG550"
        };

        // Display all bogies
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        // Search key (as per output)
        String searchKey = "BG309";

        boolean found = false;

        // LINEAR SEARCH
        for (String id : bogieIds) {
            if (id.equals(searchKey)) {
                found = true;
                break; // early termination
            }
        }

        // Result
        if (found) {
            System.out.println("\nBogie " + searchKey + " found in train consist.");
        } else {
            System.out.println("\nBogie " + searchKey + " NOT found in train consist.");
        }

        System.out.println("\nUC18 search completed...");
    }
}