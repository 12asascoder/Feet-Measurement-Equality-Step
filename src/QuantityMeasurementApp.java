import java.util.Scanner;

public class QuantityMeasurementApp {

    // Extended Enum (Base unit = FEET)
    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),                  // 1 yard = 3 feet
        CENTIMETER(0.0328084);      // 1 cm ≈ 0.0328084 feet

        private final double toFeetFactor;

        LengthUnit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        public double toFeet(double value) {
            return value * toFeetFactor;
        }
    }

    // Generic class (UNCHANGED from UC3)
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

    // Parse unit from user
    private static LengthUnit parseUnit(String input) {
        switch (input.toLowerCase()) {
            case "ft": return LengthUnit.FEET;
            case "in": return LengthUnit.INCH;
            case "yd": return LengthUnit.YARD;
            case "cm": return LengthUnit.CENTIMETER;
            default: throw new IllegalArgumentException("Invalid unit! Use ft/in/yd/cm");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            // Input 1
            System.out.print("Enter first value: ");
            double v1 = scanner.nextDouble();

            System.out.print("Enter first unit (ft/in/yd/cm): ");
            LengthUnit u1 = parseUnit(scanner.next());

            // Input 2
            System.out.print("Enter second value: ");
            double v2 = scanner.nextDouble();

            System.out.print("Enter second unit (ft/in/yd/cm): ");
            LengthUnit u2 = parseUnit(scanner.next());

            QuantityLength q1 = new QuantityLength(v1, u1);
            QuantityLength q2 = new QuantityLength(v2, u2);

            boolean result = q1.equals(q2);

            System.out.println("Result: Equal (" + result + ")");

        } catch (Exception e) {
            System.out.println("Invalid input! " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}