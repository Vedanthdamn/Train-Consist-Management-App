import java.util.*;

public class UseCase20TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" UC20 - Prevent Search on Empty Train ");
        System.out.println("======================================\n");

        // Empty bogie list (to trigger exception)
        List<String> bogieIds = new ArrayList<>();

        String searchKey = "BG309";

        try {
            boolean result = searchBogie(bogieIds, searchKey);

            if (result) {
                System.out.println("Bogie " + searchKey + " found.");
            } else {
                System.out.println("Bogie " + searchKey + " NOT found.");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC20 validation completed...");
    }

    // SEARCH METHOD WITH DEFENSIVE CHECK
    public static boolean searchBogie(List<String> bogieIds, String key) {

        // 🔴 FAIL-FAST CHECK
        if (bogieIds == null || bogieIds.isEmpty()) {
            throw new IllegalStateException("Train has no bogies. Search cannot be performed.");
        }

        // Binary Search (assuming sorted)
        int low = 0;
        int high = bogieIds.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int cmp = key.compareTo(bogieIds.get(mid));

            if (cmp == 0) return true;
            else if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }

        return false;
    }
}