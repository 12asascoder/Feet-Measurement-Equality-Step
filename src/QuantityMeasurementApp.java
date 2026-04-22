import java.util.Scanner;

public class QuantityMeasurementApp {

    // Feet class
    static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Inches class
    static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Static method for Feet comparison
    public static boolean compareFeet(double v1, double v2) {
        Feet f1 = new Feet(v1);
        Feet f2 = new Feet(v2);
        return f1.equals(f2);
    }

    // Static method for Inches comparison
    public static boolean compareInches(double v1, double v2) {
        Inches i1 = new Inches(v1);
        Inches i2 = new Inches(v2);
        return i1.equals(i2);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter unit (ft/in): ");
            String unit = scanner.next().toLowerCase();

            System.out.print("Enter first value: ");
            double value1 = scanner.nextDouble();

            System.out.print("Enter second value: ");
            double value2 = scanner.nextDouble();

            boolean result;

            if (unit.equals("ft")) {
                result = compareFeet(value1, value2);
                System.out.println("Comparing Feet...");
            } else if (unit.equals("in")) {
                result = compareInches(value1, value2);
                System.out.println("Comparing Inches...");
            } else {
                System.out.println("Invalid unit! Use 'ft' or 'in'");
                return;
            }

            System.out.println("Result: Equal (" + result + ")");

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter numeric values.");
        } finally {
            scanner.close();
        }
    }
}