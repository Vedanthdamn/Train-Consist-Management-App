class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

public class UseCase15TrainConsistMgmt {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type) {
            this.type = type;
        }

        void assignCargo(String cargo) {
            try {
                if (type.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }

                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Cargo validation completed for " + type + " bogie\n");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" UC15 - Safe Cargo Assignment ");
        System.out.println("======================================\n");

        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        cylindrical.assignCargo("Petroleum");

        GoodsBogie rectangular = new GoodsBogie("Rectangular");
        rectangular.assignCargo("Petroleum");

        System.out.println("UC15 runtime handling completed...");
    }
}