import java.util.Arrays;

public class UseCase19TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" UC19 - Binary Search for Bogie ID ");
        System.out.println("======================================\n");

        // Sorted Bogie IDs (IMPORTANT)
        String[] bogieIds = {
                "BG101",
                "BG205",
                "BG309",
                "BG412",
                "BG550"
        };

        // Display bogies
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        // Search key
        String searchKey = "BG309";

        int low = 0;
        int high = bogieIds.length - 1;
        boolean found = false;

        // BINARY SEARCH
        while (low <= high) {

            int mid = (low + high) / 2;

            int comparison = searchKey.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                found = true;
                break;
            }
            else if (comparison < 0) {
                high = mid - 1; // search left
            }
            else {
                low = mid + 1; // search right
            }
        }

        // Result
        if (found) {
            System.out.println("\nBogie " + searchKey + " found in train consist.");
        } else {
            System.out.println("\nBogie " + searchKey + " NOT found in train consist.");
        }

        System.out.println("\nUC19 search completed...");
    }
}