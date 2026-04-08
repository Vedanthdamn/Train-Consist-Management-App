import java.util.*;

public class UseCase12TrainConsistMgmt {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("======================================\n");

        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));
        bogies.add(new GoodsBogie("Cylindrical", "Coal")); // ❌ violation

        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie b : bogies) {
            System.out.println(b.type + " -> " + b.cargo);
        }

        boolean isSafe =
                bogies.stream()
                        .allMatch(b ->
                                !b.type.equalsIgnoreCase("Cylindrical")
                                        || b.cargo.equalsIgnoreCase("Petroleum")
                        );

        System.out.println("\nSafety Compliance Status: " + isSafe);

        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
    }
}