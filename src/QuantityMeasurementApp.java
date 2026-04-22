import java.util.Scanner;

public class QuantityMeasurementApp {

    // Step 1: Enum with conversion to base unit (FEET)
    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0);

        private final double toFeetFactor;

        LengthUnit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        public double toFeet(double value) {
            return value * toFeetFactor;
        }
    }

    // Step 2: Generic QuantityLength class (DRY)
    static class QuantityLength {
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }
            this.value = value;
            this.unit = unit;
        }

        // Convert to base unit (feet)
        private double toFeet() {
            return unit.toFeet(value);
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if (obj == null || getClass() != obj.getClass()) return false;

            QuantityLength other = (QuantityLength) obj;

            return Double.compare(this.toFeet(), other.toFeet()) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(toFeet());
        }
    }

    // Helper: parse unit from user
    private static LengthUnit parseUnit(String input) {
        if (input.equalsIgnoreCase("ft")) return LengthUnit.FEET;
        if (input.equalsIgnoreCase("in")) return LengthUnit.INCH;
        throw new IllegalArgumentException("Invalid unit. Use ft/in");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            // Input 1
            System.out.print("Enter first value: ");
            double v1 = scanner.nextDouble();

            System.out.print("Enter first unit (ft/in): ");
            LengthUnit u1 = parseUnit(scanner.next());

            // Input 2
            System.out.print("Enter second value: ");
            double v2 = scanner.nextDouble();

            System.out.print("Enter second unit (ft/in): ");
            LengthUnit u2 = parseUnit(scanner.next());

            // Create objects
            QuantityLength q1 = new QuantityLength(v1, u1);
            QuantityLength q2 = new QuantityLength(v2, u2);

            // Compare
            boolean result = q1.equals(q2);

            System.out.println("Result: Equal (" + result + ")");

        } catch (Exception e) {
            System.out.println("Invalid input! " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}